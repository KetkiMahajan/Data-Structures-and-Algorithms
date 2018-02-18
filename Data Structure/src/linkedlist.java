import java.util.Scanner;

public class linkedlist {
    Node head;

    public static void main(String[] args) {

        System.out.println("Enter the Element");
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        linkedlist l = new linkedlist();
        l.push(x);
        l.push(30);
        l.printList();

    }

    public void push(int x) {

        Node newNode = new Node(x);

        newNode.next = head;

        head = newNode;

    }

    public void printList() {
        Node tnode = head;

        while (tnode != null) {
            System.out.print(tnode.data);
            tnode = tnode.next;
        }

    }

    class Node {
        int data;
        Node next;

        Node(int newD) {
            data = newD;
            next = null;
        }
    }
}
