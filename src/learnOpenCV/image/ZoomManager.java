package learnOpenCV.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ZoomManager {

	public BufferedImage zoomMat2Image(Mat m, int zoomFactor) throws IOException {
		// Zoom up
		Mat dest = new Mat(m.rows() * (int) zoomFactor, m.cols() * (int) zoomFactor, m.type());
		dest = m;
		Imgproc.pyrUp(m, dest, dest.size());
		// OR
		Imgproc.resize(m, dest, dest.size(), zoomFactor, zoomFactor, Imgproc.INTER_NEAREST);

		MatOfByte matOfByte = new MatOfByte();
		// Encodes an image into a memory buffer.
		Imgcodecs.imencode(".jpg", m, matOfByte);
		byte[] byteArray = matOfByte.toArray();
		InputStream in = new ByteArrayInputStream(byteArray);
		BufferedImage bufImage = ImageIO.read(in);
		return bufImage;
	}

}
