import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    activo: 'graph',
    evalP: [9,12,4,10,8,12,15,11],
    evalPP:[],
    listaEquipos: [
      {id:1,nombre:'Huawei p30 Pro',img:'http://www.carphonewarehouse.ie/CPW/media/products/Huawei/huawei-p30-pro-black-front.png?ext=.png',evalP:1},
      {id:2,nombre:'Samsung A5',img:'https://api.themrphone.com/imgprocess/?url=https://api.themrphone.com/mrphone/images/8038/1.jpg&w=150',evalP:5},
      {id:3,nombre:'Iphone X',img:'https://www.att.com/es-us//catalog/en/idse/Apple/Apple%20iPhone%20X/Space%20Gray-hero-zoom.png',evalP:4},
      {id:4,nombre:'Huawei mate 20 Pro',img:'https://wmstatic.global.ssl.fastly.net/ml/1250119-f-8a718ef4-98d4-4083-aa26-44cf24c08c5b.jpg?width=210&height=320',evalP:1},
      {id:5,nombre:'Xiaomi redmi note 7',img:'https://www.movilzona.es/app/uploads/2019/01/redmi-note-7-300.png',evalP:2},
      {id:6,nombre:'Motorola moto z3 play',img:'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6246/6246960_sd.jpg',evalP:1},
      {id:7,nombre:'LG g7 Thinq',img:'https://www.ukunlocks.com/wp-content/uploads/2018/03/unlock-lg-g7-thinq-orange.png',evalP:1},
      {id:8,nombre:'Samsung Galaxy s10',img:'https://www.att.com/catalog/en/idse/Samsung/Samsung%20Galaxy%20S10/Prism%20Black-hero-zoom.png',evalP:1}
    ]
  },
  mutations: {
    changeActive(state, newStatus){
      state.activo = newStatus
    },
    getEval(state){
      for(var item of state.listaEquipos ){
        console.log(item.nombre)
        state.evalPP.push(item.evalP)
      }
    }

  },
  actions: {
    getEval (context){
      context.commit('getEval')
    }

  }
})
