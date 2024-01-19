package com.fssa.greenfarm.DAO;

import com.fssa.greenfarm.exception.DAOException;
import com.fssa.greenfarm.model.CartItems;
import com.fssa.greenfarm.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllCheckOutDAO {


    String sql = "SELECT cart_id,user_id,product_id,totalprice,quantity,status FROM CartItems WHERE user_id = ? AND cart_id = ?;";

    public CartItems getOneProducts(int id, int userId) throws DAOException{

        CartItems cart = null;

        try (Connection connection = ConnectionUtil.getConnection()) {

            try (PreparedStatement psmt = connection.prepareStatement(sql)) {
                psmt.setInt(1, userId);
                psmt.setInt(2,id);
                try (ResultSet rs = psmt.executeQuery()) {
                    if (rs.next()) {
                        cart = new CartItems();
                        cart.setCart_id(rs.getInt("cart_id"));
                        cart.setProduct_id(rs.getInt("product_id"));
                        cart.setUser_id(rs.getInt("user_id"));
                        cart.setTotalprice(rs.getFloat("totalprice"));
                        cart.setQuantity(rs.getFloat("quantity"));
                        cart.setStatus(rs.getBoolean("status"));
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
         throw new DAOException(e.getMessage());
        }
        return cart;
    }


    public List<CartItems> getOneProducts(List<Integer> ids,int userId) throws DAOException {

        List<CartItems> items = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()) {

            for(int nums : ids) {
                try (PreparedStatement psmt = connection.prepareStatement(sql)) {
                    psmt.setInt(1, userId);
                    psmt.setInt(2, nums);
                    try (ResultSet rs = psmt.executeQuery()) {
                        if (rs.next()) {
                            CartItems cart = new CartItems();
                            cart.setCart_id(rs.getInt("cart_id"));
                            cart.setProduct_id(rs.getInt("product_id"));
                            cart.setUser_id(rs.getInt("user_id"));
                            cart.setTotalprice(rs.getFloat("totalprice"));
                            cart.setQuantity(rs.getFloat("quantity"));
                            cart.setStatus(rs.getBoolean("status"));
                            items.add(cart);
                        }
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        }

        return items;
    }
}
