import {
	createSSRApp
} from "vue";
import App from "./App.vue";
import Vue2Verify from 'vue2-verify';
export function createApp() {
	const app = createSSRApp(App);
	app.use(Vue2Verify)
	return {
		app,
	};
}
