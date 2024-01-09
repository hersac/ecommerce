<template>
  <nav class="grid grid-cols-3 gap-4 bg-gray-800 text-white ">

    <div class="flex justify-left items-center p-2">
      <router-link to="/"><img src="" alt="MENU" /></router-link>
    </div>
    
    <div class="flex justify-center items-center space-x-4">
      <ul  v-for="(titulo, index) in titulosMenu" :key="index">
        <li>
          <router-link :to="titulo.link">{{titulo.title}}</router-link>
        </li>
      </ul>
    </div>

    <div class="flex justify-end items-center space-x-4 p-2 w-100">
      <button class="bg-green-500 hover:bg-green-300 active:bg-green-500 text-white font-bold py-2 px-4 rounded">Login</button>
      <button class="bg-green-500 hover:bg-green-300 active:bg-green-500 text-white font-bold py-2 px-4 rounded">Registro</button>
    </div>

  </nav>
</template>
<script lang="ts" setup>
import { ref, onMounted } from 'vue';
import { Menu } from '@/models/Menu';
import { titulos } from '@/service/titlesService'

const titulosMenu = ref<Array<Menu>>([]);

titulosMenu.value = titulos;

</script>