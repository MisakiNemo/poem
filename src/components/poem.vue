<script setup>
const props = defineProps({
  poem: Object
})


</script>

<template>
  <uni-card v-if="poem.id" class="poem-card">
    <view class="body">
    <view class="poem-title">{{ poem.title }}</view>
    <view class="poem-details">{{ poem.author }} {{ poem.dynasty }}</view>
    <view class="poem-content">

      <view v-for="sentence in poem.content" :key="sentence" class="poem-sentence">{{ sentence }}。</view>
    </view>
  </view>
  </uni-card>
    <view v-else class="no-content"> 暂时无内容</view>
</template>

<style scoped>

.body {
  background: linear-gradient(to bottom, #FDF5E6 0%, #F5DEB3 100%);
}


.poem-title {
  border-radius: 8px;
  width: auto;
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 10px;
  text-align: center; /* 添加居中对齐样式 */
}

.poem-content {
  margin-bottom: 10px;
  text-align: center; /* 添加居中对齐样式 */
}

.poem-sentence {
  margin-bottom: 5px;
  text-align: center; /* 添加居中对齐样式 */
}

.poem-details {
  color: #999;
  font-size: 14px;
  text-align: center; /* 添加居中对齐样式 */
}

.no-content {
  font-size: 16px;
  color: #999;
  margin-top: 20px;
  text-align: center; /* 添加居中对齐样式 */
}

</style>