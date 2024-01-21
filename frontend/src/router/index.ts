import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/views/HomeView.vue')
  },
  {
    path: '/productos',
    name: 'productos',
    component: () => import('@/views/Products.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/security/login/LoginView.vue')
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('@/security/register/RegisterView.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
