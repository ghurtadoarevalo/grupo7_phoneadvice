<template>
<v-container grid-list-xl>
  <ChangeToolbar/>
  <Charts/>
  <Graph/>
  </v-container>
</template>

<script>
  import Graph from '../components/Graph'
  import Charts from '../components/Charts'
  import ChangeToolbar from '../components/ChangeToolbar'
  import{mapState} from 'vuex'
   
  export default {
    components: {
      Graph,
      ChangeToolbar,
      Charts
    }
  }
</script>
