<template>
  <div id="app">
    <v-app>
      <v-container>
        <v-layout>
          <v-flex>
            <a href="/"><v-btn :class="['text-white']">Home</v-btn></a>
          </v-flex>
          <v-flex>
            <a href="http://localhost:8080/actors/"><v-btn :class="['text-white']">Actors</v-btn></a>
          </v-flex>
        </v-layout>

        <template>
  <v-app id="inspire">
   
    <v-toolbar
      color="blue-grey"
      dark
      fixed
      app
      clipped-right
    >
    <!--<v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>-->
      <v-toolbar-title>Phoneadvice</v-toolbar-title>
      <v-spacer></v-spacer>
    </v-toolbar>
    <!--<v-navigation-drawer
      v-model="drawer"
      fixed
      app
    >
      <v-list dense>
        <v-list-tile @click.stop="left = !left">
          <v-list-tile-action>
            <v-icon>exit_to_app</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Open Temporary Drawer</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-navigation-drawer
      v-model="left"
      temporary
      fixed
    ></v-navigation-drawer> -->
    <v-content>
      <v-container fluid fill-height>
        <v-layout justify-center >
          <v-flex shrink>
            <v-tooltip right>
              <template v-slot:activator="{ on }">
                  <router-view></router-view>
              </template>
            </v-tooltip>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
    <v-navigation-drawer
      v-model="right"
      right
      temporary
      fixed
    ></v-navigation-drawer>
    <v-footer color="blue-grey" class="white--text" app>
      <span>phoneadvice</span>
      <v-spacer></v-spacer>
      <span>&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

      </v-container>
    </v-app>
  </div>
</template>

<script>


export default {
  name: 'App',
  data: () => ({
      drawer: false,
      drawerRight: false,
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
