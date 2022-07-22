package cn.sq.platform.generator.extensions;


import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * @author sunqiang
 * @version 1.0
 * @description 自定义类型处理器
 * @date 2022/3/7 3:51 PM
 */
public class ExtensionMysqlTypeConvert extends MySqlTypeConvert {
    /**
     * 使用方法：重写该方法逻辑
     * 根据入参fieldType判断数据库类型，
     * 并使用 DbColumnType 进行设定
     * @param config
     * @param fieldType 数据库的字段类型，常量表
     * @see DbColumnType 数据库字段类型常量表
     * @return
     */
    @Override
    public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
        // 举例：如果是double类型，则使用Double类型
        if ("double".equals(fieldType)) {
            return DbColumnType.DOUBLE;
        }
        return super.processTypeConvert(config, fieldType);
    }
}
