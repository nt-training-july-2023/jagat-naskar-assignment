package JavaPrograms;

public class StringProgram {
    public static void main(String[] args) {
        String a = "abc";
        String b = "def";
        System.out.println("String all Programs");
        System.out.println("_____________________________________________");
        System.out.println("Different predefined function in String");
        System.out.println("Length of 'abc' = " + a.length());
        System.out.println("Concatination= " + a + b);
        System.out.println("char at 2nd position in 'abc'= " + a.indexOf(1));
        System.out.println("check if 'abc starts with b'= " + a.startsWith("b"));
        System.out.println("check if 'abc' starts with 'ab'= " + a.startsWith("ab"));
        System.out.println("Index of b in 'abc'= " + a.indexOf('b'));
        System.out.println("Replace a in 'abc' by R = " + a.replace("a", "R"));

        
        
        
        System.out.println("_____________________________________________");
        System.out.println("5 methods from string.lang");
        String kk = " He is a mad man";
        System.out.println("string.trim = " + kk.trim());
        System.out.println("toUpperCase = " + kk.toUpperCase());
        // System.out.println("isLowerrCase = "+kk.isLowerCase());
        System.out.println("String.intern = " + kk.intern());
        //System.out.println("string.spllit = "+kk.spllit());

        
        
        // equals and ==
        System.out.println("_____________________________________________");
        System.out.println("equals and == program");
        int x = 99;
        int y = 34;
        if (x == y)
            System.out.println("x==y");
        else
            System.out.println("x is not = to y");

        String as = "fsg";
        String bs = "fsg";
        System.out.println(as.equals(bs));

    }
}