package MyStudy;

public class MyStringIntern {
    public static void main(String[] args) {


        String s1 = "abc";
        String s2 = new StringBuilder("ab").append("c").toString();

        System.out.println(s1 == s2.intern());
        System.out.println(s1 == s2);



    }
}
