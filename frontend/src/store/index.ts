import { createStore } from 'vuex'

export default createStore({
  state: {
    token: String
  },
  getters: {
  },
  mutations: {
    setToken(state, token){
      state.token = token;
    }
  },
  actions: {
    setTokenAction({ commit }, token){
      commit('setToken', token);
    }
  },
  modules: {
  }
})
