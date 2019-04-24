<template>
  <div id="app">
    <v-container>
      <v-layout>
        <v-flex>
          <a href="/"><v-btn :class="['text-white']">Home</v-btn></a>
        </v-flex>
        <v-flex>
          <a href="http://localhost:8080/actors/"><v-btn :class="['text-white']">Actors</v-btn></a>
        </v-flex>
      </v-layout>

      <router-view></router-view>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'App',
  data: () => ({
      drawer: null,
      drawerRight: null,
      right: false,
      left: false
    }),
    props: {   
      source: String
    }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
