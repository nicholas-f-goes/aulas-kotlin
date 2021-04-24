package nicholas.goes.trabalhodofinde.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//import java.io.Serializable
//
//open class Meses : Person, Serializable {
//    var age: Int? = 0
//
//    constructor(name: String, age: Int) : super(name) {
//        this.age = age * 12
//    }
//    constructor(name: String) : super(name)
//}
@Parcelize
class Meses(var name: String?, var age: Int) : Parcelable