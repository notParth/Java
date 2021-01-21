import java.util.*;
public class barber_problem_v3 {
    int chair[], customers, customer[];
    Queue<Integer> couch, line, cashier;
    Random rand = new Random();

    barber_problem_v3(){
        customers = rand.nextInt(30)+5;
        customer = new int[customers];

        for(int i = 0; i<customers; i++)
            customer[i] = i + 1;

        chair = new int[3];
        couch = new LinkedList<>();
        line = new LinkedList<>();
        cashier = new LinkedList<>();
    }
    void move_to_entry(){
        for(int i = 0; i < customer.length; i++){
            if(line.size()<20 && customer[i] != 0){

            }
        }
    }
}
