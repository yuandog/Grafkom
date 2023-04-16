import Engine.*;
import Engine.Object;
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

    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Object> objectsRectangle = new ArrayList<>();
    private List<Vector3f> circle = new ArrayList<>();
    private ArrayList<Rectangle> stars = new ArrayList<>();
    MouseInput mouseInput;

    private ArrayList<Object> objectsPointsControl = new ArrayList<>();
    private Object controlLine;
    private ArrayList<Object> curves = new ArrayList<>();
    private ArrayList<Vector3f> center = new ArrayList<>();
    private ArrayList<Sphere> planets = new ArrayList<>();
    Sphere kotak;

    private ArrayList<Sphere> kepala = new ArrayList<>();
    private ArrayList<Sphere> badan = new ArrayList<>();
    private ArrayList<Sphere> kaki = new ArrayList<>();
    private ArrayList<Sphere> tangan = new ArrayList<>();
    private ArrayList<Sphere> topi = new ArrayList<>();
    private ArrayList<Object> kumis = new ArrayList<>();
    int countDegree = 0;
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void init() {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0f, 0f, 3f);


        kumis.add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
        ));
        kumis.get(0).addVertices(new Vector3f(-0.4f, -0.075f, 0f));
        kumis.get(0).addVertices(new Vector3f(-0.3f, 0.1f, 0f));
        kumis.get(0).addVertices(new Vector3f(-0.07f, -0.0225f, 0f));

        kumis.add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
        ));
        kumis.get(1).addVertices(new Vector3f(-0.4f, -0.275f, 0f));
        kumis.get(1).addVertices(new Vector3f(-0.3f, 0.05f, 0f));
        kumis.get(1).addVertices(new Vector3f(-0.07f, -0.0425f, 0f));

        kumis.add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
        ));
        kumis.get(2).addVertices(new Vector3f(0.4f, -0.075f, 0f));
        kumis.get(2).addVertices(new Vector3f(0.3f, 0.1f, 0f));
        kumis.get(2).addVertices(new Vector3f(0.07f, -0.0225f, 0f));

        kumis.add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
        ));
        kumis.get(3).addVertices(new Vector3f(0.4f, -0.275f, 0f));
        kumis.get(3).addVertices(new Vector3f(0.3f, 0.05f, 0f));
        kumis.get(3).addVertices(new Vector3f(0.07f, -0.0425f, 0f));


        topi.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.15f,
                0.15f, 36,
                18, 6));
        topi.get(0).rotateObject((float) Math.toRadians(60.0), 0f, 0f, -0.5f);
        topi.get(0).translateObject(-0.4f, 0.35f, 0f);

        //lengan
        tangan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.25f,
                0.25f, 36,
                18, 3));

        tangan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.25f,
                0.25f, 36,
                18, 3));
        tangan.get(0).translateObject(-0.48f, -.5f, 0f);
        tangan.get(1).translateObject(0.48f, -.5f, 0f);

        //telapak tangan
        tangan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.11f, 36,
                18, 2));
        tangan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.11f, 36,
                18, 2));
        tangan.get(2).translateObject(-0.49f, -.7f, 0f);
        tangan.get(3).translateObject(0.49f, -.7f, 0f);

        //paha
        kaki.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.25f,
                0.25f, 36,
                18, 3));


        kaki.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.25f,
                0.25f, 36,
                18, 3));
        kaki.get(0).translateObject(-0.2f, -0.9f, 0f);
        kaki.get(1).translateObject(0.2f, -0.9f, 0f);

        //telapak kaki
        kaki.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.1f,
                0.1f, 36,
                18, 3));
        kaki.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.1f,
                0.1f, 36,
                18, 3));
        kaki.get(2).translateObject(-0.21f, -1.1f, 0f);
        kaki.get(3).translateObject(0.21f, -1.1f, 0f);

        //head
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 2));
        //white face
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.45f,
                0.35f,
                0.45f, 36,
                18, 2));
        kepala.get(1).translateObject(0f, -0.14f, 0f);

        //line mata
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.13f, 36,
                18, 2));
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.13f, 36,
                18, 2));
        kepala.get(2).translateObject(-0.12f, 0.2f, 0f);
        kepala.get(3).translateObject(0.12f, 0.21f, 0f);

        //mata
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.1f,
                0.12f, 36,
                18, 2));
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.1f,
                0.12f, 36,
                18, 2));
        kepala.get(4).translateObject(-0.12f, 0.2f, 0f);
        kepala.get(5).translateObject(0.12f, 0.21f, 0f);

        //pupil
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.02f,
                0.02f,
                0.02f, 36,
                18, 2));
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.02f,
                0.02f,
                0.02f, 36,
                18, 2));
        kepala.get(6).translateObject(-0.08f, 0.15f, 0f);
        kepala.get(7).translateObject(0.08f, 0.15f, 0f);

        //nose
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.07f,
                0.07f,
                0.07f, 36,
                18, 2));
        kepala.get(8).translateObject(0f, 0.05f, 0f);

        //mulut
        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.1f,
                0.2f, 36,
                18, 2));
        kepala.get(9).translateObject(0f, -0.25f, 0f);

        //badan
        badan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.45f,
                0.6f,
                0.6f, 36,
                18, 3));
        badan.get(0).translateObject(0f, -0.4f, 0f);

        badan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.33f,
                0.4f,
                0.4f, 108,
                72, 2));
        badan.get(1).translateObject(0f, -0.5f, 0f);

        //kantong ajaib dalam

        badan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.32f,
                0.32f,
                0.32f, 108,
                72, 9));
        badan.get(2).translateObject(0f, 1.195f, 0f);
        badan.get(2).rotateObject(180f, 0f, 0f, 0f);

        //outline kantong ajaib
        badan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.30f,
                0.30f,
                0.30f, 108,
                72, 9));
        badan.get(3).translateObject(0f, 1.2f, 0f);
        badan.get(3).rotateObject(180f, 0f, 0f, 0f);

        //kalung
        badan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.4f,
                0.3f,
                0.3f, 36,
                18, 3));
        badan.get(4).translateObject(0f, -0.25f, 0f);

        //lonceng
        badan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 2));
        badan.get(5).translateObject(0f, -0.58f, 0f);
    }

    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (Sphere kepala : kepala
            ) {
                kepala.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
            }
            for (Sphere topi : topi
            ) {
                topi.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
            }
            for (Sphere badan : badan
            ) {
                badan.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
            }
            for (Sphere kaki : kaki) {
                kaki.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
            }
            for (Sphere tangan : tangan
            ) {
                tangan.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
            }
            for (Object kumis : kumis
            ) {
                kumis.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveForward(0.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (Sphere topi : topi
            ) {
                topi.translateObject(-0.1f, 0f, 0f);
            }
            for (Sphere kepala : kepala
            ) {
                kepala.translateObject(-0.1f, 0f, 0f);
            }
            for (Sphere badan : badan
            ) {
                badan.translateObject(-0.1f, 0f, 0f);
            }
            for (Sphere kaki : kaki) {
                kaki.translateObject(-0.1f, 0f, 0f);
            }
            for (Sphere tangan : tangan
            ) {
                tangan.translateObject(-0.1f, 0f, 0f);
            }
            for (Object kumis : kumis
            ) {
                kumis.translateObject(-0.1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (Sphere topi : topi
            ) {
                topi.translateObject(0.1f, 0f, 0f);
            }
            for (Sphere kepala : kepala
            ) {
                kepala.translateObject(0.1f, 0f, 0f);
            }
            for (Sphere badan : badan
            ) {
                badan.translateObject(0.1f, 0f, 0f);
            }
            for (Sphere kaki : kaki) {
                kaki.translateObject(0.1f, 0f, 0f);
            }

            for (Sphere tangan : tangan
            ) {
                tangan.translateObject(0.1f, 0f, 0f);
            }
            for (Object kumis : kumis
            ) {
                kumis.translateObject(0.1f, 0f, 0f);
            }
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();

            input();

//            code
            for (Sphere kaki : kaki
            ) {
                kaki.draw(camera, projection);
            }
            for (Sphere badan : badan
            ) {
                badan.draw(camera, projection);
            }
            for (Sphere tangan : tangan
            ) {
                tangan.draw(camera, projection);
            }

            for (Sphere kepala : kepala
            ) {
                kepala.draw(camera, projection);
            }
            for (Object kumis : kumis) {
                kumis.drawLine(camera, projection);
            }
            for (Sphere topi : topi
            ) {
                topi.draw(camera, projection);
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
