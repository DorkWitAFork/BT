import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class driver {
    public static void main(String[] args){
        Stack stack = new Stack();
        try {
            File fileObj = new File("input.txt");
            Scanner sample = new Scanner(fileObj);
            PrintWriter output = new PrintWriter("output.txt");
            output.println("Sample output.txt file. Spencer Le Bleu, CSC 130. February 22, 2025.");
            while (sample.hasNextLine()) {
                String line = sample.nextLine();
                String[] words = line.split(" ");
                String command = words[0].toLowerCase();

                switch (command) {
                    case "pop":
                        if (stack.peek() == -1) {
                            output.println("Pop: Error, empty stack.");
                            break;
                        }
                        output.println("Popped: " + stack.pop());
                        break;

                    case "peek":
                        if (stack.peek() == -1) {
                            output.println("Peek: Error, empty stack.");
                            break;
                        }
                        output.println("Peek: " + stack.peek());
                        break;

                    // This command assumes there is another word.
                    case "push":
                        int num = Integer.parseInt(words[1]);
                        stack.push(num);
                        output.println("Pushed: " + num);
                        break;

                    case "traverse":
                        if (stack.peek() == -1){
                            output.println("Stack elements (top to bottom): Stack is empty!");
                            break;
                        }
                        output.print("Stack elements (top to bottom): " + stack.traverse());
                        break;

                    default:
                        output.println("Invalid command found.");
                }
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
