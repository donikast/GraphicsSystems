package bg.tu_varna.sit.gs.app;

import bg.tu_varna.sit.gs.core.Engine;
import bg.tu_varna.sit.gs.core.Window;
import bg.tu_varna.sit.gs.demo.SceneBuilder;
import bg.tu_varna.sit.gs.renderer.OpenGLRenderer;
import bg.tu_varna.sit.gs.renderer.Renderer;
import bg.tu_varna.sit.gs.scene.Scene;

public class App extends Engine {
    private final int width, height;
    private final String title;

    private Renderer renderer;
    private Scene scene;

    public App(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    @Override
    protected void init() {
        setWindow(new Window(width, height, title));

        scene = SceneBuilder.build();

        renderer = new OpenGLRenderer();
        renderer.init();
    }

    @Override
    protected void update() {
        scene.update();
    }

    @Override
    protected void render() {
        renderer.clear();
        renderer.render(scene);
    }

    @Override
    protected void cleanup() {
        renderer.cleanup();
        getWindow().destroy();
    }
}
