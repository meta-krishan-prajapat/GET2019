package assignment3;

/**
 * @author Krishan 
 * Area class calculates the areas of triangle, rectangle,square and circle.
 */
public class Area {

	private final double PI = 3.14;

	/**
	 * method calculates area of triangle
	 * @param base   of triangle, assumes base > 0
	 * @param height of triangle, assumes height > 0
	 * @return area of triangle
	 */
	public double areaOfTriangle(double base, double height) throws Exception {

		return 0.5 * base * height;
	}

	/**
	 * method calculates area of rectangle
	 * @param width  of rectangle, assumes width > 0
	 * @param height of rectangle, assumes height > 0
	 * @return area of rectangle
	 */
	public double areaOfRectangle(double width, double height) throws Exception {

		return width * height;
	}

	/**
	 * method calculates area of square
	 * @param width of square, assumes width > 0
	 * @return area of square
	 */
	public double areaOfSquare(double width) throws Exception {

		return width * width;
	}

	/**
	 * method calculates area of circle
	 * @param radius of circle, assumes radius > 0
	 * @return area of circle
	 */
	public double areaOfCircle(double radius) throws Exception {
		return PI * radius * radius;
	}

	public static void main(String[] args) {
		try {
			Area area = new Area();
			double circleArea = area.areaOfCircle(6);
			double rectangleArea = area.areaOfRectangle(5, 6.5);
			double squareArea = area.areaOfSquare(5);
			double triangleArea = area.areaOfTriangle(20, 30);
			System.out.println("circleArea:" + circleArea);
			System.out.println("rectangleArea:" + rectangleArea);
			System.out.println("squareArea:" + squareArea);
			System.out.println("triangleArea:" + triangleArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}