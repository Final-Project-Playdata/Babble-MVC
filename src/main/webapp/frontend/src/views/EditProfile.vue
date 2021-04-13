<template>
	<div>
		<Header />
		<EditProfile />
		<Footer />
	</div>
</template>

<script>
import EditProfile from '@/components/EditProfile.vue';
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
	name: 'EditProfileView',
	components: {
		EditProfile,
		Header,
		Footer,
	},
};
</script>
