package randomorbit.test

public enum BuildEnum {

    SKINNY('skinny'),
    AVERAGE('average'),
    FAT('fat')

    String name

    BuildEnum(String name) {
        this.name = name
    }
}
