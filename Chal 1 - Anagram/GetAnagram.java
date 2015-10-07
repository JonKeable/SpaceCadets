import java.io.*;
import java.net.*;
/**
 * Write a description of class GetAnagram here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GetAnagram
{
    public String getURL(String myStr)
    {
        myStr = myStr.replaceAll("\\s","+");
        myStr = ("http://wordsmith.org/anagram/anagram.cgi?anagram="+myStr+"&t=1000&a=n");
        return myStr;
    }
    public String getAna(String myStr)
    {
       URL url = null;
       try 
       {
           url = new URL(myStr);
       }
       catch (MalformedURLException mue)
       {
           System.err.println("Something went wrong trying to read URL");
       }
       BufferedReader in = null;
       int line1 = 0;
       int line2 = 0;
       int i = 0;
       try
       {
           in = new BufferedReader(new InputStreamReader(url.openStream()));
           String myLine;
           String word1 = ("results");
           String word2 = ("</div>");
           boolean foundLine = false;
           while(((myLine = in.readLine()) != null)&&(foundLine == false))
           {
               if (myLine.contains(word1)) 
               {
                    line1 = i;
                    foundLine = true;
               }
               else
               {
                   i=i+1;
               }
               //System.out.println(myLine);
           }
           //i = 0;
           //in = new BufferedReader(new InputStreamReader(url.openStream()));
           //System.out.println("LINE 1 FOUND!!!!");
           foundLine = false;
           while(((myLine = in.readLine()) != null)&&(foundLine == false))
           {
               if (myLine.contains(word2)) 
               {
                    line2 = i;
                    foundLine = true;
               }
               else
               {
                   i=i+1;
               }
               //System.out.println(myLine);
           }
       }
       catch (IOException ioe)
       {
           System.err.println("Something went wrong trying to read the Webpage");
       }
       //System.out.println(line1);
       //System.out.println(line2);
       RandomNumberGen rng = new RandomNumberGen();
       int randInt = rng.getRandomInt(line1, line2) + 2;
       randInt = line1+randInt;
       String chosenLine = null;
       try
       {
           in = new BufferedReader(new InputStreamReader(url.openStream()));
           String myLine;
           for (i = 0; i < randInt+1; i++)
           {
               myLine = in.readLine();
           }
           chosenLine = in.readLine();
       }
       catch (IOException ioe)
       {
           System.err.println("Something went wrong trying to read the Webpage");
       }
       //System.out.println(chosenLine);
       myStr = chosenLine.substring(0, chosenLine.indexOf("<"));
       return myStr;   
    }
}
