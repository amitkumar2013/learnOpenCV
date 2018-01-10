package learnOpenCV.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;

public class ImageUtil {

	public BufferedImage Mat2BufferedImage(Mat m) {
		// First read
		int type = (m.channels() > 1) ? BufferedImage.TYPE_3BYTE_BGR : BufferedImage.TYPE_BYTE_GRAY;
		byte[] b = new byte[m.channels() * m.cols() * m.rows()];
		m.get(0, 0, b); // get all the pixels

		// Now write
		BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);

		return image;
	}

	public void showResult(Mat matImg) {
		showResult(Mat2BufferedImage(matImg));
	}

	public void showResult(BufferedImage img) {
		try {
			JFrame frame = new JFrame();
			frame.getContentPane().add(new JLabel(new ImageIcon(img)));
			frame.pack();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
