package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ControladorRequerimientos;
import modelo.vo.Nuevo_lider_Vo;
import modelo.vo.Requerimiento_IDMAXVo;

public class NewLider extends JFrame implements ActionListener {
    private JButton Insertar, Limpiar, Cerrar;
    // private GridLayout miflow;
    // private JButton arrayBtn[];
    private JTextField txnomnewL, txid_newL, txpapellidonewL, txsapellidonewL, txsalarionewL, txciudadnewL, txcargonewL,
            txclasinewL, txdocumennewL, txfechanacinewLider;// apellido, salario;
    String id_l;
    private JLabel lbid_lider, lbnombreLider, lbpapellidoLider, lbsapellidoLider, lbsalarioLider, lbciudadLider,
            lbcargoLider, lbclasifiLider, lbdocumenLider, lbfechanaciLider;
    private ControladorRequerimientos controlad2;
    public boolean pasonl = false;

    public NewLider() {
        // ControladorRequerimientos controlad = new ControladorRequerimientos();
        controlad2 = new ControladorRequerimientos();
        setLayout(null);
        setBounds(10, 10, 500, 600);
        setLocationRelativeTo(null);
        // formulario.setResizable(true);
        setVisible(true);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbid_lider = new JLabel("ID lider");
        lbid_lider.setBounds(10, 10, 80, 25);
        add(lbid_lider);
        txid_newL = new JTextField(null);
        txid_newL.setBounds(120, 10, 190, 25);
        txid_newL.setEditable(false);
        add(txid_newL);

        lbnombreLider = new JLabel("Nombre");
        lbnombreLider.setBounds(10, 50, 80, 25);
        add(lbnombreLider);
        txnomnewL = new JTextField(null);
        txnomnewL.setBounds(120, 50, 190, 25);
        add(txnomnewL);

        lbpapellidoLider = new JLabel("Primer Apellido");
        lbpapellidoLider.setBounds(10, 90, 80, 25);
        add(lbpapellidoLider);
        txpapellidonewL = new JTextField(null);
        txpapellidonewL.setBounds(120, 90, 190, 25);
        add(txpapellidonewL);

        lbsapellidoLider = new JLabel("Segundo Apellido");
        lbsapellidoLider.setBounds(10, 130, 80, 25);
        add(lbsapellidoLider);
        txsapellidonewL = new JTextField(null);
        txsapellidonewL.setBounds(120, 130, 190, 25);
        add(txsapellidonewL);

        lbsalarioLider = new JLabel("Salario");
        lbsalarioLider.setBounds(10, 180, 80, 25);
        add(lbsalarioLider);
        txsalarionewL = new JTextField(null);
        txsalarionewL.setBounds(120, 180, 190, 25);
        add(txsalarionewL);

        lbciudadLider = new JLabel("Ciudad");
        lbciudadLider.setBounds(10, 220, 80, 25);
        add(lbciudadLider);
        txciudadnewL = new JTextField(null);
        txciudadnewL.setBounds(120, 220, 190, 25);
        add(txciudadnewL);

        lbcargoLider = new JLabel("Cargo");
        lbcargoLider.setBounds(10, 260, 80, 25);
        add(lbcargoLider);
        txcargonewL = new JTextField(null);
        txcargonewL.setBounds(120, 260, 190, 25);
        add(txcargonewL);

        lbclasifiLider = new JLabel("Clasificación");
        lbclasifiLider.setBounds(10, 300, 80, 25);
        add(lbclasifiLider);
        txclasinewL = new JTextField(null);
        txclasinewL.setBounds(120, 300, 190, 25);
        add(txclasinewL);

        lbdocumenLider = new JLabel("Documento");
        lbdocumenLider.setBounds(10, 340, 80, 25);
        add(lbdocumenLider);
        txdocumennewL = new JTextField(null);
        txdocumennewL.setBounds(120, 340, 190, 25);
        add(txdocumennewL);

        lbfechanaciLider = new JLabel("Fecha de nacimiento");
        lbfechanaciLider.setBounds(10, 380, 80, 25);
        add(lbfechanaciLider);
        txfechanacinewLider = new JTextField(null);
        txfechanacinewLider.setBounds(120, 380, 190, 25);
        add(txfechanacinewLider);

        Insertar = new JButton("Insetar");
        Insertar.setBounds(200, 440, 100, 80);
        add(Insertar);
        Insertar.addActionListener(this);

        Limpiar = new JButton("Limpiar");
        Limpiar.setBounds(340, 440, 100, 80);
        add(Limpiar);
        Limpiar.addActionListener(this);
        // habilitar(false, false);

        Cerrar = new JButton("Cerrar");
        Cerrar.setBounds(60, 440, 100, 80);
        add(Cerrar);
        Cerrar.addActionListener(this);
        MaximoID();

    }

    public void vaciartextos() {

        txnomnewL.setText("");
        // txid_newL.setText("");
        txpapellidonewL.setText("");
        txsapellidonewL.setText("");
        txsalarionewL.setText("");
        txciudadnewL.setText("");
        txcargonewL.setText("");
        txclasinewL.setText("");
        txdocumennewL.setText("");
        txfechanacinewLider.setText("");
    }

    public void MaximoID() {
        try {

            Requerimiento_IDMAXVo IDMAX = controlad2.consultaMaxID();
            // System.out.println("aca vamos 1");
            if (IDMAX != null) {
                txid_newL.setText((IDMAX.getMaxID() + 1 + ""));
            } else {
                JOptionPane.showMessageDialog(null, "No existen datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e2);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cerrar) {
            super.dispose();

        }
        if (e.getSource() == Insertar) {
            boolean datoscompletos = true;
            // System.out.println(txnomnewL.getText());
            if (txcargonewL.getText().isEmpty() == true) {
                datoscompletos = false;
            }
            if (txnomnewL.getText().isEmpty() == true) {
                datoscompletos = false;
            }
            if (txpapellidonewL.getText().isEmpty() == true) {
                datoscompletos = false;
            }
            if (txdocumennewL.getText().isEmpty() == true) {
                datoscompletos = false;
            }
            if (txciudadnewL.getText().isEmpty() == true) {
                datoscompletos = false;
            }
            if (txsapellidonewL.getText().isEmpty() == true) {
                datoscompletos = false;
            }
            if (txsalarionewL.getText().isEmpty() == true) {
                datoscompletos = false;
            }
            if (txclasinewL.getText().isEmpty() == true) {
                datoscompletos = false;
            }
            if (txfechanacinewLider.getText().isEmpty() == true) {
                datoscompletos = false;
            }
            if (datoscompletos == true) {

                try {

                    Nuevo_lider_Vo datosNuevoLider = new Nuevo_lider_Vo();
                    datosNuevoLider.setID_nLider(Integer.parseInt(txid_newL.getText()));
                    datosNuevoLider.setNomNLider(txnomnewL.getText());
                    datosNuevoLider.setpApellidonLider(txpapellidonewL.getText());
                    datosNuevoLider.setsApellidonLider(txsapellidonewL.getText());
                    datosNuevoLider.setSalarionLider(Integer.parseInt(txsalarionewL.getText()));
                    datosNuevoLider.setCiudadnLider(txciudadnewL.getText());
                    datosNuevoLider.setCargonLider(txcargonewL.getText());
                    datosNuevoLider.setClasifinLider(Integer.parseInt(txclasinewL.getText()));
                    datosNuevoLider.setDocumennLider(txdocumennewL.getText());
                    datosNuevoLider.setFechacumplenLider(txfechanacinewLider.getText());
                    Integer resultado = controlad2.insertar_nuevo_lider(datosNuevoLider);
                    if (resultado != null) {
                        JOptionPane.showMessageDialog(null, "Nuevo Lider añadido", "Advertencia",
                                JOptionPane.INFORMATION_MESSAGE);
                        vaciartextos();
                        MaximoID();

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar el nuevo Lider", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el nuevo Lider", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println(e2);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Datos incompletos", "Advertencia",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }
        if (e.getSource() == Limpiar) {
            vaciartextos();

        }
    }

}
