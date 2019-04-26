<template>
    <div id="AddActor">
        <v-layout>
            <v-flex>
            <v-text-field
                v-model="newActor.firstName"
                label="Nombre"
                prepend-icon="person"
            ></v-text-field>
            </v-flex>
            <v-flex>
            <v-text-field class="ml-5"
                v-model="newActor.lastName"
                label="Apellido"
            > </v-text-field>
            </v-flex>
            <v-flex>
                <v-btn :class="['white--text','green']" @click="addActor">Enviar</v-btn>
            </v-flex>
        </v-layout>
        <v-layout>
            <v-flex>
            <v-alert :color="alertType"
                v-model="alert"
                dismissible
            >
                {{alertMessage}}
            </v-alert>
            </v-flex>
        </v-layout>    
    </div>
</template>

<script>
    export default {
        props: ['actorsList'],
        data() {
            return {
                alert: false,
                alertMessage: '',
                alertType: 'success',
                urlBase: 'http://localhost:8081/',
                newActor: 
                {
                    firstName: '',
                    lastName: '',
                    lastUpdate: ''
                },
            }
        },
        methods: 
        {
            addActor: function()
            {
                console.log(this.newActor);
                if (this.newActor.firstName != '' && this.newActor.lastName != '') 
                {
                    let self = this;
                    fetch(this.urlBase+'actors/add', {
                    method: 'POST',
                    body: JSON.stringify(this.newActor),
                    headers:{
                        'Content-Type': 'application/json'
                    }
                    })
                    .then(res => res.json())
                    .catch(error => console.error('Error:', error))
                    .then(response =>
                    {
                        console.log('Success:', response); 
                        self.actorsList.unshift(response);
                        self.newActor = {
                            firstName: '',
                            lastName: '',
                            lastUpdate: ''
                        };
                        this.alert = true;
                        this.alertMessage = "Actor agregado con éxito"; 
                    });
                }
                else
                {
                this.alert = true;
                this.alertType = 'error';
                this.alertMessage = "Actor no registrado, llenar nombre y apellido del actor"; 
                }
            } 
        }
    }
</script>

