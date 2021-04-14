<template>
	<div>
		<div class="instagram-container">
			<div class="instagram-logo">
				<img src="icon/instagram_name.png" alt="" />
			</div>

			<div class="instagram-status">
				<p>Sign up to listen audios</p>

				<p>from your friends.</p>
			</div>

			<div class="instagram-container-inside">
				<form @submit.prevent="submitForm()">
					<input type="email" placeholder="Email" v-model="username" />
					<input type="password" placeholder="Password" v-model="password" />
					<input type="text" placeholder="Nickname" v-model="nickname" />
					<input type="text" placeholder="First Name" v-model="firstName" />
					<input type="text" placeholder="Last Name" v-model="lastName" />
					<button
						v-bind:disabled="
							!isUsernameValid ||
							!password ||
							!nickname ||
							!firstName ||
							!lastName
						"
						type="submit"
					>
						Sign Up
					</button>
				</form>
				<p>By signing up, you agree to our</p>

				<p>Terms, Data policy and Cookies</p>

				<p>Policy.</p>
			</div>
		</div>

		<div class="instagram-bottom-container">
			<h4>
				Have an account?
				<a href="/" style="text-decoration: none; color: #3897f0">Sign In</a>
			</h4>
		</div>
	</div>
</template>

<script>
import { signUp } from '@/api/auth';
import { validateEmail } from '@/utils/validation';

export default {
	data() {
		return {
			//form values
			username: '',
			password: '',
			nickname: '',
			firstName: '',
			lastName: '',
		};
	},
	computed: {
		isUsernameValid() {
			return validateEmail(this.username); //id가 이메일 형식이 맞는지 체크
		},
	},
	methods: {
		async submitForm() {
			try {
				const userData = {
					username: this.username,
					password: this.password,
					nickname: this.nickname,
					firstName: this.firstName,
					lastName: this.lastName,
				};
				await signUp(userData);

				this.$router.push('../');
			} catch (error) {
				alert('회원가입 중 에러가 발생했습니다.');
				console.log(error);
			} finally {
				this.username = '';
				this.password = '';
				this.nickname = '';
				this.firstName = '';
				this.lastName = '';
			}
		},
	},
};
</script>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
.instagram-container {
	width: 100%;
	max-width: 350px;
	margin: auto;
	border: 1px solid #ccc;
	margin-top: 15px;
}
.instagram-logo {
	width: 100%;
	max-width: 200px;
	margin: auto;
	margin-top: 10px;
}
.instagram-logo img {
	width: 100%;
}
.instagram-status {
	font-size: 18px;
	text-align: center;
	color: #aaa;
}
.instagram-container-inside {
	padding: 25px;
}
.instagram-container-inside button {
	width: 100%;
	padding: 8px;
	margin: 8px;
	border: none;
	font-size: 12px;
	color: white;
	background-color: #3897f0;
	border-radius: 5px;
	cursor: pointer;
}
.instagram-container-inside h5 {
	color: #c0c0c0;
	text-align: center;
}
.instagram-container-inside input[type='email'],
input[type='text'],
input[type='password'] {
	width: 100%;
	padding: 8px;
	margin: 6px;
	display: inline-block;
	box-sizing: border-box;
	border: 1px solid #e9e9e9;
	background-color: #f0f0f0;
	font-size: 12px;
	border-radius: 4px;
}
.instagram-container-inside p {
	font-size: 16px;
	text-align: center;
	color: #aaa;
}
.instagram-bottom-container {
	width: 100%;
	max-width: 350px;
	margin: auto;
	border: 1px solid #ccc;
	margin-top: 15px;
}
.instagram-bottom-container h4 {
	margin-top: 20px;
	margin-bottom: 20px;
	text-align: center;
}
</style>
