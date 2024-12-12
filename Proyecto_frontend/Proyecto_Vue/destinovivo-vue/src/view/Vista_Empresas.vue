<template>
    <Mheader></Mheader>
    <div class="formulario-view">
    <Listar_Empresas></Listar_Empresas>
  </div>
</template>

<script setup>
import Listar_Empresas from '@/components/Listar_Empresas.vue';
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