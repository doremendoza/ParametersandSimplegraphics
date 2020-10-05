import java.awt.Color;

import acm.graphics.GCanvas;
import acm.graphics.GOval;
import acm.program.*;
import acm.util.RandomGenerator;


public class RandomCircles extends GraphicsProgram {
	public void run() {

		addTenCirclesToCanvas();
	}
	public void addTenCirclesToCanvas() {
		addCirclesToCanvas(10);
	}
	public void addCirclesToCanvas(int numOfCircles) {
		
		GCanvas canvas = getColoredCanvas(Color.white);
		
		for(int i = 0; i <= numOfCircles; i++) {
			GOval theCircle = getRandomCircle();
			canvas.add(theCircle);
		}
		
	}

	public GOval getRandomCircle() {
		GOval randomSizedCircle = getCircleOfRandomSizeAndLocation();
		randomSizedCircle = getColoredCircle(randomSizedCircle);
		
		return randomSizedCircle;
	}

	public GCanvas getColoredCanvas(Color color) {
		GCanvas canvas = this.getGCanvas();
		canvas.setBackground(color);

		return canvas;
	}

	public GOval getColoredCircle (GOval aCircle) {
		
		Color randomColor = getRandomColor();
		
		aCircle.setColor(randomColor);
		aCircle.setFillColor(randomColor);
		aCircle.setFilled(true);
		aCircle.setVisible(true);
		
		return aCircle;
	}
	public GOval getCircleOfRandomSizeAndLocation() {
		double radiusMax = 50;
		double radiusMin = 5;
		double radius = getRandomDouble(radiusMin * 2, radiusMax * 2);
		double circleSize = radius * 2;
		double x = getBounds(getWidth(), radius);
		double y = getBounds(getHeight(), radius);
		GOval theCircle = new GOval(x, y, circleSize, circleSize);
		return theCircle;
	}

	public Color getRandomColor()  {
		RandomGenerator random = new RandomGenerator();
		
		return random.nextColor();
	}

	public double getRandomDouble(double min, double max) {
		RandomGenerator random = new RandomGenerator();
		
		return random.nextDouble(min, max);
	}
	

	public double getBounds(double limitation, double radius) {
		double bounds = getRandomDouble(0, (limitation - radius * 2));
		
		return bounds;
	}
	
}
