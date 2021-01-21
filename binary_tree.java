import java.util.*;
class binary_tree{

    //Node class
    class Node{
        Node left, right;
        int data;
        Node(int data){
            left = right = null;
            this.data = data;
        }
    }

    Node root;
    int arr[];

    //function to insert node
    void insert(Node data){
        Node temp = root;
        boolean cnt = true;
        if(root == null) {
            root = data;
            return;
        }
        do{
            if(data.data <= temp.data){
                if(temp.left != null){
                    temp = temp.left;
                    continue;
                }
                temp.left = data;
                cnt = false;
            }
            else{
                if(data.data >= temp.data){
                    if(temp.right != null){
                        temp = temp.right;
                        continue;
                    }
                    temp.right = data;
                    cnt = false;
                }
            }
        }while(cnt);
    }

    //display function
    void display(Node temp) {
        if (temp != null) {
            display(temp.left);
            System.out.print(temp.data + " ");
            display(temp.right);
        }
    }

    //function to set the binary tree
    void setBinaryTree(){
        Random rand  = new Random();
        arr = new int[12];
        System.out.print("array: \n");
        for(int i = 0; i < 12; i++) {
            arr[i] = rand.nextInt(20);
            insert(new Node(arr[i]));
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("The binary tree is displayed from the leftmost leaf to the rightmost leaf");
        System.out.println("Binary Tree: ");
        display(root);
    }

    public static void main(String[] args){
        binary_tree obj = new binary_tree();
        obj.setBinaryTree();
    }
}