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
        <VBtn fab dark color="purple" @click="allGamma">
          <v-icon large color="white">monetization_on</v-icon>
        </VBtn> Gama
        
        <v-switch v-model="baja" label="Baja" color="purple"></v-switch>
        <v-switch v-model="media" label="Media" color="purple"></v-switch>
        <v-switch v-model="alta" label="Alta" color="purple"></v-switch>
    
      </v-flex>

    </VLayout>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
      baja: true,
      media: true,
      alta: true
    }),
    methods: {
      allGamma(){
        this.baja = true;
        this.media = true;
        this.alta = true;
      }
    },
  }
</script>

<style>

</style>