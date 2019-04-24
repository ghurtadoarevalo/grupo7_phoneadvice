<template>
  <v-container id="Actors">
    <v-layout>
      <v-flex>
        <v-btn :class="['text-white',background]" @click="count">{{total}}</v-btn>
      </v-flex>
      <v-flex>
        <v-btn :class="['text-white',background]" @click="getData">{{total}}</v-btn>
      </v-flex>
    </v-layout>
    <v-layout>
      <ol>
        <li v-for="actor in actors" :class="['mt-5']">
          id = {{actor.actorId}}
          <br>
          name = {{actor.firstName}}
          <br>
          apellido = {{actor.lastName}}
          <br>
          lastUpdate = {{actor.lastUpdate}}
        </li>
      </ol>
    </v-layout>
  </v-container>
</template>

<script>
/* eslint-disable */
export default {
  data() {
    return {
      items: [1, 2, 3],
      total: 0, 
      background: 'yellow',
      actors: [],
      actorId: 1
    }
  },
  methods: {
    count: function() {
      return this.total = this.items.length * 10,
             this.background = 'red'
    },
    getData: function() 
    {
      let self = this
      fetch('http://localhost:8081/actors/all')
      .then(function(response) {
        return response.json();
      })
      .then(function(myJson) {
        for (var variable of myJson) {
          self.actors.push(variable);
        }
        console.log(myJson)
      });
    } 
  },

  created:
    function() 
      {
        let self = this
        fetch('http://localhost:8081/actors/all')
        .then(function(response) {
          return response.json();
        })
        .then(function(myJson) {
          for (var variable of myJson) {
            self.actors.push(variable);
          }
          console.log(myJson)
        });
      } 
}
</script>

