/**
 * Check the problem statement here
 *@see <a href = "https://www.hackerrank.com/challenges/migratory-birds/problem?isFullScreen=true"> Problem Statement </a>
 */
object MigratoryBirds {
    fun run(arr: Array<Int>): Int {
        // Write your code here
        val list = arr.toMutableList()
        val idList = list.distinct()
        var max = 0
        var maxItem = -1
        var count: Int
        for (id in idList){
            count = list.count{it == id}
            if(count > max){
                max = count
                maxItem = id
            }
            else if(count == max){
                if(id.coerceAtLeast(maxItem) == maxItem){
                    maxItem = id
                }
            }
        }
        return maxItem
    }
}