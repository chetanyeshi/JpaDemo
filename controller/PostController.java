package com.codekul.jpaDemo6818.controller;

import com.codekul.jpaDemo6818.domain.Post1;
import com.codekul.jpaDemo6818.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepo postRepo;

    @RequestMapping(value = "/savePost")
    public String postData(@RequestBody Post1 post) {
        postRepo.save(post);
        return "Save dat successFuly";
    }

    @RequestMapping("/findAll")
    public List<Post1> findall() {

        List<Post1> post1 = postRepo.findAll(new Sort(Sort.DEFAULT_DIRECTION, "name"));
        return post1;
    }

    @GetMapping("/findByPost/{id}/{name}")
    public List<Post1> find(@PathVariable Integer id,
                            @PathVariable String name) {
        List<Post1> post1 = postRepo.findPost1ByIdOrName(id, name);
        return post1;
    }

    /* @GetMapping("/findByLength")
     public List<Post1> findByLength (){
         List<Post1> post1 = postRepo.findAll(JpaSort.unsafe("LENGTH(name)"));
         return post1;
     }
   @RequestMapping("/Pegination")
     public Page<Post1>pagination(){
       Page<Post1>post1s=postRepo.findAllPost1WithPagination();
   }
 */
    @GetMapping("/findByIdJPQL/{id}")
    public Post1 findbyIDPara(@PathVariable Integer id) {
        Post1 post1 = postRepo.findPost1ById(id);
        return post1;
    }

    @GetMapping("findById/{id}")
    public Post1 findById(@PathVariable Integer id) {
        Post1 post12 = postRepo.findByPost1Id(id);
        return post12;
    }

    @RequestMapping(value = "/uploadFile")
    public String upload(@RequestParam MultipartFile multipartFile) {

//source
        String fileName = multipartFile.getOriginalFilename();
//destination
        File f = new File("/home/chetan/images", fileName);

        try {
//transfered
            multipartFile.transferTo(f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileName;
    }
}
