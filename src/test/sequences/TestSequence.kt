package test.sequences

/**
 * @author bertking
 * @date 2019/9/25
 *
 * 什么时候使用Sequences(序列)
 * 1. 链接多个操作符:处理集合时性能损耗的最大原因是循环。集合元素迭代的次数越少性能越好（25%性能提升）
 * 序列(Sequences) 的秘诀在于它们是共享同一个迭代器(iterator) ---序列允许 map操作 转换一个元素后，然后立马可以将这个元素传递给 filter操作 ，而不是像集合(lists) 一样等待所有的元素都循环完成了map操作后，用一个新的集合存储起来，然后又遍历循环从新的集合取出元素完成filter操作。通过减少循环次数，
 * 2. 使用first{} 或者 last{}操作符（90%）
 *
 * 什么时候使用Lists(集合)
 * 1. 量级比较小的集合
 * 2. 访问索引数据
 * 3. 传递/返回给函数时(函数可能会多次遍历Sequence)：
 *      每次迭代Sequences(序列) 时，都会计算元素。Lists(集合) 中的元素只计算一次，然后存储在内存中。
 *
 */
fun main(args: Array<String>) {
    val list = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val count = list
            .map { it + 1 }
            .filter { it % 2 == 0 }
            .count { it > 5 }
    println(count)
    println("-------使用Sequence--------")
    val countBySequence = list.asSequence().map { it + 1 }.filter { it % 2 == 0 }.count { it > 5 }
    println(countBySequence)



}