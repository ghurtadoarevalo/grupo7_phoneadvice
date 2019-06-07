<template>
<v-parallax
    dark
    src="https://picserio.com/data/out/337/orange-and-yellow-wallpaper_5448482.jpg"
    height="100%"
  >
  <v-container grid-list-xs>
    <v-layout class="justify-center">
      <v-flex md6 text-xs-center>
        <v-img :src="require('@/assets/logo2.png')"></v-img>
      </v-flex>
    </v-layout>

  <v-layout row wrap>
    <Cards/>
  </v-layout>
  </v-container>
</v-parallax>

</template>

<script>
  import Cards from '../components/Cards'

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
