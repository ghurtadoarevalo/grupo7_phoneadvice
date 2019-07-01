<template>
  <v-container grid-list-xl>
    <ChangeToolbar/>
    <Charts v-if="active ==='graph'"/>
    <PhoneList v-if="active ==='graph' " style="margin-left:-5%"/>
    <Twitteros v-if="active ==='twitter'"/>
    <NeoPhoneList v-if="active ==='twitter' " style="margin-left:-5%"/>
    <Maps v-if="active ==='maps'"/>
  </v-container>
</template>
        
<script>
  import PhoneList from '../components/devices/PhoneList'
  import NeoPhoneList from '../components/devices/NeoPhoneList'
  import Charts from '../components/devices/Charts'
  import ChangeToolbar from '../components/devices/ChangeToolbar'
  import Twitteros from '../components/devices/Twitteros'
  import Maps from '../components/devices/Maps'
  import {mapState} from 'vuex';
   
  export default {
    data() {
      return {
        showNavbar: true
      }
    },
    methods:{
      getData(){
        this.$store.dispatch('getAll')
      }
    },
    components: {
      PhoneList,
      NeoPhoneList,
      ChangeToolbar,
      Charts,
      Twitteros,
      Maps
    },
    computed:{
      ...mapState(['active','ready']),
    },
    mounted(){
      this.getData()
    },
    beforeMount(){
      this.$store.dispatch('resetActive')
    },
  }
</script>
