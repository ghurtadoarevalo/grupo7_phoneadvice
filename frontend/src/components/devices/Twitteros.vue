<template>
    <v-container grid-list-xl>
    <v-layout row wrap>
      <v-flex md11 style="margin-left:-5%">
        <highcharts :options="getData()"></highcharts>
      </v-flex>

    <v-flex md1>      
      <VBtn fab dark color="#0E318A" @click="allGamma">
        <v-icon large color="white">monetization_on</v-icon>
      </VBtn>
      Gama
      <v-switch v-model="gamas[0]" @change="filterPhoneTwitters(gamas)" label="Baja"  color="#0E318A"></v-switch>          
      <v-switch v-model="gamas[1]" @change="filterPhoneTwitters(gamas)" label="Media" color="#0E318A"></v-switch>          
      <v-switch v-model="gamas[2]" @change="filterPhoneTwitters(gamas)" label="Alta" color="#0E318A"></v-switch>          
    </v-flex>
    </v-layout>
  </v-container>   
</template>

<script>
import { mapState,mapMutations, Store } from 'vuex'
import TwitterIcon from "vue-material-design-icons/Twitter.vue"
  export default {
    name: 'Charts',
    computed:{
      //...mapState([]),
    },
    components:{
      TwitterIcon,
    },
    methods:{
      ...mapMutations(['filterPhoneTwitters']),
      allGamma(){
      this.gamas = [true,true,true]
      this.filterPhoneTwitters(this.gamas);

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
            text: 'Evaluación celulares según peso',
            x:0,
            y:7
            },
            xAxis: {
            categories: this.neoPhonesData.topTen.topTenNames,
        
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
            data: this.neoPhonesData.topTen.topTenSize,
            name:'Peso de celulares',
            color: 'orange'
            },]
        }
        return chartOptions;
        },
    },
    data(){
			return{
			gamas:[true,true,true]
			}
    },
        computed:
    {
        ...mapState(['neoPhonesData'])
    }
  }
</script>