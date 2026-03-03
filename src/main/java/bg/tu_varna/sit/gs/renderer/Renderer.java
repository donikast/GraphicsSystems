package bg.tu_varna.sit.gs.renderer;

import bg.tu_varna.sit.gs.scene.Scene;

public interface Renderer {
    void init();

    void clear();

    void render(Scene scene);

    void cleanup();
}
