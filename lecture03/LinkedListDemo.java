/**
 * LinkedList
 * append +
 * insert +
 * revert 
 * find +
 */
public class LinkedListDemo {

    Node head;
    Node tail;

    /**
     * InnerLinkedList
     */
    public class Node {
        int value;
        Node next;
        Node prev;
    }

    public void append(int value) {

        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

    }

    public void push(int value) {
        Node node = new Node();
        node.value = value; 

        if (head == null) {
            head = node;
            tail = node;
        } else { 
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public boolean contains(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) {
                return true;
            } else {
                curr = curr.next;
            }
            curr = curr.next;
        }
        return false;
    }

    public void revert() {
        if (head == null || head.next == null) {
            return;
        } 
        Node curr = head;
        while (true) {
            Node next = curr.next;
            Node prev = curr.prev;

            if (prev == null) {
                tail = curr;
            }

            curr.next = prev;
            curr.prev = next;

            if (next == null) {
                head = curr;
                break;
            } 
            
            curr = next;
        }
    }

    public void print(){
        if (tail==null) {
            System.out.println("The list is empty");
            return;
        }
        Node curr = head;
        while (true) {
            System.out.printf("%d ",curr.value);
            curr = curr.next;
            if (curr == null) {
                break;
            }
        }
        System.out.println();
    }
    
}