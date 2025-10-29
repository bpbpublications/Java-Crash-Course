public class TinyBuilding2 {
    private String name;

    public TinyBuilding2(String name) {
        this.name = name;
        System.out.println(name + " is constructed.");
    }

    public void useBuilding() {
        System.out.println(name + " is in use.");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " is demolished.");
    }
}