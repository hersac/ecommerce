<template>
  <div>
    <div class="flex flex-wrap gap-4">
      <PageBasic>
        <template #title>
          <h2>Home</h2>
        </template>
      </PageBasic>

<!--
      <div
        class="grid grid-rows-[20px, 140px, 20px, 20px, 20px, 20px] gap-2 w-60 h-80 p-2 rounded-md shadow-xl"
        v-for="(product, index) in productsData" :key="index"
      >
        <div class="flex justify-center items-center">
          <h2 class="text-2x uppercase">{{product.prod_name}}</h2>
        </div>
        <div class="flex justify-center items-center">
          <img
            src="https://img.freepik.com/fotos-premium/gato-gracioso-tomandose-selfie-generative-ai_971991-1506.jpg"
            alt="MENU"
          />
        </div>
        <div class="flex justify-center items-center">
          <h2>{{product.short_desc}}</h2>
        </div>
        <div class="flex justify-center items-center">
          <h2>${{product.price}}</h2>
        </div>
        <div class="flex justify-center items-center">
          <BtnComponent
            :class="'bg-green-500 hover:bg-green-300 active:bg-green-500 text-white font-bold py-2 px-4 rounded'"
            :text="'Ver Detalles'"
          />
        </div>
      </div>
      -->
    </div>
  </div>
</template>

<script lang="ts" setup>
import PageBasic from "@/layouts/PageBasic.vue";
import BtnComponent from "@/components/BtnComponent.vue";
import router from "@/router";
import { getProducts } from '../service/products.service';
import { onMounted, ref } from "vue";

const productsData = ref<Object[]>([]);
/*
onMounted(() => {
    productsCall();
});

const productsCall = async () => {
  productsData.value = await getProducts();
}
*/
const logout = () => {
  localStorage.removeItem('TOKEN_CONSULTAS');
  router.push('/login');
};

</script>
@/service/products.service