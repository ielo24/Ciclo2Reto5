package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        // Su código
        Connection coneccion = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_3Vo> list3 = new ArrayList<Requerimiento_3Vo>();
        String sql = "SELECT p.ID_Proyecto , p.Ciudad, l.Nombre FROM Proyecto p INNER join Lider l ON (l.ID_Lider=p.ID_Lider) WHERE p.ID_Proyecto <=30;";
        try (Statement stmt = coneccion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Requerimiento_3Vo requerimiento3 = new Requerimiento_3Vo();
                requerimiento3.setIdpro(rs.getInt("ID_Proyecto"));
                requerimiento3.setCiudadpro(rs.getString("Ciudad"));
                requerimiento3.setNomlider(rs.getString("Nombre"));
                list3.add(requerimiento3);

            }

        }
        return list3;

    }
}