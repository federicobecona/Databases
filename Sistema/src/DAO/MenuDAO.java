package DAO;

import Conexion.PostgresSqlConexion;
import Modelo.Funcionalidad;
import Modelo.Menu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuDAO {

    public enum Claves {
        id_menu,
        id_aplicacion,
        nombre;
    }

    PostgresSqlConexion conexion = PostgresSqlConexion.getPostgresConexion();

    public boolean insertarMenu(Menu menu) {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("INSERT INTO menu(id_menu,id_aplicacion,nombre_menu) VALUES(?,?,?)");
            pstm.setString(1, menu.getId_menu());
            pstm.setString(2, menu.getId_aplicacion());
            pstm.setString(3, menu.getNombre());
            pstm.executeUpdate();
            pstm.close();
            conexion.commit();
            conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PostgresSqlConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregarFuncionalidad(Menu menu, Funcionalidad funcionalidad) {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("INSERT INTO menu_funcionalidad(id_menu, id_aplicacion, nombre_funcionalidad) VALUES(?,?,?)");
            pstm.setString(1, menu.getId_menu());
            pstm.setString(2, menu.getId_aplicacion());
            pstm.setString(3, funcionalidad.getNombre_funcionalidad());
            pstm.executeUpdate();
            pstm.close();
            conexion.commit();

            conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PostgresSqlConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public void borrarFuncionalidad(Menu menu, Funcionalidad funcionalidad) throws SQLException {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("DELETE FROM rol_funcionalidad where id_menu = ? and id_aplicacion = ? and nombre_funcionalidad = ?");
            pstm.setString(1, menu.getId_menu());
            pstm.setString(2, menu.getId_aplicacion());
            pstm.setString(3, funcionalidad.getNombre_funcionalidad());
            pstm.executeUpdate();
            pstm.close();
            conexion.commit();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresSqlConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.desconectar();
    }

    public void borrarMenu(Menu menu) {
    }

    public ArrayList<Menu> listarMenus() {
        return buscarMenus(Claves.nombre, "");
    }

    public ArrayList<Menu> buscarMenus(MenuDAO.Claves clave, String valor) {
        conexion.conectarse();
        ArrayList<Menu> listaRes = new ArrayList<>();
        PreparedStatement pstm;
        String query = "";
        try {
            switch (clave) {
                case id_menu:
                    query = "select * from menu m JOIN vista_admin_apps vap ON vap.id_aplicacion=m.id_aplicacion where lower(id_menu) like lower(?)";
                    break;
                case nombre:
                    query = "select * from menu m JOIN vista_admin_apps vap ON vap.id_aplicacion=m.id_aplicacion where lower(nombre_menu) like lower(?)";
                    break;
                case id_aplicacion:
                    query = "select * from menu m JOIN vista_admin_apps vap ON vap.id_aplicacion=m.id_aplicacion where lower(m.id_aplicacion) like lower(?)";
                    break;
            }
            pstm = conexion.prepareStatement(query);
            pstm.setString(1, valor + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Menu p = new Menu(rs.getString("id_menu"), rs.getString("nombre_menu"), rs.getString("id_aplicacion"));
                listaRes.add(p);
            }
            rs.close();
            pstm.close();
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(AplicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRes;
    }

    public ArrayList<Funcionalidad> buscarFuncionalidades(Menu menu) {
        ArrayList<Funcionalidad> listaRes = new ArrayList<>();
        try {
            conexion.conectarse();
            
            PreparedStatement pstm = conexion.prepareStatement("select * from funcionalidad f join"
                    + " menu_funcionalidad mf on "
                    + "mf.nombre_funcionalidad=f.nombre_funcionalidad and mf.id_aplicacion=f.id_aplicacion "
                    + "where mf.id_menu = ? and mf.id_aplicacion = ?");
            pstm.setString(1, menu.getId_menu());
            pstm.setString(2, menu.getId_aplicacion());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionalidad p = new Funcionalidad(rs.getString("nombre_funcionalidad"), rs.getString("id_aplicacion"), rs.getString("descripcion"));
                listaRes.add(p);
            }
            rs.close();
            pstm.close();
            conexion.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRes;
    }
}
