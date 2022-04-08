<template>
  <ul>
    <WordItem v-for="item in Object.keys(wordlist)" :word="wordlist[item]['word']" :transition="wordlist[item]['transition']" :key="item"></WordItem>

  </ul>
</template>

<script>
import WordItem from "@/components/WordItem";
import axios from 'axios';

export default {
  name: "WordList",
  components: {
    WordItem
  },
  data() {
    return {
      words: {},
      wordlist: {},
    }
  },
  methods: {
    getWordList() {
      axios.get("http://localhost:8081/data").then((response)=>{
        this.words = response.data
        this.wordlist = response.data
      }).catch(()=>{
        this.words = {"1":{"word": "无法连接至数据服务器"}}
        this.wordlist = {"1":{"word": "无法连接至数据服务器"}}
      })
    }
  },
  created() {
    //http://localhost:8081/data
    this.getWordList()
    this.$bus.$on("updateWordList", ()=>{
      this.getWordList()
    })
    this.$bus.$on("SearchUpdate", (text) =>  {
      this.wordlist = {}
      if (text === "") {
        // console.log("clear")
        this.wordlist = this.words;
      } else {
        for (let i in this.words) {
          if (this.words[i]['word'].indexOf(text) === 0) {
            this.wordlist[i] = this.words[i]
          }
        }
      }
    });
  },
}
</script>

<style scoped>
  ul {
    padding-left: 0;
    width: 500px;
    /*text-align: center;*/
    overflow: auto;
  }
  ul::-webkit-scrollbar {
    display: none;
  }
</style>
