> I use BFS with a queue, because bfs traverse the tree level by level. 

> At the beginning of each iteration, I store q.size() to know how many nodes belong to the current level. 

> I process exactly those nodes and add their children to the queue for the next level. 

> After processing the entire level, I increment res. When the queue becomes empty, all levels have been processed, so res is the maximum depth."