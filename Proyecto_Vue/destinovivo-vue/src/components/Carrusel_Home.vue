<template>
  <div class="posidod">
    <!--mostrar el carrusel solo si estamos en la ruta Home -->
    <section v-if="isHome" class="carousel">
        <button class="arrow left" @click="prevSlide">❮</button>
        <div class="carousel-slides" :style="{ transform: `translateX(-${currentSlide * 100}%)` }">
            <img
            v-for="(image, index) in images"
            :key="index"
            :src="image"
            :alt="'Image ' + index"
            />
        </div>
        <button class="arrow right" @click="nextSlide">❯</button>
    </section>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useRoute } from 'vue-router';
// Lista de imágenes para el carrusel
const images = [
  '/images/carrusel1.jpg',
  '/images/carrusel2.jpg',
  '/images/carrusel3.jpeg',
  '/images/carrusel4.png',
  '/images/carrusel5.jpg',
  '/images/carrusel6.jpg',
];

const currentSlide = ref(0);

// Funciones para mover imágenes hacia la izquierda y la derecha
const prevSlide = () => {
  currentSlide.value =
    (currentSlide.value - 1 + images.length) % images.length;
};

const nextSlide = () => {
  currentSlide.value = (currentSlide.value + 1) % images.length;
};

// Detectar la ruta actual
const route = useRoute();
const isHome = computed(() => route.path === '/');

</script>



<style scoped>
.carousel {
  position: relative;
  max-width: 1200px;
  margin: 2px 0px;
  overflow: hidden;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  max-height: 450px;
}

.carousel-slides {
  display: flex;
  transition: transform 0.5s ease-in-out;
}

.carousel-slides img {
  width: 100%;
  flex-shrink: 0;
  max-height: 450px;
}

.arrow {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background-color: transparent;
  color: white;
  border: none;
  font-size: 2rem;
  padding: 10px;
  cursor: pointer;
  z-index: 2;
}

.arrow.left {
  left: 5px;
}

.arrow.right {
  right: 5px;
}
</style>