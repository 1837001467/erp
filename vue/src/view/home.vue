<template> 
	<el-container>
		<!-- height顶栏高度-->
		<el-header height="80px">
			<el-row :gutter="20">
				<el-col :span="8">
					超易进销存管理系统<i class="el-icon-user-solid"></i>
				</el-col>
				<el-col :span="8"></el-col>
				<el-col :span="8" style="text-align: right;">
					<el-button plain circle icon="el-icon-eleme">注销账号</el-button>
				</el-col>
			</el-row>
		</el-header>
		<el-container>
			<el-aside width="200px">
				<!-- el-menu导航菜单 -->
				<el-menu :default-active="2" :unique-opened="true" class="el-menu-vertical-demo"
					background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
					<!-- 可展开的菜单选项-->
					<el-submenu index="1">
						<template #title><i class="el-icon-s-help"></i>采购</template>						
						<el-menu-item index="1-1"><router-link to="/cgprice"><i class="el-icon-user-solid"></i>采购报价</router-link></el-menu-item>
						<el-menu-item index="1-2"><i class="el-icon-user-solid"></i><router-link to="/cgorder">采购订单</router-link></el-menu-item>
						<el-menu-item index="1-3"><i class="el-icon-user-solid"></i><router-link to="/cgstorage">采购入库</router-link></el-menu-item>
						<el-menu-item index="1-4"><i class="el-icon-user-solid"></i><router-link to="/tuihuo">采购退货</router-link></el-menu-item>
						<!-- <el-menu-item index="1-4"><i class="el-icon-user-solid"></i><router-link to="/goodtype">商品分类</router-link></el-menu-item> -->
						<!-- <el-menu-item index="1-5"><i class="el-icon-user-solid"></i><router-link to="/fkd">付款单</router-link></el-menu-item> -->
						<el-menu-item index="1-6"><i class="el-icon-user-solid"></i><router-link to="/yinpay">付款记录</router-link></el-menu-item>
						<el-menu-item index="1-7"><i class="el-icon-user-solid"></i><router-link to="/ticket">收票管理</router-link></el-menu-item>
					</el-submenu>
					<!-- 可展开的菜单选项-->
					<el-submenu index="2">
						<template #title><i class="el-icon-s-help"></i>销售</template>
						<el-menu-item index="2-1">
							<router-link style="text-decoration: none" to="/salesorder"><i class="el-icon-user-solid"></i>销售订单
							</router-link>
						</el-menu-item>
						<el-menu-item index="2-2">
							<router-link style="text-decoration: none" to="/salesorder"><i class="el-icon-user-solid"></i>销售单
							</router-link>
						</el-menu-item>
						<el-menu-item index="2-3">
							<router-link style="text-decoration: none" to="/salesorder"><i class="el-icon-user-solid"></i>收款单
							</router-link>
						</el-menu-item>
						<el-menu-item index="2-4">
							<router-link style="text-decoration: none" to="/salesorder"><i class="el-icon-user-solid"></i>发票管理
							</router-link>
						</el-menu-item>
						<el-menu-item index="2-5">
							<router-link style="text-decoration: none" to="/salesorder"><i class="el-icon-user-solid"></i>销售退货
							</router-link>
						</el-menu-item>
						<el-menu-item index="2-6">
							<router-link style="text-decoration: none" to="/salesorder"><i class="el-icon-user-solid"></i>应收记账
							</router-link>
						</el-menu-item>
						<el-menu-item index="2-7">
							<router-link style="text-decoration: none" to="/salesorder"><i class="el-icon-user-solid"></i>入库申请
							</router-link>
						</el-menu-item>
					</el-submenu>
					<!-- 可展开的菜单选项-->
					<el-submenu index="4">
						<template #title><i class="el-icon-s-help"></i>仓库</template>
						<el-menu-item index="4-1">
							<router-link style="text-decoration: none" to="/cksq"><i class="el-icon-user-solid"></i>出库申请</router-link>
						</el-menu-item>
						<el-menu-item index="4-2">
							<router-link style="text-decoration: none" to="/rksq"><i class="el-icon-user-solid"></i>入库申请
							</router-link>
						</el-menu-item>
						<el-menu-item index="4-3">
							<router-link style="text-decoration: none" to="/ckdb"><i class="el-icon-user-solid"></i>库存调拨
							</router-link>
						</el-menu-item>
						<el-menu-item index="4-4"> 
							<router-link style="text-decoration: none" to="/ckpd"><i class="el-icon-user-solid"></i>仓库盘点
							</router-link>
						</el-menu-item>
						<el-menu-item index="4-5">
							<router-link style="text-decoration: none" to="/kcbd"><i class="el-icon-user-solid"></i>库存变动
							</router-link>
						</el-menu-item>
						<el-menu-item index="4-6">
							<router-link style="text-decoration: none" to="/zcly"><i class="el-icon-user-solid"></i>资产领用
							</router-link>
						</el-menu-item>
						<el-menu-item index="4-7">
							<router-link style="text-decoration: none" to="/tl"><i class="el-icon-user-solid"></i>退料
							</router-link>
						</el-menu-item>
					</el-submenu>
					<!-- 可展开的菜单选项-->
					<el-submenu index="5">
						<template #title><i class="el-icon-s-help"></i>资料</template>
      <el-menu-item index="5-1"><i class="el-icon-user-solid"></i><router-link to="/rk">客户资料</router-link></el-menu-item>
      <el-menu-item index="5-2"><router-link to="/ck"><i class="el-icon-user-solid"></i>供应商资料</router-link></el-menu-item>
      <el-menu-item index="5-2"><router-link to="/ck"><i class="el-icon-user-solid"></i>商品资料</router-link></el-menu-item>
      <el-menu-item index="5-2"><router-link to="/ck"><i class="el-icon-user-solid"></i>仓库资料</router-link></el-menu-item>
					</el-submenu>
					<!-- 可展开的菜单选项-->
					<el-submenu index="6">
						<template #title><i class="el-icon-s-help"></i>系统设置</template>
						<el-menu-item index="5-1"><i class="el-icon-user-solid"></i>
							<router-link to="/bm">部门</router-link>
						</el-menu-item>
						<el-menu-item index="5-2">
							<router-link style="text-decoration: none" to="/yg"><i class="el-icon-user-solid"></i>员工
							</router-link>
						</el-menu-item>
						<el-menu-item index="5-2">
							<router-link style="text-decoration: none" to="/rz"><i class="el-icon-user-solid"></i>日志
							</router-link>
						</el-menu-item>
						<el-menu-item index="5-2">
							<router-link style="text-decoration: none" to="/qx"><i class="el-icon-user-solid"></i>权限
							</router-link>
						</el-menu-item>
					</el-submenu>
					<!-- 菜单分组 el-menu-group-->
				</el-menu>
			</el-aside>
			<el-container>
				<el-main>
					<!-- 主视图区 -->
					<router-view></router-view>
				</el-main>
				<el-footer>Footer</el-footer>
			</el-container>
		</el-container>
	</el-container>
</template>

<script>
</script>

<style>
	html,
	body {
		height: 100%;
	}

	/* 顶栏样式 */
	.el-header {
		background: #42B983;
		color: #fff;
		line-height: 80px;
		font-size: 22px;
	}

	/* 侧边栏 */
	.el-aside {
		background-color: #545c64;
		color: #fff;
		margin-top: 1px;
		min-height: 670px;
	}

	.el-main {
		padding-top: 20px;
	}

	.el-footer {
		background-color: #2C3E50;
	}

	.el-submenu__title i {
		color: yellowgreen;
	}
	.el-submenu__title i.el-icon-arrow-down {
		color: yellow
	}

	.el-menu-item * {
		color: cyan;
		vertical-align: middle;
		text-decoration: none;
	}
</style>
