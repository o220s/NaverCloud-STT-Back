package ssg.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import ssg.com.a.naver.NaverCloud;

@RestController
public class NaverCloudController {
   
   // STT
   // 음성인식(파일) wav -> String
   @PostMapping("fileupload")
   public String fileupload(@RequestParam("uploadfile")MultipartFile uploadfile,
                     HttpServletRequest request) {
      System.out.println("NaverColudController fileupload " + new Date());
      
      String uploadPath = request.getServletContext().getRealPath("/upload");
      
      // 파일명을 취득
      String filename = uploadfile.getOriginalFilename();
      String filepath = uploadPath + File.separator + filename;
      
      System.out.println(filepath);
      
      try {
         BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
         os.write(uploadfile.getBytes());
         os.close();
      } catch (Exception e) {
         return "file upload fail";
      }
      // Naver cloud
      String response = NaverCloud.SttProc(filepath);
      
      return response;
   }

}
