/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.dto.ItemDto;
import edu.ijse.mvc.model.ItemModel;
import java.util.ArrayList;

/**
 *
 * @author Anjana
 */
public class ItemController {
    
    private ItemModel itemModel = new ItemModel();
    
    public String saveItem(ItemDto itemDto) throws Exception{
        return itemModel.saveItem(itemDto);
    }
    
    public String updateItem(ItemDto itemDto) throws Exception{
        return itemModel.updateItem(itemDto);
    }
    
    public String deteleItem(String code) throws Exception{
        return itemModel.deleteItem(code);
    }
    
    public ArrayList<ItemDto> getAll() throws Exception{
        return itemModel.getAll();
    }
    
    public ItemDto searchItem(String code) throws Exception{
        return itemModel.search(code);
    }
    
}
