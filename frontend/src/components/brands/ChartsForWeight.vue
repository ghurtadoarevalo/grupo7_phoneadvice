<template>
  <v-container grid-list-xl>
    <v-layout row wrap>
      <v-flex md12>
        <highcharts :options="getData()"></highcharts>
      </v-flex>
      
    </v-layout>
  </v-container>
</template>

<script>
import { mapState,mapMutations, Store } from 'vuex';

export default {
  name: 'Charts',
  computed:{
    ...mapState(['brandData']),
  },
  methods: {
    ...mapMutations(['filterByGama']), 

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
          categories: this.brandData.brandNames,
    
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
          data: this.brandData.evalBrand,
          name:'Evaluación de marcas',
          color: 'orange'
          },
          {
          data: this.brandData.evalP,
          visible: false,
          name:'Comentarios Positivos',
          color: '#90ed7d'
          },
          {
          data: this.brandData.evalNeutral,
          visible: false,
          name:'Comentarios Neutrales',
          color: 'Grey'
          }, 
          {
          data: this.brandData.evalN,
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