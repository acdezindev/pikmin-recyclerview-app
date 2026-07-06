package dialog

import ac.pmdm.recyclerviewpf.R
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

/**
 * DialogFragment personalizado para la opción "Acerca de" del menú de la Toolbar.
 *
 * Muestra un AlertDialog con información de la aplicación:
 * - Título informativo
 * - Mensaje con el autor y versión
 * - Botón de cierre
 *
 * Los textos se obtienen desde los recursos strings.xml para soportar
 * múltiples idiomas (español/inglés).
 *
 * @see ui.MainActivity Actividad principal que lo invoca
 */


class MiDialogo: DialogFragment() {

    /**
     * Crea y configura el diálogo con el tema personalizado.
     *
     * @return Dialog configurado con título, mensaje y botón de cierre
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Construye el AlertDialog con el tema personalizado
        val builder = AlertDialog.Builder(requireActivity(), R.style.mi_dialogo)


        // Configura el título, mensaje y botón positivo del diálogo
        builder.setTitle(getString(R.string.acerca_de_dialogo))
            .setMessage(getString(R.string.app_desarrollada_dialogo))
            .setPositiveButton(getString(R.string.salir_dialogo)) { dialog, _ ->
                // Accion a realizar cuando pulsamos el boton
                dialog.cancel()
            }

        return builder.create()
    }
}