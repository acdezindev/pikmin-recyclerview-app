package adapter

import data.Pikmin
import ac.pmdm.recyclerviewpf.databinding.ItemPikminCardviewBisBinding
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ui.MainActivityDetallePikmin

/**
 * Adaptador para el RecyclerView que gestiona la lista de Pikmin.
 *
 * Infla el layout item_pikmin_cardview_bis.xml para cada elemento
 * y maneja los clics para navegar a la pantalla de detalles.
 *
 * @param listaPikmin Lista de objetos Pikmin a mostrar
 */

class PikminAdapter(private val listaPikmin: List<Pikmin>) : // coge de la clase ProveedorPikmin que es una lista.( podria se un Json)
    RecyclerView.Adapter<PikminAdapter.PikminViewHolder>() {

    // declaramos la variable para el bindeo
    private lateinit var binding: ItemPikminCardviewBisBinding

    /**
     * ViewHolder que contiene las referencias a las vistas del item.
     *
     * @param binding ViewBinding del layout item_pikmin_cardview_bis.xml
     */

// con binding
    class PikminViewHolder(val binding: ItemPikminCardviewBisBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }





    /**
     * Infla el layout del item y crea el ViewHolder.
     *
     * @param parent ViewGroup padre del RecyclerView
     * @param viewType Tipo de vista (no utilizado)
     * @return ViewHolder con las vistas del item
     */

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PikminViewHolder {
        // con binding
        val binding = ItemPikminCardviewBisBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PikminViewHolder(binding)

    }



    /**
     * Vincula los datos del Pikmin a las vistas del ViewHolder.
     *
     * Asigna la imagen y el nombre, y configura el clic para abrir
     * la pantalla de detalles con los datos del Pikmin seleccionado.
     *
     * @param holder ViewHolder con las vistas
     * @param position Posición del item en la lista
     */
    override fun onBindViewHolder(holder: PikminViewHolder, position: Int) {
        val itemPikmin = listaPikmin[position]
        // Asigna los datos a las vistas
        holder.binding.ivimagenItem.setImageResource(itemPikmin.imagen)
        holder.binding.idpikmin.text = itemPikmin.nombre
        // Configura el clic para abrir la pantalla de detalles
        holder.binding.root.setOnClickListener {

            val context = holder.itemView.context
            val intent = Intent(context, MainActivityDetallePikmin::class.java).apply {
                putExtra("nombre", itemPikmin.nombre)
                putExtra("imagen", itemPikmin.imagen)
                putExtra("titulodescripcion", itemPikmin.tituloDescripcion)
                putExtra("descripcion", itemPikmin.descripcion)
                putExtra("titulohabilidades", itemPikmin.tituloHabilidades)
                putExtra("habilidades", itemPikmin.habilidades)
            }
            // Lanza la actividad  con los datos del Pikmin seleccionado
            context.startActivity(intent)
        }

    }



    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return Cantidad de Pikmin en la lista
     */
    override fun getItemCount(): Int {
        return listaPikmin.size
        // o tb se puede hacer  override fun getItemCount() = listaPikmin.size
    }


}