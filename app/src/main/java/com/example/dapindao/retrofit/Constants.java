package com.example.dapindao.retrofit;

/**
 * Created by Administrator on 2017/8/1.
 */

public class Constants {

    public static final String WeiBoAPP_KEY = "2583013109";//微博appkey
    public static final String REDIRECT_URL = "http://sns.whalecloud.com/sina2/call";//回调地址
    public static final String SCOPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";

    /**已选中频道的json*/
    public static final String SELECTED_CHANNEL_JSON = "selectedChannelJson";
    /**w未选频道的json*/
    public static final String UNSELECTED_CHANNEL_JSON = "unselectChannelJson";
    /**频道对应的请求参数*/
    public static final String CHANNEL_CODE = "channelCode";

    public static String SERVER_URL = "http://api.dapindao.com";
    //public static String SERVER_URL="http://192.168.1.109:80";
    public static long DEFAULT_TIMEOUT = 10000;

    public static final String MESSAGE_RECEIVED_ACTION = "jpush.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";
    public static final String DATA_SELECTED = "dataSelected";
    public static final String DATA_UNSELECTED = "dataUnselected";
}
