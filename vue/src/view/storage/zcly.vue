<template>

	<el-table :data="zclys" style="width: 100%;" border :header-cell-style="{'text-align':'center'}"
		:cell-style="{'text-align':'center'}">
		<el-table-column prop="zcBian" label="领用编号"></el-table-column>
		<el-table-column prop="yh.yhName" label="领用人"></el-table-column>
		<el-table-column prop="bm.bmName" label="领用部门"></el-table-column>
		<el-table-column prop="zcApplicationtime" label="申请时间" width="150"></el-table-column>
		<el-table-column prop="wh.whName" label="出货仓库"></el-table-column>
		<el-table-column prop="zc.Text" label="领用说明"></el-table-column>
		<el-table-column prop="shen.yhName" label="审批人"></el-table-column>
		<el-table-column prop="zcApprovaltime" label="审批时间" width="150"></el-table-column>
		<el-table-column prop="zcState" label="状态">
			<template #default="scope">
				<p v-if="scope.row.zcState==0">待审核</p>
				<p v-if="scope.row.zcState==1">待归还</p>
				<p v-if="scope.row.zcState==2">已归还</p>
			</template>
		</el-table-column>
		<el-table-column label="操作" align="center">
			<template #default="scope" v>
				<!-- 插槽可以获取当前行对象 scope.row可以获取当前行数据 -->
				<el-tooltip effect="dark" content="查看" placement="bottom">
					<i class="el-icon-document" @click="look(scope.row.zcId)" style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
				</el-tooltip>
				<el-tooltip effect="dark" content="通过" placement="bottom">
					<i class="el-icon-check" @click="update(scope.row),dialogFormVisible = true"  v-show="scope.row.zcState==0" style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
				</el-tooltip>
				<el-tooltip effect="dark" content="归还" placement="bottom">
					<i class="el-icon-check" @click="update(scope.row),dialogFormVisible = true"  v-show="scope.row.zcState==1" style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
				</el-tooltip>
			</template>
		</el-table-column>
	</el-table>
	<!-- layout表示布局方式 prev上一页  next下一页 pager页码列表
		 属性 total  总页数
			  page-size 每页条数
			  current-page 当前页码
		 事件
			  current-change 当前页码发生改变的时候触发的事件
			  size-change    每页条数发生改变时触发的事件
	-->
	<el-pagination background layout="prev, pager, next,sizes,total" :page-sizes="[2, 5, 10, 15]" :total="total"
		:page-size="pageSize" :current-page="pageNo" @current-change="change" @size-change="change2">
	</el-pagination>
</template>

<script>
	export default {
		data() {
			return {
				zclys: [],
				pageNo: 1,
				pageSize: 5,
				total: 0
			}
		},
		methods: {
			loadData() {
				this.axios.get("/zcClaim/pager", {
						params: {
							no: this.pageNo,
							size: this.pageSize,
						}
					})
					.then(res => {
						if (res.status == 200) {
							//后台返回的是PageInfo对象，当前分页数据存储在list中
							console.log(res.data)
							this.zclys = res.data.list;
							this.total = res.data.total;
						}
					})
			},
			look(id){
				this.axios.get("/zcClaim/look", {
						params: {
							zcId: row.zcId,
						}
					})
					.then(res => {
						if (res.status == 200) {

						}
					})
			},
			update(row) {
				this.axios.get("/zcClaim/update", {
						params: {
							zcId: row.zcId,
							zcState: (row.zcState + 1)
						}
					})
					.then(res => {
						if (res.status == 200) {
							this.loadData();
							this.$message.success({
								message: '已修改状态'
							});
						}
					})
			},
			change(pageNo) {
				//参数表示待跳转的页码
				this.pageNo = pageNo;
				this.loadData();
			},
			change2(pageSize) {
				/* 参数表示每页条数 */
				this.pageNo = 1;
				this.pageSize = pageSize;
				this.loadData()
			},
		},
		created() {
			this.loadData();
		}
	}
</script>

<style scoped>

</style>
