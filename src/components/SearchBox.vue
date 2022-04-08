<template>
<!--  <div>-->
    <div class="SearchBox-container">
      <input class="SearchBox" type="text" @focus="focusOn" @focusout="focusOff" @keypress.enter="finishedSearch" @input="searchUpdate" :placeholder="magnifier" v-model="inputContent">
      <div id="deleteBtn" v-show="showDeleteBtn" @mousedown="clearInput">×</div>
    </div>
<!--  </div>-->
</template>

<script>
export default {
  name: "SearchBox",
  methods: {
    focusOn() {
      this.magnifier = ""
      this.showDeleteBtn = true
    },
    focusOff() {
      this.magnifier = "🔍"
      this.showDeleteBtn = false
    },
    clearInput() {
      this.inputContent = ""
      this.$bus.$emit("SearchUpdate", this.inputContent)
    },
    finishedSearch(e) {
      e.target.blur()
    },
    searchUpdate() {
      this.$bus.$emit("SearchUpdate", this.inputContent.trim())
    }
  },
  data() {
    return {
      inputContent: "",
      magnifier: "🔍",
      showDeleteBtn: false,
    }
  },

}
</script>

<style scoped>
  .SearchBox-container {
    min-height: 45px;
    width: 500px;
    display: inline-flex;
    position: relative;
  }

  .SearchBox {
    user-select: none;
    background-color: #e5e5e5;
    border: 0;
    border-radius: 15px;
    width: 100%;
    height: 100%;
    text-align: center;
    font-size: 25px;
    box-sizing: border-box;
    padding-top: 5px;
    padding-bottom: 5px;

  }

  .SearchBox:focus-visible {
    outline: 0;
    text-align: left;
    padding-left: 20px;
    padding-right: 20px;
  }

  #deleteBtn {
    user-select: none;
    font-size: 30px;
    position: absolute;
    right: 10px;
    color: #4d4d4d;
    cursor: pointer;
    height: 30px;
  }
</style>
