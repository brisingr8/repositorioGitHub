package examenDocumentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Examen: refactoriza, documenta y crea repositorio remoto.(25/abril/2016)
 * Para realizar este examen deberás crear en Eclipse un proyecto con un paquete y dos clases: TestCCuenta y CCuenta. 
 * Refactorización:
 * Deberás refactorizar ambas clases y entregar, aparte del resultado, un documento "ApellidosNombreRefactorizacion.pdf" con pantallazos del antes y después de cada uno de los pasos debidamente identificados, incluyendo el menú utilizado para ello.
 * Realiza las siguientes actividades:
 * · En la clase TestCCuenta
 * · TestCCuenta.java: Extrae los métodos recogerOpcion, mostrarMenu, ingresar, retirar
 * · TestCCuenta.java: Convierte dato en campo
 * · TestCCuenta.java: Incorpora saldoActual en la misma línea.
 * · TestCCuenta.java: Renombra la variable local cuenta1 con tu cuenta en el sistema (d13macom, por ejemplo)
 * · En la clase CCuenta.java:
 * · CCuenta.java: Cambia el nombre del método "obtenerCuenta" por "getCuenta"
 * · CCuenta.java: Encapsula los campos y usa los métodos generados.
 * Documentación:
 * Deberás documentar todo el proyecto:
 * · Inserta todos los comentarios Javadoc posibles. 
 * · Introduce como autor tu nombre y apellidos.
 * · Genera y entrega la documentación Javadoc para todo el proyecto.
 * Repositorio con git:
 * Mediante comandos git, crea un repositorio local con el resultado. Una vez creado súbelo a tu cuenta de github y envía la dirección para poder visualizarlo. Incluirá lo siguiente:
 * · Proyecto resultante de la refactorización y de la documentación.
 * · "ApellidosNombreRefactorizacion.pdf" resultante de la refactorización.
 * · "ApellidosNombreRepositorio.pdf" resultante de este apartado. Aparecerán pantallazos con los comandos utilizados en la consola git. 
 *
 * 
 * @author Álvaro Muñoz Molina
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
