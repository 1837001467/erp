<template>
  <el-row>
    <el-form style="padding-top: 10px">
      <el-col :span="19">
        <el-form-item  label="人员信息:" label-width="100px">
          <el-input class="myin" @input="getData"  v-model="seach" placeholder="请输入你要查询的人员" ></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="5" label-width="220px">
        <el-form-item>
          <el-button type="primary" icon="el-icon-search">查询</el-button>
        </el-form-item>
      </el-col>
    </el-form>

  </el-row>
  <!--=============================================员工表格===================================-->
  <el-row>
    <el-col>
      <el-table :data="ygji.slice((currentPage-1)*pagesize,currentPage*pagesize)" height="450"  tooltip-effect="dark" style="width: 100%;">
        <el-table-column
            label="账号"
            prop="yhCard"
        >
        </el-table-column>
        <el-table-column
            prop="yhName"
            label="姓名">
        </el-table-column>
        <el-table-column
            prop="yhPhone"
            label="手机号">
        </el-table-column>
        <el-table-column
            prop="yhState"
            label="状态">
          <template #default="scope">
            <div class="name-wrapper">
              <el-tag :type="scope.row.yhState==0?'success':'warning'" size="medium">{{ scope.row.yhState==0?'在职':'离职' }}</el-tag>
            </div>
          </template>
        </el-table-column>
        <el-table-column
            label="操作">
          <template #default="scope">
            <el-button size="mini" @click="tjjlEdit(scope.row)" type="primary" plain>修改</el-button>
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
                      :total="ygji.length">
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
      ygji:[],
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
      this.axios.get("http://localhost:8095/user", {
        params: {
          seach: this.seach
        }
      }).then((res) => {
        this.ygji = res.data;
      }).catch()
    }
  },
  computed:{
    //获取当前时间
    getNowFormatDate() {
      var date = new Date();
      var seperator1 = "-";
      var seperator2 = ":";
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var strDate = date.getDate();
      if (month >= 1 && month <= 9) {
        month = "0" + month;
      }
      if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
      }
      let hh = new Date().getHours();
      let mf = new Date().getMinutes()<10 ? '0'+new Date().getMinutes() : new Date().getMinutes();
      let ss = new Date().getSeconds()<10 ? '0'+new Date().getSeconds() : new Date().getSeconds();
      var currentdate = year + seperator1 + month + seperator1 + strDate+' '+ +hh+seperator2+mf+seperator2+ss;
      return currentdate;
    }
  },created() {
    this.getData()
  },
}
</script>

<style>
</style>
