<template>
<v-bottom-nav
      :active.sync="bottomNav"
      :value="true"
    >
      <v-btn
        color="#0E318A"
        flat
        value="graph"
        @click="changeActive('graph')"
      >
        <span>Gráficos</span>
        <chart-icon/>
      </v-btn>

      <v-btn
        color="#0E318A"
        flat
        value="twitter"
        @click="changeActive('twitter')"
      >
        <span>Twitteros</span>
        <twitter-icon/>
      </v-btn>

      <v-btn
        color="#0E318A"
        flat
        value="maps"
        @click="changeActive('maps')"
      >
        <span>Mapas</span>
        <v-icon>place</v-icon>
      </v-btn>
    </v-bottom-nav>
</template>

<script>
    import TwitterIcon from "vue-material-design-icons/Twitter.vue"
    import ChartIcon from "vue-material-design-icons/ChartBar.vue"
    import {mapMutations} from 'vuex'

  export default { 
    components:{
      TwitterIcon,
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