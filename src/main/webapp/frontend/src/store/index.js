import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

import { signIn } from '@/api/auth';

export default new Vuex.Store({
	state: {
		username: '',
		password: '',
		user: '',
		token: '',
		error: 200,
	},
	watch: {
		error: async () => {
			if (this.error === 403) {
				const userData = {
					username: this.username,
					password: this.password,
				};

				const data = await signIn(userData);

				this.$store.commit('setToken', data.headers['authorization']);

				this.error = 200;
			}
		},
	},
	getters: {
		isSignin(state) {
			return state.token !== '';
		},
	},
	mutations: {
		setUsername(state, Username) {
			state.Username = Username;
		},
		clearUsername(state) {
			state.Username = '';
		},
		setToken(state, token) {
			state.token = token;
		},
		clearToken(state) {
			state.token = '';
		},
		getclient: function (state) {
			return state.clientinfo;
		},
	},
	actions: {},
	modules: {},
	plugins: [createPersistedState()],
});
