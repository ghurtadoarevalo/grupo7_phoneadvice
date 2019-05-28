<template>
  <v-container grid-list-xl>
    <v-layout row wrap>
      <v-flex md10>
        <highcharts :options="chartOptions"></highcharts>
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
    ...mapState(['evalP']),
  },
  methods: {
    ...mapMutations(['filterByGama']),
    allGamma(){
      this.gamas = [true,true,true]
    },
    hola(){
      //this.$store.dispatch('get')
    },
  },
    mounted(){
    this.$store.dispatch('getAll')

  },
  data () {
    return{
      gamas: [true,true,true],
      chartOptions: {
        chart: {
          //styledMode: true,
          renderTo: 'cointainer',
          type: 'column'
        },
        title: {
          text: 'Evaluación de Celulares'
        },
        xAxis: {
          categories: this.$store.state.names,
    
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
          data: this.$store.state.evalP,
          name:'Evaluación Positiva',
          color: '#90ed7d'
          },
          {
          data: this.$store.state.evalN,
          name:'Evaluación Negativa',
          color: 'Red'
        }]
      }
    }
  }
  
}
</script>