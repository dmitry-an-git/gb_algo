public class QueueDemo {
    
    Node head;
    Node tail;

    public void push(int value){
        Node node = new Node();
        node.value = value; 
        node.next = head; 
        if(head != null) {
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public Integer peek(){
        if (tail!=null) {
            Node result = tail;
            tail = tail.prev;
            if (tail!=null) {
                tail.next = null;
            }
            return result.value;
        } else { 
            return null;
        }
    }


    public int pop(){
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
            return -1;
        }
    }

    public class Node {
        int value;
        Node next;
        Node prev;
    }
}
