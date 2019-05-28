<template>
  <v-container grid-list-xs>

    <v-layout row wrap style="margin-top:-5%;" md10 >
        <v-flex xs4 md1 style="margin-right:5%;" v-for="(equipo, index) in listaEquipos" :key="index" >
            <v-btn flat color="rgb(14, 49, 138)" class="">
                <v-icon large>{{equipo.icon}}</v-icon>
                <span>{{equipo.nombre}}</span>
            </v-btn>
        </v-flex>
    </v-layout>
    
    <v-layout row wrap>

      <v-flex md10 xs12>
        <highcharts :options="chartOptions"></highcharts>
      </v-flex>
      <v-flex md2>
        <v-flex>
          <VBtn fab dark color="#0E318A" @click="allGamma">
            <v-icon large color="white">monetization_on</v-icon>
          </VBtn> Gama
        </v-flex> 
        <v-flex> 
          <v-switch v-model="baja" label="Baja" color="#0E318A"></v-switch>
          <v-switch v-model="media" label="Media" color="#0E318A"></v-switch>
          <v-switch v-model="alta" label="Alta" color="#0E318A"></v-switch>
        </v-flex>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>

export default {
  methods: {
    allGamma(){
      this.baja = true;
      this.media = true;
      this.alta = true;
      }
    },
  data () {
    return{
      baja: true,
      media: true,
      alta: true,
      listaEquipos: [
        {id:1,nombre:'Batería',icon:'battery_charging_full'},
        {id:2,nombre:'Pantalla',icon:'stay_current_portrait'},
        {id:3,nombre:'Cámara',icon:'camera_alt'},
        {id:4,nombre:'Capacidad',icon:'sd_storage'},
        {id:5,nombre:'Diseño',icon:'brush'},
        {id:6,nombre:'Rendimiento',icon:'trending_up'},
      ],
      chartOptions: {
        chart: {
          //styledMode: true,
          renderTo: 'cointainer',
          type: 'column'
        },
        title: {
          text: '.'
        },
        xAxis: {
          categories: ['Huawei p30 Pro ', 'Samsung A5 ', 'Iphone X ', 'Huawei mate 20 Pro ',
          ' Xiaomi redmi note 7 ', 'Motorola moto z3 play ', 'LG g7 Thinq ', 'Samsung Galaxy s10 ',],
    
        },
        yAxis:{
          title: {
            text: 'Numero de Tweets'
          }

        },
        legend: {
          align: 'top',
          verticalAlign: 'top',
          layout: 'horizontal',
          x: 0,
          y: 0
        },
        plotOptions: {
          column:{
            borderRadius: 5
          },
          series: {
              //stacking: 'normal'
          }
        },
        series: [
          {
          data: [9,12,4,10,8,12,15,11],
          name:'Evaluación Positiva',
          color: '#90ed7d'
          },
          {
          data:[2,5,8,1,6,10,3,11],
          name:'Evaluación Negativa',
          color: 'Red'
        }]
      }
    }
  }
  
}
</script>