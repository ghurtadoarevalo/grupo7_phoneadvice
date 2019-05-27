<template>
  <v-container grid-list-xl>
    <v-layout row wrap class="lista" style="margin-top:-5%; margin-left:">
      <v-flex v-for="(equipo, index) in listaEquipos" :key="index">
                <v-btn flat color="rgb(14, 49, 138)" class="">
                    <v-icon large>{{equipo.icon}}</v-icon>
                    <span>{{equipo.nombre}}</span>
                </v-btn>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
  export default {
    data() {
        return{
        dialog:false,
        indice:0,
        listaEquipos: [
          {id:1,nombre:'Batería',icon:'battery_charging_full'},
          {id:2,nombre:'Pantalla',icon:'stay_current_portrait'},
          {id:3,nombre:'Cámara',icon:'camera_alt'},
          {id:4,nombre:'Almacenamiento',icon:'sd_storage'},
          {id:5,nombre:'Diseño',icon:'brush'},
          {id:6,nombre:'Rendimiento',icon:'trending_up'},
        ]
      }
    }
  }
</script>

<style>
.imagen { cursor: pointer; }
</style>