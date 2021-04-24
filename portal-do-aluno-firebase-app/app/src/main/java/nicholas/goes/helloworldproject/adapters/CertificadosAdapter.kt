package nicholas.goes.helloworldproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler_certificados.view.*
import nicholas.goes.helloworldproject.R
import nicholas.goes.helloworldproject.model.Certificado

class CertificadosAdapter(val certificado: List<Certificado>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder1(LayoutInflater.from(context).inflate(R.layout.item_recycler_certificados, parent, false))
    }

    override fun getItemCount(): Int {
        return this.certificado.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val certificado = this.certificado[position]
        if(holder is ViewHolder1){
            holder.bind(certificado, position, context)
        }
    }
}

class ViewHolder1(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(Certificados: Certificado?, position: Int?, context: Context){

        val nameCertificado = itemView.nameCertificado
        val dataCertificado = itemView.dataCertificado
        val valorCertificado = itemView.horaCertificado

        Certificados?.let{
            nameCertificado.text = it.name
            dataCertificado.text = it.Data
            valorCertificado.text = "${it.Hora.toString()}"
        }

    }
}