package BaekJoon;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class RandomImg {
	
	public static void main(String[] args) {
		colorfulPatternImg();
		
	}
	
	public static boolean isInHeartShape(double tx, double ty) {
	    return (tx*tx + ty*ty - 1)*(tx*tx + ty*ty - 1)*(tx*tx + ty*ty - 1) - tx*tx*ty*ty*ty <= 0;
	}

	public static double distanceToHeartCenter(double tx, double ty) {
	    // 이 함수는 주어진 좌표가 심장의 중심으로부터 얼마나 떨어져 있는지를 계산합니다.
	    // 임의로 정의한 함수이므로 조정이 필요할 수 있습니다.
	    double distance = Math.sqrt(tx*tx + ty*ty);
	    if (isInHeartShape(tx, ty)) {
	        return distance;
	    } else {
	        return 2.0 - distance; // 심장 밖의 경우 거리를 반대로 계산
	    }
	}

	public static String colorfulPatternImg() {
	    Random random = new Random();
	    int width = random.nextInt(400) + 10;
	    int height = random.nextInt(400) + 10;

	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	    int centerX = width/2;
	    int centerY = height/2;

	    for (int x = 0; x < width; x++) {
	        for (int y = 0; y < height; y++) {
	            double tx = (2.0 * x - width) / width;
	            double ty = (height - 2.0 * y) / height;

	            double distanceToHeart = distanceToHeartCenter(tx, ty);

	            int colorValue1 = (int) (255 * Math.sin(distanceToHeart * 8.0));
	            int colorValue2 = (x + y) * 255 / (width + height);

	            double ratio = distanceToHeart / 1.5;
	            int colorValue3 = (int) (255 * (1 - ratio));
	            colorValue1 = Math.min(255, Math.max(0, colorValue1));
	            colorValue2 = Math.min(255, Math.max(0, colorValue2));
	            colorValue3 = Math.min(255, Math.max(0, colorValue3));
	            Color color = new Color(colorValue1, colorValue2, colorValue3);
	            image.setRGB(x, y, color.getRGB());
	        }
	    }

	    String filename = randStr() + "patternImage.png";
	    try {
	        ImageIO.write(image, "png", new File("C:\\Temp\\uploads\\" + filename));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return filename;
	}

	public static String randStr() {
	    Random rand = new Random();
	    int len = rand.nextInt(50) + 10; // 공백을 제거
	    char[] str = new char[len];
	    for (int i = 0; i < len; i++) {
	        int alpha = rand.nextInt(26);
	        boolean cap = rand.nextBoolean();
	        char c;
	        if (cap) {
	            c = (char) (alpha + 'A');
	        } else {
	            c = (char) (alpha + 'a');
	        }
	        str[i] = c;
	    }

	    return new String(str);
	}

}
