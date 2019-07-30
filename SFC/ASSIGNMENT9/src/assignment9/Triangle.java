package assignment9;

import java.util.Date;
import java.util.List;

public class Triangle implements Shape {
	private Point origin = null;
	private double side1;
	private double side2;
	private double side3;
	private double height = 0.0;
	private shapeType type = null;
	private Date timestamp = null;
	private int id;

	public Triangle(int id, shapeType type, Point origin, List<Double> parameters) {
		try {
			if (parameters == null || type == null || origin == null) {
				throw (new Exception("values can't be null"));
			}
			this.origin = origin;
			this.side1 = parameters.get(0);
			this.side2 = parameters.get(1);
			this.side3 = parameters.get(2);
			this.height = parameters.get(3);
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
		double tempArea = 0.0, halfOfPerimeter = 0.0;
		try {
			halfOfPerimeter = getPerimeter() / 2;
			tempArea = halfOfPerimeter * (halfOfPerimeter - side1) * (halfOfPerimeter - side2)
					* (halfOfPerimeter - side3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Math.sqrt(tempArea);

	}

	/**
	 * Method to calculate the perimeter of the shape
	 * @return perimeter of the shape
	 */
	@Override
	public double getPerimeter() {
		return (side1 + side2 + side3);
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
				throw (new Exception("point can't be null"));
			} else {
				double pointX1 = origin.getxCoordinates();
				double pointY1 = origin.getyCoordinates();
				double pointX2 = pointX1 + side1;
				double pointX3 = Math.sqrt(side3 * side3 - height * height) + pointX1;
				double pointY3 = pointY1 + height;
				// pointY2 is same as pointY1
				Point point1 = new Point(pointX1, pointY1);
				Point point2 = new Point(pointX2, pointY1);
				Point point3 = new Point(pointX3, pointY3);
				double area1 = getAreaByVertices(point1, point2, point);
				double area2 = getAreaByVertices(point2, point, point3);
				double area3 = getAreaByVertices(point1, point3, point);

				double area = getArea();

				double summedArea = area1 + area2 + area3;
				if (area == summedArea) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	/**
	 * Method to calculate the area of triangle using vertices of triangle
	 * @return area of triangle
	 */

	private double getAreaByVertices(Point point1, Point point2, Point point3) {
		double area = 0.0;
		try {
			if (point1 == null || point2 == null || point3 == null) {
				throw (new Exception("points can't be null"));
			} else {
				area = Math.abs(point1.getxCoordinates() * (point2.getyCoordinates() - point3.getyCoordinates())
						+ point2.getxCoordinates() * (point3.getyCoordinates() - point1.getyCoordinates())
						+ point3.getxCoordinates() * (point1.getyCoordinates() - point2.getyCoordinates())) / 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return area;
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
