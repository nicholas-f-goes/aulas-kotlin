package nicholas.goes.trabalhodofinde.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//import java.io.Serializable
//
//open class Minutos : Person, Serializable {
//    var age: Int = 0
//
//    constructor(name: String) : super(name)
//
//    constructor(name: String, age: Int) : super(name) {
//        this.age = age * 525600
//
//    }
//}
@Parcelize
class Minutos(var name: String?, var age: Int) : Parcelable