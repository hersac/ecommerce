<template>
  <div class="flex justify-center items-center bg-green-300 h-[100vh]">
    <AuthBasic>
      <h2 class="text-5xl">¡Bienvenido!</h2>
      <span class="text-2xl">Ingresa a tu cuenta</span>
      <div class="flex justify-center items-center">
        <img
          src="https://oyster.ignimgs.com/mediawiki/apis.ign.com/avatar-the-last-airbender/9/94/Prince_zuko_img.jpg?width=1600"
          alt="Avatar" class="w-20 rounded-full h-20 object-cover" />
      </div>
      <div class="flex justify-center mx-auto p-2 ">
        <Form class="w-[80%] p-8" @submit="onsubmit">
          <div>
            <div class="relative mt-2 rounded-md shadow-sm">
              <Field type="email" name="username" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                placeholder="Correo" :rules="validEmail" />
              <ErrorMessage name="username" class="errorMessage" />
            </div>

            <div class="relative mt-2 rounded-md shadow-sm">
              <Field type="password" name="password" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                placeholder="Contraseña" />
            </div>
          </div>
          <div class="flex justify-end items-center mt-5">
            <router-link to="#">
              <p class="text-sm underline underline-offset-4 hover:text-green-500">Recuperar contraseña</p>
            </router-link>
          </div>
          <div class="flex justify-center items-center p-5" v-if="!loading">
            <BtnComponent
              :class="'bg-green-500 hover:bg-green-300 active:bg-green-500 text-white font-bold py-2 px-4 rounded'"
              :text="'Entrar'" />
          </div>
          <div class="flex justify-center items-center" >
            <Loading :isActive="loading" :class="'w-8 h-8 mt-5'" />
          </div>
        </Form>
      </div>
      <div class="flex justify-center items-center">
        <router-link to="/register">
          <p class="text-sm hover:text-green-500">Crear una cuenta</p>
        </router-link>
      </div>
    </AuthBasic>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import router from '@/router';
import { Field, Form, ErrorMessage } from 'vee-validate';
import AuthBasic from '@/layouts/AuthBasic.vue';
import BtnComponent from "@/components/BtnComponent.vue";
import Loading from '@/components/Loading.vue';
import { validEmail } from '../../utils/ErrorValid';
import { login } from '../../service/authServices/auth.service';
import { getUsuarioPorEmail } from '../../service/usuarios.service';
import { Usuario } from '../../models/Usuario.interface';

const formData = ref<Object>({});
const userData = ref<Usuario[]>([]);
const loading = ref<boolean>(false);

const onsubmit = async (values: any) => {
  loading.value = true;
  const { username, ...data } = values;
  const emailLowercased = username.toLowerCase();
  formData.value = {username: emailLowercased, ...data };
  try {
    await login(formData.value);
    userData.value = await getUsuarioPorEmail(emailLowercased);
    localStorage.setItem('userLogin', JSON.stringify(userData.value[0]));
    router.push('/');
  } catch (error) {
    console.error(error);
  } finally {
    loading.value = false;
  }
};

</script>

../../service/authServices/Auth.service