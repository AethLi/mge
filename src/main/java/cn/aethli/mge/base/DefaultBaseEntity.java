package cn.aethli.mge.base;

import lombok.Data;

import java.io.Serializable;

/**
 * mybatis 部分，抽离公共基础model
 *
 * @author aethli
 */
@Data
public class DefaultBaseEntity implements Serializable {

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

}
