<template>
  <view class="user-container">
    <view v-if="hasLogin" class="user-info">
      <view class="avatar">
        <image src="../static/user.png" class="avatarimg" alt="用户头像"></image>
        <text v-if="id !== -1"  >{{id}}</text>
        <text class="idstring">{{ username }}</text>
      </view>
      <view>
        <button @click="quit" class="logout-button button">退出登录</button>
      </view>
    </view>

    <!-- 登录注册   -->
    <view v-else class="login-register">
      <view v-if="isLogin" class="login-form">
        <input type="text" class="input-field" placeholder="请输入用户名" v-model="loginForm.username">
        <input type="password" class="input-field" placeholder="请输入密码" v-model="loginForm.password">
        <view>
        </view>
        <button @click="login" class="login-button button">登录</button>
        {{ loginForm.username }}
        {{ loginForm.password }}
      </view>
      <view v-else class="register-form">
        <input type="text" class="input-field" placeholder="请输入用户名" v-model="registerForm.username">
        <input type="password" class="input-field" placeholder="请输入密码" v-model="registerForm.password">
        <input type="password" class="input-field" placeholder="请再次输入密码" v-model="registerForm.repassword">
        <button @click="register" class="register-button button">注册</button>
      </view>
      <button @click="toggleForm" class="toggle-button button">切换</button>
    </view>
  </view>


</template>


<script setup>
import {ref} from 'vue'
import {loginService, registerService} from "../service/poem";

const isLogin = ref(true)
const hasLogin = ref(false)
const username = ref('');
const id = ref(-1);

const loginForm = ref({
  username: '',
  password: ''
})
const registerForm = ref({
  username: '',
  password: '',
  repassword: ''
})

const validateLogin = () => {
  if (loginForm.value.username === '') {
    uni.showToast({
      title: '用户名不能为空',
      icon: 'none'
    })
    return false
  }
  if (loginForm.value.password === '') {
    uni.showToast({
      title: '密码不能为空',
      icon: 'none'
    })
    return false
  }
  return true
}

const validateRegister = () => {
  if (registerForm.value.username === '') {
    uni.showToast({
      title: '用户名不能为空',
      icon: 'none'
    })
    return false
  }
  if (registerForm.value.password === '') {
    uni.showToast({
      title: '密码不能为空',
      icon: 'none'
    })
    return false
  }
  if (registerForm.value.repassword === '') {
    uni.showToast({
      title: '确认密码不能为空',
      icon: 'none'
    })
    return false
  }
  if (registerForm.value.password !== registerForm.value.repassword) {
    uni.showToast({
      title: '两次密码不一致',
      icon: 'none'
    })
    return false
  }
  return true
}

const login = async () => {
  if (!validateLogin()) {
    return
  }
  loginService(loginForm.value.username, loginForm.value.password).then(res => {
    if (res.id === -1) {
      uni.showToast({
        title: '用户名或者密码错误',
        icon: 'none'
      })
    } else {
      uni.showToast({
        title: '登录成功',
        icon: 'none'
      })
      wx.setStorageSync('id', res.id)
      wx.setStorageSync('username', res.username)
      username.value = res.username
      hasLogin.value = true
    }

  }).catch(err => {
    console.log(err)
  })
}

const register = () => {
  if (!validateRegister()) {
    return
  }
  registerService(registerForm.value.username, registerForm.value.password).then(res => {
    if (res.id === -1) {
      uni.showToast({
        title: '用户名已存在',
        icon: 'none'
      })
    } else {
      uni.showToast({
        title: '注册成功',
        icon: 'success'
      })
      wx.setStorageSync('id', res.id)
      wx.setStorageSync('username', res.username)
      username.value = res.username
      hasLogin.value = true
    }
  }).catch(err => {
    console.log(err)
  })

}


const toggleForm = () => {
  isLogin.value = !isLogin.value
}


const quit = () => {
  wx.removeStorageSync('id')
  wx.removeStorageSync('username')
  hasLogin.value = false
}


</script>



<style scoped>

.idstring{
  font-size: 20px;
  color: #999;
  margin-left: 120px;

}


.avatarimg{
  width: 100px;
  height: 100px;
  border-radius: 50%;
  margin: 0 auto;
  display: block;
}

/* 输入框样式 */
.input-field {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  outline: none;
  font-size: 16px;
  background-color: #f5f5f5; /* 添加淡色背景，以符合古老风格 */
  color: #333; /* 字体颜色调暗，增加古老感 */
}

.input-field:focus {
  border-color: #d9b48e; /* 将聚焦时的边框颜色改为指定颜色 */
  box-shadow: 0 0 5px rgba(217, 180, 142, 0.5); /* 调整阴影颜色以匹配按钮颜色 */
}

/* 用户容器样式 */
.user-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  font-family: "Times New Roman", Times, serif; /* 使用经典字体增加古老感 */
}

/* 标题样式 */
.title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
  color: #333; /* 标题颜色调暗 */
}

/* 按钮样式 */
.button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #d9b48e; /* 将按钮背景颜色改为指定颜色 */
  color: #fff;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #b89c74; /* 调整悬停时的背景颜色 */
}

/* 错误提示样式 */
.error-message {
  color: red;
  margin-top: 10px;
}


</style>
