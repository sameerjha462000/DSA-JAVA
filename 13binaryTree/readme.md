    /**
     * Tree (By the way this is a Binary search tree now that i see this)
     * because its inorder is sorted already
     *      ___50
     *     /     \
     *    25     75
     *   / \    / \
     *  12 37  62  87
     *     /    \
     *    30    70
     * 
     * preorder : root left right -- 50 25 12 37 30 75 62 70 87
     * inorder : left root right -- 12 25 30 37 50 62 70 75 87
     * postorder : left right root -- 12 30 37 25 70 62 87 75 50
     **/

Binary trees

    In a binary tree, each node can have at most 2 children
    leaf nodes -- nodes having no child
    root node -- node from which the tree starts
    size -- no of nodes in the BT
    height -- there are two ways to define this. One is defined as the number of the nodes in the longest path from root node to a leaf node(including both of them)
    The other way could be -- the number of edges in the longest path from a root node to a leaf node
    Generally second one is called height.
