import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    @Test
    void testMissingMandatoryFields() {
        User userWithoutName = new User(null, "teste@teste.com", "teste", "teste");
        User userWithoutEmail = new User("teste", null, "teste", "teste");

        String resultNameValidation = validateUser(userWithoutName);
        String resultEmailValidation = validateUser(userWithoutEmail);

        assertEquals("Error: Name is mandatory", resultNameValidation);
        assertEquals("Error: Email is mandatory", resultEmailValidation);
    }

    private String validateUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            return "Error: Name is mandatory";
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return "Error: Email is mandatory";
        }
        return "Success";
    }

    static class User {
        private String name;
        private String email;
        private String address;
        private String phone;

        public User(String name, String email, String address, String phone) {
            this.name = name;
            this.email = email;
            this.address = address;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }
}
