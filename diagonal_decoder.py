# https://leetcode.com/discuss/interview-question/1317796/amazon-oa-2021-hackerrank
# Decode the input string into original string.

#  You are given an encoded string  and number of rows, Convert it to original string
  
#  Input: mnesi___ya__k____mime  N = 3
  
#  Output : my name is mike

#  Explanation : Read the matrix in a diagonal way starting from [0][0] index until the end of row and start from the top
#  again to decode it. _ are treated as space.
 
#  m n e s i _  _
      
#   _ y a _ _ k _
 	   
#   _ _ _ m i m e



def decode(s:str, n:int) -> str:
    # print(s)
    result = []
    
    slen = len(s)
    rowl = int(slen /n)
    skip = (rowl+1)
    
    for i in range(0, rowl):# loc in first row
        for j in range(0, n):
            p = i + j * skip
            p = p if p < slen else p-rowl
            c = s[p]
            result+= [c if c!='_' else ' ']
            
    return str.join('', result)

s = decode("mnesi___ya__k____mime"  ,3)
print(s)
           
