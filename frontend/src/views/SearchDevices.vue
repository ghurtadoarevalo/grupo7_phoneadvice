<template>
<v-container grid-list-xl>
  <ChangeToolbar/>
  <Graph/>
  </v-container>
</template>

<script>
  import Graph from '../components/Graph'
  import ChangeToolbar from '../components/ChangeToolbar'
  export default {
    components: {
      Graph,
      ChangeToolbar
    }
  }
</script>
