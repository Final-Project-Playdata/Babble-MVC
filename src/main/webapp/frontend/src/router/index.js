import Vue from 'vue';
import VueRouter from 'vue-router';
import store from '@/store/index';

Vue.use(VueRouter);

const routes = [
	{
		path: '/post',
		name: 'Post',
		component: () => import('../views/Post.vue'),
	},
	{
		path: '/edit',
		name: 'EditProfile',
		component: () => import('../views/EditProfile.vue'),
	},
	{
		path: '/explore',
		name: 'Explore',
		component: () => import('../views/Explore.vue'),
	},
	{
		path: '/detail',
		name: 'PostDetail',
		component: () => import('../views/PostDetail.vue'),
	},
	{
		path: '/profile',
		name: 'Profile',
		component: () => import('../views/Profile.vue'),
	},
	{
		path: '/',
		name: 'SingIn',
		component: () => import('../views/SingIn.vue'),
	},
	{
		path: '/signup',
		name: 'SignUp',
		component: () => import('../views/SignUp.vue'),
	},
	{
		path: '*',
		name: 'NotFound',
		component: () => import('@/views/NotFoundPage.vue'),
	},
];

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
});

router.beforeEach((to, from, next) => {
	if (to.meta.auth && !store.getters.isSignin) {
		console.log('인증이 필요합니다');
		next('/signin');
		return;
	}
	next();
});

export default router;
