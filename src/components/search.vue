<template>
<view>
  <uni-search-bar   v-model="keyword" @confirm="commit" :focus="false"></uni-search-bar>
</view>
</template>

<script setup>
import {onMounted, ref} from 'vue'
const keyword=ref('')
const props=defineProps({
  keyword:{
    type:String,
    default:''
  },
  search:{
    type:Function,
    default:()=>{}
  }
})
onMounted(()=>{
  keyword.value=props.keyword
})
const commit=(e)=>{
  props.search(keyword.value)
}

</script>