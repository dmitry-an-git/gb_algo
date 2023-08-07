

public class Main {
    public static void main(String[] args) {
        LinkedListDemo lst = new LinkedListDemo();
        lst.append(1);
        lst.append(2);
        lst.append(3);
        lst.print();
        lst.insert(4);
        lst.print();
        lst.insert(7);
        lst.print();
        lst.revert();
        lst.print();

        StackDemo stack = new StackDemo();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.pop());

        QueueDemo queue = new QueueDemo();
        queue.push(1);
        System.out.println(queue.head.value);
        System.out.println(queue.tail.value);
        queue.push(2);
        System.out.println(queue.head.value);
        System.out.println(queue.tail.value);  
        System.out.println(queue.peek());  
        System.out.println(queue.peek());  
        System.out.println(queue.peek());  
    }
}
