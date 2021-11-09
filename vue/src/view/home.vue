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
                  <el-dropdown-item icon="el-icon-setting">修改密码</el-dropdown-item>
                  <el-dropdown-item @click="Dely" icon="el-icon-close">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </div>
        </el-col>
			</el-row>
		</el-header>
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
    handleCommand(command) {
      this.$message('click on item ' + command);
      if(command==a){
        this.Dely
      }
    },
    //注销
    Dely(){
    this.$store.commit("logout");
    this.$router.replace("/login");
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
