/*
 * Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. 
 * И реализовать в нем метод добавления новых элементов с балансировкой.
 * 
 * Красно-черное дерево имеет следующие критерии:
 * • Каждая нода имеет цвет (красный или черный)
 * • Корень дерева всегда черный
 * • Новая нода всегда красная
 * • Красные ноды могут быть только левым ребенком
 * • У краcной ноды все дети черного цвета
 * 
 * Соответственно, чтобы данные условия выполнялись, 
 * после добавления элемента в дерево необходимо произвести балансировку, 
 * благодаря которой все критерии выше станут валидными. 
 * Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.
 */


class RedBlackTree{

    Node root;

    private class Node{
        private int value;
        private Node left;
        private Node right;
        private Boolean red; // red if true, otherwise black 

        private Node(int value, boolean red) {
            this.value = value;
            this.red = red; // actually always true for any new node, except for the root
        }
    }

    public boolean push(int value) {
        if (root == null) {
            root = new Node(value, false);
            return true;
        } else {
            boolean result = pushNode(root, value);
            root = rebalance(root);
            root.red = false;
            return result;
        }
    }

    private boolean pushNode(Node node, int value) {
        
        if (node.value == value) {
            return false;
        } 

        if (node.value > value) {
            if (node.left != null) {
                boolean result = pushNode(node.left, value);
                node.left = rebalance(node.left);
                return result;
            } else {
                node.left = new Node(value, true);
                return true;
            }
        } else {
            if (node.right != null) {
                boolean result = pushNode(node.right, value);
                node.right = rebalance(node.right);
                return result;
            } else {
                node.right = new Node(value, true);
                return true;
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;

            if (result.right != null && result.right.red == true && 
                    (result.left == null || result.left.red == false)) {
                        needRebalance = true;
                        result = swapRight(result);
                    }

            if (result.left != null && result.left.red == true && 
                    result.left.left != null && result.left.left.red == true) {
                        needRebalance = true;
                        result = swapLeft(result);
                    }
            
            if (result.left != null && result.left.red == true && 
                    result.right != null && result.right.red == true) {
                        needRebalance = true;
                        swapColor(result);
                    }           
        } while (needRebalance);
        return result;
    }

    private Node swapLeft(Node node) {
        Node left = node.left;
        Node orphan = node.left.right;
        left.right = node;
        node.left = orphan;
        left.red = node.red;
        node.red = true;
        return left;
    }

    private Node swapRight(Node node) {
        Node right = node.right;
        Node orphan = node.right.left;
        right.left = node;
        node.right = orphan;
        right.red = node.red;
        node.red = true;
        return right;
    }

    private void swapColor(Node node) {
        node.right.red = false;
        node.left.red = false;
        node.red = true;
    }

    boolean find(int value){
        Node node = root;
        while(node != null){
            if(node.value == value){
                return true;
            }
            if(node.value < value){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        return false;
    }

    public int size() {
        if (root == null) {
            return 0;
        } else {
            return size(root);
        }
    }

    private int size(Node node) {
        Node right = node.right;
        Node left = node.left;
        int counter = 1;                                      
        if ( right != null ) counter += size(right);        
        if ( left != null ) counter += size(left);          
        return counter;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null)
            return 0;
        else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    // we can assign indexes to node positions and use them in binary to route the selector:
    // 1 0001 root
    // 2 0010 root.left
    // 3 0011 root.right
    // 4 0100 root.left.left
    // 5 0101 root.left.right
    // 6 0110 root.right.left
    // 7 0111 root.right.right
    // 8 1000 root.left.left.left
    // some of them will be Null

    private String getNode(int num) { // returns a string representation of a node at given posiiton index
         
        int[] binary = new int[5];
        int id = 4;
 
        while (num > 0) {
            binary[id--] = num % 2;
            num = num / 2;
        }
        
        try {
            boolean started = false;
            Node curr = root;
            for (int i : binary) {
                if (!started) {
                    if (i==1) { started = true; } 
                } else {
                    if (i == 0) { curr = curr.left; }
                    else { curr = curr.right; }
                }
            }

            String color = "B";
            if (curr.red == true) {color="R";}
            return String.format("%d %s", curr.value, color);

        } catch (Exception e) {
            return "null";
        }
    }

    public void printTree() {
    
        int depth = maxDepth(); // actual depth of the tree
        if (depth > 4) {
            System.out.println("the tree is too big (4 levels max for this method)");
        } else {
            int maxSize = (int) Math.pow(2,depth);  // theoretical at last level
            int lineWidth = maxSize * 4 + (maxSize - 1) * 4; // usefull space for the chart
            int nodeNum = 1;
            for (int i = 0; i <depth; i++) {
                int elementsOnTheLine = (int) Math.pow(2,i);
                int spacersNum = elementsOnTheLine+1;
                int spacerLen = (lineWidth - 4*elementsOnTheLine)/spacersNum;
                for (int j = 0; j < elementsOnTheLine; j++) {
                    System.out.printf("%"+spacerLen+"s", "");
                    System.out.printf(getNode(nodeNum++));
                }
                System.out.println();
            } 
        }
    }
}

public class Main {
    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();

        tree.push(5);
        tree.push(3);
        tree.push(7);
        tree.push(2);
        tree.push(4);
        tree.push(6);
        tree.push(8);
        tree.push(9);
        tree.push(1);
        tree.push(0);
        tree.push(11);
        tree.push(12);

        System.out.println(tree.find(5));
        System.out.println(tree.find(10));

        System.out.printf("size: %d\n", tree.size());
        System.out.printf("depth: %d\n", tree.maxDepth());
        
        tree.printTree();
    }
}