/**
 * LinkedList
 * append +
 * push +
 * pop +
 * contains +
 * revert +
 * find +
 * print +
 * printBackwards +
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

        public Node(int value){
            this.value = value;
        }
    }

    /* 
     * insert a new node to the end of the list
     */
    public void append(int value) { 
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else if (head.next == null) {
            head.next = node;
            tail = node;
            tail.prev = head;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    /*
     * insert new node at the begining of the list
     */
    public void push(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else if (head == tail) {
            tail.prev = node;
            head = node;
            head.next = tail;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    /* 
     * delete the first node
     */
    public void pop() {
        if (head != null) {
            if (head.next != null) {
                Node next = head.next;
                next.prev = null;
                head = next;
            } else {
                head = null;
                tail = null;
            }
        }
    }

    public boolean contains(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void revert() {
        if (head == null || head.next == null) { //nothing to revert if we have zero or one node
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
    
    /* 
     * this is to check the integrity (going backwards), but not to revert the list
     */
    public void printBackwards(){
        if (tail==null) {
            System.out.println("The list is empty");
            return;
        }
        Node curr = tail;
        while (true) {
            System.out.printf("%d ",curr.value);
            curr = curr.prev;
            if (curr == null) {
                break;
            }
        }
        System.out.println();
    }
}