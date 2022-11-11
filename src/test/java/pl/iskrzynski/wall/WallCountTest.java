package pl.iskrzynski.wall;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pl.iskrzynski.wall.WallAssert.buildBlock;

public class WallCountTest {
    Block block1 = buildBlock("blue", "wood");
    List<Block> threeElementsBlockList = List.of(block1,block1,block1);

    @Test
    void shouldReturnZero() {
        Wall wall = new Wall(new ArrayList<>());
        assertThat(wall.count()).isEqualTo(0);
    }

    @Test
    void shouldReturnThreeElements() {
        Wall wall = new Wall(threeElementsBlockList);
        assertThat(wall.count()).isEqualTo(3);
    }

}
