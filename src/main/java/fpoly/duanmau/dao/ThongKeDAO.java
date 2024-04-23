/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.duanmau.dao;

import fpoly.duanmau.utils.JdbcHelper;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen duoc
 */
public class ThongKeDAO {
    // getlistOfArray phuc vu cho ham public
    private List<Object[]>  getlistOfArray(String sql,String[] cols,Object...args){
        try {
            List<Object[]> list = new ArrayList<>(); 
            ResultSet rs = JdbcHelper.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length]; 
                for(int i = 0; i<cols.length; i++){
                    vals[i] = rs.getObject(cols[i]); 
                }   
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list; 
            
        } catch (Exception e) {
            throw new RuntimeException();
        }
}
    public List<Object[]> getBangDiem(Integer makh){
        String sql = "{CALL sp_BangDiem(?)}";
        String[] cols = {"MaNH","HoTen","Diem"};
        return getlistOfArray(sql, cols, makh);
    }
    public List<Object[]> getLuongNguoiHoc(){
        String sql = "{CALL sp_ThongKeNguoiHoc}";
        String[] cols = {"Nam","SoLuong","DauTien","CuoiCung"};
        return getlistOfArray(sql, cols);
    }
    public List<Object[]> getDiemChuyenDe(){
        String sql = "{CALL sp_ThongKeDiem}";
        String[] cols = {"ChuyenDe","SoHV","ThapNhat","CaoNhat","TrungBinh"};
        return getlistOfArray(sql, cols);
    }
    public List<Object[]> getDoanhThu(Integer nam){
        String sql = "{CALL sp_ThongKeDoanhThu(?)}";
        String[] cols = {"ChuyenDe","SoHV","DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return getlistOfArray(sql, cols,nam);
    }
    
}
    
    

