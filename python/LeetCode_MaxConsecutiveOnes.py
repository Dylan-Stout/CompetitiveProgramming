#
# TOO SLOW ! Figure out faster way than brute force
#
#
# 1004. Max Consecutive Ones III
# Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
# Return the length of the longest (contiguous) subarray that contains only 1s.
#
# EXAMPLE:
#   Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
#   Output: 6
#   Explanation:
#   [1,1,1,0,0,1,1,1,1,1,1]
#
import itertools

class Solution(object):
    def longestOnes(self,A,K):
        """
                Return the longest consecutive subsequence of 1's given the opportunity to
                change K number of 'zero' values in A to 1.
                :type A: List[int]
                :type K: int
                :rtype: int
        """
        if len(A) <= K:
            return K
        zero_positions = []
        max_result = 0
        for i, num in enumerate(A):
            if num == 0:
                zero_positions.append(i)
        for comb in itertools.combinations(zero_positions, K):
            cur = 0
            for i in range(len(A)):
                if A[i] == 1 or i in comb:
                    cur += 1
                else:
                    if cur > max_result:
                        max_result = cur
                    cur = 0
        if cur != 0 and cur > max_result:
            max_result = cur
        return max_result

if __name__ == '__main__':
    sol = Solution()
    print(sol.longestOnes([1,1,1,0,0,0,1,1,1,1,0],2)) # expected 6
    print(sol.longestOnes([0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1],3)) #expected 10
    print(sol.longestOnes([1,1,1,0,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,1,0,1,1,1,1,1,1,0,1,0,0,0,0,1,0,1,1,0,1,0,1,0,0,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,0,0,0,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,1,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,1,0,1,0,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0,1,0,0,1,0,0,0,0,1,1,0,1,1,1,0,0,1,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,1,1,1,1,0,0,1,0,0,0,0,1,1,1,1,0,0,1,0,0,1,0,0,0,0,0,1,1,0,1,1,0,1,0,0,1,1,1,0,1,0,0,0,0,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,1,1,1,1,1,0,0,1,1,0,1,1,1,0,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,1,1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,1,0,1,1,1,0,1,1,0,1,0,0,1,0,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1,0,1,1,0,0,1,0,0,1,0,1,1,1,1,1,0,1,0,0,0,0,1,1,0,1,1,0,1,1,0,1,0,1,1,1,0,0,1,0,1,1,0,0,0,0,1,1,0,1,1,1,0,1,1,1,1,0,0,1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,1,1,1,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1,0,0,1,0,1,0,0,1,1,1,0,1,0,1,1,0,0,1,1,0,1,1,0,0,0,0,0,0,0,1,0,1,1,0,1,1,0,0,0,0,0,0,1,0,1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0,0,1,0,1,1,1,1,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,0,1,1,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,1,1,1,1,0,1,0,1,0,0,0,0,0,1,0,0,1,0,0,1,1,0,0,1,1],144))
