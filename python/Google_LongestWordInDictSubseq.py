#
#The Challenge
# Given a string S and a set of words D, find the longest word in D that is a subsequence of S.
#
# Word W is a subsequence of S if some number of characters, possibly zero, can be deleted from S to form W, without reordering the remaining characters.
#
# Note: D can appear in any format (list, hash table, prefix tree, etc.
#
# For example, given the input of S = "abppplee" and D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"
#
# The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".
# The word "bale" is not a subsequence of S because even though S has all the right letters, they are not in the right order.
# The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.
# Learning objectives
# This question gives you the chance to practice with algorithms and data structures. It’s also a good example of why careful analysis for Big-O performance is often worthwhile, as is careful exploration of common and worst-case input conditions.
#
class Solution(object):
    # return the word in words that is longest subsequence of seq
    def longestWordInSequence(self,S,D):
        longest_word = ''
        for word in D:
            if len(S) < len(word):
                continue
            j = 0
            for i in range(len(S)):
                if j == len(word):
                    continue
                if S[i] == word[j]:
                    j+=1
            if j == len(word) and len(word) > len(longest_word):
                longest_word = word
        return longest_word


if __name__ == '__main__':
    sol = Solution()
    print(sol.longestWordInSequence("abppplee",{"able", "ale", "apple", "bale", "kangaroo"}))
 