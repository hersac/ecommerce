<template>
	<div>
		<button :class="clase" @click="emit('function')">{{texto}}</button>
	</div>
</template>

<script lang="ts" setup>

import { ref, defineEmits } from 'vue';

const texto = ref<string>();
const clase = ref<string>();

const props = defineProps({
	text: String,
	class: String,
	function: Function
});

const emit = defineEmits(['funcion'])

texto.value = props.text;
clase.value = props.class;

</script>