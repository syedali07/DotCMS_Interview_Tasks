package resources;

public class Resource {
    public static int generateRandomNumber() {
        int b = (int) (Math.random() * (200 - 400 + 1) + 400);
        System.out.println(b);
        return b;
    }
}
