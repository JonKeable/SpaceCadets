import java.util.Random;
/**
 * Write a description of class RandomNumberGen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomNumberGen
{
    public int getRandomInt(int a, int b)
    {
        Random r = new Random();
        int c = r.nextInt((b-a)-1);
        return c;
    }
}
