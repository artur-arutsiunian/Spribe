import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

    public class APITest extends TestRunner {

        private static final RestService REST_SERVICE1 = new RestService();

        @Test
        public void checkGetUsers(){
            Assertions.assertEquals("male", REST_SERVICE1.getUsers().getPlayers().get(0).getGender(), "Quantity of users aren't correct");
        }

        @Test
        public void checkGetOneUser(){
            Assertions.assertEquals("supervisor", REST_SERVICE1.getUserById(1).getLogin(), "'Login' isn't correct");
        }

        @Test
        public void checkCreateUser(){
            Assertions.assertEquals("test126", REST_SERVICE1.createUser().getLogin(), "User with such login isn't created");
        }

        @Test
        public void checkUserIsNotCreated() {
            Assertions.assertEquals(400, REST_SERVICE1.createUserWithWrongAge(), "Status code isn't correct");
        }

        @Test
        public void checkEditUser(){
            Assertions.assertEquals("female", REST_SERVICE1.editUser("female").getGender(), "Gender isn't correct");
        }

        @Test
        public void checkDeleteUser(){
            Assertions.assertEquals(204, REST_SERVICE1.deleteUser(1483982699), "User isn't deleted");
        }
}
