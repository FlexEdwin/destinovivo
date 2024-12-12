<template>
<<<<<<< HEAD:Proyecto_frontend/Proyecto_Vue/destinovivo-vue/src/view/Formulario_Usuario.vue

    <Mheader></Mheader>


    <div class="formulario-view">
        <Insertar_Usuario></Insertar_Usuario>
    
    </div>
=======
        <Mheader></Mheader>
 <div>
        <Listar_Usuarios></Listar_Usuarios>  
  </div>
>>>>>>> origin:Proyecto_Vue/destinovivo-vue/src/view/Formulario_Usuario.vue
</template>

<script setup>
import Listar_Usuarios from '@/components/Listar_Usuarios.vue';
import Mheader from '@/components/Mheader.vue';
</script>


<style scoped>
    .formulario-view {
    text-align: center;
    font-style: normal;
    padding: 20px;
    }
    .formulario-title {
    text-align: left;
    font-size: large;
    font-style: normal;
    padding: 20px;
    }
</style>