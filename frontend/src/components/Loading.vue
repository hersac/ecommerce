<template>
        <div class="animate-spin rounded-full border-t-8 border-b-8 border-green-300" :class="class" v-if="isActive" >
        </div>
</template>
<script lang="ts" setup>

defineProps({
    isActive: Boolean,
    class: String,
});


</script>