package examenDocumentacion;

public class CCuenta {
	/**
	 * CADENA QUE ALMACENA EL NOMBRE
	 */
	private String nombre;
	/**
	 * CADENA QUE ALMACENA LA CUENTA
	 */
	private String cuenta;
	/**
	 * DECIMAL QUE ALMACENA EL SALDO
	 */
	private double saldo;
	/**
	 * DECIMAL QUE ALMACENA EL TIPO DE INTERES
	 */
	private double tipoInteres;
	
	/**
	 * METODO QUE DEVUELVE EL NOMBRE
	 * 
	 * @return
	 */
	protected String getNombre() {
		return nombre;
	}

	/**
	 * METODO QUE DA VALOR AL NOMBRE
	 * 
	 * @param nombre
	 */
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	/**
	 * METODO QUE DEVUELVE CUENTA
	 * 
	 * @return
	 */
	protected String getCuenta() {
		return cuenta;
	}

	/**
	 * METODO QUE DA VALOR A CUENTA
	 * 
	 * @param cuenta
	 */
	protected void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * METODO QUE DEVUELVE TIPO DE INTERES
	 * 
	 * @return
	 */
	protected double getTipoInteres() {
		return tipoInteres;
	}

	/**
	 * METODO QUE DA VALOR A TIPO DE INTERES
	 * 
	 * @param tipoInteres
	 */
	protected void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	/**
	 * METODO QUE DEVUELVE SALDO
	 * 
	 * @return
	 */
	protected double getSaldo() {
		return saldo;
	}

	/**
	 * INICIA LOS CAMPOS DEL OBJETO
	 * 
	 * @param nom nombre del titular
	 * @param cue nombre de la cuenta
	 * @param sal saldo de la cuenta
	 * @param tipo tipo de interes
	 */
	public CCuenta(String nom, String cue, double sal, double tipo) {
		setNombre(nom);
		setCuenta(cue);
		setSaldo(sal);
		setTipoInteres(tipo);
	}

	/**
	 * METODO QUE DEVUELVE ESTADO
	 * 
	 * @return saldo
	 */
	public double estado() {
		return saldo;
	}

	/**
	 * METODO QUE INGRESA DINERO EN LA CUENTA
	 * 
	 * @param cantidad cantidad a ingresar en la cuenta
	 * @throws Exception excepcion si la cantidad es negativa
	 */
	public void ingresar(double cantidad) throws Exception {
		if (cantidad < 0) {
			throw new Exception("No se puede ingresar una cantidad negativa");
		}
		setSaldo(getSaldo() + cantidad);
	}

	/**
	 * METODO QUE RETIRA DINERO DE LA CUENTA
	 * 
	 * @param cantidad cantidad a retirar
	 * @throws Exception excepcion si no hay saldo suficiente
	 */
	public void retirar(double cantidad) throws Exception {
		if (cantidad < 0) {
			throw new Exception("No se puede retirar una cantidad negativa");
		}
		if (estado() < cantidad) {
			throw new Exception("No se hay suficiente saldo");
		}
		setSaldo(getSaldo() - cantidad);
	}

	/**
	 * METODO QUE DA VALOR AL SALDO
	 * 
	 * @param saldo saldo de la cuenta
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
