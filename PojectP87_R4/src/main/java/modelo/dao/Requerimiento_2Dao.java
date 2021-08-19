package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        Connection coneccion = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_2Vo> list2 = new ArrayList<Requerimiento_2Vo>();
        String sql = "SELECT p.ID_Proyecto ,mc.Nombre_Material FROM Proyecto p JOIN Compra c ON (p.ID_Proyecto=c.ID_Proyecto) JOIN MaterialConstruccion mc ON(mc.ID_MaterialConstruccion=c.ID_MaterialConstruccion) WHERE c.ID_Proyecto IN (12,15,18) ORDER BY c.ID_Proyecto DESC;";
        try (Statement stmt = coneccion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Requerimiento_2Vo requerimiento2 = new Requerimiento_2Vo();
                requerimiento2.setIdpro(rs.getInt("ID_Proyecto"));
                requerimiento2.setNommat(rs.getString("Nombre_Material"));
                list2.add(requerimiento2);

            }
        }
        // Su código
        return list2;
    }
}