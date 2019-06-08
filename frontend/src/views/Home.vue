<template>
<v-parallax
    dark
    src="https://cdn.pixabay.com/photo/2018/03/21/10/01/desktop-3246124_1280.jpg"
    height="50%"
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
