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
  import PhoneList from '../components/PhoneList'
  import Charts from '../components/Charts'
  import ChangeToolbar from '../components/ChangeToolbar'
  import Twitteros from '../components/Twitteros'
  import Maps from '../components/Maps'
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
