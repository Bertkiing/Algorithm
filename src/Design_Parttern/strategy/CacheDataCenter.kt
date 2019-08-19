package Design_Parttern.strategy

/**
 * @author bertking
 * @date 2019/8/19
 */
class CacheDataCenter:IDataCenter {
    override fun getData() {
        println("从缓存中获取数据...")
    }
}