package Design_Parttern.strategy

/**
 * @author bertking
 * @date 2019/8/19
 *
 * 上下文角色（Context）：用来操作策略的上下文环境，屏蔽高层模块（客户端）对策略，算法的直接访问，封装可能存在的变化
 */
class Context(dataCenter: IDataCenter) {
    var iDataCenter:IDataCenter? = null
    init {
        iDataCenter = dataCenter
    }

    fun getData(){
        iDataCenter?.getData()
    }
}