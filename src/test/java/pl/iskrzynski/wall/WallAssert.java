package pl.iskrzynski.wall;


import java.util.List;

class WallAssert {
    static Block buildBlock(String aColor, String aMaterial) {
        return new Block() {
            private final String color = aColor;
            private final String material = aMaterial;

            @Override
            public String getColor() {
                return color;
            }

            @Override
            public String getMaterial() {
                return material;
            }
        };
    }

    static CompositeBlock buildCompositeBlock(List<Block> aBlocks) {
        return new CompositeBlock() {
            final List<Block> blocks = aBlocks;

            @Override
            public List<Block> getBlocks() {
                return blocks;
            }

            @Override
            public String getColor() {
                return null;
            }

            @Override
            public String getMaterial() {
                return null;
            }
        };
    }

}