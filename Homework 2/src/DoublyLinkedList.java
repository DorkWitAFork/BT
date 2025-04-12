class DoublyLinkedList {
    // NODE CLASS
    static class Node {
        int data;
        Node next;
        Node prev;

        // CONSTRUCTOR
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        // OPTIONAL CONSTRUCTOR- If no data is passed in upon initialization of a new Node, the data will be filled with 0.
        public Node() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    private int size;
    // CONSTRUCTOR
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // *METHODS*

    // INSERT AT HEAD  (currently has size implemented)
    public void headInsert(int data) {
        if (isEmpty()){
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
            size++;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    // INSERT AT TAIL  (currently has size implemented)
    public void tailInsert(int data) {
        if (isEmpty()){
            headInsert(data);
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    // INSERT AT A POSITION
    public void insert(int data, int position) {
        if (isEmpty() || position == 0) {
            headInsert(data);
            return;
        }
        if (position >= size()) {
            tailInsert(data);
            return;
        }
        Node cursor = listSearch(position);     // return the previous node from our desired index.
        Node newNode = new Node(data);
        newNode.next = cursor.next;
        newNode.prev = cursor;
        if (cursor.next != null) {
            cursor.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    // REMOVE HEAD NODE  (currently has size implemented)
    public void deleteHead(){
        if (isEmpty()){
            System.out.println("Error: Cannot delete head. List is empty.");
            return;
        }
        if (head.next == null) {
            deleteList();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // REMOVE TAIL NODE  (currently has size implemented)
    public void deleteTail() {
        if (isEmpty()){
            System.out.println("Error: Cannot delete tail. List is empty.");
            return;
        }
        if (head.next == null){
            deleteList();
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    // REMOVE AT A POSITION
    public void delete(int position) {
        if (isEmpty()) { return; }
        if (position == 0) {
            deleteHead();
            return;
        }
        if (position >= (size - 1)) {
            deleteTail();
            return;
        }

        Node temp = listSearch(position);
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
    }

    // TRAVERSE FORWARDS - print at the same time
    // Position represents the number of nodes to traverse and print.
    public void traverseForward(int position) {
        if (isEmpty()) { return; }
        if (position == 0) {
            System.out.println(head.data);
            return;
        }
        if (position >= size) {
            int index = 0;
            Node cursor = head;
            while (cursor != null && index < size){
                System.out.println(cursor.data);
                cursor = cursor.next;
                index++;
            }
            return;
        }

        int index = 0;
        Node cursor = head;
        while (cursor != null && index < position){
            System.out.println(cursor.data);
            cursor = cursor.next;
            index++;
        }
    }

    // TRAVERSE BACKWARDS - print at the same time
    // Position represents the number of nodes to traverse and print.
    public void traverseBackward(int position) {
        if (isEmpty()) { return; }
        if (position == 0) {
            System.out.println(tail.data);
            return;
        }
        if (position >= size) {
            int index = 0;
            Node cursor = tail;
            while (cursor != null && index < size) {
                System.out.println(cursor.data);
                cursor = cursor.prev;
                index++;
            }
            return;
        }

        int index = 0;
        Node cursor = tail;
        while (cursor != null && index < position) {
            System.out.println(cursor.data);
            cursor = cursor.prev;
            index++;
        }
    }

    // LIST SEARCH - RETURN THE NODE DATA AT THAT INDEX IN THE LIST.
    // *NOTE* THIS RETURNS THE NODE.PREV PURELY FOR THE SAKE OF ASSISTING INSERTION/DELETION.
    public Node listSearch(int position) {
        // The idea is to traverse forward, starting at the head, until we reach a null pointer or the index of choice.
        // We start by checking if the list is empty. if it is, we end there.
        if (isEmpty() || position == 0) {
            System.out.println("Error: cannot traverse list. List is empty.");
            return null;
        }
        Node cursor = head;
        int index = 0;
        while (cursor != null && index < position){
            cursor = cursor.next;
            index++;
        }

        if (cursor == null) { return tail; }

        return cursor.prev;
    }

    // PRINT LIST
    public void print() {
        if (isEmpty()){
            System.out.println("Nothing to print. List is empty.");
        } else{
            System.out.println("Printing forwards:");
            Node cursor = head;
            while (cursor != null) {
                System.out.println(cursor.data);
                cursor = cursor.next;
            }

            System.out.println("Printing backwards:");
            Node cursor2 = tail;
            while (cursor2 != null) {
                System.out.println(cursor2.data);
                cursor2 = cursor2.prev;
            }
        }
    }

    // IS EMPTY?
    public boolean isEmpty() { return (head == null); }

    // SIZE
    public int size() { return size; }

    // DELETE LIST
    public void deleteList() {
        head = null;
        tail = null;
        size = 0;
    }
}
