package cn.aethli.mge.exception;

/**
 * ClassName : MybatisPluginException
 * Function : mybatis插件异常信息.
 * Reason : mybatis异常信息插件处理机制.
 * Date : 2016年11月21日 下午4:45:29
 */

public class MybatisPluginException extends RuntimeException {

    public MybatisPluginException() {
        super();
    }

    public MybatisPluginException(String message) {
        super(message);
    }

    public MybatisPluginException(String message, Throwable cause) {
        super(message, cause);
    }

    public MybatisPluginException(Throwable cause) {
        super(cause);
    }

}
