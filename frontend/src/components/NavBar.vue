<template>
  <nav class="grid grid-cols-3 gap-4 bg-gray-800 text-white">
    <div class="flex justify-left items-center p-2">
      <router-link to="/"
        ><img
          src="https://img.freepik.com/fotos-premium/gato-gracioso-tomandose-selfie-generative-ai_971991-1506.jpg"
          alt="MENU"
          class="rounded-full w-10 h-10 object-cover"
      /></router-link>
    </div>

    <div class="flex justify-center items-center space-x-4">
      <ul v-for="(titulo, index) in titulosMenu" :key="index">
        <li>
          <router-link :to="titulo.link">{{ titulo.title }}</router-link>
        </li>
      </ul>
    </div>

    <div class="flex justify-end items-center space-x-4 p-2 w-100 relative">
      <div
        class="w-50 flex justify-center items-center gap-5 px-2 py-1 cursor-pointer hover:bg-gray-700 active:bg-gray-600 rounded-lg"
        @blur="openCloseMenu"
        @click="openCloseMenu"
      >
        <div class="flex justify-start">
          <img
            src="https://oyster.ignimgs.com/mediawiki/apis.ign.com/avatar-the-last-airbender/9/94/Prince_zuko_img.jpg?width=1600"
            alt="Avatar"
            class="w-10 rounded-full h-10 object-cover"
          />
        </div>
        <div class="flex justify-end">
          <h5>{{ usuario.primer_nombre }} {{ usuario.primer_apellido }}</h5>
        </div>
      </div>
<div
      class="absolute top-[75px] right-3 shadow-xl border-solid border-2 text-black p-4 w-64 rounded-lg transition-all duration-300 ease-in-out"
      :class="{ 'opacity-0 invisible translate-y-1': !isOpen, 'opacity-100 visible translate-y-2': isOpen }"
    >        <ul class="flex flex-col flex-wrap gap-2">
          <router-link
            to="/cuenta"
            class="hover:bg-gray-200 active:bg-gray-300 p-2 rounded-lg"
            ><li>Cuenta</li></router-link
          >
          <router-link
            to="#"
            class="hover:bg-gray-200 active:bg-gray-300 p-2 rounded-lg"
            ><li>Configuraciones</li></router-link
          >
          <router-link
            to="/login"
            class="hover:bg-gray-200 active:bg-gray-300 p-2 rounded-lg"
            @click="logout"
            ><li>Cerrar sesión</li></router-link
          >
        </ul>
      </div>
    </div>
  </nav>
</template>
<script lang="ts" setup>
import { ref } from "vue";
import { Menu } from "@/models/Menu";
import { titulos } from "../service/titles.service";
import { Usuario } from "../models/Usuario.interface";

const titulosMenu = ref<Array<Menu>>([]);
const isOpen = ref<boolean>(false);
const usuario = ref<Usuario[]>([]);
const itemLogin = localStorage.getItem("userLogin") as any;

titulosMenu.value = titulos;
usuario.value = JSON.parse(itemLogin);

const openCloseMenu = () => {
    console.log(isOpen.value);
  isOpen.value = !isOpen.value;
};

const logout = () => {
  localStorage.removeItem("TOKEN_CONSULTAS");
  localStorage.removeItem("userLogin");
};
</script>
