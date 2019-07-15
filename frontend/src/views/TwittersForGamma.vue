<template>
  <v-container grid-list-xl>
    <ChangeToolbar/>
    <Twitteros v-if="active ==='twitter'" style="margin-top:3%" />
    <Charts v-if="active ==='twitter'"/>
    <PhoneList v-if="active ==='twitter'" style="margin-left:-5%"/>
    <Maps v-if="active ==='maps'"/>
  </v-container>
</template>
        
<script>

  import PhoneList from '../components/gammas/PhoneList'
  import Charts from '../components/gammas/Charts'
  import ChangeToolbar from '../components/gammas/ChangeToolbar'
  import Maps from '../components/gammas/Maps'
  import Twitteros from '../components/gammas/Twitteros'
  import {mapState, mapMutations} from 'vuex';
   
  export default {
    data() {
      return {
        showNavbar: true,
        ready:0
      }
    },
    methods:{
        ...mapMutations(['changeActive']),
        getData(){
          if(this.usersGamma.length > 0 && this.ready == 0){
            this.$store.dispatch('getAllTwitters')
            this.ready = 1
        }
      }
    },
    components: {
      ChangeToolbar,
      Twitteros,
      Maps,
      Charts,
      PhoneList

    },
    computed:{
      ...mapState(['active','usersGamma']),
    },
    beforeMount(){
        this.changeActive('twitter')
    },
    mounted(){
      this.getData()
    },
    watch: {
      usersGamma: function(){
        this.getData()
      }
    },
  }
</script>