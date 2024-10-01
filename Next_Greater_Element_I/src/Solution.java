import java.util.HashMap;
import java.util.Stack;

class Solution {
    // monotonic stack is stack in decreasing order from bottom to top decreasing
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length];
        HashMap<Integer,Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<nums1.length;i++)
            mp.put(nums1[i],i); // the key is the number in nums1
                                // and the value is the index of this number
        for(int j=nums2.length-1;j>=0;j--){
                                                // the time complexity of containskey() is O(1)
                while (!st.isEmpty() && st.peek()<=nums2[j]){
                    st.pop();
                }
            if(mp.containsKey(nums2[j])) {
                int nextgreater = st.isEmpty() ? -1 : st.peek();
                res[mp.get(nums2[j])] = nextgreater;
            }
            st.push(nums2[j]);

        }
        return res;
    }
}