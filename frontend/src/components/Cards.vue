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
                  class="d-flex transition-fast-in-fast-out orange darken-2 v-card white--text"
                  style="height: 100%;"
                >

                <b>¡En esta sección podrá encontrar un ranking con los mejores equipos recomendados por la gente!</b>
                
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
                <div
                  v-if="hover"
                  class="d-flex transition-fast-in-fast-out orange darken-2 white--text"
                  style="height: 100%;"
                >
                <b>¡En esta sección podrá encontrar un ranking con las mejores marcas recomendados por la gente!</b>
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
              <vflex
                v-if="hover"
                class="d-flex transition-fast-in-fast-out orange darken-5 v-card--reveal display-5 white--text "
                style="height: 100%; width: 100%"
              >
              <div class = "a title mb-6">
                <b>¡En esta sección podrá encontrar un ranking con los mejores equipos según su especificación recomendados por la gente!</b>
              </div>
              </vflex>
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
              <h3 class="display-1 font-weight-light orange--text mb-2">Busqueda por especificación</h3>
     
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
              <div
                v-if="hover"
                class="d-flex transition-fast-in-fast-out orange darken-2 v-card--reveal white--text"
                style="height: 100%; width: 100%"
              >
                <b>Sección en construcción</b>
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

<style>
.v-card--reveal {
  align-items: center;
  justify-content: center;
  position: absolute;
  width: 100%;
  color:#ffffff;

}
.a{
text-shadow: 1px 1px 1px #000000; 
color:#ffffff;
font-variant:small-caps;
font-style:italic;
}
</style>