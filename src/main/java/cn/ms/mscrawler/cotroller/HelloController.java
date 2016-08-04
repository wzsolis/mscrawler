package cn.ms.mscrawler.cotroller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by weizheng on 2016/8/2.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String fileUp(String fileName, MultipartHttpServletRequest file){
        MultipartFile multipartFile = file.getFile("file");
//        Map<String, MultipartFile> fileMap = file.getFileMap();
//        MultipartFile multipartFile = file.getFile("file");
        String name = multipartFile.getName();
        String originalFilename = multipartFile.getOriginalFilename();
        boolean empty = multipartFile.isEmpty();

        try(InputStream in =  multipartFile.getInputStream();
            FileOutputStream out  = new FileOutputStream("D:\\elasticsearch-2.3.2.zip")){
//            new FileOutputStream()
            IOUtils.copy(in,out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "aaa";
    }
}
