<template>
    <div class="posidod">
        <Mheader></Mheader>
        <div class="formulario-usuario">

            <!-- Mostrar mensaje de éxito o error -->
            <div v-if="mensaje"
                :class="{ 'alert': true, 'alert-success': mensaje.type === 'success', 'alert-danger': mensaje.type === 'error' }">
                {{ mensaje.text }}
            </div>

            <!-- Formulario de empresa -->
            <form @submit.prevent="Editar_Usuario()">
                <div class="form-group-Usuario">
                    <label for="documento">Documento:</label>
                    <input type="text" id="documento" v-model="frm.documento" required />
                </div>

                <div class="form-group-Usuario">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" v-model="frm.nombre" required />
                </div>

                <div class="form-group-Usuario">
                    <label for="correo">Correo Electrónico:</label>
                    <input type="text" id="correo" v-model="frm.correo" required />
                </div>

                <div class="form-group-Usuario">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" id="telefono" v-model="frm.telefono" required />
                </div>

                <div class="form-group-Usuario">
                    <label for="nacionalidad">Nacionalidad:</label>
                    <input type="nacional" id="nacionalidad" v-model="frm.nacionalidad" required />
                </div>

                <div class="form-group-Usuario">
                    <label for="fecha_nacimiento">Fecha de Nacimiento:</label>
                    <input type="fechanaci" id="fechanaci" v-model="frm.fecha_nacimiento" required />
                </div>

                <button class="btn btn-success">Enviar</button>
            </form>
            <br>
            <button class="btn btn-info" @click="Regresar1(documento)">Regresar</button>
        </div>
    </div>
</template>


<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import Mheader from './Mheader.vue';

const data = ref([])
const mensaje = ref("null")
// Inicializar el router
const router = useRouter();

const frm = ref(({
    documento: "",
    nombre: "",
    correo: "",
    telefono: "",
    nacionalidad: "",
    fecha_nacimiento: ""
}))

const Consultar_Usuario = async () => {
    try {
        const documento = router.currentRoute.value.params.documento;
        const usuario = await fetch(`http://localhost:8080/usuarios/consultar/${documento}`,
            {
                method: "GET"

            })
        if (!usuario.ok) {
            throw new Error("Error al consultar los datos");
        }
        const usuarioData = await usuario.json();

        frm.value = {
            documento: usuarioData.documento,
            nombre: usuarioData.nombre,
            correo: usuarioData.correo,
            telefono: usuarioData.telefono,
            nacionalidad: usuarioData.nacionalidad,
            fecha_nacimiento: usuarioData.fecha_nacimiento
        };

    } catch (error) {
        mensaje.value = error.mensaje;
    }
}

const Editar_Usuario = async () => {
    try {
        const documento = router.currentRoute.value.params.documento;
        const respuesta = await fetch(`http://localhost:8080/usuarios/editar/${documento}`,
            {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(frm.value)
            });
        if (respuesta.ok) {
            // Si la respuesta es exitosa, muestra un mensaje de éxito
            mensaje.value = {
                text: "Usuario editado correctamente",
                type: "success"
            };
            // Limpiar los campos del formulario
            resetForm();
        } else {
            // Si hay un error en el servidor (por ejemplo, 400 o 500)
            const errorData = await respuesta.json();
            mensaje.value = {
                text: `Error: ${errorData.message || "No se pudo insertar el usuario"}`,
                type: "error"
            };
        }

    } catch (error) {
        mensaje.value = error.mensaje;
    }
}
// Función para restablecer los campos del formulario
const resetForm = () => {
    frm.value = {
        documento: "",
        nombre: "",
        correo: "",
        telefono: "",
        nacionalidad: "",
        fecha_nacimiento: ""
    };
};

const Regresar1 = async (documento) => {
    router.push({ name: 'Listar_Usuarios' });
};


onMounted(() => {
    Consultar_Usuario();
})


</script>

<style scoped>
.formulario-usuario {
    max-width: 500px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group-Usuario {
    margin-bottom: 15px;
}

label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

input {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 12px;
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
