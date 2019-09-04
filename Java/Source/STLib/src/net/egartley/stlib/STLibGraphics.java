package net.egartley.stlib;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class STLibGraphics {

	/**
	 * Returns a {@link BufferedImage} that is "cut" at the given point from
	 * {@code sheet}.
	 * 
	 * @param sheet
	 *            The "master", or main BufferedImage to "cut" from.
	 * @param x
	 *            X coordinate.
	 * @param y
	 *            Y coordinate.
	 * @param w
	 *            Width in which to "cut".
	 * @param h
	 *            Height in which to "cut".
	 * @return The "cut" {@link BufferedImage} from {@code sheet}.
	 */
	public BufferedImage getCroppedImage(BufferedImage sheet, int x, int y, int w, int h) {
		return sheet.getSubimage(x, y, w, h);
	}

	/**
	 * Loads an image file into the return {@link BufferedImage}. This has only
	 * been tested with .png images, but it should work with .jpg and .gif as
	 * well.
	 * 
	 * @param file
	 *            {@link java.io.File} of the image
	 * @return {@link BufferedImage} loaded in from {@code file}. Returns
	 *         {@code null} if anything went wrong.
	 */
	public BufferedImage loadImage(File file) {
		try {
			return ImageIO.read(getClass().getResource(file.getAbsolutePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Loads an image file into the return {@link BufferedImage}. This has only
	 * been tested with .png images, but it should work with .jpg and .gif as
	 * well.
	 * 
	 * @param path
	 *            Absolute/relative path of the image
	 * @return {@link BufferedImage} loaded in from the file at {@code path}.
	 *         Returns {@code null} if anything went wrong.
	 */
	public BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Calculates if the the pixel at the given point (within {@code i}) is
	 * transparent or not.
	 * 
	 * @param x
	 *            X coordinate of the pixel
	 * @param y
	 *            Y coordinate of the pixel
	 * @param i
	 *            {@link BufferedImage} where pixel is located
	 * @return True if the pixel's alpha is 0, false otherwise.
	 */
	public boolean isPixelTransparent(int x, int y, BufferedImage i) {
		int pixel = i.getRGB(x, y);
		if ((pixel >> 24) == 0x00) {
			return true;
		}
		return false;
	}

	/**
	 * Decides if the given area, or target, is currently visible within the
	 * given window dimensions. If target is just 1 pixel out of view, then it
	 * still counts as visible, but if target is two or more pixels out of view,
	 * false is returned.
	 * 
	 * @param x
	 *            X coordinate of the wanted point within the "target".
	 * @param y
	 *            Y coordinate of the wanted point within the "target".
	 * @param w
	 *            Width of the "target"
	 * @param h
	 *            Height of the "target"
	 * @param windowW
	 *            Width of the view window.
	 * @param windowH
	 *            Height of the view window.
	 * @return True if said point within the "target" is visible within the
	 *         specified view window, false otherwise.
	 */
	public boolean isVisibleWithin(int x, int y, int w, int h, int windowW, int windowH) {
		if (x >= (-w + -1) && y >= (-h + -1) && x <= windowW && y <= windowH) {
			return true;
		}
		return false;
	}

	/**
	 * Enables antialiasing in {@code g}.
	 * 
	 * @param g
	 *            {@link Graphics} in which to apply antialiasing to.
	 */
	public void enableAntiAliasing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}

	/**
	 * Returns a dialated {@link Image} of {@code srcImg}.
	 * 
	 * @param srcImg
	 *            {@link Image} in which to dialate.
	 * @param scaleWidth
	 *            Width in which to dialate.
	 * @param scaleHeight
	 *            Height in which to dialate.
	 * @return Dialated copy of {@code srcImg}.
	 */
	public static Image dialateImage(Image srcImg, int scaleWidth, int scaleHeight) {
		BufferedImage resizedImg = new BufferedImage(scaleWidth, scaleHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, scaleWidth, scaleHeight, null);
		g2.dispose();
		return resizedImg;
	}

	/**
	 * Returns a dialated {@link Image} of {@code src}.
	 * 
	 * @param src
	 *            {@link Image} in which to dialate.
	 * @param scale
	 *            Scale in which to dialate, ex. {@code 0.5} for a dialation of 1/2.
	 * @return Dialated copy of {@code src}.
	 */
	public static Image dialateImage(Image src, double scale) {
		BufferedImage resizedImg = new BufferedImage((int) scale * src.getWidth(null),
				(int) scale * src.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(src, 0, 0, (int) scale * src.getWidth(null), (int) scale * src.getHeight(null), null);
		g2.dispose();
		return resizedImg;
	}

}
