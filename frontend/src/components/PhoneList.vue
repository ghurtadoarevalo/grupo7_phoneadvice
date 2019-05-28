<template>
  <v-container grid-list-xl>
    <v-layout row wrap class="lista" style="margin-top:-5%; margin-left:6.5%">
      <v-flex class="ml-3" xs12 md1 v-for="(equipo, index) in listaEquipos" :key="index">
          <v-img height="100%" class="imagen" @click="dialog=true;indice=index" :src='equipo.img'>
          </v-img>
      </v-flex>
    </v-layout>
    <v-dialog v-model="dialog" width="500">
      <v-card>
        <VCardTitle>
          {{listaEquipos[indice].name}}
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
      ...mapState(['listaEquipos'])
    }
  }
</script>

<style>
.imagen { cursor: pointer; }
</style>