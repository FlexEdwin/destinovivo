<template>
<nav>
    <ul>
        <li>
            <router-link to ="/">Home</router-link>
        </li>
        <li>
            <router-link to ="/Insertar_Empresa"> Crear Empresa</router-link>
        </li>
        <li>
            <router-link to ="/Listar_Usuarios">Usuarios</router-link>
        </li>
    </ul>
</nav>

</template>

<style scoped>

  nav {
    display: flex;
    justify-content: flex-end;
    width: 100%;
  }


  nav ul {
    display: flex;
    gap: 20px;  
    list-style: none;
    padding: 0;
    margin: 0;
  }

 
  nav ul li a {
    text-decoration: none;
    color: white;
    font-size: 15px;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    padding: 10px 15px;
    border-radius: 10px;
  }

  
  nav ul li a:hover {
    background-color: #4caf50;
    text-decoration: none;
  }

</style>