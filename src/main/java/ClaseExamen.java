import java.util.ArrayList;
import java.util.List;

public class ClaseExamen {

    public static List<Integer> primos(int n) throws EntradaInvalida {
        if (n <= 1) {
            throw new EntradaInvalida("El número debe ser mayor que 1");
        }

        List<Integer> factores = new ArrayList<>();

        // Dividir por 2 mientras sea divisible
        while (n % 2 == 0) {
            factores.add(2);
            n = n / 2;
        }

        // Probar con números impares desde 3 en adelante
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factores.add(i);
                n = n / i;
            }
        }

        // Si n es mayor que 2, entonces es un número primo
        if (n > 2) {
            factores.add(n);
        }

        return factores;
    }

    // Clase de excepción personalizada
    static class EntradaInvalida extends Exception {
        public EntradaInvalida(String mensaje) {
            super(mensaje);
        }
    }
}