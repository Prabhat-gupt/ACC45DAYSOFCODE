public class Day1ReverseLinkedList{
    class Node{
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
        Node nextNode = new Node(data);
        if(head==null){
            head = tail = nextNode;
            return;
        }

        nextNode.next = head;
        head = nextNode;
    }
    public void reverseList(){
        if(head==null){
            System.out.println("List is empty");
        }
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void print(){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String args[]){
        Day1ReverseLinkedList node = new Day1ReverseLinkedList();
        node.addFirst(5);
        node.addFirst(4);
        node.addFirst(3);
        node.addFirst(2);
        node.addFirst(1);

        node.print();
        node.reverseList();
        node.print();
    }
}