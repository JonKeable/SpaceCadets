
/**
 * Write a description of class AnagramFetcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnagramFetcher
{

    public static void main(String[] args)
    {
        StringBuffer br = new StringBuffer();
        GetAnagram ga = new GetAnagram();
        String myStr;
        System.out.println("Welcome to Anagram Maker");
        System.out.println("please enter the text you want to turn into an anagram");
        myStr =  br.readStringCmd();
        myStr = ga.getAna(ga.getURL(myStr));
        System.out.println("Anagram generated: "+myStr);
    }
}
