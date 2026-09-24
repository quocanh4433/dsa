> I use DFS to traverse the tree, and I visit the right child before the left child. 

> I keep track of the current depth. If this is the first node I visit at this depth, I add its value to the result.

> Because I always visit the right subtree first, the first node I encounter at each depth is the rightmost node visible from the right side.

> Then I recursively visit the right child first and the left child second.