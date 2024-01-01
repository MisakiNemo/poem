<script setup>
import {ref} from 'vue';
import {getFlyFlowerService} from "../service/poem";

const word = ref('');
const poemsentence = ref({});
const test = async () => {
  if (check(word.value)) {
    getFlyFlowerService(word.value).then(res => {
      poemsentence.value = res;
    }).catch(error => {
      uni.showToast({
        title: error.message,
        duration: 2000
      });
    });
  } else {
    word.value = '';
    uni.showToast({
      title: '请输入单个中文字符',
      duration: 2000
    });
  }
};

const check = () => {
  var reg = /^[\u4E00-\u9FFF]$/;
  if (reg.test(word.value)) {
    wx.navigateTo({
      url: '/pages/FlyFlowerGame?keyword=' + word.value
    });
  } else {
    uni.showToast({
      icon: 'error',
      title: '请输入单个中文字符',
      duration: 2000
    });
  }
}


</script>

<template>
  <view>
    <view class="game-description">
      <h2>游戏说明</h2>
      <p>在输入框中输入一个中文字符,点击开始游戏按钮。接下来，你就会与ai进行比赛，轮流写出含有该字的诗句。</p>
    </view>
    <view>
      <input type="text" v-model="word" class="ancient-input">
    </view>
    <view>
      <button @click="check" class="ancient-button">开始游戏</button>
      <view>{{ poemsentence.content }}</view>
    </view>
    <img src="../static/left-tree.png" class="left-tree" alt="">
    <img src="../static/right-tree.png" class="right-tree" alt="">
  </view>
</template>


<style scoped>

.left-tree{
  position: absolute;
  left: 0;
  top: 60px;
  width: 30%;
  z-index: -1;

}

.right-tree{
 position: absolute;
  right: 0;
  top: 60px;
  width: 30%;
  z-index: -1;
}





input.ancient-input {
  border: 1px solid #ccc;
  width: 40px;
  height: 50px;
  border-radius: 10px;
  margin: 50px auto;
  padding-left: 25px;
  font-family: '宋体', serif;
  font-size: 16px;
}

button.ancient-button {
  border: none;
  margin-top: 20px;
  width: 40%;
  background-color: #e8d3a9;
  border: none;
  color: #5c3b1f;
  padding: 10px 20px;
  font-family: '宋体', serif;
  font-size: 16px;
  border-radius: 5px;
  cursor: pointer;
}

.game-description {
  margin-top: 20px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f5f5f5;
  font-family: '宋体', serif;
  font-size: 16px;
}

.game-description h2 {
  font-size: 18px;
  margin-bottom: 10px;
}

.game-description p {
  font-size: 14px;
  line-height: 1.5;
  writing-mode: vertical-rl;
  text-orientation: upright;
}

</style>
