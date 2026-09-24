> I use BFS with a queue, because bfs traverse the tree level by level. 

> At the beginning of each iteration, I store q.size() to know how many nodes belong to the current level. 

> I go through all the nodes in the current level and put their children into the queue. 

> Once I finish the current level, I increase the depth by one. When there are no more nodes in the queue, I return the depth.