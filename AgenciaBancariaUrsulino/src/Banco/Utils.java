//ações de formatação de valores

package Banco;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

    static NumberFormat formatandoNumeros = new DecimalFormat("R$ #,##0.00");
    
    public static String doubleToString(Double valor) {
        return Utils.formatandoNumeros.format(valor);
        }
}