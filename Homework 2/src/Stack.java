public class Stack {

    DoublyLinkedList list;
    private int size;
    private int capacity;       // Gave it an arbitrary capacity to check for stack overflow when using push().

    // CONSTRUCTOR
    public Stack() {
        this.list = new DoublyLinkedList();
        this.size = 0;
        this.capacity = 1000;
    }

    // PUSH
    // add an item to the top of the stack.
    // Will tell the user if the stack is too full to push new values.
    public void push(int data) {
        if (size == capacity) {
            System.out.println("Error: stack overflow.");
            return;
        }
        list.headInsert(data);
        size++;
    }

    // POP
    // Deletes the top from the list and returns its value to the user.
    // Will tell the user if the stack is empty and thus has no values to pop. Will return -1 to indicate an error.
    public int pop() {
        if (empty()){
            System.out.println("Cannot pop. Empty stack.");
            return -1;
        }
        int top = list.head.data;
        list.deleteHead();
        size--;
        return top;
    }

    // PEEK
    // Return the value at the top of the stack without popping it.
    // If list is empty, will tell the user and send back -1, indicating an error.
    public int peek() {
        if (empty()) {
            System.out.println("Stack empty.");
            return -1;
        }
        return list.head.data;
    }

    // TRAVERSE
    // Pops whole stack, printing each node as it goes until the stack is empty.
    // If the stack is empty, it will advise the user of the error.
    public String traverse() {
        if (empty()) { return "Stack is empty."; }
        String result = "";
        while (!empty()) {
            System.out.println(peek());
            result += peek() + " ";
            pop();
        }
        return result;
    }

    // DELETE STACK
    // Simply calls the delete list method from our DLL class.
    // If the stack is empty, it will advise the user of the error.
    public void deleteStack() {
        if (empty()) {
            System.out.println("Nothing to delete. Empty stack.");
            return;
        }
        list.deleteList();
    }

    // SIZE
    // Simply return the value of the size variable.
    public int size() { return size; }

    // IS EMPTY?
    // Returns a boolean to the check of if the list is empty.
    // Used in our pop, peek, and delete methods.
    public boolean empty() { return list.isEmpty(); }
}
