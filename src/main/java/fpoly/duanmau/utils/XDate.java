/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.duanmau.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nguyen duoc
 */
public class XDate {
    static SimpleDateFormat  formater = new SimpleDateFormat(); 
    // Chuyển đổi String sang date
    // date là string cần chuyển 
    // pattern là định dạng thời gian
    // Date là kết quả
    public static Date toDate(String date, String pattern){
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(); 
        }
    }
    
    // chuyển đổi từ date sang string 
    // date là Date cần chuyển 
    // pattern là định dạng thời gian
    // return String ketqua
    public static String toString(Date date, String pattern){
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    public static Date now(){
        return new Date();
    }
    // Bổ xung số ngày vào thời gian 
    // date thời gian hiện có 
    // days số ngày cần bổ sung vào date
    // return Date kết quả
    public static Date addDays(Date date , long days){
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date; 
    }
    
    
}
