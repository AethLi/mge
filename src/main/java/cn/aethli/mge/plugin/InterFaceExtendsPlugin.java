package cn.aethli.mge.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.*;

/**
 * 生成的 mapper 接口类部分，是需要继承基类文件的，并且添加泛型支持
 * 
*
 */
public class InterFaceExtendsPlugin extends PluginAdapter {

	private Set<String> mappers = new HashSet<>();

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		String mappers = this.properties.getProperty("mappers");
		if (StringUtility.stringHasValue(mappers)) {
			this.mappers.addAll(Arrays.asList(mappers.split(",")));
		} else {
			throw new RuntimeException("Mapper插件缺少必要的mappers属性!");
		}
	}

	/**
	 * 生成的mapper接口能够继承基类方法
	 *
	 * @param interfaze
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// 获取实体类
		FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		// import接口
		for (String mapper : mappers) {
			interfaze.addImportedType(new FullyQualifiedJavaType(mapper));
			interfaze.addSuperInterface(new FullyQualifiedJavaType(mapper + "<" + entityType.getShortName() + ">"));
		}
		//System.out.println(entityType.getShortName()+",,,,"+entityType);
		// import实体类
		interfaze.addImportedType(entityType);
		return true;
	}
	
	@Override
	public boolean clientInsertMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	
	@Override
	public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
	
	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

}
