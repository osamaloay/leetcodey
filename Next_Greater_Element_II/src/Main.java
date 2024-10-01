import java.security.KeyPair;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class Main {

    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> st = new Stack<>();

            // Initialize all results to -1
            for (int i = 0; i < n; i++) {
                res[i] = -1;
            }

            // Iterate through the array twice to handle the circular nature
            for (int i = 0; i < 2 * n; i++) {
                int currentIndex = i % n; // Current index in circular manner

                // Maintain the stack to find the next greater elements
                while (!st.isEmpty() && nums[currentIndex] > nums[st.peek()]) {
                    res[st.pop()] = nums[currentIndex]; // Assign the next greater element
                }

                // Push the index of the current element onto the stack only during the first pass
                if (i < n) {
                    st.push(currentIndex);
                }
            }

            return res;
        }
    }

}