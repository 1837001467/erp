<template>
<div>
		<el-row>
			<el-form :label-position="labelPosition" label-width="120px">
				<el-form-item label="供应商名称查询:" size="medium" style="float: left;margin-right: 10px;">
					<el-input placeholder="请输入" v-model="searchform.selectAll" clearable style="width: 120px;">
					</el-input>
				</el-form-item>
				<el-button @click="search()">查询</el-button>
				<el-button @click="add()">新增</el-button>
			</el-form>
		</el-row>

		<div>
			<el-table :data="tableData" :span-method="objectSpanMethod" border style="width: 100%"
				:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}">
				<el-table-column type="supId" label="供应商序号" width="80px">
				</el-table-column>
				<el-table-column prop="cpId" label="联系人序号">
				</el-table-column>	
				<el-table-column prop="supName" label="供应商名字">
				</el-table-column>
				<el-table-column prop="supTel" label="联系电话">
				</el-table-column>
				<el-table-column prop="supBian" label="编号">
				</el-table-column>
				<el-table-column label="操作" width="200px">
					<template #default="scope">
						<el-button @click="edit()">编辑</el-button>
					</template>
				</el-table-column>
			</el-table>
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
			delete(){
				
			},
			search() {
				let $this = this;
				$this.searchmessages = {
					selectAll: $this.searchform.selectAll,
					size: $this.pageSize,
					no: $this.pageNo
				};
				this.axios.post("/supplier/pager/selectAll",
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
