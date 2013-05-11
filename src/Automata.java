@SuppressWarnings("serial")
public class Automata extends Ventana{
	//String token = new String();
	int estado=0;
	public int analiza(String cadena){
		char compara;
		for(int i=0;i<cadena.length();i++){
			compara=cadena.charAt(i);
			//System.out.println(cadena.substring(i,i+1)+estado);
			switch(estado){
			case 0://estado inicial
				if(AnalizadorSintactico.esPalabraReservada(cadena)){
					i=cadena.length();
					estado=9;
				}
				else if(Character.isLetter(compara)) 
					estado=1;
				else if(compara=='_')
					estado=2;
				else if(compara=='+')
					estado=3;
				else if(compara=='*' || compara=='/' || compara=='%')
					estado=4;
				else if(Character.isDigit(compara))
					estado=5;
				else if(compara=='(' || compara==')')
					estado=8;
				else if(compara=='{' || compara=='}')
					estado=10;
				else if(compara=='[' || compara==']')
					estado=11;
				else if(compara=='<')
					estado=12;
				else if(compara=='[' || compara==']')
					estado=11;
				else if(compara=='&')
						estado=16;
				else if(compara=='|')
					estado=17;
				else if(compara=='-')
					estado=19;
				else if(compara=='=')
					estado=21;
				else if(compara=='!')
					estado=22;
				else if(compara=='>')
					estado=23;
				else if(compara=='^')
					estado=24;
				else
					estado=99;
				break;
			case 1://cadena, id
				if(Character.isLetter(compara))
					estado=1;
				else if(Character.isDigit(compara) || (compara=='_'))
					estado=2;
				else
					estado=99;
				break;
			case 2://id
				if(Character.isLetter(compara) || (compara=='_') || (Character.isDigit(compara)))
					estado=2;
				else
					estado=99;
				break;
			case 3://operador suma
				if(Character.isDigit(compara))
					estado=5;
				else if(compara=='=')
					estado=15;
				else if(compara=='+')
					estado=18;
				else
					estado=99;
				break;
			case 4://operador mult
				if(compara=='=')
					estado=15;
				else
					estado=99;
				break;
			case 5://entero
				if(Character.isDigit(compara))
					estado=5;
				else if(compara=='.')
					estado=6;
				else
					estado=99;
				break;
			case 6:
				if(Character.isDigit(compara))
					estado=7;
				else
					estado=99;
				break;
			case 7://real
				if(Character.isDigit(compara))
					estado=7;
				else
					estado=99;
				break;
			case 8://parentesis
				estado=99;
				break;
			case 9://palabra reservada
				estado=99;
				break;
			case 10://llaves
				estado=99;
				break;
			case 11://corchetes
				estado=99;
				break;
			case 12:
				if(compara=='=')
					estado=13;
				else if(compara=='<')
					estado=24;
				else
					estado=99;
				break;
			case 13:
				estado=99;
				break;
			case 14:
				estado=99;
				break;
			case 15:
				estado=99;
				break;
			case 16:
				if(compara=='&')
					estado=14;
				else
					estado=99;
				break;
			case 17:
				if(compara=='|')
					estado=14;
				else
					estado=99;
				break;
			case 18:
				estado=99;
				break;
			case 19:
				if(compara=='-')
					estado=20;
				if(compara=='=')
					estado=15;
				else if(Character.isDigit(compara))
					estado=5;
				else
					estado=99;
				break;
			case 20:
				estado=99;
				break;
			case 21: case 22: 
				if(compara=='=')
					estado=13;
				else
					estado=99;
				break;
			case 23:
				if(compara=='=')
					estado=13;
				else if(compara=='>')
					estado=24;
				else
					estado=99;
				break;
			case 24:
				estado=99;
				break;
			case 99:
					i=cadena.length();
				break;
			}
		}
		return estado;
	}
}
