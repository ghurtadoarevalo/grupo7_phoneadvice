
<template>
  <v-container grid-list-xl>
    <v-layout row wrap>
      <v-flex md11 style="margin-left:-5%">
        <highcharts :options="getData()"></highcharts>
      </v-flex>

    <v-flex md1>      
      <VBtn fab dark color="#0E318A">
        <v-icon large color="white">monetization_on</v-icon>
      </VBtn>
      Gama
      <v-radio-group :disabled="disabled" v-model="column" column @change="getTwittersByGamma(column)">
        <v-radio  value="1" label="Baja"  color="#0E318A"></v-radio>          
        <v-radio  value="2" label="Media" color="#0E318A"></v-radio>          
        <v-radio  value="3" label="Alta" color="#0E318A"></v-radio>   
      </v-radio-group>       
    </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import { mapState,mapMutations, Store } from 'vuex';


export default {
  name: 'Charts',
  computed:{
    ...mapState(['gammaData']),
  },
  methods: {
    ...mapMutations(['getTwittersByGamma','usersGamma']), 
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
          text: 'Celulares según el top 5 de twitteros más populares',
          x:0,
          y:7
        },
        xAxis: {
          categories: this.gammaData.topTen.topTenNames,
    
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
          series: {
              //stacking: 'normal'
          }
        },
        series: [
          {
          data: this.gammaData.topTen.topTenSize,
          name:'Peso de celulares',
          color: 'orange'
          },]
      }
      return chartOptions;
    },
  },
  data () {
    return{
      column: "3",
      gamas: [true,true,true],
      disabled: false

    }
  },
  watch: {
    usersGamma: function(){
      if(this.usersGamma.length>0 && this.disabled)
        this.disabled = false
    }
  },
 
  
}
</script>