public class btNode {
    btNode left, right;
    int data;
    btNode(){
        left = null;
        right = null;
        data = 0;
    }
    btNode(int d){
        left= null;
        right = null;
        data = d;
    }
    void setLeft(btNode temp){
        left = temp;
    }
    void setRight(btNode temp){
        right = temp;
    }
    void setData(int d){
        data = d;
    }
    btNode getLeft(){
        return left;
    }
    btNode getRight(){
        return right;
    }
    int getData(){
        return data;
    }
}
