<template>
	<div>
		<el-row>
			<el-form :label-position="labelPosition" label-width="80px">
				<el-form-item label="订单编号:" size="medium" style="float: left;margin-right: 50px;">
					<el-input placeholder="请输入" v-model="searchform.ordercode" clearable style="width: 120px;">
					</el-input>
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
				<el-table-column prop="orCode" label="订单编码">
				</el-table-column>
				<el-table-column prop="orTime" label="制单日期">
				</el-table-column>
				<el-table-column prop="jcSupplier.supName" label="供应商">
				</el-table-column>
				<el-table-column prop="qxUser.yhName" label="经手人">
				</el-table-column>
				<el-table-column prop="qxUser.yhPhone" label="联系电话">
				</el-table-column>
				<el-table-column prop="qxUser.yhName" label="审批人">
				</el-table-column>
				<el-table-column label="执行">
					<template #default="scope">
						<el-button @click="ruku()">生成入库单</el-button>
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
				order: {},
				form: {},
				dialogTableVisible: true,
			}
		},
		methods: {
			add(){
				
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
			ruku(){
				
			},
			search() {
				let $this = this;
				$this.searchmessages = {
					ordercode: $this.searchform.ordercode,
					size: $this.pageSize,
					no: $this.pageNo
				};
				this.axios.post("/study/cgOrder/selectByPager",
					$this.searchmessages
				).then(res => {
					console.log("carData-------：", res.data.list);
					$this.tableData = res.data.list;
					console.log("res.data.list.size=",res.data.list.length);
					$this.total = res.data.list.length;
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
