<template>
    <div class="flex justify-center items-center bg-blue-300 h-[100vh]">
        <AuthBasic>
            <h2 class="text-5xl">¡Sé parte de nosotros!</h2>
            <span class="text-2xl">Para iniciar ingresa tus datos</span>
            <div class="flex justify-center items-center mx-auto p-2">
                <Form @submit="onSubmit">
                    <div class="mt-5 grid grid-cols-2 gap-2">
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="text" name="primer_nombre" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                placeholder="Primer nombre" :rules="validRequired"/>
                                <ErrorMessage name="primer_nombre" />
                        </div>
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="text" name="segundo_nombre" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                placeholder="Segundo nombre" :rules="validRequired"/>
                                <ErrorMessage name="segundo_nombre" />
                        </div>
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="text" name="primer_apellido" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                placeholder="Primer Apellido" :rules="validRequired"/>
                                <ErrorMessage name="primer_apellido" />
                        </div>
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="text" name="segundo_apellido" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                placeholder="Segundo Apellido" :rules="validRequired"/>
                                <ErrorMessage name="segundo_apellido" />
                        </div>
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="text" name="documento_id" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                placeholder="Documento de identificacion" :rules="validCedula"/>
                                <ErrorMessage name="documento_id" />
                        </div>
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="text" name="direccion" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                placeholder="Dirección" :rules="validDirection"/>
                                <ErrorMessage name="direccion" />
                        </div>
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="email" name="username" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                placeholder="Correo Electronico" :rules="validEmail" />
                                <ErrorMessage name="username" />
                        </div>
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="date" name="fecha_nacimiento" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" :rules="validDate"/>
                            <ErrorMessage name="fecha_nacimiento" />
                        </div>
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="password" name="password" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                placeholder="Contraseña" :rules="validPassword"/>
                            <ErrorMessage name="password" />
                        </div>
                        <div class="relative mt-2 rounded-md shadow-sm">
                            <Field type="password" name="confirmPassword" class="block w-full rounded-md border-0 py-1.5 pl-7 pr-20 h-12 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                placeholder="Confirma tu contraseña" :rules="validConfirmPassword"/>
                            <ErrorMessage name="confirmPassword" />
                        </div>
                    </div>
                    <div class="mt-5 flex justify-center items-center">
                        <BtnComponent
                            :class="'bg-green-500 hover:bg-green-300 active:bg-green-500 text-white font-bold py-2 px-4 rounded'"
                            :text="'Registrarse'" />
                    </div>
                </Form>
            </div>
            <div class="flex justify-center items-center mt-5">
                <router-link to="/login">
                    <p class="text-sm hover:text-green-500">Ingresar</p>
                </router-link>
            </div>
        </AuthBasic>
    </div>
</template>
<script lang="ts" setup>
import { ref } from 'vue';
import { Field, Form, ErrorMessage } from 'vee-validate';
import AuthBasic from '@/layouts/AuthBasic.vue';
import BtnComponent from '@/components/BtnComponent.vue';
import { register } from  '../../service/authServices/AuthService';
import { validRequired, validEmail, validCedula, validDirection, validDate, validPassword, validConfirmPassword } from '../../utils/ErrorValid';

let formData = ref<Object>({})

const onSubmit = (values: any)=>{
    const { confirmPassword, ...data } = values;
    formData.value = data;
    console.log("Antes de salir: ", formData.value);
    register(formData.value);
}


</script>

