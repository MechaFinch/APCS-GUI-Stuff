package other.bouncing.objects;

/**
 * Contains utility operations for detecting collisions between basic shapes <br>
 * Credit to Jeffery Thompson <br>
 * <a href="jefferythompson.org/collision-detection">Website</a>
 * 
 * @author Alex Pickering
 */
public class CollisionUtils {
	
	/**
	 * Determines if two lines are intersecting <br>
	 * x1, y1, x2, and y2 define the first line <br>
	 * x3, y3, x4, and y4 define the second line
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @param x4
	 * @param y4
	 * @return If the two lines are intersecting
	 */
	public static boolean lineLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		//Get distances
		double aDist = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) /
					   ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1)),
			   bDist = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) /
			   		   ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1));
		
		//If aDist and bDist are between 0 and 1, they collide for some reason (I haven't looked into the maths)
		return aDist >= 0 && aDist <= 1 && bDist >= 0 && bDist <= 1;
	}
}
