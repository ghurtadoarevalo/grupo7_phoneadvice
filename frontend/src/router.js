import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/searchForDevices',
      name: 'searchForDevices',
      component: () => import(/* webpackChunkName: "search devices" */ './views/SearchDevices.vue')
    },
    {
      path: '/searchForSpecifications',
      name: 'searchForSpecifications',
      component: () => import(/* webpackChunkName: "search devices" */ './views/SearchSpecifications.vue')
    },
    {
      path: '/searchForBrands',
      name: 'searchForBrands',
      component: () => import(/* webpackChunkName: "search devices" */ './views/SearchBrands.vue')

    },
    {
      path: '/networkGraph',
      name: 'networkGraph',
      component: () => import(/* webpackChunkName: "search devices" */ './views/NetworkGraph.vue')

    }

  ]
})
