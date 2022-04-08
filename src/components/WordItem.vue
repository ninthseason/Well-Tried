<template>
  <li>
    {{ word }}
    <div id="translation" @click="switchMask">{{ transition }}
      <div class="mask" v-show="marked"></div>
    </div>
  </li>
</template>

<script>
export default {
  name: "WordItem",
  data() {
    return {
      marked: true
    }
  },
  methods: {
    switchMask() {
      this.marked = !this.marked
    },
  },
  created() {
    this.$bus.$on("MaskAllOff", () => {
      this.marked = false
    });
    this.$bus.$on("MaskAllOn", () => {
      this.marked = true
    });
  },
  props: ["word", "transition"]
}
</script>

<style scoped>
li {
  list-style: none;
  width: 500px;
  border-bottom: #d3d3d3 solid 1px;
  height: 60px;
  text-align: left;
  line-height: 30px;
  padding-bottom: 10px;
}

.mask {
  position: absolute;
  top: 13%;
  width: 100%;
  height: 80%;
  background-image: linear-gradient(315deg, #ddf6ff 25%, #d3f4ff 0, #d3f4ff 50%, #ddf6ff 0, #ddf6ff 75%, #d3f4ff 0);
  background-size: 40px 40px;
  border-radius: 5px;
  /*cursor: pointer;*/
}

#translation {
  user-select: none;
  position: relative;
  color: #8f8e8e;
  cursor: pointer;
}
</style>
