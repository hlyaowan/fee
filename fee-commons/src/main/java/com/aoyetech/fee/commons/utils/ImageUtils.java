package com.aoyetech.fee.commons.utils;
//package com.xibo.uuline.commons.utils;
//
//
//
//import java.awt.AlphaComposite;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.geom.AffineTransform;
//import java.awt.image.AffineTransformOp;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//
///**
// * @author
// * 
// */
//public class ImageUtils {
//    
//    public final static int PHOTO_RATIO = 800; //缩放图片系数
//    static{
//        System.setProperty("jmagick.systemclassloader", "no");
//    }
//    /**
//     * 图片水印
//     * 
//     * @param pressImg 水印图片
//     * @param targetImg 目标图片
//     * @param x 修正值 默认在中间
//     * @param y 修正值 默认在中间
//     * @param alpha 透明度
//     */
//    public final static void pressImage(String pressImg, String targetImg,
//            int x, int y, float alpha) {
//        try {
//            File img = new File(targetImg);
//            Image src = ImageIO.read(img);
//            int wideth = src.getWidth(null);
//            int height = src.getHeight(null);
//            BufferedImage image = new BufferedImage(wideth, height,
//                    BufferedImage.TYPE_INT_RGB);
//            Graphics2D g = image.createGraphics();
//            g.drawImage(src, 0, 0, wideth, height, null);
//            // 水印文件
//            Image src_biao = ImageIO.read(new File(pressImg));
//            int wideth_biao = src_biao.getWidth(null);
//            int height_biao = src_biao.getHeight(null);
//            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
//                    alpha));
//            g.drawImage(src_biao, (wideth - wideth_biao) / 2,
//                    (height - height_biao) / 2, wideth_biao, height_biao, null);
//            // 水印文件结束
//            g.dispose();
//            ImageIO.write((BufferedImage) image, "jpg", img);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 文字水印
//     * 
//     * @param pressText 水印文字
//     * @param targetImg 目标图片
//     * @param fontName 字体名称
//     * @param fontStyle 字体样式
//     * @param color 字体颜色
//     * @param fontSize 字体大小
//     * @param x 修正值
//     * @param y 修正值
//     * @param alpha 透明度
//     */
//    public static void pressText(String pressText, String targetImg, String fontName, int fontStyle, Color color, int fontSize, int x,
//            int y, float alpha) {
//        try {
//            File img = new File(targetImg);
//            Image src = ImageIO.read(img);
//            int width = src.getWidth(null);
//            int height = src.getHeight(null);
//            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//            Graphics2D g = image.createGraphics();
//            g.drawImage(src, 0, 0, width, height, null);
//            g.setColor(color);
//            g.setFont(new Font(fontName, fontStyle, fontSize));
//            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
//            g.drawString(pressText, (width - (getLength(pressText) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);
//            g.dispose();
//            ImageIO.write((BufferedImage) image, "jpg", img);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 缩放 效果太差 ps: Graphics下的 还有 AffineTransform下的
//     * 缩放都是针对"图形"而不是"图像"的，所以处理后图片很不清晰
//     * @param filePath 图片路径
//     * @param height 高度
//     * @param width 宽度
//     * @param bb 比例不对时是否需要补白
//     */
//    public static void resizeImgcale(String filePath, int height, int width, boolean bb) {
//        try {
//            double ratio = 0.0; // 缩放比例
//            File f = new File(filePath);
//            BufferedImage bi = ImageIO.read(f);
//            Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
//            // 计算比例
//            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
//                if (bi.getHeight() > bi.getWidth()) {
//                    ratio = (new Integer(height)).doubleValue() / bi.getHeight();
//                } else {
//                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();
//                }
//                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
//                itemp = op.filter(bi, null);
//            }
//            if (bb) {
//                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//                Graphics2D g = image.createGraphics();
//                g.setColor(Color.white);
//                g.fillRect(0, 0, width, height);
//                if (width == itemp.getWidth(null))
//                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
//                            itemp.getWidth(null), itemp.getHeight(null),
//                            Color.white, null);
//                else
//                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
//                            itemp.getWidth(null), itemp.getHeight(null),
//                            Color.white, null);
//                g.dispose();
//                itemp = image;
//            }
//            ImageIO.write((BufferedImage) itemp, "jpg", f);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 计算字的长度
//     * 
//     * @param text
//     * @return
//     */
//    public static int getLength(String text) {
//        int length = 0;
//        for (int i = 0; i < text.length(); i++) {
//            if (new String(text.charAt(i) + "").getBytes().length > 1) {
//                length += 2;
//            } else {
//                length += 1;
//            }
//        }
//        return length / 2;
//    }
//
//    /**
//     * 压缩图片
//     * 
//     * @param imgsrc 源文件
//     * @param imgdist 目标文件
//     * @param widthdist 宽
//     * @param heightdist 高
//     */
//    public static void resizeImg(String imgsrc, String imgdist, int widthdist, int heightdist) {
//        try {
//            File srcfile = new File(imgsrc);
//            if (!srcfile.exists()) {
//                return;
//            }
//            Image src = javax.imageio.ImageIO.read(srcfile);
//            BufferedImage tag = new BufferedImage(widthdist, heightdist, BufferedImage.TYPE_INT_RGB);
//            /*
//             * SCALE_SMOOTH：尺寸平滑 SCALE_AREA_AVERAGING：尺度区平均 SCALE_FAST：尺度快速
//             * SCALE_REPLICATE：尺度复制
//             */
//            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);
//            FileOutputStream out = new FileOutputStream(imgdist);
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//            encoder.encode(tag);
//            out.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    /**
//     * 图片压缩
//     * @param picFrom
//     * @param picTo
//     * @param widthdist
//     * @param heightdist
//     */
////    public static void resize(String picFrom, String picTo, int widthdist, int heightdist) {
////        try {
////            ImageInfo info = new ImageInfo(picFrom);
////            MagickImage image = new MagickImage(new ImageInfo(picFrom));
////            MagickImage scaled = image.scaleImage(widthdist, heightdist);// 小图片文件的大小.
////            scaled.setFileName(picTo);
////            scaled.writeImage(info);
////        } catch (Exception ex) {
////            ex.printStackTrace();
////        }
////    }
//    
//    public static void resize(String picFrom, String picTo, int ratio) throws Exception {
//        BufferedImage bi = ImageIO.read(new File(picFrom));
//        //原始图片属性
//        int srcWidth = bi.getWidth();
//        int srcHeight = bi.getHeight();
//        //生成图片属性
//        int newWidth = srcWidth;
//        int newHeight = srcHeight;
//        //如果超出最大宽或高就压缩
//        if (srcWidth > ratio || newHeight > ratio) {
//            //生成图片width, height计算
//            if (srcWidth >= srcHeight) {
//                if (srcWidth < ratio) {
//                    return;
//                }
//                newWidth = ratio;
//                newHeight = (int)(ratio * srcHeight / srcWidth);
//            } else {
//                if (srcHeight < ratio) {
//                    return;
//                }
//                newHeight = ratio;
//                newWidth = (int)(ratio * srcWidth / srcHeight);
//            }
//        }
////        resize(picFrom, picTo, newWidth, newHeight);
//    }
//    
//    public static void resize(String picFrom, String picTo) throws Exception {
//        resize(picFrom, picTo, PHOTO_RATIO);
//    }
//
//    public static void main(String[] args) throws Exception {
//    //  resizeImg("d:/411766.jpg", "d:/411766_1.jpg", 800, 600);
//    //  resize("d:/test_4.jpg", "d:/test_4_2.jpg", 800);
//        pressText("欢喜冤家", "d:/411766.jpg", "简体", Font.ITALIC, Color.black, 90, 40, 80, 0.5f);
//    }
//
//}
