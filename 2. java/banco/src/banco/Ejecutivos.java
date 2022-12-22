package banco;

public class Ejecutivos implements ITransacciones {

	public Ejecutivos() {

	}

	public void transaccionOk() {
		System.out.println("Operación realizada con éxito.");
	}

	public void transaccionNoOk() {
		System.out.println("No se pudo realizar la transacción.");
	}

	public void deposito() {
		System.out.println("Intentando realizar el depósito...");
		transaccionOk();
	}

	public void transferencia() {
		// TODO Auto-generated method stub
		System.out.println("Intenatando realizar la operación...");
		transaccionOk();
	}

	public void retiro() {
		// TODO Auto-generated method stub
		transaccionNoOk();
	}

	public void consulta() {
		// TODO Auto-generated method stub
		transaccionNoOk();
	}

	public void pagoServicios() {
		// TODO Auto-generated method stub
		transaccionNoOk();
	}
}
