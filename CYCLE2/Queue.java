//CYCLE2 PRM 1
//Write a menu driven program to implement the following queue operations using array
//a.enqueue
//b.dequeue
//c.display

import java.io.*;

class newQueue {
    private int first, last, size;
    private int[] arr;

    public newQueue(int size) {
        this.size = size;
        arr = new int[size];
        first = last = 0;
    }

    public void showMenu() {
        System.out.println("-----MENU-----");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Display");
        System.out.println("0. Exit");
        System.out.println("--------------");
        System.out.println("Enter your choice: (1/2/3/0) ");
    }

    public boolean checkFull() {
        if ( last == size ) {
            System.out.println("Queue is full!");
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if ( first == last ) {
            System.out.println("Queue is Empty!");
            return true;
        }
        return false;
    }

    public void enqueue( int item ) {
        if ( checkFull() ) {
            return;
        }
        arr[last++] = item;
    }

    public void dequeue() {
        if ( isEmpty() ) {
            return;
        }
        for ( int i = 0; i < last - 1; i++ )
            arr[i] = arr[i + 1];
        last--;
    }

    public void display() {
        if ( isEmpty() )
            return;
        System.out.println("Queue Elements: \n");
        System.out.print(arr[0]);
        for ( int i = 1; i < last; i++ )
            System.out.print(" <- " + arr[i]);
    }
}

class Queue {

    public static void main(String args[]) throws IOException {
        System.out.println("Enter the number of elements in the queue: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int choice = 1;
        newQueue q = new newQueue(size);
        while ( choice != 0 ) {
            q.showMenu();
            choice = Integer.parseInt(br.readLine());
			switch ( choice ) {
				case 0:
					System.out.println("Exiting from Program...");
					break;
				case 1:
                    System.out.println("Enter the item to perform enqueue:");						int item = Integer.parseInt(br.readLine());
                    q.enqueue(item);
					break;
				case 2:
                    q.dequeue();
					break;
				case 3:
                    q.display();
					break;
				default:
					System.out.println("Invalid Choice! Try Again!");
			}
			if ( choice != 0 && choice != 3 ) {
				System.out.println("----------------");
				System.out.println("Queue after operation: ");
				q.display();
				System.out.println("\n---------------");
			}
        }
    }
}
