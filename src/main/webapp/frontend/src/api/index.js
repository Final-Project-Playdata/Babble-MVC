import axios from 'axios';
import { setInterceptors } from './interceptors';

function createInstance() {
	return axios.create({
		baseURL: 'http://localhost:80',
	});
}

// 엑시오스 초기화 함수
function createInstanceWithAuth(url) {
	const instance = axios.create({
		baseURL: url,
	});
	return setInterceptors(instance);
}

export const instance = createInstance();
export const mvcInstance = createInstanceWithAuth('http://localhost:80');
export const fluxInstance = createInstanceWithAuth('http://localhost:88');
