import java.util.*;
public class pong_reinvent {
    Stack<Integer> stack[];
    int N;
    pong_reinvent(int n){
        N = n;
        stack = new Stack[N];
        for(int i = 0; i < N; i++)
            stack[i] = new Stack<Integer>();
    }
    public boolean cup_check(){
        for(int i  = 0; i < N; i++) {
            if (stack[i].size() < 1)
                return true;
        }
        return false;
    }
    public void ball_add(int cup, int ball){
        stack[cup].push(ball);
    }
    public void round_reset(){
        for(int i = 0; i < N; i++){
            //temporary array to store ball for a cup
           int tempArray[] = new int[stack[i].size()];
           //taking all the balls out from the cup
           for(int j = 0; j < tempArray.length; j++)
               tempArray[j] = stack[i].pop();
           //putting the same numbered balls back
            for(int j = 0; j < tempArray.length; j++)
                if(tempArray[j] == i)
                    stack[i].push(i);
        }
    }
    public void sort_cups(){
        //using bubble sort to sort all the cups in descending order
        Stack<Integer> tempStack = new Stack<Integer>();
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N-1; j++){
                if(stack[j].size()<stack[j+1].size()){
                    tempStack = stack[j];
                    stack[j] = stack[j+1];
                    stack[j+1] = tempStack;
                }
            }
        }
    }
    public void display(int rounds, int balls){
        System.out.println("It took "+rounds+" rounds and "+balls+" balls to complete the game");
        for(int i = 0; i < N; i++){
            System.out.print("{ ");
            int stack_size = stack[i].size();
            for(int j = 0; j < stack_size; j++) {
                System.out.print(stack[i].pop());
                if(j!=stack_size-1)
                    System.out.print(", ");
            }
            System.out.println("}");
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Choose a value of N: ");
        int numCups = scn.nextInt();
        pong_reinvent obj = new pong_reinvent(numCups);
        int ballCount = 0, roundCount = 0;
        //Game's loop
        do {
            //Round's loop
            do {
                int ballRand = rand.nextInt(numCups);
                ++ballCount;
                int cupRand = rand.nextInt(numCups);
                obj.ball_add(cupRand, ballRand);
            }
            while(obj.cup_check());
            obj.round_reset();
            ++roundCount;
        }
        while(obj.cup_check());
        obj.sort_cups();
        obj.display(roundCount, ballCount);
    }
}

