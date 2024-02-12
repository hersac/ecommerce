<template>
    <div class="w-full">
        <div>
            <NavBar />
        </div>
        <div class="mx-20">
            <h2 class="uppercase text-3xl mt-5"><slot name="title"/></h2>
            
            <slot />
        </div>
    </div>
</template>
<script lang="ts" setup>
import NavBar from '@/components/NavBar.vue';
</script>
<style lang="scss" scoped></style>