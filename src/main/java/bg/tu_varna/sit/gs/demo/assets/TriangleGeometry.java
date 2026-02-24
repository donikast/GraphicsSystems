package bg.tu_varna.sit.gs.demo.assets;

import bg.tu_varna.sit.gs.mesh.Geometry;
import bg.tu_varna.sit.gs.mesh.VertexAttribute;

public class TriangleGeometry extends Geometry {
    public TriangleGeometry() {
        setData(new float[]{
                // x y z
                -0.7f, 0.3f, 0f,
                0.7f, 0.3f, 0f,
                0f, 0.6f, 0f
        });

        setAttributes(new VertexAttribute[]{
                new VertexAttribute(0, 3),
        });

        setStride(3 * Float.BYTES); // 3 for position
    }
}
