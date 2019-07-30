package assignment9;

import java.util.Date;

public interface Shape {
	/**
	 * enum class to store the type of the shapes
	 */
	static enum shapeType {
		Rectangle, Square, Circle, Triangle
	};

	/**
	 * Method to calculate the area enclosed by the shape
	 * @return area, enclosed by the shape
	 */
	double getArea();

	/**
	 * Method to calculate the perimeter of the shape
	 * @return perimeter of the shape
	 */
	double getPerimeter();

	/**
	 * Method to return the origin of the shape i.e., the leftmost point of the shape
	 * @return origin, coordinates of the leftmost point
	 */
	Point getOrigin();

	/**
	 * Method to return the unique id of the object
	 * @return id of the object
	 */
	int getId();

	/**
	 * Method to return the timeStamp of the object created
	 * @return the copy of the date object
	 */
	double getDistance();

	/**
	 * Method to calculate the distance between the origin of the screen and origin of the shape
	 * @return distance between the two points
	 */
	Date getTimeStamp();

	/**
	 * Method to find if a point is enclosed by the shape or not
	 * @param point,point for which to check
	 * @return true if the given point lies inside the shape else false
	 */
	boolean isPointEnclosed(Point p);

	/**
	 * Method to return the type of the shape such as rectangle, square etc
	 * @return type of the shape
	 */
	shapeType getType();
}
