package com.imopan.adv.platform.util;

public class DpSystemProperties {

	public static final int USER_STATE_UNACTIVATE = 0; // 未激活
	public static final int USER_STATE_ACTIVATE = 1; // 激活
	public static final int USER_STATE_FREEZE = 2; // 冻结
	public static final int USER_STATE_DEL = 3; // 删除

	public static final String USER_TYPE_ADV_STR = "adv"; // 广告主
	public static final String USER_TYPE_APP_STR = "app"; // 应用开发者
	public static final String USER_TYPE_SITE_STR = "site"; // 网站主

	public static final String BANNER_RES_TYPE_TEXT = "210102"; // 文字
	public static final String BANNER_RES_TYPE_PHOTO = "210101"; // 图片

	public static final String BANNER_PAY_FOR_SHOW = "190101"; // 广告付费方式 按广告展示付费
	public static final String BANNER_PAY_FOR_CLICK = "190102"; // 广告付费方式 按广告点击付费
	public static final String BANNER_PAY_FOR_CPA = "190103"; // 广告付费方式 cpa
	public static final String BANNER_PAY_FOR_CPM = "190104"; // 广告付费方式 cpm
	public static final String BANNER_PAY_FOR_COMBO = "190105"; // 广告付费方式 按人次计费

	public static final String USER_LOGIN_KEY = "USER";
	public static final String USER_LOGIN_NAME_KEY = "username";
	public static final String USER_LOGIN_PWD_KEY = "userpwd";
	public static final String USER_LOGIN_TYPE_KEY = "usertype";

	// 广告条尺寸
	public static final int[][] BANNER_IMGS_WP7 = { { 50, 50 }, { 200, 200 }, { 460, 72 } };
	public static final int[][] BANNER_IMGS_AND = { { 240, 36 }, { 320, 50 }, { 480, 72 }, { 540, 100 } };
	public static final int[][] BANNER_IMGS_IOS = { { 100, 100 }, { 400, 400 }, { 640, 100 }, { 920, 144 }, { 1536, 144 } };

	public static final int[] ICOSIZE = { 72, 72 };

	public static final String BANNER_DEFAULT_END_DATE = "2020-12-31 00:00:00";

	public static final int UPLOAD_BUFFER_SIZE = (16 * 1024);

	public static final long UPLOAD_MAX_SIZE = (1024 * 1024 * 2); // 文件上传最大2M

	public static final String[] linecolor = { "#669900", "#6666FF", "#663399", "#666600", "#66ff66", "#99FFFF", "#339900",
			"#6666FF", "#669900", "#6666FF" };
}
