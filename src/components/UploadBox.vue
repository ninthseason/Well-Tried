<template>
  <div id="curtain">
    <div id="uploadWindow" @click.stop="">
      <div id="closeBtn" @click="curtainOff">×</div>
      <div id="title">添加单词</div>
      <input type="text" placeholder="单词" v-model="word">
      <input type="text" placeholder="翻译" v-model="transition">
      <div id="submitBtn" @click="uploadWord">确定</div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UploadBox",
  methods: {
    curtainOff() {
      this.$bus.$emit("curtainOff")
      this.word = ""
      this.transition = ""
    },
    uploadWord() {
      axios.post("http://localhost:8081/data", {word: this.word, transition: this.transition, token: this.token})
          .then((response) => {
            if (!response.data) {
              alert("Token不正确或输入为空")
            }
            this.$bus.$emit("curtainOff");
            this.$bus.$emit("updateWordList")
          }).catch(() => {
            alert("无法连接至数据服务器")
      });
    }
  },
  data() {
    return {
      word: "",
      transition: "",
      token: ""
    }
  },
  created() {
    this.$bus.$on("updateToken", (data) => {
      this.token = data
    })
  }
}
</script>

<style scoped>
#curtain {
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0;
  background-color: #8080804d;
  display: flex;
  align-items: center;
  justify-content: center;
}

#uploadWindow {
  width: 400px;
  height: 200px;
  background-color: white;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  position: relative;
}

input {
  margin: 10px 20px 0;
  line-height: 30px;
  font-size: 20px;
  box-sizing: border-box;
  padding-left: 5px;
  border: 0;
  border-left: #a6a6a6 2px solid;
}

input:focus-visible {
  outline: 0;
  border-left: #545454 2px solid;
}

#closeBtn {
  display: inline-flex;
  cursor: pointer;
  top: 20px;
  right: 20px;
  width: 25px;
  height: 25px;
  position: absolute;
  font-size: 40px;
  line-height: 15px;
  overflow: hidden;
}

#title {
  display: inline-flex;
  position: absolute;
  left: 20px;
  top: 10px;
  font-size: 30px;
}

#submitBtn {
  font-size: 20px;
  margin: 10px 20px 20px 20px;
  line-height: 30px;
  bottom: 0;
  background-color: #f8f8f8;
  border-radius: 3px;
  cursor: pointer;
  user-select: none;
  transition: 100ms;
}

#submitBtn:hover {
  background-color: #d9d9d9;
}
</style>
