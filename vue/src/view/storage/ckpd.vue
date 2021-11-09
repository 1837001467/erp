<template>
<!-- 	<el-row :gutter="20">
		<el-col :span="15">
			</el-col>
		<el-col :span="5">
		</el-col>
		<el-col :span="3">
			<el-button icon="el-icon-circle-plus-outline" @click="add">新增</el-button>
		</el-col>
	</el-row>
	<el-table :data="ckdbs" style="width: 100%;" border :header-cell-style="{'text-align':'center'}"
		:cell-style="{'text-align':'center'}">
		<el-table-column prop="dpBian" label="库存盘点编号" width="160"></el-table-column>
		<el-table-column prop="gId.gName" label="商品名称"></el-table-column>
		<el-table-column prop="dpNum" label="商品数量"></el-table-column>
		<el-table-column prop="whOut.whName" label="所在仓库" ></el-table-column>
		<el-table-column prop="whIn.whName" label="结果"></el-table-column>
		<el-table-column prop="yhShen.yhName" label="申请人" ></el-table-column>
		<el-table-column prop="pdApplicationtime" label="申请时间" width="160"></el-table-column>
		<el-table-column prop="yhPi.yhName" label="审批人" ></el-table-column>
		<el-table-column prop="dpApprovaltime" label="审批时间" width="160"></el-table-column>
		<el-table-column prop="dpState" label="状态" >
			<template #default="scope">
				<p v-if="scope.row.dpState==0">待审核</p>
				<p v-if="scope.row.dpState==1">已确认</p>
			</template>
		</el-table-column>
		<el-table-column label="操作" width="120">
			<template #default="scope">
				<!插槽可以获取当前行对象 scope.row可以获取当前行数据 -->
				<!-- <el-tooltip effect="dark" content="通过" placement="bottom">
					<i class="el-icon-check" @click="update(scope.row,1)" v-show="scope.row.dpState==0"
						style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
				</el-tooltip>
			</template>
		</el-table-column>
	</el-table> -->
	<!-- layout表示布局方式 prev上一页  next下一页 pager页码列表
		 属性 total  总页数
			  page-size 每页条数
			  current-page 当前页码
		 事件
			  current-change 当前页码发生改变的时候触发的事件
			  size-change    每页条数发生改变时触发的事件
	-->
<!-- 	<el-pagination background layout="prev, pager, next,sizes,total" :page-sizes="[2, 5, 10, 15]" :total="total"
		:page-size="pageSize" :current-page="pageNo" @current-change="change" @size-change="change2">
	</el-pagination>
	
	<! 仓库调拨新增 -->
	<!-- 	<el-dialog title="发起仓库调拨请求" v-model="centerDialogVisible" width="40%" center>
			<hr>
			<el-form :model="warehouseallForm" ref="warehouseallForm" label-width="100px">
				<el-form-item label="调出仓库" >
					<el-select clearable v-model="warehouseallForm.wareallOut" style="width: 300px;" @change="cha(warehouseallForm.wareallOut)">
						<el-option :label="i.whName" :value="i.whId" v-for="i in whs"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="调出产品"  >
					<el-select clearable v-model="warehouseallForm.product.proId" style="width: 300px;">
					<el-option @click="zui(index)" :label="i.goods.gName" :value="i.goods.goId" v-for="(i,index)  in products"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="调出数量"  >
					 <el-input-number v-model="warehouseallForm.waredtNum"  :max="max"  :min="num"/>
				</el-form-item>
				<el-form-item label="调入仓库" >
					<el-select clearable v-model="warehouseallForm.wareallIn" style="width: 300px;margin-right: 200px;">
						<el-option :label="i.whName" :value="i.whId" v-for="i in whs"></el-option>
					</el-select>
				</el-form-item>
			</el-form>
			<template #footer>
				<span class="dialog-footer">
					<el-button type="primary" @click="sure(),centerDialogVisible = false">确 定</el-button>
					<el-button @click="quxiao">重 置</el-button>
				</span>
			</template>
		</el-dialog> -->

</template>

<script>
// export default {
// 	data() {
// 			return {
// 				ckdbs: [],
// 				pageNo: 1,
// 				pageSize: 5,
// 				centerDialogVisible:false,
// 				total: 0,
// 				whs:[],
// 				dialogTableVisible: false,
// 				goods: [],
// 				max:1,
// 				num:1,
// 				products:[],
// 				sqr: {
// 					yhName: '',
// 					rkApplicationtime: '',
// 				},
// 				warehouseallForm: {
// 					wareallIn: 2,
// 					wareallOut: 1,
// 					waredtNum:1,
// 					product:{
// 						proId:1,
// 					},
// 				},
// 			}
// 		},
// 		methods: {
// 			loadData() {
// 				this.axios.get("/dpAllocation/pager", {
// 						parms: {
// 							no: this.pageNo,
// 							size: this.pageSize,
// 						}
// 					})
// 					.then(res => {
// 						if (res.status == 200) {
// 							//后台返回的是PageInfo对象，当前分页数据存储在list中
// 							this.ckdbs = res.data.list;
// 							this.total = res.data.total;
// 						}
// 					})
// 				this.axios.get("/JcWhinformation/selectAll")
// 					.then(res => {
// 						if (res.status == 200) {
// 							this.whs = res.data;
// 							this.cha(this.warehouseallForm.wareallOut)
// 						}
// 					})
// 			},
// 			zui(i){
// 				console.log(i)
// 				this.max=this.products[i].ccNum;
// 				console.log(this.max)
// 			},
// 			sure(){
// 				this.axios.get("/dpAllocation/add",{
// 					params:{
// 						outhouse:this.warehouseallForm.wareallOut,
// 						inhouse:this.warehouseallForm.wareallIn,
// 						num:this.num,
// 						gid:this.warehouseallForm.product.proId,
// 						yhid:1,
// 					}
// 				}).then(res =>{
// 					if(res.status==200){
// 						this.loadData();
// 						this.$message.success({
// 							message: '新增成功'
// 						});
// 					}
// 				})
// 			},
// 			add(){
// 				this.centerDialogVisible =true;
// 			},
// 			update(row,num) {
// 				this.axios.get("/dpAllocation/updateState", {
// 						params: {
// 							dpBian: row.dpBian,
// 							rkState:parseInt(num),
// 							yhId:1,
// 						}
// 					})
// 					.then(res => {
// 						if (res.status == 200) {
// 							this.loadData();
// 							this.$message.success({
// 								message: '已修改状态'
// 							});
// 						}
// 					})
// 			},
// 			cha(id){
// 			this.axios.get("dpAllocation/stock",{
// 				params:{
// 					out:id
// 				}
// 			})
// 				.then(res => {
// 					if (res.status == 200) {
// 						this.products = res.data;
// 						console.log(this.products)
// 					}
// 				})	
// 			},
// 			change(pageNo) {
// 				//参数表示待跳转的页码
// 				this.pageNo = pageNo;
// 				this.loadData();
// 			},
// 			change2(pageSize) {
// 				/* 参数表示每页条数 */
// 				this.pageNo = 1;
// 				this.pageSize = pageSize;
// 				this.loadData()
// 			},
// 		},
// 		created() {
// 			this.loadData();
// 		}
// }
</script>

<style scoped>

</style>