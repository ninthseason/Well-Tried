<template>
  <div id="addBtn" @click="addWord">+</div>
</template>

<script>
export default {
  name: "AddButton",
  methods: {
    addWord() {
      this.$bus.$emit("curtainOn")
    }
  }
}
</script>

<style scoped>
  #addBtn {
    width: 40px;
    height: 40px;
    background-color: #b9ffc67d;
    border-radius: 100%;
    position: absolute;
    bottom: 20px;
    right: 20px;
    font-size: 45px;
    line-height: 35px;
    text-align: center;
    color: #00800085;
    font-weight: 100;
    user-select: none;
    transition: 500ms;
    cursor: pointer;
    box-shadow: 0 0 10px #f1f1f1;
  }

  #addBtn:hover {
    transform: rotate(180deg);
  }
</style>
