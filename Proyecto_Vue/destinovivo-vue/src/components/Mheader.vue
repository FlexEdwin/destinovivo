<template>
  <div>
    <header>
      <div class="logotitulo">
        <img src="/images/logo1.png" alt="destinovivo">
        <h1>DestinoVivo</h1>        
      </div>
      <Mnavbar />
    </header>
  </div>

</template>

<script setup>
import Mnavbar from './Mnavbar.vue';
</script>


<style scoped>
/*estilo del header*/
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  background-color: #333;
  color: white;
}

.logotitulo {
  display: flex;
  align-items: center;
  gap: 15px;
}

.logotitulo img {
  height: 50px;
}

.logotitulo h1 {
  font-size: 24px;
  margin: 0;
}
</style>