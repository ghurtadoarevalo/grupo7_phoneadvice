<template>
  <v-container grid-list-xl>
                      <!-- No borrar, lo usé para un random 
                          <li v-for="(k,index) in query">{{k}}</li>
                        -->

    <VLayout row wrap class="mt-5">
      <v-flex xs12 md3>
        <v-hover>
          <v-card
            slot-scope="{ hover }"
            class="mx-auto"
            color="grey lighten-4"
            max-width="600"
          >
            <v-img
              :aspect-ratio="16/9"
              src="https://cdn.vuetifyjs.com/images/cards/kitchen.png"
            >
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
                <v-icon>mdi-cart</v-icon>
              </v-btn>
              <div class="font-weight-light grey--text title mb-2">For the perfect meal</div>
              <h3 class="display-1 font-weight-light orange--text mb-2">QW cooking utensils</h3>
              <div class="font-weight-light title mb-2">
                Our Vintage kitchen utensils delight any chef.<br>
                Made of bamboo by hand
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
          >
            <v-img
              :aspect-ratio="16/9"
              src="https://img.europapress.es/fotoweb/fotonoticia_20190314170534_640.jpg"
            ></v-img>
            <v-card-title>
              <div>
                <span class="headline">Cafe Badilico</span>
                <div class="d-flex">
                  <v-rating
                    :value="value"
                    color="amber"
                    dense
                    half-increments
                    readonly
                    size="14"
                  ></v-rating>
                  <div class="ml-2 grey--text text--darken-2">
                    <span>{{ value }}</span>
                    <span>({{ reviews }})</span>
                  </div>
                </div>
              </div>
              <v-spacer></v-spacer>
              <v-btn icon class="mr-0">
                <v-icon>mdi-chevron-right</v-icon>
              </v-btn>
            </v-card-title>
            <v-card-text>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus molestias consequatur explicabo itaque labore optio, ratione soluta rem fugit minus alias nisi, consectetur quaerat nulla veniam porro, unde nihil reiciendis.</p>
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
          >
            <v-img
              :aspect-ratio="16/9"
              src="https://img.europapress.es/fotoweb/fotonoticia_20190314170534_640.jpg"
            ></v-img>
            <v-card-title>
              <div>
                <span class="headline">Cafe Badilico</span>
                <div class="d-flex">
                  <v-rating
                    :value="value"
                    color="amber"
                    dense
                    half-increments
                    readonly
                    size="14"
                  ></v-rating>
                  <div class="ml-2 grey--text text--darken-2">
                    <span>{{ value }}</span>
                    <span>({{ reviews }})</span>
                  </div>
                </div>
              </div>
              <v-spacer></v-spacer>
              <v-btn icon class="mr-0">
                <v-icon>mdi-chevron-right</v-icon>
              </v-btn>
            </v-card-title>
            <v-card-text>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus molestias consequatur explicabo itaque labore optio, ratione soluta rem fugit minus alias nisi, consectetur quaerat nulla veniam porro, unde nihil reiciendis.</p>
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
          >
            <v-img
              :aspect-ratio="16/9"
              src="https://img.europapress.es/fotoweb/fotonoticia_20190314170534_640.jpg"
            ></v-img>
            <v-card-title>
              <div>
                <span class="headline">Cafe Badilico</span>
                <div class="d-flex">
                  <v-rating
                    :value="value"
                    color="amber"
                    dense
                    half-increments
                    readonly
                    size="14"
                  ></v-rating>
                  <div class="ml-2 grey--text text--darken-2">
                    <span>{{ value }}</span>
                    <span>({{ reviews }})</span>
                  </div>
                </div>
              </div>
              <v-spacer></v-spacer>
              <v-btn icon class="mr-0">
                <v-icon>mdi-chevron-right</v-icon>
              </v-btn>
            </v-card-title>
            <v-card-text>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus molestias consequatur explicabo itaque labore optio, ratione soluta rem fugit minus alias nisi, consectetur quaerat nulla veniam porro, unde nihil reiciendis.</p>
          </v-card-text>
          </v-card>
        </v-hover>
      </v-flex>
      <v-flex md3>
        
      </v-flex>

    </VLayout>
    
    <v-dialog v-model="dialog" width="500">
      <v-hover>
          <v-card
            slot-scope="{ hover }"
            :class="`elevation-${hover ? 12 : 2}`"
            class="mx-auto"
          >
            <v-img
              :aspect-ratio="16/9"
              src="https://img.europapress.es/fotoweb/fotonoticia_20190314170534_640.jpg"
            ></v-img>
            <v-card-title>
              <div>
                <span class="headline">Cafe Badilico</span>
                <div class="d-flex">
                  <v-rating
                    :value="value"
                    color="amber"
                    dense
                    half-increments
                    readonly
                    size="14"
                  ></v-rating>
                  <div class="ml-2 grey--text text--darken-2">
                    <span>{{ value }}</span>
                    <span>({{ reviews }})</span>
                  </div>
                </div>
              </div>
              <v-spacer></v-spacer>
              <v-btn icon class="mr-0">
                <v-icon>mdi-chevron-right</v-icon>
              </v-btn>
            </v-card-title>
            <v-card-text>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ducimus molestias consequatur explicabo itaque labore optio, ratione soluta rem fugit minus alias nisi, consectetur quaerat nulla veniam porro, unde nihil reiciendis.</p>
          </v-card-text>
          </v-card>
        </v-hover>
      
    </v-dialog>
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
  bottom: 0;
  justify-content: center;
  opacity: .5;
  position: absolute;
  width: 100%;
}
</style>