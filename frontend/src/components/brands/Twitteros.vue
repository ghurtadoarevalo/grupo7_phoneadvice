<template>
    <v-container grid-list-xl pa-0 style="" >
        <v-layout row wrap style="margin-left:-15%; margin-right:-15%" mt-5 mb-3>
            <v-flex md12 pa-0 >
                <v-layout row wrap>
                    <v-flex  md2 pa-0 mr-0   v-for="(userGamma, index) in usersGamma" :key="index" style="margin-left:2.8%">
                        <v-card
                            color="#26c6da"
                            dark  
                            height="70%" 
                            min-width="100%"
                        >
                            <v-card-title style="padding:5%">
                                <twitter-icon
                                large
                                left/>
                                <span class="title font-weight-light ml-1 hide_80">{{userGamma.name}}</span>

                                <v-layout
                                align-center
                                justify-end
                                ma-1
                                >
                                <v-tooltip bottom>
                                <template v-slot:activator="{ on }">
                                    <v-icon v-on="on" class="mr-1">people</v-icon>
                                    <span  v-on="on" class="subheading mr-2">{{userGamma.followersCount}}</span>
                                </template>
                                <span>Seguidores</span>
                                </v-tooltip>
                                </v-layout>
                            </v-card-title> 

                            <v-card-actions>
                            <v-list-tile class="grow">
                                <v-list-tile-avatar color="grey darken-3" class="mb-3" size="60" style="margin-left:-15%">
                                <v-img
                                    class="elevation-6"
                                    :src=userGammaData.urlPhoto
                                ></v-img>
                                </v-list-tile-avatar>

                                <v-list-tile-content>
                                <v-list-tile-title class="ml-2 hide_100" style="margin-top:-18%">  
                                        <a :href= userGammaData.urlProfile>
                                            @{{userGamma.profile}}
                                        </a>         
                                    </v-list-tile-title>
                                </v-list-tile-content>

                                
                            </v-list-tile>
                            </v-card-actions>
                        </v-card>
                    </v-flex>
                </v-layout>
            </v-flex>
        </v-layout>   

    </v-container>

</template>

<style>

.hide_80
{
    width: 80px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

.hide_100
{
    width: 140px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

</style>


<script>
import TwitterIcon from "vue-material-design-icons/Twitter.vue"
import { mapState } from 'vuex';
  export default {
    components:{
      TwitterIcon,
    },
    data(){
      return{
        usersGamma: [
        [
            {
                id: 123,
                name: "Tato",
                followersCount: 123,
                urlProfile: "https://twitter.com/Leonmarlon98", 
                size: 123,
                profile: "The word-break 22222",
                urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                phones: [
                     {
                        "phoneId": 10,
                        "model": "Zenfone Pegasus 4A",
                        "description": "Un celular económico, pero que no se quedará atrás al ejecutar tus aplicaciones",
                        "image": "asus/zenfone_pegasus_4A",
                        "assessment": 60,
                        size: 123,
                        "data_sheet": {
                            "dataSheetId": 40,
                            "cpu": "ARM Cortex-A53 de cuatro núcleos",
                            "ram": "3GB",
                            "operative_s": "Android 7.0 Nougat",
                            "dimensions": "71.26x144.26x9.1mm",
                            "front_cam": "5 megapixeles",
                            "screen": "5 pulgadas",
                            "back_cam": "13 megapixeles",
                            "storage": "32GB",
                            "batery": "4100mAh"
                        },
                        "gamma": {
                            "gammaId": 1,
                            "name": "Baja",
                            "min_price": 150000,
                            "max_price": 0
                        },
                        "statistic": {
                            "statisticId": 10,
                            "positive_density": 425,
                            "neutral_density": 60,
                            "negative_density": 35
                        }
                    }

                ]
            },
            {
                id: 125,
                name: "PAdivice", 
                followersCount: 296, 
                urlProfile: "https://twitter.com/phoneAdivice", 
                size: 432,
                profile: "phoneAdivice",
                urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                phones: [
                    {
                        "phoneId": 10,
                        "model": "Zenfone Pegasus 4A",
                        "description": "Un celular económico, pero que no se quedará atrás al ejecutar tus aplicaciones",
                        "image": "asus/zenfone_pegasus_4A",
                        "assessment": 60,
                        size: 42,
                        "data_sheet": {
                            "dataSheetId": 40,
                            "cpu": "ARM Cortex-A53 de cuatro núcleos",
                            "ram": "3GB",
                            "operative_s": "Android 7.0 Nougat",
                            "dimensions": "71.26x144.26x9.1mm",
                            "front_cam": "5 megapixeles",
                            "screen": "5 pulgadas",
                            "back_cam": "13 megapixeles",
                            "storage": "32GB",
                            "batery": "4100mAh"
                        },
                        "gamma": {
                            "gammaId": 1,
                            "name": "Baja",
                            "min_price": 150000,
                            "max_price": 0
                        },
                        "statistic": {
                            "statisticId": 10,
                            "positive_density": 425,
                            "neutral_density": 60,
                            "negative_density": 35
                        }
                    }
                ]
            },
            {
                id: 225,
                name: "Pasdasd", 
                followersCount: 542, 
                urlProfile: "https://twitter.com/phoneAdivice", 
                size: 231,
                profile: "Pasdasd",
                urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                phones: [
                    {
                        "phoneId": 1,
                        "model": "Redmi GO",
                        "description": "Es pequeño, es potente, el nuevo Xiaomi Redmi Go es la primera apuesta del fabricante Chino con Android Go, pensado para equipos economicos pero sin sacrificar potencia.",
                        "image": "xiaomi/redmi_go",
                        "assessment": 51,
                        size: 324,
                        "data_sheet": {
                            "dataSheetId": 31,
                            "cpu": "Snapdragon 425 de 4 núcleos",
                            "ram": "1GB",
                            "operative_s": "Android 8.1 Oreo",
                            "dimensions": "140.4x70.1x8.4mm",
                            "front_cam": "5 megapixeles",
                            "screen": "5 pulgadas",
                            "back_cam": "8 megapixeles",
                            "storage": "8GB",
                            "batery": "3000mAh"
                        },
                        "gamma": {
                            "gammaId": 1,
                            "name": "Baja",
                            "min_price": 150000,
                            "max_price": 0
                        },
                        "statistic": {
                            "statisticId": 1,
                            "positive_density": 30,
                            "neutral_density": 0,
                            "negative_density": 0
                        }
                    },
                    {
                        "phoneId": 10,
                        "model": "Zenfone Pegasus 4A",
                        "description": "Un celular económico, pero que no se quedará atrás al ejecutar tus aplicaciones",
                        "image": "asus/zenfone_pegasus_4A",
                        "assessment": 60,
                        size: 42,
                        "data_sheet": {
                            "dataSheetId": 40,
                            "cpu": "ARM Cortex-A53 de cuatro núcleos",
                            "ram": "3GB",
                            "operative_s": "Android 7.0 Nougat",
                            "dimensions": "71.26x144.26x9.1mm",
                            "front_cam": "5 megapixeles",
                            "screen": "5 pulgadas",
                            "back_cam": "13 megapixeles",
                            "storage": "32GB",
                            "batery": "4100mAh"
                        },
                        "gamma": {
                            "gammaId": 1,
                            "name": "Baja",
                            "min_price": 150000,
                            "max_price": 0
                        },
                        "statistic": {
                            "statisticId": 10,
                            "positive_density": 425,
                            "neutral_density": 60,
                            "negative_density": 35
                        }
                    }
                ]
            },
            {
                id: 123,
                name: "Pedrito",
                followersCount: 543,
                urlProfile: "https://twitter.com/Leonmarlon98", 
                size: 123,
                profile: "Pedrito",
                urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                phones: [
                    {
                        "phoneId": 1,
                        "model": "Redmi GO",
                        "description": "Es pequeño, es potente, el nuevo Xiaomi Redmi Go es la primera apuesta del fabricante Chino con Android Go, pensado para equipos economicos pero sin sacrificar potencia.",
                        "image": "xiaomi/redmi_go",
                        "assessment": 51,
                        size: 342,
                        "data_sheet": {
                            "dataSheetId": 31,
                            "cpu": "Snapdragon 425 de 4 núcleos",
                            "ram": "1GB",
                            "operative_s": "Android 8.1 Oreo",
                            "dimensions": "140.4x70.1x8.4mm",
                            "front_cam": "5 megapixeles",
                            "screen": "5 pulgadas",
                            "back_cam": "8 megapixeles",
                            "storage": "8GB",
                            "batery": "3000mAh"
                        },
                        "gamma": {
                            "gammaId": 1,
                            "name": "Baja",
                            "min_price": 150000,
                            "max_price": 0
                        },
                        "statistic": {
                            "statisticId": 1,
                            "positive_density": 30,
                            "neutral_density": 0,
                            "negative_density": 0
                        }
                    },
                    {
                        "phoneId": 19,
                        "model": "Nokia 3.1",
                        "description": "Tu compañero de primera.Nokia 3.1 se ve y se siente superior. Llama la atención con sus sutiles curvas y sorprendentes lados de aluminio de corte de diamante. El nuevo Nokia 3 se siente cómodo en la mano gracias a una parte trasera curvada y una pantalla esculpida Corning® Gorilla® Glass.",
                        "image": "nokia/3_1",
                        "assessment": 50,
                        size: 76,
                        "data_sheet": {
                            "dataSheetId": 9,
                            "cpu": "Mediatek MT6750N de ocho núcleos",
                            "ram": "2GB",
                            "operative_s": "Android 8.0 Oreo",
                            "dimensions": "146.3x68.7x8.7mm",
                            "front_cam": "8 megapixeles",
                            "screen": "5.2 pulgadas",
                            "back_cam": "13 megapixeles",
                            "storage": "16GB",
                            "batery": "2990mAh"
                        },
                        "gamma": {
                            "gammaId": 1,
                            "name": "Baja",
                            "min_price": 150000,
                            "max_price": 0
                        },
                        "statistic": {
                            "statisticId": 19,
                            "positive_density": 18,
                            "neutral_density": 2,
                            "negative_density": 0
                        }
                    }
                ]
            },
            {
                id: 225,
                name: "Juanito", 
                followersCount: 65, 
                urlProfile: "https://twitter.com/phoneAdivice", 
                size: 231,
                profile: "Juanito",
                urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                phones: [
                    {
                        "phoneId": 19,
                        "model": "Nokia 3.1",
                        "description": "Tu compañero de primera.Nokia 3.1 se ve y se siente superior. Llama la atención con sus sutiles curvas y sorprendentes lados de aluminio de corte de diamante. El nuevo Nokia 3 se siente cómodo en la mano gracias a una parte trasera curvada y una pantalla esculpida Corning® Gorilla® Glass.",
                        "image": "nokia/3_1",
                        "assessment": 50,
                        size: 45,
                        "data_sheet": {
                            "dataSheetId": 9,
                            "cpu": "Mediatek MT6750N de ocho núcleos",
                            "ram": "2GB",
                            "operative_s": "Android 8.0 Oreo",
                            "dimensions": "146.3x68.7x8.7mm",
                            "front_cam": "8 megapixeles",
                            "screen": "5.2 pulgadas",
                            "back_cam": "13 megapixeles",
                            "storage": "16GB",
                            "batery": "2990mAh"
                        },
                        "gamma": {
                            "gammaId": 1,
                            "name": "Baja",
                            "min_price": 150000,
                            "max_price": 0
                        },
                        "statistic": {
                            "statisticId": 19,
                            "positive_density": 18,
                            "neutral_density": 2,
                            "negative_density": 0
                        }
                    },
                    {
                        "phoneId": 20,
                        "model": "Nokia 2.1",
                        "description": "Entretenimiento de larga duración. Accionado por una batería2 4000 mAh2, Nokia 2.1 se mantiene trabajando por dos días seguidos, así que puedes pasar menos tiempo en preocuparte por cargarlo y más tiempo haciendo lo que amas.",
                        "image": "nokia/2_1",
                        "assessment": 50,
                        size:1234,
                        "data_sheet": {
                            "dataSheetId": 10,
                            "cpu": "Snapdragon 425  de cuatro núcleos",
                            "ram": "1GB",
                            "operative_s": "Android 8.1 Oreo",
                            "dimensions": "153.7x77.7x9.4mm",
                            "front_cam": "5 megapixeles",
                            "screen": "5.5 pulgadas",
                            "back_cam": "8 megapixeles",
                            "storage": "8GB",
                            "batery": "4000mAh"
                        },
                        "gamma": {
                            "gammaId": 1,
                            "name": "Baja",
                            "min_price": 150000,
                            "max_price": 0
                        },
                        "statistic": {
                            "statisticId": 20,
                            "positive_density": 6,
                            "neutral_density": 0,
                            "negative_density": 0
                        }
                    },
                ]
            },
        ],
        [
            {
                id: 123,
                name: "Pedrito2",
                followersCount: 123,
                urlProfile: "https://twitter.com/Leonmarlon98", 
                size: 123,
                profile: "The word-break 22222",
                urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                phones: [
                    {   
                        "phoneId": 7,
                        "model": "Zenfone 5",
                        "description": "Diseñado para causar impresión, el ZenFone 5 está fabricado con materiales premium y técnicas de manufactura avanzadas. ",
                        "image": "asus/zenfone_5",
                        "assessment": 61,
                        size: 213,
                        "data_sheet": {
                            "dataSheetId": 37,
                            "cpu": "Snapdragon 636 de ocho núcleos",
                            "ram": "4GB",
                            "operative_s": "Android Oreo 8.0",
                            "dimensions": "153x75,7x7,9 mm",
                            "front_cam": "8 megapixeles",
                            "screen": "6.2 pulgadas",
                            "back_cam": "12 megapixeles",
                            "storage": "64GB",
                            "batery": "3300mAh"
                        },
                        "gamma": {
                            "gammaId": 2,
                            "name": "Media",
                            "min_price": 150001,
                            "max_price": 350000
                        },
                        "statistic": {
                            "statisticId": 7,
                            "positive_density": 746,
                            "neutral_density": 332,
                            "negative_density": 282
                        }
                    },
                ]
            },
            {
                id: 125,
                name: "PAdivice", 
                followersCount: 296, 
                urlProfile: "https://twitter.com/phoneAdivice", 
                size: 432,
                profile: "phoneAdivice",
                urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                phones: [
                    {
                        "phoneId": 25,
                        "model": "Q7",
                        "description": "Diseño elegante y equilibrado",
                        "image": "lg/q7",
                        "assessment": 50,
                        size: 154,
                        "data_sheet": {
                            "dataSheetId": 15,
                            "cpu": "Helio P10 de ocho núcleos",
                            "ram": "3GB",
                            "operative_s": "Android 8.1 Oreo",
                            "dimensions": "143.8 x 69.3 x 8.4mm",
                            "front_cam": "5 megapixeles",
                            "screen": "5.5 pulgadas",
                            "back_cam": "8 megapixeles",
                            "storage": "32GB",
                            "batery": "3000mAh"
                        },
                        "gamma": {
                            "gammaId": 2,
                            "name": "Media",
                            "min_price": 150001,
                            "max_price": 350000
                        },
                        "statistic": {
                            "statisticId": 5,
                            "positive_density": 28,
                            "neutral_density": 4,
                            "negative_density": 0
                        }
                    }
                ]
            },
            {
                id: 225,
                name: "Pasdasd", 
                followersCount: 542, 
                urlProfile: "https://twitter.com/phoneAdivice", 
                size: 231,
                profile: "Pasdasd",
                urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                phones: [
                    
                    {
                        "phoneId": 37,
                        "model": "Moto One",
                        "description": "Tu smartphone más inteligente. SEGURO, RÁPIDO Y CON MEJOR DESEMPEÑO",
                        "image": "motorola/moto_one",
                        "assessment": 50,
                        size: 678,
                        "data_sheet": {
                            "dataSheetId": 27,
                            "cpu": "Qualcomm Snapdragon 625 (MSM8953) (2000 MHz)",
                            "ram": "3 GB",
                            "operative_s": "Android 8.1 \"Oreo\"",
                            "dimensions": "72 x 149 x 8 mm ",
                            "front_cam": "Estándar 8.0 MP",
                            "screen": "LTPS IPS 5,9\" táctil (1520x720)",
                            "back_cam": "Estándar 13.0 MP + Percepción profundidad (Bokeh) 2.0 MP ",
                            "storage": "32 GB",
                            "batery": "3.000 mAh"
                        },
                        "gamma": {
                            "gammaId": 2,
                            "name": "Media",
                            "min_price": 150001,
                            "max_price": 350000
                        },
                        "statistic": {
                            "statisticId": 13,
                            "positive_density": 12,
                            "neutral_density": 0,
                            "negative_density": 0
                        }
                    },
                    
                    {
                        "phoneId": 39,
                        "model": "Moto G6",
                        "description": "Lo mejor del desempeño en tu smartphone. Tú no puedes parar, tu smartphone tampoco. Con el procesador octa-core de 1,8GHz y 3 GB de RAM ejecuta tus tareas y disfruta de tus videos y juegos con más agilidad además de tener 32GB de almacenamiento para tus fotos, música y videos.",
                        "image": "motorola/moto_g6",
                        "assessment": 50,
                        size: 456,
                        "data_sheet": {
                            "dataSheetId": 29,
                            "cpu": "Qualcomm Snapdragon 450 (1800 MHz)",
                            "ram": "3 GB",
                            "operative_s": "Android 8.0 \"Oreo\"",
                            "dimensions": "72 x 153 x 8 mm ",
                            "front_cam": "Estándar 8.0 MP",
                            "screen": "LCD IPS 5.7\" táctil (2160x1080)",
                            "back_cam": "Estándar 12.0 MP + Percepción profundidad (Bokeh) 5.0 MP ",
                            "storage": "32 GB",
                            "batery": "3000 mAh"
                        },
                        "gamma": {
                            "gammaId": 2,
                            "name": "Media",
                            "min_price": 150001,
                            "max_price": 350000
                        },
                        "statistic": {
                            "statisticId": 12,
                            "positive_density": 28,
                            "neutral_density": 4,
                            "negative_density": 0
                        }
                    }
                ]
            },
            {
                id: 123,
                name: "Pedrito",
                followersCount: 543,
                urlProfile: "https://twitter.com/Leonmarlon98", 
                size: 123,
                profile: "Pedrito",
                urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                phones: [
                    {
                        "phoneId": 6,
                        "model": "Zenfone Max Pro",
                        "description": "El ZenFone Max Pro es tu incansable compañero, siempre preparado para capturar los momentos especiales.",
                        "image": "asus/zenfone_max_pro",
                        "assessment": 46,
                        size: 78,
                        "data_sheet": {
                            "dataSheetId": 36,
                            "cpu": "Snapdragon 636 de ocho núcleos",
                            "ram": "4GB",
                            "operative_s": "Android One 8.1",
                            "dimensions": "159x76x8.4mm",
                            "front_cam": "8 megapixeles",
                            "screen": "6 pulgadas",
                            "back_cam": "13 megapixeles",
                            "storage": "64GB",
                            "batery": "5000mAh"
                        },
                        "gamma": {
                            "gammaId": 2,
                            "name": "Media",
                            "min_price": 150001,
                            "max_price": 350000
                        },
                        "statistic": {
                            "statisticId": 6,
                            "positive_density": 78,
                            "neutral_density": 30,
                            "negative_density": 10
                        }
                    }
                ]
            },
            {
                id: 225,
                name: "Juanito", 
                followersCount: 65, 
                urlProfile: "https://twitter.com/phoneAdivice", 
                size: 231,
                profile: "Juanito",
                urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                phones: [
                    {
                        "phoneId": 6,
                        "model": "Zenfone Max Pro",
                        "description": "El ZenFone Max Pro es tu incansable compañero, siempre preparado para capturar los momentos especiales.",
                        "image": "asus/zenfone_max_pro",
                        "assessment": 46,
                        size: 78,
                        "data_sheet": {
                            "dataSheetId": 36,
                            "cpu": "Snapdragon 636 de ocho núcleos",
                            "ram": "4GB",
                            "operative_s": "Android One 8.1",
                            "dimensions": "159x76x8.4mm",
                            "front_cam": "8 megapixeles",
                            "screen": "6 pulgadas",
                            "back_cam": "13 megapixeles",
                            "storage": "64GB",
                            "batery": "5000mAh"
                        },
                        "gamma": {
                            "gammaId": 2,
                            "name": "Media",
                            "min_price": 150001,
                            "max_price": 350000
                        },
                        "statistic": {
                            "statisticId": 6,
                            "positive_density": 78,
                            "neutral_density": 30,
                            "negative_density": 10
                        }
                    },
                    {
                        "phoneId": 14,
                        "model": "Galaxy A9",
                        "description": "Captura increíbles fotografías con el Galaxy A9, el primer Smartphone con cámara cuádruple. Sumérgete en su pantalla infinita de 6,3” y el envolvente sonido de Dolby Atmos. Su diseño elegante y ergonómico se sentirá perfecto en tus manos.",
                        "image": "samsung/galaxy_a9",
                        "assessment": 46,
                        size: 78,
                        "data_sheet": {
                            "dataSheetId": 4,
                            "cpu": "Qualcomm Snapdragon 660 (MSM8956) (2200 MHz)",
                            "ram": "6 GB",
                            "operative_s": "Android 8.0 \"Oreo\"",
                            "dimensions": "77 x 163 x 8 mm",
                            "front_cam": "Estándar 24.0 MP",
                            "screen": "Super AMOLED 6.3\" táctil (2220x1080)",
                            "back_cam": "Estándar 24.0 MP + Gran angular (Wide angle) 8.0 MP + Teleobjetivo (Zoom) 10.0 MP + Percepción profundidad (Bokeh) 5.0 MP",
                            "storage": "128 GB",
                            "batery": "3800 mAh"
                        },
                        "gamma": {
                            "gammaId": 2,
                            "name": "Media",
                            "min_price": 150001,
                            "max_price": 350000
                        },
                        "statistic": {
                            "statisticId": 14,
                            "positive_density": 75,
                            "neutral_density": 16,
                            "negative_density": 10
                        }
                    }
                ]
            },
        ],
        [
            {
                id: 123,
                name: "Tato",
                followersCount: 123,
                urlProfile: "https://twitter.com/Leonmarlon98", 
                size: 123,
                profile: "The word-break 22222",
                urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                phones: [
                    {
                        "phoneId": 11,
                        "model": "Galaxy s10",
                        "description": "El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.",
                        "image": "samsung/galaxy_s10",
                        "assessment": 98,
                        "size": 435,
                        "data_sheet": {
                            "dataSheetId": 1,
                            "cpu": "Samsung Exynos 9 Octa (9820) (2730 MHz)",
                            "ram": "8 GB",
                            "operative_s": "Android 9.0 \"Pie\"",
                            "dimensions": "70 x 150 x 8 mm",
                            "front_cam": "Estándar 10.0 MP",
                            "screen": "Dynamic AMOLED 6.1\" táctil (3040x1440)",
                            "back_cam": "Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP",
                            "storage": "128 GB",
                            "batery": "3400 mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 11,
                            "positive_density": 1485,
                            "neutral_density": 148,
                            "negative_density": 34
                        }
                    },
                    {
                        "phoneId": 27,
                        "model": "iPhone XR",
                        "description": "El iPhone XR tiene el LCD más avanzado en un smartphone",
                        "image": "apple/iphone_xr",
                        "assessment": 61,
                        size: 213,
                        "data_sheet": {
                            "dataSheetId": 17,
                            "cpu": "Super AMOLED 5.8\" táctil (1125x2436)",
                            "ram": "4 GB",
                            "operative_s": "iOS 12",
                            "dimensions": "72 x 149 x 8 mm ",
                            "front_cam": "Estándar 7.0 MP",
                            "screen": "Super AMOLED 5.8\" táctil (1125x2436)",
                            "back_cam": "Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP",
                            "storage": "64 GB",
                            "batery": "2658 mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 7,
                            "positive_density": 746,
                            "neutral_density": 332,
                            "negative_density": 282
                        }
                    },
                    {
                        "phoneId": 29,
                        "model": "iPhone 8 Plus",
                        "description": "El Apple iPhone 8 Plus conserva la misma pantalla de su antecesor, con 5.5 pulgadas a resolución Full HD",
                        "image": "apple/iphone_8_plus",
                        "assessment": 52,
                        size:13,
                        "data_sheet": {
                            "dataSheetId": 19,
                            "cpu": "Apple A11 Bionic (2500 MHz)",
                            "ram": "3 GB",
                            "operative_s": "iOS 11",
                            "dimensions": "78 x 158 x 7 mm ",
                            "front_cam": "Estándar 7.0 MP",
                            "screen": "LCD IPS 5.5\" táctil FullHD (1920x1080)",
                            "back_cam": "Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP",
                            "storage": "64 GB",
                            "batery": "2691  mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 9,
                            "positive_density": 195,
                            "neutral_density": 20,
                            "negative_density": 15
                        }
                    },
                    {
                        "phoneId": 21,
                        "model": "G7 ThinQ",
                        "description": "Sumérgete en la gran pantalla QHD+ FullVision de 6,1\", diseñada con precisión en el metal y el vidrio.",
                        "image": "lg/g7_thinq",
                        "assessment": 51,
                        size:123,
                        "data_sheet": {
                            "dataSheetId": 11,
                            "cpu": "Snapdragon 845 de ocho núcleos",
                            "ram": "4GB",
                            "operative_s": "Android Oreo",
                            "dimensions": "53.2x71.9x8.2mm",
                            "front_cam": "8 megapixeles",
                            "screen": "6.1 pulgadas",
                            "back_cam": "16 megapixeles",
                            "storage": "64GB",
                            "batery": "3000mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 1,
                            "positive_density": 30,
                            "neutral_density": 0,
                            "negative_density": 0
                        }
                    },
                ]
            },
            {
                id: 125,
                name: "PAdivice", 
                followersCount: 296, 
                urlProfile: "https://twitter.com/phoneAdivice", 
                size: 432,
                profile: "phoneAdivice",
                urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                phones: [
                    {
                        "phoneId": 34,
                        "model": "P30",
                        "description": "Más brillo, amplitud y cercania. Observa el mundo desde una nueva perspectiva. Descubre las sorpresas ocultas y conviértelas en tus recuerdos más preciados. El HUAWEI P30 redefine la fotografía en teléfonos inteligentes.",
                        "image": "huawei/p30",
                        "assessment": 61,
                        size: 542,
                        "data_sheet": {
                            "dataSheetId": 24,
                            "cpu": "HiSilicon Kirin 710 (2200 MHz)",
                            "ram": "2 GB",
                            "operative_s": "Android 9.0 \"Pie\"",
                            "dimensions": "72 x 152 x 7 mm",
                            "front_cam": "Estándar 32.0 MP",
                            "screen": "LCD IPS 6,2\" táctil (2312x1080)",
                            "back_cam": "Estándar 24.0 MP + Gran angular (Wide angle) 8.0 MP + Percepción profundidad (Bokeh) 2.0 MP",
                            "storage": "128 GB",
                            "batery": "3340 mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 7,
                            "positive_density": 746,
                            "neutral_density": 332,
                            "negative_density": 282
                        }
                    },
                    {
                        "phoneId": 26,
                        "model": "iPhone XS",
                        "description": "El iPhone XS tiene una pantalla Super Retina de 5,8 pulgadas con pan  eles OLED hechos a la medida para ofrecer un HDR con la mayor precisión de color de toda la industria, negros intensos y un brillo increíble",
                        "image": "apple/iphone_xs",
                        "assessment": 46,
                        size:123,
                        "data_sheet": {
                            "dataSheetId": 16,
                            "cpu": "Apple A11 Bionic (2500 MHz)",
                            "ram": "2 GB",
                            "operative_s": "iOS 11",
                            "dimensions": "67 x 138 x 7 mm ",
                            "front_cam": "Estándar 7.0 MP",
                            "screen": "LCD IPS 4.7\" táctil (1334x750)",
                            "back_cam": "Estándar 12.0 MP ",
                            "storage": "64 GB",
                            "batery": "1821 mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 6,
                            "positive_density": 78,
                            "neutral_density": 30,
                            "negative_density": 10
                        }
                    },
                    {
                        "phoneId": 28,
                        "model": "iPhone 8",
                        "description": " Está diseñado con el vidrio más resistente usado en un smartphone hasta ahora y tiene un borde de aluminio aeroespacial",
                        "image": "apple/iphone_8",
                        "assessment": 59,
                        size: 22,
                        "data_sheet": {
                            "dataSheetId": 18,
                            "cpu": "Apple A12 Bionic (2400 MHz)",
                            "ram": "4 GB",
                            "operative_s": "iOS 12",
                            "dimensions": "75 x 150 x 8 mm",
                            "front_cam": "Estándar 7.0 MP",
                            "screen": "LCD IPS 6.1\" táctil (1792x828)",
                            "back_cam": "Estándar 12.0 MP ",
                            "storage": "64 GB",
                            "batery": "2942 mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 8,
                            "positive_density": 304,
                            "neutral_density": 88,
                            "negative_density": 4
                        }
                    },
                    {
                        "phoneId": 9,
                        "model": "Zenfone 3",
                        "description": "El ZenFone 3 presume de un diseño ágil y exquisito inspirado en la belleza de la naturaleza. Es una obra de arte en metal y vidrio que captura el mundo con la máxima precisión. Un teléfono extraordinario para una vida menos ordinaria.",
                        "image": "asus/zenfone_3",
                        "assessment": 52,
                        size:12,
                        "data_sheet": {
                            "dataSheetId": 39,
                            "cpu": "Snapdragon 625 de ocho núcleos",
                            "ram": "3GB",
                            "operative_s": "Android Marshmallow 6.0.1",
                            "dimensions": "152.6x77.4x7.7mm",
                            "front_cam": "8 megapixeles",
                            "screen": "5.5 pulgadas",
                            "back_cam": "16 megapixeles",
                            "storage": "32GB",
                            "batery": "3000mAh"
                        },
                        "gamma": {
                            "gammaId": 2,
                            "name": "Media",
                            "min_price": 150001,
                            "max_price": 350000
                        },
                        "statistic": {
                            "statisticId": 9,
                            "positive_density": 195,
                            "neutral_density": 20,
                            "negative_density": 15
                        }
                    },
                    {
                        "phoneId": 27,
                        "model": "iPhone XR",
                        "description": "El iPhone XR tiene el LCD más avanzado en un smartphone",
                        "image": "apple/iphone_xr",
                        "assessment": 61,
                        size: 213,
                        "data_sheet": {
                            "dataSheetId": 17,
                            "cpu": "Super AMOLED 5.8\" táctil (1125x2436)",
                            "ram": "4 GB",
                            "operative_s": "iOS 12",
                            "dimensions": "72 x 149 x 8 mm ",
                            "front_cam": "Estándar 7.0 MP",
                            "screen": "Super AMOLED 5.8\" táctil (1125x2436)",
                            "back_cam": "Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP",
                            "storage": "64 GB",
                            "batery": "2658 mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 7,
                            "positive_density": 746,
                            "neutral_density": 332,
                            "negative_density": 282
                        }
                    },
                    {
                        "phoneId": 29,
                        "model": "iPhone 8 Plus",
                        "description": "El Apple iPhone 8 Plus conserva la misma pantalla de su antecesor, con 5.5 pulgadas a resolución Full HD",
                        "image": "apple/iphone_8_plus",
                        "assessment": 52,
                        size:13,
                        "data_sheet": {
                            "dataSheetId": 19,
                            "cpu": "Apple A11 Bionic (2500 MHz)",
                            "ram": "3 GB",
                            "operative_s": "iOS 11",
                            "dimensions": "78 x 158 x 7 mm ",
                            "front_cam": "Estándar 7.0 MP",
                            "screen": "LCD IPS 5.5\" táctil FullHD (1920x1080)",
                            "back_cam": "Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP",
                            "storage": "64 GB",
                            "batery": "2691  mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 9,
                            "positive_density": 195,
                            "neutral_density": 20,
                            "negative_density": 15
                        }
                    },
                    {
                        "phoneId": 21,
                        "model": "G7 ThinQ",
                        "description": "Sumérgete en la gran pantalla QHD+ FullVision de 6,1\", diseñada con precisión en el metal y el vidrio.",
                        "image": "lg/g7_thinq",
                        "assessment": 51,
                        size:123,
                        "data_sheet": {
                            "dataSheetId": 11,
                            "cpu": "Snapdragon 845 de ocho núcleos",
                            "ram": "4GB",
                            "operative_s": "Android Oreo",
                            "dimensions": "53.2x71.9x8.2mm",
                            "front_cam": "8 megapixeles",
                            "screen": "6.1 pulgadas",
                            "back_cam": "16 megapixeles",
                            "storage": "64GB",
                            "batery": "3000mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 1,
                            "positive_density": 30,
                            "neutral_density": 0,
                            "negative_density": 0
                        }
                    },
                ]
            },
            {
                id: 225,
                name: "Pasdasd", 
                followersCount: 542, 
                urlProfile: "https://twitter.com/phoneAdivice", 
                size: 231,
                profile: "Pasdasd",
                urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                phones: [
                    {
                        "phoneId": 34,
                        "model": "P30",
                        "description": "Más brillo, amplitud y cercania. Observa el mundo desde una nueva perspectiva. Descubre las sorpresas ocultas y conviértelas en tus recuerdos más preciados. El HUAWEI P30 redefine la fotografía en teléfonos inteligentes.",
                        "image": "huawei/p30",
                        "assessment": 61,
                        size: 475,
                        "data_sheet": {
                            "dataSheetId": 24,
                            "cpu": "HiSilicon Kirin 710 (2200 MHz)",
                            "ram": "2 GB",
                            "operative_s": "Android 9.0 \"Pie\"",
                            "dimensions": "72 x 152 x 7 mm",
                            "front_cam": "Estándar 32.0 MP",
                            "screen": "LCD IPS 6,2\" táctil (2312x1080)",
                            "back_cam": "Estándar 24.0 MP + Gran angular (Wide angle) 8.0 MP + Percepción profundidad (Bokeh) 2.0 MP",
                            "storage": "128 GB",
                            "batery": "3340 mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 7,
                            "positive_density": 746,
                            "neutral_density": 332,
                            "negative_density": 282
                        }
                    },
                    {
                        "phoneId": 30,
                        "model": "iPhone XS Max",
                        "description": "El Apple iPhone XS Max es el móvil de gama top de Apple de 2018",
                        "image": "apple/iphone_xs_max",
                        "assessment": 60,
                        size: 345,
                        "data_sheet": {
                            "dataSheetId": 20,
                            "cpu": "Apple A12 Bionic (2400 MHz)",
                            "ram": "4 GB",
                            "operative_s": "iOS 12",
                            "dimensions": "77 x 157 x 7 mm ",
                            "front_cam": "Estándar 7.0 MP",
                            "screen": "Super AMOLED 6.5\" táctil (1242x2688)",
                            "back_cam": "Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP ",
                            "storage": "64 GB",
                            "batery": "2658 mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 10,
                            "positive_density": 425,
                            "neutral_density": 60,
                            "negative_density": 35
                        }
                    }
                ]
            },
            {
                id: 123,
                name: "Pedrito",
                followersCount: 543,
                urlProfile: "https://twitter.com/Leonmarlon98", 
                size: 123,
                profile: "Pedrito",
                urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                phones: [
                    {
                        phoneId: 11,
                        model: "Galaxy s10",
                        description: "El resultado de 10 años siendo pioneros en dispositivos móviles, Galaxy S10. La nueva generación Galaxy ha llegado.",
                        image: "samsung/galaxy_s10",
                        assessment: 98,
                        size: 435,
                        data_sheet: {
                            dataSheetId: 1,
                            cpu: "Samsung Exynos 9 Octa (9820) (2730 MHz)",
                            ram: "8 GB",
                            operative_s: "Android 9.0 \"Pie\"",
                            dimensions: "70 x 150 x 8 mm",
                            front_cam: "Estándar 10.0 MP",
                            screen: "Dynamic AMOLED 6.1\" táctil (3040x1440)",
                            back_cam: "Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP + Gran angular (Wide angle) 16.0 MP",
                            storage: "128 GB",
                            batery: "3400 mAh"
                        },
                        gamma: {
                            gammaId: 3,
                            name: "Alta",
                            min_price: 350001,
                            max_price: 2000000
                        },
                        statistic: {
                            statisticId: 11,
                            positive_density: 1485,
                            neutral_density: 148,
                            negative_density: 34
                        }
                    },
                    {   
                        "phoneId": 21,
                        "model": "G7 ThinQ",
                        "description": "Sumérgete en la gran pantalla QHD+ FullVision de 6,1\", diseñada con precisión en el metal y el vidrio.",
                        "image": "lg/g7_thinq",
                        "assessment": 51,
                        size: 52,
                        "data_sheet": {
                            "dataSheetId": 11,
                            "cpu": "Snapdragon 845 de ocho núcleos",
                            "ram": "4GB",
                            "operative_s": "Android Oreo",
                            "dimensions": "53.2x71.9x8.2mm",
                            "front_cam": "8 megapixeles",
                            "screen": "6.1 pulgadas",
                            "back_cam": "16 megapixeles",
                            "storage": "64GB",
                            "batery": "3000mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 1,
                            "positive_density": 30,
                            "neutral_density": 0,
                            "negative_density": 0
                        }
                    },
                    {
                        "phoneId": 27,
                        "model": "iPhone XR",
                        "description": "El iPhone XR tiene el LCD más avanzado en un smartphone",
                        "image": "apple/iphone_xr",
                        "assessment": 61,
                        size: 213,
                        "data_sheet": {
                            "dataSheetId": 17,
                            "cpu": "Super AMOLED 5.8\" táctil (1125x2436)",
                            "ram": "4 GB",
                            "operative_s": "iOS 12",
                            "dimensions": "72 x 149 x 8 mm ",
                            "front_cam": "Estándar 7.0 MP",
                            "screen": "Super AMOLED 5.8\" táctil (1125x2436)",
                            "back_cam": "Estándar 12.0 MP + Teleobjetivo (Zoom) 12.0 MP",
                            "storage": "64 GB",
                            "batery": "2658 mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 7,
                            "positive_density": 746,
                            "neutral_density": 332,
                            "negative_density": 282
                        }
                    }
                ]
            },
            {
                id: 225,
                name: "Juanito", 
                followersCount: 65, 
                urlProfile: "https://twitter.com/phoneAdivice", 
                size: 231,
                profile: "Juanito",
                urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                phones: [
                    {
                        "phoneId": 2,
                        "model": "Mi Mix 3",
                        "description": "Una renovación hermosa para una familia de equipos fantastica.",
                        "image": "xiaomi/mi_mix_3",
                        "assessment": 50,
                        size: 12,
                        "data_sheet": {
                            "dataSheetId": 32,
                            "cpu": "Snapdragon 845 de ocho núcleos",
                            "ram": "6GB",
                            "operative_s": "Android 8.1 Oreo",
                            "dimensions": "157.89x74.69x8.46 mm",
                            "front_cam": "24 megapixeles",
                            "screen": "6.39 pulgadas",
                            "back_cam": "12 megapixeles",
                            "storage": "128GB",
                            "batery": "3200mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 2,
                            "positive_density": 5,
                            "neutral_density": 0,
                            "negative_density": 0
                        }
                    },
                    {
                        "phoneId": 3,
                        "model": "Mi 9",
                        "description": "Xiaomi se adelanta a todo el mundo y antes del lanzamiento del Samsung S10, presenta su nuevo buque de Guerra.",
                        "image": "xiaomi/mi_9",
                        "assessment": 50,
                        size: 124,
                        "data_sheet": {
                            "dataSheetId": 33,
                            "cpu": "Snapdragon 855 de ocho núcleos",
                            "ram": "6GB",
                            "operative_s": "Android 9 Pie",
                            "dimensions": "157.7x74.67x7.61mm",
                            "front_cam": "20 megapixeles",
                            "screen": "6.39 pulgadas",
                            "back_cam": "48 megapixeles",
                            "storage": "128GB",
                            "batery": "3300mAh"
                        },
                        "gamma": {
                            "gammaId": 3,
                            "name": "Alta",
                            "min_price": 350001,
                            "max_price": 2000000
                        },
                        "statistic": {
                            "statisticId": 3,
                            "positive_density": 12,
                            "neutral_density": 1,
                            "negative_density": 0
                        }
                    }
                ]
            },
        ]
    ]
    
      }
    },
    computed:
    {
        //...mapState(['usersGammaData'])
    }
  }
</script>