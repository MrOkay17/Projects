/**
 * @author  Mikkel Kildeberg
 */

import java.util.*;

public class ProfanityFilter {

    // Creating a class with, arraylist, Hashmap, a string and the scanner
    private ArrayList <String> tweets; 
    private HashMap<String, String> filter;
    private String swear;
    private Scanner sc = new Scanner(System.in);


    //Constructor which creates an new profanityfilter
    public ProfanityFilter(){
        tweets = new ArrayList<>();
        filter = new HashMap<>();
        swear = sc.nextLine();
        
        while (sc.hasNextLine()) {
            tweets.add(sc.next());
            }

        }

    //Method that replace the word with chars and lastly put the word as keys and chars as values
    public void ReplaceWordWithChars() {

        // An list of the swear words where it is splitted by a gap and made to lower case words only
        String[] arrayofswears = swear.toLowerCase().split(" ");

        // An array with charts that needs to replace the swearword
        String[] swearcharts = {"*", "&", "#", "$", "%"};
        
        // Forloop that goes through the words of the swearwords in the array
        for (String words : arrayofswears) {
            
            //Empty string
            String Word_replaced_with_chars = "";

            //Forloop that goes through the length of the word and replace it with chars
            for (int i = 0; i < words.length() ; i++) {
                
                    Word_replaced_with_chars += swearcharts[i % swearcharts.length] ;
                }
            
            //puts our chars and words inside the hashmap -- Words = keys and chars = value
            filter.put(words, Word_replaced_with_chars);
            }

        }
        
    

    // Method that removes the punctuation from the tweet replace it with chars and puts the punctuation back on the string
    public void RemovePunctation(){
            for (int i = 0; i < tweets.size(); i++) {

                // creates a new string that takes word in our tweet and makes it to lower case
                String tweetsLowercase = tweets.get(i).toLowerCase();
                
                ////A forloop that loops thorugh our keys in the hashmap
                for (String checkkeys : filter.keySet()) {
                    
                    // A forloop that loops through the length of our new string which is our tweets
                    for (int p = 0; p < tweetsLowercase.length(); p++) {
                        
                        //If statement that checks whether there is punktioations 
                        if (tweetsLowercase.matches(".*\\p{Punct}")) {
                            
                            //Creates a new string which is a substring that takes thaht removes the last digted which is the punctuation 
                            String tweetsLowercase_without_punctationString = tweetsLowercase.substring(0, tweetsLowercase.length()-1);
                            
                            //Creates a new string which removes anything besides the punctuation
                            String OnlyPunctation = tweetsLowercase.substring(tweetsLowercase.length()-1, tweetsLowercase.length());
                            
                            // If statement that checks if the string is the same as the keys
                            if (tweetsLowercase_without_punctationString.equals(checkkeys)) {
                                
                                // new string that gets the values connected to the keys and adds the punctation
                                String Keys_With_Added_Punctation = filter.get(checkkeys) + OnlyPunctation; 
                                
                                //Takes the word and puts it in the arraylist instead
                                tweets.set(i, Keys_With_Added_Punctation);
                            }
    
                        }

                        // Same if statement just with all other things that not has a punctuation in it  
                        else if (tweets.get(i).toLowerCase(). equals(checkkeys)){
                            String lowercaseCheckkeys = filter.get(checkkeys);
                            tweets.set(i, lowercaseCheckkeys);
                   
                        
                    }
                  
    
                    }
                    
                }
    
                
            }
    }
            
    //Method that prints the word with a gap between
    public void Printthestatement(){
            for (String The_Final_Statement : tweets) {
                System.out.print(The_Final_Statement + " ");

        }
        
    }


    // Main method that creates a Profanity filter and runs the methods
    public static void main(String[] args) {
        ProfanityFilter Profanityfilter = new ProfanityFilter();
        Profanityfilter.ReplaceWordWithChars();
        Profanityfilter.RemovePunctation();
        Profanityfilter.Printthestatement();

    }

}

        
      