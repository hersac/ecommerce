<template>
    <div>
        <div>
            <NavBar />
        </div>
        <div>
            <slot />
        </div>
    </div>
</template>
<script lang="ts" setup>
import NavBar from '@/components/NavBar.vue';
</script>
<style lang="scss" scoped></style>