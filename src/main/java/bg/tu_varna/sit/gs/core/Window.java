package bg.tu_varna.sit.gs.core;


import org.lwjgl.opengl.GL46;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL11.*;


public class Window {
    private final long handle;
    private final int width;
    private final int height;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;

        if (!glfwInit())
            throw new IllegalStateException("GLFW init failed");

        handle = glfwCreateWindow(width, height, title, 0, 0);

        if (handle == 0)
            throw new RuntimeException("Window creation failed");

        glfwMakeContextCurrent(handle);
        createCapabilities();
        GL46.glViewport(0, 0, width, height);
        GL46.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        glfwSwapInterval(1);
       // glEnable(GL_DEPTH_TEST);
    }

    public void update() {
        glfwSwapBuffers(handle);
        glfwPollEvents();
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(handle);
    }

    public long getHandle() {
        return handle;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void destroy() {
        glfwDestroyWindow(handle);
        glfwTerminate();
    }
}
