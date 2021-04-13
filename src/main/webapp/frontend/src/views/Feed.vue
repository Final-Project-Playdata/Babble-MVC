<template>
	<div>
		<Header />
		<Feed />
		<Footer />
	</div>
</template>

<script>
import Feed from '@/components/Feed.vue';
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
	name: 'FeedView',
	components: {
		Feed,
		Header,
		Footer,
	},
};
</script>
