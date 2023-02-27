import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.glfw.GLFW.*;


public class Main {

    private Window window = new Window(800, 800, "Hello World");

    private ArrayList<Object2d> objects = new ArrayList<>();
    private ArrayList<Object2d> objectsRectangle = new ArrayList<>();
    private List<Vector3f> circle = new ArrayList<>();
    private ArrayList<Rectangle> stars = new ArrayList<>();
    MouseInput mouseInput;
    private ArrayList<Object2d> objectsPointsControl = new ArrayList<>();

    public void init() {
        window.init();
        GL.createCapabilities();

        // code
        /*objects.add(new Object2d(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f)
                        )
                ),

                new Vector4f(0.0f,1.0f,0.0f,0.0f)
        ));
    }*/
        //rumput
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-1.0f, -1.0f, 0.0f),
                                new Vector3f(1.0f, -1.0f, 0.0f),
                                new Vector3f(-1.0f, -0.45f, 0.0f),
                                new Vector3f(1.0f, -0.45f, 0.0f)
                        )
                ),
                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));
        //atap belakang
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.55f, 0.2f, 0.0f),
                                new Vector3f(0.55f, 0.2f, 0.0f),
                                new Vector3f(-0.8f, -0.2f, 0.0f),
                                new Vector3f(0.8f, -0.2f, 0.0f)
                        )
                ),
                new Vector4f(0.6f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));
        //badan rumah
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.65f, -0.1f, 0.0f),
                                new Vector3f(0.65f, -0.1f, 0.0f),
                                new Vector3f(-0.65f, -0.6f, 0.0f),
                                new Vector3f(0.65f, -0.6f, 0.0f)
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));
        //badan rumah atap
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.53f, 0.15f, 0.0f),
                                new Vector3f(0.53f, 0.15f, 0.0f),
                                new Vector3f(-0.65f, -0.1f, 0.0f),
                                new Vector3f(0.65f, -0.1f, 0.0f)
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));
        //atap depan
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.55f, 0.2f, 0.0f),
                                new Vector3f(0.55f, 0.2f, 0.0f),
                                new Vector3f(-0.45f, -0.2f, 0.0f),
                                new Vector3f(0.8f, -0.2f, 0.0f)
                        )
                ),
                new Vector4f(0.6f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));
        //cerobong asap badan
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.35f, 0.1f, 0.0f),
                                new Vector3f(0.40f, 0.1f, 0.0f),
                                new Vector3f(0.35f, 0.3f, 0.0f),
                                new Vector3f(0.40f, 0.3f, 0.0f)
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));
        //cerobong asap kepala
        objectsRectangle.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.3f, 0.3f, 0.0f),
                                new Vector3f(0.45f, 0.3f, 0.0f),
                                new Vector3f(0.3f, 0.35f, 0.0f),
                                new Vector3f(0.45f, 0.35f, 0.0f)
                        )
                ),
                new Vector4f(0.7f, 0f, 0.0f, 0.0f),
                Arrays.asList(0, 1, 2, 1, 2, 3)
        ));
        //asap
        circle = createCircle(0.4f, 0.45f, .0875f, .05f, 1);
        objects.add(new Object2d(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                circle,
                new Vector4f(0.67f, 0.67f, 0.67f, 1)
        ));
        circle = createCircle(0.45f, 0.5f, .0875f, .05f, 1);
        objects.add(new Object2d(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                circle,
                new Vector4f(0.67f, 0.67f, 0.67f, 1)
        ));
        circle = createCircle(0.5f, 0.55f, .0875f, .05f, 1);
        objects.add(new Object2d(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                circle,
                new Vector4f(0.67f, 0.67f, 0.67f, 1)
        ));
        //bintang
        circle = createCircle(.5f, .8f, .05f, .05f, 72);
        stars.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                circle,
                new Vector4f(1, 1, 1, 1),
                Arrays.asList(0, 2, 4, 1, 3)
        ));
        circle = createCircle(-.4f, .5f, .05f, .05f, 72);
        stars.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                circle,
                new Vector4f(1, 1, 1, 1),
                Arrays.asList(0, 2, 4, 1, 3)
        ));
        circle = createCircle(-.1f, .8f, .02f, .02f, 72);
        stars.add(new Rectangle(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                circle,
                new Vector4f(1, 1, 1, 1),
                Arrays.asList(0, 2, 4, 1, 3)
        ));
        //bulan
        circle = createCircle(-.75f, .75f, .1f, .1f, 1);
        objectsRectangle.add(new Object2d(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                circle,
                new Vector4f(1, 1, 0, 1)
        ));

        circle = createCircle(-.71f, .77f, .1f, .1f, 1);
        objectsRectangle.add(new Object2d(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                circle,
                new Vector4f(0, 0, 1, 0)
        ));
        objectsPointsControl.add(new Object2d(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f)
        ));
        /*objects.add(new Object2d(
                Arrays.asList(
                        // shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f)
                        )
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(1.0f, 0.0f, 0.0f),
                                new Vector3f(0.0f, 1.0f, 0.0f),
                                new Vector3f(0.0f, 0.0f, 1.0f)
                        )
                )
        ));
*/
    }

    public static List<Vector3f> createCircle(float x, float y, float rx, float ry, double inc) {
        List<Vector3f> circle = new ArrayList<>();

        for (double i = 0; i <= 360; i += inc) {
            float x1 = (float) (x + rx * Math.sin(Math.toRadians(i)));
            float y1 = (float) (y + ry * Math.cos(Math.toRadians(i)));
            float z = 0;
            circle.add(new Vector3f(x1, y1, z));
        }
        return circle;
    }

    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            System.out.println("W");

        }
        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);

            if (!((pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
                System.out.println("x : " + pos.x + " y : " + pos.y);
                /*if (window.getMouseInput().getCurrentPos() == objectsPointsControl.get()){
                    return 0;
                }*/

                    objectsPointsControl.add(new Rectangle(
                            Arrays.asList(
                                    // shaderFile lokasi menyesuaikan objectnya
                                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                            ),
                            new ArrayList<>(
                                    List.of(
                                            new Vector3f(pos.x - 0.1f, pos.y - 0.1f, 0.0f),
                                            new Vector3f(pos.x - 0.1f, pos.y + 0.1f, 0.0f),
                                            new Vector3f(pos.x + 0.1f, pos.y + 0.1f, 0.0f),
                                            new Vector3f(pos.x + 0.1f, pos.y - 0.1f, 0.0f)
                                    )
                            ),
                            new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                            Arrays.asList(0, 1, 2, 1, 2, 3)
                    ));
                }


        }
    }
    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
            GL.createCapabilities();
            input();
            //code
            for (Object2d object : objects) {
                object.draw();
            }
            for (Object2d object : objectsRectangle) {
                object.draw();
            }
            for (Rectangle object : stars) {
                object.drawStars();
            }
            for (Object2d object : objectsPointsControl) {
                object.drawLine();
            }
            //Restore state
            glDisableVertexAttribArray(0);

            //Poll for window events.
            //The key callback above will only be
            //invoked during this call.
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}