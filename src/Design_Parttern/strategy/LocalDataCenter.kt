package Design_Parttern.strategy

/**
 * @author bertking
 * @date 2019/8/19
 */
class LocalDataCenter:IDataCenter {
    override fun getData() {
        println("从本地获取数据...")
    }
}