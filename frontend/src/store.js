
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
    dataSheet: [],
    names:[],
    imgList :[],
    listaEquipos: [],
    activeSpecification: 'Batería',
    headers:[
      {spec: 'Procesador: ', icon:'mdi-chip'},
      {spec: 'RAM: ' , icon:'memory'}, 
      {spec: 'Sistema Operativo: ', icon:'android'},
      {spec: 'Dimensiones: ', icon:'open_with'}, 
      {spec: 'Peso: ', icon:'mdi-weight-gram'}, 
      {spec: 'Cámara Frontal: ', icon:'camera_front'},
      {spec: 'Cámara Trasera: ', icon:'camera_rear'},
      {spec: 'Pantalla: ', icon:'smartphone'},
      {spec: 'Almacenamiento', icon:'storage'},
      {spec: 'Bateria: ', icon:'battery_charging_full'}],
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
            var activeSpecification

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
            var activeSpecification
            var dataSheets = []

            for(var item of state.listaEquipos ){

                var dataSheet = []
                dataSheet.push(state.listaEquipos.back_cam)
                dataSheet.push(state.listaEquipos.batery)
                dataSheet.push(state.listaEquipos.cpu)
                dataSheet.push(state.listaEquipos.dimensions)
                dataSheet.push(state.listaEquipos.operative_s)
                dataSheet.push(state.listaEquipos.ram)
                dataSheet.push(state.listaEquipos.screen)
                dataSheet.push(state.listaEquipos.storage)
                dataSheet.push(state.listaEquipos.weight)
                dataSheets.push(dataSheet);


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
              state.dataSheet = dataSheet;

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
            var dataSheets = []

            for(var item of state.listaEquipos )
            {
                var dataSheet = []
                dataSheet.push(state.listaEquipos.back_cam)
                dataSheet.push(state.listaEquipos.batery)
                dataSheet.push(state.listaEquipos.cpu)
                dataSheet.push(state.listaEquipos.dimensions)
                dataSheet.push(state.listaEquipos.operative_s)
                dataSheet.push(state.listaEquipos.ram)
                dataSheet.push(state.listaEquipos.screen)
                dataSheet.push(state.listaEquipos.storage)
                dataSheet.push(state.listaEquipos.weight)
                dataSheets.push(dataSheet);
            
                evalSpecification.push(item.assessment)
                evalP.push(item.statistic.positive_density)
                evalN.push(item.statistic.negative_density)
                evalNeutral.push(item.statistic.neutral_density)
                names.push(item.model)
                imgList.push(item.image)
            }
      
            state.dataSheet = dataSheet;
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
            var dataSheets = []

            for(var item of state.listaEquipos ){
                if(gammas[item.phone.gamma.gammaId - 1]){

                    var dataSheet = []
                    dataSheet.push(state.listaEquipos.back_cam)
                    dataSheet.push(state.listaEquipos.batery)
                    dataSheet.push(state.listaEquipos.cpu)
                    dataSheet.push(state.listaEquipos.dimensions)
                    dataSheet.push(state.listaEquipos.operative_s)
                    dataSheet.push(state.listaEquipos.ram)
                    dataSheet.push(state.listaEquipos.screen)
                    dataSheet.push(state.listaEquipos.storage)
                    dataSheet.push(state.listaEquipos.weight)
                    dataSheets.push(dataSheet);


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
              state.dataSheets = dataSheets
        
        }catch(err){console.log(err)}    
    },
    filterByGama(state,gammas){
      var evalP = []
      var evalN = []
      var names = []
      var imgList = []
      var evalNeutral = []
      var evalSpecification = []
      var dataSheets = []

      for(var item of state.listaEquipos ){
        if(gammas[item.gamma.gammaId - 1]){

            var dataSheet = []
            dataSheet.push(state.listaEquipos.back_cam)
            dataSheet.push(state.listaEquipos.batery)
            dataSheet.push(state.listaEquipos.cpu)
            dataSheet.push(state.listaEquipos.dimensions)
            dataSheet.push(state.listaEquipos.operative_s)
            dataSheet.push(state.listaEquipos.ram)
            dataSheet.push(state.listaEquipos.screen)
            dataSheet.push(state.listaEquipos.storage)
            dataSheet.push(state.listaEquipos.weight)
            dataSheets.push(dataSheet)

            evalSpecification.push(item.assessment)
            evalP.push(item.statistic.positive_density)
            evalN.push(item.statistic.negative_density)
            names.push(item.model)
            imgList.push(item.image)
        }
      }
      
      state.dataSheets = dataSheet
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
