<template>
	<div>
		<Header />
		<Profile />
		<Footer />
	</div>
</template>

<script>
import Profile from '@/components/Profile.vue';
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
	name: 'ProfileView',
	components: {
		Profile,
		Header,
		Footer,
	},
};
</script>
