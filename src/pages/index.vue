<script setup>
import {ref,onMounted} from 'vue';
import RecommendPoemCard from "../components/poem.vue";
import SearchBox from "../components/search.vue";
import {getRecommendPoemService, loginService} from "../service/poem";

const recommendPoem = ref({});

onMounted(()=>{
  changeRecommend()
})


const jumpSearch = (keyword) => {
  wx.navigateTo({
    url: '/pages/poem?keyword=' + keyword
  });
};

const jumpFlyFlower = () => {
  wx.navigateTo({
    url: '/pages/FlyFlower'
  });
};
const jumpSolitaire = () => {
  wx.navigateTo({
    url: '/pages/Solitaire'
  });
};
const jumpUser = () => {
  console.log("jumpUser")
  wx.switchTab({
    url: '/pages/User'
  });
};

const changeRecommend=()=>{
  getRecommendPoemService().then(res=>{
    recommendPoem.value=res
  })

}




</script>
<template>
  <view>
    <SearchBox :search="jumpSearch"></SearchBox>
    <view>
      <view id="game" class="button-row">
        <button @click="jumpFlyFlower">飞花令</button>
        <button @click="jumpSolitaire">诗词接龙</button>
      </view>
    </view>
    <button @click="changeRecommend" id="changeBtn" class="change-btn">换一首</button>
    <RecommendPoemCard :poem="recommendPoem"></RecommendPoemCard>
    
  </view>
</template>

<style scoped>
.view {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.button-row {
  display: flex;
  flex-direction: row;
  justify-content: center;
}

button {
  margin: 10px;
  padding: 10px 20px;
  font-size: 16px;
  background-color: #d9b48eff;
  color: #ffffff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #b38e6eff;
}

.change-btn {
  margin: 10px;
  padding: 0;
  font-size: 16px;
  color: #d9b48eff;
  border: none;
  background-color: transparent;
  cursor: pointer;
}

</style>

