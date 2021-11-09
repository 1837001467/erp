<template>
	<el-row :gutter="20">
		<el-col :span="3">
			<el-button icon="el-icon-circle-plus-outline" @click="add">新增</el-button>
		</el-col>
	</el-row>
	<el-table :data="zclys" style="width: 100%;" border :header-cell-style="{'text-align':'center'}"
		:cell-style="{'text-align':'center'}">
		<el-table-column prop="zcBian" label="领用编号"></el-table-column>
		<el-table-column prop="yh.yhName" label="领用人"></el-table-column>
		<el-table-column prop="bm.bmName" label="领用部门"></el-table-column>
		<el-table-column prop="zcApplicationtime" label="申请时间" width="150"></el-table-column>
		<el-table-column prop="wh.whName" label="出货仓库"></el-table-column>
		<el-table-column prop="zcText" label="领用说明" show-overflow-tooltip></el-table-column>
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
					<i class="el-icon-document" @click="look(scope.row)"
						style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
				</el-tooltip>
				<el-tooltip effect="dark" content="通过" placement="bottom">
					<i class="el-icon-check" @click="adopt(scope.row)"
						v-show="scope.row.zcState==0" style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
				</el-tooltip>
				<el-tooltip effect="dark" content="归还" placement="bottom">
					<i class="el-icon-check" @click="update(scope.row)"
						v-show="scope.row.zcState==1" style="font-size: 18px;cursor: pointer;margin-right: 25px;"></i>
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
	<el-dialog title="领用详情" v-model="dialogTableVisible">
		<el-descriptions>
			<el-descriptions-item label="申请人">{{sqr.yhName}}</el-descriptions-item>
			<el-descriptions-item label="申请时间">{{sqr.zcApplicationtime}}</el-descriptions-item>
		</el-descriptions>
		<el-table :data="goods">
			<el-table-column property="goods.gName" label="商品名" width="200"></el-table-column>
			<el-table-column property="lyNum" label="领取数量" width="150"></el-table-column>
		</el-table>
	</el-dialog>
	<el-dialog title="领用申请表" v-model="dialogFormVisible">
		<el-form :model="form">
			<el-form-item label="申请人" :label-width="formLabelWidth">
				<el-select v-model="form.user.yhId" placeholder="请选择申请人">
					<el-option :label="i.yhName" :value="i.yhId" v-for="i in users"
						@click="linkage(i.ybm.bm.bmName,i.ybm.bm.bmId)"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="所属部门" :label-width="formLabelWidth">
				<el-input v-model="form.bm.bmName" autocomplete="off" style="width: 120px;" readonly></el-input>
			</el-form-item>
			<el-form-item label="出货仓" :label-width="formLabelWidth">
				<el-select v-model="form.cangku.whId" placeholder="请选择出货仓">
					<el-option :label="i.whName" :value="i.whId" v-for="i in Warehouses"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="商品名" :label-width="formLabelWidth">
				<el-select v-model="form.commodity.goId" placeholder="请选择商品">
					<el-option :label="i.gName" :value="i.goId" v-for="i in commoditys"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="数量" :label-width="formLabelWidth">
				  <el-input-number
				    v-model="form.lyNum"
				    :min="1"
				  ></el-input-number>
			</el-form-item>
			<el-form-item label="申请说明" :label-width="formLabelWidth">
				<el-input v-model="form.zcText" autocomplete="off" style="width: 200px;"></el-input>
			</el-form-item>
		</el-form>
		<template #footer>
			<span class="dialog-footer">
				<el-button @click="cancel()">取 消</el-button>
				<el-button type="primary" @click="sure()">确 定</el-button>
			</span>
		</template>
	</el-dialog>
</template>

<script>
	export default {
		data() {
			return {
				zclys: [],
				formLabelWidth: '120px',
				pageNo: 1,
				pageSize: 5,
				total: 0,
				dialogTableVisible: false,
				dialogFormVisible: false,
				goods: [],
				users: [],
				Warehouses:[],
				commoditys: [],
				sqr: {
					yhName: '',
					zcApplicationtime: '',
				},
				form: {
					user:{
						yhId:''
					},
					lyNum:1,
					zcText:'',
					bm: {
						bmId: '',
						bmName: '',
					},
					cangku:{
						whId:'',
						whName:'',
					},
					commodity:{
						goId:'',
						gName:''
					}
				}
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
							this.zclys = res.data.list;
							this.total = res.data.total;
						}
					})
			},
			look(row) {
				this.sqr.yhName = row.yh.yhName;
				this.sqr.zcApplicationtime = row.zcApplicationtime;
				this.axios.get("/zcClaim/look", {
						params: {
							zcId: row.zcId,
						}
					})
					.then(res => {
						if (res.status == 200) {
							console.log(res.data)
							this.dialogTableVisible = true;
							this.goods = res.data;
						}
					})
			},
			cancel(){
				this.dialogFormVisible=false;
			},
			adopt(row){
				this.axios.get("/kcStock/adopt", {
						params: {
							zcId: row.zcId,
							yuId:1,
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
			sure(){
				console.log(this.form)
				this.axios.post("/zcClaim/add",this.form)
				.then(res =>{
					if (res.status == 200) {
						this.cancel();
						this.loadData();
						this.$message.success({
							message: '添加成功'
						});
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
			linkage(bmName, bmId) {
				this.form.bm.bmName = bmName;
				this.form.bm.bmId = bmId;
			},
			add() {
				this.dialogFormVisible = true;
				this.axios.get("/user")
					.then(res => {
						if (res.status == 200) {
							this.users = res.data;
						}
					})
				this.axios.get("/JcWhinformation/selectAll")
					.then(res => {
						if (res.status == 200) {
							this.Warehouses = res.data;
						}
					})	
				this.axios.get("/own")
					.then(res => {
						if (res.status == 200) {
							this.commoditys = res.data;
						}
					})	
			}
		},
		created() {
			this.loadData();
		}
	}
</script>

<style scoped>

</style>
