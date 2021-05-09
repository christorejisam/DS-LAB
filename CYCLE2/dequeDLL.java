// CYCLE 2 PROGRAM 4
//Write program to implement a DEQUE using Doubly Linked List.


import java.io.*;
import java.util.Scanner;

class Link
  {
    public int data;
    public Link prev, next;

    public Link(int d)
    {

      data = d;
      prev = next = null;

    }
     public void displayData(){
   System.out.print(data + " ");
  }
  };

 class Deque {
    Link front;
    Link rear;
    int Size;

    public Deque()
    {
      front = rear = null;
      Size = 0;
    }

    boolean isEmpty() { return (front == null); }
    int size() { return Size; }
    public void addRear(int data)
    {
      Link newNode = new Link(data);
      if (newNode == null)
        System.out.print("OverFlow\n");
      else {
        if (front == null)
          rear = front = newNode;
        else {
          newNode.next = front;
          front.prev = newNode;
          front = newNode;
        }
        Size++;
      }
    }

   public void addFront(int data)
    {
      Link newNode = new Link(data);
      if (newNode == null)
        System.out.print("OverFlow\n");
      else {

        if (rear == null)
          front = rear = newNode;
      else {
          newNode.prev = rear;
          rear.next = newNode;
          rear = newNode;
        }

        Size++;
      }
    }
    public void removeRear()
    {
      if (isEmpty())
        System.out.print("UnderFlow\n");
      else {
        Link temp = front;
        front = front.next;
      if (front == null)
          rear = null;
        else
          front.prev = null;
        Size--;
      }
    }

    public void removeFront()
    {

      if (isEmpty())
        System.out.print("UnderFlow\n");

      else {
        Link temp = rear;
        rear = rear.prev;

        if (rear == null)
          front = null;
        else
          rear.next = null;

        Size--;
      }
    }

        public void display() {

        Link current = front;
        if(front == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.println("Deque:: ");
        while(current != null) {

            current.displayData();
            current = current.next;
        }

    }



  }


class dequeDLL {
  public static void main(String[] args)
  {

    Scanner inp =new Scanner(System.in);
    boolean online = true;
    int ch, element;
    Deque dq = new Deque();
    while (online) {

            System.out.println("\n-------MENU-------");
            System.out.print("\n1. Insert at rear\n2. Insert at front\n3. Delete at rear\n4. Delete at front\n5. Display\n6. Exit  \n\n:");
            System.out.println("Enter your choice: (1/2/3/4/5) ");
            ch = inp.nextInt();
            System.out.println("\n");
            switch (ch) {
                case 1:
                   System.out.print("Enter the element to be inserted at rear: ");
                    element = inp.nextInt();
                   dq.addRear(element);
                    break;

                case 2:
                     System.out.print("Enter the element to be inserted at front: ");
                    element = inp.nextInt();
                   dq.addFront(element);
                    break;

                case 3:
                     dq.removeRear();
                    System.out.printf("Element deleted from rear....");
                    break;


                case 4:
                     dq.removeFront();
                    System.out.printf("Element deleted from front....");
                    break;
                case 5:

                    dq.display();
                    break;

                case 6:
                    online = false;
                    System.out.printf("Exiting....Bye");
                    break;


                default:
                     System.out.print("Invalid Choice! Try Again!");

                    break;
            }

        }
  }
}

