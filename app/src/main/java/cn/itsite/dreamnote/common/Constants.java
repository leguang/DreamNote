package cn.itsite.dreamnote.common;


import cn.itsite.abase.common.BaseConstants;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class Constants extends BaseConstants {
    private final String TAG = this.getClass().getSimpleName();
    /**
     * 不允许new
     */
    private Constants() {
        throw new Error("Do not need instantiate!");
    }
    public static final String PRESS_AGAIN = "再按一次退出";
    public static final String ISFIRSTENTRY = "is_first_entry";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USER_INFO_BEAN = "user_info_bean";
    public static final String ENCRYPT_KEY = "leguang";

}
