<template>
	<main class="profile-container">
		<section class="profile">
			<header class="profile__header">
				<div class="profile__avatar-container">
					<img src="images/avatar.jpg" class="profile__avatar" />
				</div>
				<div class="profile__info">
					<div class="profile__name">
						<h1 class="profile__title">serranoarevalo</h1>
						<a href="edit" class="profile__button u-fat-text">Edit profile</a>
						<i class="fa fa-cog fa-2x" id="cog"></i>
					</div>
					<ul class="profile__numbers">
						<li class="profile__posts">
							<span class="profile__number u-fat-text">10</span> posts
						</li>
						<li class="profile__followers">
							<span class="profile__number u-fat-text">40</span> followers
						</li>
						<li class="profile__following">
							<span class="profile__number u-fat-text">134</span> following
						</li>
					</ul>
					<div class="profile__bio">
						<span class="profile__full-name u-fat-text"
							>Nicolás Serrano Arévalo</span
						>
						<p class="profile__full-bio">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugit
							rerum consequuntur aperiam, dicta delectus nihil voluptas
							explicabo sapiente quisquam. Eius ipsam asperiores excepturi
							maiores, atque voluptatum sed fuga esse molestiae.
						</p>
						<a href="http://serranoarevalo.com" class="profile__link u-fat-text"
							>serranoarevalo.com</a
						>
					</div>
				</div>
			</header>
			<div class="profile__pictures">
				<a href="detail" class="profile-picture">
					<img src="../assets/feedPhoto.jpg" class="profile-picture__picture" />
					<div class="profile-picture__overlay">
						<span class="profile-picture__number">
							<i class="fa fa-heart"></i> 450
						</span>
						<span class="profile-picture__number">
							<i class="fa fa-comment"></i> 39
						</span>
					</div>
				</a>
				<a href="detail" class="profile-picture">
					<img src="../assets/feedPhoto.jpg" class="profile-picture__picture" />
					<div class="profile-picture__overlay">
						<span class="profile-picture__number">
							<i class="fa fa-heart"></i> 450
						</span>
						<span class="profile-picture__number">
							<i class="fa fa-comment"></i> 39
						</span>
					</div>
				</a>
				<a href="detail" class="profile-picture">
					<img src="../assets/feedPhoto.jpg" class="profile-picture__picture" />
					<div class="profile-picture__overlay">
						<span class="profile-picture__number">
							<i class="fa fa-heart"></i> 450
						</span>
						<span class="profile-picture__number">
							<i class="fa fa-comment"></i> 39
						</span>
					</div>
				</a>
				<a href="detail" class="profile-picture">
					<img src="../assets/feedPhoto.jpg" class="profile-picture__picture" />
					<div class="profile-picture__overlay">
						<span class="profile-picture__number">
							<i class="fa fa-heart"></i> 450
						</span>
						<span class="profile-picture__number">
							<i class="fa fa-comment"></i> 39
						</span>
					</div>
				</a>
				<a href="detail" class="profile-picture">
					<img src="../assets/feedPhoto.jpg" class="profile-picture__picture" />
					<div class="profile-picture__overlay">
						<span class="profile-picture__number">
							<i class="fa fa-heart"></i> 450
						</span>
						<span class="profile-picture__number">
							<i class="fa fa-comment"></i> 39
						</span>
					</div>
				</a>
				<a href="detail" class="profile-picture">
					<img src="../assets/feedPhoto.jpg" class="profile-picture__picture" />
					<div class="profile-picture__overlay">
						<span class="profile-picture__number">
							<i class="fa fa-heart"></i> 450
						</span>
						<span class="profile-picture__number">
							<i class="fa fa-comment"></i> 39
						</span>
					</div>
				</a>
			</div>
		</section>
		<div class="popUp">
			<i class="fa fa-times fa-2x" id="closePopUp"></i>
			<div class="popUp__container">
				<div class="popUp__buttons">
					<a href="home" class="popUp__button">Log Out</a>
					<a href="#" class="popUp__button" id="cancelPopUp">Cancel</a>
				</div>
			</div>
		</div>
	</main>
</template>

<script>
export default {
	name: 'Profile',
};
</script>
