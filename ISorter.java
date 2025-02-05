/**
 * Interfaz genérica para algoritmos de ordenamiento.
 * Define un método sort que mide y devuelve el tiempo de ejecución en nanosegundos.
 *
 * @param <T> Tipo de datos a ordenar, debe implementar Comparable<T>.
 */
public interface ISorter<T extends Comparable<T>> {

    /**
     * Ordena el arreglo dado y devuelve el tiempo de ejecución en nanosegundos.
     *
     * @param array El arreglo a ordenar.
     * @return Tiempo de ejecución en nanosegundos.
     */
    long sort(T[] array);
}
