<template>
  <v-container grid-list-xl>
    <v-layout v-if="imgList.length === 1" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:36%;margin-right: 35%" xs1 md1 v-for="(img, index) in imgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='img'>
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="imgList.length === 2" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:16%;margin-right: 16%" xs1 md1 v-for="(img, index) in imgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='img'>
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="imgList.length === 3" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:9%;margin-right: 9%" xs1 md1 v-for="(img, index) in imgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='img'>
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="imgList.length === 4" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:6%;margin-right: 6%" xs1 md1 v-for="(img, index) in imgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='img'>
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="imgList.length === 5" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:4%;margin-right: 4%" xs1 md1 v-for="(img, index) in imgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='img'>
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="imgList.length === 6" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:2.5%;margin-right: 2.5%" xs1 md1 v-for="(img, index) in imgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='img'>
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else-if="imgList.length === 7" row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex style="margin-left:1.6%;margin-right: 1.6%" xs1 md1 v-for="(img, index) in imgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='img'>
          </v-img>
      </v-flex>
    </v-layout>

    <v-layout v-else row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex class="ml-3" xs1 md1 v-for="(img, index) in imgList" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='img'>
            <v-expand-transition>
            <div
            v-if="hover"
            class="d-flex transition-fast-in-fast-out orange darken-2 v-card--reveal display-3 white--text"
            style="height: 100%;"
            >
            $14.99
            </div>
        </v-expand-transition>
          </v-img>
      </v-flex>
    </v-layout>

    <v-dialog v-model="dialog" width="500">
      <v-card>
        <VCardTitle>
          {{names[indice]}}
        </VCardTitle>
        <v-card-text>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium, repellendus!
        </v-card-text>
        <VDivider/>
        <v-card-actions>
          <v-btn dark color="#0E318A" @click="dialog=false">Cerrar</v-btn>
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
        indice:0,
      }
    },
    computed:{
      ...mapState(['imgList','names'])
    }
  }
</script>

<style>
.imagen { cursor: pointer; }
</style> 