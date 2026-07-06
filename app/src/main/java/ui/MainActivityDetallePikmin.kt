package ui

import ac.pmdm.recyclerviewpf.R
import ac.pmdm.recyclerviewpf.databinding.ItemDetallePikminBinding
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

/**
 * Actividad que muestra los detalles completos de un Pikmin seleccionado.
 *
 * Recibe los datos mediante Intent desde el adaptador del RecyclerView
 * y los muestra en las vistas correspondientes (TextView, ImageView).
 *
 * @see adapter.PikminAdapter Adaptador que envía los datos
 * @see MainActivity Actividad principal con el listado
 */

class MainActivityDetallePikmin : AppCompatActivity() {
    // Bindeo
    private lateinit var binding: ItemDetallePikminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inicialización del ViewBinding
        binding = ItemDetallePikminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración de la Toolbar con título y botón de retroceso
        setSupportActionBar(binding.toolbarDetalle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.toolbar_pantalla_detalles)


// Recuperación de los datos enviados desde PikminAdapter
        val nombre = intent.getStringExtra("nombre")
        val imagen = intent.getIntExtra("imagen", 0)
        val titulodescripcion = intent.getStringExtra("titulodescripcion")
        val descripcion = intent.getStringExtra("descripcion")
        val titulohabilidades = intent.getStringExtra("titulohabilidades")
        val habilidades = intent.getStringExtra("habilidades")


        // Asignación de los datos a las vistas mediante ViewBinding
        binding.idPikminDetalle.text = nombre
        binding.ivimagenDetalle.setImageResource(imagen)
        binding.tvTituloDescripcion.text = titulodescripcion
        binding.tvTituloHabilidades.text = titulohabilidades
        binding.habilidades.text = habilidades
        binding.tvDescripcion.text = descripcion


        // TOAST EN PANTALLA DETALLE DE PIKMIN,
        Toast.makeText(this, (getString(R.string.toast_detalles)) + nombre, Toast.LENGTH_SHORT)
            .show()

    }

    // BOTON DE RETROCESO
    // Accion del boton de atrás en la ActionBar para que vuelva a la pantalla anterior
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

}


/**
 * Activity que muestra el detalle completo de un Pikmin seleccionado.
 *
 * Esta pantalla se abre al hacer clic sobre un item del RecyclerView en MainActivity.
 * Recupera los datos enviados a traves del Intent y los asigna a los elementos visuales
 * definidos en el layout item_detalle_pikmin.xml.
 *
 * Funcionalidades principales:
 * A Configura la interfaz edgetoedge (pantallas modernas y bordes curvos)
 * 2 Configura la Toolbar con título y boton de retroceso
 * 3 Recupera los datos enviados desde PikminAdapter mediante Intent.putExtra
 * 4 Asigna los datos a los TextViews e ImageView del layout
 * 5 Muestra un Toast indicando el Pikmin seleccionado
 *
 * XML relacionado:
 * - item_detalle_pikmin.xml > contiene:
 *   - ImageView > ivimagen_detalle
 *   - TextView > id_pikmin_detalle (nombre)
 *   - TextView > tv_titulo_descripcion
 *   - TextView> tv_descripcion
 *   - TextView >tv_titulo_habilidades
 *   - TextView >habilidades
 *
 * Flujo de datos:
 * PikminAdapter (Intent con extras) > MainActivityDetallePikmin  >views del layout
 */