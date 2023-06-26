/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.ulils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class XImage {
    public static Image getAppIcon(){
        URL url = XImage.class.getResource("/com/edusys/icon/fpt.png");
        return new ImageIcon(url).getImage();
    }
    
    // Hàm Lưu
    public static boolean save(File src){
        File dst = new File("src\\com\\edusys\\icon",src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();//tao thư mục
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
