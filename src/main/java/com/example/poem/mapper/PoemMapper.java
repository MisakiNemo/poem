package com.example.poem.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.poem.entity.Poem;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface PoemMapper extends BaseMapper<Poem> {


     List<Poem> selectPoemByKeyword(String keyword);



}
