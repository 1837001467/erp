<template>
	<div style="height: 80%;">
		<el-table :data="tableData" style="width: 100%" #default="scope" :customRow="loadDate(xxx)">
			<el-table-column prop="receiptYary" label="记账编号">
			</el-table-column>
			<el-table-column prop="orderYard" label="收款单编号">
			</el-table-column>
			<el-table-column prop="khName" label="付款方">
			</el-table-column>
			<el-table-column prop="receiptMoney" label="金额">
			</el-table-column>
			<el-table-column prop="receiptAcount" label="负责人">
			</el-table-column>
			<el-table-column prop="receiptTime" label="到账时间">
			</el-table-column>
			<el-table-column prop="receiptState" label="状态">
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
			loadBill(){
				let $this = this;
				this.axios.get("/study/xsReceipt").then(res => {
					console.log("xxx:", res.data)
					$this.tableData = res.data
				})
			},
			loadDate(row){
				console.log("数据：",row)
			}
		},
		mounted() {
			this.loadBill();
		}
	}
</script>

<style scoped="scoped">

</style>
