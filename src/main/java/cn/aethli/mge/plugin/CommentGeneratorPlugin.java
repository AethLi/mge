package cn.aethli.mge.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 注释生成修改
 *
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-08 15:27
 **/
public class CommentGeneratorPlugin extends DefaultCommentGenerator {

    @Override
    public void addFieldComment(Field field,
                                IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" *  ");
        sb.append(introspectedColumn.getRemarks());
        sb.append(",所属表字段为");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
    }
}
