package com.example.poem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.poem.entity.PoemContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoemContentMapper extends BaseMapper<PoemContent> {


    //根据关键字查询诗词内容
    public PoemContent selectPoemContentByKeyword(String keyword);




    public List<String> selectContentByPoemId(Integer poemId);


    List<PoemContent> selectByFirstPinyin(String firstPinyin);

    List<PoemContent> selectByWord(String word);
}
