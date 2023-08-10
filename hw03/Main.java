

public class Main {
    public static void main(String[] args) {
        LinkedListDemo lst = new LinkedListDemo();

        lst.push(1);
        lst.push(2);
        lst.push(3);
        lst.append(0);
        lst.append(-1);
        System.out.println(lst.contains(1));
        lst.print();
        lst.printBackwards();
        lst.revert();
        lst.print();
        lst.printBackwards();

    }
}
