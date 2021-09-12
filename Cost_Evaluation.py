# Cost Evaluation


# https://aonecode.com/oa-cloudfront-caching

import math
def addToGroupOf(member, new_mem,id_gr,gr_set ):
    # print('member',member, 'new_mem',new_mem,id_gr,gr_set )
    gr = id_gr[member]
    id_gr[new_mem]= gr
    gr_set[gr].add(new_mem)
    # print(new_mem, id_gr[new_mem],gr_set[gr])

def uniteGroups(gr1, gr2, id_gr,gr_set ):
    for v in gr_set[gr2]:
        id_gr[v] = gr1
    # print('unite',gr_set[gr1] ,gr_set[gr2] )
    gr_set[gr1]   =gr_set[gr1].union(gr_set[gr2]) 
    del(gr_set[gr2])
    
def costEvaluation(n, connections):
    id_gr = {} #int, int id -> grId
    gr_set = {} # int->set
    
    for cp in connections :
        # print(cp, gr_set)
        if cp[0] not in id_gr.keys() and cp[1] not in id_gr.keys():
            gr_set[cp[0]] = {cp[0],cp[1]}
            id_gr[cp[0]] = cp[0]
            id_gr[cp[1]] = cp[0]
            # print('new gr', cp[0])
            continue
        if cp[0] in id_gr.keys() and cp[1] in id_gr.keys():
            uniteGroups(id_gr[cp[0]], id_gr[cp[1]], id_gr, gr_set)
            # print('unite')
        else:
            if cp[0] in id_gr.keys():
                addToGroupOf(cp[0],cp[1], id_gr, gr_set )
            else:
                addToGroupOf(cp[1],cp[0], id_gr, gr_set )
    
    # print( gr_set)
    result = 0
    for i in range (0, n):
        if i not in id_gr.keys():
            result+=1

    # print(len(gr_set),9999)
    for g in gr_set.values():
        # print(len(g))
        result+= math. ceil( math.sqrt(len(g)))

    return result

print (costEvaluation(10,[[2, 6], [3, 5], [0, 1], [2, 9], [5, 6] ] ) )    
    # ['[2, 6]', '[3, 5]', '[0, 1]', '[2, 9]', '[5, 6]']
    # 01 23569 478
    # 2.  3.     3
