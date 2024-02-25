<template>
    <div class="flex flex-wrap gap-4">
        <PageBasic>
            <template #title>
                <h2>Tu Cuenta</h2>
            </template>
            <div>
                <div class="flex justify-center items-center p-4">
                    <img src="https://oyster.ignimgs.com/mediawiki/apis.ign.com/avatar-the-last-airbender/9/94/Prince_zuko_img.jpg?width=1600" alt="Avatar" class="w-32 rounded-full h-32 object-cover" />
                </div>
                <div class="flex justify-center items-center mt-5">
                    <h2 class="text-3xl">{{ usuario.primer_nombre }} {{ usuario.segundo_nombre }} {{ usuario.primer_apellido }} {{ usuario.segundo_apellido }}</h2>
                </div>
                <div class="flex justify-center items-center mt-5">
                    <p class="text-lg">{{ usuario.username }}</p>
                </div>
                <div class="flex justify-center items-center mt-5">
                    <p class="text-lg">{{ formatearFecha(usuario.fecha_nacimiento) }}</p>
                </div>
            </div>
        </PageBasic>        
    </div>
</template>
<script lang="ts" setup>
import { ref } from "vue";
import PageBasic from "@/layouts/PageBasic.vue";
import { Usuario } from "@/models/Usuario.interface";
import { formatearFecha } from '@/utils/Formatters';

const usuario = ref<Usuario[]>([]);
const itemData = localStorage.getItem('userLogin') as any;
usuario.value = JSON.parse(itemData);

</script>
