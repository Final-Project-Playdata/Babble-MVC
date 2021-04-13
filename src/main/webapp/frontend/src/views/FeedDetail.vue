<template>
	<div>
		<Header />
		<FeedDetail />
		<Footer />
	</div>
</template>

<script>
import FeedDetail from '@/components/FeedDetail.vue';
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
	name: 'FeedDetailView',
	components: {
		FeedDetail,
		Header,
		Footer,
	},
};
</script>

<style></style>
