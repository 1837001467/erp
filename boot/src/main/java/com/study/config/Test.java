package com.study.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Test {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");  //生成路径(一般都是生成在此项目的src/main/java下面)
        gc.setAuthor("zzl"); //设置作者
        gc.setOpen(false);
        gc.setFileOverride(true); //第二次生成会把第一次生成的覆盖掉
        gc.setServiceName("%sService"); //生成的service接口名字首字母是否为I，这样设置就没有
        gc.setBaseResultMap(true); //生成resultMap
        mpg.setGlobalConfig(gc);

        //2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //jdbc:mysql://47.107.49.76:3306/erp?useUnicode=true&characterEncoding=UTF-8
        dsc.setUrl("jdbc:mysql://47.107.49.76:3306/erp?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root123");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 3、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("study");
        pc.setParent("com");
        mpg.setPackageInfo(pc);

        // 4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperControllerClass("com.study.controller.BaseController");
        //strategy.setSuperEntityClass("com.study.entity.BaseEntity");
        // strategy.setTablePrefix("t_"); // 表名前缀
        strategy.setEntityLombokModel(true); //使用lombok
        //String[] strs={"assess","assessdetails"};
        //(1)qyl
//       strategy.setInclude(new String[]{"cg_storage","cg_storagedetail","cg_ticket","cg_yinpay"});  // 逆向工程使用的表   如果要生成多个,这里可以传入String[]
        strategy.setInclude(new String[]{"ly_details","pd_lnventory","rk_apply","rk_details","zc_claim"});  // 逆向工程使用的表   如果要生成多个,这里可以传入String[]
        //(2)谢灵伟
//        strategy.setInclude(new String[]{"process_application"});
        //(3)dqw
//        strategy.setInclude(new String[]{"riders"});
        //(4)mty
//        strategy.setInclude(new String[]{"cg_order"});
        mpg.setStrategy(strategy);

        //5、执行
        mpg.execute();
    }

}
