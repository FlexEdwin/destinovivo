<template>
  <div class="consultar-empresa-view">

    <h1 class="consultar-title">Consultar Empresa</h1>
    <button @click="consultarEmpresa(3)" class="btn btn-primary">Consultar Empresa con ID "3"</button>
    
    <div v-if="empresa" class="empresa-table">
      <h2>Detalles de la Empresa</h2>

      <table class="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Dirección</th>
            <th>Descripción</th>
            <th>Horario</th>
            <th>Teléfono</th>
            <th>Correo</th>
            <th>Imagen</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{{ empresa.id_empresa }}</td>
            <td>{{ empresa.nombre }}</td>
            <td>{{ empresa.direccion }}</td>
            <td>{{ empresa.descripcion }}</td>
            <td>{{ empresa.horario }}</td>
            <td>{{ empresa.telefono }}</td>
            <td>{{ empresa.correo }}</td>
            <td><img :src="empresa.imagen" alt="Imagen de la empresa" width="50" /></td>
            <td>
              <button @click="irAEditar(empresa)">Editar Empresa</button>
              <button @click="eliminarDato(empresa.id_empresa)" class="btn btn-danger">Eliminar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    
    <div v-if="error" class="error-message">
      <p>Error: {{ error }}</p>
    </div>
    
    
  </div>
</template>

<script setup>

import { ref } from 'vue';
//mod 1
import { useRouter } from 'vue-router';

const router = useRouter();
const empresa = ref(null);
const error = ref(null);

function irAEditar(empresaData) {
  // Redirigir a la página de edición pasando el ID de la empresa
  router.push({ name: 'editar_empresa', params: { id: empresaData.id_empresa } });
}


async function consultarEmpresa(id_empresa) {
  try {
    const respuesta = await fetch(`http://localhost:8080/empresas/consultar/${id_empresa}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!respuesta.ok) {
      throw new Error(`Error: ${respuesta.status} ${respuesta.statusText}`);
    }

    const data = await respuesta.json();
    empresa.value = data;
    error.value = null; // Limpiar errores anteriores
  } catch (err) {
    error.value = err.message; // Manejo de errores
    empresa.value = null; // Limpiar datos anteriores
  }
}

async function editarDato(empresaData) {
  // Aquí puedes modificar los datos que deseas editar antes de enviarlos
  const updatedEmpresa = { ...empresaData }; // Por ejemplo, podrías abrir un formulario para editar

  try {
    const respuesta = await fetch(`http://localhost:8080/empresas/editar/${empresaData.id_empresa}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(updatedEmpresa),
    });

    if (!respuesta.ok) {
      throw new Error(`Error: ${respuesta.status} ${respuesta.statusText}`);
    }

    const data = await respuesta.json();
    console.log('Empresa editada:', data);
    empresa.value = data; // Actualizar la variable empresa con los nuevos datos
  } catch (err) {
    error.value = err.message; // Manejo de errores
  }
}

async function eliminarDato(id) {
  try {
    const respuesta = await fetch(`http://localhost:8080/empresas/eliminar/${id}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!respuesta.ok) {
      throw new Error(`Error: ${respuesta.status} ${respuesta.statusText}`);
    }

    const message = await respuesta.text();
    console.log(message);
    empresa.value = null; // Limpiar la empresa después de eliminar
  } catch (err) {
    error.value = err.message; // Manejo de errores
  }
}

</script>

<style scoped>

.consultar-empresa-view {
  text-align: center;
  font-style: normal;
  padding: 20px;
  background-color: #f8f9fa; /* Fondo claro */
}

.consultar-title {
  text-align: left;
  font-size: 24px; /* Tamaño de fuente más grande */
  font-weight: bold; /* Negrita */
  padding: 20px;
  color: #343a40; /* Color oscuro */
}

.empresa-table {
  margin-top: 20px;
  border: 1px solid #dee2e6; /* Borde de la tabla */
  border-radius: 0.25rem; /* Bordes redondeados */
  overflow: hidden; /* Para bordes redondeados */
}

.table {
  width: 100%; /* Ancho completo */
  border-collapse: collapse; /* Colapsar bordes */
}

.table th, .table td {
  padding: 12px; /* Espaciado interno */
  text-align: left; /* Alinear texto a la izquierda */
  border-bottom: 1px solid #dee2e6; /* Borde inferior */
}

.table th {
  background-color: #e9ecef; /* Fondo de encabezados */
  font-weight: bold; /* Negrita para encabezados */
}

.error-message {
  color: red; /* Color rojo para errores */
  margin-top: 20px;
  font-weight: bold; /* Negrita para destacar errores */
}

.btn {
  margin: 5px; /* Espaciado entre botones */
}
</style>