package leetCode30Day;

public class MinStack10 {
	Node topNode;

	public static void main(String[] args) {
		

	}
	
	/** initialize your data structure here. */
    public MinStack10() {
        topNode = null;
    }
    
    public void push(int x) {
        if(topNode == null){
            topNode = new Node(x, x, null);
        }else{
            if(topNode.min > x){
                topNode = new Node(x, x, topNode);
            }else{
                topNode = new Node(x, topNode.min, topNode);
            }
        }
    }
    
    public void pop() {
        if(topNode == null){
            // throw new Exception("error");
            System.out.println("This stack is empty.");
        }
        topNode = topNode.previousNode;
    }
    
    public int top() {
        return topNode.value;
    }
    
    public int getMin() {
        return topNode.min;
    }

}

class Node{
    Node previousNode;
    int min;
    int value;
    
    Node(int value, int min, Node previousNode){
        this.value = value;
        this.min = min;
        this.previousNode = previousNode;
    }
}
