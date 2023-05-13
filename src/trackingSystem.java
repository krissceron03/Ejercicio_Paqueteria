import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class trackingSystem{
    List<paquete> listaPaquetes = new ArrayList<>();
    public void addPackage(paquete pkg){
        boolean yaAñadido= false;
        for (paquete p:listaPaquetes) {
            if (p.getTrackingNumber().equals(pkg.getTrackingNumber())){
               yaAñadido=true;
                JOptionPane.showMessageDialog(null, "Paquete ya existente");
            }
            else {
                listaPaquetes.add(pkg);
                JOptionPane.showMessageDialog(null, "Paquete añadido correctamente");
            }
        }
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
        listaPaquetes.add(new paquete(new address("Calle envío 1", "Ciudad envío 1", "Enviado 1", "Cod envío 1"),new address("Calle recibo 1", "Ciudad recibo 1","Recibido 1", "Cod recibido 1"),LocalDate.of(2023,4,11)));
        listaPaquetes.add(new paquete(new address("Calle envío 2", "Ciudad envío 2", "Enviado 2", "Cod envío 2"),new address("Calle recibo 2", "Ciudad recibo 2","Recibido 2", "Cod recibido 2"),LocalDate.of(2023,5,22)));
        listaPaquetes.add(new paquete(new address("Calle envío 3", "Ciudad envío 3", "Enviado 3", "Cod envío 3"),new address("Calle recibo 3", "Ciudad recibo 3","Recibido 3", "Cod recibido 3"),LocalDate.of(2023,6,3)));
        listaPaquetes.add(new paquete(new address("Calle envío 4", "Ciudad envío 4", "Enviado 4", "Cod envío 4"),new address("Calle recibo 4", "Ciudad recibo 4","Recibido 4", "Cod recibido 4"),LocalDate.of(2023,1,12)));
        listaPaquetes.add(new paquete(new address("Calle envío 5", "Ciudad envío 5", "Enviado 5", "Cod envío 5"),new address("Calle recibo 5", "Ciudad recibo 5","Recibido 5", "Cod recibido 5"),LocalDate.of(2023,3,6)));
        listaPaquetes.add(new paquete(new address("Calle envío 6", "Ciudad envío 6", "Enviado 6", "Cod envío 6"),new address("Calle recibo 6", "Ciudad recibo 6","Recibido 6", "Cod recibido 6"),LocalDate.of(2023,2,15)));

    }

    @Override
    public String toString() {
        return "TrackingSystem{" +
                "listaPaquetes=" + listaPaquetes +
                '}';
    }
}


