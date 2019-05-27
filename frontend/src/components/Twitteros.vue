<template>
    <VLayout row wrap class>
    <v-flex xs12 md4 v-for="(aux, index) in listaaux" :key="index">
  <v-card
    class="mx-auto; mt-4"
    color="#26c6da"
    dark
    
  >
    <v-card-title>
      <twitter-icon
      large
      left/>
      <span class="title font-weight-light">Twitter</span>
    </v-card-title>

    <v-card-text class="headline font-weight-bold">
      "Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."
    </v-card-text>

    <v-card-actions>
      <v-list-tile class="grow">
        <v-list-tile-avatar color="grey darken-3">
          <v-img
            class="elevation-6"
            src="https://avataaars.io/?avatarStyle=Transparent&topType=ShortHairShortCurly&accessoriesType=Prescription02&hairColor=Black&facialHairType=Blank&clotheType=Hoodie&clotheColor=White&eyeType=Default&eyebrowType=DefaultNatural&mouthType=Default&skinColor=Light"
          ></v-img>
        </v-list-tile-avatar>

        <v-list-tile-content>
          <v-list-tile-title>Evan You</v-list-tile-title>
        </v-list-tile-content>

        <v-layout
          align-center
          justify-end
          ma-1
        >
          <v-icon class="mr-1">favorite</v-icon>
          <span class="subheading mr-2">256</span>
          <v-icon class="mr-1">share</v-icon>
          <span class="subheading">45</span>
        </v-layout>
      </v-list-tile>
    </v-card-actions>
  </v-card>
    </v-flex>
    </VLayout>   
</template>

<script>
import TwitterIcon from "vue-material-design-icons/Twitter.vue"
  export default {
    components:{
      TwitterIcon,
    },
    data(){
			return{
			listaaux:[1,2,3,4,5]
			}
    }
  }
</script>