package Kattis.Tri;

import java.util.Scanner;
import java.util.arraylist;

public class Tri {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Write three integers less than 100, separeted by spaces");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (c==(a+b)){
            System.out.println(a + "+" + b + "=" +c );
        }
        
        else if (a==(b+c)){
            System.out.println(a + "=" + b + "+" +c );
        }
        
        else if (c==(a-b)){
            System.out.println(a + "-" + b + "=" +c );
        }

        else if (a==(b-c)){
            System.out.println(a + "=" + b + "-" +c );
        }

        else if (c==(a/b)){
            System.out.println(a + "/" + b + "=" +c );
        }

        else if (a==(b/c)){
            System.out.println(a + "=" + b + "/" + c );

        }
        else if (a==(b*c)){
            System.out.println(a + "=" + b + "*" + c );

        }
        else if (c==(a*b)){
            System.out.println(a + "*" + b + "=" +c );
        }
        else if((a/b)==c && (a%b)==0) System.out.println(a+"/"+b+"="+c);
       
        else if(a==(b/c)&& (b%c)==0) System.out.println(a+"="+b+"/"+c);
       
        sc.close();

    }
}

