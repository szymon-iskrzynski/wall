package pl.iskrzynski.wall;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WallCountTest {
    @Test
    void shouldReturnZero() {
        Wall wall = new Wall(new ArrayList<>());
        assertThat(wall.count()).isEqualTo(0);
    }

}
