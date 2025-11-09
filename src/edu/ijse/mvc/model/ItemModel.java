/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.ItemDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Anjana
 */
public class ItemModel {
    public String saveItem(ItemDto dto) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO item VALUES(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getCode());
        statement.setString(2, dto.getDesc());
        statement.setString(3, dto.getPack());
        statement.setDouble(4, dto.getPrice());
        statement.setInt(5, dto.getQoh());

        return statement.executeUpdate() > 0 ? "Success" : "Fail";

    }
    
    public String updateItem(ItemDto dto) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE item SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getDesc());
        statement.setString(2, dto.getPack());
        statement.setDouble(3, dto.getPrice());
        statement.setInt(4, dto.getQoh());
        statement.setString(5, dto.getCode());

        return statement.executeUpdate() > 0 ? "Success" : "Fail";

    }
    
    public String deleteItem(String code) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, code);

        return statement.executeUpdate() > 0 ? "Success" : "Fail";
    }
    
    public ArrayList<ItemDto> getAll() throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        while (rst.next()) {            
            ItemDto itemDto = new ItemDto(rst.getString("ItemCode"),
                    rst.getString("Description"), 
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"), rst.getInt("QtyOnHand"));
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
    
    public ItemDto search(String code) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, code);
        ResultSet rst = statement.executeQuery();
        
        if(rst.next()){
            ItemDto itemDto = new ItemDto(rst.getString("ItemCode"),
                    rst.getString("Description"), 
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"), rst.getInt("QtyOnHand"));
            return itemDto;
        }
        return null;
    }
}
