//* Stock Span Problem
//! (Medium Problem)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//* Brute : 
class StockSpanner{
    List<Integer> ls;

    public StockSpanner(){
        ls = new ArrayList<>();
    }

    public int next(int val){
        ls.add(val);
        int cnt = 1;
        for(int i=ls.size()-2; i>=0; i--){
            if(ls.get(i) <= val) cnt++;
            else break;
        }
        return cnt;
    }
}
//? Time Complexity : O(No. of days)
//? Space Complexity : O(Total no. of next calls)


//* Optimal : 
//? Using pge concept
class pair{
    int val;
    int idx;
    public pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
class stockSpanner{
    Stack<pair> st;
    int idx;

    public stockSpanner(){
        st = new Stack<>();
        idx = -1;
    }

    public int next(int val){
        idx++;
        while(!st.isEmpty() && st.peek().val <= val){
            st.pop();
        }
        int ans = idx - (st.isEmpty() ? -1 : st.peek().idx);
        st.push(new pair(val, idx));
        return ans;
    }
}
//? Time Complexity : O(2N)
//? Space Complexity : O(N)

public class J1_Stock_Span_Problem {
    public static void main(String[] args) {
        
        //* Brute : 
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(7));
        System.out.println(obj.next(2));
        System.out.println(obj.next(1));
        System.out.println(obj.next(3));
        System.out.println(obj.next(3));
        System.out.println(obj.next(1));
        System.out.println(obj.next(8));
        //? Time Complexity : O(No. of days)
        //? Space Complexity : O(Total no. of next calls)

        //* Optimal : 
        //? Using pge concept
        stockSpanner stock = new stockSpanner();
        System.out.println(stock.next(7));
        System.out.println(stock.next(2));
        System.out.println(stock.next(1));
        System.out.println(stock.next(3));
        System.out.println(stock.next(3));
        System.out.println(stock.next(1));
        System.out.println(stock.next(8));
        //? Time Complexity : O(2N)
        //? Space Complexity : O(N)
    }
}
