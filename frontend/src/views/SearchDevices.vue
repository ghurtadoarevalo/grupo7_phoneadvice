<template>
  <v-container grid-list-xl>
    <ChangeToolbar/>
    <Charts v-if="active ==='graph'"/>
    <Twitteros v-if="active ==='twitter'"/>
    <PhoneList v-if="active ==='graph' || 'twitter' " style="margin-left:-5%"/>
    <Maps v-if="active ==='maps'"/>
  </v-container>
</template>
        
<script>
  import PhoneList from '../components/devices/PhoneList'
  import Charts from '../components/devices/Charts'
  import ChangeToolbar from '../components/devices/ChangeToolbar'
  import Twitteros from '../components/devices/Twitteros'
  import Maps from '../components/devices/Maps'
  import {mapState, mapMutations} from 'vuex';
   
  export default {
    data() {
      return {
        showNavbar: true,
        ready:0,
      }
    },
    methods:{
      ...mapMutations(['changeActive']),
      getData(){
        if(this.phoneData.length>0 && this.ready == 0)
          this.$store.dispatch('getAll')
          this.ready = 1
      }
    },
    components: {
      PhoneList,
      ChangeToolbar,
      Charts,
      Twitteros,
      Maps
    },
    computed:{
      ...mapState(['active','phoneData']),
    },
    mounted(){
      this.$store.dispatch('resetActive')
      this.changeActive('graph')
      this.getData()
    },
    watch:{
      phoneData: function(){
        this.getData()
      }
    },

  }
</script>
