package nicholas.goes.helloworldproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler_boleto.view.*
import nicholas.goes.helloworldproject.R
import nicholas.goes.helloworldproject.model.Boleto

class BoletosAdapter(val boletos: List<Boleto>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler_boleto, parent, false))
    }

    override fun getItemCount(): Int {
        return this.boletos.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val boleto = this.boletos[position]
        if(holder is ViewHolder){
            holder.bind(boleto, position, context)
        }
    }
}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(boletos: Boleto?, position: Int?, context: Context){

        val nameBoleto = itemView.nameBoleto
        val dataBoleto = itemView.dataBoleto
        val valorBoleto = itemView.valorBoleto

        boletos?.let{
            nameBoleto.text = it.name
            dataBoleto.text = it.Data
            valorBoleto.text = "R$ ${it.valor.toString()}"

        }

    }
}