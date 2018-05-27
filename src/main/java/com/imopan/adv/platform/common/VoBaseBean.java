package com.imopan.adv.platform.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imopan.adv.platform.exception.ImopanException;

/**
 * ClassName: VoBaseBean <br/>
 * Desc:(所有入参实体的父类提供verify方法做入参校验)
 * date: 2016年2月20日 上午11:26:50 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public abstract class VoBaseBean extends BaseBean{
	@JsonIgnore
	public abstract boolean verify(String str) throws ImopanException;
	
	public boolean canPass(String str) throws ImopanException{
		return verify(str);
	}
}
