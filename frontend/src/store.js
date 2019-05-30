
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
      {id:1,name:'Huawei p30 Pro',        evalP:9,  evalN:2,  gama:2,img:'http://www.carphonewarehouse.ie/CPW/media/products/Huawei/huawei-p30-pro-black-front.png?ext=.png'},
      {id:2,name:'Samsung A5',            evalP:12, evalN:5,  gama:2,img:'https://api.themrphone.com/imgprocess/?url=https://api.themrphone.com/mrphone/images/8038/1.jpg&w=150'},
      {id:3,name:'Iphone X',              evalP:4,  evalN:8,  gama:2,img:'https://www.att.com/es-us//catalog/en/idse/Apple/Apple%20iPhone%20X/Space%20Gray-hero-zoom.png'},
      {id:4,name:'Huawei mate 20 Pro',    evalP:10, evalN:1,  gama:1,img:'https://wmstatic.global.ssl.fastly.net/ml/1250119-f-8a718ef4-98d4-4083-aa26-44cf24c08c5b.jpg?width=210&height=320'},
      {id:5,name:'Xiaomi redmi note 7',   evalP:8,  evalN:6,  gama:0,img:'https://www.movilzona.es/app/uploads/2019/01/redmi-note-7-300.png'},
      {id:6,name:'Motorola moto z3 play', evalP:12, evalN:10, gama:1,img:'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6246/6246960_sd.jpg'},
      {id:7,name:'LG g7 Thinq',           evalP:15, evalN:3,  gama:0,img:'https://www.ukunlocks.com/wp-content/uploads/2018/03/unlock-lg-g7-thinq-orange.png'},
      {id:8,name:'Samsung Galaxy s10',    evalP:11, evalN:11, gama:2,img:'https://www.att.com/catalog/en/idse/Samsung/Samsung%20Galaxy%20S10/Prism%20Black-hero-zoom.png'}
    ]
  },
  mutations: {
    //Button bar
    changeActive(state, newStatus){
      state.active = newStatus,
      console.log(newStatus)

    },
    resetActive(state)
    {
        state.active = 'graph'
    },
    filterBySpecification(state)
    {

    },
    //Devices Evaluation
    getAll(state){
      var evalP = []
      var evalN = []
      var names = []
      var imgList = []

      for(var item of state.listaEquipos ){
        evalP.push(item.evalP)
        evalN.push(item.evalN)
        names.push(item.name)
        imgList.push(item.img)
      }

      state.evalP = evalP
      state.evalN = evalN
      state.names = names
      state.imgList = imgList
    },
    filterByGama(state,gamas){
      var evalP = []
      var evalN = []
      var names = []
      var imgList = []
      
      for(var item of state.listaEquipos ){
        if(gamas[item.gama]){
          evalP.push(item.evalP)
          evalN.push(item.evalN)
          names.push(item.name)
          imgList.push(item.img)
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
