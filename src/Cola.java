import java.sql.Array;

public class Cola<T> {

    private int size = 0;
    private int max;
    private T[] cola;
    private int inicio;
    private int fin;

    public Cola() {
        this.max = 100;
        this.inicio = -1;
        this.fin = -1;
        this.cola = (T[]) new Object[this.max +1];
    }

    public Cola(int max) {
        this.max = max;
        this.inicio = -1;
        this.fin = -1;
        this.cola = (T[]) new Object[this.max +1];
    }

    public void insertar(T data) {
        if (fin < max) {
            fin++;
            size++;
            cola[fin] = data;

            if (fin == 0) {
                inicio = 0;
            }
        } else
            System.out.println("desbordamiento");
    }

    public int size() {
        return size;
    }

    public T eliminar() {
        T dato = null;
        if (inicio != -1) {
            dato = cola[inicio];

            if (inicio == fin) {
                inicio = -1;
                fin = -1;
            } else
                inicio++;

            size--;
        } else
            System.out.println("Subdesbordamiento");

        return dato;
    }

    public T peek() {
        return cola[inicio];
    }

    public String toString() {
        int i = 0;
        StringBuilder s = new StringBuilder();

        if (inicio == -1)
            return "";
        else {
            i = inicio;
            do {
                s.append(cola[i]).append(" ");
                i++;
                if (i == max && inicio > fin)
                    i = 0;
            } while (i != fin + 1);
        }
        return s.toString();
    }
}
