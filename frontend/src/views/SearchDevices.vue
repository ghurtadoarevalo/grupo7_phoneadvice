<template>
  <v-container grid-list-xl>
    <ChangeToolbar/>
    <Charts v-if="active ==='graph'"/>
    <PhoneList v-if="active ==='graph'" style="margin-left:-5%"/>
    <Twitteros v-if="active ==='twitter'"/>
    <PhoneListTwitteros v-if="active == 'twitter'" style="margin-left:-4.5%"/>
    <Maps v-if="active ==='maps'"/>
  </v-container>
</template>
        
<script>
    import PhoneList from '../components/devices/PhoneList'
    import PhoneListTwitteros from '../components/devices/PhoneListTwitteros'
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
          this.$store.dispatch('getAll')
          this.$store.dispatch('getPhoneTwitters')
          this.ready = 1
      }
    },
    components: {
      PhoneList,
      ChangeToolbar,
      Charts,
      Twitteros,
      Maps,
      PhoneListTwitteros,
    },
    computed:{
      ...mapState(['active','phoneData']),
    },
    beforeMount(){
        this.changeActive('graph')
    },
    mounted(){
      this.getData()
    },
    watch:{
      phoneData: function(){
        this.getData()
      }
    },

  }
</script>
