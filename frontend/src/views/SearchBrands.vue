<template>
<v-container grid-list-xl>
  <ChangeToolbar/>
  <Charts v-if="active ==='graph'"/>
  <BrandList v-if="active ==='graph'"/>
  <BrandListForWeight v-if="active ==='twitter'"/>
  <Maps v-if="active ==='maps'"/>
  </v-container>

  
</template>

<script>
  import ChangeToolbar from '../components/brands/ChangeToolbar'
  import Charts from '../components/brands/Charts'
  import BrandList from '../components/brands/BrandList'
  //import Twitteros from '../components/brands/Twitteros';
  import ChartsForWeight from '../components/brands/ChartsForWeight'
  import BrandListForWeight from '../components/brands/BrandListForWeight'
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
      //Twitteros,
      ChartsForWeight,
      BrandListForWeight,
      Maps
    },
    computed:{
      ...mapState(['active','brandData'])
    },
    beforeMount(){
      this.$store.dispatch('resetActive')
    },
    watch: {
      brandData: function(){ 
        this.$store.dispatch('getBrands')
      }
    },
  }
</script>
