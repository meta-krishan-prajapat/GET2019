package assignment9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import assignment9.Shape.shapeType;

public class Screen {
	private int xMax, yMax;
	private List<Shape> listOfShapes=new ArrayList<>();
	private Set<Integer> shapeId = new HashSet<Integer>();
	public static AssertionError InvalidShapeType = new AssertionError(" Invalid shape type !!!");
	public static AssertionError InvalidCoordinates = new AssertionError("Invalid coordinates!!!");
	public static AssertionError InvalidId = new AssertionError("Invalid id!!!");

	/**
	 * Constructor initialises the max x-coordinate and y-coordinate of the screen
	 * @param xMax max x-coordinate
	 * @param yMax max y-coordinate
	 */
	public Screen(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;

	}

	/**
	 * Method to add shapes to the list if the user has entered correct coordinates and type of the shape
	 * @param typerepresents the type of the shape
	 * @param pointrepresents the origin point of the shape
	 * @param parameterscontains the list of parameters of the shape
	 * @return shapeObject, object of the shape created
	 * @throws InvalidId,InvalidCoordinates exception if invalid parameters are given as input
	 * @throws InvalidShapeType exception if valid shape is not entered
	 */
	public Shape addShape(int id, shapeType type, Point point, List<Double> parameters) {
		Shape shapeObject = null;
		try {
			if (type == null || point == null || parameters == null) {
				throw (new Exception("null values cant be accepted! "));
			} else {
				if (!shapeId.contains(id)) {
					shapeId.add(id);
				} else
					throw InvalidId;

				switch (type) {
				case Circle:
					// Check the validation of the input parameters
					double radius = parameters.get(0);
					double slope = Math.atan(point.getyCoordinates() / point.getxCoordinates());
					double centerDistance = Math.sqrt(point.getxCoordinates() * point.getxCoordinates()
							+ point.getyCoordinates() * point.getyCoordinates()) + radius;
					double xCenter = centerDistance * Math.cos(slope);
					double yCenter = centerDistance * Math.sin(slope);
					if (point.getxCoordinates() >= 0 && point.getyCoordinates() >= 0 && (xCenter + radius) <= xMax
							&& (yCenter + radius <= yMax)) {
						break;
					} else
						throw InvalidCoordinates;

				case Rectangle:
					// Check the validation of the input parameters
					double length = parameters.get(0);
					double width = parameters.get(1);
					if (point.getxCoordinates() >= 0 && point.getyCoordinates() >= 0
							&& (point.getxCoordinates() + length <= xMax)
							&& (point.getyCoordinates() + width <= yMax)) {
						break;
					} else
						throw InvalidCoordinates;

				case Square:
					// Check the validation of the input parameters
					double side = parameters.get(0);
					if (point.getxCoordinates() >= 0 && point.getyCoordinates() >= 0
							&& (point.getxCoordinates() + side <= xMax) && (point.getyCoordinates() + side <= yMax)) {
						break;
					} else
						throw InvalidCoordinates;

				case Triangle:
					// Check the validation of the input parameters
					double side1 = parameters.get(0);
					double side3 = parameters.get(2);
					double height = parameters.get(3);
					if (point.getxCoordinates() >= 0 && point.getyCoordinates() >= 0
							&& (point.getxCoordinates() + side1 <= xMax)
							&& (point.getxCoordinates() + Math.sqrt(side3 * side3 - height * height) <= xMax)
							&& (point.getyCoordinates() + height <= yMax)) {
						break;
					} else
						throw InvalidCoordinates;
				default:
					throw InvalidShapeType;
				}
				shapeObject = Factory.createShape(id, type, point, parameters);
				listOfShapes.add(shapeObject);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return shapeObject;

	}

	/**
	 * Method to delete a particular shape with the given id
	 * @param type    type of the shape
	 * @param shapeId unique id of the shape
	 * @return id of the deleted shape
	 * @throws InvalidId exception if id does not exists
	 */
	public int deleteShapeFromScreen(shapeType type, int shapeId) {
		int id = -1;
		try {
			if (type == null) {
				throw (new Exception("null values cant be accepted!"));
			} else {
				System.out.println(shapeId);
				for (Shape shape : listOfShapes) {
					if (shape.getType().equals(type) && shape.getId() == shapeId) {
						listOfShapes.remove(shape);
						id = shape.getId();
						break;
					}
				}
				if (id == -1)
					throw InvalidId;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return id;
	}

	/**
	 * Method to return the list of all shapes enclosing the given point 
	 * @param point input point for which to check
	 * @return shapesEnclosingPointList, list of all the shapes enclosing the point
	 * 
	 */
	public List<Shape> getShapesEnclosingPoint(Point point) {
		List<Shape> shapesEnclosingPointList = null;
		try {
			if (point == null) {
				throw (new Exception("point cant be null"));
			} else {
				shapesEnclosingPointList = new ArrayList<>();
				for (Shape shapeObject : listOfShapes) {
					if (shapeObject.isPointEnclosed(point)) {
						shapesEnclosingPointList.add(shapeObject);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return shapesEnclosingPointList;
	}

	/**
	 * Function to delete all the shapes of a given particular shape type
	 * @param type type of the shape to be deleted
	 * @return no of all the shape objects have been deleted
	 */
	int deleteAllShapeType(shapeType type) {
		int status = 0;
		try {
			if (type == null) {
				throw (new Exception("shape type cant be null"));
			} else {
				Iterator<Shape> iterator = listOfShapes.iterator();
				while (iterator.hasNext()) {
					Shape shape = iterator.next();
					if (shape.getType().equals(type)) {
						iterator.remove();
						status++;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	/**
	 * Function to sort the shapes object in the ascending order on the basis of their area
	 * @return areaList, list in the sorted order
	 */
	public List<Shape> sortByArea() {
		List<Shape> areaList = null;
		try {
			areaList = new ArrayList<Shape>(listOfShapes);
			int size = areaList.size();
			for (int i = 0; i < size - 1; i++)
				for (int j = 0; j < size - i - 1; j++)
					if (areaList.get(j).getArea() > areaList.get(j + 1).getArea()) {
						Shape tempShape = areaList.get(j);
						areaList.set(j, areaList.get(j + 1));
						areaList.set(j + 1, tempShape);
					}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return areaList;
	}

	/**
	 * Function to sort the shapes object in the ascending order on the basis of their perimeter
	 * @return perimeterList, list in the sorted order
	 */
	public List<Shape> sortByPerimeter() {
		List<Shape> perimeterList = null;
		try {
			perimeterList = new ArrayList<Shape>(listOfShapes);
			int size = perimeterList.size();
			for (int i = 0; i < size - 1; i++)
				for (int j = 0; j < size - i - 1; j++)
					if (perimeterList.get(j).getPerimeter() > perimeterList.get(j + 1).getPerimeter()) {
						Shape tempShape = perimeterList.get(j);
						perimeterList.set(j, perimeterList.get(j + 1));
						perimeterList.set(j + 1, tempShape);
					}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return perimeterList;
	}

	/**
	 * Function to sort the shapes object in the ascending order on the basis of their distance from the origin of the screen
	 * @return distanceList, list in the sorted order
	 */
	public List<Shape> sortByDistance() {

		List<Shape> distanceList = null;
		try {
			distanceList = new ArrayList<Shape>(listOfShapes);
			int size = distanceList.size();
			for (int i = 0; i < size - 1; i++)
				for (int j = 0; j < size - i - 1; j++)
					if (distanceList.get(j).getDistance() > distanceList.get(j + 1).getDistance()) {
						Shape tempShape = distanceList.get(j);
						distanceList.set(j, distanceList.get(j + 1));
						distanceList.set(j + 1, tempShape);
					}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return distanceList;
	}

	/**
	 * Function to sort the shapes object in the ascending order on the basis of their created time
	 * @return timeList, list in the sorted order
	 */
	public List<Shape> sortByTime() {
		List<Shape> timeList = null;

		try {
			timeList = new ArrayList<Shape>(listOfShapes);
			int size = timeList.size();
			for (int i = 0; i < size - 1; i++)
				for (int j = 0; j < size - i - 1; j++)
					if (timeList.get(j).getTimeStamp().after(timeList.get(j + 1).getTimeStamp())) {
						Shape tempShape = timeList.get(j);
						timeList.set(j, timeList.get(j + 1));
						timeList.set(j + 1, tempShape);
					}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return timeList;
	}

}
