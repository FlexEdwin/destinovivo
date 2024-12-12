<template>
    <div class="detalle-empresa-view">
        <Mheader></Mheader>
        <main>
        <Administrar_Empresa></Administrar_Empresa>
        </main>
    </div>
</template>

<script setup>
    import Mheader from '@/components/Mheader.vue';
    import Administrar_Empresa from '@/components/Administrar_Empresa.vue';
</script>


<style scoped>

.detalle-empresa-view {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
    }


    main {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
    padding: 20px;
    box-sizing: border-box;
    }
</style>