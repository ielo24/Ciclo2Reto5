package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import modelo.vo.Requerimiento_IDMAXVo;
import util.JDBCUtilities;

public class REquerimiento_IDMAXDao {
    // private Integer IDMAX;

    public Requerimiento_IDMAXVo Req_IDMAX() throws SQLException {
        // System.out.println("vamos aca 2");
        Connection coneccion = JDBCUtilities.getConnection();
        Requerimiento_IDMAXVo idmax = new Requerimiento_IDMAXVo();
        String sql = "SELECT MAX(l.ID_Lider) FROM Lider l;";
        // System.out.println("vamos aca");
        try (Statement stmt = coneccion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            Requerimiento_IDMAXVo IDMAX = new Requerimiento_IDMAXVo();
            IDMAX.setMaxID(rs.getInt("MAX(l.ID_Lider)"));
            idmax = IDMAX;
        }
        return idmax;

    }

}
