package data

import ac.pmdm.recyclerviewpf.R
import android.content.Context

/**
 * Proveedor de datos que genera la lista de Pikmin.
 *
 * Utiliza el contexto para acceder a los recursos del proyecto
 * (strings y drawables) y construir la lista de objetos Pikmin
 * con toda su información.
 *
 * @param context Contexto necesario para acceder a los recursos
 * @see Pikmin Clase modelo que representa cada Pikmin
 */
class ProveedorPikmin(private val context: Context) {


    /**
     * Genera y devuelve la lista completa de Pikmin.
     *
     * Cada Pikmin incluye nombre, imagen, descripción y habilidades.
     * Los textos se obtienen desde strings.xml para soportar múltiples idiomas.
     *
     * @return Lista de objetos Pikmin con todos sus datos
     */

    fun getPikminList(): List<Pikmin> {
        return listOf(

            Pikmin(
                nombre = context.getString(R.string.pikmin_rojo),
                imagen = R.drawable.redpikmin,
                tituloDescripcion = context.getString(R.string.titulo_descripcion_detalle),
                descripcion = context.getString(R.string.pikmin_rojo_detalle),
                tituloHabilidades = context.getString(R.string.titulo_habilidad_detalle),
                habilidades = context.getString(R.string.pikmin_rojo_habilidades)

            ),
            Pikmin(
                nombre = context.getString(R.string.pikmin_amarillo),
                imagen = R.drawable.yellowpikmin,
                tituloDescripcion = context.getString(R.string.titulo_descripcion_detalle),
                descripcion = context.getString(R.string.pikmin_amarillo_detalle),
                tituloHabilidades = context.getString(R.string.titulo_habilidad_detalle),
                habilidades = context.getString(R.string.pikmin_amarillo_habilidades)
            ),
            Pikmin(
                nombre = context.getString(R.string.pikmin_azul),
                imagen = R.drawable.bluepikmin,
                tituloDescripcion = context.getString(R.string.titulo_descripcion_detalle),
                descripcion = context.getString(R.string.pikmin_azul_detalle),
                tituloHabilidades = context.getString(R.string.titulo_habilidad_detalle),
                habilidades = context.getString(R.string.pikmin_azul_habilidades)
            ),

            Pikmin(
                nombre = context.getString(R.string.pikmin_blanco),
                imagen = R.drawable.whitepikmin,
                tituloDescripcion = context.getString(R.string.titulo_descripcion_detalle),
                descripcion = context.getString(R.string.pikmin_blanco_detalle),
                tituloHabilidades = context.getString(R.string.titulo_habilidad_detalle),
                habilidades = context.getString(R.string.pikmin_blanco_habilidades)
            ),
            Pikmin(
                nombre = context.getString(R.string.pikmin_morado),
                imagen = R.drawable.purplepikmin,
                tituloDescripcion = context.getString(R.string.titulo_descripcion_detalle),
                descripcion = context.getString(R.string.pikmin_morado_detalle),
                tituloHabilidades = context.getString(R.string.titulo_habilidad_detalle),
                habilidades = context.getString(R.string.pikmin_morado_habilidades)
            ),
            Pikmin(
                nombre = context.getString(R.string.pikmin_petreo),
                imagen = R.drawable.rockpikmin,
                tituloDescripcion = context.getString(R.string.titulo_descripcion_detalle),
                descripcion = context.getString(R.string.pikmin_petreo_detalle),
                tituloHabilidades = context.getString(R.string.titulo_habilidad_detalle),
                habilidades = context.getString(R.string.pikmin_petreo_habilidades)
            ),
            Pikmin(
                nombre = context.getString(R.string.pikmin_alado),
                imagen = R.drawable.wingedpikmin,
                tituloDescripcion = context.getString(R.string.titulo_descripcion_detalle),
                descripcion = context.getString(R.string.pikmin_alado_detalle),
                tituloHabilidades = context.getString(R.string.titulo_habilidad_detalle),
                habilidades = context.getString(R.string.pikmin_alado_habilidades)
            ),
            Pikmin(
                nombre = context.getString(R.string.pikmin_gelido_ice),
                imagen = R.drawable.icepikmin,
                tituloDescripcion = context.getString(R.string.titulo_descripcion_detalle),
                descripcion = context.getString(R.string.pikmin_gelido_detalle),
                tituloHabilidades = context.getString(R.string.titulo_habilidad_detalle),
                habilidades = context.getString(R.string.pikmin_gelido_habilidades)
            ),
            Pikmin(
                nombre = context.getString(R.string.pikmin_luminoso_glow),
                imagen = R.drawable.glowpikmin,
                tituloDescripcion = context.getString(R.string.titulo_descripcion_detalle),
                descripcion = context.getString(R.string.pikmin_luminoso_detalle),
                tituloHabilidades = context.getString(R.string.titulo_habilidad_detalle),
                habilidades = context.getString(R.string.pikmin_luminoso_habilidades)
            )

        )


    }
}