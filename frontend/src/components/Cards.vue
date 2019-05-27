<template>
  <v-container grid-list-xl>
    <VLayout row wrap class="mt-5">

      <v-flex xs12 md3>
        <v-card height="100%">
          <v-img src="https://img.europapress.es/fotoweb/fotonoticia_20190314170534_640.jpg">
          </v-img>
          <v-card-title>
            <h2>Busqueda por especificacion</h2>
          </v-card-title>
          <v-card-text>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus molestias consequatur explicabo itaque labore optio, ratione soluta rem fugit minus alias nisi, consectetur quaerat nulla veniam porro, unde nihil reiciendis.</p>
          </v-card-text>
          <v-card-actions>
            <VBtn dark color="purple">Accion</VBtn>
          </v-card-actions>
        </v-card>
      </v-flex>

      <v-flex xs12 md3>
        <v-card height="100%">
          <v-img src="https://img.europapress.es/fotoweb/fotonoticia_20190314170534_640.jpg">
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

      <v-flex xs12 md3>
        <v-card height="100%">
          <v-img src="https://img.europapress.es/fotoweb/fotonoticia_20190314170534_640.jpg">
            <v-container>
              <v-layout >
                <v-flex>
                  <span class="headline white--text">Avengers Infinity</span>
                </v-flex>
                
              </v-layout>
              
            </v-container>  
          </v-img>
          <v-card-title>
            <h2>Busqueda por equipo(?)</h2>
          </v-card-title>
          <v-card-text>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus molestias consequatur explicabo itaque labore optio, ratione soluta rem fugit minus alias nisi, consectetur quaerat nulla veniam porro, unde nihil reiciendis.</p>
          </v-card-text>
          <v-card-actions>
            <VBtn dark color="purple" @click="dialog=true">Accion</VBtn>
          </v-card-actions>
        </v-card>
      </v-flex>

      <v-flex xs12 md3>
        <v-card height="100%">
          <v-img src="https://img.europapress.es/fotoweb/fotonoticia_20190314170534_640.jpg">
            <v-container>
              <v-layout >
                <v-flex>
                  <span class="headline white--text">Avengers Infinity</span>
                </v-flex>
                
              </v-layout>
              
            </v-container>  
          </v-img>
          <v-card-title>
            <h2>Busqueda por gama</h2>
          </v-card-title>
          <v-card-text>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus molestias consequatur explicabo itaque labore optio, ratione soluta rem fugit minus alias nisi, consectetur quaerat nulla veniam porro, unde nihil reiciendis.</p>
          </v-card-text>
          <v-card-actions >
            <VBtn dark color="purple" @click="dialog=true">Accion</VBtn>
          </v-card-actions>
        </v-card>
      </v-flex>

    </VLayout>
    
    <v-dialog v-model="dialog" width="500">
      <v-card>
        <VCardTitle>
          Hola soy un titulo
        </VCardTitle>
        <v-card-text>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium, repellendus!
        </v-card-text>
        <VDivider/>
        <v-card-actions>
          <v-btn dark color="purple" @click="dialog=false">Cerrar</v-btn>
        </v-card-actions>
      </v-card>
      
    </v-dialog>
  </v-container>
</template>

<script>
  export default {
    data(){
      return{
      dialog:false
      }
    }
  }
</script>

<style>

</style>