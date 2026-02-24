package bg.tu_varna.sit.gs.mesh;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Mesh {
    private final int vao;
    private final VertexBuffer vbo;
    private final int vertexCount;
    private final DrawMode drawMode;

    public Mesh(DrawMode drawMode, Geometry geometry) {
        this.drawMode = drawMode;

        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = new VertexBuffer(geometry.getData());
        vbo.bind();

        int stride = geometry.getStride();

        int offset = 0;

        for (VertexAttribute attr : geometry.getAttributes()) {

            glVertexAttribPointer(
                    attr.location(),
                    attr.componentSize(),
                    GL_FLOAT,
                    false,
                    stride,
                    (long) offset * Float.BYTES
            );

            glEnableVertexAttribArray(attr.location());

            offset += attr.componentSize();
        }

        vertexCount = geometry.getVertexCount();

        glBindVertexArray(0);
    }

    public void render() {
        glBindVertexArray(vao);
        glDrawArrays(drawMode.getGlMode(), 0, vertexCount);
        glBindVertexArray(0);
    }
}
