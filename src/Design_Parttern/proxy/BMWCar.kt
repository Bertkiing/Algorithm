package Design_Parttern.proxy

/**
 * @author bertking
 * @date 2019/8/19
 *
 * 真实主题类(被代理类)
 */
class BMWCar:ICar {
    override fun run() {
        println("宝马车 on running...")
    }
}