package Design_Parttern.proxy

/**
 * @author bertking
 * @date 2019/8/19
 *
 * 代理类(委托类)
 */
class CarProxy constructor(carType: Int) : ICar {
    var car: ICar? = null
    init {
        when (carType) {
            0 -> {
                car = BenZiCar()
            }

            1 -> {
                car = BMWCar()
            }

            2 -> {
                car = FerrariCar()
            }
        }
    }


    override fun run() {
        car?.run()
    }
}