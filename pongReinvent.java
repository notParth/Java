/**
 *
 */

/**
 * @author Parth Patel
 *
 */
import java.util.*;
public class pongReinvent {
    private int cups[][];
    pongReinvent(int numCups){
        cups = new int[numCups][2];
    }
    //Checks whether cups are full or not
    public boolean CupsCheck() {
        for(int i = 0;i<cups.length;i++)
            if((cups[i][0] + cups[i][1]) == 0)
                return true;
        return false;
    }
    //Add a ball to a cup
    public void ballAdd(int cup, int ball) {
        if(ball == cup)
            cups[cup][0]++;
        else
            cups[cup][1]++;
    }
    //Resets the round by removing the balls that don't count
    public void RoundReset() {
        for(int i = 0;i<cups.length;i++)
            cups[i][1] = 0;
    }
    //Final print function
    public void print(int rounds, int balls) {
        System.out.println("It took "+rounds+" rounds and "+balls+" balls to complete the game");
        for(int i=0;i<cups.length;i++){
            System.out.print("{");
            for(int j=0;j<cups[i][0];j++) {
                System.out.print(i);
                if(j!=cups[i][0]-1)
                    System.out.print(", ");
            }
            System.out.println("}");
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Choose a value of n: ");
        int numCups = scn.nextInt();
        pongReinvent obj = new pongReinvent(numCups);
        int ballCount = 0, roundCount = 0;
        //Game's loop
        do {
            //Round's loop
            do {
                int ballRand = rand.nextInt(numCups);
                ++ballCount;
                int cupRand = rand.nextInt(numCups);
                obj.ballAdd(cupRand, ballRand);
            }
            while(obj.CupsCheck());
            obj.RoundReset();
            ++roundCount;
        }
        while(obj.CupsCheck());
        obj.print(roundCount, ballCount);
    }
}
