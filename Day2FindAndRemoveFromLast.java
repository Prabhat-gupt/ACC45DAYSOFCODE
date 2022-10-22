
public class Day2FindAndRemoveFromLast {
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

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void removeNNode(int n){
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            sz++;
            temp = temp.next;
        }

        int i = 1;
        int toFind = sz - n;
        Node prev = head;
        while(i<toFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        // return prev;
    }

    public void print(){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        Day2FindAndRemoveFromLast node = new Day2FindAndRemoveFromLast();
        node.addLast(1);
        node.addLast(2);
        node.addLast(3);
        node.addLast(4);
        node.addLast(5);

        node.print();
        node.removeNNode(3);
        node.print();
    }
}
