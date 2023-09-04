public class PasswordVerifier {
    public boolean verify(String password) throws Exception {

        if (password.length() < 8) {
            throw new Exception("Пароль должен быть не менее 8 символов");
        }

        if (!password.matches(".*\\d.*")) {
            throw new Exception("Пароль должен содержать хотя бы одну цифру");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new Exception("Пароль должен содержать хотя бы одну заглавную букву");
        }

        return true;
    }

    public static void main(String[] args) {
        PasswordVerifier verifier = new PasswordVerifier();

        try {
            verifier.verify("Weak");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            verifier.verify("StrongPass123");
            System.out.println("Пароль корректен");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

