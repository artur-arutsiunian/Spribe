import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

//@Execution(ExecutionMode.CONCURRENT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

    public class APITest extends TestRunner {

        private static final RestService REST_SERVICE1 = new RestService();

        @Order(1)
        @Test
        public void checkGetUsers(){
            Assertions.assertEquals("male", REST_SERVICE1.getUsers().getPlayers().get(0).getGender(), "Quantity of users aren't correct");
        }

        @Order(2)
        @Test
        public void checkGetOneUser(){
            Assertions.assertEquals("supervisor", REST_SERVICE1.getUserById(1).getLogin(), "'Login' isn't correct");
        }

        @Order(3)
        @Test
        public void checkCreateUser(){
            Assertions.assertEquals("test126", REST_SERVICE1.createUser().getLogin(), "User with such login isn't created");
        }

        @Order(4)
        @Test
        public void checkUserIsNotCreated() {
            Assertions.assertEquals(400, REST_SERVICE1.createUserWithWrongAge(), "Status code isn't correct");
        }

        @Order(5)
        @Test
        public void checkEditUser(){
            Assertions.assertEquals("male", REST_SERVICE1.editUser("male").getGender(), "Gender isn't correct");
        }

        @Order(6)
        @Test
        public void checkDeleteUser(){
        Assertions.assertEquals(204, REST_SERVICE1.deleteUser(2), "User isn't deleted");
    }


}
