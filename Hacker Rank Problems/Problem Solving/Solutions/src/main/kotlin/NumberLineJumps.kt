/**
 * Check the problem statement here
 * @see <a href = "https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true"> Problem Statement </a>
 */
object NumberLineJumps {
    fun run(x1: Int, v1: Int, x2: Int, v2: Int): String {
        // Write your code here
        val no = "NO"
        val yes = "YES"

        var x1_t = x1
        var x2_t = x2

        if(x1 > x2){
            return if (v1 > v2) no else{
                while(x1_t > x2_t){
                    x1_t += v1
                    x2_t += v2
                }
                if(x1_t == x2_t) yes else no
            }
        }else if (x2 > x1){
            return if (v2 > v1) no else{
                while(x2_t > x1_t){
                    x1_t += v1
                    x2_t += v2
                }
                if(x1_t == x2_t) yes else no
            }
        }
        else return yes
    }
}