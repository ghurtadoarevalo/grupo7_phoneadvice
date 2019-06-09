
import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios';

Vue.use(Vuex)
Vue.use(Axios)

export default new Vuex.Store({
  state: {
    active: 'graph', //Utilizado para indicar qué pestaña se muestra dentro de cada categoría
    evalSpecification: [],  //Utilizado para mostrar la evaluación en los gráficos de specificacion
    evalBrand: [], //Utilizado para mostrar la evaluación en los gráficos de marca
    evalNeutral: [], //Utilizado para mostrar los comentarios neutrales en los gráficos
    evalP: [], //Utilizado para mostrar los comentarios positivos en los gráficos
    evalN: [], //Utilizado para mostrar los comentarios negativos en los gráficos
    specData: [], //Utilizado para mostrar las fichas técnicas de los equipos
    names:[], //Utilizado para almacenar los nombres de los equipos y mostrarlos en los gráficos
    imgList :[], //Utilizado para almacenar las imágenes de los equipos y mostrarlas en los gráficos
    brandImgList: [], //Utilizado para almacenar las imágenes de las marcas y mostrarlas en los gráficos
    brandNames:[], //Utilizado para almacenar los nombres de las marcas y mostrarlos en los gráficos
    listaEquipos: [],  //Utilizado para almacenar los equipos que provienen del backend al hacer las consultas
    activeSpecification: 'Batería', //Utilizado para indicar qué especificación está activa en la pestaña de especficaciones
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
            var specData = []
            var activeSpecification

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
              specData.push(dataSheet);

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
              state.specData = specData
        
        }catch(err){console.log(err)}
    },
    async getAllSpecification(state, specification_id)
    {
        try{await Axios
            .get('http://localhost:8081/phones_specifications/1/specification')
            .then(response => (state.listaEquipos = response.data))

            var evalP = []
            var evalN = []
            var names = []
            var imgList = []
            var evalNeutral = []
            var evalSpecification = []
            var activeSpecification
            var specData = []

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
              specData.push(dataSheet);

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
              state.specData = specData;

        }catch(err){console.log(err)}
    },
    //Devices Evaluation
    
    async getAll(state){
        try{
            await Axios 
            .get('http://localhost:8081/phones/getall')
            .then(response => (state.listaEquipos = response.data))
            var evalNeutral = []
            var evalSpecification = []
            var evalP = []
            var evalN = []
            var names = []
            var imgList = []
            var specData = []

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
                specData.push(dataSheet);
            
                evalSpecification.push(item.assessment)
                evalP.push(item.statistic.positive_density)
                evalN.push(item.statistic.negative_density)
                evalNeutral.push(item.statistic.neutral_density)
                names.push(item.model)
                imgList.push(item.image)
            }
      
            state.specData = specData;
            state.evalSpecification = evalSpecification
            state.evalNeutral = evalNeutral
            state.evalP = evalP
            state.evalN = evalN
            state.names = names
            state.imgList = imgList

        }catch(err){console.log("En get all " + err)}
    
      },
    async getBrands(state){
      try{
        await Axios
        .get('http://localhost:8081/brands/')
        .then(response => (state.listaMarcas = response.data))
        console.log("Metodo getBrands");
        var evalBrand = []
        var brandNames = []
        var brandImgList = []
        var evalP = []
        var evalN = []
        var evalNeutral = []

        for(var item of state.listaMarcas){
          console.log(item)
          evalBrand.push(item.assessment)
          brandNames.push(item.name)
          brandImgList.push(item.image)
          evalP.push(item.statistic.positive_density)
          evalN.push(item.statistic.negative_density)
          evalNeutral.push(item.statistic.neutral_density)
        }
        state.evalBrand = evalBrand
        state.brandImgList = brandImgList
        state.brandNames = brandNames
        state.evalP = evalP
        state.evalN = evalN
        state.evalNeutral = evalNeutral
      } catch(err) {console.log(err)}
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
            var specData = []

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
                  specData.push(dataSheet);


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
              state.specData = specData
        
        }catch(err){console.log(err)}    
    },
    filterByGama(state,gammas){
      var evalP = []
      var evalN = []
      var names = []
      var imgList = []
      var evalNeutral = []
      var evalSpecification = []
      var specData = []

      for(var item of state.listaEquipos ){
        if(gammas[item.gamma.gammaId - 1]){

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
          specData.push(dataSheet);

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
      state.specData = specData

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
    },
    getBrands(context){
      context.commit('getBrands')
    }
  },
})
