package com.example.poem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("poems_info")
public class PoemInfo {
    @TableId
    private Integer id;
    private String title;
    private String author;
    private String dynasty;
}
