package com.example.poem.service;

import com.example.poem.DTO.PoemDTO;
import com.example.poem.DTO.PoemGameDTO;

import java.util.List;

public interface poemService {

  PoemDTO getRandomPoem();

  PoemDTO getPoemById(Integer id);



  List<PoemDTO> searchPoem(int pageNum, int pageSize, String keyword);


  //诗词接龙游戏
  PoemGameDTO getSolitaireGame(String sentence);

  PoemGameDTO    getFlyFlowerGame(String word);
}
