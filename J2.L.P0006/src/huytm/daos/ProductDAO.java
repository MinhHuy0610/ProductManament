/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytm.daos;


import huytm.Connect.MyConnection;
import huytm.dtos.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class ProductDAO {
    public static Vector<ProductDTO> getProduct(){
        Connection cn=null;
        PreparedStatement pstm=null;
        ResultSet result=null;
        Vector<ProductDTO> listProduct= new Vector<>();
        try {
            cn = MyConnection.makeConnecton();
            if(cn!=null){
                try{
                    String sql=" Select productID, productName, unit, price, quantity, categoryid " 
                            +" from TblProducts ";
                    pstm = cn.prepareStatement(sql);
                    result = pstm.executeQuery();
                    while(result.next()){
                        String productID = result.getString("productID");
                        String productName = result.getString("productName");
                        String unit= result.getString("unit");
                        float price= result.getFloat("price");
                        int quantity= result.getInt("quantity");
                        String categoryid= result.getString("categoryid");
                        
                        ProductDTO product = new ProductDTO(productID, productName, unit, price, quantity, categoryid) ;
                        listProduct.add(product);
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        
        
    }   catch (SQLException ex) {   
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProduct;
    }
    public static int insertProduct(String productID,String productName,String unit
            , float price, int quantity, String categoryid) throws SQLException {
        Connection con=null;
        PreparedStatement pstm =null;
        int result= 0;
        try{
            con = MyConnection.makeConnecton();
            
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        try{
            String sql = " Insert into TblProducts values (?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, productID);
            pstm.setString(2, productName);
            pstm.setString(3, unit);
            pstm.setFloat(4, price);
            pstm.setInt(5, quantity );
            pstm.setString(6, categoryid);
            result = pstm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }                    
        return result;
    }
    public static int deleteProduct(String productID){
        Connection con = null;
        PreparedStatement pstm=null;
        int result= 0;
        try{
            con = MyConnection.makeConnecton();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        try {
            String sql= "Delete from TblProducts where productID = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, productID);
            result = pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public static int updateProduct(String productID,String productName,String unit,
            float price, int quantity, String categoryid) throws SQLException{
        Connection con = null;
        PreparedStatement pstm= null;
        int result = 0;
        try{
            con = MyConnection.makeConnecton();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
            String sql = "Update TblProducts "
                + " set productName= ? , unit= ?, price = ?, quantity = ?, categoryid = ? "
                + " where productID = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, productName);
            pstm.setString(2, unit);
            pstm.setFloat(3, price);
            pstm.setInt(4, quantity);
            pstm.setString(5, categoryid);
            pstm.setString(6, productID);
            result = pstm.executeUpdate();
            
            if(pstm!=null){
                pstm.close();
            }
            if(con!=null){
                con.close();
            }        
        return result;
    }
}
