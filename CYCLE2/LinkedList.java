//CYCLE2 PRM2
//Write a menu driven program to perform the following on a Single Linked List
//a.insertion at beginning
//b.insertion at end
//c.insert a node after a specific node
//d.deletion from beginning
//e.delete from end
//f.delete from a particular position


import java.util.Scanner;

class LinkedList {
  Node head;

  class Node {
    int item;
    Node next;

    Node(int d) {
      item = d;
      next = null;
    }
  }


  public void insertAtBeginning(int data)
  {
    Node new_node = new Node(data);
    new_node.next = head;
    head = new_node;
  }


  public void insertAfter(int p_data, int data)
  {
  Node p = head;
  while(p.item != p_data)
  {
  p = p.next;
  }
  Node new_node = new Node(data);
  new_node.next = p.next;
  p.next = new_node;
  }

  public void insertAtEnd(int data) {
    Node new_node = new Node(data);

    if (head == null) {
      head = new Node(data);
      return;
    }

    new_node.next = null;

    Node last = head;
    while (last.next != null)
      last = last.next;

    last.next = new_node;
    return;
  }

  void deleteAtBeg()
  {
      if(head == null)
      return;

      Node node = head;
      head = head.next;
  }

  void deleteNodeAtPos(int position) {
    if (head == null)
      return;

    Node node = head;

    if (position == 0) {
      head = node.next;
      return;
    }

    for (int i = 1; node != null && i < position - 1; i++)
      node = node.next;

    if (node == null || node.next == null)
      return;

    Node next = node.next.next;
    node.next = next;
  }

  void deleteAtEnd()
  {
      if(head == null)
      return;

      Node node = head;
      if(head.next == null)
      {
          head = null;
          return;
      }
      while(node.next.next != null)
      {
          node = node.next;
      }
      node.next = null;
  }

  public void printList() {
    Node node = head;
    while (node != null) {
      System.out.print(node.item + "  ");
      node = node.next;
    }
  }

  public static void main(String[] args)
  {
    LinkedList l = new LinkedList();
    Scanner scan = new Scanner(System.in);

    char ch;
    do
    {
        System.out.println("\n Linked List Operations:");
        System.out.println("Choose any one\n");
        System.out.println("1. Insert at beginning");
        System.out.println("2. Insert at end");
        System.out.println("3. Insert a node after a specific node");
        System.out.println("4. Delete from beginning");
        System.out.println("5. Delete from end");
        System.out.println("6. Delete from a particular position");

        int choice = scan.nextInt();

        switch(choice)
        {
            case 1:
                System.out.println("Enter element to insert:");
                l.insertAtBeginning(scan.nextInt());
                break;

            case 2:
                System.out.println("Enter element to insert:");
                l.insertAtEnd(scan.nextInt());
                break;

            case 3:
                System.out.println("Enter element after which new element is to be inserted:");
                int n = scan.nextInt();
                System.out.println("Enter element to insert:");
                int ele = scan.nextInt();

                l.insertAfter(n,ele);
                break;

            case 4:
                l.deleteAtBeg();
                break;

            case 5:
                l.deleteAtEnd();
                break;

            case 6:
                System.out.println("Enter position:");
                int p = scan.nextInt();
                    l.deleteNodeAtPos(p);
                break;

            default:
                System.out.println("Wrong Entry \n ");
                break;
        }
         System.out.println("\nLinked list is: ");
        l.printList();
        System.out.println("\nDo you want to continue (Type y or n) \n");
        ch = scan.next().charAt(0);
    }
       while (ch == 'Y'|| ch == 'y');
  }
}
