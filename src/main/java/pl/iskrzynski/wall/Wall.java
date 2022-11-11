package pl.iskrzynski.wall;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class Wall implements Structure {
    private final List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String aColor) {
        List<Block> blockList = new ArrayList<>(getFlatList());
        for (Block block : blockList) {
            if (aColor.equals(block.getColor())) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String aMaterial) {
        List<Block> blockList = new ArrayList<>(getFlatList());
        List<Block> returnList = new ArrayList<>();
        for (Block block : blockList) {
            if(block.getMaterial().equals(aMaterial)){
                returnList.add(block);
            }
        }
        return returnList;
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
