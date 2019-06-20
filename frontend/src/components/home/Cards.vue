<template>
  <v-container grid-list-xl>
                      <!-- No borrar, lo usé para un random 
                          <li v-for="(k,index) in query">{{k}}</li>
                        -->
    <VLayout row wrap class="mt-2">
      <v-flex xs12 md3>
        <v-hover>
          <v-card
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 12 : 2}`"
            class="mx-auto"
            color="grey lighten-4"
          >
            <v-img
              :aspect-ratio="9/15"
              :src="require('@/assets/home/celulares.png')"
            >
              <v-expand-transition>
                <div
                v-if="hover"
                class="d-flex v-card--reveal transition-fast-in-fast-out orange darken-2 display-3 white--text "
                style="height: 100%; width: 100%"
              >
              <div class = "a font-weight-light mb-2">
                <b>¡En esta sección podrá encontrar un ranking con los mejores equipos recomendados por la gente!</b>
              </div>
              </div>
              </v-expand-transition>
            </v-img>
            <v-card-text
              class="pt-4"
              style="position: relative;"
            >
              <v-btn
                absolute
                color="orange"
                class="white--text"
                fab
                large
                right
                top
                to="/searchForDevices"
              >
                <v-icon>mdi-cellphone-iphone</v-icon>
              </v-btn>
              <h3 class="display-1 font-weight-light orange--text mb-2">Busqueda por equipo</h3>
            </v-card-text>
          </v-card>
        </v-hover>
      </v-flex>


      <v-flex xs12 md3>
        <v-hover>
          <v-card
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 12 : 2}`"
            class="mx-auto"
            color="grey lighten-4"
            max-width="600"
          >
            <v-img
              :aspect-ratio="9/15"
              :src="require('@/assets/home/brand.png')"
            >
              <v-expand-transition>
                <v-flex
                v-if="hover"
                class="d-flex v-card--reveal transition-fast-in-fast-out orange darken-2 display-3 white--text "
                style="height: 100%; width: 100%"
              >
              <div class = "a font-weight-light mb-2">
                <b>¡En esta sección podrá encontrar un ranking con las mejores marcas recomendados por la gente!</b>
              </div>
              </v-flex>
              </v-expand-transition>
            </v-img>
            <v-card-text
              class="pt-4"
              style="position: relative;"
            >
              <v-btn
                absolute
                color="orange"
                class="white--text"
                fab
                large
                right
                top
                to="/searchForBrands"

              >
                <v-icon>mdi-compass</v-icon>
              </v-btn>
              <h3 class="display-1 font-weight-light orange--text mb-2">Busqueda por marca</h3>

            </v-card-text>
          </v-card>
        </v-hover>
      </v-flex>


      <v-flex xs12 md3>
        <v-hover>
          <v-card
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 12 : 2}`"
            class="mx-auto"
            color="grey lighten-4"
          >
            <v-img
              :aspect-ratio="9/15"
              :src="require('@/assets/home/spec.png')"
            >               
            <v-expand-transition>
                <v-flex
                v-if="hover"
                class="d-flex v-card--reveal transition-fast-in-fast-out orange darken-2 display-3 white--text "
                style="height: 100%; width: 100%"
              >
              <div class = "a font-weight-light mb-2">
                <b>¡En esta sección podrá encontrar un ranking con los mejores equipos según su especificación recomendados por la gente!</b>
              </div>
              </v-flex>
              </v-expand-transition> 
            </v-img>
            <v-card-text
              class="pt-4"
              style="position: relative;"
            >
              <v-btn
                absolute
                color="orange"
                class="white--text"
                fab
                large
                right
                top
                to="/searchForSpecifications"
              >
                <v-icon>mdi-settings</v-icon>
              </v-btn>

              <div class="display-1 font-weight-light orange--text mb-2">
              Busqueda por especificación
              </div>
     
            </v-card-text>
          </v-card>
        </v-hover>
      </v-flex>

      <v-flex xs12 md3>
        <v-hover>
          <v-card
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 12 : 2}`"
            class="mx-auto"
            color="grey lighten-4"
            max-width="600"
          >
            <v-img
              :aspect-ratio="9/15"
              :src="require('@/assets/home/build.png')"
            >
              <v-expand-transition>
              <v-flex
              v-if="hover"
              class="d-flex v-card--reveal transition-fast-in-fast-out orange darken-2 display-3 white--text "
              style="height: 100%; width: 100%"
            >
            <div class = "a font-weight-light mb-2">
              <b>¡Sección en construcción!</b>
            </div>
            </v-flex>
            </v-expand-transition> 
            </v-img>
            <v-card-text
              class="pt-4"
              style="position: relative;"
            >
              <v-btn
                absolute
                color="orange"
                class="white--text"
                fab
                large
                right
                top
              >
                <v-icon>mdi-hammer</v-icon>
              </v-btn>
  
              <h3 class="display-1 font-weight-light orange--text mb-2">Busqueda por Gama</h3>

            </v-card-text>
          </v-card>
        </v-hover>
      </v-flex>
      <v-flex md3>
        
      </v-flex>

    </VLayout>
  </v-container>
</template>

<script>
  export default {
    data(){
      return{
      dialog:false,
      reviews: 413,
      value: 4.5
      //query:[]
      }
    },
    mounted()
    {
        //Esto lo usé para un random, no borrar aún xD
        //for (let index = 1; index < 11; index++) {
            //for (let index2 = 1; index2 < 7; index2++) {
                //let positive = Math.floor(Math.random() * (100 - 1 + 1))+1;
                //let negative = Math.floor(Math.random() * (100 - 1 + 1))+1;
                //let neutral = Math.floor(Math.random() * (100 - 1 + 1))+1;
                //let assessment = Math.floor(Math.random() * (7 - 1 + 1))+1;

                //let query = "INSERT INTO `phoneadvice`.`statistic` (`negative_density`, `neutral_density`, `positive_density`) VALUES (" + positive + "," + negative + ","+ neutral+");";
                //let query = "INSERT INTO `phoneadvice`.`phone_specification` (`phone_id`, `specification_id`, `assessment`) VALUES ("+ index +","+ index2 + "," + assessment +");"
                //this.query.push(query);
            //}

        //}
    }
    
  }
</script>

<style lang="css">
.v-card--reveal {
  align-items: top;
  bottom: 0;
  justify-content: center;
  opacity: 0.85;
  position: absolute;
  width: 100%;

}
.a{
text-shadow: 2px 2px 4px #000000;
font-style:italic;
font-family: Gill Sans, sans-serif;
width: 100%;
height: 40vh;
font-size: 4.5vmin !important;
white-space: pre-wrap;
}
</style>