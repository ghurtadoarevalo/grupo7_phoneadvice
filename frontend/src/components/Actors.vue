
<template>
  <v-container id="Actors">
    <addActor v-bind:actorsList="actors"></addActor>
    <show-actors v-bind:actorsList="actors" :class="['mt-5']"></show-actors>
  </v-container>
</template>

<script>

import AddActor from './AddActor.vue'
import ShowActors from './ShowActors.vue'

/* eslint-disable */
  export default {
    data() {
      return {
        urlBase: 'http://localhost:8081/',
        actors: [{info:{},films:{}}]
      }
    },
    components:
    {
      AddActor, ShowActors
    },
    methods: 
    {
      getActors: function()
      {
        this.actors = [];
        let self = this;
        fetch(this.urlBase+'actors/all')
        .then(function(response) {
          return response.json();
        })
        .then(function(actors) {
          console.log(actors)
          for (var actor of actors) {
            self.actors.push(actor);
          }
        });
      }
    },
    created: function()
    {
      this.getActors()
    }
  }
  </script>

