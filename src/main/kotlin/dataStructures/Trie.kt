package dataStructures

import java.util.*

/**
 * A [Trie](https://en.wikipedia.org/wiki/Trie) is a data structure similar
 * to a graph or tree mostly used for locating specific keys from within a set.
 * These keys are often Strings, so a great example of this is an autocomplete feature.
 *
 * In order to access a key (to recover its value, change it, or remove it), the trie
 * is traversed depth-first, following the links between nodes, which represent each
 * character in the key.
 */
class Trie(val root: Node = Node()) {

    data class Node(
        var isWord: Boolean = false,
        val childNodes: MutableMap<Char, Node> = mutableMapOf()
    )

    fun addWord(word: String) {
        var node = this.root
        word.forEach { character ->
            if (node.childNodes[character] != null) {
                node = node.childNodes[character]!!
            } else {
                node.childNodes[character] = Node()
                node = node.childNodes[character]!!
            }
        }
        node.isWord = true
    }

    /**
     * First find a node with the prefix.
     */
    fun findWord(word: String): List<String> {
        var node = this.root
        var prefix = ""
        word.forEach { character ->
            if (!node.childNodes.containsKey(character)) {
                return@forEach
            }
            prefix += character
            node = node.childNodes[character]!!
        }
        return dfs(node, prefix)
    }

    private fun dfs(node: Node, prefix: String): List<String> {
        val words = arrayListOf<String>()
        node.childNodes.forEach { (key, value) ->
            words.addAll(dfs(value, prefix.plus(key)))
        }
        if(node.isWord){
            words.add(prefix)
        }
        return words
    }

    private fun dfsIterative(node: Node, prefix: String): List<String> {
        val stack = Stack<Pair<Node, String>>().apply {
            add(Pair(node, prefix))
        }
        val result = arrayListOf<String>()

        while (stack.isNotEmpty()) {
            val nodePrefix = stack.pop()
            if (nodePrefix.first.isWord) {
                result.add(nodePrefix.second)
            }
            nodePrefix.first.childNodes.forEach { (key, value) ->
                stack.push(Pair(value, nodePrefix.second.plus(key)))
            }
        }

        return result
    }

}

fun main() {
    val words = arrayOf("Perro", "Gato", "Perrera", "Permisivo", "Parto", "Serpiente", "Lón")
    val trie = Trie().apply {
        words.forEach { this.addWord(it) }
    }
    // println(trie.root)
    println(trie.findWord("P")) // [Perro, Perrera, Permisivo, Parto]
}