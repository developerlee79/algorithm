package design

class LeetCode_705 {

    class MyHashSet {

        private val hashArray = arrayOfNulls<MutableList<Int>>(2500)

        fun add(key: Int) {
            if (hashArray[hash(key)] == null) {
                hashArray[hash(key)] = mutableListOf()
            }
            if (!this.contains(key)) {
                hashArray[hash(key)]!!.add(key)
            }
        }

        fun remove(key: Int) {
            if (hashArray[hash(key)] != null) {
                hashArray[hash(key)]!!.remove(key)
            }
        }

        fun contains(key: Int): Boolean {
            if (hashArray[hash(key)] == null) {
                return false
            }
            return hashArray[hash(key)]!!.contains(key)
        }

        private fun hash(key: Int) = key.hashCode().ushr(12)

    }
}

fun main() {
    // Input
    val myHashSet = LeetCode_705.MyHashSet()
    // Output
    myHashSet.add(1)
    myHashSet.add(2)
    require(myHashSet.contains(1))
    require(!myHashSet.contains(3))
    myHashSet.add(2)
    require(myHashSet.contains(2))
    myHashSet.remove(2)
    require(!myHashSet.contains(2))
}
