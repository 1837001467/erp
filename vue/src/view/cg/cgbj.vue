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
						<el-option v-for="ct in depts" :label="ct.bm_name" :value="ct.bm_id" :key="ct.bm_id">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="经手人:" size="medium" style="float: left;margin-right: 50px;">
					<el-select v-model="searchform.cgbm" clearable>
						<el-option v-for="ct in users" :label="ct.yh_name" :value="ct.yh_id" :key="ct.yh_id">
						</el-option>
					</el-select>
				</el-form-item>
				<el-button @click="search()">查询</el-button>
				<el-button @click="add()">新增</el-button>
			</el-form>
		</el-row>

		<div>
			<el-table :data="tableData" :span-method="objectSpanMethod" border style="width: 100%"
				:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}">
				<el-table-column type="index" label="序号" width="80px">
				</el-table-column>
				<el-table-column prop="prCode" label="订单编码">
				</el-table-column>
				<el-table-column prop="prName" label="项目名称">
				</el-table-column>
				<el-table-column prop="qxDepartment.bmName" label="采购部门">
				</el-table-column>
				<el-table-column prop="prZdtime" label="制单日期">
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
						<el-tag size="medium" type="warning" v-show="scope.row.prState==3">已驳回</el-tag>
					</template>
				</el-table-column>
				<el-table-column label="执行">
					<template #default="scope">
						<el-button type="success" plain @click="caigou()" :disabled="scope.row.prState==1?false:true"
							v-show="scope.row.prState==1">
							生成采购单</el-button>
						<el-button type="primary" plain @click="examine(scope.row)"
							:disabled="scope.row.prState==0?false:true" v-show="scope.row.prState==0">审核
						</el-button>
					</template>
				</el-table-column>
				<el-table-column label="操作" width="200px">
					<template #default="scope">
						<el-button @click="edit()">编辑</el-button>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageNo"
				:page-sizes="[2, 5, 10, 15]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper"
				:total="total">
			</el-pagination>
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
				labelPosition: 'right',
				searchform: {},
				pageNo: 1,
				pageSize: 5,
				total: 0,
				tableData: [],
				depts: [],
				users: [],
				order: {},
				form: {},
				dialogTableVisible: true,
				ExaminedialogVisible: false,
				spopinion: {
					radio: '1',
					opinion: ""
				}
			}
		},
		methods: {
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
					prid: this.sqmessage.pr_id,
					applystate: this.spopinion.radio,
					spidea: this.spopinion.opinion
				}
				console.log("审批的数据-----：", params);
				// this.axios.post("study/carapply/carapplysp", params).then(res => {
				// 	console.log("res结果：", res);
				// 	this.ExaminedialogVisible = false;
				// 	this.spopinion.opinion = "";
				// 	this.searchByKeyword();
				// 	//子组件向父容器传递信息，能够触发父组件的事件
				// 	this.$emit("send", true);
				// })
			},
			qxExamine() { //取消审批
				this.ExaminedialogVisible = false;
				this.spopinion.radio = "1";
				this.spopinion.opinion = "";
			},
			shenhe() {

			},
			add() {

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
			caigou() {

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
			}
		},
		created() {
			this.search();
		}
	}
</script>

<style scoped="scoped">


</style>
