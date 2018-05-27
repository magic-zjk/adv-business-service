package com.imopan.adv.platform.interceptor;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.InputBuffer;
import org.apache.catalina.connector.OutputBuffer;
import org.apache.tomcat.util.buf.ByteChunk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.imopan.adv.platform.common.ImopanConstants;
import com.imopan.adv.platform.util.PropertiesUtil;

/**
 * 日志拦截器
 * ClassName: LogInterceptor <br/>
 * Desc:(..)
 * date: 2016年7月8日 下午4:02:57 <br/>
 *
 * @author guochangqing
 * @version 1.0
 */
public class LogInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	/**
	 * Charset.forName("UTF-8")
	 */
	private static Charset charset = Charset.forName("UTF-8");

	public static final String isdebug = PropertiesUtil.getproperties_classpath("conf/conf.properties",
			"isdebug");
	/**
	 * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
	 * SpringMVC中的Interceptor拦截器是链式的，可以同时存在
	 * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行
	 * ，而且所有的Interceptor中的preHandle方法都会在
	 * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的
	 * ，这种中断方式是令preHandle的返 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
	 */
	// @SuppressWarnings({ "null" })
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		if (handlerMethod == null || handlerMethod.getMethodParameters() == null
				|| handlerMethod.getMethodParameters().length == 0) {
			return true;
		}
		Method method = handlerMethod.getMethod();
		if ("login".equals(method.getName())) {//登陆方法 放行
			return true;
		}
		if("1".equals(isdebug)){//调试 模式
			return true;
		}
		// session中获取用户信息
		HttpSession session = request.getSession();
		if (session != null) {
			Object user_id = session.getAttribute("user_id");
			Object user_name = session.getAttribute("user_name");
			//Object true_name = session.getAttribute("true_name");
			if (user_id != null && user_name != null ) {

			} else {//不是登陆但是没有session session失效
				logger.error(ImopanConstants.LOGGER_PREFIX_ERROR+"session中user信息为空,返回登陆页!");
				response.setStatus(900);
				return false;
			}
		} else {
			logger.error(ImopanConstants.LOGGER_PREFIX_ERROR+"session为空,返回登陆页!");
			response.setStatus(900);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 拦截方法，并将stringResult中的内容返回给前台
		// PrintWriter out = response.getWriter();
		// System.err.println(modelAndView);
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 该方法也是需要当前对应的Interceptor 的preHandle 方法的返回值为true
	 * 时才会执行。顾名思义，该方法将在整个请求结束之后，也就是在DispatcherServlet
	 * 渲染了对应的视图之后执行。这个方法的主要作用是用于进行资源清理工作的。
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"记录请求响应开始");
		// session中获取用户信息
		HttpSession session = request.getSession();
		if (session != null) {
			Object user_id = session.getAttribute("user_id");
			Object user_name = session.getAttribute("user_name");
			//Object true_name = session.getAttribute("true_name");
			if (user_id != null && user_name != null ) {
				logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"用户id,用户名|"+user_id.toString() +","+ user_name.toString());
			} 
		}
		String accessUri = request.getRequestURI();
		logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"记录请求accessUri|"+accessUri);
		String postparam = convertRequestPostByReflect(request);
		logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"记录请求入参|"+postparam);
		String postresponse = convertResponsePostByReflect(response);
		logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"记录响应出参|"+postresponse);
		logger.debug(ImopanConstants.LOGGER_PREFIX_DEBUG+"记录请求响应结束");
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * Desc:(通过反射获取请求参数). <br/>
	 * 不能通过流读取的方式 inputStream 不能读2次
	 * 
	 * @author guochangqing
	 * @param request
	 * @return
	 */
	private String convertRequestPostByReflect(HttpServletRequest request) {
		String outStr = "";
		try {
			request.setCharacterEncoding("UTF-8");
			ServletInputStream inputStream = request.getInputStream();
			Class<?> cls = Class.forName("org.apache.catalina.connector.CoyoteInputStream");
			Field field_ib = cls.getDeclaredField("ib");
			field_ib.setAccessible(true);
			InputBuffer ib = (InputBuffer) field_ib.get(inputStream);
			Class<?> cls2 = Class.forName("org.apache.catalina.connector.InputBuffer");
			Field field_bb = cls2.getDeclaredField("bb");
			field_bb.setAccessible(true);
			ByteChunk byteChunk = (ByteChunk) field_bb.get(ib);
			byteChunk.setCharset(charset);
			int length = byteChunk.getEnd();
			byte src[] = new byte[length];
			byte[] buffer = byteChunk.getBuffer();
			System.arraycopy(buffer, 0, src, 0, length);
			outStr = new String(src, "UTF-8");
 			String[] split = outStr.split("\\r\\n");
			if (split.length >= 1) {
				outStr = split[split.length - 1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outStr;
	}
	/**
	 * Desc:(通过反射获取请求参数). <br/>
	 * 不能通过流读取的方式 inputStream 不能读2次
	 * 
	 * @author guochangqing
	 * @param request
	 * @return
	 */
	private String convertResponsePostByReflect(HttpServletResponse response) {
		String outStr = "";
		try {
			response.setCharacterEncoding("UTF-8");
			ServletOutputStream outputStream = response.getOutputStream();
			Class<?> cls = Class.forName("org.apache.catalina.connector.CoyoteOutputStream");
			Field field_ob = cls.getDeclaredField("ob");
			field_ob.setAccessible(true);
			OutputBuffer ob = (OutputBuffer) field_ob.get(outputStream);
			Class<?> cls2 = Class.forName("org.apache.catalina.connector.OutputBuffer");
			Field field_bb = cls2.getDeclaredField("bb");
			field_bb.setAccessible(true);
			ByteChunk byteChunk = (ByteChunk) field_bb.get(ob);
			byte[] buffer = byteChunk.getBuffer();
			Field field_bytesWritten = cls2.getDeclaredField("bytesWritten");
			field_bytesWritten.setAccessible(true);
			Long bytesWritten=field_bytesWritten.getLong(ob);
			if(bytesWritten>8182){
				return "数据过长,不记录!";
			}
			byteChunk.setCharset(charset);
			int length = bytesWritten.intValue();
			byte src[] = new byte[length];
			System.arraycopy(buffer, 0, src, 0, length);
			outStr = new String(src, "UTF-8");
			String[] split = outStr.split("\\r\\n");
			if (split.length >= 1) {
				outStr = split[split.length - 1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outStr;
	}
}
