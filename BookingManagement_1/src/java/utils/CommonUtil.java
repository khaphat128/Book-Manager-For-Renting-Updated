/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Administrator
 */
public class CommonUtil {
    
     
     public static int toInt(String number){
         try {
             int out=Integer.parseInt(number);
             return out;
         } catch (NumberFormatException e) {
             return 0;
         }
     }
}
