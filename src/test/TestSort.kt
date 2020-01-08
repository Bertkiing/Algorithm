package test

/**
 * @author bertking
 * @date 2019/12/26
 */
fun main(args: Array<String>) {

    var students = arrayListOf<Student>()
    for (i in 5 downTo 0) {
        students.add(Student("$i", "$i name"))
    }
    students.add(Student("3", "1ubName"))

    println(students)

    println("-----------")

//    val sortedBy = students.sortedBy {
//        it.num
//    }
//    println(sortedBy)
//    println("-----------")
//    students.sortBy {
//        it.num
//    }

    students.sortWith(object : Comparator<Student> {
        override fun compare(o1: Student?, o2: Student?): Int {
            val i1 = o1?.num ?: "0"
            val i2 = o2?.num ?: "0"
            if (i1 > i2) {
                return 1
            } else if (i1 < i2) {
                return -1
            } else {
                if (o1?.name ?: "" > o2?.name ?: "") {
                    return 1
                } else {
                    return -1
                }
            }
        }

    })

    println(students)

}


class Student {
    constructor(num: String, name: String) {
        this.num = num
        this.name = name
    }

    var num = "0"
    var name = ""
    override fun toString(): String {
        return "Student(num=$num, name='$name')"
    }
}