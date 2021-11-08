<template>
  <el-row>
    <el-form style="padding-top: 10px">
      <el-col :span="19">
        <el-form-item  label="角色信息:" label-width="100px">
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
          <el-button  style="margin-left: 500px" @click="jsEdit" type="primary">新增</el-button>
        </el-form-item>
      </el-col>
    </el-form>

    <!--sssssssssssssssssss角色弹框sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss-->

    <el-dialog width="40%" :before-close="xgJs" :title=jstit v-model="jstk">
      <el-form ref="jsFrom" :rules="rulejs" :model="js">
        <el-row>
          <el-col :span="10">
            <el-form-item label="角色名:" prop="posName" label-width="120px">
              <el-input v-model="js.posName"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10">
            <el-form-item label="部门：" label-width="120px" prop="posId">
              <el-select v-model="js.bmId" placeholder="请选择">
                <el-option
                    v-for="item in bmji"
                    :key="item.value"
                    :label="item.bmName"
                    :value="item.bmId">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="角色授权" label-width="120px">
            </el-form-item>
          </el-col>
          <el-col :span="10">
            <el-scrollbar style="margin-top: 10px" height="200px">
              <el-tree ref="tree" :data="sqxji" node-key="jsdnId"
                       :props="props" show-checkbox  default-expand-all
              >
              </el-tree>
            </el-scrollbar>
          </el-col>
        </el-row>
        <el-form-item>
          <el-col :span="1" :offset="11">
            <el-button type="primary" @click="jsForm('jsFrom')">确定</el-button>
          </el-col>
        </el-form-item>
      </el-form>
    </el-dialog>


  </el-row>
  <!--=============================================角色表格===================================-->
  <el-row>
    <el-col>
      <el-table :data="jsji.slice((currentPage-1)*pagesize,currentPage*pagesize)" height="450"  tooltip-effect="dark" style="width: 100%;">
        <el-table-column
            label="编号"
            prop="posId"
        >
        </el-table-column>
        <el-table-column
            prop="posName"
            label="角色名">
        </el-table-column>
        <el-table-column
            prop="bm.bmName"
            label="部门">
        </el-table-column>
        <el-table-column
            label="操作">
          <template #default="scope">
            <el-button size="mini" @click="jsEdit(scope.row,1)" type="primary" plain>修改</el-button>
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
                      :total="jsji.length">
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
      dialogVisible:false,
      jstk:false,//角色弹框
      jstit:'',//角色弹框标题
      jsji:[],
      qxji:[],
      bmji:[],
      sqxji:[],
      js:{
        posId:'',
        posName:'',
        bmId:''
      },
      rulejs:{
        posName: [
          {required: true, message: '请输入角色名', trigger: 'blur'},
        ],
        posId: [
          {required: false, message: '请选择部门', trigger: 'change'},
          {required: true, message: '请选择部门', trigger: 'blur' }
        ],
      },
      props: {
        id:'jsdnId',
        label: 'jsdnZname',
        children: 'list'
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
      this.axios.get("http://localhost:8095/qxbm").then((res) => {
        this.bmji = res.data;
      }).catch()
      this.axios.get("http://localhost:8095/action", {
        params: {
          seach: this.seach
        }
      }).then((res) => {
        this.jsji = res.data;
      }).catch()
      //所有权限
      this.axios.get("http://localhost:8095/syqx").then((res) => {
        this.sqxji = res.data;
      }).catch()
    },
    //角色弹框
    xgJs(){
      this.jstk=false;
      this.$refs['jsFrom'].resetFields();
    },
    //弹框确认
    jsForm(formName){
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
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    //新增修改角色
    jsEdit(row,is){
      this.jstit = is == 1 ? '修改角色' : '新增角色';//设置弹框标题
      if(row!=""){
        this.js.bmId=row.bmId,
        this.posName=row.posName,
        this.js.posId=row.posId
        //树形控件自选
        this.axios.get("http://localhost:8095/jsqx", {
          params: {
            posId:row.posId
          }
        }).then((res) => {
          console.log(res.data)
          this.qxji = res.data;
          res.data
          var ww=[];
          res.data.forEach(function(x){
            ww.push(x.jsdnId)
          });
          // this.dialogVisible=true
          this.$nextTick(function() {
            this.$refs.tree.setCheckedKeys(ww)
          })
        }).catch()
      }else {

      }
      this.jstk=true
    },
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
