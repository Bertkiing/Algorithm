package Design_Parttern.strategy

/**
 * @author bertking
 * @date 2019/8/19
 *
 * 具体策略角色（ConcreteStrategy）：具体的策略或算法实现；
 */
class CloudDataCenter:IDataCenter {
    override fun getData() {
        println("数据从云端获取....")
    }
}