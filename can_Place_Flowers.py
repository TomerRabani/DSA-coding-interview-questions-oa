class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        
        if [0]==flowerbed and n==1: return 1
        count, mx = 0, 0
        
        if flowerbed[0]==0:
            count = 1
        
        for v in flowerbed:
            if v==0:
                count +=1
            else:
                # print(count)
                mx += int((count -1) /2 ) 
                count = 0
                if mx>= n :
                    return 1
        if count >0:
#             mx += int((count-1 +1) /2 ) 
            mx += int((count) /2 ) 
  
        return n<=mx
    
