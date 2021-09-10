
#  You are given an List of positions of cars as to where they are parked. You are also given an integer K. 
#  The cars needs to be covered with a roof. You have to find the minimum length of roof that takes to cover K cars.
 
#  Input : 12,6,5,2      K = 3
 
#  Explanation :  There are two possible roofs that can cover K cars. One that covers the car in 2,5,6 parking spots and
#  another roof which covers 5,6,12 parking spots. The length of these two roofs are 5 and 8 respectively. Return 5
#  since that's the roof with minimum length that covers K cars.

#  Output : 5



def min_roof_length(k:int, nums:list)->int:
    if k > len (nums):
        return 0
    
    result= pow(2,32)
    
    nums.sort()
#     print(nums)
    for i in range(0,len(nums)-k+1):
        size = nums[i+k-1] - nums[i] + 1
        result = min(result, size)
        
    
    return result
    
size = min_roof_length(5, [12,3,8,6,13])
print(size)
