package com.example.demo.Controllers;
//
//import jdk.internal.instrumentation.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;

//@RestController
public class FileSave {

//    @Autowired
//    private HttpServletRequest request;
//
//    public class handleFileUpload(MultipartFile file) {
//        if (!file.isEmpty()) {
//            try {
//                String uploadsDir = "/uploads/";
//                String realPathtoUploads = request.getServletContext().getRealPath(uploadsDir);
//                if (!new File(realPathtoUploads).exists()) {
//                    new File(realPathtoUploads).mkdir();
//                }
//
//                Logger log;
//                log.info("realPathtoUploads = {}", realPathtoUploads);
//
//
//                String orgName = file.getOriginalFilename();
//                String filePath = realPathtoUploads + orgName;
//                File dest = new File(filePath);
//            }
//        }
//    }
}