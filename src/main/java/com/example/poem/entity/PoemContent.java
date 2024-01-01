package com.example.poem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("poems_content")
public class PoemContent {

    @TableId
    private Integer id;

    @TableField("poem_id")
    private Integer poemId;


    private String lineContent;


    private Integer lineNumber;


    private String lineFirstPinyin;


    private String lineLastPinyin;


}
