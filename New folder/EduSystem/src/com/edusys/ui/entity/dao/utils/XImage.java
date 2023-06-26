
package com.edusys.ui.entity.dao.utils;

import java.awt.Image;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;


public class XImage {
    public static Image getAppIcon() {
            URL url  = XImage.class.getResource("/com/edusys/ui/entity/icon/fpt.png");
            return new  ImageIcon(url).getImage();
        }
        public static boolean save(File src){
            File dst = new File("src\\main\\resources\\com\\edusys\\ui\\entity\\icon\\logo",src.getName());
            if(!dst.getParentFile().exists()){
                dst.getParentFile().mkdirs();// tạo thư mục
            }
            try {
                Path from = Paths.get(src.getAbsolutePath());
                Path to = Paths.get(dst.getAbsolutePath());
                Files.copy(from, to,StandardCopyOption.REPLACE_EXISTING);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

