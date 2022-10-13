import java.util.*;
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input to the first swear word
        String swear = sc.nextLine();

        // Creates a new arraylist that is called tweet
        List<String> tweets = new ArrayList<>();
       
        // Creates a whileloop that adds all the input lines / tweets to the arraylist
        while (sc.hasNextLine()) {
            tweets.add(sc.next());
            }

        // String[] test_case = "I bleeping hate those fudgesicles.".split(" ");
        
        // for (String string : test_case) {
        //     tweets.add(string);
        // }


        // An list of the swear words where it is splitted by a gap and made to lower case words only
        String[] arrayofswears = swear.toLowerCase().split(" ");

        // An array with charts that needs to replace the swearword
        String[] swearcharts = {"*", "&", "#", "$", "%"};

        // Creating an hashmap called filter that cointains a key string and a value string
        HashMap<String, String> filter = new HashMap<String, String>();

        
        
        // Forloop that puts the word into the hashmap
            
            // a forloop looking for words in our list array of swears
            for (String words : arrayofswears) {

                // Creates an interger that is 0
                int counter = 0;
                
                // Creates an empty string
                String stringwithnothing = "";

                //Another forloop that will continue too loop until the end of the word and plus count1 every time
                for (int i = 0; i < words.length(); i++, counter++) {
                    
                    //If the count is under 5 it will take the empty string and insert it with chars
                    if (counter < 5) {
                        stringwithnothing += swearcharts[counter];
                    }
                    
                    // if the count is over 5 the count will be reset to 0 and start over with the loop of the chars
                    else{
                    counter = 0;
                    stringwithnothing += swearcharts[counter];
                }
                }
                
                //Takes the swear word and puts it in as a key in our hashmap + puts our string with nothing inside the value which is the chars
                filter.put(words, stringwithnothing);
                
                //System.out.print(filter); Checking the hashmap

            }


        // a new forloop that loops through the arraylist of tweets / words in our arraylist
        for (int i = 0; i < tweets.size(); i++) {

            // creates a new string that takes word in our tweet and makes it to lower case
            String newString = tweets.get(i).toLowerCase();

            //A forloop that loops thorugh our keys in the hashmap
            for (String checkkeys : filter.keySet()) {
                
                // A forloop that loops through the length of our new string which is our tweets
                for (int j = 0; j < newString.length(); j++) {
                    
                    //If statement that checks whether there is punktioations -- Could also be done like this   //(newString.contains("!" ) | newString.contains("." ) | newString.contains("?" ) | newString.contains("," )){
                    
                    if (newString.matches(".*\\p{Punct}")) {

                        //Creates a new string which is a substring that takes thaht removes the last digted which is the punctuation 
                        String Anotherone = newString.substring(0, newString.length()-1);
                        
                        //Creates a new string which removes anything besides the punctuation
                        String Anothertwo = newString.substring(newString.length()-1, newString.length());

                        // If statement that checks if the string anotherone is the same as the keys
                        if (Anotherone.equals(checkkeys)) {

                            // new string that gets the values connected to the keys and adds the punctation
                            String noget = filter.get(checkkeys)+ Anothertwo; 

                            //Takes the string and puts it in the arraylist instead
                            tweets.set(i, noget);
                        }

                    }
                    // Same if statement just with all other things that not has a punctuation in it  
                    else if (tweets.get(i).toLowerCase().equals(checkkeys)){
                        String lowercaseCheckkeys = filter.get(checkkeys);
                        tweets.set(i, lowercaseCheckkeys);
               
                    
                }
              

                }
                
            }

            
        }
        
        // Creates an empty string
        //String printing = "";

        // Creates a forloop that go through the strings in our arraylist tweets
            
        for (String anotherstring : tweets) {
                System.out.print(anotherstring + " ");
                
                // adds anotherstring + a gap to our printstatment between all words
                //printing += anotherstring + " ";
            }
        
        // prints the program
        //System.out.println(printing);

        sc.close();
    }
}


        

    

