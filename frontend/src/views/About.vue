<template>
  <div class="about">
    <highcharts :options="chartOptions"></highcharts>
  </div>
</template>

<script>

export default {
  data(){
      return{ 
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
    }
  }
  
}
</script>