import java.util.LinkedList;

public class Day4JavaCollectionFramework {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        System.out.println(ll);

        ll.removeFirst();

        System.out.println(ll);

        ll.removeLast();

        System.out.println(ll);

        ll.clear();

        System.out.println(ll);
    }
}
