<template>
	<div>
		<button :class="clase" @click="emits('get-click')">{{texto}}</button>
	</div>
</template>

<script lang="ts" setup>

import { ref, defineEmits } from 'vue';

const texto = ref<string>();
const clase = ref<string>();

const props = defineProps({
	text: String,
	class: String,
});

const emits = defineEmits(['get-click'])

texto.value = props.text;
clase.value = props.class;

</script>