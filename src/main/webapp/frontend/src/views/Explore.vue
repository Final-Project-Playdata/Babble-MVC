<template>
	<div>
		<Header />
		<Explore />
		<Footer />
	</div>
</template>

<script>
import Explore from '@/components/Explore.vue';
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
	name: 'ExploreView',
	components: {
		Explore,
		Header,
		Footer,
	},
};
</script>
