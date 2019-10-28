
public class TestMyLinkedList {
    public static void main(String[] args) {
        MyList ll = new MyList(31);
        ll.addLast(7);
        ll.addFirst(69);
        ll.add(0, 322);
        ll.addLast(7);
        ll.removeObj(7);
        ll.removeObj(7); System.out.println("LinkedList 1:");
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }
        MyList ll2 = ll.clone();
        ll2.addLast(644);
        ll2.remove(0);
        System.out.println("LinkedList 2:");
        for (int i = 0; i < ll2.size(); i++) {
            System.out.println(ll2.get(i));
        }
        System.out.println(ll2.contain(644));
        System.out.println(ll2.indexOf(644));
        System.out.println(ll2.add(666));
        System.out.println("LinkedList 2:");
        for (int i = 0; i < ll2.size(); i++) {
            System.out.println(ll2.get(i));
        }
        ll2.clear();
        ll2.add(644);
        System.out.println("LinkedList 2:");
        for (int i = 0; i < ll2.size(); i++) {
            System.out.println(ll2.get(i));
        }
        System.out.println(ll.getLast());
    }
}
