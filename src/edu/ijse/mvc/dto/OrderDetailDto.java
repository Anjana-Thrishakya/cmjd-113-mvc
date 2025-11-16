/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.dto;

/**
 *
 * @author Anjana
 */
public class OrderDetailDto {
    
    private String itemCode;
    private int qty;
    private int dicount;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String itemCode, int qty, int dicount) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.dicount = dicount;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the dicount
     */
    public int getDicount() {
        return dicount;
    }

    /**
     * @param dicount the dicount to set
     */
    public void setDicount(int dicount) {
        this.dicount = dicount;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" + "itemCode=" + itemCode + ", qty=" + qty + ", dicount=" + dicount + '}';
    }
    
    
    
}
