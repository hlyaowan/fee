package com.aoyetech.fee.statuscode;

public abstract class BusinessCode {

    /** 正常 */
    public static final int NORMAL                             = 100000;
    /** 协议请求方法错误 */
    public static final int REQ_PROTOCAL_ERR                   = 100001;
    /** 参数错误 */
    public static final int PARAM_ERROR                        = 100002;
    /** 持久层异常 */
    public static final int DB_EXCEPTION                       = 100003;
    /** 操作失败 */
    public static final int OPRATE_ERROR                       = 100004;
    /** 用户密码不正确 */
    public static final int PASSWORD_INCORRECT                 = 100005;
    /** 用户账号已存在 */
    public static final int USER_EXIST                         = 100006;
    /** 用户账号不存在 */
    public static final int USER_NOT_EXIST                     = 100007;
    /** 用户账号已暂停 */
    public static final int USER_PAUSE                         = 100008;
    /** 用户账号已注销 */
    public static final int USER_STOP                          = 100009;
    /** 用户账户被锁定 */
    public static final int USER_LOCKED                        = 100010;
    /** 请登录再试 */
    public static final int NO_LOGININ                         = 100011;
    /** 用户ID不能为空 **/
    public static final int USERID_LEAK                        = 100012;
    /** 用户已经签到 */
    public static final int USER_ALREADY_SIGNIN                = 100013;
    /** 非法的用户标识 */
    public static final int ILLEGAL_USER_ID                    = 100014;
    /** 用户密码修改失败 */
    public static final int RESET_USER_PASSWORD_ERROR          = 100015;
    /** 尊敬的{0} 您好，您没有订购当前{1}，您当前剩余{2}阅点，订购需要{3}阅点或{4}元话费。 */
    public static final int USER_NOT_ORDERED                   = 100016;
    /** 您还未登录 */
    public static final int CHAPTER_IS_ORDER_USER_NOT_LOGIN    = 100017;
    /** 订购成功 */
    public static final int ORDER_SUCCESS                      = 100018;
    /** 订购失败 */
    public static final int ORDER_FAIL                         = 100019;
    /** 不存在订购关系 */
    public static final int NO_ORDER_RELATION                  = 100020;
    /** 已经存在订购关系 */
    public static final int ALREADY_ORDER_RELATION             = 100021;
    /** 尊敬的{0} 您好，您的余额不足，当前剩余{1}阅点，购买该{2}需要{3}阅点或{4}元话费。 */
    public static final int LEAK_MONEY                         = 100022;
    /** 兑换成功 */
    public static final int CONVERT_POINT_SUCCESS              = 100023;
    /** 时间格式非法 */
    public static final int ERROR_DATE_FORMAT                  = 100024;
    /** 时间格式长度不为八位 */
    public static final int ERROR_DATE_FORMAT_LENGTH           = 100025;
    /** 结束时间小于起始时间 */
    public static final int ENDTIMEUPSTARTTIME                 = 100026;
    /** 请求参数缺失(发送消息) */
    public static final int PARAM_LOST                         = 100027;
    /** 请求TOKEN错误 */
    public static final int REQ_TOKEN_ERROR                    = 100028;
    /** 请求超时 */
    public static final int REQ_TIME_OUT                       = 100029;
    /** 用户不合法 */
    public static final int USER_ERROR                         = 100030;
    /** 服务器繁忙 */
    public static final int SYS_ERROR                          = 999999;

}
