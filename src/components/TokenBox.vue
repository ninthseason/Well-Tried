<template>
  <div id="token-container">
    <div id="token-logo">&lt;</div>
    <input id='token' type="text" placeholder="token" @change="updateToken" v-model="token" autocomplete="off">
  </div>
</template>

<script>
export default {
  name: "TokenBox",
  methods: {
    updateToken() {
      this.$bus.$emit("updateToken", this.token)
    }
  },
  data() {
    return {
      token: ""
    }
  }
}
</script>

<style scoped>
  #token-container {
    width: 200px;
    height: 50px;
    background-color: #bababa75;
    position: fixed;
    right: -160px;
    transition: 200ms;
  }

  #token-container:hover {
    right: 0;
  }

  #token-logo {
    position: absolute;
    font-size: 40px;
    line-height: 20px;
    height: 25px;
    overflow: hidden;
    margin-top: 13px;
    color: grey;
    left: 5px;
    user-select: none;
  }

  #token {
    left: 50px;
    position: absolute;
    line-height: 20px;
    top: 12px;
    width: 130px;
    font-size: 20px;
  }

  #token:focus-visible {
    outline: 0;
  }
</style>
