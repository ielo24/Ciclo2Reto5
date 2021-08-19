package modelo.dao;

//import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.vo.Nuevo_lider_Vo;
import util.JDBCUtilities;

public class Nuevo_Lider_Dao {

    public Integer Insert_nuevo_lider(Nuevo_lider_Vo datosNuevoLider) throws SQLException {
        Integer res = 0;
        Connection conex = JDBCUtilities.getConnection();
        Boolean realizado = false;

        try {
            String sql = "INSERT Into Lider (ID_Lider,Nombre,Primer_Apellido,Segundo_Apellido,Salario,Ciudad_Residencia,Cargo,Clasificacion,Documento_Identidad,Fecha_Nacimiento) values(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement inserNlider = conex.prepareStatement(sql);
            inserNlider.setInt(1, datosNuevoLider.getID_nLider());
            inserNlider.setString(2, datosNuevoLider.getNomNLider());
            inserNlider.setString(3, datosNuevoLider.getpApellidonLider());
            inserNlider.setString(4, datosNuevoLider.getsApellidonLider());
            inserNlider.setInt(5, datosNuevoLider.getSalarionLider());
            inserNlider.setString(6, datosNuevoLider.getCiudadnLider());
            inserNlider.setString(7, datosNuevoLider.getCargonLider());
            inserNlider.setInt(8, datosNuevoLider.getClasifinLider());
            inserNlider.setString(9, datosNuevoLider.getDocumennLider());
            inserNlider.setString(10, datosNuevoLider.getFechacumplenLider());
            res = inserNlider.executeUpdate();
            realizado = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo conectar");
            System.out.println(e);
        }

        if (realizado) {
            return res;

        } else {
            return null;
        }

    }

}
