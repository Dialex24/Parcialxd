
import controlador.*;
import modelos.*;
import vistas.*;

public class main {
    

    public static void main(String[] args) {
        // TODO code application logic here
        frmPrincipal VistaPrincipal = new frmPrincipal();
        frmAgregar VistaAgregar = new frmAgregar(VistaPrincipal, true);
        frmContactos VistaContactos = new frmContactos(VistaPrincipal, true);
        contactosModel ModeloContactos = new contactosModel();
        
        contactosController controladorContactos = new contactosController(VistaPrincipal, VistaAgregar, VistaContactos , ModeloContactos);
    }
    
}
