<template>
	<el-table ref="multipleTable" :data="yfData" style="width: 100%" :header-cell-style="{'text-align':'center'}"
		:cell-style="{'text-align':'center'}" row-key="spuid"
		:tree-props="{children: 'children', hasChildren: 'hasChildren'}">
		<el-table-column prop="yiId" label="ID">
		</el-table-column>
		<el-table-column prop="yiAccount" label="付款账户">
		</el-table-column>
		<el-table-column prop="yiTime" label="制单时间" width="180px">
		</el-table-column>
		<el-table-column prop="yiWay" label="付款方式">
		</el-table-column>
		<el-table-column prop="yiType" label="付款类型">
		</el-table-column>
		<el-table-column prop="yiPrice" label="总额">
		</el-table-column>
		<el-table-column label="状态">
			<template #default="scope">
				<el-tag size="medium" type="danger" v-show="scope.row.yiState==0">待付款</el-tag>
				<el-tag size="medium" type="success" v-show="scope.row.yiState==1">已付款</el-tag>
			</template>
		</el-table-column>
		<el-table-column label="操作" width="200px">
			<template #default="scope">
				<el-button @click="fk(scope.row)" :disabled="scope.row.yiState==0?false:true"
					v-show="scope.row.yiState==0">付款</el-button>
			</template>
		</el-table-column>
	</el-table>
	<!--分页插件-->
	<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
		style="text-align: center; margin-top: 10px" :current-page="currentPage" :page-sizes="[2,4,6,8]"
		:page-size="pagesize" layout="total, sizes, prev, pager, next, jumper" :total="yfData.length">
	</el-pagination>
	<el-dialog v-model="fkDialog" :close-on-click-modal="false">
		<el-form>
			<el-form-item label="付款类型" prop="cgbm">
				<el-select v-model="form.way" style="width: 60%;">
					<el-option v-for="ct in ways" :label="ct" :value="ct" :key="ct">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="付款方式" prop="cgbm">
				<el-select v-model="form.type" style="width: 60%;">
					<el-option v-for="ct in types" :label="ct" :value="ct" :key="ct">
					</el-option>
				</el-select>
			</el-form-item>
			<div style="margin: 0 auto;">
				<el-button @click="sure" >确定</el-button>
			</div>

		</el-form>
	</el-dialog>

</template>

<script>
	import {
		ElMessage
	} from 'element-plus'
	import qs from 'qs'
	export default {
		data() {
			return {
				form: {},
				yfData: [],
				types: ["预付款", "应付款"],
				ways: ["现金", "储值卡扣除", "快递代收", "工行转账", "农行转账"],
				fkDialog: false,
				currentPage: 1, //1初始页
				pagesize: 10 //    1每页的数
			}
		},
		methods: {
			// 初始页currentPage、初始每页数据数pagesize和数据data
			handleSizeChange: function(size) {
				this.pagesize = size;
				console.log(this.pagesize) //每页下拉显示数据
			},
			handleCurrentChange: function(currentPage) {
				this.currentPage = currentPage;
				console.log(this.currentPage) //点击第几页
			},
			allData() {
				let $this = this;
				this.axios.get("/yinpay/all").then(res => {
					console.log("res=", res)
					$this.yfData = res.data;
				})
			},
			fk(row) { //付款
				console.log("row=", row);
				this.fkDialog = false;
				this.form.way=this.ways[0];
				this.form.type=this.types[0];
				this.form.yiid=row.yiId;
			},
			sure() { //付款确定按钮
				let params = {
					yiid:this.form.yiid,
					way: this.form.way,
					fktype: this.form.type
				}
				this.axios.post("/yinpay/fukuan", qs.stringify(params)).then(res => {
					console.log("res=", res)
				})
			}
		},
		created() {
			this.allData();
		}
	}
</script>

<style>
</style>
