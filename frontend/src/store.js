import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    activo: 'graph'
  },
  mutations: {
    changeActive(state, newStatus){
      state.activo = newStatus
    }

  },
  actions: {

  }
})
