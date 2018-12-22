`package com.codekul.jpaDemo6818.controller;

import com.codekul.jpaDemo6818.domain.SaveFileandData;
import com.codekul.jpaDemo6818.repository.SaveDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class SaveDataController {
    @Autowired
    SaveDataRepo saveDataRepo;
@RequestMapping("/paramSave")
    public String savedata(@RequestParam Integer id,
                           @RequestParam String name,
                           @RequestParam Integer marks,
                           @RequestParam String city,
                           @RequestParam MultipartFile multipartFile){
    SaveFileandData saveFileandData=new SaveFileandData();
    saveFileandData.setId(id);
    saveFileandData.setName(name);
    saveFileandData.setMarks(marks);
    saveFileandData.setCity(city);

    String fileName=multipartFile.getOriginalFilename();
//destination
    File f=new File("/home/chetan/images",fileName);
     saveFileandData.setImagePath(fileName);
    try{
//transfered
        multipartFile.transferTo(f);
    }catch (Exception e){
        e.printStackTrace();
    }
    saveDataRepo.save(saveFileandData);
    return "Save Data Successful";

}

}
