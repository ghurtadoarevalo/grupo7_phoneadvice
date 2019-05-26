<template>
  <v-app>
   <v-navigation-drawer v-model="sidebar" app>
    <v-img class="mt-3 mr-2" :src="require('./assets/logo.png')"> 
          </v-img>
     <v-text-field
        hide-details
        prepend-icon="search"
        single-line
      ></v-text-field>
      <v-list>
        <v-list-tile
          v-for="item in menuItems"
          :key="item.title"
          :to="item.path">
          <v-list-tile-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>{{ item.title }}</v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>

    <v-toolbar dense dark color="#0E318A" app>
    
      <span >
        <v-toolbar-side-icon @click="sidebar = !sidebar">
        </v-toolbar-side-icon>
      </span>
      <v-toolbar-title>
        
        <router-link to="/" tag="span" style="cursor: pointer">
        Phone Advice
        </router-link>

      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items class="hidden-xs-only">
        <v-btn
          flat
          v-for="item in menuItems"
          :key="item.title"
          :to="item.path">
          <v-icon left dark>{{ item.icon }}</v-icon>
          {{ item.title }}
        </v-btn>
        <v-text-field
        hide-details
        prepend-icon="search"
        single-line
      ></v-text-field>
      </v-toolbar-items>
    </v-toolbar>

    <v-content>
      <router-view/>
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  data () {
    return {
      appTitle: 'Phone Advice',
      sidebar: false,
      menuItems: [
          { title: 'Home', path: '/', icon: 'home' },
          { title: 'Celulares', path: '/searchForDevices', icon: 'phone_iphone' },
          { title: 'Tareas', path: '/tareas', icon: 'note_add' }
     ]
    }
  }
}
</script>