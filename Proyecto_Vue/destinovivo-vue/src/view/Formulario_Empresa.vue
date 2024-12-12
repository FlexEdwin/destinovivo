<template>

  <Mheader></Mheader>
  <div class="formulario-view">
    <Insertar_Empresa></Insertar_Empresa>
  </div>

</template>

<script setup>
import Insertar_Empresa from '@/components/Insertar_Empresa.vue';
import Mheader from '@/components/Mheader.vue';
</script>

<style scoped>
    .formulario-view {
    text-align: center;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    padding: 20px;
    }
    
    .formulario-title {
    padding: 20px;
    }
</style>
