package com.imopan.adv.platform.mapper;

/**
 * ClassName: ToolMapper <br/>
 * Desc:(工具mapper类)
 * date: 2016年2月1日 下午5:26:54 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public interface ToolMapper {
	
	/**
	 * Desc:(查询上一次插入的id). <br/>
	 * @author guochangqing
	 * @return
	 */
	int selectLastInsertId();

}