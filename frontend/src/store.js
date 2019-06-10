
import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios';

Vue.use(Vuex)
Vue.use(Axios)

export default new Vuex.Store({
  state: {
    active: 'graph', //Utilizado para indicar qué pestaña se muestra dentro de cada categoría
    activeSpecification: 'Batería', //Utilizado para indicar qué especificación está activa en la pestaña de especficaciones
    
    phonesDescription: [],
    evalSpecification: [],  //Utilizado para mostrar la evaluación en los gráficos de specificacion
    specData: [], //Utilizado para mostrar las fichas técnicas de los equipos
    names:[], //Utilizado para almacenar los nombres de los equipos y mostrarlos en los gráficos
    imgList :[], //Utilizado para almacenar las imágenes de los equipos y mostrarlas en los gráficos
    
    listaEquipos: [],  //Utilizado para almacenar los equipos que provienen del backend al hacer las consultas
    headers:[ //Utilizado por la ficha técnica
      {spec: 'Procesador: ', icon:'mdi-chip'},
      {spec: 'RAM: ' , icon:'memory'}, 
      {spec: 'Sistema Operativo: ', icon:'android'},
      {spec: 'Dimensiones: ', icon:'open_with'}, 
      {spec: 'Cámara Frontal: ', icon:'camera_front'},
      {spec: 'Cámara Trasera: ', icon:'camera_rear'},
      {spec: 'Pantalla: ', icon:'smartphone'},
      {spec: 'Almacenamiento', icon:'storage'},
      {spec: 'Bateria: ', icon:'battery_charging_full'}],
      topTen: {
        evalP:[],
        evalN:[],
        evalNeutral:[],
        topTenNames: [],
        topTenImgList: [],
        topTenEvalSpecification: [],
        topTenSpecData:[]
      },
      brandData: {
        brandImgList: [],
        brandNames:[],  
        evalBrand: [],
        evalP:[],
        evalN:[],
        evalNeutral:[],
      }
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
            state.specData = []
            var names = []
            var imgList = []
            var evalSpecification = []
            var specData = []
            var phonesDescription = []
            var activeSpecification
            var topTen = {
              evalP:[],
              evalN:[],
              evalNeutral:[],
              topTenNames: [],
              topTenImgList: [],
              topTenEvalSpecification: [],
              topTenSpecData:[]
            }
            var index = 0

            for(var item of state.listaEquipos )
            {
              var dataSheet = []
              dataSheet.push(item.phone.data_sheet.cpu)
              dataSheet.push(item.phone.data_sheet.ram)
              dataSheet.push(item.phone.data_sheet.operative_s)
              dataSheet.push(item.phone.data_sheet.dimensions)
              dataSheet.push(item.phone.data_sheet.front_cam)
              dataSheet.push(item.phone.data_sheet.back_cam)
              dataSheet.push(item.phone.data_sheet.screen)
              dataSheet.push(item.phone.data_sheet.storage)
              dataSheet.push(item.phone.data_sheet.batery)
              phonesDescription.push(item.phone.description)

               
              if(index >= 10){
                specData.push(dataSheet);
                activeSpecification = item.specification.name
                evalSpecification.push(item.assessment)
                names.push(item.phone.model)
                imgList.push(item.phone.image)
              }
              else {
                activeSpecification = item.specification.name
                topTen.topTenEvalSpecification.push(item.assessment)
                topTen.topTenEvalP.push(item.statistic.positive_density)
                topTen.topTenEvalN.push(item.statistic.negative_density)
                topTen.topTenEvalNeutral.push(item.statistic.neutral_density)
                topTen.topTenNames.push(item.phone.model)
                topTen.topTenSpecData.push(dataSheet);
                topTen.topTenImgList.push(item.phone.image)
                index ++
              }
              
             }
              state.activeSpecification = activeSpecification
              state.evalSpecification = evalSpecification
              state.names = names
              state.imgList = imgList
              state.specData = specData
              state.phonesDescription = phonesDescription
              state.topTen = topTen
        
        }catch(err){console.log(err)}
    },
    async getAllSpecification(state, specification_id)
    {
        try{await Axios
            .get('http://localhost:8081/phones_specifications/1/specification')
            .then(response => (state.listaEquipos = response.data))
            state.specData = []
            var names = []
            var imgList = []
            var evalSpecification = []
            var activeSpecification 
            var specData = []
            var phonesDescription = []

            var topTen = {
              evalP:[],
              evalN:[],
              evalNeutral:[],
              topTenNames: [],
              topTenImgList: [],
              topTenEvalSpecification: [],
              topTenSpecData:[]
            }

            var index = 0

            for(var item of state.listaEquipos ){

              var dataSheet = []
              dataSheet.push(item.phone.data_sheet.cpu)
              dataSheet.push(item.phone.data_sheet.ram)
              dataSheet.push(item.phone.data_sheet.operative_s)
              dataSheet.push(item.phone.data_sheet.dimensions)
              dataSheet.push(item.phone.data_sheet.front_cam)
              dataSheet.push(item.phone.data_sheet.back_cam)
              dataSheet.push(item.phone.data_sheet.screen)
              dataSheet.push(item.phone.data_sheet.storage)
              dataSheet.push(item.phone.data_sheet.batery)
              phonesDescription.push(item.phone.description)

              if (index > 9){
                specData.push(dataSheet);
                activeSpecification = item.specification.name
                evalSpecification.push(item.assessment)
                names.push(item.phone.model)
                imgList.push(item.phone.image)

              }
              else{
                activeSpecification = item.specification.name
                topTen.evalP.push(item.statistic.positive_density)
                topTen.evalN.push(item.statistic.positive_density)
                topTen.evalNeutral.push(item.statistic.positive_density)
                topTen.topTenEvalSpecification.push(item.assessment)
                topTen.topTenNames.push(item.phone.model)
                topTen.topTenImgList.push(item.phone.image)
                topTen.topTenSpecData.push(dataSheet)
                index++
              }
              
            }
              state.activeSpecification = activeSpecification
              state.evalSpecification = evalSpecification
              state.names = names
              state.imgList = imgList
              state.specData = specData;
              state.phonesDescription = phonesDescription
              state.topTen = topTen

        }catch(err){console.log(err)}
    },
    //Devices Evaluation
    
    async getAll(state){
        try{
            await Axios 
            .get('http://localhost:8081/phones/getall')
            .then(response => (state.listaEquipos = response.data))
            console.log(state.listaEquipos)
            state.specData = []
            var evalSpecification = []
            var names = []
            var imgList = []
            var specData = []
            var phonesDescription = []
            var topTen = {
              evalP:[],
              evalN:[],
              evalNeutral:[],
              topTenNames: [],
              topTenImgList: [],
              topTenEvalSpecification: [],
              topTenSpecData:[]
            }

            var index = 0

            for(var item of state.listaEquipos )
            {
                var dataSheet = []
                dataSheet.push(item.data_sheet.cpu)
                dataSheet.push(item.data_sheet.ram)
                dataSheet.push(item.data_sheet.operative_s)
                dataSheet.push(item.data_sheet.dimensions)
                dataSheet.push(item.data_sheet.front_cam)
                dataSheet.push(item.data_sheet.back_cam)
                dataSheet.push(item.data_sheet.screen)
                dataSheet.push(item.data_sheet.storage)
                dataSheet.push(item.data_sheet.batery)
                phonesDescription.push(item.description)

                if(index > 9){
                  specData.push(dataSheet);
                  evalSpecification.push(item.assessment)
                  names.push(item.model)
                  imgList.push(item.image)

                }
                else{
                  topTen.evalP.push(item.statistic.positive_density)
                  topTen.evalN.push(item.statistic.positive_density)
                  topTen.evalNeutral.push(item.statistic.positive_density)
                  topTen.topTenEvalSpecification.push(item.assessment)
                  topTen.topTenNames.push(item.model)
                  topTen.topTenImgList.push(item.image)
                  topTen.topTenSpecData.push(dataSheet)
                  index ++
                }
                
            }
            state.specData = specData;
            state.evalSpecification = evalSpecification
            state.names = names
            state.imgList = imgList
            state.phonesDescription = phonesDescription
            state.topTen = topTen

        }catch(err){console.log("En get all " + err)}
    
      },
    async getBrands(state){
      try{
        await Axios
        .get('http://localhost:8081/brands/')
        .then(response => (state.listaMarcas = response.data))
        state.specData = []

        var brandData = {
          brandImgList: [],
          brandNames:[],  
          evalBrand: [],
          evalP:[],
          evalN:[],
          evalNeutral:[],
        }

        for(var item of state.listaMarcas){
          brandData.evalBrand.push(item.assessment)
          brandData.brandNames.push(item.name)
          brandData.brandImgList.push(item.image)
          brandData.evalP.push(item.statistic.positive_density)
          brandData.evalN.push(item.statistic.negative_density)
          brandData.evalNeutral.push(item.statistic.neutral_density)
        }
        state.brandData = brandData
      } catch(err) {console.log(err)}
    },
    filterByGammaSpecification(state,gammas)
    {
        try{
            state.specData = []

            var evalSpecification = []
            var names = []
            var imgList = []
            var specData = []
            var index = 0
            var phonesDescription = []
            var activeSpecification;
            var topTen = {
              evalP:[],
              evalN:[],
              evalNeutral:[],
              topTenNames: [],
              topTenImgList: [],
              topTenEvalSpecification: [],
              topTenSpecData:[]
            }

            for(var item of state.listaEquipos ){
                if(gammas[item.phone.gamma.gammaId - 1]){

                  var dataSheet = []
                  dataSheet.push(item.phone.data_sheet.cpu)
                    dataSheet.push(item.phone.data_sheet.ram)
                    dataSheet.push(item.phone.data_sheet.operative_s)
                    dataSheet.push(item.phone.data_sheet.dimensions)
                    dataSheet.push(item.phone.data_sheet.front_cam)
                    dataSheet.push(item.phone.data_sheet.back_cam)
                    dataSheet.push(item.phone.data_sheet.screen)
                    dataSheet.push(item.phone.data_sheet.storage)
                    dataSheet.push(item.phone.data_sheet.batery)
                    phonesDescription.push(item.phone.description)

                  
                  if(index > 9){
                    activeSpecification = item.specification.name
                    evalSpecification.push(item.assessment)
                    names.push(item.phone.model)
                    imgList.push(item.phone.image)
                    specData.push(dataSheet);

                  }
                  else{
                    activeSpecification = item.specification.name
                    topTen.evalP.push(item.statistic.positive_density)
                    topTen.evalN.push(item.statistic.positive_density)
                    topTen.evalNeutral.push(item.statistic.positive_density)
                    topTen.topTenEvalSpecification.push(item.assessment)
                    topTen.topTenNames.push(item.phone.model)
                    topTen.topTenImgList.push(item.phone.image)
                    topTen.topTenSpecData.push(dataSheet)
                    index ++
                  }
                }
              }

              state.activeSpecification = activeSpecification
              state.evalSpecification = evalSpecification
              state.names = names
              state.imgList = imgList
              state.specData = specData
              state.phonesDescription = phonesDescription
              state.topTen = topTen

        
        }catch(err){console.log(err)}    
    },
    filterByGama(state,gammas){

    try{
        state.specData = []

      var names = []
      var imgList = []
      var evalSpecification = []
      var specData = []
      var phonesDescription = []
      var topTen = {
        evalP:[],
        evalN:[],
        evalNeutral:[],
        topTenNames: [],
        topTenImgList: [],
        topTenEvalSpecification: [],
        topTenSpecData:[]
      }
      var index = 0

      for(var item of state.listaEquipos )
      {
        if(gammas[item.gamma.gammaId - 1])
        {
            var dataSheet = []
            dataSheet.push(item.data_sheet.cpu)
            dataSheet.push(item.data_sheet.ram)
            dataSheet.push(item.data_sheet.operative_s)
            dataSheet.push(item.data_sheet.dimensions)
            dataSheet.push(item.data_sheet.front_cam)
            dataSheet.push(item.data_sheet.back_cam)
            dataSheet.push(item.data_sheet.screen)
            dataSheet.push(item.data_sheet.storage)
            dataSheet.push(item.data_sheet.batery)
            phonesDescription.push(item.description)


          if(index > 9){
            specData.push(dataSheet)
            evalSpecification.push(item.assessment)
            names.push(item.model)
            imgList.push(item.image)

          }
          else
          {
            topTen.evalP.push(item.statistic.positive_density)
            topTen.evalN.push(item.statistic.positive_density)
            topTen.evalNeutral.push(item.statistic.positive_density)
            topTen.topTenEvalSpecification.push(item.assessment)
            topTen.topTenNames.push(item.model)
            topTen.topTenImgList.push(item.image)
            topTen.topTenSpecData.push(dataSheet)
            index ++
          }
          
        }
       }

      state.evalSpecification = evalSpecification
      state.names = names
      state.imgList = imgList
      state.specData = specData
      state.phonesDescription = phonesDescription
      state.topTen = topTen

    }catch(err){console.log(err)}    

    },
  
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
    },
    getBrands(context){
      context.commit('getBrands')
    },
  },
})
