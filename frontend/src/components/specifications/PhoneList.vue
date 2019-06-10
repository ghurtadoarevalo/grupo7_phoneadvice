<template>
  <v-container grid-list-xl>
    <v-layout v-if="topTenImgList.length === 1" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:36%;margin-right: 35%" xs1 md1 v-for="(img, index) in topTenImgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src="require('@/assets/phones/'+ img + '.png')">
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="topTenImgList.length === 2" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:16%;margin-right: 16%" xs1 md1 v-for="(img, index) in topTenImgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src="require('@/assets/phones/'+ img + '.png')">
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="topTenImgList.length === 3" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:9%;margin-right: 9%" xs1 md1 v-for="(img, index) in topTenImgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src="require('@/assets/phones/'+ img + '.png')">
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="topTenImgList.length === 4" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:6%;margin-right: 6%" xs1 md1 v-for="(img, index) in topTenImgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src="require('@/assets/phones/'+ img + '.png')">
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="topTenImgList.length === 5" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:4%;margin-right: 4%" xs1 md1 v-for="(img, index) in topTenImgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src="require('@/assets/phones/'+ img + '.png')">
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="topTenImgList.length === 6" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:2.5%;margin-right: 2.5%" xs1 md1 v-for="(img, index) in topTenImgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src="require('@/assets/phones/'+ img + '.png')">
          </v-img>
      </v-flex>
    </v-layout>
  <v-layout v-else-if="topTenImgList.length >= 10" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:0.3%;margin-right:0.3%" xs1 md1 v-for="(img, index) in topTenImgList" :key="index">
          <v-img contain class="imagen" @click="dialog=true;indice=index" :src="require('@/assets/phones/'+ img + '.png')">
          </v-img>
      </v-flex>
      <v-flex md1>
        <v-btn @click="dialog2=true" large outline color="#0E318A">
          <VIcon>phone_iphone</VIcon>¡Aún hay más!</v-btn>      
      </v-flex>
    </v-layout>

  <v-dialog v-model="dialog" width="500">
      <v-card>
        <v-toolbar color="#0E318A" dark>
          <v-toolbar-title>Tabla de especificaciones</v-toolbar-title>
          <v-spacer></v-spacer>
        </v-toolbar>
        <v-layout mt-4 ml-2 row wrap>
          <v-flex md4>
            <v-img class="imagen" @click="dialog=true;indice=index" :src="require('@/assets/phones/'+ topTenImgList[indice] + '.png')"/>
          </v-flex>
          <v-flex md6 ml-4>
            <v-list-tile>
                <v-list-tile-title>Descripcion: </v-list-tile-title>
            </v-list-tile>
            <p>{{phonesDescription[indice]}}</p>

          </v-flex>
        </v-layout>
        <v-list three-line>
            <v-subheader>
              {{ topTenNames[indice]}}
            </v-subheader>
          <template v-for="(item, index) in topTenSpecData[indice]">
            
            <v-divider :key="index+'%'+item+1" :inset="true"></v-divider>

            <v-list-tile :key="index+'%'+item+2">
              <v-list-tile-action>
                <v-icon large color="#0E318A">{{ headers[index].icon}}</v-icon>
              </v-list-tile-action>

              <v-list-tile-content>
                <v-list-tile-title>{{ headers[index].spec }}</v-list-tile-title>
                <v-list-tile-sub-title>{{item}}</v-list-tile-sub-title>
              </v-list-tile-content>
            </v-list-tile>
              
          </template>
        </v-list>
      
      <v-card-actions>
          <v-btn dark color="#0E318A" @click="dialog=false">Cerrar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

     <v-dialog v-model="dialog3" width="500">
      <v-card>
        <v-toolbar color="#0E318A" dark>

          <v-toolbar-title>Tabla de especificaciones</v-toolbar-title>

          <v-spacer></v-spacer>

        </v-toolbar>
        <v-layout mt-4 ml-2 row wrap>
          <v-flex md4>
            <v-img class="imagen" :src="require('@/assets/phones/'+ imgList[indice] + '.png')"/>
          </v-flex>
          <v-flex md6 ml-4>
            <v-list-tile>
                <v-list-tile-title>Descripcion: </v-list-tile-title>
            </v-list-tile>
            <p>{{phonesDescription[indice]}}</p>

          </v-flex>
        </v-layout>
        <v-list three-line>
            <v-subheader>
              {{ names[indice]}}
            </v-subheader>
          <template v-for="(item, index) in specData[indice]">
            
            <v-divider :key="index+'%'+item+1" :inset="true"></v-divider>

            <v-list-tile :key="index+'%'+item+2">
              <v-list-tile-action>
                <v-icon large color="#0E318A">{{ headers[index].icon}}</v-icon>
              </v-list-tile-action>

              <v-list-tile-content>
                <v-list-tile-title>{{ headers[index].spec }}</v-list-tile-title>
                <v-list-tile-sub-title>{{item}}</v-list-tile-sub-title>
              </v-list-tile-content>
            </v-list-tile>
              
          </template>
        </v-list>
      
      <v-card-actions>
          <v-btn dark color="#0E318A" @click="dialog3=false">Cerrar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>


    <v-dialog v-model="dialog2" width="500">
      <v-card>
        <v-toolbar color="#0E318A" dark>
          <v-toolbar-title>Ranking</v-toolbar-title>
          <v-spacer></v-spacer></v-toolbar>
        <v-list three-line>
          <template v-for="(item, index) in names">
            
            <v-divider :key="index+'%'+item+1" :inset="true"></v-divider>
              <v-subheader :key="index+'%'+item+4">
                {{index+11+". " + item }}
              </v-subheader>
              <v-layout row wrap :key="index+'%'+item+3">
                <v-flex style="margin-left:2%; margin-bottom:1%;" md1>
                  <v-img class="imagen" @click="dialog3=true;indice=index" :src="require('@/assets/phones/'+ imgList[index] + '.png')"/>
                </v-flex>  
                <v-flex>
                  <v-list-tile :key="index+'%'+item+2">
                    <v-list-tile-content>
                    <v-list-tile-title>Evaluación</v-list-tile-title>
                    <v-list-tile-sub-title>{{evalSpecification[index]}}</v-list-tile-sub-title>
                    </v-list-tile-content>
                </v-list-tile>
                </v-flex> 
              </v-layout>              
          </template>
        </v-list>
      <v-card-actions>
          <v-btn dark color="#0E318A" @click="dialog2=false">Cerrar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

  </v-container>
</template>

<script>
import { mapState } from 'vuex';   
  export default {
    data() {
        return{
        dialog:false,
        dialog2:false,
        dialog3:false,
        indice:0,
      }
    },
    computed:{
      ...mapState(['imgList','names','headers','specData','topTenImgList','topTenSpecData','topTenNames','evalSpecification','phonesDescription'])
    }
  }
</script>

<style>
.imagen { cursor: pointer; }
</style> 