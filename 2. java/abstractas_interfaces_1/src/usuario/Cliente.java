package usuario;

import transaccion.*;

public interface Cliente {
    // En general me parece horrible en la implementaciones haber usado
    // instanceof para chequear a que tipo correspondía
    void realizarTransaccion(Transaccion transaccion);
}
