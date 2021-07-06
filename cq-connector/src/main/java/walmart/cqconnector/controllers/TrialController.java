package walmart.cqconnector.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import walmart.cqconnector.models.CSVObject;
import walmart.cqconnector.models.TrialModel;
import walmart.cqconnector.repositories.TrialRepo;
import walmart.cqconnector.services.TrialService;
import walmart.cqconnector.utils.CSVHelper;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/upload")
public class TrialController {

    @Autowired
    TrialService trialService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertDB( @RequestBody TrialModel data) {
        boolean response = trialService.savetoDb(data);
        if(response) return ResponseEntity.ok("Successful");
        else return ResponseEntity.ok("Didn't get the result");
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchDb( @RequestParam Integer id) {
        TrialModel response = trialService.findinDb(id);
        if(response!=null) return ResponseEntity.ok(response);
        else return ResponseEntity.ok("Didn't find in DB");
    }

    @PostMapping("/batchcall")
    public ResponseEntity<?> batchClass(@RequestBody List<TrialModel> data){
        boolean result = trialService.sendBatch(data);
        if(result) return ResponseEntity.ok("Batch process successful");
        else return ResponseEntity.ok("Batch didn't upload");
    }


    @PostMapping( "/csv" )
    public ResponseEntity<?> csvUpload(
            @RequestParam( "file" ) MultipartFile file){
        boolean result;
        int fileId;
        try {
            CSVHelper csvHelper = new CSVHelper();
            List<TrialModel> data = (List<TrialModel>)csvHelper.extractData(file,TrialModel.class);
            result = trialService.sendBatch(data);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity("Upload Failed", HttpStatus.EXPECTATION_FAILED);
        }
        if(result) return ResponseEntity.ok("Batch process successful");
        else return ResponseEntity.ok("Batch didn't upload");
    }



}


