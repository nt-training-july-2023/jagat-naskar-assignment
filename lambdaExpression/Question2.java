package lambdaExpression;
import JavaPrograms.ABC;

public class Question2 {

	private static final Object String = null;

	public static void main(String[] args) {
		System.out.println("Create a functional interface with the"
				+ " name ‘Shape’ and a method ‘area’. Write a program"
				+ " to implement this interface for shapes, rectangle,"
				+ " square, circle, cube, sphere, cylinder and find"
				+ " out its area. All the implementation should be"
				+ " within a single class.");
		
		Shape rectangle=(Object len, Object bre)->
		{
			Double len1=Double.valueOf(len.toString());
			Double bre2=Double.valueOf(bre.toString());
			System.out.println("Area of rectangle of len = "
								+len+" and breadth = "+bre+" = "+(len1*bre2));
			
		};
		rectangle.ABC(4, 3);
		
		Shape square=(Object len, Object bre)->
		{
			Double len1=Double.valueOf(len.toString());
			Double bre2=Double.valueOf(bre.toString());
			System.out.println("Area of square of len = "
								+len+" and breadth = "+bre+" = "+(len1*len1));
			
		};
		square.ABC(4, 0);
		
		Shape circle=(Object radius, Object bre)->
		{
			Double radius1=Double.valueOf(radius.toString());
			Double bre2=Double.valueOf(bre.toString());
			System.out.println("Area of circle of radius = "
								+radius1+" = "+((22/7)*Math.pow((double) radius1, 2)));
			
		};
		circle.ABC(4, 0);
		
		
		
		Shape cube=(Object radius, Object bre)->
		{
			Double radius1=Double.valueOf(radius.toString());
			Double bre2=Double.valueOf(bre.toString());
			System.out.println("Area of cube of radius = "
								+radius1+" = "+6*Math.pow((double) radius1, 2));
			
		};
		cube.ABC(4, 0);
		
		
		Shape sphere=(Object radius, Object bre)->
		{
			Double radius1=Double.valueOf(radius.toString());
			Double bre2=Double.valueOf(bre.toString());
			System.out.println("Area of sphere of radius = "
								+radius1+" = "+(4*(22/7)*Math.pow((double) radius1, 2)));
			
		};
		sphere.ABC(4, 0);
		
		
		//2πrh+2πr2
		Shape cylinder=(Object radius, Object height)->
		{
			Double radius1=Double.valueOf(radius.toString());
			Double height1 =Double.valueOf(height.toString());
			System.out.println("Surface area of cylinder of radius = "
								+radius1+" and height "+height1+" = "+(2*(22/7)*Math.pow((double) radius1, 2)) + (2 * (22/7) * radius1 * height1));
			
		};
		cylinder.ABC(4, 5);
		
		
	}

}


@FunctionalInterface
interface Shape<side1, side2>{
	void ABC(side1 t1, side2 t2);
}