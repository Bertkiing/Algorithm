package design.staticProxy;

/**
 * @author bertking
 * @date 2020/2/17
 *
 * 房屋中介(代理商):委托中介去卖房
 */
public class Proxy4House implements IHouseSeller {
    private HouseOwner owner = null;

    @Override
    public void sellHouse() {
        System.out.println("这里是房屋中介：");
        if (owner == null) {
            owner = new HouseOwner();
        }
        owner.sellHouse();
    }
}
