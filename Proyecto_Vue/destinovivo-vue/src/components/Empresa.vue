<template>

    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Direccion</th>
                <th scope="col">Descripcion</th>
                <th scope="col">Horario</th>
                <th scope="col">Telefono</th>
                <th scope="col">Correo</th>
                <th scope="col">Contraseña</th>
                <th scope="col">Imagen</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(item,index) in data" :key="index">
                <td>{{ item.id_empresa }}</td>
                <td>{{ item.nombre }}</td>
                <td>{{ item.direccion }}</td>
                <td>{{ item.descripcion }}</td>
                <td>{{ item.horario }}</td>
                <td>{{ item.telefono }}</td>
                <td>{{ item.correo }}</td>
                <td>{{ item.contrasena }}</td>
                <td>{{ item.imagen }}</td>
                <router-link to ="/Vista_Empresa" class="btn">Eliminar</router-link>
                
            </tr>
        </tbody>
    </table>
    <div><button type="button" class="btn btn-primary"></button>Nueva Empresa</div>
</template>

<script setup>
import { ref, onMounted } from 'vue';   
const data = ref ([])
const mensaje = ref("null")

const Listar_Empresa=async()=>{
    try{
        const empresas=await fetch ("http://localhost:8080/empresas/consultar",
        {
            method: "GET"

        })
        if (!empresas.ok){
            throw new Error ("error")
        }
        data.value=await empresas.json();
    } catch (error){
        mensaje.value=error.mensaje
    }
}
onMounted(()=>{
    Listar_Empresa();
})

</script>