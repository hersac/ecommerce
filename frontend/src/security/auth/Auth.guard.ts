import { NavigationGuardNext, RouteLocationNormalized } from 'vue-router';

export const authGuard = (to: RouteLocationNormalized, from: RouteLocationNormalized, next: NavigationGuardNext) => {
  if (localStorage.getItem('TOKEN_CONSULTAS')) {
    next();
  } else {
    next('/login');
  }
};

export const basicGuard = (to: RouteLocationNormalized, from: RouteLocationNormalized, next: NavigationGuardNext) => {
    if (!localStorage.getItem('TOKEN_CONSULTAS')) {
      next();
    } else {
      next('/');
    }
  };