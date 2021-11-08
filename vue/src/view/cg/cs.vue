<template>
  <el-row>
    <el-form style="padding-top: 10px">
      <el-col :span="19">
        <el-form-item  label="人员信息:" label-width="100px">
          <el-input class="myin" @input="getData"  v-model="seach" placeholder="请输入你要查询的记录" ></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="5" label-width="220px">
        <el-form-item>
          <el-button type="primary" icon="el-icon-search">查询</el-button>
        </el-form-item>
      </el-col>
    </el-form>

  </el-row>
  <!--=============================================部门表格===================================-->
  <el-row>
    <el-col>
      <el-table :data="bmji.slice((currentPage-1)*pagesize,currentPage*pagesize)" height="450"  tooltip-effect="dark" style="width: 100%;">
        <el-table-column
            label="编号"
            prop="bmId"
        >
        </el-table-column>
        <el-table-column
            prop="bmName"
            label="性别">
        </el-table-column>
        <el-table-column
            label="操作">
          <template #default="scope">
            <el-button size="mini" @click="tjjlEdit(scope.row)" type="primary" plain>查看</el-button>
          </template>
        </el-table-column>

      </el-table>

      <!--分页插件-->
      <el-pagination  @size-change="handleSizeChange" @current-change="handleCurrentChange"
                      style="text-align: center; margin-top: 10px"
                      :current-page="currentPage"
                      :page-sizes="[2,4,6,8]"
                      :page-size="pagesize"
                      layout="total, sizes, prev, pager, next, jumper"
                      :total="bmji.length">
      </el-pagination>
    </el-col>
  </el-row>


  <el-dialog title="填写检查结果" v-model="txjg" width="40%" center  ><!-- 弹窗  新增   -=-=-=-=-=-=-==-=-=-=-=--=-=-=-=-=-=-检查结果填写 -->
    <span v-for="(t,i) in aloneg" >{{t.checkName}}:<el-input  v-model="t.tjCodeIndex"></el-input></span>
    <span style="color: red">医生建议：<el-input v-model="manProposal"  type="textarea"> </el-input></span>
    <el-row>
      <el-col :span="2" :offset="10">
        <el-button type="primary" style="margin-top: 20px" @click="txjgForm">确定</el-button>
      </el-col>
    </el-row>

  </el-dialog>

</template>

<script>
import qs from "qs";

export default {
  data () {
    return {
      bmji:[],
      seach: '',//查询框
      currentPage: 1, //1初始页
      pagesize: 10, //    1每页的数
    }
  },
  methods: {
    // 初始页currentPage、初始每页数据数pagesize和数据data
    handleSizeChange: function (size) {
      this.pagesize = size;
      console.log(this.pagesize) //每页下拉显示数据
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
      console.log(this.currentPage) //点击第几页
    },
    // 体检人员预约参数
    getData() {
      this.axios.get("http://localhost:8095/qxbm", {
        params: {
          seach: this.seach
        }
      }).then((res) => {
        this.bmji = res.data;
      }).catch()
    }
  },created() {
    this.getData()
  },
}
</script>

<style>
<yle>
