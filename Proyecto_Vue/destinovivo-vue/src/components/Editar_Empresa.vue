<template>
    <div class="editar-empresa-view">
      <h1 class="editar-title">Editar Empresa</h1>
      <form @submit.prevent="guardarCambios">
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <input type="text" v-model="empresa.nombre" id="nombre" required />
        </div>
        <div class="form-group">
          <label for="direccion">Dirección:</label>
          <input type="text" v-model="empresa.direccion" id="direccion" required />
        </div>
        <div class="form-group">
          <label for="descripcion">Descripción:</label>
          <textarea v-model="empresa.descripcion" id="descripcion" required></textarea>
        </div>
        <div class="form-group">
          <label for="horario">Horario:</label>
          <input type="text" v-model="empresa.horario" id="horario" required />
        </div>
        <div class="form-group">
          <label for="telefono">Teléfono:</label>
          <input type="text" v-model="empresa.telefono" id="telefono" required />
        </div>
        <div class="form-group">
          <label for="correo">Correo:</label>
          <input type="email" v-model="empresa.correo" id="correo" required />
        </div>
        <div class="form-group">
          <label for="imagen">Imagen URL:</label>
          <input type="text" v-model="empresa.imagen" id="imagen" />
        </div>
        <button type="submit" class="btn btn-success">Guardar Cambios</button>
        <button @click="cancelar" class="btn btn-secondary">Cancelar</button>
      </form>
      <div v-if="error" class="error-message">
        <p>Error: {{ error }}</p>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { useRoute, useRouter } from 'vue-router';
  
  const route = useRoute();
  const router = useRouter();
  const empresa = ref({});
  const error = ref(null);
  
  async function cargarDatos() {
    try {
      const respuesta = await fetch(`http://localhost:8080/empresas/consultar/${route.params.id}`);
      if (!respuesta.ok) throw new Error(`Error: ${respuesta.status} ${respuesta.statusText}`);
      empresa.value = await respuesta.json();
    } catch (err) {
      error.value = err.message;
    }
  }
  
  onMounted(() => {
    cargarDatos(); // Cargar los datos de la empresa al montar el componente
  });
  
  async function guardarCambios() {
    try {
      const respuesta = await fetch(`http://localhost:8080/empresas/editar/${empresa.value.id_empresa}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(empresa.value),
      });
  
      if (!respuesta.ok) throw new Error(`Error: ${respuesta.status} ${respuesta.statusText}`);
      await respuesta.json();
      alert("Los cambios fueron guardados exitosamente"); // Agregar mensaje de confirmación
    router.push(`/detalle_empresa`); // Redirigir a la página de detalles de la empresarouter.push(`/detalle_empresa/${empresa.value.id_empresa}`);
    } catch (err) {
      error.value = err.message;
    }
  }
  
  function cancelar() {
    router.push('/administrar-empresa'); // Redirigir al listado de empresas
  }
  </script>

  
  <style scoped>
  .editar-empresa-view {
    text-align: center;
    padding: 20px;
    background-color: #f8f9fa;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  .error-message {
    color: red;
  }
  </style>