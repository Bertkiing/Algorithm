package design;

import design.staticProxy.IHouseSeller;
import design.staticProxy.Proxy4House;

/**
 * @author bertking
 * @date 2020/2/17
 */
public class TestSellHouse {
    public static void main(String[] args) {
        IHouseSeller sellHouse = new Proxy4House();
        sellHouse.sellHouse();
    }
}
