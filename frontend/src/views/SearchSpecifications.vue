<template>
  <v-container grid-list-xl class="mt-5">
      <!--<specificationsList v-if="activo ==='graph'"/>-->
      <Charts v-if="activo ==='graph'"/>
      <PhoneList v-if="activo ==='graph'"/>
      <Twitteros v-if="activo ==='twitter'"/>
      <Maps v-if="activo ==='maps'"/>
  </v-container>
</template>

<script>
  import PhoneList from '../components/specifications/PhoneList'
  import Charts from '../components/specifications/Charts'
  import ChangeToolbar from '../components/specifications/ChangeToolbar'
  import specificationsList from '../components/specifications/specificationsList'
  import Twitteros from '../components/specifications/Twitteros'
  import Maps from '../components/specifications/Maps'
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
      Maps,
      specificationsList
    },
    computed:{
      ...mapState(['activo'])
    },
  }
</script>
