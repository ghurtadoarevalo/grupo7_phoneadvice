
<template>
  <v-card style="margin-top:3%">
    <v-card-title class="indigo white--text headline">
      Marcas ordenadas según relevancia
    </v-card-title>
    <v-layout
      justify-space-between
      pa-3
    >
      <v-flex xs5>
        <v-treeview
          :active.sync="active"
          :items="items"
          activatable
          active-class="primary--text"
          open-all
          transition
          hoverable
          on-icon
          style="cursor: pointer;"
        >
          <template v-slot:prepend="{ item, active }">
            <v-icon
              v-if="!item.children"
              :color="active ? '#0E318A' : ''"
            >
              mdi-tag-heart
            </v-icon>
          </template>
        </v-treeview>
      </v-flex>
      <v-flex
        d-flex
        text-xs-center
      >
        <v-scroll-y-transition mode="out-in">
          <div
            v-if="!selected"
            class="title grey--text text--lighten-1 font-weight-light"
            style="align-self: center;"
          >
            Seleccione una marca
          </div>
          <v-card
            v-else
            :key="selected.id"
            class="pt-4 mx-auto"
            flat
            max-width="400"
          >
            <v-card-text>
              <v-avatar
                size="150"
              >
                <v-img
                  :src="require('@/assets/brands/'+ selected.img + '.png')"
                  class="mb-4"
                ></v-img>
              </v-avatar>
              <h3 class="headline mb-2">
                {{ selected.name }}
              </h3>
              <div class="blue--text mb-2">{{ selected.name }}</div>
              <div class="blue--text subheading font-weight-bold">{{ selected.name }}</div>
            </v-card-text>
            <v-divider></v-divider>
            <v-layout
              tag="v-card-text"
              text-xs-left
              wrap
            >
              <v-flex mt-1 v-for="(user, index) in brandUsers[selected.id]" :key="index">
                <v-card
                  color="#26c6da"
                  dark
                  height="110"
                  style="margin-bottom:2%"
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
                      <v-list-tile-avatar color="grey darken-3" class="mb-3" size="60" style="margin-left:-3%">
                      <v-img
                          class="elevation-6"
                          :src="user.urlPhoto"
                      ></v-img>
                      </v-list-tile-avatar>
                      <v-layout
                        align-center
                        justify-end
                      >
                        <v-tooltip bottom>
                          <template v-slot:activator="{ on }">              
                            <VBtn class="mr-1" style="margin-bottom:9%" v-on="on" :href= user.urlProfile flat icon><v-icon>mdi-open-in-new</v-icon></VBtn>
                          </template>
                          <span>Ir al perfil</span>
                        </v-tooltip>
                      </v-layout>
                      
                    </v-list-tile>
                  </v-card-actions>
                </v-card>
              </v-flex>

            </v-layout>
          </v-card>
        </v-scroll-y-transition>
      </v-flex>
    </v-layout>
  </v-card>
</template>
content_copy


<script>
import { constants } from 'crypto';
import {mapState} from 'vuex';

  export default {
    computed: {
      ...mapState(['neoBrandData']),
      items () {
        return [
          {
            children: this.brandData
          }
        ]
      },
      selected () {
        if (!this.active.length) return undefined
        const id = this.active[0]
        let algo = this.brandData.find(brand => brand.id === id)
        console.log(algo)
        return algo
      }
    },
    methods: {
    },
    watch: {
      neoBrandData: function(){
        if(this.neoBrandData.length!=0){
        this.neoBrandData.sort(function (a, b) {
          return (a.brandID - b.brandID)
        })
        
        for(var data of this.neoBrandData)
        {
          var brandInfo = {id: data.brandID-1, name: data.brandName, img:this.imgData[data.brandID-1], weight: data.size}
          this.brandData.push(brandInfo)
          var users_brand = []
          for(var user of data.users)
            users_brand.push(user)

          this.brandUsers.push(users_brand)
        }
        this.brandData.sort(function (a, b) {
          return (b.weight - a.weight)
        })
        console.log('Aqui va el test')
        console.log(this.brandData)
      }
      }
    },
    mounted() {
    },
    
    data: () => ({
      active: [0],
      avatar: null,
      imgData:['LGLogo','SamsungLogo','XiaomiLogo','MotorolaLogo','HuaweiLogo','AsusLogo','AppleLogo','NokiaLogo'],
      brandData:[],
      brand_test:[],
      brandUsers: [],
    }),
  }
</script>