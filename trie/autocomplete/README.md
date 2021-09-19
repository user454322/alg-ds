# Autocomplete Trie

Trie is a tree-like data structure where its nodes hold a collection (as opposed to only 2 in binary trees) with links to other nodes.  

**Why tries tho?**  

* Operations like `search`, `delete` and `insert` can be performed in *O(n)*.

**Why not tries?**  

* It requires space. E.g., In a trie used to store the names of employees, the names of employees with the same name is stored only once, only the counter of how many words end there is incremented with each repeated name. It looks like it is space efficient.  
However, the space efficiency can be compromised with the references (kept in the collection) to the nodes.


Tries are useful in a variety of use cases. Here we are looking at the **autocompletion** case.  

This work was inspired by the [Implement TRIE | Leetcode #208 video](https://www.youtube.com/watch?v=xqsaAhQC6c8). Which explains tries and how to search in tires but it doesn't go into how to implement the actual autocompletion. 

## The implementation
As with any problem is important to conceptualize how the actual data structure looks like.

Diagram of node
Code of node

Transition to insert

comment the suggest code  

