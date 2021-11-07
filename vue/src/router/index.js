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
			name: "采购管理",
			component: home,
			meta: {
			title: "采购管理"
			},
			children: [
				{
					path: '/cgbj',
					component: () => import('@/view/cg/cgbj.vue'),
					name: "采购报价",
					meta: {
						title: '采购报价'
					}
				},
				{
					path: '/cgorder',
					component: () => import('@/view/cg/cgorder.vue'),
					name: "采购订单",
					meta: {
						title: '采购订单'
					}
				},
				{
					path: '/cgstorage',
					component: () => import('@/view/cg/cgstorage.vue'),
					name: "采购入库",
					meta: {
						title: '采购入库'
					}
				},
				{
					path: '/goodtype',
					component: () => import('@/view/cg/allgoods.vue'),
					name: "商品分类",
					meta: {
						title: '商品分类'
					}
				},
				{
					path: '/tuihuo',
					component: () => import('@/view/cg/tuihuo.vue'),
					name: "采购退货",
					meta: {
						title: '采购退货'
					}
				},
				{
					path: '/fkd',
					component: () => import('@/view/cg/fkd.vue'),
					name: "付款单",
					meta: {
						title: '付款单'
					}
				},
				{
					path: '/yinpay',
					component: () => import('@/view/cg/yinpay.vue'),
					name: "应付记账",
					meta: {
						title: '应付记账'
					}
				},
				{
					path: '/ticket',
					component: () => import('@/view/cg/ticket.vue'),
					name: "收票管理",
					meta: {
						title: '收票管理'
					}
				}
			]
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
			{
				path: "/",
				name: "销售管理",
				component: home,
				meta: {
					title: "销售管理"
				},
				children: [
					{
						path: '/salesorder',
						component: () => import('@/view/sell/salesorder.vue'),
						name: "销售订单",
						meta: {
							title: '销售订单'
						},
					},
				]
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
