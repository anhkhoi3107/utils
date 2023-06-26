
package com.edusys.ui.entity.dao.utils;

import com.edusys.ui.entity.NhanVien;

/**
 *
 * 
 */
public class Auth {
    /**
 *đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
 * 
 */
   public static NhanVien user = null; 
        /**
 *xóa thông tin của người sử dụng khi có yêu cầu đăng xuất  
 * 
 */
   public static void clear(){
       Auth.user = null;
   }
        /**
// kiểm tra đăng nhập hay chưa *
*  @return đăng nhập hay chưa
 */
   public static boolean isLogin(){
       return Auth.user != null;
   }
   public static boolean isManger(){
       return Auth.isLogin() && user.isVaiTro();
   }
    
    
}
