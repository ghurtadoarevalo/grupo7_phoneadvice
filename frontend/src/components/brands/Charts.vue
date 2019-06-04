
<template>
  <v-container grid-list-xl>
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
    ...mapState(['evalP','evalN','evalNeutral','evalBrand','listaMarcas','brandNames']),
  },
  methods: {
    ...mapMutations(['filterByGama']), 
    allGamma(){
      this.gamas = [true,true,true]
      this.filterByGama(this.gamas);

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
          text: 'Evaluación de Marcas',
          x:0,
          y:7
        },
        xAxis: {
          categories: this.brandNames,
    
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
          data: this.evalBrand,
          name:'Evaluación de marcas',
          color: 'Blue'
          },
          {
          data: this.evalP,
          visible: false,
          name:'Comentarios Positivos',
          color: '#90ed7d'
          },
          {
          data: this.evalNeutral,
          visible: false,
          name:'Comentarios Neutrales',
          color: 'Grey'
          }, 
          {
          data: this.evalN,
          visible: false,
          name:'Comentarios Negativos',
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
    }
  }
  
}
</script>