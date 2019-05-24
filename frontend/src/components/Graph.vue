<template>
  <v-container grid-list-xl>
    <VLayout row wrap class="mt-5">
      <v-flex xs12 md8>
        <v-card height="100%">
          <v-img src="http://www.burningcutlery.com/derek/bargraph/one_dataset_colors.png">
            <v-container>
              <v-layout >
                <v-flex>
                  <span class="headline white--text">Avengers Infinity</span>
                </v-flex>
                
              </v-layout>
              
            </v-container>  
          </v-img>
          <v-card-title>
            <h2>Busqueda por marca</h2>
          </v-card-title>
          <v-card-text>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus molestias consequatur explicabo itaque labore optio, ratione soluta rem fugit minus alias nisi, consectetur quaerat nulla veniam porro, unde nihil reiciendis.</p>
          </v-card-text>
          <v-card-actions>
            <VBtn dark color="purple" @click="dialog=true">Accion</VBtn>
          </v-card-actions>
        </v-card>
      </v-flex>
      <v-flex md4>
          <h1>Filtrar Búsqueda</h1>
          <v-checkbox
              v-model="ex4"
              label="indigo darken-3"
              color="indigo darken-3"
              value="indigo darken-3"
              hide-details
            ></v-checkbox>
             <v-checkbox
              v-model="ex4"
              label="indigo darken-3"
              color="indigo darken-3"
              value="indigo darken-3"
              hide-details
            ></v-checkbox>
             <v-checkbox
              v-model="ex4"
              label="indigo darken-3"
              color="indigo darken-3"
              value="indigo darken-3"
              hide-details
            ></v-checkbox>
          
      </v-flex>

    </VLayout>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
      ex4: ['red', 'indigo', 'orange', 'primary', 'secondary', 'success', 'info', 'warning', 'error', 'red darken-3', 'indigo darken-3', 'orange darken-3']
    })
  }
</script>

<style>

</style>