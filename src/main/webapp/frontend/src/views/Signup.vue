<template>
	<div>
		<div class="jb-box">
			<video muted autoplay loop>
				<source src="../video/BACKGROUND.mp4" type="video/mp4" />
				<strong>Your browser does not support the video tag.</strong>
			</video>
			<div class="jb-text">
				<SignUp></SignUp>
			</div>
		</div>
	</div>
</template>

<script>
import SignUp from '@/components/SignUp.vue';

export default {
	components: {
		SignUp,
	},
};
</script>

<style></style>
