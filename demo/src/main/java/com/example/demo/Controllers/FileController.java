package com.example.demo.Controllers;
import com.example.demo.Controllers.CSVbeans;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Controllers.CSVbeans;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.io.*;
import java.util.List;

@Controller
@CrossOrigin(origins = "*" )
@RequestMapping ("/upload")
public class FileController {
    @Autowired
    private HttpServletRequest request;

    @PostMapping ("/CSV")
    public ResponseEntity<ResponseMsg> csvUpload(@RequestParam("file") MultipartFile file) throws IOException {

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<CSVObject> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVObject.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of users
            List<CSVObject> data = csvToBean.parse();
            for(int i =0; i< data.size(); i++){
                System.out.println(data.get(i));
            }
        }catch (Exception e){
            System.out.println("I m here, inside exception");
        }

        System.out.println("I m here, POST successful");
        String message = "";
        try {
            String str= new CSVbeans(file.getOriginalFilename()).getId();
            message = "File status Updated for: "+ file.getOriginalFilename() + str;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMsg(message));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //file save to local directory

        try {
            String dir = "C:/Users/HP/Desktop";
            String filePath = request.getServletContext().getRealPath(dir);
            System.out.println("Transferring downloaded files to Desktop");
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping ("/files")
    public ResponseEntity<String> getFile(){
        System.out.println("I am here, GET successful");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
