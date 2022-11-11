package pl.iskrzynski.wall;


class WallAssert {
    static Block buildBlock(String aColor, String aMaterial){
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

}