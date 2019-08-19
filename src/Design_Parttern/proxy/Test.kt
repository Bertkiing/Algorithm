package Design_Parttern.proxy

/**
 * @author bertking
 * @date 2019/8/19
 *
 * 代理模式讲解
 * https://www.jianshu.com/p/a4eb8eda6335
 *
 * https://www.jianshu.com/p/f5e092352ee4
 *
 * 代理模式有三个角色:
 * 1. 抽象主题类
 * 2. 被代理类
 * 3. 代理类
 *
 * In general, 代理模式一般分为:"静态代理" & "动态代理"。我们这里谈的是静态代理
 */
fun main(args: Array<String>) {
    CarProxy(2).run()
}