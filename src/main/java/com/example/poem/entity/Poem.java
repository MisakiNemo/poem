package com.example.poem.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("poetry")
public class Poem {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String dynasty;
    private String author;

    private String content;


}
