
import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios';

Vue.use(Vuex)
Vue.use(Axios)

export default new Vuex.Store({
  state: {
    active: 'graph',
    evalSpecification: [],
    evalNeutral: [],
    evalP: [],
    evalN: [],
    names:[],
    imgList :[],
    listaEquipos: [],
    activeSpecification: 'Batería'
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
            var evalNeutral = []
            var evalSpecification = []
            var activeSpecification;

            for(var item of state.listaEquipos ){
                activeSpecification = item.specification.name
                evalSpecification.push(item.assessment)
                evalP.push(item.statistic.positive_density)
                evalN.push(item.statistic.negative_density)
                evalNeutral.push(item.statistic.neutral_density)
                names.push(item.phone.model)
                imgList.push(item.phone.image)
              }

              state.activeSpecification = activeSpecification
              state.evalSpecification = evalSpecification
              state.evalNeutral = evalNeutral
              state.evalP = evalP
              state.evalN = evalN
              state.names = names
              state.imgList = imgList
        
        }catch(err){console.log(err)}
    },
    async getAllSpecification(state, specification_id)
    {
        try{await Axios
            .get('http://localhost:8081/phones_specifications/1/specification')
            .then(response => (state.listaEquipos = response.data))
        
            console.log(state.listaEquipos)

            var evalP = []
            var evalN = []
            var names = []
            var imgList = []
            var evalNeutral = []
            var evalSpecification = []
            var activeSpecification;

            for(var item of state.listaEquipos ){
                activeSpecification = item.specification.name
                evalSpecification.push(item.assessment)
                evalP.push(item.statistic.positive_density)
                evalN.push(item.statistic.negative_density)
                evalNeutral.push(item.statistic.neutral_density)
                names.push(item.phone.model)
                imgList.push(item.phone.image)
              }

              state.activeSpecification = activeSpecification
              state.evalSpecification = evalSpecification
              state.evalNeutral = evalNeutral
              state.evalP = evalP
              state.evalN = evalN
              state.names = names
              state.imgList = imgList
        
        }catch(err){console.log(err)}
    },
    //Devices Evaluation
    
    async getAll(state){
        try{
            await Axios 
            .get('http://localhost:8081/phones/getall')
            .then(response => (state.listaEquipos = response.data))
            console.log(state.listaEquipos);
            
            var evalNeutral = []
            var evalSpecification = []
            var evalP = []
            var evalN = []
            var names = []
            var imgList = []
      
            for(var item of state.listaEquipos ){
              
                evalSpecification.push(item.assessment)
                evalP.push(item.statistic.positive_density)
                evalN.push(item.statistic.negative_density)
                evalNeutral.push(item.statistic.neutral_density)
                names.push(item.model)
                imgList.push(item.image)
            }
      
            state.evalSpecification = evalSpecification
            state.evalNeutral = evalNeutral
            state.evalP = evalP
            state.evalN = evalN
            state.names = names
            state.imgList = imgList

        }catch(err){console.log("En get all " + err)}
    
    },
    filterByGammaSpecification(state,gammas)
    {
        try{
            var evalP = []
            var evalN = []
            var names = []
            var imgList = []
            var evalNeutral = []
            var evalSpecification = []
            var activeSpecification;

            for(var item of state.listaEquipos ){
                if(gammas[item.phone.gamma.gammaId - 1]){
                    activeSpecification = item.specification.name
                    evalSpecification.push(item.assessment)
                    evalP.push(item.statistic.positive_density)
                    evalN.push(item.statistic.negative_density)
                    evalNeutral.push(item.statistic.neutral_density)
                    names.push(item.phone.model)
                    imgList.push(item.phone.image)
                }
              }

              state.activeSpecification = activeSpecification
              state.evalNeutral = evalNeutral
              state.evalSpecification = evalSpecification
              state.evalNeutral = evalNeutral
              state.evalP = evalP
              state.evalN = evalN
              state.names = names
              state.imgList = imgList
        
        }catch(err){console.log(err)}    
    },
    filterByGama(state,gammas){
      var evalP = []
      var evalN = []
      var names = []
      var imgList = []
      var evalNeutral = []
      var evalSpecification = []

      for(var item of state.listaEquipos ){
        if(gammas[item.gamma.gammaId - 1]){
            evalSpecification.push(item.assessment)
            evalP.push(item.statistic.positive_density)
            evalN.push(item.statistic.negative_density)
            names.push(item.model)
            imgList.push(item.image)
        }
      }
      
      state.evalSpecification = evalSpecification
      state.evalNeutral = evalNeutral
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
    getAllSpecification (context)
    {
        context.commit('getAllSpecification')
    },
    resetActive (context)
    {
        context.commit('resetActive')
    }
  },
})
