package leecode

/**
 * @author bertking
 * @date 2020/1/8
 *
 * https://leetcode-cn.com/problems/defanging-an-ip-address/
 *
 */
fun main(args: Array<String>) {
    val address = "1.1.1.1"
    println("Result:${defangIPaddr(address)}")
}



fun defangIPaddr(address: String): String {
    return    address.replace(".","[.]")
}
