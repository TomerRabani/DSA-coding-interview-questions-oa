# https://www.geeksforgeeks.org/k-th-missing-element-in-sorted-array/
# Given an increasing sequence a[], we need to find the K-th missing contiguous element 
# in the increasing sequence which is not present in the sequence. 
# If no k-th missing element is there output -1. 

def findKthPositive( arr: [int], k: int) -> int:
    return findKthPositive_rec( arr, k, 0 , len(arr)-1) 
    
def findKthPositive_rec(arr: [int], k: int, left: int, right: int) -> int:
    
    if(left +1 == right):
        return arr[left] + k


    m = int(left + (right-left) / 2) #m = 3

    missingOnLeft =  ( arr[m] - arr[left]) - (m-left )  #2
    #print(k, left, m , right,  missingOnLeft)
    
    if  missingOnLeft >= k:
        return findKthPositive_rec(arr, k, left, m)
    else: 
        return findKthPositive_rec(arr, k- missingOnLeft , m, right) # 3 3 4
    return -1

print( findKthPositive([2,3,5,6], 1)) #4
print( findKthPositive([2, 3, 5, 9, 10, 11, 12], 4)) #8

