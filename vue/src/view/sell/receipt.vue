<template>
<<<<<<< HEAD
	<div>
		<el-table :data="tableData" style="width: 100%">
			<el-table-column label="操作" #default="scope">
				<el-button @click="updateProceeds(scope.row)" v-if="scope.row.proceedsState=='已申请'">审核</el-button>
			</el-table-column>
			<el-table-column prop="proceedsYard" label="订单编号">
			</el-table-column>
			<el-table-column prop="salesId" label="收款单编号">
			</el-table-column>
			<el-table-column prop="khId" label="客户">
			</el-table-column>
			<el-table-column prop="khId" label="联系人">
			</el-table-column>
			<el-table-column prop="orderMoney" label="金额">
			</el-table-column>
			<el-table-column prop="yhId" label="申请人">
			</el-table-column>
			<el-table-column prop="proceedsTime" label="申请时间">
			</el-table-column>
			<el-table-column prop="qxYhId" label="审核人">
			</el-table-column>
=======
	<div style="height: 80%;">
		<el-table :data="tableData" style="width: 100%" #default="scope" :customRow="loadDate(xxx)">
			<el-table-column label="操作" #default="scope">
				<el-button @click="updateProceeds(scope.row)" v-if="scope.row.proceedsState=='已申请'">审核</el-button>
			</el-table-column>
			<el-table-column prop="orderYard" label="订单编号">
			</el-table-column>
			<el-table-column prop="proceedsYard" label="收款单编号">
			</el-table-column>
			<el-table-column prop="proceedsName" label="客户">
			</el-table-column>
			<el-table-column prop="proceedsName" label="联系人">
			</el-table-column>
			<el-table-column prop="proceedsMoney" label="金额">
			</el-table-column>
			<el-table-column prop="yonghuName" label="申请人">
			</el-table-column>
			<el-table-column prop="proceedsTime" label="申请时间">
			</el-table-column>
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
			<el-table-column prop="proceedsTimes" label="审核时间">
			</el-table-column>
			<el-table-column prop="proceedsState" label="订单状态">
			</el-table-column>
		</el-table>
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
				tableData:[],
			}
		},
		methods: {
			loadProceeds(){
				let $this = this;
				this.axios.get("/study/xsProceeds").then(res => {
					console.log("xxx:", res.data)
					$this.tableData = res.data
				})
			},
			updateProceeds(row){
				console.log("ddxq:",row)
				this.axios.post("/study/xsProceeds/update",{
					proceedsId:row.proceedsId,
					proceedsState:row.proceedsState,
					qxYhId:'',
<<<<<<< HEAD
				}).then(res =>{
					
				})
=======
					salesId:row.salesId,
					yhId:row.yhId,
					khId:row.khId,
					proceedsMoney:row.proceedsMoney,
				}).then(res =>{
					this.loadProceeds();
				})
			},
			loadDate(row){
				console.log("数据：",row)
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
			}
		},
		mounted() {
			this.loadProceeds();
		}
	}
</script>

<style scoped="scoped">

</style>
