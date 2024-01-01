<script setup>
import {ref} from "vue";
import {onLoad} from "@dcloudio/uni-app";
import {getFlyFlowerService} from "../service/poem";
import {pinyin} from "pinyin-pro";


let word = ref('')
let messages = ref([{content: '你好，我是小诗', isUser: false}, {content: '你好，我是小诗', isUser: true}]);
const userInput = ref('');

const fetchPoem = async () => {
  getFlyFlowerService(word.value).then(res => {
    messages.value.push({content: res.content, isUser: false});
  }).catch(error => {
    uni.showToast({
      title: error.message,
      duration: 2000
    });
  });
}
const sendMessage = async () => {
  const flag = await checkPoem(userInput.value);
  if (flag) {
    messages.value.push({content: userInput.value, isUser: true});
    await fetchPoem(userInput.value)
    userInput.value = '';
  } else {
    uni.showToast({
      title: '请输入正确的诗句',
      icon: 'error',
      duration: 2000
    });
  }
  ;
}

onLoad((option) => {
  word.value = option.keyword ? option.keyword : ''
})


const checkPoem = async (poem) => {
  var reg = new RegExp(word.value);
  if (reg.test(poem)) {
    return true;
  } else {
    return false;
  }
}


</script>

<template>
  <view id="body">
    <view id="describe">
      <view>请与AI进行比赛，在输入框中输入含有"{{ word }}"的诗句</view>
    </view>
    <view id="messages">
      <view v-for="message in messages" :key="message.content">
        <view v-if="message.isUser" class="user message">
          {{ message.content }}
          <img src="../static/user2.png" class="avatar" alt="">
        </view>
        <view v-else class="ai,message">
          <img src="../static/ai.png" class="avatar" alt="">
          {{ message.content }}
        </view>
      </view>
    </view>
    <view id="inputBox">
      <uni-easyinput class="userinput" type="text" v-model="userInput" placeholder="请输入内容" @confirm="sendMessage"/>
    </view>
  </view>
</template>

<style scoped>

.avatar {
  border-radius: 50%;
  width: 30px;
  height: 30px;
}

#body {
  display: block;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: #f5f5f5;
  font-family: 'Times New Roman', serif;
}

.userinput:focus {
  border-color: red;
}

#inputBox {
  position: fixed;
  bottom: -15px;
  left: 0;
  width: 100%;
  height: 50px;
  background-color: #f5f5f5;
}

.user {
  text-align: right;
  margin-right: 10px;
  color: #333;
}

#messages {
  margin-bottom: 40%;
}

.message {
  padding-bottom: 40px;
}

#describe {
  font-size: 18px;
  margin: 20px;
  color: #666;
}

.ai {
  color: #666;
}

.userinput {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 5px 10px;
  font-size: 14px;
  color: #333;
  background-color: #fff;
}

</style>