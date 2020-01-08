package retrofit

import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.Executor

/**
 * @author bertking
 * @date 2019/10/24
 */
fun main(args: Array<String>) {
    val retrofit = Retrofit.Builder()
            .baseUrl("http://www.baidu.com")
            .addConverterFactory(FakeGsonConverterFactory()) // 其实就是往converterFactories添加
            .addCallAdapterFactory(FakeCallAdapterFactory()) // callAdapterFactories
            .callbackExecutor(Executor { }) // 不能和addCallAdapterFactory共用，两者为互斥关系
            .build()



}