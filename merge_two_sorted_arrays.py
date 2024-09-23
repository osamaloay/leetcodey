class Solution:
    def merge(self, nums1, m, nums2, n):
        # last index of nums1
        last = m + n - 1

        # now start merging from the end
        while m > 0 and n > 0:
            if nums2[n-1] > nums1[m-1]:
                nums1[last] = nums2[n-1]
                n -= 1
            else:
                nums1[last] = nums1[m-1]
                m -= 1
            last -= 1

        # if there are still elements in nums2
        while n > 0:
            nums1[last] = nums2[n-1]
            n -= 1
            last -= 1

        return nums1

# Example usage
if __name__ == "__main__":
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3
    result = Solution().merge(nums1, m, nums2, n)
    print(result)  # Output: [1, 2, 2, 3, 5, 6]