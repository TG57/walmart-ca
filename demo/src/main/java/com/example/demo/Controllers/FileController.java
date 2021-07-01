package com.example.demo.Controllers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Controller
@CrossOrigin( origins = "*" )
@RequestMapping( "/upload" )
public class FileController {
    @Autowired private HttpServletRequest request;

    @PostMapping( "/CSV" )
    public ResponseEntity<ResponseMsg> csvUpload(
            @RequestParam( "file" ) MultipartFile file, @RequestParam( "eligibility" ) String eligibility )
    throws IOException {

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<CSVObject> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVObject.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of users
            List<CSVObject> data = csvToBean.parse(); for(int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
            }
        }
        catch (Exception e) {
            System.out.println("I m here, inside exception");
        }


        try {
            System.out.println(" Got eligibility " + eligibility);
            File fileZ = new File(
                    "src/main/resources/targetFile.csv");

            try (OutputStream os = new FileOutputStream(fileZ)) {
                os.write(file.getBytes());
            } String uploadsDir = "/uploads/"; String realPathtoUploads = request.getServletContext().getRealPath(
                    uploadsDir);

            System.out.println(realPathtoUploads); String filePath = request.getServletContext().getRealPath("/");
            file.transferTo(new File(filePath)); System.out.println("Transferring downloaded files to " + filePath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("I m here, POST successful"); String message = ""; try {
            String str = new CSVbeans(file.getOriginalFilename()).getId();
            message = "File status Updated for: " + file.getOriginalFilename() + str; return ResponseEntity.status(
                    HttpStatus.OK).body(new ResponseMsg(message));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //file save to local directory
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping( "/files" )
    public ResponseEntity<String> getFile() {
        System.out.println("I am here, GET successful"); return new ResponseEntity<>(HttpStatus.OK);
    }
}
