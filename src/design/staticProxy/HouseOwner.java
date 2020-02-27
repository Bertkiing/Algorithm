package design.staticProxy;

/**
 * @author bertking
 * @date 2020/2/17
 *
 * 房东:真正的卖房者
 */
public class HouseOwner implements IHouseSeller {
    @Override
    public void sellHouse() {
        System.out.println("我是房东，我要卖房子");
    }
}
