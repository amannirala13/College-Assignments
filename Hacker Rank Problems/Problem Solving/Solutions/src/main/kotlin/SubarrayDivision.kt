/**
 * Check the problem statement here
 *@see <a href = "https://www.hackerrank.com/challenges/the-birthday-bar/problem?isFullScreen=true"> Problem Statement </a>
 */
object SubarrayDivision {
    fun run(s: Array<Int>, d: Int, m: Int): Int {
        // Write your code here
        var counter = 0
        val currentList = mutableListOf<Int>()
        for(i in 0..(s.size-m)){
            for (j in 0 until m){
                currentList.add(s[i+j])
            }
            if(currentList.sum() == d) counter++
            currentList.clear()
        }
        return counter
    }
}