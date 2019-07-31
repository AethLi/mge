package cn.aethli.mge.mybatis.base;

import cn.aethli.mge.utils.StringUtilss;
import cn.aethli.mge.vo.enums.DeleteFlagEnum;

import java.beans.Transient;
import java.io.Serializable;

/**
 * mybatis 部分，抽离公共基础model
 *
 * @author wang
 */
public class BaseEntity implements Serializable, IDynamicTableName {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID， 主键部分
     */
    private Long id;

    /**
     * 删除标示
     */
    private DeleteFlagEnum deleteFlag;

    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建时间
     */
    private String updateTime;

    /**
     * 动态表名部分，与数据库内真是的字段无关性
     */
    private String dynamicTableName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeleteFlagEnum getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(DeleteFlagEnum deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

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
