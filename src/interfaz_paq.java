import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class interfaz_paq extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton btnDatosPred;
    private JButton mostrarPaquetesButton;
    private JTextArea tAmostrarDatos;
    private JTextField txtCalleSalida;
    private JTextField txtCiudadSalida;
    private JTextField txtEstadoSalida;
    private JTextField txtCodigoSalida;
    private JTextField txtCalleLlegada;
    private JTextField txtCiudadLlegada;
    private JTextField txtEstadoLlegada;
    private JTextField txtCodigoLlegada;
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtAnio;
    private JButton btnAñadirPaquete;
    private JTextField txtTrancking;
    private JButton btnRemover;
    private JTextField txtBuscarCiudad;
    private JButton btnBuscarCiudad;
    private JTextArea tABuscarPorCiudad;
    private JTextField txtCodigoDire;
    private JTextField txtEstadoDire;
    private JButton btnBuscarporDire;
    private JTextArea tABuscarporDire;
    private JTextField txtCalleDire;
    private JTextField txtCiudadDire;
    private JTextField txtNumeroTran;
    private JButton btnBuscarPorNum;
    private JTextArea tABuscarporNum;
    private trackingSystem ts;
public interfaz_paq(String titulo) {
    super(titulo);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panel1);
    this.pack();
    ts=new trackingSystem();
    btnDatosPred.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ts.datosQuemados();
            JOptionPane.showMessageDialog(null, "Datos Quemados cargados correctamente");
            btnDatosPred.setEnabled(false);

        }
    });
    mostrarPaquetesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          tAmostrarDatos.setText(ts.toString());
        }
    });
    btnAñadirPaquete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ts.addPackage(new paquete(new address(txtCalleSalida.getText(),txtCiudadSalida.getText(),txtEstadoSalida.getText(),txtCodigoSalida.getText()),
                    new address(txtCalleLlegada.getText(),txtCiudadLlegada.getText(),txtEstadoLlegada.getText(),txtCodigoLlegada.getText()),
                    LocalDate.of(Integer.parseInt(txtAnio.getText()), Integer.parseInt(txtMes.getText()), Integer.parseInt(txtDia.getText()))));
            JOptionPane.showMessageDialog(null, "Paquete creado correctamente\n Código: "+ts.getLastPackageCode());
        }
    });
    btnRemover.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(ts.removePackage(txtTrancking.getText())){
                JOptionPane.showMessageDialog(null, "Paquete encontrado y eliminado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Paquete no existente o codigo ingresado incorrectamente");
            }
        }
    });
    btnBuscarCiudad.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<paquete> ciudad=ts.searchByCity(txtBuscarCiudad.getText());
            System.out.println("Tamaño arreglo ciudades: "+ciudad.size());
            if(ciudad.size()>0){
                tABuscarPorCiudad.setText(ts.mostrarLista(ciudad));
            }
            else{tABuscarPorCiudad.setText("No se encontraron paquetes");
            }
        }
    });
    btnBuscarporDire.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            paquete paquete1=ts.searchByRecipientAddress(new address(txtCalleDire.getText(),txtCiudadDire.getText(),txtEstadoDire.getText(),txtCodigoDire.getText()));
            if(paquete1!=null){
                tABuscarporDire.setText(paquete1.toString());
            }else{
                tABuscarporDire.setText("No se encontraron resultados para la busqueda");
            }
        }
    });
    btnBuscarPorNum.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            paquete paquete1=ts.searchByTrackingNumber(txtNumeroTran.getText());
            if(paquete1!=null){
                tABuscarporNum.setText(paquete1.toString());
            }else{
                tABuscarporNum.setText("No se encontraron paquetes");
            }
        }
    });
}
}
