<template>
<v-parallax
    dark
    :src="require('@/assets/fondo.jpg')"
    height="100%"
  >
  <v-container grid-list-xs>
    <v-layout class="justify-center">
      <v-flex  md5 text-xs-center>
        <v-img style="margin-top: 1%" :src="require('@/assets/logo.svg')"></v-img>
      </v-flex>
    </v-layout>

  <v-layout row wrap>
    <Cards style="margin-top:1%"/>
  </v-layout>
  </v-container>
</v-parallax>
</template>

<script>
  import Cards from '../components/home/Cards'

  export default {
    components: {
      Cards
    },
    data() {
      return {
        showNavbar: false
      }
    },
  }
</script>
