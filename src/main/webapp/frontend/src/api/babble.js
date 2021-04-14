// 학습 노트 조작과 관련된 CRUD API 함수 파일
import { mvcInstance } from './index';
import store from '@/store/index';

function getTagsInPost(id) {
	return mvcInstance.get(`/post/${id}/tags`).catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

function insertTagList(id, tagList) {
	return mvcInstance.post(`/post/${id}/tags`, tagList).catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

function updateTagList(id, tagList) {
	return mvcInstance.put(`/post/${id}/tags`, tagList).catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

function insertPost(post) {
	return mvcInstance.post('post', post).catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

function deletePost(id) {
	return mvcInstance.delete(`/post/${id}`).catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

function updatePost(id) {
	return mvcInstance.put(`/post/${id}`).catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

function getPost(id) {
	return mvcInstance.get(`/post/${id}`).catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

function getPostList() {
	return mvcInstance.get('posts').catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

function getPostListWithTag(tag) {
	return mvcInstance.get(`posts/${tag}`).catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

function insertRetweetPost(post) {
	return mvcInstance.post('retweet', post).catch(err => {
		store.state.error = err.toString().slice(-3);
	});
}

export {
	getTagsInPost,
	insertTagList,
	updateTagList,
	insertPost,
	deletePost,
	updatePost,
	getPost,
	getPostList,
	getPostListWithTag,
	insertRetweetPost,
};
