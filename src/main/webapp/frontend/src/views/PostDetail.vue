<template>
	<div>
		<Header />
		<PostDetail />
		<Footer />
	</div>
</template>

<script>
import PostDetail from '@/components/PostDetail.vue';
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
	name: 'PostDetailView',
	components: {
		PostDetail,
		Header,
		Footer,
	},
};
</script>

<style></style>
