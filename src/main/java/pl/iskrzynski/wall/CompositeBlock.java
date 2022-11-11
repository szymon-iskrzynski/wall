package pl.iskrzynski.wall;

import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
