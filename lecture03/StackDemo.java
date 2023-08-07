public class StackDemo {
    
    Node head;

    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public Integer pop(){
        if (head != null) {
            if (head.next != null) {
                Node next = head.next;
                Node curr = head;
                head = next;
                return curr.value;
            } else {
                Node curr = head;
                head = null;
                return curr.value;
            }

        } else {
            return null;
        }
    }

    public class Node {
        int value;
        Node next;
    }
}
