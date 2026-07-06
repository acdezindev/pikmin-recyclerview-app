package ui

import ac.pmdm.recyclerviewpf.R
import ac.pmdm.recyclerviewpf.databinding.ActivityMainAjustesBinding
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

/**
 * Actividad de configuración de la aplicación.
 *
 * Permite al usuario personalizar la experiencia de la app mediante:
 * - Cambio entre tema claro/oscuro
 * - Selección de idioma (Español/Inglés)
 *
 * Las preferencias se guardan mediante SharedPreferences para persistir
 * entre sesiones de la aplicación.
 *
 * @see androidx.appcompat.app.AppCompatDelegate Para gestión del tema
 * @see androidx.core.os.LocaleListCompat Para gestión del idioma
 */


class MainActivityAjustes : AppCompatActivity() {

    // variable de bindeo
    private lateinit var binding: ActivityMainAjustesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilitamos EdgeToEdge para pantallas curvas
        // Inicialización del ViewBinding
        binding = ActivityMainAjustesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Configuración de la Toolbar con título y botón de retroceso
        setSupportActionBar(binding.toolbarAjustes)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title =
            getString(R.string.toolbar_ajustes)// Recogemos el titulo de la toolbar desde el String con getString se podria hacer supportActionBar?.title = ajustes pero ya no podriamos traducir pq seria literal


        // SharedPreferences para mantener estado de las preferencias  ( Switch se queda por defecto en la seleccion  y no se reinicia )
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)

        // Configuración del switch de tema (claro/oscuro)
        // Restaurar el estado guardado del switch
        binding.switchTema.isChecked = prefs.getBoolean("clave_oscuro", false)

        // Listener para detectar cambios en el switch de tema
        binding.switchTema.setOnCheckedChangeListener { butonView, isChecked ->
            if (isChecked) {
                // Switch activado
                Toast.makeText(
                    this@MainActivityAjustes,
                    (getString(R.string.modo_activado)),
                    Toast.LENGTH_SHORT
                ).show() // // recogemos el texto del string
                // Forzar modo oscuro
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Switch desactivado
                Toast.makeText(
                    this@MainActivityAjustes,
                    (getString(R.string.modo_desactivado)),
                    Toast.LENGTH_SHORT
                ).show() // recogemos el texto del string
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            // Guarda la preferencia en SharedPreferences
            prefs.edit().putBoolean("clave_oscuro", isChecked).apply()

        }


        //********   CAMBIO DE IDIOMA LO PODRIAMOS METER EN UNA FUNCION   **********
        // Variables Configuración del switch de idioma (español/inglés)
        val spanishLocale: LocaleListCompat = LocaleListCompat.forLanguageTags("es")
        val englishLocale: LocaleListCompat = LocaleListCompat.forLanguageTags("en")

        // Restaurar el estado guardado del switch de idioma
        binding.switchLenguaje.isChecked =
            prefs.getBoolean("clave_idioma", false) // false espanol por defecto

        // Listener para detectar cambios en el switch de idioma
        binding.switchLenguaje.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {  // Switch activado empieza en la izquierda
                //CAMBIAR ingles
                AppCompatDelegate.setApplicationLocales(englishLocale)
                Toast.makeText(
                    this@MainActivityAjustes,
                    (getString(R.string.idioma_en)),
                    Toast.LENGTH_SHORT
                ).show()  // Obtiene el texto desde strings.xml

            } else {  // Switch desactivado
                // Cambiar a Espanol
                AppCompatDelegate.setApplicationLocales(spanishLocale)
                Toast.makeText(this, getString(R.string.idioma_es), Toast.LENGTH_SHORT).show()
            }
            // Guardar la preferencia del idioma
            prefs.edit().putBoolean("clave_idioma", isChecked).apply()

        }
    } //fin oncreate


    // PARA PONER EL BOTON DE RETROCESO ( la flechita <-- ) EN LA TOOLBAR
    /**
     * Gestiona el botón de retroceso de la Toolbar.
     *
     * @return true si el evento ha sido procesado
     */
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

}


/**
 * Activity que muestra la pantalla de ajustes de la aplicación.
 *
 * 1 Configura Toolbar con título y boton de retroceso
 * 2 Permite activar o desactivar el Modo Oscuro usando un Switch
 * 3 Muestra un Toast indicando si el Modo Oscuro está activado o desactivado
 *
 * Los XML relacionados son:
 * -activity_main_ajustes.xml` > contiene:
 * -Toolbar > toolbar_ajustes
 * -Switch switch_tema > para activar/desactivar el modo oscuro
 *
 * Flujo de datos:
 * Usuario interactúa con el Switch > Listener detecta cambio > Se cambia el tema de la app con AppCompatDelegate > y mostramos  un Toast
 */