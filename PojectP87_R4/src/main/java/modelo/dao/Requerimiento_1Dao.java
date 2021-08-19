package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        Connection coneccion = JDBCUtilities.getConnection();
        ArrayList<Requerimiento_1Vo> list1 = new ArrayList<Requerimiento_1Vo>();
        String sql = "SELECT l.ID_Lider , l.Nombre , l.Primer_Apellido ,l.Salario FROM Lider l WHERE (SELECT AVG(Salario)from Lider l) <l.Salario ORDER by l.Salario DESC; ";
        try (Statement stmt = coneccion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Requerimiento_1Vo requerimiento1 = new Requerimiento_1Vo();
                requerimiento1.setIdlider(rs.getInt("ID_Lider"));
                requerimiento1.setNombre(rs.getString("Nombre"));
                requerimiento1.setPriapellido(rs.getString("Primer_Apellido"));
                requerimiento1.setSalario(rs.getInt("Salario"));
                list1.add(requerimiento1);

            }
        }
        // System.out.println("ajajaja");
        return list1;
        // Su código
    }
}