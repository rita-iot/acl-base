package com.xiaoyi.base.utils;

/**
 * @title 返回信息枚举类
 * @description 返回信息枚举类
 *              _COMMON : 公共返回信息
 *              _{SERVICE-NAME（服务名）}_{ACTION-NAME（方法标题）}
 * @author：Bing
 * @date：2021/12/2 11:16
 * @version：1.0
 */
public enum ResultMessageEnum {
    /**
     * 公共提示
     */
    SUCCESS_COMMON("操作成功"),
    FAILED_COMMON("操作失败"),
    VALIDATE_FAILED_COMMON("参数校验失败"),
    FORBBIDEN_COMMON("没有相关权限"),
    USER_NOT_FOUND("用户不存在"),
    USER_ACCOUNT_ERROR("账号密码错误"),
    GATEWAY_ERROR("网关异常"),
    SERVICE_INSTANCE_NOT_FOUND("未找到服务实例"),
    USER_NOT_LOGIN("用户未登录"),
    VALIDATE_FILE_TYPE_NOT_SUPPORT("文件类型不支持"),
    /**
     * 服务自定义提示
     */
    /**
     * Fol随访服务异常
     */
    FOL_PAT_NOT_FOUND("患者不存在"),
    FOL_ID_NOT_BLACK("所属人ID不能为空"),
    FOL_HEALTH_FILTER_FEIGN_FAIL("随访健康宣教筛选Feign返回异常"),
    FOL_HEALTH_FILTER_PAT_PACKAGE_ERROR("随访服务患者组装信息异常"),
    FOL_ILLEGALITY_SEND_TYPE("患者不存在"),
    FOL_PLAN_PAT_ID_NOT_FOUND("患者计划任务ID不存在"),
    /**
     * Pat患者服务异常
     */
    PAT_STATUS_NOT_NULL("状态不能为空"),
    /**
     * 全局异常
     */
    FAILED_FEIGN("Feign调用异常"),
    FAILED_COMMON_SERVER_ERROR("服务端异常"),
    COMMON_AGE_TRANSITION_ERROR("年龄转换错误"),

    /**
     * 工具包异常
     */
    UTIL_ANNOTATION_FEIGN_NOT_FOUND("feign注解不存在"),
    UTIL_SERVICE_NAME_NOT_BLACK("服务名不得为空"),
    UTIL_SERVICE_INSTANCE_NOT_NULL("服务实例不得为空"),
    UTIL_SEATA_HTTP_CALL_ERROR("SEATA HTTP远程调用异常"),
    UTIL_SEATA_HTTP_CACHE_ERROR("SEATA HTTP缓存异常"),
    UTIL_SEATA_HTTP_RESPONSE_JSON_ERROR("SEATA HTTP响应序列化失败"),
    /**
     * 模板异常
     */
    SMS_TEMPLATE_NOT_FOUND("短信消息模板没有找到"),
    SMS_SEND_ERROR("短信发送失败"),
    SMS_SAVE_FAIL("短信发送记录保存失败"),
    /**
     * 文件异常
     */
    FILE_NOT_FOUND("文件不存在");

    /**
     * 提示返回信息
     */
    private String message;

    ResultMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
