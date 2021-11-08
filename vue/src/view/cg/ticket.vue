<template>
	<el-table ref="multipleTable" :data="yfData" style="width: 100%" :header-cell-style="{'text-align':'center'}"
		:cell-style="{'text-align':'center'}" row-key="spuid"
		:tree-props="{children: 'children', hasChildren: 'hasChildren'}">
		<el-table-column prop="tiId" label="ID">
		</el-table-column>
		<el-table-column prop="cgYinpay.yiAccount" label="付款账户">
		</el-table-column>
		<el-table-column prop="tiTime" label="制单时间" width="180px">
		</el-table-column>
		<el-table-column prop="cgYinpay.yiWay" label="付款方式">
		</el-table-column>
		<el-table-column prop="cgYinpay.yiType" label="付款类型">
		</el-table-column>
		<el-table-column prop="cgYinpay.yiPrice" label="总额">
		</el-table-column>
		<el-table-column label="状态">
			<template #default="scope">
				<el-tag size="medium" type="success" v-show="scope.row.tiState==0">正常</el-tag>
				<el-tag size="medium" type="danger" v-show="scope.row.tiState==1">停用</el-tag>
			</template>
		</el-table-column>
		<el-table-column label="操作" width="200px">
			<template #default="scope">
				<el-button @click="delticket(scope.row)"
					v-show="scope.row.tiState==0" type="danger" plain>删除</el-button>
					<el-button @click="delticket(scope.row)"
						v-show="scope.row.tiState==1" type="success" plain>启用</el-button>
			</template>
		</el-table-column>
	</el-table>
	<!--分页插件-->
	<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
		style="text-align: center; margin-top: 10px" :current-page="currentPage" :page-sizes="[2,4,6,8]"
		:page-size="pagesize" layout="total, sizes, prev, pager, next, jumper" :total="yfData.length">
	</el-pagination>

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
				currentPage: 1, //1初始页
				pagesize: 10 //1每页的数
			}
		},
		methods: {
			delticket(row){
				let $this=this;
				let params={
					tiid:row.tiId,
					tistate:row.tiState
				}
				this.axios.post("/cgTicket/delticket",qs.stringify(params)).then(res => {
					console.log("res=", res)
					this.allData();
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
			allData() {
				let $this = this;
				this.axios.get("/cgTicket/all").then(res => {
					console.log("res=", res)
					$this.yfData = res.data;
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
