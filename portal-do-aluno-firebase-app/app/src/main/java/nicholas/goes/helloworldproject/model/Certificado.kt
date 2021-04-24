package nicholas.goes.helloworldproject.model

class Certificado(var name: String, var Hora: Int, var Data: String) {

    override fun toString(): String {
        return "Certificado(name='$name', Hora=$Hora, Data='$Data')"
    }
}