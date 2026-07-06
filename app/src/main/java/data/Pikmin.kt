package data

/**
 * Clase modelo que representa un Pikmin con todos sus datos.
 *
 * Define la estructura de datos de cada Pikmin, incluyendo su nombre,
 * imagen, descripción y habilidades. Cada propiedad se corresponde
 * con un componente visual en los layouts XML.
 *
 * Correspondencia con los layouts:
 * - item_pikmin_cardview_bis.xml (vista en el RecyclerView):
 *   - nombre → TextView
 *   - imagen → ImageView (recurso drawable)
 *
 * - item_detalle_pikmin.xml (pantalla de detalle):
 *   - tituloDescripcion → TextView
 *   - descripcion → TextView
 *   - tituloHabilidades → TextView
 *   - habilidades → TextView
 *
 * @property nombre Nombre del Pikmin
 * @property imagen Recurso drawable de la imagen del Pikmin
 * @property tituloDescripcion Título de la sección de descripción
 * @property descripcion Descripción del Pikmin
 * @property tituloHabilidades Título de la sección de habilidades
 * @property habilidades Habilidades o características del Pikmin
 *
 * @see ProveedorPikmin Proveedor que genera la lista de Pikmin
 * @see adapter.PikminAdapter Adaptador que utiliza esta clase para mostrar los datos
 */

data class Pikmin(
    val nombre: String,
    val imagen: Int,
    val tituloDescripcion: String,
    val descripcion: String,
    val tituloHabilidades: String,
    val habilidades: String
)