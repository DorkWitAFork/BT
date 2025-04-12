public class Deque {
    DoublyLinkedList list;
    private int size;
    private int capacity;

    public Deque(){
        this.list = new DoublyLinkedList();
        this.size = 0;
        this.capacity = 1000;
    }

    public boolean empty() { return list.isEmpty(); }
    public int size() { return list.size(); }


    // PRINT FORWARD
    // Prints the list from front to back.
    public void printForward() {
        if (empty()) {
            System.out.println("Cannot print. Deque empty.");
            return;
        }
        list.traverseForward(size());
    }

    // PRINT BACKWARD
    // Prints the list from back to front.
    public void printBackward() {
        if (empty()) {
            System.out.println("Cannot print. Deque empty.");
            return;
        }
        list.traverseBackward(size());
    }

    // PEEK END
    // Returns the value of the item at the front of the deque. Will throw an error if the deque is empty.
    public int front() {
        if (empty()){
            System.out.println("Cannot peek. Deque empty");
            return -1;
        }
        return list.head.data;
    }

    // PEEK END
    // Returns the value of the item at the back of the deque. Will throw an error if the deque is empty.
    public int back() {
        if (empty()){
            System.out.println("Cannot peek. Deque empty");
            return -1;
        }
        return list.tail.data;
    }

    // INSERT FRONT
    // Inserts an item to the front of the deque. Will throw an error if the deque is at capacity.
    public void pushFront(int data) {
        if  (size == capacity) {
            System.out.println("Cannot insert. Deque is full.");
            return;
        }
        list.headInsert(data);
        size++;
    }

    // INSERT BACK
    // Inserts an item to the back of the deque. Will throw an error if the deque is at capacity.
    public void pushBack(int data) {
        if  (size == capacity) {
            System.out.println("Cannot insert. Deque is full.");
            return;
        }
        list.tailInsert(data);
        size++;
    }

    // DELETE DEQUE
    // Will delete the entire deque. Throws an error if the deque is empty.
    public void deleteDeque() {
        if (empty()) {
            System.out.println("Nothing to delete. Deque empty.");
            return;
        }
        list.deleteList();
    }

    // POP FRONT
    // Will delete the value of the front item and return its value. Will throw an error if the deque is empty.
    public int popFront() {
        if (empty()){
            System.out.println("Nothing to delete. Deque empty.");
            return -1;
        }
        int front = list.head.data;
        list.deleteHead();
        size--;
        return front;
    }

    // POP END
    // Will delete the value of the back item and return its value. Will throw an error if the deque is empty.
    public int popBack() {
        if (empty()){
            System.out.println("Nothing to delete. Deque empty.");
            return -1;
        }
        int end = list.tail.data;
        list.deleteTail();
        size--;
        return end;
    }
}
