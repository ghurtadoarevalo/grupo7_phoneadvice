<template>
    <v-container grid-list-xl pa-0 style="" >
        <v-layout row wrap style="margin-left:-15%; margin-right:-15%" mt-5 mb-3>
            <v-flex md12 pa-0 >
                <v-layout row wrap>
                    <v-flex  md2 pa-0 mr-0 v-for="(aux, index) in listaaux" :key="index" style="margin-left:2.8%">
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
                                <span class="title font-weight-light ml-1 hide_80">{{usersGammaData[index].name}}</span>

                                <v-layout
                                align-center
                                justify-end
                                ma-1
                                >
                                <v-tooltip bottom>
                                <template v-slot:activator="{ on }">
                                    <v-icon v-on="on" class="mr-1">people</v-icon>
                                    <span  v-on="on" class="subheading mr-2">{{usersGammaData[index].followersCount}}</span>
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
                                    :src=usersGammaData[index].urlPhoto
                                ></v-img>
                                </v-list-tile-avatar>

                                <v-list-tile-content>
                                <v-list-tile-title class="ml-2 hide_100" style="margin-top:-18%">  
                                        <a :href= usersGammaData[index].urlProfile>
                                            @{{usersGammaData[index].profile}}
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
            listaaux:[1,2,3,4,5],
            tweeters:[
                {
                    name: "Tatoooooooooo", followersCount: 296, urlProfile: "https://twitter.com/Leonmarlon98", profile: "The word-break 22222",
                    urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                },
                {
                    name: "PAdivice", followersCount: 296, urlProfile: "https://twitter.com/phoneAdivice", profile: "phoneAdivice",
                    urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
                },
                {
                    name: "Tato", followersCount: 296, urlProfile: "https://twitter.com/Leonmarlon98",profile: "Leonmanrlon98",
                    urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                },
                {
                    name: "Tato", followersCount: 296, urlProfile: "https://twitter.com/Leonmarlon98",profile: "Leonmanrlon98",
                    urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                },
                {
                    name: "Tato", followersCount: 296, urlProfile: "https://twitter.com/Leonmarlon98",profile: "Leonmanrlon98",
                    urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
                }
            ]
			}
    },
    computed:
    {
        ...mapState(['usersGammaData'])
    }
  }
</script>