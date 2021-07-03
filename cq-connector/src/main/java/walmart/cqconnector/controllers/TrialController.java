package walmart.cqconnector.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import walmart.cqconnector.models.TrialModel;
import walmart.cqconnector.repositories.TrialRepo;
import walmart.cqconnector.services.TrialService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/upload")
public class TrialController {

    @Autowired
    TrialService trialService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertDB( @RequestBody TrialModel data) {
        //issue: I get only Multipart file ?
        //Have to create List?
        boolean response = trialService.savetoDb(data);
        if(response) return ResponseEntity.ok("Successful");
        else return ResponseEntity.ok("Didn't get the result");
    }
}
