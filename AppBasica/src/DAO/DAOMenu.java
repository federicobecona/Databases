package DAO;

import Conexion.PostgresSqlConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOMenu {

    PostgresSqlConexion conexion = PostgresSqlConexion.getPostgresConexion();

    public Map<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> st = null;
        try {
            conexion.conectarse();
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM vista_menu_func where id_aplicacion=?");
            ps.setString(1, conexion.getId_app());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nom_menu = rs.getString("nombre_menu");
                if (nom_menu == null) {

                    System.out.println(rs.getString("nombre_funcionalidad"));
                    continue;
                }
                st = map.getOrDefault(nom_menu, null);
                if (st == null) {
                    map.put(nom_menu, new ArrayList<>());
                    st = map.get(nom_menu);
                }
                st.add(rs.getString("nombre_funcionalidad"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

}
