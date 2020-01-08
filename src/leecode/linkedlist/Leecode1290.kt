package leecode.linkedlist

/**
 * @author bertking
 * @date 2020/1/8
 *
 * a | 0 = a
 * a | 1 = a + 1 或者 a
 *
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */



fun main(args: Array<String>) {
    var x = 9
    println("${x.or(1)}")


    var head = ListNode(1)
    var node1 = ListNode(0)
    var node2 = ListNode(0)
    var node3 = ListNode(1)


    head.next = node1
    node1.next = node2
    node2.next = node3
    println("Result:${getDecimalValue1(head)}")

}

/**
 *
 * 反人类做法：记住从高位向低位转换的公式：anS=0;ans=2*ans+当前位的值；
 *
 * 最Happy
 *
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/qian-hou-2ci-fen-xi-li-yong-wei-yun-suan-ji-suan-a/
 *
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/1290-er-jin-zhi-lian-biao-zhuan-zheng-shu-by-wbfyp/
 *
 * 注意：二进制 ---> 十进制  1001 -> 1 * 2^3 + 0 * 2^2 + 0 * 2^1 + 1 * 2^0
 *
 *
 * 推理过程:
 * 1. 假设 二进制数为 10101010 ，将其分为两个部分1010101 和 0
 * 2. 设1010101所对应的十进制数是a，则 10101010对应的十进制数是 a * 2 + 0
 * 3. 同理 a 也可以表示为 b * 2 + 1 (b是101010对应的十进制数)
 * 4. 故有递推公式 前面的十进制数 * 2 + 最后一位二进制数
 *
 */
fun getDecimalValue(head: ListNode?): Int {
    var head: ListNode? = head ?: return 0
    var result = 0
    while (head != null) {
        /**
         * result = result * 2 + head.val
         *
         * 通过位运算 或 将取出数字存入最低位
         *
         * res 左移 1 位后最低位为零 ( res = 0x???????0 )；
         * val 为 0 或 1 ( val = 0x00000000 或者 0x00000001 )；
         * res 和 val 进行“或”的位运算，只会改变 res 的最低位
         */
        result = result.shl(1).or(head.`val`)
        head = head.next
    }
    return result
}


/**
 * Low
 */
fun getDecimalValue2(head: ListNode?): Int {
    var head: ListNode? = head ?: return 0
    var string = ""
    while (head != null) {
        string += head.`val`.toString()
        head = head.next
    }
    return string.toInt(2)
}


/**
 *
 *采用 二进制转十进制：按权相加法,从低位到高位。
 * 1. 可以通过List,Stack，Array 或者反转链表(推荐)辅助，从而使用按权相加法。
 *
 * 2. 可以通过遍历链表，得到其最高位的权是多少，然后按照从高到低进行计算也可以。
 *
 */
fun getDecimalValue1(head: ListNode?): Int {
    var head: ListNode? = head ?: return 0

    var reverse = reverse(head)

    var sum = 0
    var index = 0
    while (reverse != null) {
        if (reverse.`val` == 1) {
            sum += Math.pow(2.toDouble(), index.toDouble()).toInt()
        }
        index++
        reverse = reverse.next
    }
    return sum
}

/**
 * 反转链表
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/shi-yong-fan-zhuan-zhi-zhen-de-fang-shi-wan-cheng-/
 */
fun reverse(head: ListNode?): ListNode? {
    /**
     * head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
     */
    var head: ListNode? = head ?: return null

    /**
     * 当前节点是head
     * pre —— 当前节点的前一节点
     * next —— 当前节点的下一节点
     *
     * 两者的目的:
     *  让当前节点从 pre -> head -> next1 -> next2 变成 pre <- head <- next1 <- next2
     *  即：pre 让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点后的话，则此单链表就断开了，
     *  故需要pre 和 next 两个节点。
     *
     * 1 -> 2 -> 3 -> 4 -> 5
     * 1 <-2 <- 3 <- 4 <- 5
     */
    var pre: ListNode? = null
    var next: ListNode?

    /**
     * 循环操作
     * 如果当前节点不为空的话，始终执行此循环。
     * 此循环的目的就是让当前节点从 指向next 到 指向pre
     * 唯如此，就可以做到"反转链表"的效果
     */
    while (head != null) {
        /**
         * 先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
         */
        next = head.next
        /**
         * 保存完next，就可以让head从指向next 变成 指向 pre 了
         */
        head.next = pre

        /**
         * head指向pre后，就继续反转下一个节点
         *
         * 让 pre,head,next依次向后移动一个节点，继续下一次的指针反转
         */
        pre = head
        head = next
    }

    /**
     * 如何head 为 null, 则 pre就为最后一个节点了。此时链表已经反转完毕，pre就是反转后的第一个节点
     */
    return pre
}
