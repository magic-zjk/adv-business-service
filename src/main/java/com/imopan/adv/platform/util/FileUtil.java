package com.imopan.adv.platform.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

	public static synchronized void copy(File src, File dst) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), DpSystemProperties.UPLOAD_BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst), DpSystemProperties.UPLOAD_BUFFER_SIZE);
			byte[] buffer = new byte[DpSystemProperties.UPLOAD_BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;

		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 根据字符串创建本地目录 并按照年月建立子目录返回
	 * @param path
	 * @return
	 */
	public static String getFolderByMonth(String pdir) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMM");
		String path = pdir.replace("\\", "/");
		if(!path.endsWith("/")) {
			path += "/";
		}
		path += formater.format(new Date());
		
		File dir = new File(path);
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				return pdir;
			}
		}
		return path += "/";
	}
	
}
