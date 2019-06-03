<template>
  <v-container grid-list-xl class="mt-5">
      <!--<specificationsList v-if="activo ==='graph'"/>-->
      <Charts/>
      <PhoneList class="hidden-sm-and-down"/>
      <XsPhoneList class="hidden-md-only"/>
  </v-container>
</template>

<script>
  import PhoneList from '../components/specifications/PhoneList'
  import XsPhoneList from '../components/specifications/xsPhoneList'
  import Charts from '../components/specifications/Charts'
  import specificationsList from '../components/specifications/specificationsList'
  import {mapState, mapMutations} from 'vuex';
   
  export default {
    data() {
      return {
      } 
    },
    components: {
      PhoneList,
      XsPhoneList,
      Charts,
      specificationsList
    },
    computed:{
      ...mapMutations(['changeActive']),
    },
    beforeMount(){
        this.$store.dispatch('getAllSpecification'),
        this.$store.dispatch('resetActive')
	},

    
  }
</script>
