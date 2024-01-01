import {pinyin} from "pinyin-pro";


export const getFirstPinyin = (sentence) => {
    let firstWord = sentence.charAt(0);
    let firstPinyin = pinyin(firstWord, {toneType: 'none'});
    return firstPinyin;
}

export const getLastPinyin = (sentence) => {
    let lastWord = sentence.charAt(sentence.length - 1);
    let lastPinyin = pinyin(lastWord, {toneType: 'none'});
    return lastPinyin;
}