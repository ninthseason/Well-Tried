<template>
  <div class="MaskCtlBtn" @click="func">遮挡所有</div>
</template>

<script>
export default {
  name: "MaskAllOn",
  methods: {
    func() {
      this.$bus.$emit("MaskAllOn")
    }
  }
}
</script>

<style scoped>
  .MaskCtlBtn {
    position: absolute;
    height: 30px;
    width: 80px;
    cursor: pointer;
    line-height: 29px;
    box-shadow: 0 0 10px #f5f5ff;
    border-radius: 10px;
    color: #595959;
    right: 0;
  }
</style>
