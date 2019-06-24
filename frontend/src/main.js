import '@babel/polyfill'
import Vue from 'vue'
import HighchartsVue from 'highcharts-vue'
import Highcharts from 'highcharts'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import '@mdi/font/css/materialdesignicons.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import '@mdi/font/css/materialdesignicons.css'


Vue.config.productionTip = false
Vue.use(HighchartsVue, {
  highcharts: Highcharts
})

new Vue({
  router,
  store,
  HighchartsVue,
  Highcharts,
  render: h => h(App)
}).$mount('#app')
