# given a list, return a list of lists containing all in-place permutations
def permute(nums):
    if len(nums) == 0:
        return []
    if len(nums)==1:
        return [nums]
    results = []
    for i in range(len(nums)):
        pivot = nums[i]
        rest = nums[:i] + nums[i+1:]
        for p in permute(rest):
            results.append([pivot] + p)
    return results



if __name__ == '__main__':
    print(permute([1, 2, 3]))
    print(permute([1,2,3,4]))
    print(permute([1,2,3,4,5,6,7]))