package com.imopan.adv.platform.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.imopan.adv.platform.common.ImopanConstants;
import com.imopan.adv.platform.common.ResultBean;

/**
 * ClassName: ImopanControllerAdvice <br/>
 * Desc:(全局异常处理类)
 * date: 2016年1月24日 下午3:46:41 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
@ControllerAdvice
public class ImopanControllerAdvice {
	
	private static Logger logger = LoggerFactory.getLogger(ImopanControllerAdvice.class);
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultBean handleIOException(Exception e) {
    	String operation = "出现imopan全局异常";
    	ResultBean ret = null;
    	logger.error(ImopanConstants.LOGGER_PREFIX_ERROR + operation + "e.getMessage()="+e.getMessage(), e);
    	try {
    		ImopanException imopanException = (ImopanException)e;
			ret= new ResultBean(0,imopanException.getPerrorcode(),"",imopanException.getPerrormessage());
		} catch (Exception e1) {
			ret = new ResultBean(0,-10000,"",ClassUtils.getShortName(e.getClass()) + e.getMessage());
			//e.printStackTrace();
		}
    	return ret;
    }
}