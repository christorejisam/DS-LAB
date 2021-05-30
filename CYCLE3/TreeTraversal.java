// CYCLE 3 PROGRAM 1
// QUS:- Implement a binary search tree  and perform
//       1) Tree Traversals -Inorder, Preorder & Postorder
//       2)Search methods-BFS & DFS

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Link {
    int data;
    Link left, right;

    public Link(int data) {
        this.data = data;
    }
}

class BinaryTree {
    Link root;

    BinaryTree() {
        root = null;
    }

    void printPostOrder(Link link) {
        if ( link == null ) return;
        printPostOrder(link.left);
        printPostOrder(link.right);
        System.out.print(link.data + " ");
    }

    void printPreOrder(Link link) {
        if ( link == null ) return;
        System.out.print(link.data + " ");
        printPreOrder(link.left);
        printPreOrder(link.right);
    }

    void printInOrder(Link link) {
        if ( link == null ) return;
        printInOrder(link.left);
        System.out.print(link.data + " ");
        printInOrder(link.right);
    }

    void insertLink(int data) {
        Link newLink = new Link(data);
        if ( root == null ) {
            root = newLink;
            return;
        }

        Link current = root;
        Link temp;

        while ( true ) {
            temp = current;
            if ( data < current.data ) {
                current = current.left;
                if ( current == null ) {
                    temp.left = newLink;
                    return;
                }
            } else {
                current = current.right;
                if ( current == null ) {
                    temp.right = newLink;
                    return;
                }
            }
        }
    }

    void binaryFirstSearch(Link root, int data) {
        Queue<Link> queue = new LinkedList<Link>();
        queue.add(root);
        int position = 0;
        boolean found = false;
        System.out.println("BFS Order: ");
        while (!queue.isEmpty()) {
            Link tempLink = queue.poll();
            if ( tempLink.data == data ) found = true;
            System.out.print(tempLink.data + " ");
            if (tempLink.left != null) {
                queue.add(tempLink.left);
                if ( !found ) position++;
            }
            if (tempLink.right != null) {
                queue.add(tempLink.right);
                if ( !found ) position++;
            }
        }
        if (found)
            System.out.println("\nFound " + data + " at position " + ((int)position + 1));
        else
            System.out.println("\nDoes not exist in the tree");
    }

    void depthFirstSearch(Link root, int data) {
        if ( root == null ) return;
        Stack<Link> stack = new Stack<Link>();
        Link tempLink = root;
        int position = 0;
        boolean found = false;
        System.out.println("DFS Order: ");
        while ( tempLink != null || stack.size() > 0 ) {
            while ( tempLink != null ) {
                stack.push(tempLink);
                tempLink = tempLink.left;
            }
            tempLink = stack.pop();
            if ( !found ) position++;
            System.out.print(tempLink.data + " ");
            if ( tempLink.data == data) found = true;
            tempLink = tempLink.right;
        }
        if ( found )
            System.out.println("\nFound " + data + " at position " + ((int)position + 1));
        else
            System.out.println("\nDoes not exist in the tree");
    }
}

public class TreeTraversal {
    public static void main(String args[]) throws IOException {
        BinaryTree tree = new BinaryTree();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data, choice = -1;
        while ( choice != 0 ) {
            System.out.println("\n-------------MENU------------");
            System.out.println("1. Insert Elements ");
            System.out.println("2. In-order Traversal");
            System.out.println("3. Pre-order Traversal");
            System.out.println("4. Post-order Traversal");
            System.out.println("5. BFS Search");
            System.out.println("6. DFS Search");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(br.readLine());
            switch(choice){
                case 1:
                    System.out.println("Enter data to inserted: ");
                    data = Integer.parseInt(br.readLine());
                    tree.insertLink(data);
                    break;
                case 2:
                    System.out.print("In-order traversal: ");
                    tree.printInOrder(tree.root);
                    break;
                case 3:
                    System.out.print("Pre-order traversal: ");
                    tree.printPreOrder(tree.root);
                    break;
                case 4:
                    System.out.print("Post-order traversal: ");
                    tree.printPostOrder(tree.root);
                    break;
                case 5:
                    System.out.println("Enter the data to be searched for: ");
                    data = Integer.parseInt(br.readLine());
                    tree.binaryFirstSearch(tree.root, data);
                    break;
                case 6:
                    System.out.println("Enter the data to be searched for: ");
                    data = Integer.parseInt(br.readLine());
                    tree.depthFirstSearch(tree.root, data);
                    break;
                case 0:
                    System.out.println("Exiting.....Bye..!!");
                    br.close();
                    return;
                default : System.out.println("Invalid Choice! Try Again!");
            }
        }
    }
}
