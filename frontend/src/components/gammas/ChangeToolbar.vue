<template>
<v-bottom-nav
      :active.sync="bottomNav"
      :value="true"
    >
      <v-btn
        color="#0E318A"
        flat
        value="twitter"
        @click="changeActive('twitter')"
      >
        <span>Twitteros</span>
        <v-icon>mdi-twitter</v-icon>
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
    import {mapMutations} from 'vuex'

  export default { 
    components:{
      
    },
    data () {
      return {
        bottomNav: 'twitter'
      }
    },

    methods: {
        ...mapMutations(['changeActive'])
    },
  }
</script>