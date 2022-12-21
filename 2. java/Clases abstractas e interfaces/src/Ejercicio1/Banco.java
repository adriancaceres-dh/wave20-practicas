package Ejercicio1;

import java.util.LinkedList;

public class Banco {
    private LinkedList<Usuarios> usuariosBanco = new LinkedList<>();

    private String nombreBanco;

    public Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public LinkedList<Usuarios> getUsuariosBanco() {
        return usuariosBanco;
    }

    public void agregarUsuariosBanco(Usuarios nuevoUsuario) {
        usuariosBanco.add(nuevoUsuario);
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public boolean realizarDeposito(int cantEfectivoDepositar, Usuarios usuarioConsulta) {
        /* Esta condición de if representaría la validació de la tarjeta en el cajero o cuando la persona en el
         * mostrador verifica los datos del usuario en el sistema. Si los datos no son encontrados se rechaza solicitud.*/
        Deposito nuevaD = new Deposito();
        if (usuariosBanco.contains(usuarioConsulta)) {
            // Aquí debería verificar que la cuenta exista para colocar el 1 o 0.
            // Además si tiene la cantidad de $ suficiente.
            if (cantEfectivoDepositar == 1) {
                nuevaD.transaccionOk();
                return true;
            } else {
                nuevaD.transaccionNoOk();
                return false;
            }
        } else {
            // El usuario no existe en el sistema
            nuevaD.transaccionNoOk();
            return false;
        }
    }

    public boolean realizarTransferencia(int cantDinero, Usuarios usuarioConsulta) {
        /* Esta condición de if representaría la validació de la tarjeta en el cajero o cuando la persona en el
         * mostrador verifica los datos del usuario en el sistema. Si los datos no son encontrados se rechaza solicitud.*/
        Transferencia nuevaT = new Transferencia();
        if (usuariosBanco.contains(usuarioConsulta)) {
            // Aquí debería verificar que la cuenta exista para colocar el 1 o 0.
            // Además si tiene la cantidad de $ suficiente.
            if (cantDinero == 1) {
                nuevaT.transaccionOk();
                return true;
            } else {
                nuevaT.transaccionNoOk();
                return false;
            }
        } else {
            // El usuario no existe en el sistema
            nuevaT.transaccionNoOk();
            return false;
        }
    }

    public boolean realizarRetiroDeEfectivo(int cantidadDineroRetirar, Usuarios usuarioConsulta) {
        /* Esta condición de if representaría la validació de la tarjeta en el cajero o cuando la persona en el
         * mostrador verifica los datos del usuario en el sistema. Si los datos no son encontrados se rechaza solicitud.*/
        RetiroDeEfectivo nuevoRE = new RetiroDeEfectivo();
        if (usuariosBanco.contains(usuarioConsulta)) {
            // Aquí debería verificar que posee la cantidad de efectivo a retirar.
            if (cantidadDineroRetirar == 1) {
                nuevoRE.transaccionOk();
                return true;
            } else {
                nuevoRE.transaccionNoOk();
                return false;
            }
        } else {
            // El usuario no existe en el sistema
            nuevoRE.transaccionNoOk();
            return false;
        }
    }

    public boolean realizarConsultaDeSaldo(Usuarios usuarioConsulta) {
        /* Esta condición de if representaría la validació de la tarjeta en el cajero o cuando la persona en el
         * mostrador verifica los datos del usuario en el sistema. Si los datos no son encontrados se rechaza solicitud.*/
        ConsultaSaldo nuevaT = new ConsultaSaldo();
        if (usuariosBanco.contains(usuarioConsulta)) {
            nuevaT.realizarConsultaSaldo();
            return true;
        } else {
            // El usuario no existe en el sistema
            nuevaT.transaccionNoOk();
            return false;
        }
    }

    // El servicio debería ser un String que luego se busca el nombre en alguna lista. Pero por simplicidad se deja así.
    public boolean realizarPagoDeServicios(int servicio, Usuarios usuarioConsulta) {
        /* Esta condición de if representaría la validació de la tarjeta en el cajero o cuando la persona en el
         * mostrador verifica los datos del usuario en el sistema. Si los datos no son encontrados se rechaza solicitud.*/
        PagoServicios nuevoPS = new PagoServicios();
        if (usuariosBanco.contains(usuarioConsulta)) {
            // Aquí debería verificar que el servicio existe en alguna lista y no este al día con las cuotas.
            if (servicio == 1) {
                nuevoPS.transaccionOk();
                return true;
            } else {
                nuevoPS.transaccionNoOk();
                return false;
            }
        } else {
            // El usuario no existe en el sistema
            nuevoPS.transaccionNoOk();
            return false;
        }
    }
}
