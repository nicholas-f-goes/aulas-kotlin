package nicholas.goes.helloworldproject.model

class User {

    var email: String? = null
    var password: String? = null

    override fun toString(): String {
        return "User(email=$email, password=$password)"
    }

}