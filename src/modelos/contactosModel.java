
package modelos;

import java.util.ArrayList; 

public class contactosModel {
    public ArrayList<Contactos> listaContactos = new ArrayList <Contactos>();
    
    public void agregarContacto(String ape, String nom, String tel){
        Contactos contacto = new Contactos(ape, nom, tel);
        this.listaContactos.add(contacto);   
    }
    
    public ArrayList ListarContactos (){
        return listaContactos;
    }     
}
