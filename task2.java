public class task2 {
	public static void main(String[] argc) {
		HSV hsv1 = new HSV(50, 70, 30);
		System.out.println(hsv1);
		System.out.println(hsv1.toRgb());
	}
}

class ColorModel {
	public RGB toRgb();
}

class HSV extends ColorModel {
	private int hue;	// 0-360 color tone
	private int saturation; // 0-100
	private int value;	// 0-100 color value (Brightness)

	public RGB toRgb() {
		int H_i = hue / 60 % 6;
		int V_min = (100 - saturation) * value / 100;
		int a =  (hue % 60) / 60 * (value - V_min);
		int V_inc = V_min + a;
		int V_dec = value - a;
		int R = 0, G = 0, B = 0;
		switch (H_i) {
			case 0: R = value; G = V_inc; B = V_min; break;
			case 1: R = V_dec; G = value; B = V_min; break;
			case 2: R = V_min; G = value; B = V_inc; break;
			case 3: R = V_min; G = V_dec; B = value; break;
			case 4: R = V_inc; G = V_min; B = value; break;
			case 5: R = value; G = V_min; B = V_dec; break;
			default: System.out.println("toRgb case");
		}
		return new RGB(R*255/100, G*255/100, B*255/100);
	}
	
	public HSV (int h, int s, int v) {
		hue = h; saturation = s; value = v;
	}

	public String toString() {
		return "HSV[" + hue + "][" + saturation + "][" + value + "]";
	}
}

class Grayscale extends ColorModel {
	private byte grayBrightness;	//0 - Black -> 255 - White
	
	public RGB toRgb() {
		// ToDo
	}
	
	public String toString() {
		return "GrSc[" + grayBrightness + "]";
	}

	public Grayscale() {
		grayBrightness = 127;
	}

	public Grayscale(int gb) {
		grayBrightness = (byte) gb;
	}
}

class RGB extends ColorModel {
	private int red;
	private int green;
	private int blue;
	public RGB() {
		red = 0; green = 0; blue = 0;
	}
	public RGB (int r, int g, int b) {
		red = r; green = g; blue = b;
	}
	public String toString() {
		return "RGB[" + red + "][" + green + "][" + blue + "]";
	}
}
