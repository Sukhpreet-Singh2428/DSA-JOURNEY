// class Data{
//     private Integer num;
//     private String name;
//     private InternalData internalData;   //? So we can have custom class within a custom class
//     Data(int _num, String _name, int _revenue){
//         this.num = _num;
//         this.name = _name;
//         this.internalData = new InternalData(_revenue);
//     }
//     public void setNum(Integer _num){
//         this.num = _num;
//     }
//     public void setName(String _name){
//         this.name = _name;
//     }
//     public Integer getNum(){
//         return num;
//     }
//     public String getName(){
//         return name;
//     }
// }

// class InternalData {
//     public Integer revenue;
//     InternalData(Integer _revenue){
//         this.revenue = _revenue;
//     }
// }

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;
import java.util.*;   //? this will import everything
// import java.util.LinkedList;
// import java.util.Stack;
// import java.util.HashSet;
// import java.util.Vector;
// import java.util.TreeSet;
// import java.util.ArrayDeque;
// import java.util.HashMap;
// import java.util.PriorityQueue;
// import java.util.Set;
// import java.util.TreeMap;

public class JavaCollectionFramework {
    public static Comparator<Integer> geComparator(){
        return  new Comparator<Integer>() {
            //? [num1, num2]
            @Override
            public int compare(Integer num1, Integer num2){
                //? num1 < num2
                //? Order is wrong
                if(num1 < num2){
                    return 1;
                }
                else if(num1 > num2){
                    return -1;
                }
                return 0;
            }
        };
    }
    public static void main(String[] args){

        //* Custom class : 

        // Integer num = 5;    //? In Java, int is a primitive data type while Integer is a Wrapper class
        // String name = "Sukhpreet";
        //! int, being a primitive data type has got less flexibility. We can only store the binary value of an integer in it.
        //! Since Integer is a wrapper class for int data type, it gives us more flexibility in storing, converting and manipulating an int data.
        //! Integer is a class and thus it can call various in-built methods defined in the class. Variables of type Integer store references to Integer objects, just as with any other reference (object) type.

        // Data dataObj1 = new Data(9, "Sukhpreet", 10000);
        // Data dataobj2 = new Data(7, "TUF", 100);
        // dataObj1.name = "Striver";  //? when data is public
        // System.out.println(dataobj2.name);
        // dataObj1.setName("Striver");
        // System.out.println(dataobj2.getName());


        //* Collection (is an interface)
        //! Collection : 
        //!  a. List   (is an interface)
        //!     i. ArrayList    (class)
        //!     ii. LinkedList  (class)
        //!     iii. Stack      (class)
        //!     iv. Vector      (class)
        //! b. Set      (interface)
        //!     i. HashSet   (class)
        //!     ii. TreeSet  (class)
        //! c. Queue   (interface)
        //!     i. ArrayDeque   (class)
        //!     ii. LinkedList  (class)
        //!     iii. PriorityQueue  (class)

        //* List : 

        //! ArrayList : 
        // ArrayList<Integer> aList = new ArrayList<>(); //* ArrayList is in Dynamic in nature. It is one ended List, you can only add from the end (back)
        //// int arr[] = new int[100];  //? This is an array. Array are constant in Size and starts from 0 index
        // aList.add(10);
        // aList.add(16);
        // aList.add(20);
        // aList.add(12);
        // System.out.println(aList);  //? [10, 16, 20, 12]
        // System.out.println(aList.size());  //? 4
        // System.out.println(aList.get(3));  //? 12
        // System.out.println(aList.remove(2)); //? 20
        // System.out.println(aList); //? [10, 16, 12]
        // aList.add(1, 17);
        // System.out.println(aList);  //? [10, 17, 16, 12]
        // aList.clear();
        // System.out.println(aList.contains(17));  //? true

        //! LinkedList : 
        // LinkedList<Integer> ll = new LinkedList<>(); 
        //* The diff. from ArrayList is it is an Two ended List : it allows to add from end and from front as well
        // ll.add(1);
        // ll.add(2);
        // ll.addFirst(3);
        // ll.addLast(6);  //? add and addLast, both are same
        // System.out.println(ll);  //? [3, 1, 2, 6]
        // ll.removeFirst();
        // System.out.println(ll.removeLast()); //? 6
        // System.out.println(ll);  //? [1, 2]
        // System.out.println(ll.size());  //? 2
        // System.out.println(ll.contains(1)); //? true

        //! Stack : 
        //* LIFO : Last in First Out
        // Stack<Integer> st = new Stack<>();
        // st.push(2);
        // st.push(4);
        // st.push(6);
        // System.out.println(st);   //? [2, 4, 6]
        // System.out.println(st.peek());  //? 6
        // st.pop();
        // System.out.println(st.peek());  //? 4
        // System.out.println(st.isEmpty()); //? false
        // System.out.println(st.size()); //? 2

        //? Vector : 
        //* This is exactly same as ArrayList, the Only diff. is it is Thread Safe
        // Vector<Integer> vec = new Vector<>();
        // vec.add(5);
        // vec.add(10);
        // vec.add(15);
        // System.out.println(vec);  //? [5, 10, 15]
        // vec.add(1, 6);
        // System.out.println(vec);  //? [5, 6, 10, 15]
        // System.out.println(vec.size()); //? 4
        // System.out.println(vec.get(2)); //? 10
        // vec.remove(1);
        // System.out.println(vec); //? [5, 10, 15]
        //? all others.. similiar to ArrayList 


        //* Set : 

        //! HashSet :  takes O(1) time to add
        // HashSet<Integer> hs = new HashSet<>();
        //* HashSet is a Data Structure that stores unique elements in any random order
        // hs.add(1);
        // hs.add(2);
        // hs.add(1);
        // hs.add(0);
        // System.out.println(hs);  //? [0, 1, 2]
        // hs.remove(2);
        // for(Integer num : hs){
        //     System.out.println(num);
        // }
        // for(var num : hs){   //? var : java automatically finds where it is String, Integer or other.
        //     System.out.println(num);
        // }
        //? and more....
        //? like .size(), .equals(another HashSet), .contains(), isEmpty(), etc

        //! TreeSet :  takes O(logN) time to add 
        //* TreeSet is a Data Structure that Stores unique elements in Sorted Order
        // TreeSet<Integer> ts = new TreeSet<>();
        // ts.add(12);
        // ts.add(9);
        // ts.add(1);
        // ts.add(4);
        // System.out.println(ts); //? [1, 4, 9, 12]
        // for(var num: ts){
        //     System.out.println(num);
        // }
        // System.out.println(ts.floor(8)); //* 4 , <= 8 : It prints the first value that is less than 8
        // System.out.println(ts.ceiling(8));  //* 9 , >= 8 : It prints the first value that is greater than 8
        //? and all other same can apply here too
        //? like .size(), .remove(), .equals(another HashSet), .contains(), isEmpty(), etc
        

        //* Queue :  (FIFO)

        //! ArrayDeque : 
        // ArrayDeque<Integer> ad = new ArrayDeque<>();
        // ad.offer(2);
        // ad.offer(6);
        // ad.offer(9);
        // ad.offer(10);
        // System.out.println(ad);  //? [2, 6, 9, 10]
        // System.out.println(ad.peek());  //? 2
        // ad.poll();
        // System.out.println(ad.peek()); //? 6
        // System.out.println(ad.size()); //? 3
        //? there is also .offerFirst and .offerLast as the Deque is an two ended data structure
        //? and others....

        //! LinkedList 
        //? Already Done !

        //! Priority Queue  (Min Heap)
        //* Stores elements
        //* and whenever you ask for peek, it gives you the smallest element
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // pq.offer(1);
        // pq.offer(0);
        // pq.offer(5);
        // pq.offer(4);
        // System.out.println(pq);  //? [0, 1, 5, 4]
        // System.out.println(pq.peek());  //? 0
        // pq.poll();
        // System.out.println(pq.peek());  //? 1
        // pq.poll(); 
        // System.out.println(pq.peek());  //? 4  <----
        // while(pq.isEmpty() == false){
        //     System.out.println(pq.peek());
        //     pq.poll();
        // }


        //! Map : 
        //! a. HashMap
        //! b. TreeMap

        //* HashMap
        //? Key, value
        // HashMap<Integer, String> mp = new HashMap<>();
        // mp.put(1, "Raj");
        // mp.put(2, "vikram");
        // mp.put(3, "Rima");
        // System.out.println(mp);  //? {1=Raj, 2=vikram, 3=Rima}
        // System.out.println(mp.get(3));  //? Rima
        // System.out.println(mp.size());
        // mp.remove(2);
        // System.out.println(mp);  //? {1=Raj, 3=Rima}
        // System.out.println(mp.get(4));  //? null

        //* TreeMap 
        //? key, value 
        //? Sorted Order of Keys
        // TreeMap<Integer, String> tmp = new TreeMap<>();
        // tmp.put(12, "vikram");
        // tmp.put(1, "Raj");
        // tmp.put(8, "Rima");
        // System.out.println(tmp);  //? {1=Raj, 8=Rima, 12=vikram}
        //? Others are as same as in HashMap 
        //? Extra are : 
        // System.out.println(tmp.ceilingKey(2));  //? 8
        // System.out.println(tmp.floorKey(2));  //? 1
        // Set<Integer> st = tmp.keySet();
        // System.out.println(st);  //? [1, 8, 12]


        //! Iterator : 
        //!  a. ListIterator
        // List<Integer> al = new ArrayList<>();
        // al.add(1);
        // al.add(5);
        // al.add(4);
        // // for(var num : al){
        // //     System.out.println(num);
        // // }
        // Iterator<Integer> iterator = al.iterator();
        // while(iterator.hasNext()){
        //     Integer num = iterator.next();
        //     System.out.println(num);
        // }


        //! Common Algorithms : 
        // List<Integer> al = new ArrayList<>();
        // al.add(1);
        // al.add(5);
        // al.add(4);
        // System.out.println(al);  //? [1, 5, 4]
        // Collections.sort(al);
        // System.out.println(al);  //? [1, 4, 5]
        // System.out.println(Collections.max(al));  //? 5
        // System.out.println(Collections.min(al));  //? 1
        // Collections.reverse(al);
        // System.out.println(al);  //? [5, 4, 1]
        // System.out.println(Collections.frequency(al, 5)); //? 1

        // int[] arr = new int[5];
        // arr[0] = 1;
        // arr[1] = 6;
        // arr[2] = 7;
        // arr[3] = 9;
        // arr[4] = 1;
        // Arrays.sort(arr);
        // for(var num : arr){
        //     System.out.println(num);
        // }

        // int num = (int) Math.pow(2, 5);
        // System.out.println(num);  //? 32


        //! Custom Comparator : 
        // ArrayList<Integer> al = new ArrayList<>();
        // al.add(1);
        // al.add(5);
        // al.add(4);
        //* sort it in the descending order
        // Collections.sort(al, new Comparator<Integer>() {
        //     //? [num1, num2]
        //     @Override
        //     public int compare(Integer num1, Integer num2){
        //         //? num1 < num2
        //         //? Order is wrong
        //         if(num1 < num2){
        //             return 1;
        //         }
        //         else if(num1 > num2){
        //             return -1;
        //         }
        //         return 0;
        //     }
        // });
        //? or 
        // Collections.sort(al, geComparator()); //? Write the same above thing into method for better readiability
        // System.out.println(al);  //? [5, 4, 1]

        //* Lambda Functions
        //? [num1, num2]
        //? num1 < num2 -> worng order, swap means return positive
        //? num1 < num2 -> correct order
        // Collections.sort(al, (num1, num2) -> num2 - num1);
        // System.out.println(al);  //? [5, 4, 1]


        //? Max Heap
        //? which returns the max elements when you poll the top element
        PriorityQueue<Integer> pq = new PriorityQueue<>(geComparator());
        pq.add(1);
        pq.add(5);
        pq.add(3);
        System.out.println(pq.poll());  //? 5
    }
}
