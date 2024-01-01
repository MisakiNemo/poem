import request from "../utils/request";


export const getRecommendPoemService = (params) => {
    return request({
        url:'api/poem/recommend',
        method:'get',
    })
}
export const SearchPoemService = (pageNum,pageSize,keyword) => {
    return request({
        url:'api/poem/search',
        method:'post',
        data:{
            pageNum,
            pageSize,
            keyword
        }
    })
}


export const getSolitaireService = (sentence) => {
    return request({
        url:'api/poem/solitaire',
        method:'get',
        data:{
            sentence
        }
    })
}

export  const getFlyFlowerService = (word) => {
    return request({
        url:'api/poem/flyFlower',
        method:'get',

        data:{
            word
        }
    })
}


export const loginService=(username,password)=>{
    return request({
        url:'api/user/login',
        method:'post',
        data:{
            username,
            password
        }
    })
}


export const registerService=(username,password)=>{
    return request({
        url:'api/user/register',
        method:'post',
        data:{
            username,
            password
        }
    })
}


