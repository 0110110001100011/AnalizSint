import java.awt.EventQueue;
import java.util.StringTokenizer;

public class AnalizadorSintactico {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static boolean esPalabraReservada(String palabra){
		String reservada = new String("break case char const continue default do double " +
				"else enum extern float for goto if int long register return short signed " +
				"sizeof static struct switch typedef union unsigned void  while struct static " +
				"const enum");
		StringTokenizer token = new StringTokenizer(reservada);
		String compara = new String();
		compara=token.nextToken();
		while(token.hasMoreTokens()){;
			if(palabra.compareTo(compara)==0)
				return true;
			compara=token.nextToken();
		}
		return false;
	}
	public static String muestra(int envio, String cadenaSalida){
		switch(envio){
		case 0:
			cadenaSalida+=("estado 0\n");
			break;
		/*case 1:
			cadenaSalida+=("Cadena o Identificador\n");
			break;*/
		case 1:case 2:
			cadenaSalida+=("ID ");
			break;
		case 3:	case 4: case 19:
			cadenaSalida+=("Operador Aritmetico ");
			break;
		case 5:
			cadenaSalida+=("Entero ");
			break;
		case 7:
			cadenaSalida+=("Real ");
			break;
		case 8:
			cadenaSalida+=("Parentesis ");
			break;
		case 9:
			cadenaSalida+=("Palabra reservada ");
			break;
		case 10:
			cadenaSalida+=("Llave ");
			break;
		case 11:
			cadenaSalida+=("Corchete ");
			break;
		case 12: case 13: case 23:
			cadenaSalida+=("Operador Relacional ");
			break;
		case 14: case 22:
			cadenaSalida+=("Operador Logico ");
			break;
		case 15:case 21: 
			cadenaSalida+=("Operador Asignacion ");
			break;
		case 16:case 17: case 24:
			cadenaSalida+=("Operador nivel bit ");
			break;
		case 18:
			cadenaSalida+=("Incremento ");
			break;
		case 20:
			cadenaSalida+=("Decremento ");
			break;
		default:
			cadenaSalida+=("ERROR ");
		}
		return cadenaSalida;
	}
	
	public String analizaCadena(String cadena){
			
		return cadena;
	}

}
