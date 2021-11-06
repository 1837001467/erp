<template>
	<div>
		<el-button style="background-color: #13CE66;color: black;" @click="addSorder">新增销售订单</el-button>
		<el-input placeholder="订单编号" v-model="order.order_id" clearable style="width: 120px;">
		</el-input>
		<el-input placeholder="客户" v-model="order.order_name" clearable style="width: 120px;">
		</el-input>
		<el-input placeholder="经手人" v-model="order.order_" clearable style="width: 120px;">
		</el-input>
		<el-date-picker v-model="order.time" type="datetimerange" start-placeholder="Start Date"
			end-placeholder="End Date" :default-time="defaultTime1">
		</el-date-picker>
		<el-button>查询</el-button>
		<div>
			<el-table :data="tableData" style="width: 100%">
				<el-table-column label="操作">
				</el-table-column>
				<el-table-column prop="orderYard" label="订单编号">
				</el-table-column>
				<el-table-column prop="khId" label="客户">
				</el-table-column>
				<el-table-column prop="khId" label="联系人">
				</el-table-column>
				<el-table-column prop="orderMoney" label="金额">
				</el-table-column>
				<el-table-column prop="yhId" label="申请人">
				</el-table-column>
				<el-table-column prop="orderTime" label="申请时间">
				</el-table-column>
				<el-table-column prop="qxYhId" label="审核人">
				</el-table-column>
				<el-table-column prop="orderTimes" label="审核时间">
				</el-table-column>
				<el-table-column prop="orderState" label="订单状态">
				</el-table-column>
			</el-table>
			<el-pagination background @current-change="handleCurrentChange" layout="prev, pager, next"
				:page-size="pageSize" :total="total">
			</el-pagination>
			<el-dialog title="新增销售订单" v-model="dialogTableVisible" width="60%">
				<div>
					<div style="height: 50px;">
						<el-button @click="addOrder">保存</el-button>
					</div>
					<el-form :model="order">
						<el-form-item>
							<el-descriptions width="100%" v-model="taskdetails">
								<el-descriptions-item width="600px">
									<el-form-item label="订单编号">
										<el-input v-model="order.orderYard"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="客户">
										<el-input v-model="order.orderName"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系人">
										<el-input v-model="order.orderName"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系电话">
										<el-input v-model="order.orderPhone"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="订单申请人">
										<el-input v-model="order.yhId"></el-input>
									</el-form-item>
								</el-descriptions-item>
							</el-descriptions>
						</el-form-item>
					</el-form>
				</div>
				<div>
					<el-button @click="addCommodity">添加商品</el-button>
					<el-table :data="tableDatas" style="width: 100%">
						<el-table-column prop="taskId" label="商品编号">
						</el-table-column>
						<el-table-column prop="employeeb.eename" label="商品名称">
						</el-table-column>
						<el-table-column prop="employeea.eename" label="单价">
						</el-table-column>
						<el-table-column prop="taskTime" label="数量">
						</el-table-column>
					</el-table>
					<el-dialog title="商品资料" v-model="commodityDetails" width="60%">
						<div>
							<el-button>添加</el-button>
							<el-table ref="multipleTable" :data="tableData" style="width: 100%"
								@selection-change="handleSelectionChange">
								<el-table-column type="selection" width="55" />
								<el-table-column prop="taskId" label="商品编号">
								</el-table-column>
								<el-table-column prop="employeeb.eename" label="商品名称">
								</el-table-column>
								<el-table-column prop="employeea.eename" label="单价">
								</el-table-column>
								<el-table-column prop="taskTime" label="数量">
								</el-table-column>
							</el-table>
						</div>
					</el-dialog>
				</div>
			</el-dialog>
			<el-dialog title="订单详情" v-model="orderDetails" width="60%">
				<div>
					<div style="height: 50px;">
						<el-button @click="addTask">审核</el-button>
					</div>
					<el-form :model="form">
						<el-form-item>
							<el-descriptions width="100%" v-model="taskdetails">
								<el-descriptions-item width="600px">
									<el-form-item label="订单编号" prop="taskTitle">
										<el-input v-model="form.taskTitle"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="客户" prop="taskTitle">
										<el-input v-model="form.taskTitle"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系人" prop="taskTitle">
										<el-input v-model="form.taskTitle"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系电话" prop="taskTitle">
										<el-input v-model="form.taskTitle"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="订单申请人" prop="taskTitle">
										<el-input v-model="form.taskTitle"></el-input>
									</el-form-item>
								</el-descriptions-item>
							</el-descriptions>
						</el-form-item>
					</el-form>
				</div>
				<div>
					<el-affix>商品详情</el-affix>
					<el-table :data="tableData2" style="width: 100%">
						<el-table-column prop="taskId" label="商品编号">
						</el-table-column>
						<el-table-column prop="employeeb.eename" label="商品名称">
						</el-table-column>
						<el-table-column prop="employeea.eename" label="单价">
						</el-table-column>
						<el-table-column prop="taskTime" label="数量">
						</el-table-column>
					</el-table>
				</div>
			</el-dialog>
		</div>
	</div>
</template>

<script>
	import {
		ref,
		defineComponent
	} from 'vue'
	export default {
		data() {
			return {
				order: {},
				form: {},
				dialogTableVisible: false,
				commodityDetails: false,
				orderDetails: false,
				tableData: [],
				order:{},
			}
		},
		methods: {
			loadOrder() {
				let $this = this;
				this.axios.get("/study/xsSalesorder").then(res => {
					console.log("xxx:", res.data)
					$this.tableData = res.data
				})
			},
			addSorder() {
				let $this = this;
				$this.dialogTableVisible = true;
			},
			addOrder(){
				let $this = this;
				this.axios.post("/study/xsSalesorder/add",{
					orderYard:$this.order.orderYard,
					orderName:$this.order.orderName,
					orderPhone:$this.order.orderPhone,
					yhId:$this.order.yhId,
				}).then(res =>{
					
				})
			},
			addCommodity() {
				let $this = this;
				$this.commodityDetails = true;
			},
		},
		mounted() {
			this.loadOrder();
		}
	}
</script>

<style scoped="scoped">

</style>
