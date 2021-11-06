import { createApp } from 'vue'
import ElementEnhance from 'element-enhance'
import 'element-enhance/lib/style.css'
import ElementPlus from 'element-plus'
/* 导入element-plus */
import 'element-plus/lib/theme-chalk/index.css'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import Print from 'vue-print-nb'
import VueAxios from 'vue-axios'
import store from '@/store/store.js'
/* 导入qs的依赖包 */
import qs from 'qs'

/* element-plus汉化 */
import 'dayjs/locale/zh-cn'

import locale from 'element-plus/lib/locale/lang/zh-cn'

router.beforeEach((to, from, next)=> {
	console.log("即将要去的地方",to)
	
	console.log("当前用户：",JSON.stringify(store.state))
    if (to.fullPath == '/login') {
	  //login页面不需要验证，放行，并直接return结束方法
      next();
      return;
    }
	// //从store中或者当前登录的用户信息
    var name = store.state.user.name;
    if (name == '未登录') {
       next("/login")
    } else {
		if(to.matched.length==0){
		next(from.path);	
		}else{
		next();	
		}
    }
  }
)
let vue=createApp(App)
vue.use(ElementEnhance)
vue.use(ElementPlus,{locale})
vue.use(store)
vue.use(router)
vue.use(Print)
vue.use(VueAxios,axios)
vue.use(ElementPlus)/* 将element-plus全局组件库引入vue中 */
/* 配置全局属性 */
vue.config.globalProperties.$qs=qs
vue.mount('#app')
