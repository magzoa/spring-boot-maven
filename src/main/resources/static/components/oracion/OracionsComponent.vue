<template>

  <div class="row">
    <div class="col-sm-3">

    </div>
    <div class="col-sm-6">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Registro de Oraciones</h5>


          <form @submit.prevent="saveOracion">
            <div class="form-group">
              <label for="descripcion">Descripción</label>
              <input type="text" class="form-control" id="descripcion" aria-describedby="descripcionHelp" placeholder="Descripción" v-model="oracion.descripcion">
              <small id="descripcionHelp" class="form-text text-muted">Escriba una descrpción para la oración.</small>
            </div>

            <div class="form-group">
              <label for="texto">Texto</label>
              <input type="text" class="form-control" id="texto" aria-describedby="textoHelp" placeholder="Texto" v-model="oracion.texto">
              <small id="textoHelp" class="form-text text-muted">Texto de la Oración</small>
            </div>

            <div class="form-group">
              <label for="nivel">Nivel</label>
              <input type="number" class="form-control" id="nivel" aria-describedby="nivelHelp" placeholder="Nivel" v-model="oracion.nivel">
              <small id="nivelHelp" class="form-text text-muted">Nivel de complejidad de la oración</small>
            </div>






            <button type="submit" class="btn btn-primary">Registrar</button>
          </form>







        </div>
      </div>
      <!-- fin card formulario -->



      <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Descripción</th>
          <th scope="col">Texto</th>
          <th scope="col">Nivel</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="oracion in oracions" :key="oracion.id">
          <th scope="row">#</th>
          <td>{{oracion.descripcion}}</td>
          <td>{{oracion.texto}}</td>
          <td>{{oracion.nivel}}</td>
          <td>
              <button @click="editar(oracion)" class="btn">Create</button>
              <button @click="eliminar(oracion)" class="btn">REmove</button>
            </td>
        </tr>
      </tbody>
    </table>






    </div>
  </div>
    




</template>

<script>
import Oracion from '../../services/oracions'




export default {
  name: 'OracionsComponent',
  props: {
    msg: String
  },data(){
			return {
				oracions: [],
        oracion:{
        id:'',
        descripcion: '',
				texto: '',
        nivel:''
        }
        
			}
    },mounted(){
      this.listar()
    },
    methods:{
      listar(){
    Oracion.listar().then(resposta=>{
    console.log(resposta.data)
    this.oracions=resposta.data
  })
  },saveOracion(){

      if(!this.oracion.id){
        Oracion.save(this.oracion).then(resposta=>{
        this.oracion={}
        alert('Guardado exitoso!!')
        this.listar();
        this.errors=[]
        }).catch(e=>{
        this.errors=e.response.data.errors
        })
      }else{
         Oracion.update(this.oracion).then(resposta=>{
        this.oracion={}
        alert('Actulización exitosa!!')
        this.listar();
        this.errors=[]
        }).catch(e=>{
        this.errors=e.response.data.errors
        })
      }

      
    },
    editar(oracion){
      this.oracion = oracion


    },
    eliminar(oracion){

        if(confirm('Desea remover el producto')){
        
        Oracion.delete(oracion).then(resposta=>{
          this.listar();
          this.errors=[]

        }).catch(e=>{

          this.errors =e.response.data.errors

        })

        }


        


    }




    }
}



</script>


<style scoped>




</style>