<template>

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
							console.log(res.data)
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
</script>

<style scoped>

</style>