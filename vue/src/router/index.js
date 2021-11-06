import login from "@/view/Login.vue"
import home from "@/view/home.vue"
let routes = [{
			path: "/",
			name: "首页",
			component: home,
			meta: {
				title: "我是首页"
				}
			},
			{
			path: "/",
			name: "系统管理",
			component: home,
			meta: {
			title: "系统管理"
			},
			children: [
				{
					path: '/bm',
					component: () => import('@/view/qx/dept.vue'),
					name: "部门",
					meta: {
						title: '部门'
					}
				},
				{
					path: '/yg',
					component: () => import('@/view/qx/departmt.vue'),
					name: "员工",
					meta: {
						title: '员工'
					},
				},
				{
					path: '/rz',
					component: () => import('@/view/qx/qxlog.vue'),
					name: "日志",
					meta: {
						title: '日志'
					},
				},
				{
					path: '/js',
					component: () => import('@/view/qx/staff.vue'),
					name: "角色",
					meta: {
						title: '角色'
					},
				},
			]
			},
			{
				path: "/",
				name: "库存管理",
				component: home,
				meta: {
					title: "库存管理"
				},
				children: [
					{
						path: '/cksq',
						component: () => import('@/view/storage/cksq.vue'),
						name: "出库申请",
						meta: {
							title: '出库申请'
						},
					},
					{
						path: '/rksq',
						component: () => import('@/view/storage/rksq.vue'),
						name: "入库申请",
						meta: {
							title: '入库申请'
						},
					},
					{
						path: '/ckdb',
						component: () => import('@/view/storage/ckdb.vue'),
						name: "仓库调拨",
						meta: {
							title: '仓库调拨'
						},
					},
					{
						path: '/ckpd',
						component: () => import('@/view/storage/ckpd.vue'),
						name: "仓库盘点",
						meta: {
							title: '仓库盘点'
						},
					},
					{
						path: '/kcbd',
						component: () => import('@/view/storage/kcbd.vue'),
						name: "库存变动",
						meta: {
							title: '库存变动'
						},
					},
					{
						path: '/zcly',
						component: () => import('@/view/storage/zcly.vue'),
						name: "资产领用",
						meta: {
							title: '资产领用'
						},
					},
					{
						path: '/tl',
						component: () => import('@/view/storage/tl.vue'),
						name: "退料",
						meta: {
							title: '退料'
						},
					},
				]
			},
			{
				path: "/login",
				name: "登陆",
				component: login,
				meta: {
					title: "登陆"
				}
			},
		]

		import {
			createRouter,
			createWebHistory,
			createWebHashHistory
		} from 'vue-router'

		let router = createRouter({
			history: createWebHistory(),
			routes
		})


		export default router
