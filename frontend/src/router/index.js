import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home.vue'
import Actors from '@/components/Actors.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
    },
    {
      path: '/actors',
      name: 'Actors',
      component: Actors
    }
  ],
  mode: 'history'
})
