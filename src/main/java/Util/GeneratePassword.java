package Util;

import org.mindrot.jbcrypt.BCrypt;

public class GeneratePassword {
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    // Kiểm tra mật khẩu
    public static boolean checkPassword(String rawPassword, String hashedPassword) {
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }
}
