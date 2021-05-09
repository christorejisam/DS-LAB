//CYCLE 1 PRM 5
//Write programs to perform the following
//a)infix to postfix conversions
//b)infix to prefix conversions


import java.io.*;

class Stack {
    private char[] arr;
    private int size, top;

    public Stack(int size) {
        this.size = size;
        arr = new char[size];
        top = -1;
    }

    public void push ( char item ) {
        arr[++top] = item;
    }

    public char pop () {
        return arr[top--];
    }
    public char peek() {
        return arr[top];
    }

    public Boolean isEmpty() {
        if ( top == -1 ) return true;
        return false;
    }
}

class InfixPostfix {
    // Utility Functions
    static int precedence(char operator) {
        if ( operator == '+' || operator == '-' )
            return 0;
        else if ( operator == '*' || operator == '/' )
            return 1;
        else if ( operator == '^' )
            return 2;
        return -1;
    }

    static String reverseString(String inputString) {
        String reversedString = "";
        for ( int i = inputString.length() - 1; i >= 0 ; i-- ) {
            if ( inputString.charAt(i) == '(' ) reversedString += ')';
            else if ( inputString.charAt(i) == ')' ) reversedString += '(';
            else reversedString += inputString.charAt(i);
        }
        return reversedString;
    }

    static String infixToPostfix(String infixString) {
        String postfixString = "";
        int size = infixString.length();
        Stack s = new Stack(size);
        for ( int i = 0; i < size; i++ ) {
            char character = infixString.charAt(i);
            if ( Character.isLetterOrDigit(character)) {
                // Pushing the character if it's operand
                postfixString += character;
            }
            else if ( character == '(' ) {
                s.push(character);
            }
            else if ( character == ')' ) {
                while ( !s.isEmpty() && s.peek() != '(') {
                    // Popping the character until '(' is encountered
                    postfixString += s.pop();
                }
                s.pop(); // Removing '(' from the stack
            }
            else {
                // If it's a operator
                while ( !s.isEmpty() && precedence(character) < precedence(s.peek()))
                    postfixString += s.pop();
                s.push(character);
            }
        }
        // Popping remaining elements
        while (!s.isEmpty()) {
            if ( s.peek() == '(')
                System.out.println("Entered Infix String is Invalid");
            postfixString += s.pop();
        }
        return postfixString;
    }

    static String infixToPrefix(String infixString) {
        String prefixString = "", reversedString = "", reversedPrefix = "";

        // Reversing the infix string
        reversedString = reverseString(infixString);

        // Finding postfix expression of the reversed infix string
        reversedPrefix = infixToPostfix(reversedString);

        // Reversing the postfix of reversed infix string
        prefixString = reverseString(reversedPrefix);

        return prefixString;
    }

    public static void main(String args[]) throws IOException {
        String infixString;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        do {
            infixString = "";
            System.out.println("--------MENU-------");
            System.out.println("1. Infix to Postfix");
            System.out.println("2. Infix to Prefix");
            System.out.println("0. Exit");
            System.out.println("-------------------");
            System.out.println("Enter your choice: (1/2/0) ");
            choice = Integer.parseInt(br.readLine());
            switch(choice) {
                case 0:
                System.out.println("Exiting from the program...");
                break;
                case 1:
                    System.out.println("Enter the infix string: ");
                    infixString = br.readLine();
                    System.out.println("Postfix String: " + infixToPostfix(infixString));
                    break;
                case 2:
                    System.out.println("Enter the infix string: ");
                    infixString = br.readLine();
                    System.out.println("Prefix String: " + infixToPrefix(infixString));
                    break;
                default:
                    System.out.println("Invalid Choice! Try Again!");
            }
        }while(choice != 0);
    }
}
