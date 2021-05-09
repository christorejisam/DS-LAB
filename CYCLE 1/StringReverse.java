//CYCLE 1 PRM 4
//Write a program to reverse a string using stack

import java.io.*;

class newStack {
	private int max, top;
	private char[] arr;

	public newStack(int size) {
		max = size;
		arr = new char[max];
		top = -1;
	}

	public void push( char item ) {
		arr[++top] = item;
	}

	public char pop() {
		return arr[top--];
	}
}

class StringReverse {
    public static void main(String args[]) throws IOException {
        String inputString, reveredString = "";
		System.out.println("Enter the string to be reversed: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputString = br.readLine();
        int size = inputString.length();
        newStack s = new newStack(size);
        for ( int i = 0; i < size; i++)
            s.push(inputString.charAt(i));
        for ( int i = 0; i < size; i++)
            reveredString += s.pop();
        System.out.println("Reversed String: " + reveredString);
    }
}
