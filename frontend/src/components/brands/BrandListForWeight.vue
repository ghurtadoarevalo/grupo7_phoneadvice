<template>
  <v-container grid-list-xl>
    <v-layout  row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex class="ml-3" style="margin-right:2.5%" xs1 md1 v-for="(img, index) in brandData.brandImgList" :key="index">
          <v-img height="100%" width="100%" @click="dialog=true;indice=index" :src="require('@/assets/brands/'+ img + '.png')">
          </v-img>
      </v-flex>
    </v-layout>
    
    <v-dialog
      v-model="dialog"
      width="450"
    >
        <v-toolbar color="#26c6da" dark>
          <v-toolbar-title>TOP 5 Twitteros que hablan de {{brandData.brandImgList[indice]}}</v-toolbar-title>
          <v-spacer></v-spacer></v-toolbar>
        <v-flex mt-1 v-for="(user, index) in brandUsers[0]" :key="index">
        
          <v-card
            color="#26c6da"
            dark
          >
            <v-card-title>
                <v-icon
                large
                left>mdi-twitter</v-icon>
                <a 
                  :href= user.urlProfile 
                  class="title font-weight-light ml-1 hide_80"
                  style="color:white;text-decoration:none"
                >{{user.name}}</a>

                <v-layout
                align-center
                justify-end
                ma-1
                >
                <v-tooltip bottom>
                <template v-slot:activator="{ on }">
                    <v-icon v-on="on" class="mr-1">people</v-icon>
                    <span  v-on="on" class="subheading mr-2">{{user.followersCount}}</span>
                </template>
                <span>Seguidores</span>
                </v-tooltip>
                </v-layout>
            </v-card-title> 

            <v-card-actions>
              <v-list-tile class="grow">
                <v-list-tile-avatar color="grey darken-3" class="mb-3" size="60">
                <v-img
                    class="elevation-6"
                    :src="user.urlPhoto"
                ></v-img>
                </v-list-tile-avatar>
              </v-list-tile>
              <v-tooltip bottom>
              <template v-slot:activator="{ on }">              
              <VBtn v-on="on" :href= user.urlProfile flat icon><v-icon>mdi-open-in-new</v-icon></VBtn>
              </template>
              <span>Ir al perfil</span>
              </v-tooltip>
            </v-card-actions>
          </v-card>
        </v-flex>
    </v-dialog>
  </v-container>
</template>

<script>
import { mapState } from 'vuex';
  export default {
    data() {
        return{
          dialog:false,
          indice:0,
          brandData:{
            brandImgList:['AppleLogo', 'AsusLogo','HuaweiLogo','LGLogo','MotorolaLogo','NokiaLogo','SamsungLogo','XiaomiLogo']},
          
          brandUsers:       
          [
            [
            {
                id: 123,
                name: "Tato",
                followersCount: 123,
                urlProfile: "https://twitter.com/Leonmarlon98", 
                size: 123,
                profile: "The word-break 22222",
                urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
            },
            {
              id: 125,
              name: "PAdivice", 
              followersCount: 296, 
              urlProfile: "https://twitter.com/phoneAdivice", 
              size: 432,
              profile: "phoneAdivice",
              urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
            },
            {
              id: 225,
              name: "Pasdasd", 
              followersCount: 542, 
              urlProfile: "https://twitter.com/phoneAdivice", 
              size: 231,
              profile: "Pasdasd",
              urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
            },
            {
              id: 123,
              name: "Pedrito",
              followersCount: 543,
              urlProfile: "https://twitter.com/Leonmarlon98", 
              size: 123,
              profile: "Pedrito",
              urlPhoto: "https://pbs.twimg.com/profile_images/720727499693539328/YNu-yWWF_bigger.jpg",
            },
            {
              id: 225,
              name: "Juanito", 
              followersCount: 65, 
              urlProfile: "https://twitter.com/phoneAdivice", 
              size: 231,
              profile: "Juanito",
              urlPhoto: "https://pbs.twimg.com/profile_images/1132408647521320960/gBdOVTb5_bigger.jpg",
              
            },
            ]
          ],
      }
    },
    computed:{
      //...mapState(['brandData'])
    },
    watch: {
    },
    mounted(){
      console.log(this.brandUsers[0])
    }
  }

</script>

<style>
.imagen { cursor: pointer; }
</style>