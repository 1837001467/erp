<template>
	<el-table :data="rksqs" style="width: 100%;" border :header-cell-style="{'text-align':'center'}"
		:cell-style="{'text-align':'center'}">
		<el-table-column prop="rkBian" label="入库申请编号" width="160"></el-table-column>
		<el-table-column prop="stCode" label="订单入库编号" width="160"></el-table-column>
		<el-table-column prop="rkType" label="入库类型"></el-table-column>
		<el-table-column prop="yhShen.yhName" label="申请人"></el-table-column>
		<el-table-column prop="rkApplicationtime" label="申请时间" width="150"></el-table-column>
		<el-table-column prop="yhPi.yhName" label="审批人"></el-table-column>
		<el-table-column prop="rkApprovaltime" label="审批时间" width="150"></el-table-column>
		<el-table-column prop="rkState" label="状态">
			<template #default="scope">
				<p v-if="scope.row.rkState==0">待审核</p>
				<p v-if="scope.row.rkState==1">已入库</p>
				<p v-if="scope.row.rkState==2">已退货</p>
			</template>
		</el-table-column>
		<el-table-column label="操作" align="center" width="180">
			<template #default="scope">
				<!-- 插槽可以获取当前行对象 scope.row可以获取当前行数据 -->
				<el-tooltip effect="dark" content="查看" placement="bottom">
					<i class="el-icon-document" @click="look(scope.row)"
						style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
				</el-tooltip>
				<el-tooltip effect="dark" content="通过" placement="bottom">
					<i class="el-icon-check" @click="update(scope.row,1)" v-show="scope.row.rkState==0"
						style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
				</el-tooltip>
				<el-tooltip effect="dark" content="不通过" placement="bottom">
					<i class="el-icon-close" @click="update(scope.row,2)" v-show="scope.row.rkState==0"
						style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
				</el-tooltip>
			</template>
		</el-table-column>
	</el-table>
	<!-- layout表示布局方式 prev上一页  next下一页 pager页码列表
		 属性 total  总页数
			  page-size 每页条数
			  current-page 当前页码
		 事件
			  current-change 当前页码发生改变的时候触发的事件
			  size-change    每页条数发生改变时触发的事件
	-->
	<el-pagination background layout="prev, pager, next,sizes,total" :page-sizes="[2, 5, 10, 15]" :total="total"
		:page-size="pageSize" :current-page="pageNo" @current-change="change" @size-change="change2">
	</el-pagination>

	<el-dialog title="入库申请详情" v-model="dialogTableVisible">
		<el-descriptions>
			<el-descriptions-item label="申请人">{{sqr.yhName}}</el-descriptions-item>
			<el-descriptions-item label="申请时间">{{sqr.rkApplicationtime}}</el-descriptions-item>
		</el-descriptions>
		<el-table :data="goods">
			<el-table-column property="good.gName" label="商品名" width="200"></el-table-column>
			<el-table-column property="rkdNum" label="领取数量" width="150"></el-table-column>
		</el-table>
	</el-dialog>
</template>

<script>
export default {
name: "rksq"
}
</script>

<style scoped>

</style>