import java.time.LocalDate;

public class paquete{
    private String trackingNumber;
    private address senderAdrees, recipientAddress;
    private LocalDate estimatedDeliveryDate;
    private static int cont=0;

    public paquete(address senderAdrees, address recipientAddress, LocalDate estimatedDeliveryDate) {
        this.trackingNumber = newTracking();
        this.senderAdrees = senderAdrees;
        this.recipientAddress = recipientAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private String newTracking(){
        cont=cont+1;
        return"AS-"+cont;

    }

    public String getTrackingNumber() {
        return trackingNumber;
    }


    public address getRecipientAddress() {
        return recipientAddress;
    }


    @Override
    public String toString() {
        return "\nPAQUETE\n" +
                "Número de rastreo: " + trackingNumber + "\n" +
                "Dirección del remitente: " + senderAdrees +"\n"+
                "Dirección del destinatario: " + recipientAddress +"\n"+
                "Fecha estimada de entrega: " + estimatedDeliveryDate +"\n";
    }
}
