package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

//import javax.swing.WindowConstants;

import modelo.dao.Nuevo_Lider_Dao;
import modelo.dao.REquerimiento_IDMAXDao;
import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.dao.Requerimiento_3Dao;
import modelo.vo.Nuevo_lider_Vo;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;
import modelo.vo.Requerimiento_IDMAXVo;
import vista.NewLider;
import vista.datosGRa;

public class ControladorRequerimientos {
    // Su código
    private Requerimiento_1Dao requerimiento_1dao;
    private Requerimiento_2Dao requerimiento_2dao;
    private Requerimiento_3Dao requerimiento_3dao;
    private REquerimiento_IDMAXDao requerimiento_IDMAXdao;
    private NewLider nuevaventana;
    private Nuevo_Lider_Dao nuevolider_dao;

    public ControladorRequerimientos() {
        this.requerimiento_1dao = new Requerimiento_1Dao();
        this.requerimiento_2dao = new Requerimiento_2Dao();
        this.requerimiento_3dao = new Requerimiento_3Dao();
        this.requerimiento_IDMAXdao = new REquerimiento_IDMAXDao();
        this.nuevolider_dao = new Nuevo_Lider_Dao();

    }

    public void mostrarnewlider() throws SQLException {
        nuevaventana = new NewLider();
        nuevaventana.setVisible(true);

    }
    // nuevaventana.setVisible(true);

    public ArrayList<Requerimiento_1Vo> consultarRequerimiento1() throws SQLException {
        // Su código
        // System.out.println("ahora si estamos aca");
        return this.requerimiento_1dao.requerimiento1();

    }

    public ArrayList<Requerimiento_2Vo> consultarRequerimiento2() throws SQLException {
        // Su código
        return this.requerimiento_2dao.requerimiento2();
    }

    public ArrayList<Requerimiento_3Vo> consultarRequerimiento3() throws SQLException {
        // Su código
        return this.requerimiento_3dao.requerimiento3();
    }

    public Requerimiento_IDMAXVo consultaMaxID() throws SQLException {
        // System.out.println("yayayaya");
        return this.requerimiento_IDMAXdao.Req_IDMAX();
    }

    public void mostrarVentanaPrincipal() {
        datosGRa vPrincipal = new datosGRa();
        vPrincipal.setVisible(true);
    }

    public Integer insertar_nuevo_lider(Nuevo_lider_Vo datosNuevoLider) throws SQLException {
        return this.nuevolider_dao.Insert_nuevo_lider(datosNuevoLider);
    }
}
