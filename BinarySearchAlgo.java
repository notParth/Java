//End statement for no match
public class BinarySearchAlgo {
    public static void main(String[] args){
        int arr[] = {1, 2, 3 ,4, 5, 8};
        int num = 9;
        int start = 0, end = 6;
        int mid = -1;
        int matchIndex;
        while(mid!=end-1){
            mid = (start+end)/2;
            System.out.println(start+" "+mid+ " "+end);
            if(arr[mid]!=num){
                if(num>arr[mid])
                    start = mid;
                else
                    end = mid;
            }
            else {
                System.out.println("Used");
                break;
            }
        }
        System.out.println("index: "+mid);
        System.out.println("element: "+arr[mid]);
    }
}
