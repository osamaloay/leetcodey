
import java.util.HashMap;
import java.util.Stack;
import java.util.Dictionary;

public class Solution {

   /* public int[] dailyTemperatures(int[] temperatures) {
    int [] res = new int [temperatures.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i=0;i<temperatures.length;i++)
            mp.put(temperatures[i],i); // puts the tempreature as key and value is its index

    for(int i=temperatures.length-1;i>=0;i--){
        while (!st.isEmpty() && st.peek()<=temperatures[i]){
            st.pop();
        }
        int index = st.isEmpty()?0:mp.get(st.peek())-i;
        res[i]=index;
        st.push(temperatures[i]);
    }



    can't use the hashmap since it doesn't allow the duplicate keys

    return  res;
    }*/



    public int[] dailyTemperatures(int[] temperatures){
        int [] res= new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){

            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
            }

            int diffInDays = st.isEmpty() ? 0:st.peek()-i;
            res[i] = diffInDays;
            st.push(i);
        }



        return res;
    }
}
