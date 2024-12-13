<template>
  <div class="posidod">
    <Mheader></Mheader>
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
          <td>{{ item.documento }}</td>
          <td>{{ item.nombre }}</td>
          <td>{{ item.correo }}</td>
          <td>{{ item.telefono }}</td>
          <td>{{ item.nacionalidad }}</td>
          <td>{{ item.fecha_nacimiento }}</td>
          <td><button class="btn btn-primary" @click="Editar_Usuario(item.documento)">Editar</button></td>
          <td><button class="btn btn-danger" @click="modalDel = false; Eliminar_Usuario(item.documento)">Eliminar</button>
          </td>

        </tr>
      </tbody>
    </table>

    <div><button class="btn btn-primary" @click="Nuevo_Usuario()">Nuevo Usuario</button></div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import Mheader from './Mheader.vue';

// Definir las variables reactivas
const data = ref([])
const mensaje = ref("null")

// Inicializar el router
const router = useRouter();

// Función para listar los usuarios
const Listar_Usuario = async () => {
  try {
    const usuarios = await fetch("http://localhost:8080/usuarios/consultar",
      {
        method: "GET",

      });
    if (!usuarios.ok) {
      throw new Error("Error al consultar los datos");
    }
    data.value = await usuarios.json();
  } catch (error) {
    mensaje.value = error.mensaje;
  }
};

// Llamar la función listarUsuarios cuando el componente se monta
onMounted(() => {
  Listar_Usuario();
});

// Función para editar usuario, redirige al componente de editar
const Editar_Usuario = async (documento) => {
  router.push({ name: 'Editar_Usuario/:documento', params: { documento } });
};

// Función para eliminar usuario
const Eliminar_Usuario = async (documento) => {
  try {
    const response = await fetch(`http://localhost:8080/usuarios/eliminar/${documento}`,
      {
        method: "DELETE",

      });
    if (!response.ok) {
      const errorData = await response.json();
      throw new Error(errorData.message || "Error al eliminar el usuario");
    }
    Listar_Usuario();
  } catch (error) {
    mensaje.value = error.mensaje;
  }
};

// Función para agregar nuevo usuario
const Nuevo_Usuario = async (documento) => {
  router.push({ name: 'Insertar_Usuario' });
};

</script>
