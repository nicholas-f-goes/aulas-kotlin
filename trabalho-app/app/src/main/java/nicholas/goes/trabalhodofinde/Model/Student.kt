package nicholas.goes.trabalhodofinde.Model

import java.io.Serializable

class Student : Person, Serializable {
    var age: Int? = 0

    constructor(name: String) : super(name)

    constructor(name: String, age: Int) : super(name) {
        this.age = age
    }
}