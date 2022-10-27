public class Day7SwapNode {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;
    static int size;
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void swap(int x,int y){
        int size = 0;

        Node temp = head;
        Node prev = head;
        Node xNode = null;
        Node yNode = null;

        while(temp!=null){
            size++;

            if(size==x){
                xNode = prev;
            }

            if(size==y){
                yNode = prev;
            }

            prev = temp;
            temp = temp.next;
        }

        Node te = xNode.next;
        yNode.next.next = xNode.next.next;
        xNode.next = yNode.next;
        yNode.next = te;
        te.next = null;
    }

    public void print(){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    public static void main(String[] args) {
        Day7SwapNode node = new Day7SwapNode();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);

        node.print();

        node.swap(2, 4);

        node.print();
    }
}
