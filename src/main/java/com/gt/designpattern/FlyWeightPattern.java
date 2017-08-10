package com.gt.designpattern;

import java.awt.Graphics;
import java.util.HashMap;

/*
 * 
 * Flyweight design pattern is used when we need to create a lot of Objects of a class.
 *  Since every object consumes memory space that can be crucial for low memory devices, 
 *  such as mobile devices or embedded systems, flyweight design pattern can be applied to reduce the load on memory by sharing objects.
 * 
 * The number of Objects to be created by application should be huge.
The object creation is heavy on memory and it can be time consuming too.
The object properties can be divided into intrinsic and extrinsic properties,
 extrinsic properties of an Object should be defined by the client program.
To apply flyweight pattern, we need to divide Object property into intrinsic and extrinsic properties.
 Intrinsic properties make the Object unique whereas extrinsic properties are set by client code and used to perform different operations.
  For example, an Object Circle can have extrinsic properties such as color and width.

For applying flyweight pattern, we need to create a Flyweight factory that returns the shared objects. 
For our example, lets say we need to create a drawing with lines and Ovals. So we will have an interface Shape and its concrete implementations as Line and Oval. 
Oval class will have intrinsic property to determine whether to fill the Oval with given color or not whereas Line will not have any intrinsic property.
 */

public class FlyWeightPattern {

}

 interface FlyShape {

	public void draw(Graphics g, int x, int y, int width, int height, java.awt.Color color);
}

 class FlyLine implements FlyShape {

	public FlyLine() {
		System.out.println("Creating Line object");
		// adding time delay
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics line, int x1, int y1, int x2, int y2, java.awt.Color color) {
		line.setColor(color);
		line.drawLine(x1, y1, x2, y2);
	}

}

 class Oval implements FlyShape {

	// intrinsic property
	private boolean fill;

	public Oval(boolean f) {
		this.fill = f;
		System.out.println("Creating Oval object with fill=" + f);
		// adding time delay
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics circle, int x, int y, int width, int height, java.awt.Color color) {
		circle.setColor(color);
		circle.drawOval(x, y, width, height);
		if (fill) {
			circle.fillOval(x, y, width, height);
		}
	}


}

 class FlyShapeFactory {

	private static final HashMap<ShapeType, FlyShape> shapes = new HashMap<ShapeType, FlyShape>();

	public static FlyShape getShape(ShapeType type) {
		FlyShape shapeImpl = shapes.get(type);

		if (shapeImpl == null) {
			if (type.equals(ShapeType.OVAL_FILL)) {
				shapeImpl = new Oval(true);
			} else if (type.equals(ShapeType.OVAL_NOFILL)) {
				shapeImpl = new Oval(false);
			} else if (type.equals(ShapeType.LINE)) {
				shapeImpl = new FlyLine();
			}
			shapes.put(type, shapeImpl);
		}
		return shapeImpl;
	}

	public static enum ShapeType {
		OVAL_FILL, OVAL_NOFILL, LINE;
	}
}
