/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytm.daos;

import huytm.dtos.UserDTO;
import huytm.Connect.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class UserDAO {
    public static UserDTO checkLoginUsers(String userID, String password) throws SQLException {
        Connection cn = null;
        try {
            cn = MyConnection.makeConnecton();
            if (cn != null) {
                String sql = "select userID, password\n"
                        + "from TblUsers \n"
                        + "where userID like ? and password like ?  ";
                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setString(1, userID);
                pstm.setString(2, password);

                ResultSet rs = pstm.executeQuery();

                if (rs.next()) {
                        UserDTO acc= new UserDTO(rs.getString("userID"), rs.getString("password"));
                    return acc;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (cn != null) {
                cn.close();
            }
        }

        return null;
    }
    
    public static List<String> getUserId() {
        Connection cn = null;
        List<String> listUserID = new ArrayList<>();
        try {
            cn = MyConnection.makeConnecton();
            String sql = "Select userID\n"
                    + "from tblUsers";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                String userID = result.getString("userID");
                listUserID.add(userID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listUserID;
    }
}
