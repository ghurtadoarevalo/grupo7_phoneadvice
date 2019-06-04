<template>
<v-container grid-list-xl>
  <ChangeToolbar/>
  <Charts v-if="active ==='graph'"/>
  <BrandList v-if="active ==='graph'"/>
  <Maps v-if="active ==='maps'"/>
  </v-container>

  
</template>

<script>
  import BrandList from '../components/brands/BrandList'
  import Charts from '../components/brands/Charts'
  import ChangeToolbar from '../components/brands/ChangeToolbar'
  import Maps from '../components/devices/Maps'
  import {mapState} from 'vuex';
   
  export default {
    data() {
      return {
      }
    },
    components: {
      BrandList,
      ChangeToolbar,
      Charts,
      Maps
    },
    computed:{
      ...mapState(['active'])
    },
    beforeMount(){
      this.$store.dispatch('getBrands')
    },
  }
</script>
