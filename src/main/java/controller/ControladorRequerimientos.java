package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.Requerimiento_1Dao;
import model.dao.Requerimiento_2Dao;
import model.dao.Requerimiento_3Dao;
import model.vo.Requerimiento1;
import model.vo.Requerimiento2;
import model.vo.Requerimiento3;


//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientos {
    //Su codigo
    private final Requerimiento_1Dao proyectosPorEstratoDao;
    private final Requerimiento_2Dao proyectosPorTipo;
    private final Requerimiento_3Dao proyectosQuibdoApartaestudioDao;

    public ControladorRequerimientos(){
        //Su codigo
        this.proyectosPorEstratoDao = new Requerimiento_1Dao();
        this.proyectosPorTipo = new Requerimiento_2Dao();
        this.proyectosQuibdoApartaestudioDao = new Requerimiento_3Dao();
    }

    public ArrayList<Requerimiento1> consultarRequerimiento_1() throws SQLException {
        //Su codigo
        return this.proyectosPorEstratoDao.requerimiento1();
    }
    
    public ArrayList<Requerimiento2> consultarRequerimiento_2() throws SQLException {
        //Su codigo
        return this.proyectosPorTipo.requerimiento2();
    }

    public ArrayList<Requerimiento3> consultarRequerimiento_3() throws SQLException {
        //Su codigo
        return this.proyectosQuibdoApartaestudioDao.requerimiento3();
    }

}
