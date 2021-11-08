<template> 
	<el-container>
		<!-- height顶栏高度-->
		<el-header height="80px">
			<el-row :gutter="20">
				<el-col :span="8">
					超易进销存管理系统<i class="el-icon-user-solid"></i>
				</el-col>
				<el-col :span="14"></el-col>
        <el-col :span="2">
          <div class="myheader">
            <el-dropdown trigger="click">
              <span style="font-size: 20px;color: white">
								{{$store.state.token.yhName}}
								<i class="el-icon-arrow-down el-icon--right"></i>
						      </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item @click="mmtk=true" icon="el-icon-setting">修改密码</el-dropdown-item>
                  <el-dropdown-item @click="Dely" icon="el-icon-close">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </div>
        </el-col>
			</el-row>
		</el-header>

    <!--sssssssssssssssssss角色弹框sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss-->

    <el-dialog width="40%" :before-close="xgMm" title='修改密码' v-model="mmtk">
      <el-form ref="mmFrom" :rules="rulemm" :model="mm">
        <el-row>
          <el-col :span="16">
            <el-form-item label="原密码:" prop="yPswd" label-width="120px">
              <el-input v-model="mm.yPswd"  placeholder="请输入原密码" show-password></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="16">
          <el-form-item label="现密码:" prop="xPswd" label-width="120px">
            <el-input v-model="mm.xPswd" placeholder="请输入现密码" show-password></el-input>
          </el-form-item>
        </el-col>
        </el-row>
        <el-form-item>
          <el-col :span="1" :offset="11">
            <el-button type="primary" @click="mmForm('mmFrom')">确定</el-button>
          </el-col>
        </el-form-item>
      </el-form>
    </el-dialog>

		<el-container>
			<el-aside width="200px">
				<!-- el-menu导航菜单 -->
        <el-menu router unique-opened
                 class="el-menu-vertical-demo">
          <el-submenu v-for="(menu,idx) in menus" :index="idx+''">
            <template #title>
              <i :class="menu.jsdnTpath"></i>
              <span>{{menu.jsdnZname}}</span>
            </template>
            <el-menu-item v-for="c in menu.list" :index="c.jsdnPath+''">
              <i :class="c.jsdnTpath"></i>
              <template #title>{{c.jsdnZname}}</template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
			</el-aside>
			<el-container>
				<el-main>
					<!-- 主视图区 -->
					<router-view></router-view>
				</el-main>
			</el-container>
		</el-container>
	</el-container>
</template>

<script>
export default {
  data () {
    return {
      mmtk:false,
      mm:{
        yPswd:'',
        xPswd:''
      },
      rulemm:{
        yPswd: [
          {required: true, message: '请输入原始密码', trigger: 'blur'},
        ],
        xPswd: [
          {required: true, message: '请输入新密码', trigger: 'blur'},
          { min: 6, max: 10, message: '长度在 6 到 10 个字符', trigger: 'blur' }
        ],
      },
      menus:[]
    }
  },
  methods: {
    getMenus(){
      let userId = this.$store.state.token.yhId;
      console.log(this.$store.state.token.yhId)
      this.axios.get("http://localhost:8095/dlqx",{params:{yhId:userId}}).then((res)=>{
        this.menus = res.data
        console.log(this.menus)
      }).catch()
    },
    //修改密码弹框X
    xgMm(){
      this.mmtk=false
      this.$refs['mmFrom'].resetFields();
    },
    //修改密码弹框确认
    mmForm(formName){
      //查询原密码
      let params = {
        yhCard:this.$store.state.token.yhCard,
        yhPswd:this.mm.yPswd,
      }

      let paramsq = {
        yhId:this.$store.state.token.yhId,
        yhPswd:this.mm.xPswd,
      }
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //查询原密码
          this.axios.post("http://localhost:8095/login",params).then((res)=>{
            if(res.data !== 'fail'){
              this.axios.post("http://localhost:8095/upd-yhps",paramsq).then((v) => {
                if (v.data === 'ok') {
                  this.rzAdd("修改密码")
                  this.Dely()
                } else {
                  console.log(v.data)
                }
              }).catch();
            }else {
              this.$message({
                message: '原密码错误',
                type: 'info'
              });
            }
          }).catch(()=>{

          })
          // this.axios.get("http://localhost:8095/login", params).then((res) => {
          //   let aa=res.data;
          //   if(res.data=null||res.data==""){
          //     //修改密码
          //     this.axios.post("http://localhost:8095/upd-yhps",paramsq).then((v) => {
          //       if (v.data === 'ok') {
          //         this.rzAdd("修改密码")
          //         this.Dely()
          //       } else {
          //         console.log(v.data)
          //       }
          //     }).catch();
          //     this.bmtk=false
          //   }else{
          //     console.log(this.bmji1)
          //     this.$message.info("已有该部门")
          //   }
          // }).catch()
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
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
    //注销
    Dely(){
    this.$store.commit("logout");
    this.$router.replace("/login");
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
},
  created() {
    //取token值
    this.token = this.$store.state.token
    this.getMenus()
  }
}
</script>

<style>
	html,
	body {
		height: 100%;
	}

	/* 顶栏样式 */
	.el-header {
		background: #42B983;
		color: #fff;
		line-height: 80px;
		font-size: 22px;
	}

	/* 侧边栏 */
	.el-aside {
		background-color: whitesmoke;
		color: #fff;
		margin-top: 1px;
		min-height: 620px;
	}

	.el-main {
		padding-top: 20px;
	}

	.el-footer {
		background-color: white;
	}

	.el-submenu__title i {
		color: yellowgreen;
	}
	.el-submenu__title i.el-icon-arrow-down {
		color: yellow
	}

	.el-menu-item * {
		color: cyan;
		vertical-align: middle;
		text-decoration: none;
	}
</style>
