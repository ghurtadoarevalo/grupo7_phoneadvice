<template>
  <v-container grid-list-xl>
    <v-layout row wrap class="lista" style="margin-top:-5%; margin-left:6.5%">
      <v-flex class="ml-3" xs12 md1 v-for="(equipo, index) in listaEquipos" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='equipo.img'>
          </v-img>
      </v-flex>
    </v-layout>
    <v-dialog v-model="dialog" width="500">
      <v-card>
        <VCardTitle>
          {{listaEquipos[indice].nombre}}
        </VCardTitle>
        <v-card-text>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium, repellendus!
        </v-card-text>
        <VDivider/>
        <v-card-actions>
          <v-btn dark color="#0E318A" @click="dialog=false">Cerrar</v-btn>
        </v-card-actions>
      </v-card>
      
    </v-dialog>
  </v-container>
</template>

<script>
  export default {
    data() {
        return{
        dialog:false,
        indice:0,
        listaEquipos: [
          {id:1,nombre:'Huawei p30 Pro',img:'http://www.carphonewarehouse.ie/CPW/media/products/Huawei/huawei-p30-pro-black-front.png?ext=.png'},
          {id:2,nombre:'Samsung A5',img:'https://api.themrphone.com/imgprocess/?url=https://api.themrphone.com/mrphone/images/8038/1.jpg&w=150'},
          {id:3,nombre:'Iphone X',img:'https://www.att.com/es-us//catalog/en/idse/Apple/Apple%20iPhone%20X/Space%20Gray-hero-zoom.png'},
          {id:4,nombre:'Huawei mate 20 Pro',img:'https://wmstatic.global.ssl.fastly.net/ml/1250119-f-8a718ef4-98d4-4083-aa26-44cf24c08c5b.jpg?width=210&height=320'},
          {id:5,nombre:'Xiaomi redmi note 7',img:'https://www.movilzona.es/app/uploads/2019/01/redmi-note-7-300.png'},
          {id:6,nombre:'Motorola moto z3 play',img:'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6246/6246960_sd.jpg'},
          {id:7,nombre:'LG g7 Thinq',img:'https://www.ukunlocks.com/wp-content/uploads/2018/03/unlock-lg-g7-thinq-orange.png'},
          {id:8,nombre:'Samsung Galaxy s10',img:'https://www.att.com/catalog/en/idse/Samsung/Samsung%20Galaxy%20S10/Prism%20Black-hero-zoom.png'}
        ]
      }
    }
  }
</script>

<style>
.imagen { cursor: pointer; }
</style>