package pl.iskrzynski.wall;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pl.iskrzynski.wall.WallAssert.buildBlock;

public class WallFindBlockByMaterialTest {

    Wall emptyWall = new Wall(new ArrayList<>());
    List<Block> emptyList = new ArrayList<>();

    @Test
    void shouldReturnEmptyListFromEmptyWall() {
        assertThat(emptyWall.findBlocksByMaterial("wood")).isEqualTo(emptyList);
        assertThat(emptyWall.findBlocksByMaterial("steel")).isEqualTo(emptyList);
    }
}
