package banco;

public class Cobradores implements ITransacciones {
	public Cobradores() {

	}

	public void transaccionOk() {
		System.out.println("La operación se realizó sin problemas.");

	}

	public void transaccionNoOk() {
		System.out.println("No se pudo llevar a cabo la operación solicitada.");

	}

	public void deposito() {
		transaccionNoOk();

	}

	public void transferencia() {
		transaccionNoOk();

	}

	public void retiro() {
		System.out.println("Realizando la operación...");
		transaccionOk();

	}

	public void consulta() {
		transaccionOk();

	}

	public void pagoServicios() {
		System.out.println("Intentando pagar su servicio....");
		transaccionNoOk();

	}

}
