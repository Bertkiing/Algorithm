package AD

import java.security.spec.ECGenParameterSpec
import java.util.*
import java.util.LinkedList

/**
 * @author bertking
 * @date 2019/7/10
 */


class Graph() {
    var vertexes: ArrayList<Vertex> = arrayListOf()

    init {

        /**
         * 创建顶点
         */
        for (i in 0..7) {
            val vertex = Vertex(i.toString())
            vertexes.add(vertex)
        }

        /**
         * 创建边
         */
        val edge01 = Edge(Vertex("0"), Vertex("1"))
        val edge02 = Edge(Vertex("0"), Vertex("2"))
        val edge13 = Edge(Vertex("1"), Vertex("3"))
        val edge14 = Edge(Vertex("1"), Vertex("4"))
        val edge25 = Edge(Vertex("2"), Vertex("5"))
        val edge26 = Edge(Vertex("2"), Vertex("6"))
        val edge37 = Edge(Vertex("3"), Vertex("7"))
        val edge47 = Edge(Vertex("4"), Vertex("7"))
        val edge56 = Edge(Vertex("5"), Vertex("6"))


        vertexes[0].addEdge(edge01)
        vertexes[0].addEdge(edge02)

        vertexes[1].addEdge(edge13)
        vertexes[1].addEdge(edge14)

        vertexes[2].addEdge(edge25)
        vertexes[2].addEdge(edge26)

        vertexes[3].addEdge(edge37)

        vertexes[4].addEdge(edge47)

        vertexes[5].addEdge(edge56)

    }
}


/**
 * 顶点类
 */
class Vertex(var label: String = "", var isVisited: Boolean = false) {
    var edges = ArrayList<Edge>()
    /**
     * 给当前节点添加一条边
     */
    fun addEdge(edge: Edge) {
        edges.add(edge)
    }
}


/**
 * 边
 */
class Edge(var from: Vertex, var to: Vertex)

fun BFS(vertex: Vertex){
    // 已经被访问的节点
    val visited = arrayListOf<Vertex>()
    // 用队列存储依次要遍历的元素
    val queue:Queue<Vertex> = LinkedList<Vertex>()

    queue.offer(vertex)
}













































