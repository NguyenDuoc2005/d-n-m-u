/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.duanmau.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen duoc
 */
public class MsgBox {
    // hien thi thong bao cho nguoi dung 
    // parent là cửa sổ chứa thông báo 
    // message là thông báo
    public static void alert(Component parent , String message ){
        JOptionPane.showMessageDialog(parent,message,"Hệ thống quản lý đào tạo",
                JOptionPane.INFORMATION_MESSAGE);
    }
    // hien thi thong bao va yeu cau nguoi dung xac nhan
    // parent là cửa sổ chứa thông báo 
    // massage là câu trả lời yes / no 
    // return là kết quả nhận được tru  false 
    public static boolean confirm(Component parent , String message){
        int result = JOptionPane.showConfirmDialog(parent, message,
                "Hệ thống quản lý đào tạo",JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return  result == JOptionPane.YES_OPTION;  
    }
    // hien thi thong bao yeu cau nhap du lieu 
    //parent là cửa sổ chứa thông báo 
    //massage là thông báo nhắc nhở nhập 
    // return là kết quả nhập được từ người sử dụng nhập vào 
    public static String prompt(Component parent , String message){
        return JOptionPane.showInputDialog(parent,message,
                "Hệ thống quản lý đào tạo ",JOptionPane.INFORMATION_MESSAGE);
    }
}
