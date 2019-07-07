
import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios';
import { STATUS_CODES } from 'http';

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
    imgList :[], //Utilizado para almacenar las imágenes de los equipos y mostrarlas en los gráficos
    brandList: [],        
    phoneData: [],  //Utilizado para almacenar los equipos que provienen del backend al hacer las consultas
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
    usersGammaData: [],
    gammaData:    {
        phonesDescription: [],
        topTen:
        {
            topTenNames:[],
            topTenImgList:[],
            topTenSize:[],
            topTenSpecData: [],
        },
        others:
        {
            othersNames:[],
            othersImgList:[],
            othersSpecData: [], 
        }
    },

    usersGamma: [],
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
        var phoneSpecification = []
        //Se obtienen todos los teléfonos
        await Axios 
        .get('http://localhost:8081/phones/getall')
        .then(response => (state.phoneData = response.data))
        
        console.log('phoneData con datos cargados')

        //Se obtienen todos los teléfonos según cada especificación
        for (let index = 1; index < 7; index++) {
          var listFilter = []
          await Axios
          .get('http://localhost:8081/phones_specifications/'+index+'/specification')
          .then(response => (listFilter = response.data))   
          state.phoneSpecification.push(listFilter);
        }
        console.log('phoneSpecification con datos cargados')

        //Se obtienen todas las marcas
        await Axios
        .get('http://localhost:8081/brands/')
        .then(response => (state.brandList = response.data))
        
        console.log('brandList con datos cargados')

        //Se obtienen todos los tweeteros y los celulares de los que hablan por gama
        for (let id = 1; id < 4; id++)
        {
            await Axios 
            .get('http://localhost:8081/neo/getRelevantGamma/'+id)
            .then(response => (state.usersGamma[id-1] = response.data))
        }

        console.log(state.usersGamma[0])
        console.log(state.usersGamma[1])
        console.log(state.usersGamma[2])

        state.ready = 1
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
        */

      }catch(err){console.log("En get all all " + err)}
    }, 

    /*Funciones para vista SearchDevices*/
    getAll(state){
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

      state.evalSpecification = evalSpecification
      state.names = names
      state.imgList = imgList
      state.specData = specData
      state.dataSheet = dataSheet
      state.phonesDescription = phonesDescription
      state.topTen = topTen
    },


    /*Funciones para vista SearchSpecification*/
    getAllSpecification(state)
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
    filterBySpecification(state, specification_id)
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
    getBrands(state){
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
    

    /*Funciones para la vista TwittersForGamma*/
    getAllTwitters(state)
    {
        var gammaData = {
            phonesDescription: [],
            topTen:
            {
                topTenNames:[],
                topTenImgList:[],
                topTenSize:[],
                topTenSpecData: [],
            },
            others:
            {
                othersNames:[],
                othersImgList:[],
                othersSpecData: [], 
                othersSize:[],

            }
        }

        var users = []
        var phones = []

        let usersGamma = JSON.parse(JSON.stringify(state.usersGamma[2]))
        for(var userGamma of usersGamma) //Se piden los de gamma alta en primera instancia)
        {
            var user = 
            {
                name: "",
                followersCount: 0,
                urlProfile: "",
                screenName: "",
                urlPhoto: ""
            }

            user.name = userGamma.name
            user.followersCount = userGamma.followersCount
            user.urlProfile = userGamma.urlProfile
            user.screenName = userGamma.screenName
            user.urlPhoto = userGamma.urlPhoto

            users.push(user)


            for(let phone of userGamma.phones)
            {

                let phone_base =
                {
                    phoneId: 0,
                    model: "",
                    size: 0,
                    description: "",
                    image: "",
                    data_sheet: {},
                }

                phone_base.phoneId = phone.id
                phone_base.model = phone.model,
                phone_base.size = phone.size,
                phone_base.description = phone.phoneSQL.description
                phone_base.image = phone.phoneSQL.image,
                phone_base.data_sheet = phone.phoneSQL.data_sheet

                console.log(phone_base)

                if(phones.length == 0)
                {
                    phone_base.model += " Recomendado por: @" + userGamma.screenName
                    phones.push(phone_base)
                    break 
                }
                let repeated = 0;

                for(var i = 0; i < phones.length; i++)
                {
                    if( phone_base.phoneId == phones[i].phoneId)
                    {
                        repeated = 1
                        phones[i].model += " @" + userGamma.screenName
                    }
                }

                if(repeated != 1)
                {
                    phone_base.model += " Recomendado por: @" + userGamma.screenName
                    phones.push(phone_base)                
                }

            }
        }

        phones.sort(function(a, b){
            return b.size - a.size;
        }); 

        var index = 0

        for(var phone of phones)
        {
            var dataSheet = []
            dataSheet.push(phone.data_sheet.cpu)
            dataSheet.push(phone.data_sheet.ram)
            dataSheet.push(phone.data_sheet.operative_s)
            dataSheet.push(phone.data_sheet.dimensions)
            dataSheet.push(phone.data_sheet.front_cam)
            dataSheet.push(phone.data_sheet.back_cam)
            dataSheet.push(phone.data_sheet.screen)
            dataSheet.push(phone.data_sheet.storage)
            dataSheet.push(phone.data_sheet.batery)
            gammaData.phonesDescription.push(phone.description)
    
            if(index > 9){
                gammaData.others.othersSpecData.push(dataSheet);
                gammaData.others.othersNames.push(phone.model)
                gammaData.others.othersSize.push(phone.size)
                gammaData.others.othersImgList.push(phone.image)
            }
            else{
                gammaData.topTen.topTenSize.push(phone.size)
                gammaData.topTen.topTenNames.push(phone.model)
                gammaData.topTen.topTenImgList.push(phone.image)
                gammaData.topTen.topTenSpecData.push(dataSheet)
                index ++
            } 
        }

        state.gammaData = gammaData
        state.usersGammaData = users

        console.log(gammaData)

    },
    getTwittersByGamma(state,gamma)
    {
        var gammaData = {
            phonesDescription: [],
            topTen:
            {
                topTenNames:[],
                topTenImgList:[],
                topTenSize:[],
                topTenSpecData: [],
            },
            others:
            {
                othersNames:[],
                othersImgList:[],
                othersSpecData: [], 
                othersSize:[],

            }
        }

        var users = []
        var phones = []

        let usersGamma = JSON.parse(JSON.stringify(state.usersGamma[gamma-1]))
        for(var userGamma of usersGamma) //Se piden los de gamma alta en primera instancia)
        {
            var user = 
            {
                name: "",
                followersCount: 0,
                urlProfile: "",
                screenName: "",
                urlPhoto: ""
            }

            user.name = userGamma.name
            user.followersCount = userGamma.followersCount
            user.urlProfile = userGamma.urlProfile
            user.screenName = userGamma.screenName
            user.urlPhoto = userGamma.urlPhoto

            users.push(user)


            for(let phone of userGamma.phones)
            {

                let phone_base =
                {
                    phoneId: 0,
                    model: "",
                    size: 0,
                    description: "",
                    image: "",
                    data_sheet: {},
                }

                phone_base.phoneId = phone.id
                phone_base.model = phone.model,
                phone_base.size = phone.size,
                phone_base.description = phone.phoneSQL.description
                phone_base.image = phone.phoneSQL.image,
                phone_base.data_sheet = phone.phoneSQL.data_sheet

                console.log(phone_base)

                if(phones.length == 0)
                {
                    phone_base.model += " Recomendado por: @" + userGamma.screenName
                    phones.push(phone_base)
                    break 
                }
                let repeated = 0;

                for(var i = 0; i < phones.length; i++)
                {
                    if( phone_base.phoneId == phones[i].phoneId)
                    {
                        repeated = 1
                        phones[i].model += " @" + userGamma.screenName
                    }
                }

                if(repeated != 1)
                {
                    phone_base.model += " Recomendado por: @" + userGamma.screenName
                    phones.push(phone_base)                
                }

            }
        }

        phones.sort(function(a, b){
            return b.size - a.size;
        }); 

        var index = 0

        for(var phone of phones)
        {
            var dataSheet = []
            dataSheet.push(phone.data_sheet.cpu)
            dataSheet.push(phone.data_sheet.ram)
            dataSheet.push(phone.data_sheet.operative_s)
            dataSheet.push(phone.data_sheet.dimensions)
            dataSheet.push(phone.data_sheet.front_cam)
            dataSheet.push(phone.data_sheet.back_cam)
            dataSheet.push(phone.data_sheet.screen)
            dataSheet.push(phone.data_sheet.storage)
            dataSheet.push(phone.data_sheet.batery)
            gammaData.phonesDescription.push(phone.description)
    
            if(index > 9){
                gammaData.others.othersSpecData.push(dataSheet);
                gammaData.others.othersNames.push(phone.model)
                gammaData.others.othersSize.push(phone.size)
                gammaData.others.othersImgList.push(phone.image)
            }
            else{
                gammaData.topTen.topTenSize.push(phone.size)
                gammaData.topTen.topTenNames.push(phone.model)
                gammaData.topTen.topTenImgList.push(phone.image)
                gammaData.topTen.topTenSpecData.push(dataSheet)
                index ++
            } 
        }

        state.gammaData = gammaData
        state.usersGammaData = users

        console.log(gammaData)


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
    getAllTwitters(context){
        context.commit('getAllTwitters')
      },
  },
})
