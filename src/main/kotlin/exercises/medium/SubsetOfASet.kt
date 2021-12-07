package exercises.medium

fun main() {
    val list = arrayListOf("a", "b", "c", "d")
    print(subsets(0, list))
}

fun subsets(position: Int, list: ArrayList<String>): ArrayList<ArrayList<String>> {

    if (position < 0 || position >= list.size) {
        return ArrayList()
    }

    val subLists: ArrayList<ArrayList<String>> = ArrayList()
    if (position == 0) subLists.add(arrayListOf())
    subLists.add(arrayListOf(list[position]))

    for (i in position + 1 until list.size) {
        subLists.add(arrayListOf(list[position], list[i]))
    }

    subLists.addAll(subsets(position + 1, list))

    return subLists
}