
# Cost Evaluation


# https://aonecode.com/oa-cloudfront-caching

import math

class node:
    val:int
    adj:set[int] 
    def __init__(self, val:int):
        self.val = val
        self.adj = set()
        
        
def dfs(v:int, visited:set, gr:list, vert:dict)->list:
    # print('dfs', v)
    visited.add(v)
    gr.append(v)
    if v in vert.keys():
        # print(v,vert[v].adj)
        for i in vert[v].adj:
            if i not in visited:
                dfs(i, visited, gr, vert)
    return gr


def costEvaluation(n:int, connections):
    vert = {}
    
    for cp in connections :
        # print(cp, index)
        v0, v1  = cp[0],cp[1]
        for v in cp:
            if v not in vert:
                vert[v] = node(v)
        vert[v0].adj.add(v1)
        vert[v1].adj.add(v0)
    
    result =0
    visited = set()
    for i in range(0, n):
        if i not in vert.keys():
            result+=1
        else:
            if i not in visited:
                group = []
                dfs(i, visited, group, vert)
                # print(group)
                result += ceil(sqrt( len(group)))
    return result

print (costEvaluation(10, [[2, 6], [3, 5], [0, 1], [2, 9], [5, 6] ] ) )    
    # ['[2, 6]', '[3, 5]', '[0, 1]', '[2, 9]', '[5, 6]']
    # 01 23569 478
    # 2.  3.     3
