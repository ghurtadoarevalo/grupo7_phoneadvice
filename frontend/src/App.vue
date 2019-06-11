<template>
  <v-app>
    <Navbar/>
  </v-app>
</template>

<script>
import Navbar from './components/Navbar'
export default {
  
  name: 'App',
  components:{
    Navbar
  },
  data () {
    return {
      //
    }
  },
  beforeCreate(){
    this.$store.dispatch('getAllAll')
  }
}
</script>