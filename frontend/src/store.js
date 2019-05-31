
import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios';

Vue.use(Vuex)
Vue.use(Axios)

export default new Vuex.Store({
  state: {
    active: 'graph',
    evalP: [],
    evalN: [],
    names:[],
    imgList :[],
    listaEquipos: [
      
    ]
  },
  mutations: {
    //Button bar
    changeActive(state, newStatus){
      state.active = newStatus
    },
    resetActive(state)
    {
        state.active = 'graph'
    },
    async filterBySpecification(state, specification_id)
    {
        try{await Axios
            .get('http://localhost:8081/phones_specifications/'+specification_id+'/specification')
            .then(response => (state.listaEquipos = response.data))
        
            var evalP = []
            var evalN = []
            var names = []
            var imgList = []
    
            for(var item of state.listaEquipos ){
                evalP.push(item.phone.statistic.positive_density)
                evalN.push(item.phone.statistic.negative_density)
                names.push(item.phone.model)
                imgList.push(item.phone.image)
              }
        
              state.evalP = evalP
              state.evalN = evalN
              state.names = names
              state.imgList = imgList
        
        }catch(err){console.log(err)}
        


    },
    //Devices Evaluation
    
     getAll(state){
        try{
            Axios 
            .get('http://localhost:8081/phones/getall')
            .then(response => (state.listaEquipos = response.data))
            console.log(state.listaEquipos);

            var evalP = []
            var evalN = []
            var names = []
            var imgList = []
      
            for(var item of state.listaEquipos ){
              evalP.push(item.phone.statistic.positive_density)
              evalN.push(item.phone.statistic.negative_density)
              names.push(item.phone.model)
              imgList.push(item.phone.image)
            }
      
            state.evalP = evalP
            state.evalN = evalN
            state.names = names
            state.imgList = imgList

        }catch(err){console.log("En get all " + err)}
    
    },
    filterByGama(state,gammas){
      var evalP = []
      var evalN = []
      var names = []
      var imgList = []
      
      for(var item of state.listaEquipos ){
        if(gammas[item.phone.gamma.gammaId - 1]){
            evalP.push(item.phone.statistic.positive_density)
            evalN.push(item.phone.statistic.negative_density)
            names.push(item.phone.model)
            imgList.push(item.phone.image)
        }
      }
      state.evalP = evalP
      state.evalN = evalN
      state.names = names
      state.imgList = imgList
    }
  },
  actions: {
    getAll (context){
      context.commit('getAll')
    },
    resetActive (context)
    {
        context.commit('resetActive')
    }
  },
})
