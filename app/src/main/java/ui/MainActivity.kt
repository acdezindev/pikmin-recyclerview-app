package ui

import dialog.MiDialogo
import adapter.PikminAdapter
import data.ProveedorPikmin
import ac.pmdm.recyclerviewpf.R
import ac.pmdm.recyclerviewpf.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar

/**
 * Actividad principal que gestiona el listado de Pikmin en un RecyclerView.
 *
 * Implementa una Toolbar con menú de opciones que permite acceder a la información
 * de la aplicación (Acerca de) y a la pantalla de ajustes de configuración.
 *
 * @see ProveedorPikmin Proveedor de datos de los Pikmin
 * @see PikminAdapter Adaptador para el RecyclerView
 * @see MiDialogo Diálogo informativo "Acerca de"
 * @see MainActivityAjustes Pantalla de configuración
 */

class MainActivity : AppCompatActivity() {

    // ViewBinding (Bindeo)
    private lateinit var binding: ActivityMainBinding


    /**
     * Lanzador para iniciar actividades y recibir resultados.
     * Implementado para futuras comunicaciones entre actividades.
     */
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // Procesar la respuesta si fuese necesario
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //A
        // Inicialización del ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

// ******* NOTA MOVILES CON FILO ********
// -----  MOVILES CON FILO por ahora no lo usamos-------
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
// ----- FIN  MOVILES CON FILO -------


// -------   MANEJAR EL RecyclerView (CONFIGURACIÓN) --------------
        // B1 obtener la referencia del RecyclerView(lo capturamos)
        val recyclerView = binding.recyclerView
        // B2 Configurar el LayoutManager en este caso sera GridLayout , para organizar los items cudriculas de 3 columnas en nuestro caso.
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        // B3 Obtener la lista de datos desde el proveedor (ProveedorPikmin)
        val proveedor =
            ProveedorPikmin(this) // Proporciona el contexto para acceder a strings.xml
        val listaPikmin = proveedor.getPikminList()
        // B4 Asignar el Adapter
        recyclerView.adapter = PikminAdapter(listaPikmin)
// ------- FIN   MANEJAR EL RecyclerView  --------------


// ------ CONFIGURAR EL MENU TOOLBAR  --------------
// C Configuración de la Toolbar como ActionBar de la actividad (creada en activity_main.xml)
        setSupportActionBar(binding.idbarratoolbar) // usamos el bindeo


        // ------- SNACKBAR Bienvenida ----------------
        //  Muestra el Snackbar de bienvenida
        simpleSnackbar() // Es una Funcion (metodo)

    } // fin on create

// ************* FUNCIONES >> ( METODOS EN OTROS LENGUAJES ( JAVA ) van fuera del OnCreate ) ****************


    // FUNCIÓN
    /**
     * Infla el menú de opciones definido en menu_main.xml en la Toolbar.
     *
     * @param menu Menú donde se agregarán los items
     * @return true si el menú se ha inflado correctamente
     */

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // FUNCIÓN
    /**
     * Gestiona los eventos de selección de los items del menú.
     *
     * @param item Item seleccionado por el usuario
     * @return true si el evento ha sido procesado
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.acercade -> { // Muestra un diálogo con información de la app (texto definido en menu_main.xml, configuración en MiDialogo)
                val fragmentManager = supportFragmentManager
                val dialogo = MiDialogo() // Creamos el dialogo
                dialogo.show(fragmentManager, "tagAlerta") // mostramos el dialogo
                //--------------------------------------------------
                true
            }
            // Navegamos a la pantalla Ajustes
            R.id.ajustes -> { // Lanzamos una nueva pantalla (Activity) al pulsar el texto ajustes del menu.xml lo que seria el item de ajustes.
                val intent = Intent(this, MainActivityAjustes::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }





    // Función que muestra un Snackbar ( Se usa en Oncreate )
    /**
     * Muestra un Snackbar en la vista principal indicando que la lista de Pikmin se ha cargado.
     *
     * Este metodo obtiene la vista raíz R.id.main y muestra un mensaje breve.
     */
    fun simpleSnackbar() {
        // Bindeo
        Snackbar.make(binding.main, getString(R.string.snackbar), Snackbar.LENGTH_SHORT).show()

    }


}


/**
 * Activity principal que muestra la lista de Pikmin en un RecyclerView y gestiona la Toolbar con un menu.
 *
 * FUNCIONES PRINCIPALES:
 * A️ Configurar edgetoedge  enableEdgeToEdge()
 * B️ Configurar RecyclerView con GridLayoutManager y Adapter
 * C️ Configurar Toolbar con título
 * D️ Inflar menu de Toolbar > onCreateOptionsMenu
 * E️ Gestionar clicks en menu > onOptionsItemSelected
 * F️ Mostrar Snackbar indicando que la lista se cargo > simpleSnackbar()
 *
 * XML relacionados:
 * - activity_main.xml > contiene RecyclerView recyclerView y Toolbar idbarratoolbar
 * - menu_main.xml > define los items de menú: acercade y ajustes
 *
 * Clases relacionadas:
 * - ProveedorPikmin > proporciona la lista de Pikmin
 * - PikminAdapter > adapta los datos al RecyclerView
 * - MiDialogo > dialogo de informacion "Acerca de"
 * - MainActivityAjustes > Activity de ajustes/tema oscuro
 */