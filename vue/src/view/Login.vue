<template>
	  <div class="homepage-hero-module">
	    <div class="video-container">
	      <div :style="fixStyle" class="filter"></div>
 	      <video muted :style="fixStyle" autoplay loop class="fillWidth" v-on:canplay="canplay">
	        <source src="../img/登录.mp4" type="video/mp4"/>
	        浏览器不支持 video 标签，建议升级浏览器。
	        <source src="../img/登录.mp4" type="video/webm"/>
	        浏览器不支持 video 标签，建议升级浏览器。
	      </video> 
 	      <div class="poster hidden" v-if="!vedioCanPlay">
	        <img :style="fixStyle" src="../img/登录.mp4" alt="">
	      </div> 
	    </div>
	  </div>
	  <div id="login">
		<el-form :model="user" :rules="rules"
		  class="login-container" label-position="left" label-width="0px">
		  <h3 class="login_title">账号密码登录</h3>
		    <el-form-item prop="account"><!-- prop属性中是验证器的键 -->
		      <el-input type="text" v-model="user.account"
		                auto-complete="off" placeholder="账号">			
			  </el-input>
		    </el-form-item>
		    <el-form-item prop="password">
		      <el-input type="password" v-model="user.password"
		                auto-complete="off" placeholder="密码">			
			  </el-input>
		    </el-form-item>
		    <el-form-item style="width: 100%">
		      <el-button type="primary" style="width: 100%;" @click="submitClick">登录</el-button>
		    </el-form-item>
		  </el-form>
		</div>
</template>

<script>
  export default {
    name: 'login',
    data() {
      return {
        vedioCanPlay: false,
        fixStyle: '',
		rules: {
			  account: [
				  {required: true, message: '请输入用户名', trigger: 'blur'},
			  ],
			  password: [
				  {required: true, message: '请输入密码', trigger: 'blur'},
				  {min:6,max:18,message:'密码长度在6-18之间',trigger:'blur'}
			  ]
			},
		checked: true,
		user: {
			 account: '谢灵伟',
			 password: '123456',
			 name:'登录',
			}
		}
    },
    methods: {
      canplay() {
        this.vedioCanPlay = true
      },
	  submitClick: function () {
						let n = Object.assign({},this.user);
						this.$store.commit('login',n);
						this.$router.replace("/");
					}
    },
    mounted: function() {
      window.onresize = () => {
        const windowWidth = document.body.clientWidth
        const windowHeight = document.body.clientHeight
        const windowAspectRatio = windowHeight / windowWidth
        let videoWidth
        let videoHeight
        if (windowAspectRatio < 0.5625) {
          videoWidth = windowWidth
          videoHeight = videoWidth * 0.5625
          this.fixStyle = {
            height: windowWidth * 0.5625 + 'px',
            width: windowWidth + 'px',
            'margin-bottom': (windowHeight - videoHeight) / 2 + 'px',
            'margin-left': 'initial'
          }
        } else {
          videoHeight = windowHeight
          videoWidth = videoHeight / 0.5625
          this.fixStyle = {
            height: windowHeight + 'px',
            width: windowHeight / 0.5625 + 'px',
            'margin-left': (windowWidth - videoWidth) / 2 + 'px',
            'margin-bottom': 'initial'
          }
        }
      }
      window.onresize();
    }
  }
</script>


<style scoped>
  .homepage-hero-module,
  .video-container {
    position: relative;
    height: 100vh;
    overflow: hidden;
  }
 
  .video-container .poster img,
  .video-container video {
    z-index: 0;
    position: absolute;
  }
 
  .video-container .filter {
    z-index: 1;
    position: absolute;
    background: rgba(0, 0, 0, 0.4);
  }
  .login-container {
      border-radius: 15px;
      background-clip: padding-box;
  	position: absolute;
  	width: 350px;
  	top:50%;
  	left:50%;
  	transform: translate(-50%,-50%);
      padding: 35px 35px 15px 35px;
      background-color: rgba(255, 255, 255, 0.2);
      border: 1px solid #eaeaea;

    }
  	
    .login_title {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #ffffff;
    }
    .login_remember {
      margin: 0px 0px 35px 0px;
      text-align: left;
    }
  	
  	.el-button--primary{
  		background: linear-gradient(45deg,pink 20%,dodgerblue 100%);
  		border: none;
  	}
  	.el-button--primary:hover{
  		background: linear-gradient(135deg,dodgerblue 20%,pink 100%);
  		border: none;
  	}
	#login{
		z-index: 999;
		position: absolute;
		top: 50%;
		left: 50%;
	}
</style>
