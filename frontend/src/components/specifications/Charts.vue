<template>
  <v-container grid-list-xs>

    <v-layout row wrap style="margin-top:-5%;" md10 >
        <v-flex xs4 md1 style="margin-right:5%;" v-for="(specification, index) in specificationsList" :key="index" >
            <v-btn flat color="rgb(14, 49, 138)" class="">
                <v-icon @click="filterBySpecification(specification.id)" large>{{specification.icon}}</v-icon>
                <span>{{specification.name}}</span>
            </v-btn>
        </v-flex>
    </v-layout>
    <v-layout row wrap>
      <v-flex md10>
        <highcharts :options="getData()"></highcharts>
      </v-flex>
      <v-flex md2>
        <VBtn fab dark color="#0E318A" @click="allGamma">
          <v-icon large color="white">monetization_on</v-icon>
        </VBtn> Gama
        
        <v-switch v-model="gamas[0]" @change="filterByGama(gamas)" label="Baja"  color="#0E318A"></v-switch>
        <v-switch v-model="gamas[1]" @change="filterByGama(gamas)" label="Media" color="#0E318A"></v-switch>
        <v-switch v-model="gamas[2]" @change="filterByGama(gamas)" label="Alta" color="#0E318A"></v-switch>
    
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import { mapState,mapMutations, Store } from 'vuex';

export default {
  name: 'Charts',
  computed:{
    ...mapState(['evalP','evalN','listaEquipos','names']),
  },
  methods: {
    ...mapMutations(['filterByGama','filterBySpecification']),
    allGamma(){
      this.gamas = [true,true,true]
      this.filterByGama(this.gamas);
    },
    getData(){
      var chartOptions = {
        chart: {
          //styledMode: true,
          renderTo: 'cointainer',
          type: 'column'
        },
        title: {
          text: 'Evaluación de Celulares'
        },
        xAxis: {
          categories: this.names,
    
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
            borderRadius: 4
          },
          series: {
              //stacking: 'normal'
          }
        },
        series: [
          {
          data: this.evalP,
          name:'Evaluación Positiva',
          color: '#90ed7d'
          },
          {
          data: this.evalN,
          name:'Evaluación Negativa',
          color: 'Red'
        }]
      }
      return chartOptions;
    },
  },
  /*mounted(){
    this.$store.dispatch('getAll')
  },*/
  data () {
    return{
      gamas: [true,true,true],
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