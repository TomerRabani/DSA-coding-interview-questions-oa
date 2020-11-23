def Main():
    # a = [3, 1, 4, 1, 5, 9]
    # result = solution(a)
    # result = solution([3,2, 1, 4, 1, 5, 9])
    result = solution([1,1,1,6,1])
    
    print(result)

        
def solution(a):
    if len(a) == 0:
        return 0
    a.sort()
    total = sum(a)
    # print(total)
    
    i = 0;
    temp = total;
    while i < len(a) and temp % 3 != 0 : 
        temp = total - a[i]
        i +=1
    if i >= len(a):
        a.pop(0)
        return solution(a)
    skipi = i - 1;
        
    t = 0
    c = 0
    # print(i)
        
    for i in range(len(a)):
        if(i == skipi and c == 0):
            c+=1
            continue
        t = t + (a[i] * pow(10, i-c));
    return t

Main()
