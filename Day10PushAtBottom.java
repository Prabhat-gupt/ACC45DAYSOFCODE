public class Day10PushAtBottom {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{
        static Node head = null;
        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }

            return head.data;
        }

        public void pushAtBottom(int data){
            if(isEmpty()){
                push(data);
                return;
            }

            int top = pop();
            pushAtBottom(data);
            push(top);
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.pushAtBottom(6);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
