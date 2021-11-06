<template>
	<!-- 当路径是/   显示的home.vue
	     当路径是/login  显示的是login.vue-->
  <router-view  v-if="isRouterAlive" ></router-view>
</template>

<script>
	import qs from 'qs'
	export default {
		provide() { //提供reload方法
		    return {
		        reload: this.reload
		    }
		},
		data() {
		    return {
		        isRouterAlive : true
		    }
		},
		methods:{ //刷新方法
		    reload() {
		        this.isRouterAlive = false;
		        this.$nextTick(function() {
		            this.isRouterAlive = true
		        })
		    },
		},
		created(){
			//1、判断session中是否存在值
			if(sessionStorage.getItem("state")){
				console.log("哈哈哈")	
				this.$store.replaceState(
					Object.assign(
					{},
					this.$store.state,
					JSON.parse(sessionStorage.getItem("state")))
				)
				let state = this.$store.state;
				console.log(state)
				// sessionStorage.removeItem("state");
			}else{
				console.log("y有值.....",this.$store.state)
			}
		},
		mounted() {
			let state = this.$store.state;
			console.log(state)
			//注册事件
			window.addEventListener("beforeunload",function(){
				console.log("beforeunload事件在当页面卸载（关闭）或刷新时调用")
				sessionStorage.setItem("state",JSON.stringify(state));
			})
		}
	}
</script>