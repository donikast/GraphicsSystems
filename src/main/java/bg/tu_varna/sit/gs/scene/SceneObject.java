package bg.tu_varna.sit.gs.scene;

import bg.tu_varna.sit.gs.model.Model;
import bg.tu_varna.sit.gs.shaders.ShaderProgram;

public abstract class SceneObject {
    private final Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void render(ShaderProgram shader) {
        model.render(shader);
    }

    public void update(){}
}
