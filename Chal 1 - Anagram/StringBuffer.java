import java.io.*;
import java.net.*;
/**
 * Write a description of class StringBuffer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringBuffer
{
    public String readStringCmd()
    /** 
    * This class reads string from a users command line input.(from Chal1 entry)
    */
    {
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
}
