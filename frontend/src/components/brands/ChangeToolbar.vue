<template>
<v-bottom-nav
      :active.sync="bottomNav"
      :value="true"
      color="transparent"
    >
      <v-btn
        color="#0E318A"
        flat
        value="graph"
        @click="changeActive('graph',2)"
      >
        <span>Gráficos</span>
        <chart-icon/>
      </v-btn>

      <v-btn
        color="#0E318A"
        flat
        value="maps"
        @click="changeActive('maps',2)"
      >
        <span>Mapas</span>
        <v-icon>place</v-icon>
      </v-btn>
    </v-bottom-nav>
</template>

<script>
    import ChartIcon from "vue-material-design-icons/ChartBar.vue"
    import {mapMutations} from 'vuex'

  export default { 
    components:{
      ChartIcon
    },
    data () {
      return {
        bottomNav: 'graph'
      }
    },

    methods: {
        ...mapMutations(['changeActive'])
    },
  }
</script>