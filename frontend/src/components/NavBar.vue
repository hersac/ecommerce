<template>
  <nav class="grid grid-cols-3 gap-4 bg-gray-800 text-white ">

    <div class="flex justify-left items-center p-2">
      <router-link to="/"><img src="https://img.freepik.com/fotos-premium/gato-gracioso-tomandose-selfie-generative-ai_971991-1506.jpg" alt="MENU" class="rounded-full w-10 h-10 object-cover" /></router-link>
    </div>
    
    <div class="flex justify-center items-center space-x-4">
      <ul  v-for="(titulo, index) in titulosMenu" :key="index">
        <li>
          <router-link :to="titulo.link">{{titulo.title}}</router-link>
        </li>
      </ul>
    </div>

    <div class="flex justify-end items-center space-x-4 p-2 w-100">
      <BtnComponent :class="'bg-green-500 hover:bg-green-300 active:bg-green-500 text-white font-bold py-2 px-4 rounded'" :text="'Login'" />
      <BtnComponent :class="'bg-green-500 hover:bg-green-300 active:bg-green-500 text-white font-bold py-2 px-4 rounded'" :text="'Registrar'" />
    </div>

  </nav>
</template>
<script lang="ts" setup>
import { ref, onMounted } from 'vue';
import BtnComponent from '@/components/BtnComponent.vue';
import { Menu } from '@/models/Menu';
import { titulos } from '@/service/titlesService';

const titulosMenu = ref<Array<Menu>>([]);

titulosMenu.value = titulos;

</script>