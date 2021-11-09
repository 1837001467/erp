<template>
	<el-table :data="rksqs" style="width: 100%;" border :header-cell-style="{'text-align':'center'}"
		:cell-style="{'text-align':'center'}">
		<el-table-column prop="ckBian" label="入库申请编号" width="160"></el-table-column>
		<el-table-column prop="salesYard" label="订单入库编号" width="160"></el-table-column>
		<el-table-column prop="ckType" label="入库类型"></el-table-column>
		<el-table-column prop="yhShen.yhName" label="申请人"></el-table-column>
		<el-table-column prop="ckApplicationtime" label="申请时间" width="150"></el-table-column>
		<el-table-column prop="yhPi.yhName" label="审批人"></el-table-column>
		<el-table-column prop="ckApprovaltime" label="审批时间" width="150"></el-table-column>
		<el-table-column prop="ckState" label="状态">
			<template #default="scope">
				<p v-if="scope.row.ckState==0">待审核</p>
				<p v-if="scope.row.ckState==1">已出库</p>
				<p v-if="scope.row.ckState==2">库存不足，等待出库</p>
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
					<i class="el-icon-check" @click="update(scope.row,1)" v-show="scope.row.ckState!=1"
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

	<el-dialog title="出库申请详情" v-model="dialogTableVisible">
		<el-descriptions>
			<el-descriptions-item label="申请人">{{sqr.yhName}}</el-descriptions-item>
			<el-descriptions-item label="申请时间">{{sqr.ckApplicationtime}}</el-descriptions-item>
		</el-descriptions>
		<el-table :data="goods">
			<el-table-column property="goods.gName" label="商品名" width="200"></el-table-column>
			<el-table-column property="ckdNum" label="领取数量" width="150"></el-table-column>
		</el-table>
	</el-dialog>
</template>

<script>
	export default {
		data() {
			return {
				rksqs: [],
				pageNo: 1,
				pageSize: 5,
				total: 0,
				dialogTableVisible: false,
				goods: [],
				sqr: {
					yhName: '',
					ckApplicationtime: '',
				},
			}
		},
		methods: {
			loadData() {
				this.axios.get("/ckApply/pager", {
						params: {
							no: this.pageNo,
							size: this.pageSize,
						}
					})
					.then(res => {
						if (res.status == 200) {
							//后台返回的是PageInfo对象，当前分页数据存储在list中
							this.rksqs = res.data.list;
							this.total = res.data.total;
						}
					})
			},
			look(row) {
				this.sqr.yhName = row.yhShen.yhName;
				this.sqr.ckApplicationtime = row.ckApplicationtime;
				this.axios.get("/ckApply/look", {
						params: {
							rkId: row.ckId,
						}
					})
					.then(res => {
						if (res.status == 200) {
							console.log(res.data)
							this.dialogTableVisible = true;
							this.goods = res.data;
						}
					})
			},
			update(row,num) {
				this.axios.get("/ckApply/updateState", {
						params: {
							ckId: row.ckId,
							yhId: 1,
							ckState:parseInt(num),
						}
					})
					.then(res => {
						if (res.status == 200) {
							this.loadData();
							this.$message.success({
								message: '已修改状态'
							});
						}
					})
			},
			change(pageNo) {
				//参数表示待跳转的页码
				this.pageNo = pageNo;
				this.loadData();
			},
			change2(pageSize) {
				/* 参数表示每页条数 */
				this.pageNo = 1;
				this.pageSize = pageSize;
				this.loadData()
			},
		},
		created() {
			this.loadData();
		}
	}
</script>

<style scoped>

</style>
