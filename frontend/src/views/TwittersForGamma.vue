<template>
  <v-container grid-list-xl>
    <ChangeToolbar/>
    <Twitteros v-if="active ==='twitter'"/>
    <Maps v-if="active ==='maps'"/>
  </v-container>
</template>
        
<script>
  import ChangeToolbar from '../components/gammas/ChangeToolbar'
  import Maps from '../components/gammas/Maps'
  import Twitteros from '../components/gammas/Twitteros'
  import {mapState, mapMutations} from 'vuex';
   
  export default {
    data() {
      return {
        showNavbar: true
      }
    },
    methods:{
        ...mapMutations(['changeActive'])
    },
    components: {
      ChangeToolbar,
      Twitteros,
      Maps
    },
    computed:{
      ...mapState(['active']),
    },
    beforeMount(){
        this.changeActive('twitter')
    },
  }
</script>