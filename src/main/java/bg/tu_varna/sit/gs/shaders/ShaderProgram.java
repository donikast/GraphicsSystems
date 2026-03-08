package bg.tu_varna.sit.gs.shaders;

import static org.lwjgl.opengl.GL20.*;

public class ShaderProgram {

    private final int programId;

    public ShaderProgram(String vertexSource, String fragmentSource) {

        int vertexId = compileShader(vertexSource, GL_VERTEX_SHADER);
        int fragmentId = compileShader(fragmentSource, GL_FRAGMENT_SHADER);

        programId = glCreateProgram();
        glAttachShader(programId, vertexId);
        glAttachShader(programId, fragmentId);
        glLinkProgram(programId);

        if (glGetProgrami(programId, GL_LINK_STATUS) == 0) {
            throw new RuntimeException("Shader linking failed:\n" +
                    glGetProgramInfoLog(programId));
        }

        glDeleteShader(vertexId);
        glDeleteShader(fragmentId);
    }

    private int compileShader(String source, int type) {
        int id = glCreateShader(type);
        glShaderSource(id, source);
        glCompileShader(id);

        if (glGetShaderi(id, GL_COMPILE_STATUS) == 0) {
            throw new RuntimeException("Shader compile failed:\n" +
                    glGetShaderInfoLog(id));
        }
        return id;
    }

    public void use() {
        glUseProgram(programId);
    }

    public void unbind() {
        glUseProgram(0);
    }

    public void cleanup() {
        glDeleteProgram(programId);
    }
}
