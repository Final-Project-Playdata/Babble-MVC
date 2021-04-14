<template>
	<div>
		<Header />
		<Post />
		<Footer />
	</div>
</template>

<script>
import Post from '@/components/Post.vue';
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
	name: 'PostView',
	components: {
		Post,
		Header,
		Footer,
	},
};
</script>
