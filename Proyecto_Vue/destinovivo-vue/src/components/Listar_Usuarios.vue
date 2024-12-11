<template>
    <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Documento</th>
      <th scope="col">Nombre</th>
      <th scope="col">Correo</th>
      <th scope="col">Telefono</th>
      <th scope="col">Nacionalidad</th>
      <th scope="col">Fecha de nacimiento</th>
      <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="(item, index) in data" :key="index">
      <td>{{item.documento}}</td>
      <td>{{item.nombre}}</td>
      <td>{{item.correo}}</td>
      <td>{{item.telefono}}</td>
      <td>{{item.nacionalidad}}</td>
      <td>{{item.fecha_nacimiento}}</td>
      <td ><button @click="Editar_Usuario(item.documento)">Editar</button> <button>Eliminar</button></td>
    </tr>
  </tbody>
</table>

<div><router-link to ="/Insertar_Usuario">Nuevo usuario</router-link></div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

// Definir las variables reactivas
const data = ref([])
const mensaje = ref("null")

// Inicializar el router
const router = useRouter();

// Función para listar los usuarios
const Listar_Usuario=async()=>{
    try{
        const usuarios=await fetch ("http://localhost:8080/usuarios/consultar",
        {
            method:"GET",
            
        });
        if (!usuarios.ok){
            throw new Error ("Error al consultar los datos");
        }
        data.value=await usuarios.json();
      }catch (error){
        mensaje.value=error.mensaje;
      }
    };

    // Llamar la función listarUsuarios cuando el componente se monta
    onMounted(()=>{
        Listar_Usuario();
    });

    // Función para editar usuario, redirige al componente de editar
    const Editar_Usuario=async(documento)=>{
      router.push({ name: 'Editar_Usuario/:documento', params: {documento}});
    
};

</script>
