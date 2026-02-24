package bg.tu_varna.sit.gs.utils;

public class ResourceLoader {
    public String loadResource(String path) {
        try (var is = getClass().getClassLoader().getResourceAsStream(path)) {
            assert is != null;
            return new String(is.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException("Cannot load resource: " + path);
        }
    }
}
