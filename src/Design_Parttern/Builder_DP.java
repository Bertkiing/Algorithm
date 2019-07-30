package Design_Parttern;

/**
 * @author bertking
 * @date 2019/7/28
 * 建造者模式 -
 * 使用场景:构造复杂对象(属性多余4个)；类的属性不确定；
 * 具体使用中的例子：Glide,源码中的AlertDialog，OkHttpClient and so on ...  随处可见其身影
 * <p>
 * 写的时候要分清---必填参数 & 选填参数(构造者的构造函数)
 */
public class Builder_DP {
    public static void main(String[] args) {
        Car car = new CarBuilder("BenZ", 5)
                .withWD(true)
                .withDisplacement("V-12")
                .withColor("BLACK")
                .withSkylight(true)
                .build();

        System.out.println("全车信息:" + car.toString());
    }
}


class Car {

    private static  volatile  Car instance = null;

    // 汽车品牌
    private String branch = "";
    // 轮胎数量
    private int tyres = 0;
    // 是否是四驱
    private boolean isWD = false;
    // 是否有天窗
    private boolean isHasSkylight = false;
    // 汽车颜色
    private String color = "red";
    //发动机排量
    private String displacement = "V6";

    private Car(CarBuilder builder) {
        this.branch = builder.branch;
        this.tyres = builder.tyres;
        this.isWD = builder.isWD;
        this.isHasSkylight = builder.isHasSkylight;
        this.color = builder.color;
        this.displacement = builder.displacement;
    }

    /**
     * DCL单例
     * @param builder
     * @return
     */
    public static Car getInstance(CarBuilder builder) {
        if(instance == null){
            synchronized (Car.class){
                if(instance == null){
                    instance = new Car(builder);
                }
            }
        }

        return instance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "branch='" + branch + '\'' +
                ", tyres=" + tyres +
                ", isWD=" + isWD +
                ", isHasSkylight=" + isHasSkylight +
                ", color='" + color + '\'' +
                ", displacement='" + displacement + '\'' +
                '}';
    }
}

class CarBuilder {
    // 汽车品牌
    String branch = "";
    // 轮胎数量
    int tyres = 0;
    // 是否是四驱
    boolean isWD = false;
    // 是否有天窗
    boolean isHasSkylight = false;
    // 汽车颜色
    String color = "red";
    //发动机排量
    String displacement = "V6";

    /**
     * 构造函数
     *
     * @param branch
     * @param tyres
     */
    public CarBuilder(String branch, int tyres) {
        if (branch == null || branch.length() <= 0) {
            throw new IllegalArgumentException("汽车品牌不能为空");
        }

        if (tyres <= 2 || tyres % 2 == 0) {
            throw new IllegalArgumentException("你不要备胎啦...");
        }

        this.branch = branch;
        this.tyres = tyres;
    }


    public CarBuilder withWD(boolean isWD) {
        this.isWD = isWD;
        return this;
    }

    public CarBuilder withSkylight(boolean isHasSkylight) {
        this.isHasSkylight = isHasSkylight;
        return this;
    }

    public CarBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder withDisplacement(String displacement) {
        this.displacement = displacement;
        return this;
    }

    public Car build() {
        return Car.getInstance(this);
    }


}



