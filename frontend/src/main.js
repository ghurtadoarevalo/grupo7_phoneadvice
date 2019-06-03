import '@babel/polyfill'
import Vue from 'vue'
import HighchartsVue from 'highcharts-vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

import VuePaginate from 'vue-paginate'
Vue.use(VuePaginate)

Vue.config.productionTip = false
Vue.use(HighchartsVue)

new Vue({
  router,
  store,
  HighchartsVue,
  render: h => h(App)
}).$mount('#app')
