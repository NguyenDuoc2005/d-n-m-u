package fpoly.duanmau.utils;

import fpoly.duanmau.entity.NhanVien;

public class Auth {
    // đối tượng này chứa thông tin người sử dụng sau khi đăng nhập

    public static NhanVien user = null;

    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static boolean isManger() {
        return Auth.isLogin() && user.isVaiTro();
    }
    
}
