package learnOpenCV;

import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.Mat;

import learnOpenCV.image.LineDetector;
import learnOpenCV.image.ZoomManager;
import learnOpenCV.util.ImageLoader;
import learnOpenCV.util.ImageUtil;

public class CrackFinder {

	private static LineDetector lineMgr = new LineDetector();
	private static ZoomManager zoomMgr = new ZoomManager();
	private static boolean zoom = false;
	private static ImageLoader imgLoader = new ImageLoader();
	private static boolean debug = false;
	private static ImageUtil imgUtil = new ImageUtil();

	public static void main(String[] args) throws IOException {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String imagePath = "images/new.jpg";
		if (args != null && args.length > 0) {
			imagePath = args[0];
		}

		// Zoom
		Mat origImg = imgLoader.readImage(imagePath, false);
		if (zoom) {
			imgUtil.showResult(zoomMgr.zoomMat2Image(origImg, 2));
		}

		Mat grayImg = imgLoader.readImage(imagePath, true);
		if (debug) {
			imgUtil.showResult(grayImg);
		}

		// Canny Edge Detection
		Mat cannyImg = lineMgr.detectCannyEdges(grayImg);
		// ref.showResult(ref.Mat2BufferedImage(cannyImg));
		imgUtil.showResult(lineMgr.drawHoughLines(origImg, cannyImg));
	}

}
