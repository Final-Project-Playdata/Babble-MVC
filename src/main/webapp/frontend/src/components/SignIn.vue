<template>
	<main class="login">
		<div class="login__column">
			<img
				src="../assets/phone.png"
				alt="Phone Image"
				title="Phone Image"
				class="login__phone-image"
			/>
		</div>
		<section class="login__column">
			<div class="login__section login__sign-in">
				<img
					src="../assets/logo.png"
					alt="Logo"
					title="Logo"
					class="login__logo"
				/>
				<!-- x   -->
				<form @submit.prevent="signIn" class="login__form">
					<div class="login__input-container">
						<input
							type="text"
							name="username"
							placeholder="Username"
							required
							class="login__input"
							v-model="username"
						/>
					</div>
					<div class="login__input-container">
						<input
							type="password"
							name="password"
							placeholder="Password"
							required
							class="login__input"
							v-model="password"
						/>
						<a href="#" class="login__form-link">Forgot?</a>
					</div>
					<div class="login__input-container">
						<input
							v-bind:disabled="!isUsernameValid || !password"
							type="submit"
							value="Log in"
							class="login__input login__input--btn"
						/>
					</div>
				</form>
				<span class="login__divider">or</span>
				<a class="login__fb-link" href="#">
					<i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i> Log in
					with Facebook
				</a>
			</div>
			<div class="login__section login__sign-up">
				<span class="login__text">
					Don't have an account?
					<a href="#" class="login__link"> Sign up </a>
				</span>
			</div>
			<div class="login__section login__section--transparent login__app">
				<span class="login__text"> Get the app. </span>
				<div class="login__appstores">
					<img
						src="../assets/ios.png"
						alt="iOS"
						title="Get the app!"
						class="login__appstore"
					/>
					<img
						src="../assets/android.png"
						alt="Android"
						title="Get the app!"
						class="login__appstore"
					/>
				</div>
			</div>
		</section>
	</main>
</template>

<script>
import { validateEmail } from '@/utils/validation';
import { signIn } from '@/api/auth';

export default {
	name: 'SignIn',
	data() {
		return {
			username: '',
			password: '',
			temp: '',
		};
	},
	computed: {
		isUsernameValid() {
			return validateEmail(this.username);
		},
	},
	methods: {
		async signIn() {
			try {
				const userData = {
					username: this.username,
					password: this.password,
				};

				const data = await signIn(userData);

				console.log(data.headers['authorization']);
				// this.$store.commit('setToken', data.data.token);
				// this.$router.push('home');
			} catch (error) {
				console.log(error.response.data);
				this.$router.push('../Signin');
			} finally {
				this.username = '';
				this.password = '';
			}
		},
	},
};
</script>
