package com.example.poem.utils;

//导入汉字转拼音库

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoemUtils {

    //获取一个字的拼音
    public static String getOnePinyin(String word) {
        String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word.charAt(0));
        return pinyinArray[0].substring(0, pinyinArray[0].length() - 1);
    }

    //将一首诗用。分割成多个句子
    public static List<String> getSentences(String poem) {
        List<String> result = new ArrayList<>();
        String[] sentences = poem.split("。");
        result.addAll(Arrays.asList(sentences));
        return result;
    }

    //获取一个句子的最后一个字
    public static String getLastWord(String sentence) {
        return sentence.substring(sentence.length() - 1);
    }


}










