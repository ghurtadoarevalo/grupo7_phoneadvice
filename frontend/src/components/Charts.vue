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
        
        <v-switch v-model="baja" label="Baja" color="#0E318A"></v-switch>
        <v-switch v-model="media" label="Media" color="#0E318A"></v-switch>
        <v-switch v-model="alta" label="Alta" color="#0E318A"></v-switch>
    
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>

export default {
  data :() => ({
    baja: true,
    media: true,
    alta: true,
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
        categories: ['Huawei p30 Pro ', 'Samsung A5 ', 'Iphone X ', 'Huawei mate 20 Pro ',
        ' Xiaomi redmi note 7 ', 'Motorola moto z3 play ', 'LG g7 Thinq ', 'Samsung Galaxy s10 ',],
        title: {
          text: 'Celulares'
        }
      },
      yAxis:{
        title: {
          text: 'Numero de Tweets'
        }

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

  })
  
}
</script>