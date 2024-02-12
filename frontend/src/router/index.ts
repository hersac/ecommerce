import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import { authGuard, basicGuard } from '../security/auth/Auth.guard';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/views/HomeView.vue'),
    beforeEnter: authGuard,
  },
  {
    path: '/productos',
    name: 'productos',
    component: () => import('@/views/Products.vue'),
    beforeEnter: authGuard,
  },
  {
    path: '/cuenta',
    name: 'Cuenta',
    component: () => import('@/views/cuenta/CuentaView.vue'),
    beforeEnter: authGuard,
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/security/login/LoginView.vue'),
    beforeEnter: basicGuard,
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('@/security/register/RegisterView.vue'),
    beforeEnter: basicGuard,
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
