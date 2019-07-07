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
  import ChartsForWeight from '../components/brands/ChartsForWeight'
  import BrandListForWeight from '../components/brands/BrandListForWeight'
  import Maps from '../components/devices/Maps'
  import {mapState,mapMutations} from 'vuex';
   
  export default {
    data() {
      return {
        ready : 0,
      }
    },
    components: {
      BrandList,
      ChangeToolbar,
      Charts,
      ChartsForWeight,
      BrandListForWeight,
      Maps
    },
    methods:
    {
      ...mapMutations(['changeActive']),
      getData(){
        if(this.ready == 0 && this.brandList.length > 0){
          this.$store.dispatch('getBrands')
          this.ready = 1
        }
      }
    },
    computed:{
      ...mapState(['active','brandList'])
    },
    beforeMount(){
      this.changeActive('graph')      
      this.$store.dispatch('resetActive')
      this.getData()
    },
    watch: {
      brandList: function(){ 
        this.getData()
      }
    },
  }
</script>
