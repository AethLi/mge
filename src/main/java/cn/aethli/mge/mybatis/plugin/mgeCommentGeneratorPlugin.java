package cn.aethli.mge.mybatis.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 注释生成修改
 *
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-08 15:27
 **/
public class mgeCommentGeneratorPlugin extends DefaultCommentGenerator {

    @Override
    public void addFieldComment(Field field,
                                IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        /*if (suppressAllComments) {
            return;
        }*/

        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**"); //$NON-NLS-1$

        sb.append(" *  "); //$NON-NLS-1$
        sb.append(introspectedColumn.getRemarks());
        sb.append(",所属表字段为");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());

        field.addJavaDocLine(" */"); //$NON-NLS-1$

        String column = introspectedColumn.getActualColumnName();
        if (StringUtility.stringContainsSpace(column) || introspectedTable.getTableConfiguration().isAllColumnDelimitingEnabled()) {
            column = introspectedColumn.getContext().getBeginningDelimiter()
                    + column
                    + introspectedColumn.getContext().getEndingDelimiter();
        }

        if (!column.equals(introspectedColumn.getJavaProperty())) {
            //@Column  //去掉生成的注解如果需要加JPA注解可以加上
//            field.addAnnotation("@MyBatisColumnAnnotation(name = \"" + column + "\", "
//            		+ "value = \"" + introspectedTable.getFullyQualifiedTable() + "_" + introspectedColumn.getActualColumnName() + "\", "
//    				+ "chineseNote = \"" + introspectedColumn.getRemarks() + "\", "
//            		+ "tableAlias = \"" + introspectedColumn.getTableAlias() + "\")");
        }
    }
}
