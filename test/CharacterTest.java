import org.junit.Test;
import Character.*;

public class CharacterTest {
    @Test
    public void test() {
        Character.Character myCharacter = new Character.Character("Hero", 10, 20) {

            @Override
            public String getDetails() {
                return "";
            }
        };
    }
}
