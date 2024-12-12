import { createRouter, createWebHistory } from "vue-router";
import Home from "@/view/Home.vue";
import Formulario_Empresa from "@/view/Formulario_Empresa.vue";
import Formulario_Resena from "@/view/Formulario_Resena.vue";
import Listar_Usuarios from "@/components/Listar_Usuarios.vue";
import Insertar_Usuario from "@/components/Insertar_Usuario.vue";
import Editar_Usuario from "@/components/Editar_Usuario.vue";

import Formulario_Usuario from "@/view/Formulario_Usuario.vue";

const routes=[

    {
        path: '/',
        name: 'home',
        component: Home

    },
    {
        path: '/insertar_Empresa',
        name: 'insertar_Empresa',
        component: Formulario_Empresa

    },
    {
        path: '/Listar_Usuarios',
        name: 'Listar_Usuarios',
        component: Listar_Usuarios

    },
    {
        path: '/Insertar_Usuario',
        name: 'Insertar_Usuario',
        component: Insertar_Usuario

    },
    {
        path: '/Editar_Usuario/:documento',
        name: 'Editar_Usuario/:documento',
        component: Editar_Usuario,
        props: true,

    },

]

    const router=createRouter({
        history:createWebHistory(),
        routes,
    });

    export default router;
