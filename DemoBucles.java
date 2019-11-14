import java.util.Random;
/**
 *    @author - Xanti Gardeazabal Iribarren
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;
    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int potencia = 1;
        while (numero >= potencia){
            potencia = potencia * 2;
        }
        potencia = potencia / 2;
        return potencia;
    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        int auxnumero = numero;
        int potencia = 0;
        System.out.printf("%6s",numero + " =");
        while(auxnumero != 0){
            potencia = mayorPotencia2(auxnumero);
            auxnumero = auxnumero - mayorPotencia2(auxnumero);
            System.out.printf("%6d",potencia);
        }
    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {
        int aleatorio = generador.nextInt(256);
        int repeticiones = 0;
        while (repeticiones < n && aleatorio != 0){
            escribirSumaPotencias(aleatorio);
            System.out.println("");
            aleatorio = generador.nextInt(256);
            repeticiones ++;
            if (aleatorio == 0){
                System.out.print("Salió el 0");
            }
            else if(repeticiones == n){
                System.out.print("Se generaron " + n + " aleatorios");
            }
        }
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línea
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
        for(int i = 1; i <= n; i++){
            System.out.print("" + caracter);
        }
    }

    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        for(int i = 0; i < escalones; i++){
            for(int j = 0; j < alto; j++){
                System.out.println("");
                for(int k = 1; k <= (i * ancho); k++){
                    System.out.print(" ");
                }
                escribirCaracter(ancho, '*');
            }
        }
    }
}

