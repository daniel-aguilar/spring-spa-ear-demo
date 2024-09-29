<template>
  <h1>Other</h1>
  <RouterLink to="/">Go to home</RouterLink>
</template>

<script setup>
import { onMounted } from 'vue'

async function doThing() {
  const baseUrl = import.meta.env.VITE_CONTEXT_PATH;
  const url = `${baseUrl}/api/test`;

  const res = await fetch(url).then(r => r.json());
  console.log(res);
}

onMounted(() => doThing());
</script>
