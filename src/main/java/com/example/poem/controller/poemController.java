package com.example.poem.controller;

import com.example.poem.DTO.PoemDTO;
import com.example.poem.DTO.PoemGameDTO;
import com.example.poem.DTO.SearchDTO;
import com.example.poem.service.poemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poem")
public class poemController {
    @Autowired
    private poemService poemService;


    @GetMapping("/recommend")
    public PoemDTO getRandomPoem() {
        return poemService.getRandomPoem();
    }


    @PostMapping("/search")
    public List<PoemDTO> searchPoem(@RequestBody SearchDTO searchDTO) {
        System.out.println("searchPoem");
        System.out.println(searchDTO.getKeyword());
        System.out.println(searchDTO.getPageNum());
        System.out.println(searchDTO.getPageSize());
        return poemService.searchPoem(searchDTO.getPageNum(), searchDTO.getPageSize(), searchDTO.getKeyword());
    }





    @GetMapping("/solitaire")
    public PoemGameDTO getSolitaireGame(@RequestParam String sentence) {
        return poemService.getSolitaireGame(sentence);
    }


    @GetMapping("/flyFlower")
    public PoemGameDTO getFlyFlowerGame(@RequestParam String word) {
        return poemService.getFlyFlowerGame(word);
    }






}
