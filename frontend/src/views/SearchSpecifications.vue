<template>
  <v-container grid-list-xl class="mt-5">
      <!--<specificationsList v-if="activo ==='graph'"/>-->
      <Charts/>
      <PhoneList style="margin-left:-5%"/>
  </v-container>
</template>

<script>
  import PhoneList from '../components/specifications/PhoneList'
  import Charts from '../components/specifications/Charts'
  import specificationsList from '../components/specifications/specificationsList'
  import {mapState, mapMutations} from 'vuex';
   
  export default {
    data() {
      return {
        showNavbar: true
      } 
    },
    components: {
      PhoneList,
      Charts,
      specificationsList
    },
    computed:{
      ...mapMutations(['changeActive','ready']),
    },
    mounted(){
        this.$store.dispatch('getAllSpecification'),
        this.$store.dispatch('resetActive')
	},

    
  }
</script>
