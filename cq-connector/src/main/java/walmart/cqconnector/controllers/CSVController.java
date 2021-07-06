package walmart.cqconnector.controllers;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import walmart.cqconnector.models.CSVObject;
import walmart.cqconnector.utils.CSVHelper;

import java.util.List;

@Controller
@CrossOrigin(origins = "*" )
@RequestMapping("/upload")
public class CSVController {
    @PostMapping( "/CSV" )
    public ResponseEntity<?> csvUpload(
            @RequestParam( "file" ) MultipartFile file, @RequestParam( "eligibility" ) String eligibility ){

        int fileId;
        try {
            CSVHelper csvHelper = new CSVHelper();
            fileId = csvHelper.saveCSVFile((List<CSVObject>)csvHelper.extractData(file, CSVObject.class));
        }
        catch (Exception ex){
            return new ResponseEntity("Upload Failed", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity("Uploaded Successfully with file id = " + fileId, HttpStatus.OK);
    }
}
