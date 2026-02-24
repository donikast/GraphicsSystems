package bg.tu_varna.sit.gs.demo.objects;

import bg.tu_varna.sit.gs.demo.assets.RectangleGeometry;
import bg.tu_varna.sit.gs.demo.assets.TriangleGeometry;
import bg.tu_varna.sit.gs.model.ModelElement;
import bg.tu_varna.sit.gs.mesh.DrawMode;
import bg.tu_varna.sit.gs.mesh.Mesh;
import bg.tu_varna.sit.gs.scene.SceneObject;

public class House extends SceneObject {

    public House() {
        Mesh mesh = new Mesh(DrawMode.TRIANGLES, new RectangleGeometry());

        ModelElement rectangle = new ModelElement(mesh);
        getModel().addElement(rectangle);

        Mesh mesh2 = new Mesh(DrawMode.TRIANGLES, new TriangleGeometry());

        ModelElement triangle = new ModelElement(mesh2);
        getModel().addElement(triangle);
    }

    @Override
    public void update() {
    }
}
