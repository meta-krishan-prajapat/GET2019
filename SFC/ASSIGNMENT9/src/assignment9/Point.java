package assignment9;

public class Point {
	private double xCoordinates;
	public double yCoordinates;
	/**
	 * @return the y coordinate of a particular point.
	 */
	public double getyCoordinates() {
		return yCoordinates;
	}
	
	/**
	 * @return the x coordinate of a point
	 */
	public double getxCoordinates() {
		return xCoordinates;
	}
	
	/**
	 * @param xCoordinates is the x coordinate of a point
	 * @param yCoordinates is the y coordinate of a point
	 */
	public Point(double xCoordinates , double yCoordinates)
	{
		try
		{
		this.xCoordinates=xCoordinates;
		this.yCoordinates=yCoordinates;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
