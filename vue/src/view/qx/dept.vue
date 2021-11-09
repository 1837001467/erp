<template>
  <el-row>
    <el-form style="padding-top: 10px">
      <el-col :span="19">
        <el-form-item  label="部门信息:" label-width="100px">
<<<<<<< HEAD
          <el-input class="myin" @input="getData"  v-model="seach" placeholder="请输入你要查询的记录" ></el-input>
=======
          <el-input class="myin" @input="getData"  v-model="seach" placeholder="请输入你要查询的部门" ></el-input>
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        </el-form-item>
      </el-col>
      <el-col :span="5" label-width="220px">
        <el-form-item>
          <el-button type="primary" icon="el-icon-search">查询</el-button>
        </el-form-item>
      </el-col>
      <el-col :span="5"  label-width="900px">
        <el-form-item>
          <el-button  style="margin-left: 500px" @click="bmEdit" type="primary">新增</el-button>
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
            label="部门">
        </el-table-column>
        <el-table-column
            label="操作">
          <template #default="scope">
            <el-button size="mini" @click="bmEdit(scope.row,1)" type="primary" plain>修改</el-button>
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


  <el-dialog :title=bmbt  :before-close="xgBm" v-model="bmtk" width="30%" center  ><!-- 弹窗  新增   -=-=-=-=-=-=-==-=-=-=-=--=-=-=-=-=-=-部门弹框 -->
    <el-form :model="bm" ref="bmForm" :rules="rules">
      <el-form-item label="部门名称" prop="bmName">
        <el-input type="text" style="width: 60%;" v-model="bm.bmName"></el-input><br />
      </el-form-item>
<!--      部门名称：<el-input type="text" style="width: 40%;" v-model="bm.bmName"></el-input><br />-->
      <el-row>
        <el-col :span="2" :offset="10">
          <el-button type="primary" style="margin-top: 20px" @click="bmForm('bmForm')">确定</el-button>
        </el-col>
      </el-row>
    </el-form>


  </el-dialog>

</template>

<script>
import qs from "qs";

export default {
  data () {
    return {
      bmbt:'',
      bmtk:false,
<<<<<<< HEAD
      bmji:[],
      bm:{

=======
      bmji1:[],//部门单
      bmji:[],//部门集合
      bm:{
        bmId:'',
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        bmName:''
      },
      rules: {
        bmName: [
<<<<<<< HEAD
          {required: true, message: '请输入用户名', trigger: 'blur'},
=======
          {required: true, message: '请输入部门', trigger: 'blur'},
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        ]
      },
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
    },
    bmForm(formName){
<<<<<<< HEAD
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.post("http://localhost:8095/add-bm",
              this.bm
          ).then((v) => {
            if (v.data === 'ok') {
              this.getData()
              this.$refs[formName].resetFields();
              this.$message.success("新增成功")
            } else {
              console.log(v.data)
            }
          }).catch();
          this.bmtk=false
=======
      let params = {
        bmId:this.bm.bmId,
        bmName:this.bm.bmName,
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //查询去重
          this.axios.get("http://localhost:8095/bmqc", {
            params: {
              bmName: this.bm.bmName
            }
          }).then((res) => {
            this.bmji1 = res.data;
            let aa=res.data;
            if(res.data=null||res.data==""){
              this.axios.post("http://localhost:8095/add-bm",
                  params
              ).then((v) => {
                if (v.data === 'ok') {
                  this.getData()
                  this.$refs[formName].resetFields();
                  if(this.bmbt=="新增部门"){
                    this.$message.success("新增成功")
                    this.rzAdd("新增部门")
                  }else {
                    this.$message.success("修改成功")
                    this.rzAdd("修改部门")
                  }
                } else {
                  console.log(v.data)
                }
              }).catch();
              this.bmtk=false
            }else{
              console.log(this.bmji1)
              this.$message.info("已有该部门")
            }
          }).catch()


>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        } else {
          console.log('error submit!!');
          return false;
        }
      });
<<<<<<< HEAD

      // this.axios.post("http://localhost:8095/add-bm",this.bm).then((res)=>{
      //   this.getData()
      // }).catch()
=======
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
    },
    //部门弹框X
    xgBm(){
      this.bmtk=false;
      this.$refs['bmForm'].resetFields();
    },
    // 新增部门
    bmEdit(row,is){
<<<<<<< HEAD
      this.bmbt = is == 1 ? '修改' : '新增';//设置弹框标题
      console.log(this.$store.state.token)
      if(row!=""){
=======
      this.bmbt = is == 1 ? '修改部门' : '新增部门';//设置弹框标题
      console.log(this.$store.state.token)
      if(row!=""){
        this.bm.bmId=row.bmId
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        this.bm.bmName=row.bmName
      }else {
        this.bm.bmName=""
      }
      this.bmtk=true
<<<<<<< HEAD
    }
=======
    },//新增日志方法
    rzAdd(action){
      let params = {
        logAction:action,
        yhId:this.$store.state.token.yhId,
        logTime:this.getNowFormatDate
      }
      this.axios.post("http://localhost:8095/add-rz",params).then((v) => {
        if (v.data === 'ok') {
        } else {
          console.log(v.data)
        }
      }).catch();
    },
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
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
