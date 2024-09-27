package clase1.actividades;

import java.math.BigInteger;

public class Actividades2 {

/* ¿ Cómo usaría los tipos de datos long y BigInteger ?
Realizar la implementación en java */

    // Función auxiliar para la recursión con cola
    private static long factorialTailLong(long n, long result) {
    if (n == 0) {
    return result;
    } else {
    return factorialTailLong(n - 1, n * result);
    }
    }

    // Función principal que inicia la recursión con cola
    public static long factorialLong(long n) {
    return factorialTailLong(n, 1);
    }

    private static BigInteger factorialTailBigInteger(BigInteger n, BigInteger result) {
        if (n.equals(BigInteger.ZERO)) {
            return result;
        } else {
            return factorialTailBigInteger(n.subtract(BigInteger.ONE), n.multiply(result));
        }
    }
    
    // Función principal que inicia la recursión con cola
    public static BigInteger factorialBigInteger(BigInteger n) {
        return factorialTailBigInteger(n, BigInteger.ONE);
    }

}
