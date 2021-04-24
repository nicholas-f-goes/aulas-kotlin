package nicholas.goes.retrofitnovalenada.model

import com.google.gson.annotations.SerializedName

data class Zipcode(

    @SerializedName("bairro")
    val district: String,

    @SerializedName("cep")
    val cep: String,

    @SerializedName("complemento")
    val complemento: String,

    @SerializedName("ddd")
    val coutryCode: String,

    @SerializedName("localidade")
    val locale: String,

    @SerializedName("logradouro")
    val logradouro: String,

    @SerializedName("rua")
    val street: String,

    @SerializedName("uf")
    val state: String
)
{
    override fun toString(): String {
        return "Zipcode(district='$district', cep='$cep', complemento='$complemento', coutryCode='$coutryCode', locale='$locale', logradouro='$logradouro', street='$street', state='$state')"
    }
}