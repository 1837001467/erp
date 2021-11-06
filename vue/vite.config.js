import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import {resolve} from 'path'
// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve:{
	  alias:{
		  /* 配置@符号指向src目录。@简写方式*/
		  '@':resolve(__dirname,'src')
	  }
  },
  server:{
	  port:4000,/* 当前项目的端口号 */
	  open:true /* 工程启动之后自动打开浏览器*/
  }
})