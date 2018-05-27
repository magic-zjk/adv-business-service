/**
 * @author FSJ
 * 2013-8-2
 */
package com.imopan.adv.platform.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/**
 * @author FSJ 2013-8-2
 */
public class ImgUtil {
	private String	inputFileName	= "";	// 输入图文件名
	private String	outputFileName	= "";	// 输出图文件名
	private int		outputWidth		= 0;	// 输出图片宽
	private int		outputHeight	= 0;	// 输出图片高
	private boolean	proportion		= true; // 是否等比缩放标记(默认为等比缩放)

	public static void main(String[] arg) {
		String str = "";

//		System.out.println("输入的图片大小：" + new File("D:\\Administrator\\Pictures\\马尔代夫.jpg").length() / 1024 + "KB");
//		str = mypic.compressPic("D:\\Administrator\\Pictures\\马尔代夫.jpg", "D:\\Administrator\\Pictures\\马尔代夫1.jpg", 220);
//		System.out.println("输出的图片大小：" + new File("D:\\Administrator\\Pictures\\马尔代夫1.jpg").length() / 1024 + "KB");
//		System.out.println(str);
//		System.out.println();
//		
//		System.out.println("输入的图片大小：" + new File("D:\\Administrator\\Pictures\\QQ图片20130802122614.gif").length() / 1024 + "KB");
//		str = mypic.compressPic("D:\\Administrator\\Pictures\\QQ图片20130802122614.gif",
//				"D:\\Administrator\\Pictures\\QQ图片201308021226141.gif", 64);
//		System.out.println("输出的图片大小：" + new File("D:\\Administrator\\Pictures\\QQ图片201308021226141.gif").length() / 1024 + "KB");
//		System.out.println(str);
//		System.out.println();
//		
//		System.out.println("输入的图片大小：" + new File("D:\\uploadapp\\cpa\\icon_ADW EX 1.3.1333.png").length() / 1024 + "KB");
//		str = mypic.compressPic("D:\\uploadapp\\cpa\\icon_ADW EX 1.3.1333.png", "D:\\uploadapp\\cpa\\icon_ADW EX 1.3.1333.png", 50, 50, false);
//		System.out.println("输出的图片大小：" + new File("D:\\uploadapp\\cpa\\icon_ADW EX 1.3.1333.png").length() / 1024 + "KB");
//		System.out.println(str);
//		System.out.println();
		
		System.out.println("输入的图片大小：" + new File("D:\\Administrator\\Pictures\\logoDd.png").length() / 1024 + "KB");
		str = new ImgUtil().compressPic("D:\\Administrator\\Pictures\\logoDd.png", "D:\\Administrator\\Pictures\\logoDd.png", 50, 50, false);
		System.out.println("输出的图片大小：" + new File("D:\\Administrator\\Pictures\\logoDd.png").length() / 1024 + "KB");
		System.out.println(str);
		System.out.println();
		
		System.out.println("输入的图片大小：" + new File("D:\\uploadapp\\cpa\\logoDd.png").length() / 1024 + "KB");
		str = new ImgUtil().compressPic("D:\\uploadapp\\cpa\\logoDd.png", "D:\\uploadapp\\cpa\\logoDd.png", 50, 50, false);
		System.out.println("输出的图片大小：" + new File("D:\\uploadapp\\cpa\\logoDd.png").length() / 1024 + "KB");
		System.out.println(str);
		System.out.println();
		
		System.out.println("输入的图片大小：" + new File("D:\\Administrator\\Pictures\\aaa.png").length() / 1024 + "KB");
		str = new ImgUtil().compressPic("D:\\Administrator\\Pictures\\aaa.png", "D:\\Administrator\\Pictures\\aaa.png", 50, 50, false);
		System.out.println("输出的图片大小：" + new File("D:\\Administrator\\Pictures\\aaa.png").length() / 1024 + "KB");
		System.out.println(str);
		System.out.println();
		
		System.out.println("输入的图片大小：" + new File("D:\\uploadapp\\cpa\\aaa.png").length() / 1024 + "KB");
		str = new ImgUtil().compressPic("D:\\uploadapp\\cpa\\aaa.png", "D:\\uploadapp\\cpa\\aaa.png", 50, 50, false);
		System.out.println("输出的图片大小：" + new File("D:\\uploadapp\\cpa\\aaa.png").length() / 1024 + "KB");
		System.out.println(str);
		System.out.println();
	}

	// 图片处理
	private String compressPic() {
		try {
			// 获得源文件
			File file = new File(this.inputFileName);
			if (!file.exists()) {
				return this.inputFileName + " no exists";
			}
			Image sourceImage = ImageIO.read(file);
			// 判断图片格式是否正确
			if (sourceImage == null || sourceImage.getWidth(null) == -1) {
				return this.inputFileName + " not a img";
			}
			
			if(this.outputWidth == 0 && this.outputWidth == 0) {
				return "00";
			}
			
			if(this.outputWidth == 0 && this.outputHeight == sourceImage.getHeight(null)) {
				return "no change size";
			}
			
			if(this.outputWidth == 0 && this.outputWidth == sourceImage.getWidth(null)) {
				return "no change size";
			}
			
			if(this.outputHeight == sourceImage.getHeight(null) && this.outputWidth == sourceImage.getWidth(null)) {
				return "no change size";
			}
			
			int newWidth = 0;
			int newHeight = 0;
			// 判断是否是等比缩放
			if (this.proportion == true) {
				double rate = 1.0;
				if (this.outputWidth == 0 && this.outputHeight == 0) {
					return "this.outputWidth == 0 && this.outputHeight == 0";
				} else if (this.outputWidth == 0) {
					rate = ((double) sourceImage.getHeight(null)) / (double) this.outputHeight;
				} else if (this.outputHeight == 0) {
					rate = ((double) sourceImage.getWidth(null)) / (double) this.outputWidth;
				} else {
					// 为等比缩放计算输出的图片宽度及高度
					double rate1 = ((double) sourceImage.getWidth(null)) / (double) this.outputWidth;
					double rate2 = ((double) sourceImage.getHeight(null)) / (double) this.outputHeight;
					// 根据缩放比率大的进行缩放控制
					rate = rate1 > rate2 ? rate1 : rate2;
				}
				newWidth = (int) (((double) sourceImage.getWidth(null)) / rate);
				newHeight = (int) (((double) sourceImage.getHeight(null)) / rate);
			} else {
				newWidth = this.outputWidth; // 输出的图片宽度
				newHeight = this.outputHeight; // 输出的图片高度
			}

			// [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
			String imgType = this.outputFileName.substring(this.outputFileName.lastIndexOf(".") + 1);
			int bitype = BufferedImage.TYPE_INT_RGB;
			if ("png".equalsIgnoreCase(imgType)) {
				bitype = BufferedImage.TYPE_INT_ARGB;
			}
			BufferedImage bufferedImage = new BufferedImage(newWidth, newHeight, bitype);
			// Image.SCALE_SMOOTH 的缩略算法生成缩略图片的平滑度的优先级比速度高， 生成的图质量比较好，但速度慢
			bufferedImage.getGraphics().drawImage(sourceImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0,
					null);
			ImageIO.write(bufferedImage, imgType, new File(this.outputFileName));
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "OK";
	}

	/**
	 * 等比例压缩成指定的宽度
	 * 
	 * @param inputFileName
	 * @param outputFileName
	 * @param outputWidth
	 * @return
	 */
	public String compressPic(String inputFileName, String outputFileName, int outputWidth) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
		this.outputWidth = outputWidth;
		this.proportion = true;
		return compressPic();
	}

	/**
	 * 压缩成指定的宽度、高度，如果等比例就按压缩比例大的
	 * 
	 * @param inputFileName
	 * @param outputFileName
	 * @param outputWidth
	 * @param outputHeight
	 * @param proportion
	 * @return
	 */
	public String compressPic(String inputFileName, String outputFileName, int outputWidth, int outputHeight, boolean proportion) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
		this.proportion = proportion;
		this.outputWidth = outputWidth;
		this.outputHeight = outputHeight;
		return compressPic();
	}

}
