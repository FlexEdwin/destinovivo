<template>
    <nav>
        <ul>
            <li>
                <router-link to ="/">Home</router-link>
            </li>
            <li>
                <router-link to ="/Insertar_Empresa">Crear Empresa</router-link>
            </li>
            <li>
                <router-link to ="/Listar_Usuarios">Usuarios</router-link>
            </li>
            <li>
                <router-link to ="/Insertar_Resena">Reseñas</router-link>
            </li>
        </ul>
    </nav>
</template>

<style scoped>
  /*estilos para el contenedor de la barra de navegacion*/
  nav {
    display: flex;
    justify-content: flex-end;
    width: 100%;
  }

  /*estilos para la lista de elementos*/
  nav ul {
    display: flex;
    gap: 20px;  /*espaciado entre los botones*/
    list-style: none;
    padding: 0;
    margin: 0;
  }

  /*estilos para los botones*/
  nav ul li a {
    text-decoration: none;
    color: white;
    font-size: 15px;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    padding: 10px 15px;
    border-radius: 10px;
  }

  /*efecto hover al pasar el cursor los enlaces*/
  nav ul li a:hover {
    background-color: #4caf50;
    text-decoration: none;
  }

</style>