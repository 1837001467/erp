<template>
	<div>
		<el-row>
			<el-form :label-position="labelPosition" label-width="80px">
				<el-button @click="add()">新增</el-button>
			</el-form>
		</el-row>
		<div>
			<el-table :data="tableData" :span-method="objectSpanMethod" style="width: 100%"
				:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}">
				<el-table-column label="订单编码">
					<template #default="scope">
						<el-tag size="medium" type="primary" plain @click="clickData(scope.row.stId)">
							{{scope.row.stCode}}
						</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="stTime" label="制单日期" width="180px">
				</el-table-column>
				<el-table-column prop="jcSupplier.supName" label="供应商">
				</el-table-column>
				<el-table-column prop="ck.whName" label="仓库">
				</el-table-column>
				<el-table-column prop="qxUser.yhName" label="采购员">
				</el-table-column>
				<el-table-column prop="qxUser.yhPhone" label="联系电话">
				</el-table-column>
				<el-table-column prop="stTotalmoney" label="总额">
				</el-table-column>
				<el-table-column label="状态" width="170px">
					<template #default="scope">
						<el-tag size="medium" type="danger" v-show="scope.row.stState==0">未审核</el-tag>
						<el-tag size="medium" type="success" v-show="scope.row.stState==1">已审核未生成入库单</el-tag>
						<el-tag size="medium" type="info" v-show="scope.row.stState==2">已审核已生成入库单</el-tag>
						<el-tag size="medium" type="warning" v-show="scope.row.stState==3">已驳回</el-tag>
					</template>
				</el-table-column>
				<el-table-column label="操作" width="200px">
					<template #default="scope">
						<!-- <el-button @click="ruku(scope.row.orId)" :disabled="scope.row.stState==1?false:true"
							v-show="scope.row.stState==1">入库</el-button>
						<el-button type="primary" plain @click="examine(scope.row)"
							:disabled="scope.row.stState==0?false:true" v-show="scope.row.stState==0">审核
						</el-button> -->
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
				<el-table-column prop="gname" label="商品名称">
				</el-table-column>
				<el-table-column prop="cgStorageDetail.sdCount" label="采购数量">
				</el-table-column>
				<el-table-column prop="cgStorageDetail.sdPrice" label="采购价格">
				</el-table-column>
			</el-table>
		</div>
		<el-dialog title="采购入库单审批" v-model="ExaminedialogVisible" :close-on-click-modal="false">
			<el-form :label-position="labelPosition" label-width="80px" :model="spopinion" :rules="sprules"
				ref="spopinion">
				<el-form-item label="审批" prop="radio" style="float: initial;">
					<el-radio v-model="spopinion.radio" label="1">同意</el-radio>
					<el-radio v-model="spopinion.radio" label="0">不同意</el-radio>
				</el-form-item>
				<el-form-item label="审批意见:" prop="opinion" style="float: initial;">
					<el-input v-model.trim="spopinion.opinion" type="textarea" :autosize="{ minRows: 4, maxRows: 4}">
					</el-input>
				</el-form-item>
			</el-form>
			<template #footer>
				<span class="dialog-footer">
					<el-button @click="qxExamine()">取 消</el-button>
					<el-button type="primary" @click="OnSubmit()">确定
					</el-button>
				</span>
			</template>
		</el-dialog>
		<el-dialog title="采购入库单" v-model="RkdialogVisible" :close-on-click-modal="false" width="60%">
			<div>
				<div style="height: 50px;">
					<el-button @click="hold" type="success" plain>保存</el-button>
				</div>
				<el-form :model="form">
					<el-form-item>
						<el-descriptions width="100%" v-model="taskdetails">
							<el-descriptions-item width="500px">
								<el-form-item label="订单编号">
									<el-input v-model="form.cgcode" disabled></el-input>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="350px">
								<el-form-item label="采购部门" prop="cgbm">
									<el-select v-model="form.bm.bmId">
										<el-option v-for="ct in depts" :label="ct.bmName" :value="ct.bmId"
											:key="ct.bmId">
										</el-option>
									</el-select>
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
							<el-descriptions-item width="350px">
								<el-form-item label="付款账户">
									<el-select v-model="form.zh">
										<el-option v-for="ct in zhtype" :label="ct" :value="ct" :key="ct">
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
					<el-table-column prop="gname" label="商品名称">
					</el-table-column>
					<el-table-column prop="gunit" label="单位">
					</el-table-column>
					<el-table-column label="单价(元)">
						<template #default="scope">
							<el-input-number v-model="scope.row.gprice" controls-position="right" :min="1">
							</el-input-number>
						</template>
					</el-table-column>
					<el-table-column label="数量">
						<template #default="scope">
							<el-input-number v-model="scope.row.gbian" controls-position="right" :min="1">
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
								<el-table-column prop="goId" label="用品编号" width="165px">
								</el-table-column>
								<el-table-column prop="gname" label="用品名称">
								</el-table-column>
								<el-table-column prop="gunit" label="单位">
								</el-table-column>
								<el-table-column prop="gprice" label="单价(元)">
								</el-table-column>
								<el-table-column prop="stocknum" label="库存">
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
	import {
		ElMessage
	} from 'element-plus'
	import qs from 'qs'
	export default {
		data() {
			return {
				state:0,//1新增，0点击生成采购订单
				zhtype: ["现金", "工行", "交通行", "建设银行", "招商银行", "农行"], //账户
				RkdialogVisible: false,
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
					bm: {
						bmId: ''
					},
					explain: '',
					prId: '',
					zh: ''
				},
				dialogTableVisible: true,
				ExaminedialogVisible: false,
				spopinion: {
					radio: '1',
					opinion: ""
				},
				xzData: [], //选择完的商品数据
				sqmessage: {},
				typeData: [], //用品分类
				spudata: [], //商品数据
				cks: [],
				gfId: 0,
				multipleSelection: [],
				Spudialog: false,
				state: 0, //1新增，0点击生成采购订单
				goodsData: [] //商品详情数据
			}
		},
		methods: {
			add(){
				this.state=1;
				this.RkdialogVisible=true;
				this.fuzhi();
			},			
			clickData(stid) { //获取商品详情
				this.tableData.forEach(v => {
					if (v.stId == stid) {
						this.goodsData = v.goods;
					}
				})
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
			fuzhi(){
				this.form.user.yhId = this.users[0].yhId;
				this.form.gys.supId = this.suppliers[0].supId;
				this.form.bm.bmId = this.depts[0].bmId;
				this.form.ck.whId = this.cks[0].whId;
			},
			ruku(orid) { //生成入库单
				let $this = this;
				this.RkdialogVisible = true;
				this.fuzhi();
				this.form.orId = orid;
				this.changeTel();
				$this.form.cgcode = 'CGD' + this.getProjectNum() + Math.floor(Math.random() *
					10000) // 如果是6位或者8位随机数，相应的 *1000000或者 *100000000就行了
				console.log("xxx", this.getProjectNum() + Math.floor(Math.random() *
					10000));
			},
			hold() { //生成入库单的保存
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
					gys: this.form.gys,
					bm: this.form.bm,
					ck: this.form.ck,
					tableData: $this.xzData,
					explain: this.form.explain,
					orid: this.form.orId,
					zh: this.form.zh,
					state:this.state
				}
				console.log("params=", params);
				this.axios.post("/study/cgStorage/addstorage",
					params
				).then(res => {
					console.log("res=", res)
					if (res.data == 1) {
						this.search();
						this.RkdialogVisible = false;
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
				console.log("multipleSelection=", this.multipleSelection)
				this.xzData = this.multipleSelection;
			},
			sure() { //商品数据弹框确定按钮
				this.Spudialog = false;
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
			},
			OnSubmit(row) { //审批弹框确定
				console.log("row==========", row);
				let params = {
					stid: this.sqmessage.stId,
					applystate: this.spopinion.radio,
					spidea: this.spopinion.opinion
				}
				console.log("审批的数据-----：", params);
				this.axios.post("/study/cgStorage/examine", qs.stringify(params)).then(res => {
					console.log("res结果：", res);
					this.ExaminedialogVisible = false;
					this.spopinion.opinion = "";
					this.search();
				})
			},
			qxExamine() { //取消审批
				this.ExaminedialogVisible = false;
				this.spopinion.radio = "1";
				this.spopinion.opinion = "";
			},
			examine(row) { //审批
				let $this = this;
				$this.ExaminedialogVisible = true,
					$this.sqmessage = {
						...row
					};
				console.log("sqmessage", $this.sqmessage);
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
				this.axios.get("/study/cgStorage/all").then(res => {
					console.log(res, "carData-------：", res.data);
					$this.tableData = res.data;
				})
			},
			all() {
				let $this = this;
				this.axios.post("/qxbm", {
					seach: ""
				}).then(res => {
					console.log("depts：", res.data);
					$this.depts = res.data;
				})
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
				$this.form.cgcode = 'CGR' + this.getProjectNum() + Math.floor(Math.random() *
					10000) // 如果是6位或者8位随机数，相应的 *1000000或者 *100000000就行了
				console.log("xxx", this.getProjectNum() + Math.floor(Math.random() *
					10000));
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
