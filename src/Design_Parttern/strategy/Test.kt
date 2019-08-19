package Design_Parttern.strategy

/**
 * @author bertking
 * @date 2019/8/19
 * https://www.jianshu.com/p/3bcf55cf83d3
 *
 * 策略模式:
 * 上下文角色(context):屏蔽高层(客户端)对策略，算法的直接访问，封装可能存在的变化
 * 抽象策略角色:规定策略或算法的行为
 * 具体策略角色:具体的策略or算法实现
 *
 * 其本质:分离算法，选择实现
 *
 * Android中属性动画的属性差值器
 * https://www.jianshu.com/p/489abbc15241
 */

fun main(args: Array<String>) {
    /* 选择一个具体策略 */
    val dataCenter: IDataCenter = CloudDataCenter()
    /* 来一个上下文环境 */
    val context = Context(dataCenter)
    /* 让上下文环境执行算法 */
    context.getData()
}