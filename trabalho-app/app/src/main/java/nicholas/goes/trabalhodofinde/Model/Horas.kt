package nicholas.goes.trabalhodofinde.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//import java.io.Serializable
//
//open class Horas : Person, Serializable {
//    var age: Int? = 0
//
//    constructor(name: String, age: Int) : super(name) {
//        this.age = age * 8760
//    }
//    constructor(name: String) : super(name)
//}
@Parcelize
class Horas(var name: String?, var age: Int) : Parcelable