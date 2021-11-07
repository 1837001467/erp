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
				<el-table-column label="操作" #default="scope" width="220px">
					<el-button @click="loadDetails(scope.row)">查看详情</el-button>
					<el-button @click="updateOrder(scope.row)" v-if="scope.row.orderState=='已申请'">审核</el-button>
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
			<el-dialog title="新增销售订单" v-model="dialogTableVisible" width="60%" :close-on-click-modal="false">
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
										<el-input v-model="order.orderNames"></el-input>
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
					<el-table :data="tableCoom" style="width: 100%">
						<el-table-column prop="gname" label="商品名称">
						</el-table-column>
						<el-table-column prop="gprice" label="单价">
						</el-table-column>
						<el-table-column label="数量">
							<template #default="scope">
								<el-input-number v-model="scope.row.gbian" controls-position="right" :min="1">
								</el-input-number>
							</template>
						</el-table-column>
					</el-table>
					<el-dialog title="商品资料" v-model="commodityDetails" width="60%" :close-on-click-modal="false">
						<div>
							<el-button @click="sure()" style="width: 100px;height: 30px;">确定</el-button>
						</div>
						<el-container>
							<div style="width: 180px;padding: 10px;" @click="cxsousuo()">
								<el-input placeholder="输入关键字搜索" v-model="filterText">
								</el-input>
								<el-tree class="filter-tree" :data="typeData" :props="defaultProps" highlight-current
									:filter-node-method="filterNode" ref="tree" @node-click="clickNode"
									default-expand-all="true">
								</el-tree>
							</div>
							<el-container style="padding-top: 10px;">
								<el-table ref="multipleTable" :data="spudata" style="width: 100%"
									:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}"
									row-key="spuid" :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
									@selection-change="handleSelectionChange">
									<el-table-column type="selection" width="55">
									</el-table-column>
									<el-table-column prop="ypcode" label="商品id" width="165px">
									</el-table-column>
									<el-table-column prop="gname" label="商品名称">
									</el-table-column>
									<el-table-column prop="gunit" label="单位">
									</el-table-column>
									<el-table-column prop="gprice" label="单价(元)">
									</el-table-column>
								</el-table>
							</el-container>
						</el-container>
					</el-dialog>
				</div>
			</el-dialog>
			<el-dialog title="订单详情" v-model="orderDetails" width="60%">
				<div>
					<el-form :model="form">
						<el-form-item>
							<el-descriptions width="100%" v-model="taskdetails">
								<el-descriptions-item width="600px">
									<el-form-item label="订单编号" prop="taskTitle">
										<el-input v-model="form.orderYard"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="客户" prop="taskTitle">
										<el-input v-model="form.khId"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系人" prop="taskTitle">
										<el-input v-model="form.khId"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系电话" prop="taskTitle">
										<el-input v-model="form.orderPhone"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="订单申请人" prop="taskTitle">
										<el-input v-model="form.yhId"></el-input>
									</el-form-item>
								</el-descriptions-item>
							</el-descriptions>
						</el-form-item>
					</el-form>
				</div>
				<div>
					<el-affix>商品详情</el-affix>
					<el-table :data="tableData2.goods" style="width: 100%">
						<el-table-column prop="goId" label="商品编号">
						</el-table-column>
						<el-table-column prop="gname" label="商品名称">
						</el-table-column>
						<el-table-column prop="gprice" label="单价">
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
	import qs from 'qs'
	import {
		ElMessage
	} from 'element-plus'
	export default {
		data() {
			return {
				order: {},
				form: {},
				dialogTableVisible: false,
				commodityDetails: false,
				orderDetails: false,
				tableData: [], //销售订单
				tableData2:[],//销售订单详情
				order: {
					orderYard:'',
					yhId:'',
				},
				tableCoom: [], //商品详情


				//商品详情
				filterText: '',
				pageNo: 1,
				pageSize: 5,
				total: 0,
				typeData: [], //用品分类
				spudata: [],
				gfId: 0,
				multipleSelection: []
			}
		},
		watch: {
			filterText(val) {
				this.$refs.tree.filter(val);
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
			addOrder() {
				let $this = this;
				this.axios.post("/study/xsSalesorder/add", {
					orderYard: $this.order.orderYard,
					orderName: $this.order.orderName,
					orderNames: $this.order.orderNames,
					orderPhone: $this.order.orderPhone,
					yhId: $this.order.yhId,
					goods:$this.tableCoom,
				}).then(res => {

				})
				this.dialogTableVisible = false;
			},
			addCommodity() {
				let $this = this;
				$this.commodityDetails = true;
				this.loadSpuType();
				this.allgoods();
			},
			loadDetails(row) {
				this.orderDetails = true
				this.form = {
					...row
				}
				this.tableData2 = {
					...row
				}
			},
			updateOrder(row){
				console.log("ddxq:",row)
				this.axios.post("/study/xsSalesorder/update",{
					orderId:row.orderId,
					orderState:row.orderState,
					qxYhId:'',
				}).then(res =>{
					
				})
			},

			//商品详情
			handleSelectionChange(val) {
				this.tableCoom = val;
				console.log("multipleSelection=", this.tableCoom)
			},
			sure() { //确定
				this.commodityDetails = false;
			},
			filterNode(value, data) {
				if (!value) return true;
				return data.label.indexOf(value) !== -1;
			},
			clickNode(data, node) {
				console.log(data, "获取到的tree数据：", data.id, node.parent.data.id);
				if (data.id) {
					this.gfId = data.id;
				} else {
					this.gfId = 0;
				}
				console.log("this.gfId=" + this.gfId);
				this.allgoods();
			},
			loadSpuType() { //公告分类数据
				let $this = this;
				this.axios.post("/alltype")
					.then(res => {
						console.log("sputypes：", res);
						let spu = {
							id: 0,
							label: '商品分类',
							children: []
						}
						res.data.forEach((v, i) => {
							let pos = {
								id: v.gfId,
								label: v.gfName,
							}
							spu.children.push(pos);
						})
						$this.typeData.push(spu);
						console.log("typeData=", this.typeData);
					})
			},
			allgoods() {
				let $this = this;
				let search = {
					gfId: $this.gfId
				};
				this.axios.post("/getByType",
					qs.stringify(search)
				).then(res => {
					console.log("res=", res)
					$this.spudata = res.data;
				})
			},
			
			// 获取当前日期的方法   随机码
			getProjectNum() {
				let $this = this;
				const projectTime = new Date() // 当前中国标准时间
				const Year = projectTime.getFullYear() // 获取当前年份 支持IE和火狐浏览器.
				const Month = projectTime.getMonth() + 1 // 获取中国区月份
				const Day = projectTime.getDate() // 获取几号
				var CurrentDate = Year
				if (Month >= 10) { // 判断月份和几号是否大于10或者小于10
					CurrentDate += Month
				} else {
					CurrentDate += '0' + Month
				}
				if (Day >= 10) {
					CurrentDate += Day
				} else {
					CurrentDate += '0' + Day
				}
				return CurrentDate
			},
			created() {
				let $this = this;
				// 调用获取当前日期的方法加四位随机数  赋值表单中的项目编号
				$this.order.orderYard = 'XSDD' + this.getProjectNum() + Math.floor(Math.random() *
					10000) // 如果是6位或者8位随机数，相应的 *1000000或者 *100000000就行了
				console.log("xxx", this.getProjectNum() + Math.floor(Math.random() *
					10000));
			},
		},
		mounted() {
			this.loadOrder();
			this.created();
		}
	}
</script>

<style scoped="scoped">

</style>
