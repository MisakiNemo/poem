package com.example.poem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.poem.entity.PoemInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoemInfoMapper extends BaseMapper<PoemInfo> {
    
    //根据诗的题目、作者、诗句查询诗词id
    public List<Integer> selectPoemIdByKeyword(String keyword);



}
