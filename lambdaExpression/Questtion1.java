package lambdaExpression;



public class Questtion1 {


	//main function
	public static void main(String[] args) {
		String s = "AfoxInTheWell";
		System.out.println("Original String: "+s);
		System.out.println("Replacing vowels with #");
		
		//lambda function of ReplaceFunction class
		ReplaceString replaceString = (String ss)->{
			//testing replace()
			
			String kkString = ss.replace("e", "#");
			System.out.println("= "+kkString);
			//using replaceAll()
			String kString = ss.replaceAll("[aeiouAEIOU]", "#");
			
			return kString;
		};
		
		System.out.println(replaceString.replace(s));
		
	}

}


interface ReplaceString{
	public String replace(String s);
}