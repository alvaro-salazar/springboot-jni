package ejemplojni.lib;

/**
 *  Clase que representa las funciones de la biblioteca dinamica JNI
 */
public class JavaCalculator {

    public native int sum(int a, int b);

    public native int multiply(int a, int b);

    public native float sum(float a, float b);

    public JavaCalculator() {
        try {
            System.loadLibrary("javacalculator");
            System.out.println("Biblioteca cargada exitosamente!");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Carga de la biblioteca fallida: " + e.getMessage());
        }
    }
}