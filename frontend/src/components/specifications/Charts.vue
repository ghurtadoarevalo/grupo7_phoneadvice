<template>
  <v-container grid-list-xs>
    <v-layout row wrap style="margin-top:-7%;" md12 >
        <v-flex xs4 md1 style="margin-right:8%;" v-for="(specification, index) in specificationsList" :key="index" >
            <v-btn round  @click="filterBySpecification(specification.id), gammas = [true,true,true]" flat color="rgb(14, 49, 138)" class="">
                <v-icon large>{{specification.icon}}</v-icon>
                <span>{{specification.name}}</span>
            </v-btn>
        </v-flex>
    </v-layout>

    <v-layout row wrap>
      <v-flex md11 style="margin-left:-5%">
        <highcharts :options="getData()"></highcharts>
      </v-flex> 

      <v-flex md1>      
        <VBtn fab dark color="#0E318A" @click="allGamma">
          <v-icon large color="white">monetization_on</v-icon>
        </VBtn> 
        <br>Gama
        <v-switch v-model="gammas[0]" @change="filterByGammaSpecification(gammas)" label="Baja"  color="#0E318A"></v-switch>
        <v-switch v-model="gammas[1]" @change="filterByGammaSpecification(gammas)" label="Media" color="#0E318A"></v-switch>        
        <v-switch v-model="gammas[2]" @change="filterByGammaSpecification(gammas)" label="Alta" color="#0E318A"></v-switch>        
      </v-flex>
         
    </v-layout>
  </v-container>
</template>

<script>
import { mapState,mapMutations, Store } from 'vuex';

export default {
  name: 'Charts',
  computed:{
    ...mapState(['evalP','evalN','evalNeutral','evalSpecification','names','activeSpecification','topTen']),
  },
  methods: {
    ...mapMutations(['filterByGammaSpecification','filterBySpecification']),
    allGamma(){
      this.gammas = [true,true,true]
      this.filterByGammaSpecification(this.gammas);
    },
    getData(){
      var chartOptions = {

        responsive: {
        rules: [{
            condition: {
            maxWidth: 500
            },
            chartOptions: {
            legend: {
                enabled: false
            }
            }
        }]
        },
        chart: {
          //styledMode: true,
          renderTo: 'cointainer',
          type: 'column'
        },
        title: {
          text: 'Evaluación por especificación: ' + this.activeSpecification,
          x:0,
          y:7
        },
        xAxis: {
          categories: this.topTen.topTenNames,
    
        },
        yAxis:{
          title: {
                text: 'Nota / Numero de Tweets'
          }

        },
        legend: {
          align: 'top',
          verticalAlign: 'top',
          layout: 'horizontal',
          x: 100,
          y: 20
        },
        plotOptions: {
          column:{
            borderRadius: 4
          },
          series: {
              //stacking: 'normal'
          }
        },
        series: [
          {
          data: this.topTen.topTenEvalSpecification,
          name:'Evaluación de ' + this.activeSpecification,
          color: 'orange'
          },
          {
          data: this.topTen.topTenEvalP,
          visible: false,
          name:'Comentarios Positivos',
          color: '#90ed7d'
          },
          {
          data: this.topTen.topTenEvalNeutral,
          visible: false,
          name:'Comentarios Neutrales',
          color: 'Grey'
          }, 
          {
          data: this.topTen.topTenEvalN,
          visible: false,
          name:'Comentarios Negativos',
          color: 'Red'
          }
        ]
      }
      return chartOptions;
    },
  },
  /*mounted(){
    this.$store.dispatch('getAll')
  },*/
  data () {
    return{
      gammas: [true,true,true],
      specificationsList: [
          {id:1,name:'Batería',icon:'battery_charging_full'},
          {id:2,name:'Pantalla',icon:'stay_current_portrait'},
          {id:3,name:'Cámara',icon:'camera_alt'},
          {id:4,name:'Capacidad',icon:'sd_storage'},
          {id:5,name:'Diseño',icon:'brush'},
          {id:6,name:'Rendimiento',icon:'trending_up'},
        ],
      
    }
  }
  
}
</script>