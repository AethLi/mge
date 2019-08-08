package cn.aethli.mge.mybatis.base;

import cn.aethli.mge.utils.StringUtilss;
import lombok.Data;

import java.beans.Transient;
import java.io.Serializable;

/**
 * mybatis 部分，抽离公共基础model
 *
 * @author aethli
 */
@Data
public class BaseEntity implements Serializable, IDynamicTableName {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID， 主键部分
     */
    private String id;

    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 动态表名部分，与数据库内真实的字段无关性
     */
    private String dynamicTableName;

    @Override
    @Transient
    public String getDynamicTableName() {
        if (this.dynamicTableName != null && !this.dynamicTableName.equals("")) {
            return dynamicTableName;
        } else {
            String simpleNameTemp = this.getClass().getSimpleName();
            String tableNameTemp = StringUtilss.toUnderlineCase(simpleNameTemp);
            return tableNameTemp;
        }

    }

    public void setDynamicTableName(String dynamicTableName) {
        this.dynamicTableName = dynamicTableName;
    }
}
