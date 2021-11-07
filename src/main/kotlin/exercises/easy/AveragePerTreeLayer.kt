package exercises.easy

/**
 * You have a binary tree. Find the average per layer.
 *
 * 		 8
 * 	  5    1
 *  7  3  2  4
 *       9     1
 *
 * Output: [8, 3, 4, 5]
 *
 * 1. create node for tree
 * 2. BFS and collect each layer into an array and it into a map
 * 		- receive the root node and layer number
 * 		- if layer number is empty, create empty list
 * 		- add the root value to the layer
 * 		- iterate to left and right nodes
 * 3. calc avg for each array of the map and save them into new array
 *
 */

fun main() {

    val rootNode = Node(8, Node(5, Node(7), Node(3)), Node(1, Node(2, Node(9)), Node(4, null, Node(1)) ))
    print(calcAverage(collect(rootNode, HashMap())))

}

private data class Node(val value: Int, val left: Node? = null, val right: Node? = null)

private fun collect(root: Node?, map: HashMap<Int, ArrayList<Int>>, layerNumber: Int = 0): HashMap<Int, ArrayList<Int>> {
    if(root == null) return HashMap()

    if(map[layerNumber] == null){
        map[layerNumber] = arrayListOf()
    }

    map[layerNumber]?.add(root.value)

    collect(root.left, map, layerNumber+1)
    collect(root.right, map, layerNumber+1)

    return map
}

fun calcAverage(map: HashMap<Int, ArrayList<Int>>): List<Int>{
    val finalList = arrayListOf<Int>()
    map.values.forEach { list ->
        finalList.add(list.average().toInt())
    }
    return finalList
}