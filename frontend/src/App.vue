<template>
  <div>
    <div>
      <NavBar />
    </div>
    <div class="p-4">
      <div class="w-full bg-white p-6 rounded-md shadow-md">
        <router-view />
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import NavBar from '@/components/NavBar.vue';

</script>>
<style lang="scss">
</style>
