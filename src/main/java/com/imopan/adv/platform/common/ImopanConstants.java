package com.imopan.adv.platform.common;

/**
 * ClassName: ImopanConstants <br/>
 * Desc:(常量类)
 * date: 2016年1月24日 下午3:15:46 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class ImopanConstants{
	
	private final static String LOGGER_PREFIX="ADV_BUSINESS_SERVICE";
	//log
	public final static String LOGGER_PREFIX_ERROR="ERROR_PG_"+LOGGER_PREFIX+".|";
	
	public final static String LOGGER_PREFIX_DEBUG="DEBUG_PG_"+LOGGER_PREFIX+".|";
	
	public final static String LOGGER_PREFIX_INFO="INFO_PG_"+LOGGER_PREFIX+".|";
	
	public final static String LOGGER_PREFIX_WARN="WARN_PG_"+LOGGER_PREFIX+".|";
	
	//advtype 广告类型
	/**
	 * IMOPAN_ADV_TYPE_BANNER:广告类型常量,banner
	 */
	public final static int IMOPAN_ADV_TYPE_BANNER=1;
	/**
	 * IMOPAN_ADV_TYPE_BANNER:广告类型常量,插屏
	 */
	public final static int IMOPAN_ADV_TYPE_CHAPING=2;
	/**
	 * IMOPAN_ADV_TYPE_BANNER:广告类型常量,积分墙
	 */
	public final static int IMOPAN_ADV_TYPE_JIFENQIANG=3;
	//NET_TYPE 网络类型常量
	/**
	 * IMOPAN_NET_TYPE_WIFI:网络类型常量,WIFI
	 */
	public final static int IMOPAN_NET_TYPE_WIFI=1;
	/**
	 * IMOPAN_NET_TYPE_GPRS:网络类型常量,GPRS
	 */
	public final static int IMOPAN_NET_TYPE_GPRS=2;
	/**
	 * IMOPAN_NET_TYPE_OTHERS:网络类型常量,OTHERS
	 */
	public final static int IMOPAN_NET_TYPE_OTHERS=3;
	
	
	//redis_prefix
	/**
	 * IMOPAN_REDIS_PREFIX_MEDIADISCOUNT:redis 媒体扣量前缀
	 * 操作redis key  imopan:media field  productId  例如  imopan:media   900 媒体id
	 */
	public final static String IMOPAN_REDIS_PREFIX_MEDIADISCOUNT="imopan:media";
	
	/**
	 * IMOPAN_REDIS_PREFIX_APPSOTREINFO：redis AppStoreInfo前缀
	 */
	public static final String IMOPAN_REDIS_PREFIX_APPSOTREINFO="imopan:appsotreinfo";
	
	/**
	 * appstoreinfo key 过期时间
	 */
	public static final int APPSOTREINFO_KEY_EXPIRE_TIME = 86400;//seconds 24*60*60
	
	/**
	 * IMOPAN_REDIS_PREFIX_ADVIDEA:redis 广告创意前缀
	 * 操作redis key  imopan:advert field  ideaid  例如  imopan:advert   84 创意id
	 */
	public final static String IMOPAN_REDIS_PREFIX_ADVIDEA="imopan:advert";
	
	/**
	 * IMOPAN_REDIS_PREFIX_PUT_PRICE 投放单价
	 */
	public final static String IMOPAN_REDIS_PREFIX_PUT_PRICE="imopan:put:price";
	/**
	 * IMOPAN_REDIS_PREFIX_PUT_NUM 投放数量
	 */
	public final static String IMOPAN_REDIS_PREFIX_PUT_NUM="imopan:put:num";
	
	//日志记录-->模块id
	/**
	 * IMOPAN_MODULES_CP:业务模块-->广告主
	 */
	public final static int IMOPAN_MODULES_CP=1;
	/**
	 * IMOPAN_MODULES_CHANNEL:业务模块-->渠道管理
	 */
	public final static int IMOPAN_MODULES_CHANNEL=2;
	/**
	 * IMOPAN_MODULES_THROWIN:业务模块-->投放管理
	 */
	public final static int IMOPAN_MODULES_THROWIN=3;
	/**
	 * IMOPAN_MODULES_DEVELOPER:业务模块-->开发者管理
	 */
	public final static int IMOPAN_MODULES_DEVELOPER=4;
	/**
	 * IMOPAN_MODULES_MEDIA:业务模块-->媒体管理
	 */
	public final static int IMOPAN_MODULES_MEDIA=5;
	/**
	 * IMOPAN_MODULES_DATA:业务模块-->数据管理
	 */
	public final static int IMOPAN_MODULES_DATA=6;
	/**
	 * IMOPAN_MODULES_FINCIANCE:业务模块-->财务对账
	 */
	public final static int IMOPAN_MODULES_FINCIANCE=7;
	/**
	 * IMOPAN_MODULES_SYSTEM:业务模块-->系统设置
	 */
	public final static int IMOPAN_MODULES_SYSTEM=8;
	
	//日志记录-->业务类型
	/**
	 * IMOPAN_BIZ_TYPE_ADD:操作类型-->新增
	 */
	public final static int IMOPAN_BIZ_TYPE_ADD=1;
	/**
	 * IMOPAN_BIZ_TYPE_UPDATE:操作类型-->修改
	 */
	public final static int IMOPAN_BIZ_TYPE_UPDATE=2;
	/**
	 * IMOPAN_BIZ_TYPE_DELTET:操作类型-->删除
	 */
	public final static int IMOPAN_BIZ_TYPE_DELTET=3;
	
	//日志记录-->业务标记  ResultBean中,bizstatus由后台返回给前台标识业务种类
	/**
	 * IMOPAN_BIZ_STATUS_GET:业务标记-->此操作是查询用于回显告知前台缓存
	 */
	public final static int IMOPAN_BIZ_STATUS_GET=1;
	/**
	 * IMOPAN_BIZ_STATUS_UPDATE:业务标记-->此操作是修改操作告知前台对比缓存做日志记录
	 */
	public final static int IMOPAN_BIZ_STATUS_UPDATE=2;
	/**
	 * IMOPAN_BIZ_STATUS_ADD:业务标记-->此操作是新增操作告知前台做日志记录
	 */
	public final static int IMOPAN_BIZ_STATUS_ADD=3;
	/**
	 * IMOPAN_BIZ_STATUS_DELETE:业务标记-->此操作是删除操作告知前台做日志记录
	 */
	public final static int IMOPAN_BIZ_STATUS_DELETE=4;
	
	//MQ-->消息队列量通知
	
	/**
	 * IMOPAN_MQ_NOTIFY_QUEUE_NAME:消息队列量通知-->修改广告组限量时 queue名字
	 */
	public final static String IMOPAN_MQ_NOTIFY_QUEUE_NAME="zpv3_queue";
	
	
}
