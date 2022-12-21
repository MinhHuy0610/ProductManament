/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytm.daos;

import huytm.Connect.MyConnection;
import huytm.dtos.CategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author acer
 */
public class CategoryDAO {

    public static Vector<CategoryDTO> getCategories(){
        Vector<CategoryDTO> listCategory= new Vector<>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MyConnection.makeConnecton();            
            if(con != null){
                String sql = "Select categoryID, categoryName, description \n"
                        + " From TblCategories";
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();                
                while (rs.next()){
                String categoryID = rs.getString("categoryID");
                String categoryName = rs.getString("categoryName");
                String description = rs.getString("description");
                CategoryDTO ct= new CategoryDTO(categoryID, categoryName, description);
                listCategory.add(ct);
            }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
            if(pstm !=null){
                try{
                    pstm.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
            if(con!=null){
                try{
                    con.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        } return listCategory;
    }
    public static int insertCatogory(String categoryID, String categoryName, String description) throws SQLException{
        Connection con = null;
        int result=0;
        PreparedStatement pstm=null;
        try {
            con= MyConnection.makeConnecton();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String url = " Insert into TblCategories values(?,?,?)";
            pstm= con.prepareStatement(url);
            pstm.setString(1, categoryID);
            pstm.setString(2, categoryName);
            pstm.setString(3, description);       
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (pstm != null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public static int deleteCatogory(String catogoryID) throws SQLException{
        Connection con= null;
        int result=0;
        PreparedStatement pstm=null;
        try {
            con= MyConnection.makeConnecton();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            String url = "Delete from TblCategories Where categoryID = ?";
            pstm= con.prepareStatement(url);
            pstm.setString(1, catogoryID);
            result = pstm.executeUpdate();
        return result;
    }
    public static int updateCatogory(String categoryID, String categoryName, String description){
        Connection con= null;
        int result=0;
        PreparedStatement pstm= null;
        try {
            con = MyConnection.makeConnecton();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String url= "Update TblCategories  \n"
                    + " Set categoryName = ?, description= ?  \n"
                    + " Where categoryID = ?";
            pstm = con.prepareStatement(url);
            pstm.setString(1, categoryName);
            pstm.setString(2,description);
            pstm.setString(3, categoryID);
            result=pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
