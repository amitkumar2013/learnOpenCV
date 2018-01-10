package learnOpenCV.util;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class ImageLoader {

	public Mat readImage(String imagePath, boolean gray) {
		// Loads an image from a file.
		Mat img = Imgcodecs.imread(imagePath,
				(gray) ? Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE : Imgcodecs.CV_LOAD_IMAGE_COLOR);
		return img;
	}

}
