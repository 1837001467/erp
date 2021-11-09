<template>
	<el-row :gutter="20">
		<el-col :span="15">
			</el-col>
		<el-col :span="5">
			<el-input  placeholder="请输入内容" v-model="seach" clearable style="width: 150px;">
				</el-input>
			<el-button icon="el-icon-search" circle @click="loadData()"></el-button>
		</el-col>
	</el-row>
	<el-table :data="stocks" style="width: 100%;" border :header-cell-style="{'text-align':'center'}"
		:cell-style="{'text-align':'center'}">
		<el-table-column prop="kcBian" label="库存变动编号"></el-table-column>
		<el-table-column prop="kcType" label="库存变动类型"></el-table-column>
		<el-table-column prop="goods.gName" label="变动商品"></el-table-column>
		<el-table-column prop="kcNum" label="变动数量" ></el-table-column>
		<el-table-column prop="wh.whName" label="变动仓库"></el-table-column>
		<el-table-column prop="kcTime" label="变动时间" ></el-table-column>
		<el-table-column prop="user.yhName" label="负责人"></el-table-column>
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
				stocks:[],
				total:0,
				pageSize:5,
				pageNo:1,
				seach:''
			}
		},
		methods: {
			loadData() {
				this.axios.get("/kcStock/pager", {
						params: {
							no: this.pageNo,
							size: this.pageSize,
							kcBian:this.seach
						}
					})
					.then(res => {
						if (res.status == 200) {
							//后台返回的是PageInfo对象，当前分页数据存储在list中
<<<<<<< HEAD
=======
							console.log(res.data)
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
							this.stocks = res.data.list;
							this.total = res.data.total;
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
			}
		},
		created() {
			this.loadData();
		}
}
</script>

<style scoped>

</style>