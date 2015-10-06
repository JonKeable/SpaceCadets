import java.io.*;
import java.net.*;
/**
 * A class containing methods for reading text form console and webpages.
 * 
 * @author Jon Keable 
 * @version 06/10/15
 */
public class ReadString 
{
    public String readStringCmd()
    /** 
    * This class reads string from a users command line input.
    */
    {
        // put your code here
        System.out.println("Please enter a Soton ID");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String myString = null;
        try
        {
            myString = in.readLine();
        }
        catch (IOException ioe)
        {
            System.err.println("Something went wrong trying to read input");
        }
        return myString;
        
    }
    public String IDtoURL(String myString)
    /**
     * This class converts a sotonID to its ecs people adress.
     */
    {
        System.out.println("Looking up URL for soton ID: " + myString);
        myString = ("http://www.ecs.soton.ac.uk/people/"+myString);
        return myString;
    }
    public String findLine(String myString)
    /**
     * This class finds the line in the webpage where the name of the ID holder is stored.
     */
    {
       System.out.println("Searching Webpage: " + myString);
       URL url = null;
       try 
       {
           url = new URL(myString);
       }
       catch (MalformedURLException e)
       {
           System.err.println("Something went wrong trying to read URL");
       }
       BufferedReader in = null;
       try
       {
           in = new BufferedReader(new InputStreamReader(url.openStream()));
           String myLine;
           String word = ("class=\"vcard\"");
           while((myLine = in.readLine()) != null)
           {
               if ( myLine.contains(word)) 
               {
                    myString = myLine;
                    myLine = null;
                    //System.out.println("Found line: " + myString); - to test the correct line is found
               }
           }
       }
       catch (IOException ioe)
       {
           System.err.println("Something went wrong trying to read the Webpage");
       }
       return myString;
    }
    public String findName(String myString)
    /**
     * This class finds the exact name of the ID holder from the relevant line of the webpage
     */
    {
        String subStr; 
        int p1;
        int p2 = 0;
        int p3;
        p1 = myString.indexOf("class=\"vcard\"");
        p2 = p1;
        for (int i = 0; i < 3; i++)
        {
            p2 = myString.lastIndexOf(">",  p2 -1);
        }
        /**
         * This find the 3rd ">" from the right from the position of "class = "vcard"" as there is <div><div> between this and the name
         */
        //System.out.println(myString.substring(p2, p2+10)); - to test the 3rd ">" is found correctly
        p3 = myString.indexOf("<", p2);
        //System.out.println(myString.substring(p3, p3+10)); - to test the "<" is found correctly
        subStr = myString.substring(p2+1,p3);
        //System.out.println("Found Substring: " + subStr); - to test substring is correct
        //myString = subStr.substring((p1+1),p2);
        return subStr;
    }
}
