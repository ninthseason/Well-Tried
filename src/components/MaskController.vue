<template>
  <div id="MaskController">
    <MaskAllOff></MaskAllOff>
    <MaskAllOn></MaskAllOn>
  </div>
</template>

<script>
import MaskAllOff from "@/components/MaskControlBtn/MaskAllOff";
import MaskAllOn from "@/components/MaskControlBtn/MaskAllOn";

export default {
  name: "MaskController",
  components: { MaskAllOff, MaskAllOn }
}
</script>

<style scoped>
  #MaskController {
    position: absolute;
    width: 500px;
    height: 50px;
  }
</style>
