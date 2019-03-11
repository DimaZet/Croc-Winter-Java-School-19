import java.util.ArrayList;

public class task2 {
	public static void main(String[] argc) throws Exception {
		HSV hsv1 = new HSV(50, 70, 30);
		System.out.println(hsv1);
		System.out.println(hsv1.toRgb());

		ColorPalette myPalette = new ColorPalette();
		myPalette.add(new RGB(255, 0, 0));
		myPalette.add(new RGB(188, 0, 209));
		myPalette.add(new HSV(94, 100, 82));
		ColorModel closeToRed = new RGB(250, 6, 6);
		System.out.println(myPalette.colorCloseTo(closeToRed));
	}
}

abstract class ColorModel {
	public abstract RGB toRgb() throws Exception;
}

class HSV extends ColorModel {
	private int hue;	// 0-360 color tone
	private int saturation; // 0-100
	private int value;	// 0-100 color value (Brightness)
	@Override
	public RGB toRgb() throws Exception {
		int H_i = hue / 60 % 6;
        double V_min = (100 - saturation) * value / 100.0;
        double a =  (hue % 60) / 60.0 * (value - V_min);
        double V_inc = V_min + a;
        double V_dec = value - a;
        double R = 0, G = 0, B = 0;
		switch (H_i) {
			case 0: R = value; G = V_inc; B = V_min; break;
			case 1: R = V_dec; G = value; B = V_min; break;
			case 2: R = V_min; G = value; B = V_inc; break;
			case 3: R = V_min; G = V_dec; B = value; break;
			case 4: R = V_inc; G = V_min; B = value; break;
			case 5: R = value; G = V_min; B = V_dec; break;
			default: System.out.println("toRgb case");
		}
		return new RGB((int)(R*255/100), (int)(G*255/100), (int)(B*255/100));
	}
	@Override
	public String toString() { return "HSV[" + hue + "][" + saturation + "][" + value + "]"; }
	public HSV () { hue = 0; saturation = 0; value = 100;}
	public HSV (int h, int s, int v) throws Exception {
		setHue(h); setSaturation(s); setValue(v);
	}

	public void setHue(int hue) throws Exception {
		if ((0 <= hue) && (hue < 360))
			this.hue = hue;
		else
			throw new Exception("set hue out of range");
	}
	public void setSaturation(int saturation) throws Exception {
		if ((0 <= saturation) && (saturation <= 100))
			this.saturation = saturation;
		else
			throw new Exception("set saturation out of range");

	}
	public void setValue(int value) throws Exception {
		if ((0 <= value) && (value <= 100))
			this.value = value;
		else
			throw new Exception("set value out of range");
	}

	public int getHue() { return hue; }
	public int getSaturation() { return saturation; }
	public int getValue() { return value; }
}

class Grayscale extends ColorModel {
	private int grayBrightness;	//0 - Black -> 255 - White
	@Override
	public RGB toRgb() throws Exception {
		return new RGB(grayBrightness, grayBrightness, grayBrightness);
	}
	@Override
	public String toString() { return "GrSc[" + grayBrightness + "]"; }
	public Grayscale() { grayBrightness = 127; }
	public Grayscale(int gb) throws Exception { setGrayBrightness(gb); }

	public void setGrayBrightness(int grayBrightness) throws Exception {
		if ((0 <= grayBrightness) && (grayBrightness < 256))
			this.grayBrightness = grayBrightness;
		else
			throw new Exception("set grayBrightness out of range");
	}
	public int getGrayBrightness() { return grayBrightness; }
}

class RGB extends ColorModel {
	private int red;
	private int green;
	private int blue;
	@Override
	public String toString() { return "RGB[" + red + "][" + green + "][" + blue + "]"; }
    @Override
    public RGB toRgb() { return this; }
	public RGB() { red = 0; green = 0; blue = 0; }
	public RGB (int r, int g, int b) throws Exception { setRed(r); setGreen(g); setBlue(b); }
	public void setRed(int red) throws Exception {
		if((red >= 0) && (red <= 255))
			this.red = red;
		else
			throw new Exception("set red out of range");
	}
	public void setGreen(int green) throws Exception {
		if((green >= 0) && (green <= 255))
			this.green = green;
		else
			throw new Exception("set green out of range");
	}
	public void setBlue(int blue) throws Exception {
		if((blue >= 0) && (blue <= 255))
			this.blue = blue;
		else
			throw new Exception("set blue out of range");
	}

	public int getRed() { return red; }
	public int getGreen() { return green; }
	public int getBlue() {	return blue; }
}

class ColorPalette extends ArrayList<ColorModel> {

	public static double rgbDistance(ColorModel A, ColorModel B) throws Exception {
		double d_r = A.toRgb().getRed() - B.toRgb().getRed();
		double d_g = A.toRgb().getGreen() - B.toRgb().getGreen();
		double d_b = A.toRgb().getBlue() - B.toRgb().getBlue();
		return Math.sqrt( d_r*d_r + d_g*d_g + d_b*d_b );
	}

	public ColorModel colorCloseTo( ColorModel sample) throws Exception {
		if (this.size() == 0)
			throw new Exception("empty ColorPalette");
		ColorModel closest = this.get(0);
		double d_min = rgbDistance(this.get(0), sample);
		for (ColorModel c: this) {
			if (rgbDistance(c, sample) < d_min) {
				closest = c;
				d_min = rgbDistance(c, sample);
			}
		}
		return closest;
	}
}
