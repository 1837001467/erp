<template>
	<div>
		<el-row>
			<el-form :label-position="labelPosition" label-width="80px">
				<el-form-item label="项目名称:" size="medium" style="float: left;">
					<el-input placeholder="项目名称" v-model="searchform.xmname" clearable style="width: 120px;">
					</el-input>
				</el-form-item>
				<el-form-item label="采购部门:" size="medium" style="float: left;">
					<el-select v-model="searchform.cgbm" clearable>
						<el-option v-for="ct in depts" :label="ct.bmName" :value="ct.bmId" :key="ct.bmId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="经手人:" size="medium" style="float: left;margin-right: 50px;">
					<el-select v-model="searchform.cgbm" clearable>
						<el-option v-for="ct in users" :label="ct.yhName" :value="ct.yhId" :key="ct.yhId">
						</el-option>
					</el-select>
				</el-form-item>
				<el-button @click="search()">查询</el-button>
				<el-button @click="add()">新增</el-button>
			</el-form>
		</el-row>
		<div>
			<el-table :data="tableData.slice((pageNo)*pageSize,pageNo*pageSize)">
				<el-table-column label="订单编码">
					<template #default="scope">
						<el-tag size="medium" type="primary" plain @click="clickData(scope.row.prId)">
							{{scope.row.prCode}}
						</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="prName" label="项目名称">
				</el-table-column>
				<el-table-column prop="qxDepartment.bmName" label="采购部门">
				</el-table-column>
				<el-table-column prop="prZdtime" label="制单日期" width="170px">
				</el-table-column>
				<el-table-column prop="jcSupplier.supName" label="供应商">
				</el-table-column>
				<el-table-column prop="qxUser.yhName" label="经手人">
				</el-table-column>
				<el-table-column prop="qxUser.yhPhone" label="联系电话">
				</el-table-column>
				<el-table-column label="状态">
					<template #default="scope">
						<el-tag size="medium" type="danger" v-show="scope.row.prState==0">未审核</el-tag>
						<el-tag size="medium" type="success" v-show="scope.row.prState==1">已审核未生成订单</el-tag>
						<el-tag size="medium" type="info" v-show="scope.row.prState==2">已审核已生成订单</el-tag>
						<el-tag size="medium" type="warning" v-show="scope.row.prState==3">已驳回</el-tag>
					</template>
				</el-table-column>
				<el-table-column label="操作">
					<template #default="scope">
						<el-button size="small" type="success" plain @click="caigou(scope.row.prId)"
							:disabled="scope.row.prState==1?false:true" v-show="scope.row.prState==1">
							生成采购单</el-button>
						<el-button size="small" type="primary" plain @click="examine(scope.row)"
							:disabled="scope.row.prState==0?false:true" v-show="scope.row.prState==0">审核
						</el-button>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageNo"
				:page-sizes="[2, 5, 10, 15]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper"
				:total="tableData.length">
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
				<el-table-column prop="cgPricedetail.pdCount" label="采购数量">
				</el-table-column>
				<el-table-column prop="cgPricedetail.pdPrice" label="采购价格">
				</el-table-column>
			</el-table>
		</div>
		<el-dialog title="采购报价审批" v-model="ExaminedialogVisible" :close-on-click-modal="false">
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
		<el-dialog title="采购订单" v-model="CgdialogVisible" :close-on-click-modal="false" width="60%">
			<div>
				<el-form :model="form" :rules="rules" ref="form">
					<div style="height: 50px;">
						<el-button @click="hold('form')" type="success" plain>保存</el-button>
					</div>
					<el-form-item>
						<el-descriptions width="100%">
							<el-descriptions-item width="600px">
								<el-form-item label="订单编号">
									<el-input v-model="form.cgcode" disabled></el-input>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="300px" v-show="state==1" v-if="state==1">
								<el-form-item label="项目名称" prop="prname">
									<el-input v-model="form.prname"></el-input>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="300px">
								<el-form-item label="采购部门" prop="cgbm">
									<el-select v-model="form.bm.bmId">
										<el-option v-for="ct in depts" :label="ct.bmName" :value="ct.bmId"
											:key="ct.bmId">
										</el-option>
									</el-select>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="300px">
								<el-form-item label="采购员">
									<el-select v-model="form.user.yhId">
										<el-option v-for="ct in users" :label="ct.yhName" :value="ct.yhId"
											:key="ct.yhId">
										</el-option>
									</el-select>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="400px">
								<el-form-item label="供应商">
									<el-select v-model="form.gys.supId" @change="changeTel">
										<el-option v-for="ct in suppliers" :label="ct.supName" :value="ct.supId"
											:key="ct.supId">
										</el-option>
									</el-select>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="500px">
								<el-form-item label="联系电话">
									<el-input v-model="form.tel" disabled=""></el-input>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="500px" v-show="state==1" v-if="state==1">
								<el-form-item label="需求日期">
									<el-date-picker v-model="form.xqtime" type="datetime" placeholder="选择日期时间"
										style="width: 100%;">
									</el-date-picker>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="350px" v-show="state==1" v-if="state==1">
								<el-form-item label="总金额">
									<el-input v-model="form.totalmoney" disabled></el-input>
								</el-form-item>
							</el-descriptions-item>
							<el-descriptions-item width="500px">
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
					<el-table-column label="采购单价(元)">
						<template #default="scope">
							<el-input-number v-model="scope.row.gPrice" controls-position="right" :min="1"
								@change="changeTotalmoney()">
							</el-input-number>
						</template>
					</el-table-column>
					<el-table-column label="采购数量">
						<template #default="scope">
							<el-input-number v-model="scope.row.gBian" controls-position="right" :min="1"
								@change="changeTotalmoney()">
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
	import {
		ElMessage
	} from 'element-plus'
	import qs from 'qs'
	import dayjs from 'dayjs'
	export default {
		data() {
			return {
				rules: {
					prname: [{
						required: true,
						message: '请输入项目名称',
						trigger: 'change'
					}]
				},
				state: 0, //1新增，0点击生成采购订单
				goodsData: [], //商品详情数据
				labelPosition: 'right',
				searchform: {},
				pageNo: 1,
				pageSize: 5,
				total: 0,
				tableData: [],
				xzData: [], //选择完的商品数据
				depts: [],
				users: [],
				order: {},
				form: {
					user: {
						yhId: ''
					},
					cgcode: "",
					gys: {
						supId: ''
					},
					bm: {
						bmId: ''
					},
					explain: '',
					prId: ''
				},
				dialogTableVisible: true,
				ExaminedialogVisible: false,
				spopinion: {
					radio: '1',
					opinion: ""
				},
				sqmessage: {},
				CgdialogVisible: false,
				cgorder: {},
				suppliers: [],
				Spudialog: false,
				filterText: '',
				pageNo: 1,
				pageSize: 5,
				total: 0,
				typeData: [], //用品分类
				spudata: [], //商品数据
				gfId: 0,
				multipleSelection: []
			}
		},
		methods: {
			/*时间格式化 yyyy-mm=dd HH:MM:ss*/
			formatDate: function(value) {
				var date = new Date(value);
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				var day = date.getDate();
				var hours = date.getHours();
				var minutes = date.getMinutes();
				var sec = date.getSeconds()
				if (month < 10) {
					month = "0" + month;
				}
				if (day < 10) {
					day = "0" + day;
				}
				if (hours < 10) {
					hours = '0' + hours;
				}
				if (minutes < 10) {
					minutes = '0' + minutes;
				}
				if (sec < 10) {
					sec = '0' + sec;
				}
				return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + sec;
			},
			add() { //新增
				this.CgdialogVisible = true;
				this.state = 1;
				this.fuzhi();
				this.form.cgcode = 'BJD' + this.getProjectNum() + Math.floor(Math.random() *
					10000) // 如果是6位或者8位随机数，相应的 *1000000或者 *100000000就行了
				console.log("xxx", this.getProjectNum() + Math.floor(Math.random() *
					10000));
			},
			clickData(prid) { //获取商品详情
				this.tableData.forEach(v => {
					if (v.prId == prid) {
						this.goodsData = v.goods;
					}
				})
			},
			changeTotalmoney() {
				let $this = this;
				let totalmoney = 0;
				this.xzData.forEach(v => {
					console.log("ss==============" + (v.gBian) * (v.gPrice))
					totalmoney = totalmoney + ((v.gBian) * (v.gPrice));
					console.log("totalmoney=" + totalmoney);
				})
				this.form.totalmoney = totalmoney;
			},
			hold(formName) { //保存
				this.$refs[formName].validate((valid) => {
					if (valid) {
						let $this = this;
						console.log("this.xzData=", this.xzData);
						if (this.xzData.length == 0) {
							ElMessage.warning({
								message: '请选择商品',
								type: 'warning'
							});
							return;
						}
						let mytime = dayjs(this.form.xqtime).format('YYYY-MM-DD HH:mm:ss');
						let params = {
							ddcode: $this.form.cgcode,
							user: this.form.user,
							gys: this.form.gys,
							bm: this.form.bm,
							tableData: $this.xzData,
							explain: this.form.explain,
							prid: this.form.prId,
							xqtime: mytime,
							state: this.state,
							prname: this.form.prname,
							totalmoney: this.form.totalmoney
						}
						console.log("params=", params);
						if (this.state == 0) { //新增采购订单
							this.axios.post("/study/cgOrder/addorder",
								params
							).then(res => {
								console.log("res=", res)
								if (res.data == 1) {
									this.goodsData = [];
									this.$router.push("/cgorder");
								}
							})
						} else { //新增报价单
							this.axios.post("/study/cgPrice/add",
								params
							).then(res => {
								console.log("res=", res)
								if (res.data == 1) {
									this.CgdialogVisible = false;
									this.search();
									this.goodsData = [];
								}
							})
						}
					} else {
						console.log('error submit!!');
						return false;
					}
				});
			},
			//商品渲染
			cxsousuo() {
				this.gfId = 0;
				this.allgoods();
			},
			handleSelectionChange(val) {
				this.multipleSelection = val;
				console.log("multipleSelection=", this.multipleSelection);
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
				this.changeTotalmoney();
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
			fuzhi() { //赋值操作
				this.form.user.yhId = this.users[0].yhId;
				this.form.gys.supId = this.suppliers[0].supId;
				this.form.bm.bmId = this.depts[0].bmId;
				this.changeTel();
			},
			caigou(prid) { //生成采购单
				let $this = this;
				this.state = 0;
				this.fuzhi();
				this.form.prId = prid;
				$this.form.cgcode = 'CGD' + this.getProjectNum() + Math.floor(Math.random() *
					10000) // 如果是6位或者8位随机数，相应的 *1000000或者 *100000000就行了
				console.log("xxx", this.getProjectNum() + Math.floor(Math.random() *
					10000));
				this.CgdialogVisible = true;
				//给订单对应的商品赋值
				this.tableData.forEach(v => {
					if (v.prId == prid) {
						this.xzData = v.goods;
					}
				})
				this.changeTotalmoney();
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
			},
			changeTel() {
				let $this = this;
				if ($this.suppliers) {
					$this.suppliers.forEach(v => {
						if ($this.form.gys.supId) {
							if (v.supId == $this.form.gys.supId) {
								$this.form.tel = v.jcContactperson.cpTel;
							}
						} else {
							$this.form.tel = ""
						}

					})
				}

			},
			examine(row) { //审批
				let $this = this;
				$this.ExaminedialogVisible = true,
					$this.sqmessage = {
						...row
					};
				console.log("sqmessage", $this.sqmessage);
			},
			OnSubmit(row) { //审批弹框确定
				console.log("row==========", row);
				let params = {
					prid: this.sqmessage.prId,
					applystate: this.spopinion.radio,
					spidea: this.spopinion.opinion
				}
				console.log("审批的数据-----：", params);
				this.axios.post("/study/cgPrice/examine", qs.stringify(params)).then(res => {
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
				$this.searchmessages = {
					xmname: $this.searchform.xmname,
					cgbm: $this.searchform.cgbm,
					jsr: $this.searchform.jsr,
					size: $this.pageSize,
					no: $this.pageNo
				};
				this.axios.post("/study/cgPrice/selectByPager",
					$this.searchmessages
				).then(res => {
					console.log(res, "priceData-------：", res.data);
					$this.tableData = res.data;
					$this.total = res.data.length;
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
				this.axios.post("/supplier/allsup", {}).then(res => {
					console.log(res, "sup：", res.data);
					$this.suppliers = res.data;
				})
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
