<template>
<v-container grid-list-xl>
  <ChangeToolbar/>
  <Charts v-if="activo ==='graph'"/>
  <PhoneList v-if="activo ==='graph'"/>
  <Twitteros v-if="activo ==='twitter'"/>
  <Maps v-if="activo ==='maps'"/>
  </v-container>
</template>

<script>
  import PhoneList from '../components/devices/PhoneList'
  import Charts from '../components/devices/Charts'
  import ChangeToolbar from '../components/devices/ChangeToolbar'
  import Twitteros from '../components/devices/Twitteros'
  import Maps from '../components/devices/Maps'
  import {mapState} from 'vuex';
   
  export default {
    data() {
      return {
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
      ...mapState(['activo'])
    },
    beforeMount(){
    this.$store.dispatch('getAll')
    },
  }
</script>
