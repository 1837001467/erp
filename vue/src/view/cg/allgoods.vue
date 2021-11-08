<template>
	<div>
		<el-button @click="sure()" style="width: 100px;height: 30px;">确定</el-button>
	</div>
	<el-container>
		<div style="width: 180px;padding: 10px;" @click="cxsousuo()">
			<el-input placeholder="输入关键字搜索" v-model="filterText">
			</el-input>
			<el-tree class="filter-tree" :data="typeData" :props="defaultProps" highlight-current
				:filter-node-method="filterNode" ref="tree" @node-click="clickNode" default-expand-all="true">
			</el-tree>
		</div>
		<el-container style="padding-top: 10px;">			
			<el-table ref="multipleTable" :data="spudata" style="width: 100%"
				:header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}" row-key="spuid"
				:tree-props="{children: 'children', hasChildren: 'hasChildren'}"
				@selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55">
				</el-table-column>
				<el-table-column type="index" label="序号">
				</el-table-column>
				<el-table-column prop="gName" label="用品名称">
				</el-table-column>
				<el-table-column prop="gUnit" label="单位">
				</el-table-column>
				<el-table-column prop="gPrice" label="单价(元)">
				</el-table-column>
			</el-table>
		</el-container>
	</el-container>
</template>

<script>
	import {
		ElMessage
	} from 'element-plus'
	import qs from 'qs'
	export default {
		data() {
			return {
				filterText: '',
				pageNo: 1,
				pageSize: 5,
				total: 0,
				typeData: [], //用品分类
				spudata: [],
				gfId: 0,
				multipleSelection:[]
			}
		},
		watch: {
			filterText(val) {
				this.$refs.tree.filter(val);
			}
		},
		methods: {
			cxsousuo() {
				this.gfId = 0;
				this.allgoods();
			},
			handleSelectionChange(val) {
				this.multipleSelection = val;
				console.log("multipleSelection=",this.multipleSelection)
			},
			sure() { //确定
				//this.multipleSelection
			},
			filterNode(value, data) {
				if (!value) return true;
				return data.label.indexOf(value) !== -1;
			},
			clickNode(data, node) {
				console.log(data, "获取到的tree数据：", data.id, node.parent.data.id);
				if (data.id) {
					this.gfId = data.id;
				} else {
					this.gfId = 0;
				}
				console.log("this.gfId=" + this.gfId);
				this.allgoods();
			},
			loadSpuType() { //公告分类数据
				let $this = this;
				this.axios.post("/alltype")
					.then(res => {
						console.log("sputypes：", res);
						let spu = {
							id: 0,
							label: '商品分类',
							children: []
						}
						res.data.forEach((v, i) => {
							let pos = {
								id: v.gfId,
								label: v.gfName,
							}
							spu.children.push(pos);
						})
						$this.typeData.push(spu);
						console.log("typeData=", this.typeData);
					})
			},
			allgoods() {
				let $this = this;
				let search = {
					gfId: $this.gfId
				};
				this.axios.post("/getByType",
					qs.stringify(search)
				).then(res => {
					console.log("res=", res)
					$this.spudata = res.data;
				})
			}
		},
		created() {
			this.loadSpuType();
			this.allgoods();
		}
	}
</script>

<style>
</style>
