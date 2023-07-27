package exHandling_javaDocs_Annotation;

/**
 * @author jagat
 * @version 1.0
 * @since  2023
 */
public class AreaOfShapes {

	public static void main(String[] args) {
	 Shape shape = new Shape();
	 double length = 34, bredth = 4;
	 System.out.println("Area of rectangle of length "+length+"cm and bredth "+bredth+"cm = "+shape.Rectangle(length, bredth));
	 
	 double r = 34;
	 System.out.println("Area of circle of radius "+r+"cm = "+shape.Circle(r));
	 
	 double base = 04, height = 14;
	 System.out.println("Area of triangle of base "+base+"cm and height "+height+"cm = "+shape.Triangle(base, height));
	}

}

class Shape{
	/**
	 * Calculate the area of the rectangle using the formula: length * breadth
	 * @param a The length of the rectangle
	 * @param b The breadth of the rectangle
	 * @return The area of the rectangle
	 * @throws IlligalArgumentException if the length or bredth is not positive.
	 */
	double Rectangle(double a, double b)
	{
		if(a<=0 || b<= 0)
			throw new IllegalArgumentException("Length and Bredth should be positive.");
		return a*b;
	}
	
	/**
	 * Calculate the area of the radius using the formula: pie * r *r
	 * @param radius The radius of the circle
	 * @return The area of the circle
	 * @throws IlligalArgumentException if the length or bredth is not positive.
	 */
	double Circle(double radius)
	{
		if(radius<=0 )
			throw new IllegalArgumentException("Length and Bredth should be positive.");
		return 22/7*radius*radius;
	}
	
	/**
	 * Calculate the area of the triangle using the formula: (base * height)/2
	 * @param a The height of the triangle
	 * @param b The base of the triangle
	 * @return The area of the triangle
	 * @throws IlligalArgumentException if the base or height is not positive.
	 */
	double Triangle(double a, double b)
	{
		if(a<=0 || b<= 0)
			throw new IllegalArgumentException("Length and Bredth should be positive.");
		return (a*b)/2;
	}
}



/*
write a program to calculate Area of -
 Rectangle
 Circle
 Triangle
Make use of Appropriate annotations and javadoc
*/