
/**
 * The class containging the main method.
 * 
 * @author Jon Keable
 * @version 06/10/15
 */
public class MainProgram
{
    // instance variables - replace the example below with your own
    private int x;

    public static void main(String[] args)
    {
       String myString = null;
       Boolean correctInput = false;
       ReadString br = new ReadString();
       myString = br.readStringCmd();
       System.out.println("You entered the ID: " + myString);
       myString = br.findLine(br.IDtoURL(myString));
       myString = br.findName(myString);
       System.out.println("Name of ID holder: " + myString);
    }
}
