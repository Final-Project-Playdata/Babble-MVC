<template>
	<nav class="navigation">
		<a href="feed">
			<img
				src="../assets/navLogo.png"
				alt="logo"
				title="logo"
				class="navigation__logo"
			/>
		</a>
		<div class="navigation__search-container">
			<i class="fa fa-search"></i>
			<input type="text" placeholder="Search" />
		</div>
		<div class="navigation__icons">
			<a href="explore" class="navigation__link">
				<i class="fa fa-compass"></i>
			</a>
			<a href="#" class="navigation__link">
				<i class="fa fa-heart-o"></i>
			</a>
			<a href="profile" class="navigation__link">
				<i class="fa fa-user-o"></i>
			</a>
		</div>
	</nav>
</template>

<script>
export default {
	name: 'Header',
};
</script>
