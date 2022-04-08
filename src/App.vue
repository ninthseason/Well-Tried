<template>
  <div id="app">
    <div id="logo">
      <h1>Well-Tried</h1>
      <div>Powered by Kl1nge5</div>
    </div>
    <MaskController></MaskController>
    <SearchBox></SearchBox>
    <WordList></WordList>
    <AddButton></AddButton>
    <TokenBox></TokenBox>
    <UploadBox v-show="showCurtain"></UploadBox>
  </div>
</template>

<script>
import SearchBox from "@/components/SearchBox";
import WordList from "@/components/WordList";
import AddButton from "@/components/AddButton";
import UploadBox from "@/components/UploadBox";
import TokenBox from "@/components/TokenBox";
import MaskController from "@/components/MaskController";

export default {
  name: 'App',
  components: {
    SearchBox, WordList, AddButton, UploadBox, TokenBox, MaskController
  },
  data() {
    return {
      showCurtain: false
    }
  },
  created() {
    this.$bus.$on("curtainOff", ()=>{this.showCurtain = false});
    this.$bus.$on("curtainOn", ()=>{this.showCurtain = true});
  }
}
</script>

<style>
html {
  height: 100%;
}

body {
  background-color: aliceblue;
  height: 100%;
  text-align: center;
  overflow: hidden;
  /*margin: 0;*/
}

#app {
  /*text-align: center;*/
  display: inline-flex;
  flex-direction: column;
  align-items: center;
  height: 96%;
  /*margin: 8px;*/
  background-color: #ffffff;
  border-radius: 10px;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 10px;
  position: relative;
}

#logo {
  /*display: flex;*/
}

#logo h1 {
  margin-bottom: 0;
  line-height: 24px;
}

#logo div {
  text-align: center;
  user-select: none;
  font-size: 5px;
  line-height: 20px;
  color: rgba(2, 86, 86, 0.56);
}
</style>
