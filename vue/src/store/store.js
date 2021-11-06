/* 1、导入vuex的相关函数 */
import {createStore} from 'vuex'

// let state={
// 	index:4
// }

/* 2、创建store对象 */
let store = createStore({
	/* 状态管理 */
	state:{
		index:0,
		user:{
			name: '未登录',
		}
	},
	/* 修改状态的同步函数 */
	mutations:{
		login(state,user){
		  //添加用户信息到状态管理器中
		  state.user = user;
		  console.log("hahahah");
		},
		logout(state){
			state.user = {
				name: '未登录',
			}
		},
		updateUser(state,obj){
			state.user.admin = Object.assign(state.user.admin,obj);
			console.log("修改用户信息。。。",state.user);
		}
	}
})
/* 3、导出对象 */
export default store