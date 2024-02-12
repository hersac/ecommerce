<template>
        <div class="animate-spin rounded-full border-t-2 border-b-2 border-green-300" :class="class" v-if="isActive" >
        </div>
</template>
<script lang="ts" setup>

defineProps({
    isActive: Boolean,
    class: String,
});


</script>