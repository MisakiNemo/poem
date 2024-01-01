package com.example.poem.service;

import com.example.poem.DTO.PoemDTO;
import com.example.poem.DTO.PoemGameDTO;
import com.example.poem.constant.Constant;
import com.example.poem.entity.Poem;
import com.example.poem.entity.PoemContent;
import com.example.poem.entity.PoemInfo;
import com.example.poem.mapper.PoemContentMapper;
import com.example.poem.mapper.PoemInfoMapper;
import com.example.poem.mapper.PoemMapper;
import com.example.poem.utils.PoemUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class poemServiceImp implements poemService {
    @Autowired
    private PoemInfoMapper poemInfoMapper;
    @Autowired
    private PoemContentMapper poemContentMapper;
    @Autowired
    private PoemMapper poemMapper;

    @Override
    public PoemDTO getRandomPoem() {
        Integer id = (int) (Constant.PoemNumber * Math.random());
        return getPoemById(id);
    }

    @Override
    public PoemDTO getPoemById(Integer id) {
        PoemInfo poemInfo = poemInfoMapper.selectById(id);
        List<String> content = poemContentMapper.selectContentByPoemId(id);
        return PoemDTO.builder()
                .id(poemInfo.getId())
                .title(poemInfo.getTitle())
                .author(poemInfo.getAuthor())
                .dynasty(poemInfo.getDynasty())
                .content(content)
                .build();
    }



    @Override
    public List<PoemDTO> searchPoem(int pageNum, int pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<Poem> poemList = poemMapper.selectPoemByKeyword(keyword);
        List<PoemDTO> poemDTOList = new ArrayList<>();
        for (Poem poem : poemList) {
            poemDTOList.add(PoemDTO.builder()
                    .id(poem.getId())
                    .title(poem.getTitle())
                    .author(poem.getAuthor())
                    .dynasty(poem.getDynasty())
                    .content(PoemUtils.getSentences(poem.getContent()))
                    .build());
        }
        return poemDTOList;
    }


    //诗词接龙游戏
    @Override
    public PoemGameDTO getSolitaireGame(String sentence) {
        String lastWord = PoemUtils.getLastWord(sentence);
        String firstPinyin = PoemUtils.getOnePinyin(lastWord);
        List<PoemContent> poemContentList = poemContentMapper.selectByFirstPinyin(firstPinyin);
        int id = (int) (Math.random() * poemContentList.size());
        PoemContent poemContent = poemContentList.get(id);
        return PoemGameDTO.builder()
                .id(poemContent.getPoemId())
                .content(poemContent.getLineContent())
                .build();
    }

    @Override
    public PoemGameDTO getFlyFlowerGame(String word) {
        List<PoemContent> poemContentList = poemContentMapper.selectByWord(word);
        int id = (int) (Math.random() * poemContentList.size());
        PoemContent poemContent = poemContentList.get(id);
        return PoemGameDTO.builder()
                .id(poemContent.getPoemId())
                .content(poemContent.getLineContent())
                .build();
    }


}








