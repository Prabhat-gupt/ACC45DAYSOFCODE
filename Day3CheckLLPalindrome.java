public class Day3CheckLLPalindrome {
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
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public Node midNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }

        Node mid = midNode(head);

        Node prev = null;
        Node curr = tail = prev;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        while(right!=null){
            if(left.data==right.data){
                left = left.next;
                right = right.next;
            }else{
                return false;
            }
        }
        return true;
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
    public static void main(String args[]){
        Day3CheckLLPalindrome node = new Day3CheckLLPalindrome();
        node.addLast(1);
        node.addLast(2);
        node.addLast(2);
        node.addLast(1);

        node.print();
        System.out.println(node.isPalindrome());
    }
}
