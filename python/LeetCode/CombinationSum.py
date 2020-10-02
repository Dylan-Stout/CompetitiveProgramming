class Solution(object):
    def combinationSum(self, candidates, target):
        results = []
        for i in range(len(candidates)):
            self.sumHelper([],0, candidates,0,target,results)
        return results

    def sumHelper(self,current,cur_ind,arr,sum,target,results):
        if sum > target:
            return
        if sum == target:
            results.append(current)
            return
        while cur_ind < len(arr):
            cur_visit = list(current)
            cur_visit.append(arr[cur_ind])
            self.sumHelper(cur_visit,cur_ind,arr,sum+arr[cur_ind],target,results)
            cur_ind += 1



if __name__ == '__main__':
    sol = Solution()
    print(sol.combinationSum([1,2,3,4],6))