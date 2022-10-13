public class Yolo {
    
    public static void main(String[] args) {
        String x = "orange,apple,banana";

        String a = x.substring(1,9).substring(1,3);
        String b = x.substring(5,10).substring(0,2);
        String c = x.substring(5,12).substring(2,5);
        String d = x.substring(4,11).substring(4,7);
        String e = x.substring(0,6).substring(3,6);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
map.get();