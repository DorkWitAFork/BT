public class Queue {
    DoublyLinkedList list;
    private int size;
    private int capacity;

    // CONSTRUCTOR
    // Initializes a new empty DLL. Sets size to 0 and capacity to 1000.
    public Queue() {
        this.list = new DoublyLinkedList();
        this.size = 0;
        this.capacity = 1000;
    }

    // ENQUEUE
    // Allows user to add item to list by passing a single parameter, the value of the data.
    // Will throw an error if the list is already at capacity.
    public void enqueue(int data) {
        if (size == capacity){
            System.out.println("Error: queue is full.");
            return;
        }
        list.tailInsert(data);
        size++;
    }

    // DEQUEUE
    // Remove the front item from the queue and return its value to where it was called.
    // Will throw an error if the queue is empty.
    public int dequeue() {
        if (empty()){
            System.out.println("Cannot pop. Empty queue.");
            return -1;
        }
        int front = list.head.data;
        list.deleteHead();
        size--;
        return front;
    }

    // PEEK
    // Returns the front element without dequeuing it.
    public int peek() {
        if (empty()) {
            System.out.println("Cannot peek. Empty queue.");
            return -1;
        }
        return list.head.data;
    }

    // EMPTY
    // Returns a boolean value after checking if the queue is empty or not.
    public boolean empty() { return (list.isEmpty()); }
}
