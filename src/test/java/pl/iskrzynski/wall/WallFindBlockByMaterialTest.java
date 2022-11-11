package pl.iskrzynski.wall;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pl.iskrzynski.wall.WallAssert.buildBlock;

public class WallFindBlockByMaterialTest {

    Block block1 = buildBlock("blue", "wood");
    Block block2 = buildBlock("green", "wood");
    Block block3 = buildBlock("blue", "steel");
    Block block4 = buildBlock("green", "steel");
    List<Block> blockList = List.of(block1,block2,block3,block4);
    List<Block> woodBlockList = List.of(block1,block2);
    List<Block> steelBlockList = List.of(block3,block4);
    Wall emptyWall = new Wall(new ArrayList<>());
    List<Block> emptyList = new ArrayList<>();
    Wall noEmptyWall = new Wall(blockList);

    @Test
    void shouldReturnEmptyListFromEmptyWall() {
        assertThat(emptyWall.findBlocksByMaterial("wood")).isEqualTo(emptyList);
        assertThat(emptyWall.findBlocksByMaterial("steel")).isEqualTo(emptyList);
    }

    @Test
    void shouldReturnEmptyListMaterialNoExistInWall() {
        assertThat(noEmptyWall.findBlocksByMaterial("plastic")).isEqualTo(emptyList);
    }

    @Test
    void shouldReturnMaterialList() {
        assertThat(noEmptyWall.findBlocksByMaterial("steel").size()).isEqualTo(steelBlockList.size());
        assertThat(noEmptyWall.findBlocksByMaterial("steel").get(0)).isIn(steelBlockList);
        assertThat(noEmptyWall.findBlocksByMaterial("steel").get(1)).isIn(steelBlockList);

        assertThat(noEmptyWall.findBlocksByMaterial("wood").size()).isEqualTo(woodBlockList.size());
        assertThat(noEmptyWall.findBlocksByMaterial("wood").get(0)).isIn(woodBlockList);
        assertThat(noEmptyWall.findBlocksByMaterial("wood").get(1)).isIn(woodBlockList);
    }
}
