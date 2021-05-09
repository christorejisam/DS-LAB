//CYCLE1 PRM 6
//WAP to perform postfix expression evaluation


import java.io.*;

class Stack {
    private float[] arr;
    private int size, top;

    public Stack(int size) {
        this.size = size;
        arr = new float[size];
        top = -1;
    }

    void push(float data) {
        arr[++top] = data;
    }
    float pop() {
        return arr[top--];
    }
}

class PostfixEvaluation {
    static float postfixEvaluation(String inputString) {
        int size = inputString.length();
        Stack s = new Stack(size);
        for ( int i = 0; i < size; i++ ) {
            char character = inputString.charAt(i);
            if ( Character.isDigit(character) ) {
                s.push(Integer.parseInt(String.valueOf(character)));
            }
            else {
                float val1 = s.pop();
                float val2 = s.pop();
                switch(character) {
                    case '+':
                        s.push(val2 + val1);
                        break;
                    case '-':
                        s.push(val2 - val1);
                        break;
                    case '/':
                        s.push(val2 / val1);
                        break;
                    case '*':
                        s.push(val2 * val1);
                        break;
                }
            }
        }
        return s.pop();
    }
    public static void main(String args[]) throws IOException {
        System.out.println("Enter the postfix string to be evaluated");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        System.out.println("Postfix Evaluation of " + inputString + " : " + postfixEvaluation(inputString));
    }
}
