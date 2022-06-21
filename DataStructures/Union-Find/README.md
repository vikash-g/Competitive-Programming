# Union Find (Disjoint Set)

Union-Find is a data structure that keeps track of elements which are split into one or more disjoint sets.
It has two primary operation: `union` and `find`.

`union(p, q)`: To connect p and q, find which are the root nodes of each element and if the root nodes are different make one of the root nodes be the parent of the other.

`find(p)`: To find which component p belongs to, find the root of p by following the parent nodes until a self loop is reached (a node who's parent is itself).

It can also support following operations:
* `components()`: Number of components.
* `componentWeight(p)`: The weight of component containing element p.
* `connected(p, q)`: Check if p is connected to q or not i.e. if they are part of same component.</br>
    We assume `is connected to` is an equivalence relation:
    * Reflexive: `p` is connected to `p`.
    * Symmetric: If `p` is connect to `q`, then `q` is connected to `p`.
    * Transitive: If `p` is connected to `q` and `q` is connected to `r`, then `p` is connected to `r`.</br>

*`Connected component is a maximal set of objects that are mutually connected.`*

In this data structure, we do not "un-union" or "disconnect" elements. In general, this would be very inefficient to do since we would have to update all the children of a node.

Initially the number of components is equal to the number of elements. The number of components will keep decreasing as we keep connecting more and more nodes of different components. Also, note that the nmber of root nodes never increases.

There are multiple variants of Union-Find. Each variant either optimizes `union` or `find` or both operations.

---

## Quick Find [eager approach]
* It contains an integer array id[] or size N. id[i] is the parent of node i.
* Interpretation: p and q are connected iff they have the same id.

Union: To merge components containing p and q, change all entries whose id equals id[p] to id[q].</br>
Find: Check if p and q have same id.

```java
public class QuickFind {
    private final int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; ++i) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
```
*PS: Union operation is too costly in Quick Find.*

---

## Quick Union [lazy approach]
* Root of i is id[id[...id[i]...]]

Union: To merge components containing p and q, set the id of p's root to the id of q's root.</br>
Find: Check if p and q have the same root.

```java
public class QuickUnion {
    private final int[] id;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
```
*PS: Finding root is costly when tree is skewed.*

---

## Weighted Quick Union
* In this we maintain an extra array weight[i] to keep the weight of node in the tree rooted at i.

Union: We link the root of smaller tree to the root of larger tree and also update the weight of larger tree with weight of samller tree.</br>

Find: identical to quick-union.</br>
    *`return root(p) == root(q)`*

```java
public class WeightedQuickUnion {
    private final int[] id;
    private final int[] weight;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        weight = new int[N];
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }

        if (weight[i] < weight[j]) {
            id[i] = j;
            weight[j] += weight[i];
        } else {
            id[j] = i;
            weight[i] += weight[j];
        }
    }
}
```
*PS: Union and Find both operation can be log(N)*

---

## Quick union with path compression

Just after computing the root of p, set the id of each encountered node to point to that root.

Two-pass implementation: add second loop to root() to set the id[] of each examined node to the root.

Simpler one-pass variant: Make every other node in path point to its grandparent (thereby halving path length);

```java
private int root(int i) {
    while (i != id[i]) {
        id[i] = id[id[i]];
        i = id[i];
    }
    return i;
}
```
*PS: It gives the amortized time complexity of O(1) as the tree height keeps reducing after each union/find operation*

---


## Weighted Quick Union with path compression: amortized analysis

Proposition [Hopcroft-Ulman, Tarjan] Starting from an empty data structure, any sequence of M union-find operations
on N objects makes <= c(N + M lg<sup>*</sup>N)

lg<sup>*</sup>N: number of iterations taken for log fuction to reduce N to 1

|N|lg<sup>*</sup>N|
|:---:|:---:|
|1|0|
|2|1|
|4|2|
|16|3|
|65536|4|
|2<sup>65536</sup>|5|

`iterate log function`

