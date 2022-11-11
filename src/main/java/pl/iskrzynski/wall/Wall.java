package pl.iskrzynski.wall;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class Wall implements Structure {
    private final List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return null;
    }

    @Override
    public int count() {
        return getFlatList().size();
    }

    private List<Block> getFlatList() {
        List<Block> blockList = new ArrayList<>(blocks);
        List<Block> newBlockList = new ArrayList<>();
        boolean flatTableReady;
        do {
            flatTableReady = true;
            for (Block block : blockList) {
                if (block instanceof CompositeBlock) {
                    flatTableReady = false;
                    newBlockList.addAll(((CompositeBlock) block).getBlocks());
                } else {
                    newBlockList.add(block);
                }
            }
            blockList.clear();
            blockList.addAll(newBlockList);
            newBlockList.clear();

        } while (!flatTableReady);
        return blockList;
    }
}
