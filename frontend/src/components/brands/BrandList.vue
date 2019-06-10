<template>
  <v-container grid-list-xl>
    <v-layout  row wrap style="margin-top:-5%; margin-left:6.5%">
      <v-flex class="ml-3" style="margin-right:2.5%" xs1 md1 v-for="(img, index) in brandData.brandImgList" :key="index">
          <v-img height="100%" width="100%" @click="dialog=true;indice=index" :src="require('@/assets/brands/'+ img + '.png')">
            <v-expand-transition>
            <div
            v-if="hover"
            class="d-flex transition-fast-in-fast-out orange darken-2 v-card--reveal display-3 white--text"
            style="height: 100%;"
            >
            </div>
        </v-expand-transition>
          </v-img>
      </v-flex>
    </v-layout>
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
      ...mapState(['brandData'])
    }
  }
</script>

<style>
.imagen { cursor: pointer; }
</style>