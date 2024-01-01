<script setup>
import {ref} from 'vue';
import {getSolitaireService} from "../service/poem";
import {getFirstPinyin, getLastPinyin} from "../utils/pinyin";

let messages = ref([]);
const userInput = ref('');

const sendMessage = async () => {
  if (!await checkPoem(userInput.value)) {
    uni.showToast({
      title: '请输入正确的诗句',
      icon: 'error',
      duration: 2000
    });
  } else {
    messages.value.push({content: userInput.value, isUser: true});
    await fetchPoem(userInput.value)
    userInput.value = '';
  }
};

const checkPoem = async (poem) => {
  if (messages.value.length === 0) {
    return true
  }
  const lastPinyin = getLastPinyin(messages.value[messages.value.length - 1].content);
  const firstPinyin = getFirstPinyin(poem);
  if (lastPinyin === firstPinyin) {
    return true;
  } else {
    return false;
  }


};

// 从后端获取接龙的信息
const fetchPoem = async (poem) => {
  getSolitaireService(poem).then(res => {
    messages.value.push({content: res.content, isUser: false});
  }).catch(error => {
    uni.showToast({
      title: error.message,
      duration: 2000
    });
  });
}


</script>

<template>
  <view id="body">
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
      <uni-easyinput type="text" v-model="userInput" placeholder="请输入内容" @confirm="sendMessage"/>
    </view>

  </view>
</template>

<style scoped>

.avatar {
  text-align: center;
  align-items: center;
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
}

#inputBox {
  position: fixed;
  bottom: -15px;
  left: 0;
  width: 100%;
  height: 50px;
}

.user {
  text-align: right;
  margin-right: 10px;
  color: #000;
}

#messages {
  margin-bottom: 40%;

}

.message {
  padding-bottom: 20px;

}


</style>
