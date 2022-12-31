/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahmi_listrik;

/**
 *
 * @author Hp
 */
public class fahmi_usersession {
    private static int id;
    private static String username;    
    private static String nama;
    
    
    public static int get_id(){
        return id;
    }
    
    public static void set_id(int id){
        fahmi_usersession.id = id;
    }
    
    public static String get_username(){
        return username;
    }
    
    public static void set_username(String username){
        fahmi_usersession.username = username;
    }
    
    public static String get_nama(){
        return nama;
    }
    
    public static void set_nama(String nama){
        fahmi_usersession.nama = nama;
    }
}
