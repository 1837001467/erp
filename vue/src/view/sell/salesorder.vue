<template>
	<div>
		<el-button style="background-color: #13CE66;color: black;" @click="addSorder">新增销售订单</el-button>
		<el-input placeholder="订单编号" v-model="selectorderYard" clearable style="width: 120px;">
		</el-input>
		<el-button @click="selectByYard">查询</el-button>
		<div>
			<el-table :data="tableData" style="width: 100%">
				<el-table-column label="操作" #default="scope" width="220px">
					<el-button @click="loadDetails(scope.row)">查看详情</el-button>
					<el-button @click="updateOrder(scope.row)" v-if="scope.row.orderState=='已申请'">审核</el-button>
				</el-table-column>
				<el-table-column prop="orderYard" label="订单编号">
				</el-table-column>
				<el-table-column prop="orderName" label="客户">
				</el-table-column>
				<el-table-column prop="orderName" label="联系人">
				</el-table-column>
				<el-table-column prop="orderMoney" label="金额">
				</el-table-column>
				<el-table-column prop="yonghuName" label="申请人">
				</el-table-column>
				<el-table-column prop="orderTime" label="申请时间">
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
						<el-button @click="addOrder">新增采购订单</el-button>
					</div>
					<el-form :model="order">
						<el-form-item>
							<el-descriptions width="100%" v-model="taskdetails">
								<el-descriptions-item width="600px">
									<el-form-item label="订单编号">
										<el-input v-model="order.orderYard" disabled="false"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="客户">
										<!-- <el-input v-model="order.orderName"></el-input> -->
										<el-select v-model="order.khId" placeholder="请选择">
											<el-option v-if="Customer!=null" v-for="b in Customer" :key="b.khId"
												:label="b.khName" :value="b.khId" @click="selectCustomer(b)">
											</el-option>
										</el-select>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系人">
<<<<<<< HEAD
										<el-input v-model="order.orderNames"></el-input>
=======
										<el-input v-model="order.orderNames" disabled="false"></el-input>
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系电话" >
										<el-input v-model="order.orderPhone" disabled="false"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="订单申请人">
										<el-input v-model="order.yhId" disabled="false"></el-input>
									</el-form-item>
								</el-descriptions-item>
							</el-descriptions>
						</el-form-item>
					</el-form>
				</div>
				<div>
					<el-button @click="addCommodity">添加商品</el-button>
<<<<<<< HEAD
					<el-table :data="tableCoom" style="width: 100%">
						<el-table-column prop="gname" label="商品名称">
=======
					<el-table :data="xzData" style="width: 100%">
						<el-table-column prop="gName" label="商品名称">
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
						</el-table-column>
						<el-table-column prop="gprice" label="单价">
						</el-table-column>
						<el-table-column label="数量">
							<template #default="scope">
<<<<<<< HEAD
								<el-input-number v-model="scope.row.gbian" controls-position="right" :min="1">
=======
								<el-input-number v-model="scope.row.gBian" controls-position="right" :min="1">
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
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
<<<<<<< HEAD
									<el-table-column prop="ypcode" label="商品id" width="165px">
									</el-table-column>
									<el-table-column prop="gname" label="商品名称">
									</el-table-column>
									<el-table-column prop="gunit" label="单位">
									</el-table-column>
									<el-table-column prop="gprice" label="单价(元)">
=======
									<el-table-column type="index" label="id" width="165px">
									</el-table-column>
									<el-table-column prop="gName" label="商品名称">
									</el-table-column>
									<el-table-column prop="gUnit" label="单位">
									</el-table-column>
									<el-table-column prop="gPrice" label="单价(元)">
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
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
<<<<<<< HEAD
										<el-input v-model="form.orderYard"></el-input>
=======
										<el-input v-model="form.orderYard" disabled="false"></el-input>
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="客户" prop="taskTitle">
<<<<<<< HEAD
										<el-input v-model="form.khId"></el-input>
=======
										<el-input v-model="form.orderName" disabled="false"></el-input>
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系人" prop="taskTitle">
<<<<<<< HEAD
										<el-input v-model="form.khId"></el-input>
=======
										<el-input v-model="form.orderName" disabled="false"></el-input>
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="联系电话" prop="taskTitle">
<<<<<<< HEAD
										<el-input v-model="form.orderPhone"></el-input>
									</el-form-item>
								</el-descriptions-item>
								<el-descriptions-item width="300px">
									<el-form-item label="订单申请人" prop="taskTitle">
										<el-input v-model="form.yhId"></el-input>
=======
										<el-input v-model="form.orderPhone" disabled="false"></el-input>
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
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
<<<<<<< HEAD
						<el-table-column prop="gname" label="商品名称">
						</el-table-column>
						<el-table-column prop="gprice" label="单价">
=======
						<el-table-column prop="gName" label="商品名称">
						</el-table-column>
						<el-table-column prop="gPrice" label="单价">
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
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
<<<<<<< HEAD
				tableData2:[],//销售订单详情
				order: {
					orderYard:'',
					yhId:'',
				},
				tableCoom: [], //商品详情

=======
				tableData2: [], //销售订单详情
				order: {
					orderYard: '',
					yhId: '戴莉',
				},
				xzData: [], //商品详情
				Customer: [], //客户
				selectorderYard: '', //查询条件
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375

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
				this.order.khId=this.Customer[0].khId;
				this.order.orderNames=this.Customer[0].khName;
				this.order.orderPhone=this.Customer[0].khTel;
				$this.dialogTableVisible = true;
			},
			addOrder() {
				let $this = this;
				this.axios.post("/study/xsSalesorder/add", {
					orderYard: $this.order.orderYard,
<<<<<<< HEAD
					orderName: $this.order.orderName,
					orderNames: $this.order.orderNames,
					orderPhone: $this.order.orderPhone,
					yhId: $this.order.yhId,
					goods:$this.tableCoom,
				}).then(res => {

				})
				this.dialogTableVisible = false;
=======
					khId: $this.order.khId,
					orderNames: $this.order.orderNames,
					orderPhone: $this.order.orderPhone,
					yhId: 1,
					goods: $this.xzData,
				}).then(res => {
					this.loadOrder();
				})
				this.dialogTableVisible = false;
				this.loadOrder();
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
			},
			addCommodity() {
				let $this = this;
				$this.commodityDetails = true;
				this.loadSpuType();
				this.allgoods();
<<<<<<< HEAD
=======
				this.typeData = [];
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
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
<<<<<<< HEAD
			updateOrder(row){
				console.log("ddxq:",row)
				this.axios.post("/study/xsSalesorder/update",{
					orderId:row.orderId,
					orderState:row.orderState,
					qxYhId:'',
				}).then(res =>{
					
=======
			updateOrder(row) {
				console.log("ddxq:", row)
				this.axios.post("/study/xsSalesorder/update", {
					orderId: row.orderId,
					orderState: row.orderState,
					qxYhId: '',
					khId: row.khId,
				}).then(res => {
					this.loadOrder();
				})
			},
			//查询所有用户
			loadCustomer() {
				this.axios.get("/study/jcCustomer").then(res => {
					console.log("客户：", res.data)
					this.Customer = res.data
				})
			},
			selectCustomer(row) {
				console.log("选择的客户信息：", row)
				this.order.orderNames = row.khName;
				this.order.orderPhone = row.khTel;
			},
			selectByYard() {
				this.axios.post("/study/xsSalesorder", {
					orderYard: this.selectorderYard
				}).then(res => {
					console.log("查询的信息：", res)
					this.tableData = res.data
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
				})
			},

			//商品详情
			handleSelectionChange(val) {
<<<<<<< HEAD
				this.tableCoom = val;
				console.log("multipleSelection=", this.tableCoom)
			},
			sure() { //确定
				this.commodityDetails = false;
=======
				this.xzData = val;
				console.log("multipleSelection=", this.multipleSelection);
			},
			sure() { //商品数据弹框确定按钮
				//要判断之前商品已经存在就累加数量	
				this.commodityDetails = false;
				console.log("修改前的商品详情=", this.xzData);
				this.multipleSelection.forEach(v => {
					v.gBian = 1;
				})
				const map = new Map();
				for (let i = 0; i < this.xzData.length; ++i) {
					map.set(this.xzData[i].goId, this.xzData[i])
				}
				for (let i = 0; i < this.multipleSelection.length; ++i) {
					if (map.has(this.multipleSelection[i].goId)) {
						map.get(this.multipleSelection[i].goId).gBian++
					} else {
						map.set(this.multipleSelection[i].goId, this.multipleSelection[i])
					}
				}
				this.xzData = [];
				map.forEach(v => {
					console.log("v=", v);
					this.xzData.push(v);
				})
				this.typeData = [];
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
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
<<<<<<< HEAD
			
=======

>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
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
<<<<<<< HEAD
=======
			this.loadCustomer();
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
		}
	}
</script>

<style scoped="scoped">

</style>
