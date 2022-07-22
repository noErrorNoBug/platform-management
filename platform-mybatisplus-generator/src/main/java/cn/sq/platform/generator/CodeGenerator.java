package cn.sq.platform.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

/**
 * @author sunqiang
 * @version 1.0
 * @description 代码生成器
 * @date 2022/3/11 11:41 AM
 */
public class CodeGenerator {
    public static void main(String[] args) {
        // 数据库基本信息配置
        String url = "jdbc:mysql://rm-m5epk71o1tapw6o6pko.mysql.rds.aliyuncs.com:3306/mall";
        String username = "mall";
        String password = "600255";

        // 文件生成路径
        String workpath = System.getProperty("user.dir") + "/mall-mbg";  // 需要将ide的工作路径指定到父目录下，后缀为子模块目录
        String pkgPath = workpath + "/src/main/java"; // 代码路径
        String pkgXml = workpath + "/src/main/resources"; // 资源路径
        String pkgParent = "cn.sq";// 父包名
        String pkgMoudule = "mall";//模块名
        String pkgEntity = "pojo";//Entity包名，基于 父包名.模块名
        String pkgService = "service";//service包名，基于 父包名.模块名
        String pkgServiceImpl = "service.impl";//impl所在包名，基于 父包名.模块名
        String pkgMapper = "mapper";//mapper所在包名，基于 父包名.模块名
        String pkgController = "controller";//controller所在包名，基于 父包名.模块名
        String fileXml = "mappers";//mapper.xml所在位置，基于pkgXml路径
        String pkgOther = "others";//自定义文件所在包名，基于 父包名.模块名

        // 自定义模板路径
        String tempEntity = "ext-templates/entity.java.vm";    //entity 自定义模板 java
        // String tempController = "ext-templates/controller.java.vm"; //controller 自定义模板
        // String tempService = "ext-templates/service.java.vm";   //service 自定义模板
        // String tempServiceImpl = "ext-templates/serviceImpl.java.vm";   //serviceImpl 自定义模板
        String tempMapper = "ext-templates/mapper.java.vm"; //mapper 自定义模板
        String tempMapperXml = "ext-templates/mapper.xml.vm";  //xml 自定义模板
        // String tempEntityKt = "ext-templates/entity.java.vm";   //entity 自定义模板 kotlin

        // 数据库配置
        FastAutoGenerator
                /**
                 * 数据库配置
                 */
                .create(new DataSourceConfig.Builder(url, username, password)
                        .dbQuery(new MySqlQuery())  // 使用Mysql的查询语句
                        // .schema("schemaName")   // 如Oracle多schema的配置schema名
                        .typeConvert(new MySqlTypeConvert())    // 数据库类型转换器，使用Mysql，即数据库类型转换为JavaBean的识别器，可以进行自定义设置，使用自己的处理器
                        // .typeConvert(new ExtensionMysqlTypeConvert())   // 使用自定义类型
                        .keyWordsHandler(new MySqlKeyWordsHandler())    // 关键字处理器，使用Mysql关键字识别
                )

                /**
                 * 全局配置
                 */
                .globalConfig(builder -> {
                    builder.fileOverride()  // 覆盖已生成的文件
                            .author("sunqiang") // @author
                            .enableSwagger() // 开启swagger模式，只支持Swagger2的模板，3需要自己修改模板
                            // .enableKotlin() // 开启Kotlin模式，使用Kotlin进行编程
                            .disableOpenDir()   // 禁用输出结束后打开窗口
                            .outputDir(pkgPath) //指定输出目录，这里是指定到项目目录下
                            .dateType(DateType.TIME_PACK);   // 时间策略
                    // .commentDate("yyyy-MM-dd");  // 注释日期
                })

                /**
                 * 路径配置
                 */
                .packageConfig(builder -> {
                    builder.parent(pkgParent)  //父包名
                            .moduleName(pkgMoudule)     //父模块名
                            .entity(pkgEntity)   // entity所在包名
                            .service(pkgService)     // service所在包名
                            .serviceImpl(pkgServiceImpl)    // impl所在包名
                            .mapper(pkgMapper)   // mapper所在包名
                            .xml(fileXml)  // XML文件所在的包名
                            .controller(pkgController) //controller所在包名
                    // .other(pkgOther)    // 输出自定义文件时的包名
                    // .pathInfo(new HashMap<OutputFile,String>(){{    // 输出空的模板文件到指定的目录下
                    //     put(OutputFile.mapperXml,pkgXml); // xml空内容模板
                    //     put(OutputFile.entity,pkgPath); // entity空内容模板
                    //     put(OutputFile.service,pkgPath); // service空内容模板
                    //     put(OutputFile.serviceImpl,pkgPath); // serviceImpl空内容模板
                    //     put(OutputFile.mapper,pkgPath); // mapper空内容模板
                    //     put(OutputFile.controller,pkgPath); // controller空内容模板
                    //     // put(OutputFile.other,pkgPath); // 自定义空内容模板
                    // }})
                    ;
                })

                /**
                 * 模板配置
                 */
                .templateConfig(builder -> builder
                                // .disable()  //禁用全部模板生成
                                .disable(TemplateType.CONTROLLER, TemplateType.SERVICE, TemplateType.SERVICEIMPL)   // 禁用指定模板生成（不生成对应文件）
                                .mapper(tempMapper)    //自定义 mapper 模板
                                .mapperXml(tempMapperXml)    //自定义 xml 模板
                                .entity(tempEntity)    //自定义entity模板，支持swagger3，java
                        // .controller(tempController)    // 自定义controller模板
                        // .service(tempService)    //自定义 service 模板
                        // .serviceImpl(tempServiceImpl)    //自定义 serviceImpl 模板

                        // .entityKt(tempEntityKt)  // 自定义 entity模板，kotlin
                )

                /**
                 * 注入配置
                 */
                // .injectionConfig(builder -> builder.beforeOutputFile((tableInfo, stringObjectMap) -> {
                //    // 文件输出前预处理
                // System.out.println("tableInfo:" + tableInfo.getEntityName());
                // })
                //                 .customMap(Collections.singletonMap("test","testParam"))// 自定义模板传入参数
                //                 .customFile(new HashMap<String, String>() {{    //  自定义模板配置文件和输出
                //                     put("sample.vue","/ext-templates/vue.test.vm");
                //                     put("abc.vue","/ext-templates/vue.test.vm");
                //                 }}).build())

                /**
                 * 全局策略配置
                 */
                .strategyConfig(builder -> builder
                // .enableCapitalMode()    // 开启大写名称模式
                // .enableSkipView()       // 生成时跳过视图
                // .disableSqlFilter()     // 禁止sql 过滤
                // .enableSchema()         // 启用schema模式
                // //手动设置匹配条件（sql中过滤）匹配模式分为3中：左匹配，右匹配，默认前后都匹配，只有匹配命中的才生成代码，不能与NotLikeTable同时使用
                // .likeTable(new LikeTable("sms_",SqlLike.LEFT))
                // //手动设置排除条件（sql中过滤），匹配模式分为3中：左匹配，右匹配，默认前后都匹配，匹配命中的进行排除不生成代码，不能与LikeTable同时使用
                // .notLikeTable(new LikeTable("cms_",SqlLike.LEFT))
                // .addInclude("cms_profile","ems_ak") // 增加表匹配，额外匹配输入的表（全量查询，内存中过滤）
                // .addExclude("cms_profile","ems_ak") //  增加表过滤，额外过滤掉某些指定的表（全量查询，内存中过滤）
                // .addTablePrefix("cms_","ems_","ams_")   //  生成符合前缀条件的表
                // .addTableSuffix("_ppa","_ppb")  // 生成符合后缀条件的表
                // .addFieldPrefix("entry_","test_")   // 生成符合前缀条件的字段属性
                // .addFieldSuffix("_id","_name")  // 生成符合后缀条件的属性

                /**
                 * 实体类策略配置
                 */
                // .entityBuilder()
                // .nameConvert(INameConvert)  //名称转换器，如果有特殊需求的话自己实现一个进行转换
                // .superClass(BaseEntity.class)   // 设置父类
                // .superClass("com.sunsite.common.BaseEntity")    // 设置父类
                // .disableSerialVersionUID()  // 禁用SerialVersionUID
                // .enableColumnConstant() //开启生成字段常量
                // .enableChainModel() // 开启链式模式
                // .enableLombok() // 开启Lombok模式
                // .enableRemoveIsPrefix() // 开启 Boolean类型移除is模式
                // .enableActiveRecord()   // 开启 ActiveRecord模式
                // .versionColumnName("version_id")    // 数据库中乐观锁字段名称
                // .versionPropertyName("versionId")   // 生成的实体中对应的乐观锁属性名称
                // .logicDeleteColumnName("is_delete") // 数据库中表示逻辑删除的字段名称
                // .logicDeletePropertyName("delete")  // 生成的实体中表示逻辑删除的字段名称
                // .naming(NamingStrategy.underline_to_camel)  // 数据库表名映射到实体的规则，默认下划线转驼峰
                // .columnNaming(NamingStrategy.underline_to_camel)    // 数据库字段名映射到实体属性的规则，默认null，不填写与naming相同
                // .addSuperEntityColumns("create_by","create_time")    // 为父类添加共同字段
                // .addIgnoreColumns("sex","tall") // 忽略数据库字段
                // .addTableFills(new Column("create_time", FieldFill.INSERT)) // 添加mapper方法的字段自动填充sql
                // .addTableFills(new Property("update_time",FieldFill.INSERT_UPDATE)) // 添加mapper方法的字段自动填充sql
                // .idType(IdType.AUTO)    // 全局主键类型
                // .convertFileName(new ConverterFileName() {  // entity文件名替换策略
                // @Override
                // public String convert(String entityName) {
                // if ("ABC".equals(entityName)) {
                // return "CDE";
                // }
                // return entityName;
                // }
                // })
                // .formatFileName("%sEntity") // entity 文件名格式化，此处为统一加后缀

                /**
                 * controller 策略配置
                 */
                // .controllerBuilder()
                // .superClass(BaseController.class)   //设置父类"
                // .superClass("com.sunsite.common.BaseController.class")  // 设置父类
                // .enableHyphenStyle()    // 开启驼峰连字符
                // .enableRestStyle()  // 开启@RestController控制器
                // .convertFileName(new ConverterFileName() {  // 名称转换器，与上面使用方法相同
                //     @Override
                //     public String convert(String entityName) {
                //         return null;
                //     }
                // })
                // .formatFileName("%sAction") // 名称格式化

                /**
                 * service 策略配置
                 */
                // .serviceBuilder()
                // .superServiceClass(BaseService.class)   // service类父类
                // .superServiceClass("com.sunsite.common.BaseService")    // service类父类
                // .superServiceImplClass(BaseServiceImpl.class)   // serviceImpl 类父类
                // .superServiceImplClass("com.sunsite.common.BaseServiceImpl")    // serviceImpl 类父类
                // .convertServiceFileName(new ConverterFileName() {       // 转换service 名称，与前面一直
                //     @Override
                //     public String convert(String entityName) {
                //         return null;
                //     }
                // })
                // .convertServiceImplFileName(new ConverterFileName() {   // 转换serviceImpl名称，默认是IxxxService
                //     @Override
                //     public String convert(String entityName) {
                //         if (entityName.startsWith("I")) {
                //             entityName = entityName.split("I")[1] + "Impl";
                //         }
                //         return entityName;
                //     }
                // })
                // .formatServiceFileName("%sService") // 格式化Service 名称
                // .formatServiceImplFileName("%sServiceImpl") //格式化ServiceImpl名称
                /**
                 * mapper 策略配置
                 */
                .mapperBuilder()
                // .superClass(BaseMapper.class)   // 设置 Mapper 的父类
                // .superClass("com.sunsite.common.BaseMapper")    // 设置Mapper 的父类
                .enableMapperAnnotation()   // Mapper 加入 @Mapper 注解
                .enableBaseResultMap()  //  启用 BaseResultMap 生成
                .enableBaseColumnList() // 启用 BaseColumnList 生成
                // .cache(MyMapperCache.class) //设置本地缓存实现类
                // .convertMapperFileName(new ConverterFileName() {    // 过滤mapper文件名
                //     @Override
                //     public String convert(String entityName) {
                //         return null;
                //     }
                // })
                // .convertXmlFileName(new ConverterFileName() {   // 过滤xml文件名
                //     @Override
                //     public String convert(String entityName) {
                //         return null;
                //     }
                // })
                // .formatMapperFileName("%sMapper")   // 格式化Mapper 命名
                // .formatXmlFileName("%sMapper")      // 格式化xml命名

                )
                .execute();
    }
}
