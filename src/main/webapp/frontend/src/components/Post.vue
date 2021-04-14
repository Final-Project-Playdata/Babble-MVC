<template>
	<main class="post">
		<section class="audio" v-for="value in model" v-bind:key="value.id">
			<header class="audio__header">
				<div class="audio__header-column">
					<img class="audio__avatar" src="images/avatar.jpg" />
				</div>
				<div class="audio__header-column">
					<span class="audio__username">{{ value.user.username }}</span>
					<span class="audio__location">고쳐야함</span>
				</div>
			</header>
			<div class="audio__file-container">
				<audio class="audio__file" src="../assets/feedPhoto.jpg">
					sdafsfas
				</audio>
			</div>
			<div class="audio__info">
				<div class="audio__icons">
					<span class="audio__icon">
						<i class="fa fa-heart-o heart fa-lg"></i>
					</span>
					<span class="audio__icon">
						<i class="fa fa-comment-o fa-lg"></i>
					</span>
				</div>
				<span class="audio__likes">35 likes</span>
				<ul class="audio__comments">
					<li class="audio__comment">
						<span class="audio__comment-author">serranoarevalo</span>wow this is
						great!
					</li>
					<li class="audio__comment">
						<span class="audio__comment-author">lynn</span>no is not!
					</li>
				</ul>
				<span class="audio__time-ago">11 hours ago</span>
				<div class="audio__add-comment-container">
					<textarea
						placeholder="Add a comment..."
						class="audio__add-comment"
					></textarea>
					<i class="fa fa-ellipsis-h"></i>
				</div>
			</div>
		</section>
	</main>
</template>

<script>
import { getPostList } from '@/api/babble';

export default {
	name: 'Post',
	data: function () {
		return { model: {} };
	},
	methods: {
		async getPosts() {
			try {
				const response = await getPostList();
				this.model = response.data;
			} catch (error) {
				console.log(error);
				alert('방 정보를 가져오는 중 문제가 발생했습니다.');
				this.$router.push('../');
			}
		},
	},
	beforeMount() {
		this.getPosts();
	},
};
</script>
