
import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios';

Vue.use(Vuex, Axios); 

export default new Vuex.Store({
  state: {
    active: 'graph', //Utilizado para indicar qué pestaña se muestra dentro de cada categoría
    activeSpecification: 'Batería', //Utilizado para indicar qué especificación está activa en la pestaña de especficaciones
    activeSpecificationIndex: 0, //Utilizado para indicar qué especificación está activa en la pestaña de especficaciones
    phonesDescription: [],
    evalSpecification: [],  //Utilizado para mostrar la evaluación en los gráficos de specificacion
    specData: [], //Utilizado para mostrar las fichas técnicas de los equipos
    names:[], //Utilizado para almacenar los nombres de los equipos y mostrarlos en los gráficos
    imgList : [], //Utilizado para almacenar las imágenes de los equipos y mostrarlas en los gráficos
    brandList: [],
    phoneData: [],  //Utilizado para almacenar los equipos que provienen del backend al hacer las consultas
    neoPhoneSizes: [],
    neoPhoneNames: [],
    neoPhoneImgList: [],
    neoPhoneData: [
      { phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },
      { phoneID: 27, 
        model: 'iPhone XR', 
        description: 'El iPhone XR tiene el LCD más avanzado en un smartphone', 
        assessment: 61,
        image: 'apple/iphone_xr', 
        size: 213,
        data_sheet: {
          dataSheetId: 17,
          cpu: 'Super AMOLED 5.8\" táctil (1125x2436)',
          ram: '4 GB',
          operative_s: 'iOS 12',
          dimensions: '72 x 149 x 8 mm ',
          front_cam: 'Estándar 7.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP',
          storage: '64 GB',
          batery: '2658 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      },{ phoneID: 11, 
        model: 'Galaxy s10', 
        description: 'El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.', 
        assessment: 98,
        image: 'samsung/galaxy_s10', 
        size: 435,
        data_sheet: {
          dataSheetId: 1,
          cpu: 'Samsung Exynos 9 Octa (9820) (2730 MHz)',
          ram: '8 GB',
          operative_s: 'Android 9.0 Pie',
          dimensions: '70 x 150 x 8 mm',
          front_cam: 'Estándar 10.0 MP',
          screen: 'Dynamic AMOLED 6.1\" táctil (3040x1440)',
          back_cam: 'Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP',
          storage: '128 GB',
          batery: '3400 mAh' 
        },
        gamma:{
          gammaId: 3,
          name: 'Alta',
          min_price: 350001,
          max_price: 2000000,
        },
        
       
      }
    ],
    phoneSpecification:[], //Utilizado para almacenar los equipos que provienen del backend al hacer las consultas
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
    neoTopTen: {
      topTenSizes: [],
      topTenNames: [],
      topTenImgList: [],
      topTenSpecData:[]
    },
    brandData: {
      brandImgList: [],
      brandNames:[],  
      evalBrand: [],
      evalP:[],
      evalN:[],
      evalNeutral:[],
    },
    allGraphData:{nodes:[], links: []},
    graphData: {brandNodes:[], links: []},
    link:[],
    ready:0,
  },
  mutations: {
    /*Verificacion de elemento activo en ChangeToolbar*/
    changeActive(state, newStatus, view){
        state.active = newStatus
    },
    resetActive(state)
    {
        state.active = 'graph'
    },


    /*Traer todo de la DB*/
    async getAllAll(state){
      try{
        await Axios 
        .get('http://localhost:8081/phones/getall')
        .then(response => (state.phoneData = response.data))
        
        console.log('phoneData con datos cargados')
        

        for (let index = 1; index < 7; index++) {
          var listFilter = []
          await Axios
          .get('http://localhost:8081/phones_specifications/'+index+'/specification')
          .then(response => (listFilter = response.data))   
          state.phoneSpecification.push(listFilter);
        }
        console.log('phoneSpecification con datos cargados')

        await Axios
        .get('http://localhost:8081/brands/')
        .then(response => (state.brandList = response.data))
        
        console.log('brandList con datos cargados')

        /*
        await Axios
        .get('http://localhost:8081/neo/fullNodos/')
        .then(response => (state.allGraphData.nodes = response.data))

        await Axios
        .get('http://localhost:8081/neo/fullAristas/')
        .then(response => (state.allGraphData.links = response.data))

        await Axios
        .get('http://localhost:8081/neo/getBrands')
        .then(response => (state.graphData.brandNodes = response.data))

        await Axios
        .get('http://localhost:8081/neo/fullAristas/')
        .then(response => (state.allGraphData.links = response.data))

        await Axios
        .get('http://localhost:8081/neo/getPhones/')
        .then(response =>(state.neoPhoneData = response.data))
        */

      }catch(err){console.log("En get all all " + err)}
    },


    /*Funciones para vista SearchDevices*/
    async getAll(state){
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

      for(var item of state.phoneData )
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
          topTen.evalN.push(item.statistic.negative_density)
          topTen.evalNeutral.push(item.statistic.neutral_density)
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
    },

      getNeoPhones(state){
      var names = []
      var imgList = []
      var specData = []
      var phonesDescription = []
      var phoneSize = []
      var topTen = {
        topTenSize: [],
        topTenNames: [],
        topTenImgList: [],
        topTenSpecData:[]
      }
      var index = 0
      for(var item of state.neoPhoneData )
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
          phoneSize.push(item.size)
          names.push(item.model)
          imgList.push(item.image)

        }
        else{
          topTen.topTenSize.push(item.size)
          topTen.topTenNames.push(item.model)
          topTen.topTenImgList.push(item.image)
          topTen.topTenSpecData.push(dataSheet)
          index ++
        } 
      }
      state.neoPhoneSizes = phoneSize
      state.neoPhoneNames = names
      state.neoPhoneImgList = imgList
      state.neoTopTen = topTen
      console.log('PESOS')
      console.log(topTen.topTenSize)

    },

    filterByGama(state,gammas){
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

      for(var item of state.phoneData)
      {
        var dataSheet = []
        if(gammas[item.gamma.gammaId - 1])
        {
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
            topTen.evalN.push(item.statistic.negative_density)
            topTen.evalNeutral.push(item.statistic.neutral_density)
            topTen.topTenEvalSpecification.push(item.assessment)
            topTen.topTenNames.push(item.model)
            topTen.topTenImgList.push(item.image)
            topTen.topTenSpecData.push(dataSheet)
          }
          index ++
        }
      }
      console.log(topTen)
      state.evalSpecification = evalSpecification
      state.names = names
      state.imgList = imgList
      state.specData = specData
      state.dataSheet = dataSheet
      state.phonesDescription = phonesDescription
      state.topTen = topTen
    },
    

    /*Funciones para vista SearchSpecification*/
    async filterBySpecification(state, specification_id)
    {
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

      for(var item of state.phoneSpecification[specification_id-1])
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
          evalSpecification.push(item.assessment)
          names.push(item.phone.model)
          imgList.push(item.phone.image)
        }
        else {
          topTen.topTenEvalSpecification.push(item.assessment)
          topTen.evalP.push(item.statistic.positive_density)
          topTen.evalN.push(item.statistic.negative_density)
          topTen.evalNeutral.push(item.statistic.neutral_density)
          topTen.topTenNames.push(item.phone.model)
          topTen.topTenSpecData.push(dataSheet);
          topTen.topTenImgList.push(item.phone.image)
          index ++
        }
      }
      state.activeSpecification = state.phoneSpecification[specification_id-1][0].specification.name
      state.activeSpecificationIndex = specification_id-1
      state.evalSpecification = evalSpecification
      state.names = names
      state.imgList = imgList
      state.specData = specData
      state.phonesDescription = phonesDescription
      state.topTen = topTen
        
    },

    async getAllSpecification(state)
    {
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
       
      for(var item of state.phoneSpecification[0] ){
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
          evalSpecification.push(item.assessment)
          names.push(item.phone.model)
          imgList.push(item.phone.image)

        }
        else{
          topTen.evalP.push(item.statistic.positive_density)
          topTen.evalN.push(item.statistic.negative_density)
          topTen.evalNeutral.push(item.statistic.neutral_density)
          topTen.topTenEvalSpecification.push(item.assessment)
          topTen.topTenNames.push(item.phone.model)
          topTen.topTenImgList.push(item.phone.image)
          topTen.topTenSpecData.push(dataSheet)
          index++
        }
      }
      state.activeSpecification = state.phoneSpecification[0][0].specification.name
      state.activeSpecificationIndex = 0
      state.evalSpecification = evalSpecification
      state.names = names
      state.imgList = imgList
      state.specData = specData;
      state.phonesDescription = phonesDescription
      state.topTen = topTen
    },

    filterByGammaSpecification(state,gammas){
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

      for(var item of state.phoneSpecification[state.activeSpecificationIndex]){
        var dataSheet = []

          if(gammas[item.phone.gamma.gammaId - 1]){            
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
              evalSpecification.push(item.assessment)
              names.push(item.phone.model)
              imgList.push(item.phone.image)
              specData.push(dataSheet);

            }
            else{
              topTen.evalP.push(item.statistic.positive_density)
              topTen.evalN.push(item.statistic.negative_density)
              topTen.evalNeutral.push(item.statistic.neutral_density)
              topTen.topTenEvalSpecification.push(item.assessment)
              topTen.topTenNames.push(item.phone.model)
              topTen.topTenImgList.push(item.phone.image)
              topTen.topTenSpecData.push(dataSheet)
              index ++
            }
          }
        }
        state.dataSheet = dataSheet
        state.activeSpecification = state.phoneSpecification[state.activeSpecificationIndex][0].specification.name
        state.evalSpecification = evalSpecification
        state.names = names
        state.imgList = imgList
        state.specData = specData
        state.phonesDescription = phonesDescription
        state.topTen = topTen
    },


    /*Funciones para vista SearchBrands*/
    async getBrands(state){
      var brandData = {
        brandImgList: [],
        brandNames:[],  
        evalBrand: [],
        evalP:[],
        evalN:[],
        evalNeutral:[],
      }

      for(var item of state.brandList){
        brandData.evalBrand.push(item.assessment)
        brandData.brandNames.push(item.name)
        brandData.brandImgList.push(item.image)
        brandData.evalP.push(item.statistic.positive_density)
        brandData.evalN.push(item.statistic.negative_density)
        brandData.evalNeutral.push(item.statistic.neutral_density)
      }
      state.brandData = brandData
    },

    
    
    /*Funciones para vista NetworkGraph*/
  },
  actions: {
    getAll (context){
      context.commit('getAll')
    },
    getAllSpecification (context)
    {
      context.commit('getAllSpecification')
    },
    getAllAll (context)
    {
      context.commit('getAllAll')
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
