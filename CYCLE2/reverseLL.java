// CYCLE 2 PROGRAM 3
//Write a program to reverse a Singly Linked List


import java.io.*;
import java.util.Scanner;

class Link {
    public int data;
    public Link next;
    public Link (int d) {
        data = d;
    }

    public void displayLink() {
        System.out.print(data);
    }
}

class LinkedList {
    public Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int element) {
        Link newLink = new Link(element);
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int element) {
        Link newLink = new Link(element);
        Link currentLink = first;
        while(currentLink.next != null) {
           currentLink = currentLink.next;
        }
        currentLink.next = newLink;

    }


    public void displayList() {
        Link currentLink = first;
        while(currentLink != null) {
            currentLink.displayLink();
            System.out.print("  ");
            currentLink = currentLink.next;
        }
        System.out.print("\n");
    }

    public Link reverse() {
    	if(first==null){
    	  return first;
    	}
        Link currentLink = first;
        Link previousLink = null;
        Link nextLink = null;
        while(currentLink != null) {
            nextLink = currentLink.next;
            currentLink.next = previousLink;
            previousLink = currentLink;
            currentLink = nextLink;

          }
	return previousLink ;

}
}

class reverseLL {
    public static void main(String[] args) {
        Scanner inp =new Scanner(System.in);
  	System.out.println("\nEnter the Size of LinkedList :");
  	int no = inp.nextInt();

        int element;
        LinkedList list = new LinkedList();
        Link link = new Link(0);

        System.out.print("Enter the element to be inserted in first: ");
        element = inp.nextInt();

        list.insertFirst(element);

        for(int i =1; i<no; i++){
                System.out.print("Enter the element to be inserted : ");
                element = inp.nextInt();
                list.insertLast(element);
            }

        System.out.print("\nThe elements of the list are : ");
        list.displayList();

        System.out.print("\n\nReversed list : ");
        list.first=list.reverse();
        list.displayList();

    }
}
