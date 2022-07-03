/**
 * Check the problem statement here
 *@see <a href = "https://www.hackerrank.com/challenges/between-two-sets/problem?isFullScreen=true"> Problem Statement </a>
 */
object BetweenTwoSets {
    fun run(a: Array<Int>, b: Array<Int>): Int {
        // Write your code here
        val range = a.asList().max()..b.asList().min()
        var count = 0
        var isCounting = true

        for (num in range){
            for (i in a){
                if(num%i != 0){isCounting = false}
            }
            for(j in b){
                if(j%num != 0){ isCounting = false}
            }
            if(isCounting) count += 1
            isCounting = true

        }
        return count
    }
}