import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class trackingSystem{
    List<paquete> listaPaquetes = new ArrayList<>();
    public void addPackage(paquete pkg){
        /*boolean yaAñadido= false;
        for (paquete p:listaPaquetes) {
            if (p.getTrackingNumber().equals(pkg.getTrackingNumber())){
               yaAñadido=true;
                JOptionPane.showMessageDialog(null, "Paquete ya existente");
            }
            else {
                listaPaquetes.add(pkg);
                JOptionPane.showMessageDialog(null, "Paquete añadido correctamente");
            }
        }*/
        listaPaquetes.add(pkg);
    }

    public boolean removePackage(String trackingNumber1){
        /*boolean yaEliminado=false;
        for (paquete p: listaPaquetes) {
            if (p.getTrackingNumber().equals(trackingNumber1)){
                listaPaquetes.remove(p);
                yaEliminado=true;
                JOptionPane.showMessageDialog(null, "Paquete eliminado correctamente");
            }else {
                JOptionPane.showMessageDialog(null, "Paquete no encontrado");
                yaEliminado=false;
            }
        }*/
        paquete paqu;
        for (int i=0;i<listaPaquetes.size();i++) {
            paqu=listaPaquetes.get(i);
            if(paqu.getTrackingNumber().equals(trackingNumber1)){
                listaPaquetes.remove(i);
                return true;
            }
        }
        return false;

    }

    public paquete searchByRecipientAddress(address recipientAddress){
        for (paquete p1:listaPaquetes) {
            if (p1.getRecipientAddress().equals(recipientAddress)){
                return p1;
            }
        }
        return null;
    }

    public paquete searchByTrackingNumber(String trackingNumber){
        try{
            int numTracking=Integer.parseInt(trackingNumber.substring(3));

            int izq = Integer.parseInt(listaPaquetes.get(0).getTrackingNumber().substring(3));
            int dere = Integer.parseInt(listaPaquetes.get(listaPaquetes.size()-1).getTrackingNumber().substring(3));

            while (izq <= dere) {
                int m = (izq + dere) / 2;
                int condicion=Integer.parseInt(listaPaquetes.get(m).getTrackingNumber().substring(3));
                if (condicion==numTracking) {
                    return listaPaquetes.get(m);
                } else if (condicion < numTracking) {
                    izq = m + 1;
                } else {
                    dere = m - 1;
                }
            }
        }catch (IndexOutOfBoundsException e) {
            return null;
        }

        return null;
    }
    public List<paquete> searchByCity (String ciudad){
        List<paquete> pPorCiudad=new ArrayList<paquete>();
        for (paquete paqu1 : listaPaquetes) {
            if(paqu1.getRecipientAddress().getCiudad().equals(ciudad)){
                pPorCiudad.add(paqu1);
            }
        }
        return pPorCiudad;
    }
    public String getLastPackageCode() {
        return listaPaquetes.get(listaPaquetes.size()-1).getTrackingNumber();
    }

    public String mostrarLista(List<paquete> lista){
        String mostrar="";
        for (paquete package1 : lista) {
            mostrar=mostrar+package1.toString();

        }
        return mostrar;
    }
    public void datosQuemados(){
        listaPaquetes.add(new paquete(new address("Calle 10 de Agosto", "Guayaquil", "Enviado 1", "2134"),new address("Av. Napo", "Quito","Recibido 1", "2134"),LocalDate.of(2023,4,11)));
        listaPaquetes.add(new paquete(new address("Avenida Edgar Cordova Polo", "Machala", "Enviado 2", "1023"),new address("Calle 10 de Agosto", "Guayaquil","Recibido 2", "1023"),LocalDate.of(2023,5,22)));
        listaPaquetes.add(new paquete(new address("Calle Larga", "Cuenca", "Enviado 3", "4321"),new address("Avenida Edgar Cordova Polo", "Machala","Recibido 3", "4321"),LocalDate.of(2023,6,3)));
        listaPaquetes.add(new paquete(new address("Calle Montego Bye", "Ambato", "Enviado 4", "3451"),new address("Calle José Calama", "Quito","Recibido 4", "3451"),LocalDate.of(2023,1,12)));
        listaPaquetes.add(new paquete(new address("Calle 12 de Octubre", "Quito", "Enviado 5", "8912"),new address("Montego Bye", "Ambato","Recibido 5", "8912"),LocalDate.of(2023,3,6)));
        listaPaquetes.add(new paquete(new address("Calle José Calama", "Quito", "Enviado 6", "0054"),new address("Calle Larga", "Cuenca","Recibido 6", "0054"),LocalDate.of(2023,2,15)));

    }

    @Override
    public String toString() {
        return "Sistema de rastreo " +
                "LISTA DE PAQUETES: \n" + listaPaquetes;
    }
}


