/**
 * File : IDynamicTableName.java
 * Author : lenovo
 * Version : 1.1
 * Date : 2017年1月10日
 * Modify :
 * Package Name : com.zhongpin.zp.persist.base.entity
 * Project Name : zp-persist-base
 * Description :
 * 
 */

package cn.aethli.mge.mybatis.base;

/**
 * ClassName : IDynamicTableName
 * Function : Mybatis 动态表名处理.
 * Reason : Mybatis 动态表名处理.
 * Date : 2017年1月10日 上午11:06:47
 */

public interface IDynamicTableName {

	/**
     * 获取动态表名 - 这个方法是关键，只要有返回值，不是null和''，就会用返回值作为表名
     *
     * @return
     */
    String getDynamicTableName();
}
