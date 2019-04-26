<template>
    <div id="ShowActors">
        <v-expansion-panel focusable>
        <v-expansion-panel-content
            v-for="(actor,i) in actorsList"
            :key="i"
        >
            <div slot="header">
                <div>Nombre: {{actor.firstName}}</div>
                <div>Apellido: {{actor.lastName}}</div>
            </div>

            <v-card>
                <v-card-text>
                    <div v-for="(film,i) in actor.films" :key="i">
                        Título: {{film.title}}
                        Género: {{film.genre}}
                    </div>
                    <div v-if="actor.films.length === 0">No se encontraron películas de este actor</div>
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
              background: "white",
              actorId: '',
              films: []
            }
        },
        methods: 
        {
            getMovies: function(actorId)
            {
                this.films = [];
                let self = this;
                fetch(this.urlBase+'actors/'+actorId+'/films')
                .then(function(response) {
                return response.json();
                })
                .then(function(films) {
                    for (var film of films) {
                        self.films.push(film);
                    }
                });
          }
       },
    }
    
</script>


