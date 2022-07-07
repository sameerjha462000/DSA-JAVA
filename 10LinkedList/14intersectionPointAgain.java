import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;


// added intersectionPointAgain at 637...
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

    int midOne(){
        if(size == 0)
        {
            System.out.println("List is empty...");
            return -1;
        }

        // classic slow fast approach

        node slow = head;
        node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    int midTwo(){
        if(size == 0){
            System.out.println("List is empty...");
            return -1;
        }

        // modified slow fast approach

        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    void sort(){
        // will be apptying the classic bubblesort for sorting
        int iteration = 1;
        while(iteration < size){
            int handleStart = 0;
            int handleEnd = 1;
            while(handleEnd <= size-iteration){
                node start = getNode(handleStart);
                node end = getNode(handleEnd);

                if(start.data > end.data){
                    // swap the values
                    int temp = start.data;
                    start.data = end.data;
                    end.data = temp;
                }

                handleStart++;
                handleEnd++;
            }
            iteration++;
        }
    }

    linkedlist merg(linkedlist ltwo){
        int i=0;
        int j=0;

        int noe = size + ltwo.size;

        linkedlist ans = new linkedlist();

        while(noe-- != 0){
            int valOne = (i<size)?(getNode(i).data):Integer.MAX_VALUE;
            int valTwo = (j<ltwo.size)?(ltwo.getNode(j).data):Integer.MAX_VALUE;

            int data = (int)Math.min(valOne,valTwo);

            // System.out.println("added "+" "+i +"  "+ j);

            if(data == valOne)
                i++;
            if(data == valTwo)
                j++;

            ans.addLast(data);
            
        }
        return ans;
    }

    void reversePI(){
        if(size == 0 || size == 1)
            return;

        node prev = null;
        node curr = head;
        node hold = head.next;

        while(hold != null){
            curr.next = prev;
            prev = curr;
            curr = hold;
            hold = hold.next;
        }

        // change links one more time...
        curr.next = prev;
        curr = null;
        prev = null;
        
        // swap(head,tail);

        node temp = head;
        head = tail;
        tail = temp;

        temp = null;
    }

    boolean isPalindrome(){
        int start = 0;
        int end = size-1;

        while(start <= end){
            node startNode = getNode(start);
            node endNode = getNode(end);

            if(startNode.data != endNode.data)
                return false;
            start++;
            end--;
        }

        return true;
    }

    boolean isCircular(){
        node slow = head;
        node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                return true;
            }
        }

        return false;
    }

    node cycleHead(){
        if(isCircular()==false)
            return null;

        node slow = head;
        node fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                break;
            }
        }

        // now start moving fast and slow one step each at a time 

        fast = head;
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    void removeCycle(){
        if(isCircular()== false)
            return;

        node cycleHead = cycleHead();

        node curr = cycleHead;

        while(curr.next != cycleHead)
        {
            // System.out.println("....");
            curr = curr.next;
        }

        curr.next = null;
    }

    int lengthOfCycle(){
        if(isCircular()==false)
            return 0;

        node cycleHead = cycleHead();
        node temp = cycleHead;
        int count = 1;
        while(temp.next != cycleHead)
        {
            count++;
            temp = temp.next;
        }
        return count;
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
        l.addLast(50);
        l.addLast(60);
        l.addLast(70);

        linkedlist lOne = new linkedlist();
        lOne.addLast(80);
        lOne.addLast(90);

        lOne.tail.next = l.head;
        lOne.tail = l.tail;
        lOne.size = lOne.size + l.size;

        linkedlist lTwo = new linkedlist();
        lTwo.addLast(10);
        lTwo.addLast(20);
        lTwo.addLast(30);
        lTwo.addLast(40);
        lTwo.tail.next = l.head;
        lTwo.tail = l.tail;
        lTwo.size = lTwo.size + l.size;

        System.out.println(lOne);
        System.out.println(lTwo);
        // System.out.println(lOne.size);
        // System.out.println(lTwo.size);

        intersectionPointAgain(lOne,lTwo);

    }

    public static void intersectionPoint(linkedlist lOne,linkedlist lTwo){
        int sizeOne = lOne.size;
        int sizeTwo = lTwo.size;

        node one = lOne.head;
        node two = lTwo.head;

        int diff = -1;
        if(sizeOne > sizeTwo)
        {
            diff = sizeOne-sizeTwo;
            // list one is greater
            while(diff-- != 0){
                one = one.next;
            }

        }else{
            diff = sizeTwo-sizeOne;
            // list two is greater than or equal to listOne in size
            while(diff-- != 0){
                two = two.next;
            }
        }
        // System.out.println(one.data);
        // System.out.println(two.data);
        while(one != two){
            one = one.next;
            two = two.next;
        }

        System.out.println(one.data);
    }

    public static void intersectionPointAgain(linkedlist lOne,linkedlist lTwo){


        // Make a cycle by joining the tail of tail of lTwo to its head and then 
        // this becomes a cycle of lOne, so the intersection point of these
        // two linked list is the cycle head of lOne.
        lTwo.tail.next = lTwo.head;


        System.out.println(lOne.cycleHead().data);
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
