<template>
    <v-container grid-list-xl>
        <VLayout row wrap>

            <v-flex xs12 md6>
                <v-card class="mb-3" v-for="(tarea, index) in listaTareas" :key="index">
                    <v-card-text>
                        <v-chip label color="pink" text-color="white" class="ml-0">
                            <v-icon left>label</v-icon>{{tarea.titulo}}
                        </v-chip>
                        <p>{{tarea.descripcion }}</p>
                        <v-btn color="warning" @click="editar(tarea.id)" class="ml-0">Editar</v-btn>
                        <v-btn color="error" @click="eliminarTarea(tarea.id)">Eliminar</v-btn>
                    </v-card-text>
                </v-card>

            </v-flex >

            <v-flex xs12 md6 v-if="addForm">
                <v-card class="mb-3 pa-3">
                    <v-form @submit.prevent="agregarTarea">
                        <v-text-field
                            v-model="titulo"
                            label="Titulo de la tarea"
                        ></v-text-field>
                        <v-textarea
                            v-model="descripcion"
                            label="Descripcion de la tarea"
                        ></v-textarea>
                        <VBtn block color="success" type="submit">Agregar Tarea</VBtn>
                    </v-form>
                </v-card>
            </v-flex>

            <v-flex xs12 md6 v-if="!addForm">
                <v-card class="mb-3 pa-3">
                    <v-form @submit.prevent="editarTarea">
                        <v-text-field
                            v-model="titulo"
                            label="Titulo de la tarea"
                        ></v-text-field>
                        <v-textarea
                            v-model="descripcion"
                            label="Descripcion de la tarea"
                        ></v-textarea>
                        <VBtn block color="warning" type="submit">Editar Tarea</VBtn>
                    </v-form>
                </v-card>
            </v-flex>

        </VLayout>
        <v-snackbar
      v-model="snackbar"
    >
      {{ mensaje }}
      <v-btn
        color="pink"
        flat
        @click="snackbar = false"
      >
        Cerrar
      </v-btn>
    </v-snackbar>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            titulo:'',
            descripcion:'',
            snackbar: false,
            mensaje:'',
            addForm: true,
            indexEditar: '',
            listaTareas: [
                {id:1,titulo:'Titulo tarea 1', descripcion:'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit architecto odio voluptas dicta vel iure unde cum quod, perferendis quibusdam, consectetur amet atque maiores culpa a id natus reiciendis dolorem.'},
                {id:2,titulo:'Titulo tarea 2', descripcion:'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit architecto odio voluptas dicta vel iure unde cum quod, perferendis quibusdam, consectetur amet atque maiores culpa a id natus reiciendis dolorem.'}
            ]
        }
    },
    methods: {
        agregarTarea(){
            if (this.titulo === '' || this.descripcion === '') {
                this.snackbar = true;
                this.mensaje = 'No debe dejar ningun campo en blanco para ingresar su tarea';
            }else{
                this.listaTareas.push({
                    id: Date.now(),
                    titulo: this.titulo,
                    descripcion: this.descripcion
                })
                this.snackbar = true;
                this.mensaje = 'Tarea añadida!';
                this.titulo = '';
                this.descripcion = '';
            }
        },
        eliminarTarea(id){
            this.listaTareas = this.listaTareas.filter(e => e.id != id)
        },
        editar(index){
            
            this.addForm = false;
            this.titulo = this.listaTareas[index].titulo;
            this.descripcion = this.listaTareas[index].descripcion;
            this.indexEditar = index;
        },
        editarTarea(){
            if (this.titulo === '' || this.descripcion === ''){
                this.snackbar = true;
                this.mensaje = 'No debe dejar ningun campo en blanco al editar su tarea';
                
            }else{
                this.listaTareas[this.indexEditar].titulo = this.titulo;
                this.listaTareas[this.indexEditar].descripcion = this.descripcion;
                this.titulo =''
                this.descripcion =''
                this.addForm = true;
                this.snackbar = true;
                this.mensaje = 'Tarea editada con éxito'
            }
        }
    }
}
</script>
