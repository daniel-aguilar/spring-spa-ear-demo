import HomeView from '@/components/HomeView.vue';
import NotFoundView from '@/components/NotFoundView.vue';
import OtherView from '@/components/OtherView.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(`${import.meta.env.VITE_CONTEXT_PATH}/`),
  routes: [
    {
      path: '/',
      component: HomeView,
    },
    {
      path: '/other',
      component: OtherView,
    },
    {
      path: '/:pathMatch(.*)*',
      component: NotFoundView,
    },
  ],
});

export default router;
