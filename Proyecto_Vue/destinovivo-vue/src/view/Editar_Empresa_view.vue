<template>
    <Mheader></Mheader>
    <div class=" editar-empresa-view">
      <Editar_Empresa></Editar_Empresa>  
    </div>
    
</template>


<script setup>
    import Mheader from '@/components/Mheader.vue';
    import Editar_Empresa from '@/components/Editar_Empresa.vue';
</script>



<style scoped>
.editar-empresa-view{
    text-align: center;
    font-style: normal;
    padding: 20px;
    }



</style>