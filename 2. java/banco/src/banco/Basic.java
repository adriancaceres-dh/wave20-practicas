package banco;

public class Basic implements ITransacciones {
	public Basic() {

	}

	public void transaccionOk() {

		System.out.println("Operación realizada correctamente.");
	}

	public void transaccionNoOk() {
		System.out.println("La operación no se pudo llevar a cabo.");

	}

	public void deposito() {
		transaccionNoOk();

	}

	public void transferencia() {
		transaccionNoOk();

	}

	public void retiro() {
		System.out.println("Retirando dinero en efectivo...");
		transaccionOk();

	}

	public void consulta() {
		System.out.println("Consultando saldo...");
		transaccionOk();

	}

	public void pagoServicios() {
		System.out.println("Espere mientras pagamos su servicio...");
		transaccionNoOk();

	}

}
