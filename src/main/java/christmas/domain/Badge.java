package christmas.domain;

public enum Badge {
    STAR("스타"),
    TREE("트리"),
    SANTA("산타"),
    NONE("없음");

    private String name;

    Badge(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
