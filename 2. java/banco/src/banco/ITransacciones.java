package banco;

public interface ITransacciones {
	public void transaccionOk();

	public void transaccionNoOk();
	public abstract void deposito();

	public void transferencia();

	public void retiro();

	public void consulta();

	public void pagoServicios();
}
