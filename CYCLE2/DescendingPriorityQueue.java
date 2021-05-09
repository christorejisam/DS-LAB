// CYCLE 2 PROGRAM 5
// Write a java program to implement a descending priority queue using singly linked list.


import java.io.*;

class Link {
    int data;
    Link next;

    public Link( int data ) {
        this.data = data;
    }
}

class LinkedList {
    Link first = null;

    public void insert( int data ) {
        Link newLink = new Link(data);
        if ( first == null )
            first = newLink;
        else if ( newLink.data > first.data ) {
            newLink.next = first;
            first = newLink;
        }
        else {
            Link current = first;
            while ( current.next != null ) {
                if ( current.next.data > newLink.data ) {
                    current = current.next;
                } else break;
            }
            newLink.next = current.next;
            current.next = newLink;
        }
    }

    public void remove() {
        if ( !isEmpty() ) {
            first = first.next;
            // if ( current.next == null ) {
            //     first = null;
            // } else {
            //     while ( current.next.next != null ) current = current.next;
            //     current.next = null;
            // }
        } else {
            System.out.print("Priority Queue is empty!!!");
        }
    }

    public void displayList() {
        Link current = first;
        if ( isEmpty() )
            System.out.print("List is empty!!!");
        else {
            System.out.print("Linkedlist: ");
            System.out.print(current.data);
            while ( current.next != null ) {
                current = current.next;
                System.out.print(" --> " + current.data);
            }
        }
        System.out.println('\n');
    }


    public int peekMax() {
        return first.data;
    }

    public int peekMin() {
        Link current = first;
        while ( current.next != null ) current = current.next;
        return current.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

class DescendingPriorityQueue {
    public static void main(String args[]) throws IOException {
        LinkedList l = new LinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int element, choice = 1;
        while ( choice != 0 ) {
            System.out.println("--Descending Priority Queue--");
            System.out.println("-------------MENU------------");
            System.out.println("1. Insert a Element");
            System.out.println("2. Delete a Element");
            System.out.println("3. Peek Maximum");
            System.out.println("4. Peek Minimum");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: (1/2/3/4/0) ");
            choice = Integer.parseInt(br.readLine());
            switch(choice) {
                case 1:
                    System.out.println("Enter the element to be added: ");
                    element = Integer.parseInt(br.readLine());
                    l.insert(element);
                    l.displayList();
                    break;
                case 2:
                    System.out.println("Deleting element");
                    l.remove();
                    l.displayList();
                    break;
                case 3:
                    System.out.println("Peek Max: " + l.peekMax());
                    l.displayList();
                    break;
                case 4:
                    System.out.println("Peek Min: " + l.peekMin());
                    l.displayList();
                    break;
                case 0:
                    System.out.println("Exiting.....Bye..!!");
                    break;
                default:
                    System.out.println("Invalid Choice! Try Again!");
                    l.displayList();
            }
        }
    }
}
