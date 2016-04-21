package examenDocumentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Examen: refactoriza, documenta y crea repositorio remoto.(25/abril/2016)
 * Para realizar este examen deber�s crear en Eclipse un proyecto con un paquete y dos clases: TestCCuenta y CCuenta. 
 * Refactorizaci�n:
 * Deber�s refactorizar ambas clases y entregar, aparte del resultado, un documento "ApellidosNombreRefactorizacion.pdf" con pantallazos del antes y despu�s de cada uno de los pasos debidamente identificados, incluyendo el men� utilizado para ello.
 * Realiza las siguientes actividades:
 * � En la clase TestCCuenta
 * � TestCCuenta.java: Extrae los m�todos recogerOpcion, mostrarMenu, ingresar, retirar
 * � TestCCuenta.java: Convierte dato en campo
 * � TestCCuenta.java: Incorpora saldoActual en la misma l�nea.
 * � TestCCuenta.java: Renombra la variable local cuenta1 con tu cuenta en el sistema (d13macom, por ejemplo)
 * � En la clase CCuenta.java:
 * � CCuenta.java: Cambia el nombre del m�todo "obtenerCuenta" por "getCuenta"
 * � CCuenta.java: Encapsula los campos y usa los m�todos generados.
 * Documentaci�n:
 * Deber�s documentar todo el proyecto:
 * � Inserta todos los comentarios Javadoc posibles. 
 * � Introduce como autor tu nombre y apellidos.
 * � Genera y entrega la documentaci�n Javadoc para todo el proyecto.
 * Repositorio con git:
 * Mediante comandos git, crea un repositorio local con el resultado. Una vez creado s�belo a tu cuenta de github y env�a la direcci�n para poder visualizarlo. Incluir� lo siguiente:
 * � Proyecto resultante de la refactorizaci�n y de la documentaci�n.
 * � "ApellidosNombreRefactorizacion.pdf" resultante de la refactorizaci�n.
 * � "ApellidosNombreRepositorio.pdf" resultante de este apartado. Aparecer�n pantallazos con los comandos utilizados en la consola git. 
 *
 * 
 * @author �lvaro Mu�oz Molina
 * @version 1.0
 *
 */

public class TestCCuenta {
	
	/**
	 * BUFFER EN EL QUE VAMOS A INTRODUCIR LOS DATOS
	 */
	private static BufferedReader dato;

	/**
	 * MAIN EN EL QUE VAMOS A EJECUTAR EL PROGRAMA
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		dato = new BufferedReader(new InputStreamReader(System.in));
		
			
		/**
		 * OPCION DEL MENU
		 */
		int opcion = 0;
		
		/**
		 * CREACION DEL OBJETO CUENTA CON EL QUE VAMOS A TRABAJAR
		 */	
		CCuenta d15mumoa = new CCuenta("Rigoberta Piedra", "0000-6523-85-678912345", 2500, 0);
		
		/**
		 * DO WHILE PARA REPETIR EL PROGRAMA HASTA QUE EL USUARIO PULSE SALIR
		 */
		do {
			/**
			 * TRY CATCH PARA ASEGURAR QUE LAS INSTRUCCIONES SE EJECUTAN SIN PROBLEMAS
			 */
			try {
				/**
				 * MUESTRA EL MENU
				 */
				mostrarMenu();
				/**
				 * RECOGE LA OPCION DEL USUARIO
				 */
				opcion = recogerOpcion(dato);
				/**
				 * SWITCH PARA REALIZAR UNA ACCION EN FUNCION DE LA OPCION ESCOGIDA
				 */
				switch (opcion) {
				/**
				 * CASO PRIMERO: INGRESAR DINERO
				 */
				case 1:
					ingresar(dato, d15mumoa);
					break;
				/**
				 * CASE SEGUNDO: RETIRAR DINERO
				 */
				case 2:
					retirar(dato, d15mumoa);
					break;
				/**
				 * CASE TERCERO: SALIR DEL PROGRAMA
				 */
				case 3:
					System.out.println("Aaaaaaaaaadios");
				}
			/**
			 * CATCH PARA CAPTURAR LAS EXCEPCIONES QUE PUEDAN OCURRIR
			 */
			} catch (IOException ex) {
				Logger.getLogger(TestCCuenta.class.getName()).log(Level.SEVERE, null, ex);
			}
		} while (opcion != 3);
		System.out.println("Saldo actual: " + d15mumoa.estado());
	}

	/**
	 * METODO QUE SIRVE PARA RETIRAR DINERO DE LA CUENTA
	 * 
	 * @param dato
	 * @param cuenta1
	 * @throws IOException
	 */
	
	private static void retirar(BufferedReader dato, CCuenta cuenta1) throws IOException {
		System.out.println("Indica cantidad a retirar: ");
		float retirar = Integer.parseInt(dato.readLine());
		try {
			cuenta1.retirar(retirar);
		} catch (Exception e) {
			System.out.print("Fallo al retirar");
		}
	}

	/**
	 * METODO QUE SIRVE PARA INGRESAR DINERO EN LA CUENTA
	 * 
	 * @param dato
	 * @param cuenta1
	 * @throws IOException
	 */
	
	private static void ingresar(BufferedReader dato, CCuenta cuenta1) throws IOException {
		System.out.println("Indica cantidad a ingresar: ");
		float ingresar = Integer.parseInt(dato.readLine());
		try {
			System.out.println("Ingreso en cuenta");
			cuenta1.ingresar(ingresar);
		} catch (Exception e) {
			System.out.print("Fallo al ingresar");
		}
	}
	
	/**
	 * METODO QUE MUESTRA EL MENU AL USUARIO
	 */

	private static void mostrarMenu() {
		System.out.println("MENU DE OPERACIONES");
		System.out.println("-------------------");
		System.out.println("1 - Ingresar");
		System.out.println("2 - Retirar");
		System.out.println("3 - Salir");
	}
	
	/**
	 * METODO QUE DEVUELVE LA OPCION ELGIDA POR EL USUARIO
	 * 
	 * @param dato
	 * @return
	 * @throws IOException
	 */

	private static int recogerOpcion(BufferedReader dato) throws IOException {
		int opcion;
		opcion = Integer.parseInt(dato.readLine());
		return opcion;
	}
}
