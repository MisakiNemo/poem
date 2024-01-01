package com.example.poem.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PoemDTO {
    private Integer id;
    private String title;
    private String author;
    private String dynasty;

    private List<String> content;





}
