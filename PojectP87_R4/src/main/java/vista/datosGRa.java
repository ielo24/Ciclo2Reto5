package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorRequerimientos;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class datosGRa extends JFrame implements ActionListener {
    private JButton Inicio, Opc1, Opc2, NuevoLid;// Botones
    private JTextField cmpNombre = new JTextField();// Letrero de bienvenida
    String nombre, id_l, apellido, salario, id_p, nomMaterial;// asignacion de datos
    private ControladorRequerimientos controlad = new ControladorRequerimientos();// Llamado y asignacion del
                                                                                  // controlador
    // Tabla de datos
    private DefaultTableModel plantilla = new DefaultTableModel();
    private JTable tabla = new JTable(plantilla);
    private JScrollPane scroll = new JScrollPane(tabla);

    public Boolean paso = false;
    Object[][] nomD = {}; // datos para borrar tabla

    public void texto() {
        setLayout(null);
        cmpNombre.setText("**** Bienvenidos ****");
        cmpNombre.setFont(new java.awt.Font("Verdana", 1, 30));
        cmpNombre.setBounds(130, 30, 400, 400);
        add(cmpNombre);
        cmpNombre.setEditable(false);
        cmpNombre.setFocusable(true);
        scroll.setFocusable(false);
        Object[] nomC = {};
        plantilla.setDataVector(nomD, nomC);
    }

    public datosGRa() {

        setBounds(10, 10, 600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Asignacion de datos a los botones
        setLayout(null);
        Inicio = new JButton("Inicio");
        Inicio.setBounds(10, 30, 100, 80);
        add(Inicio);
        Inicio.addActionListener(this);

        Opc1 = new JButton("Opcion 1");
        Opc1.setBounds(10, 130, 100, 80);
        add(Opc1);
        Opc1.addActionListener(this);

        Opc2 = new JButton("Opcion 2");
        Opc2.setBounds(10, 230, 100, 80);
        add(Opc2);
        Opc2.addActionListener(this);

        NuevoLid = new JButton("Nuevo Lider");
        NuevoLid.setBounds(10, 330, 100, 80);
        add(NuevoLid);
        NuevoLid.addActionListener(this);
        texto();

    }

    public void FormularioTable(Object[] datos) {

        setLayout(null);
        cmpNombre.setBounds(0, 0, 0, 0);
        cmpNombre.setFocusable(false);
        cmpNombre.setText("");
        String[] nomCol = { "ID_Lider", "Nombre", "Primer_Apellido", "Salarios" };
        scroll.setFocusable(true);
        if (paso == false) {

            plantilla.setDataVector(nomD, nomCol);
            scroll.setBounds(130, 30, 400, 400);
            add(scroll, BorderLayout.CENTER);
            plantilla.insertRow(0, datos);
            paso = true;
        } else {
            plantilla.addRow(datos);
        }

    }

    public void FormularioTable2(Object[] datos) {

        setLayout(null);
        cmpNombre.setBounds(0, 0, 0, 0);
        cmpNombre.setFocusable(false);
        scroll.setFocusable(true);
        cmpNombre.setText("");

        String[] nomCol = { "ID_Proyecto", "Nombre del material" };
        if (paso == false) {

            plantilla.setDataVector(nomD, nomCol);
            scroll.setBounds(130, 30, 400, 400);
            add(scroll, BorderLayout.CENTER);
            plantilla.insertRow(0, datos);
            paso = true;
        } else {
            plantilla.addRow(datos);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Inicio) {

            texto();
            texto();
        }
        if (e.getSource() == Opc1) {

            cmpNombre.setBounds(0, 0, 0, 0);
            try {

                ArrayList<Requerimiento_1Vo> requeri1 = controlad.consultarRequerimiento1();
                paso = false;

                if (requeri1 != null) {
                    for (int i = 0; i < requeri1.size(); i++) {
                        id_l = requeri1.get(i).getIdlider() + "";
                        nombre = requeri1.get(i).getNombre();
                        apellido = requeri1.get(i).getPriapellido();
                        salario = (requeri1.get(i).getSalario() + "");
                        Object[] datosnuevos = { id_l, nombre, apellido, salario };
                        FormularioTable(datosnuevos);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No existen datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e2);
            }

        }
        if (e.getSource() == Opc2) {

            cmpNombre.setBounds(0, 0, 0, 0);
            try {

                ArrayList<Requerimiento_2Vo> requeri2 = controlad.consultarRequerimiento2();
                paso = false;
                if (requeri2 != null) {
                    for (int i = 0; i < requeri2.size(); i++) {
                        id_p = requeri2.get(i).getIdpro() + "";
                        nomMaterial = requeri2.get(i).getNommat();
                        Object[] datosnuevos = { id_p, nomMaterial };
                        FormularioTable2(datosnuevos);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No existen datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e3) {
                JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e3);
            }

        }
        if (e.getSource() == NuevoLid) {

            try {
                controlad.mostrarnewlider();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Error al abrir la ventana", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e1);
            }
        }

    }

}