package bg.tu_varna.sit.gs.demo;

import bg.tu_varna.sit.gs.demo.objects.House;
import bg.tu_varna.sit.gs.scene.Scene;
import bg.tu_varna.sit.gs.scene.SceneObject;
import org.joml.Vector3f;

public class SceneBuilder {

    public static Scene build() {

        Scene scene = new Scene();
        SceneObject house = new House();
        house.getTransform().setScale(new Vector3f(0.3f, 0.3f, 1f));
        house.getTransform().rotateZ(90);
        house.getTransform().setTranslation(new Vector3f(0.5f, 0f, 0f));
        scene.addSceneObject(house);

        return scene;
    }
}
