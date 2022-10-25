public class Day5DetectingCycleInLL {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }

        return false;
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
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;

        System.out.println(isCycle());

    }
}
