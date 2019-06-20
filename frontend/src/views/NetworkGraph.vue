<template>
<v-container>
  <Graph/>
</v-container>
</template>

<script >
  import D3Network from 'vue-d3-network'
  import Graph from "../components/network/Graph.vue"

  export default {
    name: 'NetworkGraph',
    components: {
      D3Network,
      Graph
    },
    data() {
      return {
        //
      }
    },
    methods: {
      //
    },
    computed:{
    //
  }

  }
</script>
<style lang="css">

</style>
