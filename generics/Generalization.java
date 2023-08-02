package generics;

public class Generalization <T> {

	T data[] = (T[]) new Object[5];
	public static void main(String[] args) {
		Object[] objects = new Object[4];
		objects[0] = "1";
		objects[1] = 2;
		objects[2] = "3";
		objects[3] = 4;
		System.out.println(objects);
		for(Object m: objects)
			System.out.println(m.getClass()+" "+m);
		
		
		Generalization<Integer> obj = new Generalization<Integer>();
		obj.data[0] = 344;
		obj.data[1] = 4;
		obj.data[2] = (23);
		obj.data[3] = 33;
		for(Object i: obj.data) {
			System.out.println(i);
		}
		for(Integer i: obj.data)
			System.out.println(i);
	}

}
