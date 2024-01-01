<script setup>
import {onLoad,} from "@dcloudio/uni-app";
import {ref, onMounted} from "vue";
import Search from "../components/search.vue";
import PoemCard from "../components/poem.vue";
import {SearchPoemService} from "../service/poem";

let currentPage = ref(1)
let tempkeyword = ref('')
onLoad((option) => {
  tempkeyword.value = option.keyword ? option.keyword : ''
})
onMounted(() => {
  if (tempkeyword != "") {
    handlechange({current: 1})
  }

})

const poems = ref([])
const handlechange = async (newpage) => {
  uni.showLoading({
    title: '加载中'
  })
  SearchPoemService(newpage.current, 10, tempkeyword.value).then(res => {
    currentPage.value = newpage.current
    poems.value = res;

    uni.hideLoading()
  }).catch(error => {
    uni.showToast({
      title: error.message,
      duration: 2000
    });
  });
}

const search = (keyword) => {
  tempkeyword.value = keyword
  handlechange({current: 1}, keyword)

}
</script>

<template>
  <view>
    <view>
      <Search :search="search" :keyword="tempkeyword"/>
    </view>
    <view>
      <uni-pagination :current="currentPage" title="标题文字" total="100" @change="handlechange"></uni-pagination>
    </view>
    <view v-for="poem in poems">
      <PoemCard :poem="poem"/>
    </view>
  </view>
</template>

<style scoped>

</style>