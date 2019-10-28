import javafx.beans.binding.ObjectBinding;

public class MyList {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numNodes;

    public MyList() {
    }

    public MyList(Object data) {
        head = new Node(data);
        this.numNodes++;
    }

    public void addFirst(Object obj) {
        Node tmp = head;
        head = new Node(obj);
        head.next = tmp;
        numNodes++;
    }

    public void addLast(Object obj) {
        if(numNodes == 0){
            addFirst(obj);
        }else{
            Node tmp = head;
            for (int i = 0; i < numNodes - 1 && tmp.next != null; i++) {
                tmp = tmp.next;
            }
            tmp.next = new Node(obj);
            numNodes++;
        }
    }

    public boolean add(Object obj) {
        if(numNodes == 0){
            addFirst(obj);
        }else{
            Node tmp = head;
            for (int i = 0; i < numNodes - 1 && tmp.next != null; i++) {
                tmp = tmp.next;
            }
            tmp.next = new Node(obj);
            numNodes++;
        }
        return true;
    }

    public void add(int index, Object obj) {
        if (index == 0) {
            this.addFirst(obj);
        } else {
            Node tmp = head;
            Node holder;
            for (int i = 0; i < index - 1 && tmp.next != null; i++) {
                tmp = tmp.next;
            }
            holder = tmp.next;
            tmp.next = new Node(obj);
            tmp.next.next = holder;
            numNodes++;
        }
    }

    public Object remove(int index) {
        Node tmp = head;
        Node result;
        if (index == 0) {
            head = tmp.next;
            result = tmp;
        } else {
            for (int i = 1; i < index - 1 && tmp.next != null; i++) {
                tmp = tmp.next;
            }
            result = tmp.next;
            Node holder = tmp.next.next;
            tmp.next = holder;
        }
        numNodes--;
        return result.getData();
    }

    public boolean removeObj(Object obj) {
        Node tmp = head;
        if (tmp.getData().equals(obj)) {
            head = tmp.next;
            numNodes--;
            return true;
        }
        for (int i = 0; i < numNodes && tmp.next != null; i++) {
            if (tmp.next.getData().equals(obj)) {
                Node holder = tmp.next.next;
                tmp.next = holder;
                break;
            }
            tmp = tmp.next;
        }
        numNodes--;
        return true;
    }

    public MyList clone() {
        MyList tmpList = new MyList(this.head.getData());
        Node tmp = this.head;
        for (int i = 0; i < numNodes && tmp.next != null; i++) {
            tmpList.addLast(tmp.next.getData());
            tmp = tmp.next;
        }
        return tmpList;
    }

    public boolean contain(Object obj) {
        Node tmp = this.head;
        for (int i = 0; i < numNodes; i++) {
            if (tmp.getData().equals(obj)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public int indexOf(Object obj) {
        Node tmp = head;
        for (int i = 0; i < numNodes; i++) {
            if (tmp.getData().equals(obj)) {
                return i;
            }
            tmp = tmp.next;
        }
        return -1;
    }


    public Object get(int index) {
        Node tmp = head;
        if (index == 0) return tmp.getData();
        for (int i = 0; i < index - 1 && tmp.next != null; i++) {
            tmp = tmp.next;
        }
        return tmp.next.getData();
    }

    public Object getFirst(){
        return this.head.getData();
    }
    public Object getLast(){
        Node tmp = head;
        for(int i =0; i<numNodes-1;i++){
            tmp = tmp.next;
        }
        return tmp.getData();
    }

    public int size() {
        return this.numNodes;
    }

    public void clear(){
        this.head = new Node(null);
        this.numNodes = 0;
    }
}
