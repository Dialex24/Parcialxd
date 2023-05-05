
package controlador;

import java.awt.event.*;        
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.*;
import vistas.*;

public class contactosController implements ActionListener {
    frmPrincipal vistaPrincipal;
    frmAgregar vistaAgregar;
    frmContactos vistaContactos;
    frmVer vistaVer;
    contactosModel modeloContactos;
public DefaultTableModel TablaContactos = new DefaultTableModel();

    public contactosController(frmPrincipal vistaPrincipal, frmAgregar vistaAgregar, frmContactos vistaContactos, contactosModel modeloContactos) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaAgregar = vistaAgregar;
        this.vistaContactos = vistaContactos;
        this.modeloContactos = modeloContactos;
        
        this.vistaPrincipal.btnAgregar.addActionListener(this);
        this.vistaPrincipal.btnContactos.addActionListener(this);
        this.vistaAgregar.btnCancelar.addActionListener(this);
        
        this.vistaPrincipal.setVisible(true);
        
        this.TablaContactos.addColumn("APELLIDO");
        this.TablaContactos.addColumn("NOMBRES");
        this.TablaContactos.addColumn("TELEFONO");     
        this.vistaContactos.jtbContactos.setModel(TablaContactos);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.vistaPrincipal.btnAgregar){
            this.vistaAgregar.setVisible(true);
            this.modeloContactos.agregarContacto(this.vistaAgregar.txtApellidos.getText(),
                    this.vistaAgregar.txtNombre.getText(), 
                    this.vistaAgregar.txtTelefono.getText());
        }
        
        if(e.getSource()== this.vistaAgregar.btnAgregarContacto){
            this.modeloContactos.agregarContacto(this.vistaAgregar.txtApellidos.getText(),
                    this.vistaAgregar.txtNombre.getText(), 
                    this.vistaAgregar.txtTelefono.getText());
        
      
        
        if(e.getSource()== this.vistaAgregar.btnCancelar){
            this.vistaAgregar.dispose();
        }    
            
            ArrayList <Contactos> listaLocal = this.modeloContactos.ListarContactos();
            
            String Cadena = " ";
            
                
            for(Contactos MiListaContactos: listaLocal){
                Cadena = Cadena + MiListaContactos.getApellido() + " " + MiListaContactos.getNombre() + " " + MiListaContactos.getTelefono() +"\n";
                this.vistaVer.txtVer.setText(Cadena);
                
                      
        }
    }
    
         if(e.getSource () == this.vistaPrincipal.btnContactos){
            ArrayList<Contactos> listaLocal = this.modeloContactos.ListarContactos();
            
             for(int i = 0; i < listaLocal.size(); i++){
                
                this.TablaContactos.addRow(new Object[]{this.modeloContactos.listaContactos.get(i).getApellido(), 
                this.modeloContactos.listaContactos.get(i).getNombre(), 
                Integer.parseInt(this.modeloContactos.listaContactos.get(i).getTelefono())});  
                
            }        
}

         if(e.getSource () == this.vistaPrincipal.btnContactos){
            this.vistaContactos.setVisible(true);
}

}
}