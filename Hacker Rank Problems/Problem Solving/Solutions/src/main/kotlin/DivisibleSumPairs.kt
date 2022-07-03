/**
 * Check the problem statement here
 *@see <a href = "https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?isFullScreen=true"> Problem Statement </a>
 */
object DivisibleSumPairs {
    fun run(k: Int, ar: Array<Int>): Int {
        // Write your code here
        var count = 0
        val list = mutableListOf<Int>()
        for(i in 0 until ar.size-1){
            list.add(ar[i])
            for(j in i+1 until ar.size) {
                list.add(ar[j])
                if((list.sum() % k) == 0) count++
                list.removeAt(list.size-1)            // removeLast() doesnt work on hackerrank ide
            }
            list.clear()
        }
    return count
    }
}