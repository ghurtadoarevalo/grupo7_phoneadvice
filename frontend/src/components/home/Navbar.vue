<template>
  <v-app >
   <v-navigation-drawer v-if="$router.currentRoute.path != '/'"
    class="hidden-sm-and-up" disable-resize-watcher v-model="sidebar" app>
    <v-img class="ml-5 mr-5 mt-3" :src="require('@/assets/logo.svg')"> 
          </v-img>

      <v-list>
        <v-list-tile
          v-for="item in menuItems"
          :key="item.title"
          :to="item.path">
          <v-list-tile-action>
            <v-icon >{{ item.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>{{ item.title }}</v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>

    <v-toolbar v-if="$router.currentRoute.path != '/'" dense dark color="#0E318A" app>
      <span class="hidden-sm-and-up">
        <v-toolbar-side-icon @click="sidebar = !sidebar">
        </v-toolbar-side-icon>
      </span>
      <v-toolbar-title>
        
        <router-link  to="/" tag="span" style="cursor: pointer">
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
      </v-toolbar-items>
    </v-toolbar>

    <v-content>
      <router-view/>
    </v-content>
  </v-app>
</template>

<script>

export default {
  data () {
    return {
      appTitle: 'Phone Advice',
      sidebar: false,
      menuItems: [
          { title: 'Inicio', path: '/', icon: 'home' },
          { title: 'Celulares', path: '/searchForDevices', icon: 'phone_iphone' },
          {title: 'Marcas', path: '/searchForBrands', icon: 'mdi-android' },
          { title: 'Especificaciones', path: '/searchForSpecifications', icon: 'settings' },
          { title: 'Grafo', path: '/networkGraph', icon: 'mdi-graphql' },
     ]
    }
  }
}
</script>