<template>
    <div id="ShowActors">
        <v-expansion-panel focusable>
        <v-expansion-panel-content
            v-for="(actor,i) in actorsList"
            :key="i"
        >
            <div slot="header" @click="getMovies(actor.actorId)">
                <div>Nombre: {{actor.firstName}}</div>
                <div>Apellido: {{actor.lastName}}</div>
            </div>

            <v-card>
                <v-card-text>
                    <div v-for="(film,i) in films" :key="i" >
                        Título: {{film.title}}
                        Género: {{film.genre}}
                    </div>
                    <div v-if="films.length === 0">No se encontraron películas de este actor</div>

                </v-card-text>
            </v-card>
        </v-expansion-panel-content>
        </v-expansion-panel>
    </div>    
</template>


<script>

    export default 
    {
        props: ['actorsList'],
        data() {
            return {
              urlBase: 'http://localhost:8081/',
              films: [],
            }
        },
        methods: 
        {
            getMovies: function(actorId)
            {
                this.value = 0;
                this.films = [];
                let self = this;
                this.value += 40;
                fetch(this.urlBase+'actors/'+actorId+'/films')
                .then(function(response) {
                return response.json();
                })
                .catch(function(error) {
                console.log('Hubo un problema con la petición Fetch:' + error.message);
                })
                .then(function(films) {
                    self.showBar = true;
                    self.value+=10;
                    for (var film of films) {
                        self.films.push(film);
                    }
                    self.value+=20;
                });
                this.value += 30;
                //this.showBar = false;
          }
       },
    }
    
</script>


