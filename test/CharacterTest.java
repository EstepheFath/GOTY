import org.junit.Test;
import Character.*;

public class CharacterTest {
    @Test
    public void test() {
        CharacterGame myCharacter = new CharacterGame("Hero", 10, 20, 20) {

            @Override
            public String getDetails() {
                return "";
            }
        };
    }
}
