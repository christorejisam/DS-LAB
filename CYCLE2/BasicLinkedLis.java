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
    
    public void insert(int data) {
        Link newLink = new Link(data);
        if ( first == null ) {
            first = newLink;
        } else {
            Link current = null;
            current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newLink;
        }
        newLink.next = null;
    }

    public void deleteKey( int key ) {
        if ( !isEmpty() ) {
            Link current = first;
            int flag = 1;
            while ( current.next.data != key && flag == 1 ) {
                if ( current.next.next == null ) {
                    System.out.println("Element " + key + " doesn't exist!");
                    flag = 0;
                    break;
                }
                current = current.next;
            }
            if ( flag == 1)
            current.next = current.next.next;
        }
    }

    public void deleteFirst() {
        if ( !isEmpty() ) {
            Link temp = null;
            temp = first.next;
            first = temp;
        }
    }

    public void displayList() {
        Link current = first;
        if ( isEmpty() ) 
            System.out.print("List is empty!");
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

    public boolean isEmpty() {
        if ( first == null ) return true;
        return false;
    }
}

class BasicLinkedList {
    public static void main(String args[]) throws IOException {
        LinkedList l = new LinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int element, choice = 1;
        while ( choice != 0 ) {
            System.out.println("-----MENU-----");
            System.out.println("1. Add to Linked List");
            System.out.println("2. Delete from Beginning");
            System.out.println("3. Delete element according to key");
            System.out.println("0. Exit from program");
            System.out.println("Enter your choice: (1/2/3) ");
            choice = Integer.parseInt(br.readLine());
            switch(choice) {
                case 1: 
                    System.out.println("Enter the element to be added");
                    element = Integer.parseInt(br.readLine());
                    l.insert(element);
                    l.displayList();
                    break;
                case 2:
                    System.out.println("Deleting the element at the beginning");
                    l.deleteFirst();
                    l.displayList();
                    break;
                case 3:
                    System.out.println("Enter the value of element to be deleted: ");
                    element = Integer.parseInt(br.readLine());
                    System.out.println("Deleting the element at the position " + element);
                    l.deleteKey(element);
                    l.displayList();
                    break;
                case 0: 
                    System.out.println("Exiting... Bye");
                    break;
                default: 
                    System.out.println("Invalid Choice! Try Again!");
                    l.displayList();
            }
        }
    }
}
