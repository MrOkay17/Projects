import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
    
    // Using scanner
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();

    // The first input to values - Integers
    int bottles = Integer.valueOf(input.substring(0, input.indexOf(" ")));
    
    // The verse 
    String bottles_verse = input.substring(input.indexOf(" ")+ 1);

    // The first word in the verse 
    String bottles_vers2 = bottles_verse.substring(0, bottles_verse.indexOf(" "));
    
    // Word alone without the last letter
    String bottle = bottles_vers2.substring(0,(bottles_vers2.length()-1));
    
    // The rest of the verse without the first word
    String bottles_vers3 = bottles_verse.substring(bottles_verse.indexOf(" "));

    // Strings - The rest of the song
    String lineOne = " on the wall";
    String lineTwo = "Take one down, pass it around";


    // For loop - looping through the lyrics
    for (int i = bottles; i > 0; i--) {
        if (i > 2) {
            System.out.println(i + " " + bottles_verse + lineOne);
            System.out.println(i + " " + bottles_verse);
            System.out.println(lineTwo);
            System.out.println(i-1 + " " + bottles_verse + lineOne);
            System.out.print("\n");
        }
        
        //Second last line loop

       else if (i == 2){
        System.out.println(i + " " +  bottles_verse + lineOne);
            System.out.println(i + " " + bottles_verse);
            System.out.println(lineTwo);
            System.out.println("One " + bottle + bottles_vers3 + lineOne);
            System.out.print("\n");
       }
        // Last line loop

        else {
            System.out.println("One " + bottle + bottles_vers3 + lineOne);
            System.out.println("One " + bottle + bottles_vers3);
            System.out.println(lineTwo);
            System.out.println("No more " + bottles_verse + lineOne);

        }
        
    }

    sc.close();

    }

}

