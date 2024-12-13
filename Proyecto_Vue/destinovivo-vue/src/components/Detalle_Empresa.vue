<template>
  <div class="posidod">
    <Mheader></Mheader>
<div class="formulario-empresa">       
        <!-- Formulario de empresa -->
        <form>
   
          <div class="form-group">
            <label for="nombre">Nombre de la Empresa:</label>
            <label id="nombre">{{ frm.nombre }}</label>
            
          </div>
          
          <div class="form-group">
            <label for="direccion">Dirección:</label>
            <label id="direccion">{{ frm.direccion }}</label>
            
          </div>
    
          <div class="form-group">
            <label for="descripcion">Descripción:</label>
            <label id="descripcion">{{ frm.descripcion }}</label>
            
          </div>
    
          <div class="form-group">
            <label for="horario">Horario:</label>
            <label id="horario">{{ frm.horario }}</label>
            
          </div>
          
          <div class="form-group">
            <label for="telefono">Telefono:</label>
            <label id="telefono" >{{ frm.telefono }}</label>
            
          </div>
    
          <div class="form-group">
            <label for="email">Correo Electrónico:</label>
             <label id="email">{{ frm.correo }}</label>
            
          </div>
    
          <div class="form-group">
            <label for="imagen">Imagen:</label>
            <img :src="frm.imagen" >          
        </div>
    </form>
</div>
</div>
</template>

<script setup>

import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import Mheader from './Mheader.vue';

const data = ref([])
const mensaje = ref("null")
// Inicializar el router
const router = useRouter();

const frm = ref(({
   id_empresa: '',
   nombre: '',
   direccion: '',
   descripcion: '',
   horario: '',
   telefono: '',
   correo: '',
   contrasena: '',
   imagen: ''
}))

const Consultar_Empresa = async () => {
    try {
        const id_empresa = router.currentRoute.value.params.id_empresa;
        const empresa = await fetch(`http://localhost:8080/empresas/consultar/${id_empresa}`,
            {
                method: "GET"

            })
        if (!empresa.ok) {
            throw new Error("Error al consultar los datos");
        }
        const empresaData = await empresa.json();

        frm.value = {

            id_empresa: empresaData.id_empresa,
            nombre: empresaData.nombre,
            direccion: empresaData.direccion,
            descripcion: empresaData.descripcion,
            horario: empresaData.horario,
            telefono: empresaData.telefono,
            correo: empresaData.correo,
            contrasena: empresaData.contrasena,
            imagen: empresaData.imagen

        };

    } catch (error) {
        mensaje.value = error.mensaje;
    }
}

onMounted(() => {
    Consultar_Empresa();
})

</script>

<style scoped>
   .formulario-empresa {
     max-width: 500px;
     margin: 0 auto;
     padding: 20px;
     background-color: #f9f9f9;
     border-radius: 8px;
     box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
   }
   label{
     text-align: left;
     font-size: 14px;
     font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
     display: block;
     margin-bottom: 5px;
     font-weight: bold;
   }
   .form-group {
     margin-bottom: 15px;
     margin: 20px;
   }
 
   input {
     width: 100%;
     padding: 8px;
     border: 1px solid #ccc;
     border-radius: 8px;
     font-size: 12px;
   }
 
   button {
     padding: 10px 20px;
     background-color: #4caf50;
     color: white;
     border: none;
     border-radius: 4px;
     cursor: pointer;
   }
 
   button:hover {
     background-color: #4565a0;
   }
 
   .mensaje-exito {
     margin-top: 20px;
     background-color: #d4edda;
     color: #155724;
     padding: 10px;
     border-radius: 4px;
   }

   img{
    width: 10rem;
    height: 10rem;
   }
 </style>
 