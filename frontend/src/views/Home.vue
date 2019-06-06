<template>
<v-parallax
    dark
    src="https://cdn.vuetifyjs.com/images/backgrounds/vbanner.jpg"
  >
  <Cards/>
  </v-parallax>

</template>

<script>
  import Cards from '../components/Cards'

  export default {
    components: {
      Cards
    }
  }
</script>
