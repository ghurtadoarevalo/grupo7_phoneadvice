
<template>
<v-bottom-nav
      :active.sync="bottomNav"
      :value="true"
      color="transparent"
    >
      <v-btn
        color="teal"
        flat
        value="recent"
      >
        <span>Gráficos</span>
        <chart-icon/>
      </v-btn>

      <v-btn
        color="teal"
        flat
        value="favorites"
      >
        <span>Twitteros</span>
        <twitter-icon/>
      </v-btn>

      <v-btn
        color="teal"
        flat
        value="nearby"
      >
        <span>Mapas</span>
        <v-icon>place</v-icon>
      </v-btn>
    </v-bottom-nav>
</template>

<script>
    import TwitterIcon from "vue-material-design-icons/Twitter.vue"
    import ChartIcon from "vue-material-design-icons/ChartBar.vue"

  export default { 
    components:{
        TwitterIcon,
        ChartIcon
    },
    data () {
      return {
        bottomNav: 'recent'
      }
    }
  }
</script>