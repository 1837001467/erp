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
      <el-col :span="5"  label-width="900px">
        <el-form-item>
          <el-button  style="margin-left: 500px" @click="yhEdit" type="primary">新增</el-button>
        </el-form-item>
      </el-col>
    </el-form>

<!--sssssssssssssssssss用户弹框ssssssssssssssssss-->

    <el-dialog width="40%" :before-close="xgYh" :title=yhtit v-model="yhtk">
      <el-form ref="yhFrom" :rules="ruleyh" :model="yh">
        <el-row>
          <el-col :span="10">
            <el-form-item label="账号" prop="yhCard" label-width="120px">
<<<<<<< HEAD
              <el-input v-model="yh.yhCard"></el-input>
=======
              <el-input v-model="yh.yhCard" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"></el-input>
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
            </el-form-item>
          </el-col>
          <el-col :offset="1" :span="10">
            <el-form-item label="用户名:" label-width="120px" prop="yhName">
                <el-input v-model="yh.yhName"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="10">
            <el-form-item label="职位：" label-width="120px" prop="posId">
              <el-select v-model="yh.posId" placeholder="请选择">
                <el-option
                    v-for="item in jsji"
                    :key="item.value"
                    :label="item.posName"
                    :value="item.posId">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="21">
            <el-form-item label="手机号：" label-width="120px" prop="yhPhone">
<<<<<<< HEAD
              <el-input v-model="yh.yhPhone"></el-input>
=======
              <el-input  v-model="yh.yhPhone"></el-input>
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item>
          <el-col :span="1" :offset="11">
            <el-button type="primary" @click="yhForm('yhFrom')">确定</el-button>
          </el-col>
        </el-form-item>
      </el-form>
    </el-dialog>



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
            prop="ybm.bm.bmName"
            label="部门">
        </el-table-column>
        <el-table-column
            prop="ybm.posName"
            label="职位">
        </el-table-column>
        <el-table-column
            label="操作">
          <template #default="scope">
            <el-button size="mini" @click="yhEdit(scope.row,1)" type="primary" plain>修改</el-button>
            <el-button size="mini" @click="xgYhmm(scope.row)" type="primary" plain>重置</el-button>
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



</template>

<script>
import qs from "qs";

export default {
  data () {
    return {
      yhtk:false,//弹框
      yhtit:'',//弹框标题
      jsji:[],//角色集
      ygji:[],
      seach: '',//查询框
      yh:{
        yhId:'',
        yhCard:'',
        yhName:'',
        yhPswd:123456,
        yhPhone:'',
        posId:'',
        yhState:0
      },
      ruleyh:{
        yhCard: [
          {required: true, message: '请输入账号', trigger: 'blur'},
<<<<<<< HEAD
=======

>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        ],
        yhName: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
        ],
        posId: [
          {required: false, message: '请选择职位', trigger: 'change'},
          {required: true, message: '请选择职位', trigger: 'blur' }
        ],
        yhPhone: [
<<<<<<< HEAD
          {required: true, message: '请输入手机号', trigger: 'blur'},
=======
          {required: true, message: '请输入手机号', trigger: 'blur'},{
            pattern: /^1(3|4|5|6|7|8)\d{9}$/,
            message: '请输入正确的手机号'
          },
>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        ]
      },
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
    // 基础参数
    getData() {
      this.axios.get("http://localhost:8095/user", {
        params: {
          seach: this.seach
        }
      }).then((res) => {
        this.ygji = res.data;
      }).catch()
      //所有职位或角色
      this.axios.get("http://localhost:8095/action").then((res) => {
        this.jsji = res.data;
      }).catch()
    },
    yhEdit(row,is){
      this.yhtit = is == 1 ? '修改用户' : '新增用户';//设置弹框标题
      if(row!=""){
            this.yh.yhCard=row.yhCard,
            this.yh.yhName=row.yhName,
            this.yh.yhPhone=row.yhPhone,
            this.yh.posId=row.posId,
            this.yh.yhId=row.yhId,
            this.yh.yhPswd=row.yhPswd
      }else {
<<<<<<< HEAD
        this.bm.bmName=""
=======

>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
      }
      this.yhtk=true
    },
    //用户弹框X
    xgYh(){
      this.yhtk=false;
      this.$refs['yhFrom'].resetFields();
    },
    xgYhmm(row){
      let params = {
        yhId:row.yhId,
<<<<<<< HEAD
        yhPswd:123456222,
      }
      console.log(params)
      this.axios.post("/upd-yhps",params).then((v) => {
        if (v.data === 'ok') {
          this.getData()
          // this.$refs[formName].resetFields();
          this.$message.success("新增成功")
        } else {
          console.log(v.data)
        }
      }).catch();
    },
    //打开确认弹框
    yhForm(formName){
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
        yhPswd:123456,
      }
      console.log(params)
      this.$confirm('此操作将重置该员工密码，重置后为123456, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.axios.post("/upd-yhps",params).then((v) => {
          if (v.data === 'ok') {
            this.getData()
            this.rzAdd("重置密码")
          } else {
            console.log(v.data)
          }
        }).catch();
        this.$message({
          type: 'success',
          message: '重置成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消'
        });
      });
    },
    //新增日志方法
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
    //用户确认弹框
    yhForm(formName){
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.yh.yhPswd='123456';
          //查询去重
          this.axios.get("http://localhost:8095/yhqc", {
            params: {
              yhCard:this.yh.yhCard
            }
          }).then((res) => {
            let aa=res.data;
			
            if(res.data==0){
              this.axios.post("http://localhost:8095/adu-yh",
                  this.yh
              ).then((v) => {
                if (v.data === 'ok') {
                  this.getData()
                  this.$refs[formName].resetFields();
                  if(this.yhtit=='新增用户'){
                    this.$message.success("新增成功")
                    this.rzAdd("新增员工")
                  }else {
                    this.$message.success("修改成功")
                    this.rzAdd("修改员工")
                  }
                  this.yhtk=false
                } else {
                  console.log(v.data)
                  this.$message.info("该账号名已使用")
                }
              }).catch();
            }else{
              this.$message.info("该账号名已使用")
            }
          }).catch()





>>>>>>> 49a989ad24102f249fe76034f2e5cf9ccca7e375
        } else {
          console.log('error submit!!');
          return false;
        }
      });
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
