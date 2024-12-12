<template>
    <div class="eliminar-empresa-view">
      <h1 class="eliminar-title">Eliminar Empresa</h1>
      <button @click="consultarEmpresa(empresaId)" class="btn btn-primary">Consultar Empresa con ID "{{ empresaId }}"</button>
      
      <div v-if="empresa" class="empresa-details">
        <h2>Detalles de la Empresa</h2>
        <p><strong>ID:</strong> {{ empresa.id_empresa }}</p>
        <p><strong>Nombre:</strong> {{ empresa.nombre }}</p>
        <p><strong>Dirección:</strong> {{ empresa.direccion }}</p>
        <p><strong>Descripción:</strong> {{ empresa.descripcion }}</p>
        <p><strong>Horario:</strong> {{ empresa.horario }}</p>
        <p><strong>Teléfono:</strong> {{ empresa.telefono }}</p>
        <p><strong>Correo:</strong> {{ empresa.correo }}</p>
        <img :src="empresa.imagen" alt="Imagen de la empresa" width="100" />
        
        <button @click="eliminarDato(empresa.id_empresa)" class="btn btn-danger">Confirmar Eliminación</button>
      </div>
  
      <div v-if="error" class="error-message">
        <p>Error: {{ error }}</p>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  
  const router = useRouter();
  const empresaId = ref(0); // ID de la empresa a eliminar
  const empresa = ref(null);
  const error = ref(null);
  
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
  
  async function eliminarDato(id) {
  try {
    const respuesta = await fetch(`http://localhost:8080/empresas/eliminar/${id}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      // No es necesario enviar un cuerpo para la eliminación
    });
    if (!respuesta.ok) {
      throw new Error(`Error: ${respuesta.status} ${respuesta.statusText}`);
    }
    const message = await respuesta.text();
    console.log(message);
    empresa.value = null; // Limpiar la empresa después de eliminar
    alert('Empresa eliminada con éxito');
    router.push({ name: 'detalle_empresa' }); // Redirigir a la vista de detalles o a donde desees
  } catch (err) {
    error.value = err.message; // Manejo de errores
  }
}
  </script>
  
  <style scoped>
  .eliminar-empresa-view {
    text-align: center;
    padding: 20px;
    background-color: #f8f9fa;
  }
  .eliminar-title {
    font-size: 24px;
    font-weight: bold;
    color: #343a40;
  }
  .empresa-details {
    margin-top: 20px;
  }
  .error-message {
    color: red;
    margin-top: 20px;
    font-weight: bold;
  }
  .btn {
    margin: 5px;
  }
  </style>