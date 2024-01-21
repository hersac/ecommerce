<template>
  <div>
    <h2>¡Bienvenido!</h2>
    <span>Ingresa a tu cuenta</span>
    <div
      class="flex justify-center items-center mx-auto p-2 rounded-md shadow-xl"
    >
      <form class="w-1/2">
        <div>
          <div class="relative mt-2 rounded-md shadow-sm">
            <input
              type="email"
              name="email"
              id="email"
              class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-10 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              placeholder="Correo"
              required
            />
          </div>

          <div class="relative mt-2 rounded-md shadow-sm">
            <input
              type="password"
              name="password"
              id="password"
              class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-10 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              placeholder="Contraseña"
              required
            />
          </div>
        </div>
        <div class="flex justify-center items-center p-5">
          <BtnComponent
            :class="'bg-green-500 hover:bg-green-300 active:bg-green-500 text-white font-bold py-2 px-4 rounded'"
            :text="'Entrar'"
          />
        </div>
      </form>
    </div>
  </div>
</template>

<script lang="ts" setup>
import BtnComponent from "@/components/BtnComponent.vue";
</script>

