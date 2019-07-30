package assignment9;

import java.util.Date;
import java.util.List;

public class Rectangle implements Shape {
	private Point origin = null;
	private double length = 0.0;
	private double width = 0.0;
	private shapeType type = null;
	private Date timestamp = null;
	private int id;

	public Rectangle(int id, shapeType type, Point origin, List<Double> parameters) {
		try {
			if (parameters == null || type == null || origin == null) {
				throw (new Exception("values can't be null"));
			}

			this.origin = origin;
			this.length = parameters.get(0);
			this.width = parameters.get(1);
			this.type = type;
			this.timestamp = new Date();
			this.id = id;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Method to calculate the area enclosed by the shape
	 * @return area, enclosed by the shape
	 */
	@Override
	public double getArea() {
		double area = 0;
		try {
			area = length * width;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return area;
	}

	/**
	 * Method to calculate the perimeter of the shape
	 * @return perimeter of the shape
	 */
	@Override
	public double getPerimeter() {
		double perimeter = 0;
		try {
			perimeter = 2 * (length + width);
		} catch (Exception e) {
		}
		return perimeter;
	}

	/**
	 * Method to return the origin of the shape i.e., the leftmost point of the shape
	 * @return origin, coordinates of the leftmost point
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}

	/**
	 * Method to find if a point is enclosed by the shape or not
	 * @param point, point for which to check
	 * @return true if the given point lies inside the shape else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		try {
			if (point == null) {
				throw (new Exception("point cant be null"));
			} else if (point.getxCoordinates() >= origin.getxCoordinates()
					&& point.getyCoordinates() >= origin.getyCoordinates()
					&& point.getxCoordinates() < origin.getxCoordinates() + length
					&& point.getyCoordinates() < origin.getyCoordinates() + width) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Method to calculate the distance between the origin of the screen and origin of the shape
	 * @return distance between the two points
	 */
	@Override
	public double getDistance() {
		double distance = 0;
		try {
			distance = Math.sqrt(origin.getxCoordinates() * origin.getxCoordinates()
					+ origin.getyCoordinates() * origin.getyCoordinates());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return distance;

	}

	/**
	 * Method to return the type of the shape such as rectangle, square etc
	 * @return type of the shape
	 */
	@Override
	public shapeType getType() {
		return type;
	}

	/**
	 * Method to return the timestamp of the object created
	 * @return the copy of the date object
	 */
	@Override
	public Date getTimeStamp() {
		Date timeStamp = null;
		try {
			timeStamp = new Date(timestamp.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return timeStamp;
	}

	/**
	 * Method to return the unique id of the object
	 * @return id of the object
	 */
	@Override
	public int getId() {
		return id;
	}

}
