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
import TwitterIcon from "vue-material-design-icons/Twitter.vue"



  export default {
    name: 'Charts1',
    components:{
      TwitterIcon,
    },
    computed:{
    //...mapState([]),
    },

    methods:{
      //...mapMutations([]),

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
          
          renderTo: 'cointainer',
          type: 'column'
        },
        title: {
          text: 'Evaluación de Celulares por Peso',
          x:0,
          y:7
        },
        xAxis: {
          categories: ['Cel1', 'Cel2', 'Cel3', 'Cel4', 'Cel5', 'Cel6', 'Cel7'],
    
        },
        yAxis:{
          title: {
            text: 'Peso'
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
        },
        series: [
          {
          data: [1,2,3,4,5,6,7],
          name:'Evaluación de marcas',
          color: 'orange'
          }]
      }
      return chartOptions;
      }

    },
    
    data(){
			
    }
  }
</script>