import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'kangaroo' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. INTEGER x1
 *  2. INTEGER v1
 *  3. INTEGER x2
 *  4. INTEGER v2
 */

fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {
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

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val x1 = first_multiple_input[0].toInt()

    val v1 = first_multiple_input[1].toInt()

    val x2 = first_multiple_input[2].toInt()

    val v2 = first_multiple_input[3].toInt()

    val result = kangaroo(x1, v1, x2, v2)

    println(result)
}
i
