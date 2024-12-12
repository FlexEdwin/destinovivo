<template>
 <div class="formulario-empresa">
       
    <!-- Formulario de empresa -->
    <form @submit.prevent="Insertar_Empresa()">

      <div class="form-group">
        <label for="id_empresa">Código de la Empresa:</label>
        <input
          type="number"
          id="id_empresa"
          v-model="frm.id_empresa"
          placeholder="Ingresa el código de la empresa"
          required
        />
      </div>

      <div class="form-group">
        <label for="nombre">Nombre de la Empresa:</label>
        <input
          type="text"
          id="nombre"
          v-model="frm.nombre"
          placeholder="Ingresa el nombre de la empresa"
          required
        />
      </div>
      
      <div class="form-group">
        <label for="direccion">Dirección:</label>
        <input
          type="text"
          id="direccion"
          v-model="frm.direccion"
          placeholder="Ingresa la dirección"
          required
        />
      </div>

      <div class="form-group">
        <label for="descripcion">Descripción:</label>
        <input
          type="text"
          id="descripcion"
          v-model="frm.descripcion"
          placeholder="Ingresa la descripcion"
          required
        />
      </div>

      <div class="form-group">
        <label for="horario">Horario:</label>
        <input
          type="text"
          id="horario"
          v-model="frm.horario"
          placeholder="Ingresa el Horario"
          required
        />
      </div>
      
      <div class="form-group">
        <label for="telefono">Telefono:</label>
        <input
          type="number"
          id="telefono"
          v-model="frm.telefono"
          placeholder="Ingresa el Telefono"
          required
        />
      </div>

      <div class="form-group">
        <label for="email">Correo Electrónico:</label>
        <input
          type="email"
          id="email"
          v-model="frm.correo"
          placeholder="Ingresa el correo electrónico"
          required
        />
      </div>

      <div class="form-group">
        <label for="contrasena">Contraseña:</label>
        <input
          type="password"
          id="contrasena"
          v-model="frm.contrasena"
          placeholder="Ingresa la contraseña"
          required
        />
      </div>

      <div class="form-group">
        <label for="imagen">Imagen:</label>
        <input
          type="text"
          id="imagen"
          v-model="frm.imagen"
          placeholder="Ingresa URL de la Imagen"
          required
        />
      </div>

      <button type="submit" class="btn-submit">Enviar</button>
    </form>

    <!-- Mensaje de éxito después del envío -->
    <div class="mensaje-exito" v-if="mensajeExito">
      <p>Formulario enviado con éxito!</p>
    </div>
  </div>

</template>

<script setup>
import { ref } from 'vue';

// Estado del formulario
const frm = ref({
  id_empresa: '',
  nombre: '',
  direccion: '',
  descripcion: '',
  horario: '',
  telefono: '',
  correo: '',
  contrasena: '',
  imagen: ''
});

//estado para mostrar el mensaje de registo exitoso
const mensajeExito = ref(false);

const Insertar_Empresa = async () => {
  try {
    // Enviar datos a la API
    const respuesta = await fetch('http://localhost:8080/empresas/insertar', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(frm.value)
    });

    if (respuesta.ok) {
      //mostrar mensaje de éxito
      mensajeExito.value = true;

      //limpiar los campos formulario después del envío
      frm.value = {
        id_empresa:'',
        nombre: '',
        direccion: '',
        descripcion: '',
        horario: '',
        telefono: '',
        correo: '',
        contrasena: '',
        imagen: ''
      };
      //ocultar mensaje después de 3 segundos
      setTimeout(() => {
        mensajeExito.value = false;
      }, 3000);
    }
  } catch (error) {
    console.error('Error al insertar la empresa:', error);
  }
};
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
</style>
