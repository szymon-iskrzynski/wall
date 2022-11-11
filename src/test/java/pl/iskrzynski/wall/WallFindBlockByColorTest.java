package pl.iskrzynski.wall;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pl.iskrzynski.wall.WallAssert.buildBlock;
import static pl.iskrzynski.wall.WallAssert.buildCompositeBlock;

public class WallFindBlockByColorTest {
    Block block1 = buildBlock("blue", "wood");
    Block block2 = buildBlock("green", "wood");
    Block block3 = buildBlock("blue", "steel");
    Block block4 = buildBlock("green", "steel");
    Block block5 = buildBlock("black", "concrete");

    List<Block> blockList = List.of(block1,block2,block3,block4);
    CompositeBlock compositeBlock = buildCompositeBlock(blockList);
    List<Block> nestedBlockList = List.of(compositeBlock,block5);
    Wall emptyWall = new Wall(new ArrayList<>());
    Wall noEmptyWall = new Wall(nestedBlockList);
    Optional<Block> emptyOptionalList = Optional.empty();

    @Test
    void shouldReturnOptionalEmpty() {
        assertThat(emptyWall.findBlockByColor("blue")).isEqualTo(emptyOptionalList);
        assertThat(noEmptyWall.findBlockByColor("red")).isEqualTo(emptyOptionalList);
       }
    @Test
    void shouldReturnOptionalBlock() {
        assertThat((noEmptyWall.findBlockByColor("blue"))).isEqualTo(Optional.of(block1));
        assertThat((noEmptyWall.findBlockByColor("green"))).isEqualTo(Optional.of(block2));
    }
}
