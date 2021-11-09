<template>
	<div>
		<el-row>
			<el-form :label-position="labelPosition" label-width="80px">
				<el-form-item label="状态:" size="medium" style="float: left;">
					<el-select v-model="searchform.stateoption" clearable>
						<el-option v-for="ct in states" :label="ct.name" :value="ct.value" :key="ct.value">
						</el-option>
					</el-select>
				</el-form-item>
				<el-button @click="search()" type="primary" plain icon="el-icon-search" size="medium">查询</el-button>
				<el-button @click="add()" type="success" plain icon="el-icon-plus" size="medium">新增</el-button>
			</el-form>
		</el-row>
		<div>
			<el-table :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)" :span-method="objectSpanMethod" style="width: 100%"
				:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}">
				<el-table-column label="订单编码">
					<template #default="scope">
						<el-tag size="medium" type="primary" plain @click="clickData(scope.row.reId)">
							{{scope.row.reCode}}
						</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="reTime" label="制单日期" width="180px">
				</el-table-column>
				<el-table-column prop="supplier.supName" label="供应商">
				</el-table-column>
				<el-table-column prop="reResaon" label="退货原因">
				</el-table-column>
				<el-table-column prop="user.yhName" label="采购员">
				</el-table-column>
				<el-table-column prop="user.yhPhone" label="联系电话">
				</el-table-column>
				<el-table-column label="状态" width="170px">
					<template #default="scope">
						<el-tag size="medium" type="success" v-show="scope.row.reState==0">正常</el-tag>
						<el-tag size="medium" type="danger" v-show="scope.row.reState==1">停用</el-tag>
					</template>
				</el-table-column>
				<el-table-column label="操作" width="200px">
					<template #default="scope">
						<el-button size="small" @click="delTh(scope.row)" v-show="scope.row.reState==0" type="danger"
							plain>删除
						</el-button>
						<el-button size="small" @click="delTh(scope.row)" v-show="scope.row.reState==1" type="success"
							plain>启用
						</el-button>
					</template>
				</el-table-column>
			</el-table>
			<!--分页插件-->
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				style="text-align: center; margin-top: 10px" :current-page="currentPage" :page-sizes="[2,4,6,8]"
				:page-size="pagesize" layout="total, sizes, prev, pager, next, jumper" :total="tableData.length">
			</el-pagination>
		</div>
		<div class="bootomdiv">
			<span>商品详情：</span>
			<el-table :data="goodsData" :header-cell-style="{'text-align':'center'}"
				:cell-style="{'text-align':'center'}">
				<el-table-column type="index" label="序号">
				</el-table-column>
				<el-table-column prop="gName" label="商品名称">
				</el-table-column>
				<el-table-column prop="cgReturndetail.rdCount" label="退货数量">
				</el-table-column>
				<el-table-column prop="cgReturndetail.rdPrice" label="退货价格(元)">
				</el-table-column>
			</el-table>
		</div>

		<el-dialog title="采购退货单" v-model="ThdialogVisible" :close-on-click-modal="false" width="60%">
			<div>
				<div style="height: 50px;">
					<el-button @click="hold" type="success" plain>保存</el-button>
				</div>
				<el-form :model="form">
					<el-form-item>
						<el-descriptions width="100%">
							<el-descriptions-item width="500px">
								<el-form-item label="订单编号">
									<el-input v-model="form.cgcode" disabled></el-input>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="350px">
								<el-form-item label="采购员">
									<el-select v-model="form.user.yhId">
										<el-option v-for="ct in users" :label="ct.yhName" :value="ct.yhId"
											:key="ct.yhId">
										</el-option>
									</el-select>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="600px">
								<el-form-item label="供应商">
									<el-select v-model="form.gys.supId" @change="changeTel">
										<el-option v-for="ct in suppliers" :label="ct.supName" :value="ct.supId"
											:key="ct.supId">
										</el-option>
									</el-select>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="350px">
								<el-form-item label="进货仓">
									<el-select v-model="form.ck.whId">
										<el-option v-for="ct in cks" :label="ct.whName" :value="ct.whId" :key="ct.whId">
										</el-option>
									</el-select>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="900px">
								<el-form-item label="说明:" prop="explain">
									<el-input v-model="form.explain"></el-input>
								</el-form-item>
							</el-descriptions-item>
						</el-descriptions>
					</el-form-item>
				</el-form>
			</div>
			<div>
				<el-button @click="addCommodity">添加商品</el-button>
				<el-table :data="xzData" style="width: 100%">
					<el-table-column prop="goId" label="商品编号">
					</el-table-column>
					<el-table-column prop="gName" label="商品名称">
					</el-table-column>
					<el-table-column prop="gUnit" label="单位">
					</el-table-column>
					<el-table-column label="单价(元)">
						<template #default="scope">
							<el-input-number v-model="scope.row.gPrice" controls-position="right" :min="1">
							</el-input-number>
						</template>
					</el-table-column>
					<el-table-column label="数量">
						<template #default="scope">
							<el-input-number v-model="scope.row.gBian" controls-position="right" :min="1">
							</el-input-number>
						</template>
					</el-table-column>
				</el-table>
				<el-dialog title="商品资料" v-model="Spudialog" width="60%" :close-on-click-modal="false">
					<div>
						<el-button @click="sure()" style="width: 100px;height: 30px;">确定</el-button>
					</div>
					<el-container>
						<div style="width: 180px;padding: 10px;" @click="cxsousuo()">
							<el-input placeholder="输入关键字搜索" v-model="filterText">
							</el-input>
							<el-tree class="filter-tree" :data="typeData" highlight-current
								:filter-node-method="filterNode" ref="tree" @node-click="clickNode"
								default-expand-all="true">
							</el-tree>
						</div>
						<el-container style="padding-top: 10px;">
							<el-table ref="multipleTable" :data="spudata" style="width: 100%"
								:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}"
								row-key="spuid" :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
								 :default-sort="{prop: 'goId', order: 'descending'}"
								@selection-change="handleSelectionChange">
								<el-table-column type="selection" width="55">
								</el-table-column>
								<el-table-column prop="goId" label="用品编号" width="165px">
								</el-table-column>
								<el-table-column prop="gName" label="用品名称">
								</el-table-column>
								<el-table-column prop="gUnit" label="单位">
								</el-table-column>
								<el-table-column prop="gPrice" label="单价(元)">
								</el-table-column>
							</el-table>
						</el-container>
					</el-container>
				</el-dialog>
			</div>
		</el-dialog>
	</div>
</template>

<script>
	import {
		ref,
		defineComponent
	} from 'vue'
	import qs from 'qs'
	export default {
		data() {
			return {
				zhtype: ["现金", "工行", "交通行", "建设银行", "招商银行", "农行"], //账户
				ThdialogVisible: false,
				labelPosition: 'right',
				searchform: {},
				currentPage: 1, //1初始页
				pagesize: 10, //    1每页的数
				tableData: [],
				order: {},
				form: {
					user: {
						yhId: ''
					},
					cgcode: "",
					gys: {
						supId: ''
					},
					ck: {
						whId: ''
					},
					explain: ''
				},
				dialogTableVisible: true,
				xzData: [], //选择完的商品数据
				sqmessage: {},
				typeData: [], //用品分类
				spudata: [], //商品数据
				cks: [],
				gfId: 0,
				multipleSelection: [],
				Spudialog: false,
				states: [{
						value: 1,
						name: '正常'
					},
					{
						value: 2,
						name: '停用'
					}
				],
				goodsData: [] //商品详情数据
			}
		},
		methods: {
			delTh(row) { //删除退货单
				this.$confirm('此操作将修改退货单状态, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					let $this = this;
					let params = {
						reid: row.reId,
						restate: row.reState
					}
					console.log("params=", params);
					this.axios.post("/cgReturn/delTh", qs.stringify(params)).then(res => {
						if (res.data == 1) {
							this.search();
						}
					})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消修改'
					});
				});
			},
			add() {
				let $this = this;
				this.ThdialogVisible = true;
				this.form.user.yhId = this.users[0].yhId;
				this.form.gys.supId = this.suppliers[0].supId;
				this.form.ck.whId = this.cks[0].whId;
				$this.form.cgcode = 'THD' + this.getProjectNum() + Math.floor(Math.random() *
					10000) // 如果是6位或者8位随机数，相应的 *1000000或者 *100000000就行了
				console.log("xxx", this.getProjectNum() + Math.floor(Math.random() *
					10000));
			},
			clickData(reId) { //获取商品详情
				this.tableData.forEach(v => {
					if (v.reId == reId) {
						this.goodsData = v.goods;
					}
				})
				console.log("this.goodsData-------=", this.goodsData);
			},
			// 初始页currentPage、初始每页数据数pagesize和数据data
			handleSizeChange: function(size) {
				this.pagesize = size;
				console.log(this.pagesize) //每页下拉显示数据
			},
			handleCurrentChange: function(currentPage) {
				this.currentPage = currentPage;
				console.log(this.currentPage) //点击第几页
			},
			ruku(reid) { //生成退货单
				let $this = this;
				this.ThdialogVisible = true;
				this.form.reId = reid;
				this.changeTel();
				$this.form.cgcode = 'CGD' + this.getProjectNum() + Math.floor(Math.random() *
					10000) // 如果是6位或者8位随机数，相应的 *1000000或者 *100000000就行了
				console.log("xxx", this.getProjectNum() + Math.floor(Math.random() *
					10000));
			},
			hold() { //生成退货单的保存
				let $this = this;
				console.log("this.xzData=", this.xzData);
				if (this.xzData.length == 0) {
					ElMessage.warning({
						message: '请选择商品',
						type: 'warning'
					});
					return;
				}
				let params = {
					ddcode: $this.form.cgcode,
					user: this.form.user,
					supplier: this.form.gys,
					ck: this.form.ck,
					tableData: $this.xzData,
					explain: this.form.explain
				}
				console.log("params=", params);
				this.axios.post("/cgReturn/add",
					params
				).then(res => {
					console.log("res=", res)
					if (res.data == 1) {
						this.search();
						this.ThdialogVisible = false;
					}
				})
			},
			//商品渲染
			cxsousuo() {
				this.gfId = 0;
				this.allgoods();
			},
			handleSelectionChange(val) {
				this.multipleSelection = val;
			},
			sure() { //商品数据弹框确定按钮
				this.Spudialog = false;
				//要判断之前商品已经存在就累加数量
				console.log("修改前xzData=", this.xzData);
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
				console.log("修改后xzData=", this.xzData);
				this.typeData = [];
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
			addCommodity() {
				this.Spudialog = true;
				this.loadSpuType();
				this.allgoods();
				this.multipleSelection = [];
				this.$refs["multipleTable"].clearSelection();
			},
			//每页请求的页码数发生改变时触发
			handleSizeChange(size) {
				this.pageSize = size;
				this.search();
			},
			//当前页面发生改变时触发
			handleCurrentChange(currNo) {
				this.pageNo = currNo;
				this.search();
			},
			search() {
				let $this = this;
				console.log("$this.searchform.stateoption", $this.searchform.stateoption);
				let cs = 3;
				console.log($this.searchform.stateoption == undefined, "555555");
				console.log($this.searchform.stateoption);
				if ($this.searchform.stateoption == undefined || $this.searchform.stateoption == '') {
					console.log("11111");
					cs = 3;
				} else if($this.searchform.stateoption == 1){
					cs=0;
				}else if($this.searchform.stateoption == 2){
					cs=1;
				}
				
				let searchmessages = {
					zt: cs
				}
				console.log("searchmessages", searchmessages);
				this.axios.post("/cgReturn/all", qs.stringify(searchmessages)).then(res => {
					console.log(res, "carData-------：", res.data);
					$this.tableData = res.data;
				})
			},
			all() {
				let $this = this;
				this.axios.post("/user", {
					seach: ""
				}).then(res => {
					console.log("users：", res.data);
					$this.users = res.data;
				})
				this.axios.post("/supplier/allsup").then(res => {
					console.log(res, "sup：", res.data);
					$this.suppliers = res.data;
				})
				this.axios.get("/JcWhinformation/selectAll").then(res => {
					console.log(res, "sup：", res.data);
					$this.cks = res.data;
				})
			},
			// 获取当前日期的方法
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
			}
		},
		created() {
			this.search();
			this.all();
		}
	}
</script>


<style scoped="scoped">
	.el-input-number {
		width: 130px;
	}

	.bootomdiv {
		margin-top: 100px;
		margin-bottom: 0px;
		position: relative;
	}
</style>
