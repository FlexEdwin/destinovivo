<template>
        <Mheader></Mheader>
 <div>
        <Listar_Usuarios></Listar_Usuarios>  
  </div>
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