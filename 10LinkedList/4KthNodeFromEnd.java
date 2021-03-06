import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;


// added KthNodeFromEnd at 310...
class node{
    int data;
    node next;

    node(){

    }

    node(int val){
        data =  val;
    }
}

class linkedlist{
    node head;
    node tail;
    int size;

    linkedlist(){

    }

    void addFirst(int val){

        // first make a node with the given data
        node n = new node(val);

        if(size == 0){
            head = tail = n;
        }else{
            // list is not empty
            n.next = head;
            head = n;
        }
        n = null;
        size++;
    }

    void addLast(int val){

        // first make a new node
        node n = new node(val);

        if(size == 0){
            head = tail = n;
        }else{
            tail.next = n;
            tail = n;
        }
        n = null;
        size++;
    }

    void add(int index,int val){
        if(index == 0){
            addFirst(val);
            return;
        }

        if(index == size){
            addLast(val);
            return;
        }
        
        // index is not 0 and size

        node prev = null;
        node curr = head;

        while(index-- != 0){
            prev = curr;
            curr = curr.next;
        }

        node n = new node(val);
        prev.next = n;
        n.next = curr;

        prev = null;
        curr = null;
        n = null;
        size++;
    }

    void removeFirst(){
        if(size == 0){
            System.out.println("List is empty...");
            return;
        }

        if(size == 1){
            head = tail = null;
            size--;
            return;
        }

        node curr = head;
        head = head.next;
        curr.next = null;
        curr = null;
        size--;
    }

    void removeLast(){
        if(size == 0){
            System.out.println("List is empty...");
            return;
        }

        if(size == 1){
            removeFirst();
            return;
        }

        node curr = head;

        while(curr.next != tail){
            curr = curr.next;
        }

        curr.next = null;
        tail = curr;
        curr = null;
        size--;
    }

    void remove(int index){
        if(index < 0  || index >= size)
            return ;
        if(index == 0){
            removeFirst();
            return;
        }
        if(index == size-1){
            removeLast();
            return;
        }

        node prev = null;
        node curr = head;
        while(index--!=0){
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        curr.next = null;
        prev = curr;
        curr = null;
        size--;
    }

    int getFirst(){
        if(size == 0){
            System.out.println("List is empty...");
            return -1;
        }

        return head.data;
    }

    int getLast(){
        if(size == 0){
            System.out.println("List is empty...");
            return -1;
        }

        return tail.data;
    }

    int get(int index){
        if(size == 0){
            System.out.println("List is empty...");
            return -1;
        }else{
            // List is not empty...
            if(index < 0 || index >= size)
            {
                System.out.println("Invalid arguments");
                return -1;
            }
            if(index == 0)
            {
                return head.data;
            }

            if(index == size-1)
            {
                return tail.data;
            }

            node temp = head;

            while(index-- != 0){
                temp = temp.next;
            }

            return temp.data;
        }
    }

    boolean contains(int val){
        if(size == 0){
            System.out.println("List is empty...");
            return false;
        }

        node temp = head;
        while(temp != null){
            if(temp.data == val)
                return true;
            temp = temp.next;
        }
        return false;
    }

    void clear(){
        if(size == 0)
            return;

        head = tail = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    node getHeadNode(){
        if(size == 0){
            System.out.println("List is empty...");
            return null;
        }

        return head;
    }

    node getTailNode(){
        if(size == 0){
            System.out.println("List is empty...");
            return null;
        }

        return tail;
    }

    node getNode(int index){
        if(index < 0 || index >=size)
        {
            System.out.println("Invalid arguments...");
            return null;
        }

        if(index == 0){
            return getHeadNode();
        }

        if(index == size-1){
            return getTailNode();
        }

        node temp = head;
        while(index-- != 0){
            temp = temp.next;
        }

        return temp;
    }

    void reverseByValues(){
        if(size == 0 || size == 1)
        {
            return;
        }

        // Reverse by two pointer approach, we will just change the values in the nodes
        // and not the actual links...

        int start = 0;
        int end = size-1;

        while(start <= end){
            // swap the values in the nodes present at start and end position...
            node startNode = getNode(start);
            node endNode = getNode(end);

            // swapping of values...

            int temp = startNode.data;
            startNode.data = endNode.data;
            endNode.data = temp;

            // modify the pointers...

            start++;
            end--;
        }
    }

    int KthNodeFromEnd(int k){
        if(k < 1 || k > size)
        {
            System.out.println("Invalid arguments...");
            return -1;
        }

        if(k == 1){
            // we are talking about the tail node
            return tail.data;
        }

        if(k == size){
            return head.data;
        }

        node slow = head;
        node fast = head;

        while(k-- != 0){
            fast = fast.next;
            // k--;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    @Override
    public String toString(){
        if(size == 0)
            return "[]";

        node temp = head;
        String s = "[ ";
        while(temp != null){
            s += temp.data + " ";
            temp = temp.next;
        }
        s += "]";
        return s;
    }

}
class Main{
    public static void main(String ...args){
        initializeIO();
        linkedlist l = new linkedlist();
        l.addFirst(20);
        l.addLast(30);
        l.addFirst(40);
        l.addLast(-1);
        l.add(3,-89);
        System.out.println(l);
        l.removeLast();
        System.out.println(l);
        System.out.println(l.contains(40));
        // l.clear();
        System.out.println(l);
        l.reverseByValues();
        for(int i=0;i<5;i++){
            l.addLast(i+1);
        }
        System.out.println(l);

        System.out.println(l.KthNodeFromEnd(3));
    }

    private static void initializeIO(){
        try 
        {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        } 
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }
}
