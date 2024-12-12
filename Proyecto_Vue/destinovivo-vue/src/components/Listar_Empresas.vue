<template>
    <div>
        <h1>Listado de Empresas</h1>
        <div class="row">
            <div class="col-md-4" v-for="(item, index) in data" :key="index">
                <div class="card mb-3" style="width: 18rem;">
                    <img :src="item.imagen" class="card-img-top" alt="Imagen de la empresa">
                    <div class="card-body">
                        <h5 class="card-title">{{item.nombre}}</h5>
                        <p class="card-text">{{item.descripcion}}</p>
                        <p class="card-text"><strong>Teléfono: </strong>{{item.telefono}}</p>
                        <router-link to ="/ACA RUTA AL DETALLE DE LA EMPRESA" class="btn">Ver más</router-link>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
const data = ref([]);
const mensaje = ref("null");

const Listar_Empresas = async () => {
    try {
        const empresas = await fetch("http://localhost:8080/empresas/consultar", {
            method: "GET"
        });
        if (!empresas.ok) {
            throw new Error("Error al listar empresas");
        }
        data.value = await empresas.json();
    } catch (error) {
        mensaje.value = error.message;
    }
};

onMounted(() => {
    Listar_Empresas();
});
</script>

<style scoped>
    h1 {
        text-align: center;
        margin: 50px;
        font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    }

    .btn {
        text-decoration: none;
        color: white;
        font-size: 15px;
        font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        padding: 8px 15px;
        border-radius: 10px;
        background-color: #333;
    }

    .btn:hover {
        background-color: #4caf50;
        text-decoration: none;
        color: white;
    }

    .card {
        font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        text-align: center;
    }

    img{
        width: 18rem;
        height: 18rem;
    }
    

</style>
