package assignment9;

import java.util.List;

import assignment9.Shape.shapeType;

public class Factory {

	/**
	 * Method to return the object of the shape created
	 * @param type,type of the shape such as rectangle, square
	 * @param point,origin of the shape
	 * @param parameters,list of parameters of the shape such as its length, width depends upon the type of the shape
	 * @return shape, object of the created shape
	 */
	public static Shape createShape(int id, shapeType type, Point point, List<Double> parameters) {
		Shape shape = null;
		try {
			if (type == null || point == null || parameters == null) {

			}
			switch (type) {
			case Rectangle:
				shape = new Rectangle(id, type, point, parameters);
				break;
			case Circle:
				shape = new Circle(id, type, point, parameters);
				break;

			case Square:
				shape = new Square(id, type, point, parameters);
				break;

			case Triangle:
				shape = new Triangle(id, type, point, parameters);
				break;

			default:
				throw (new Exception("Enter correct shape type !!"));
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());

		}
		return shape;
	}

}
