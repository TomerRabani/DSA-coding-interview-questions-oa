# https://leetcode.com/problems/missing-ranges
# print("Hello World!")

def findRanges(arr: list, start: int, end: int):
    # print(0)
    reader = start
    out = ''
    if start < arr[0]:
        out = str(start)+' '
        # print(start, arr[0], out)
    for i,v in enumerate(arr):
        # print(v)
        if reader < v:
            if arr[i-1]+1 < v:
                out+=" "+ str(arr[i-1]+1) 
                
            out+='->'+str(v-1)+' '
            # print(reader, v, out)
            reader = v

            
        if v < reader and reader<= end:
            if v+1 == reader:
                continue
            out+= str(v+1)+ ' '
            
            
        # print('loopend ',v, reader)
        reader+=1
        
    if reader <= end:
        out+= str(reader) + ' -> ' + str(end)
        
    return out

out  = findRanges(arr=[1,2,2,2,933,933,934,935,936], start=0, end=9999)
print(out)
    
  
