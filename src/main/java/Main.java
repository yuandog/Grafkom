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
    boolean check = true;
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
                0.5f, 360,
                180, 2));
        kepala.get(0).translateObject(0f, 0f, 0f);
        //white face
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.45f,
                0.45f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(0).translateObject(0f, -0.05f, 0.1f);

        //outline mata
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.12f,
                0.12f,
                0.14f, 36,
                18, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.12f,
                0.12f,
                0.14f, 36,
                18, 2));
        kepala.get(0).getChildObject().get(1).translateObject(-0.12f, 0.2f, 0.36f);
        kepala.get(0).getChildObject().get(2).translateObject(0.12f, 0.21f, 0.36f);

        //mata
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.12f, 360,
                180, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.12f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(3).translateObject(-0.12f, 0.2f, 0.4f);
        kepala.get(0).getChildObject().get(4).translateObject(0.12f, 0.21f, 0.4f);

        //pupil
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.02f, 360,
                180, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.02f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(5).translateObject(-0.08f, 0.2f, 0.52f);
        kepala.get(0).getChildObject().get(6).translateObject(0.08f, 0.2f, 0.52f);

        //nose
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.07f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(7).translateObject(0f, 0.05f, 0.55f);

        //mulut
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.15f,
                0.05f,
                0.15f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(8).translateObject(0f, -0.13f, 0.43f);

        //badan
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.45f,
                0.6f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(9).translateObject(0f, -0.4f, 0f);

        //badan putih
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.4f, 360,
                180, 2));

        kepala.get(0).getChildObject().get(10).translateObject(0f, -0.5f, 0.1f);

        //outline kantong ajaib

        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.35f,
                0.35f,
                0.35f, 360,
                180, 9));
        kepala.get(0).getChildObject().get(11).translateObject(0f, 0.9f, -0.525f);
        kepala.get(0).getChildObject().get(11).rotateObject(180f, 0f, 0f, 0f);

        //kantong ajaib
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.30f, 360,
                180, 9));
        kepala.get(0).getChildObject().get(12).translateObject(0f, 0.9f, -0.60f);
        kepala.get(0).getChildObject().get(12).rotateObject(180f, 0f, 0f, 0f);

        //kalung
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.1f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(13).translateObject(0f, -0.29f, 0.24f);

        //lonceng
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.05f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(14).translateObject(0f, -0.33f, 0.55f);


        //lengan
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.15f,
                0.25f, 360,
                180, 3));

        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.15f,
                0.25f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(15).translateObject(-0.48f, -.5f, 0f);
        kepala.get(0).getChildObject().get(16).translateObject(0.48f, -.5f, 0f);

        //telapak tangan
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.11f, 360,
                180, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.11f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(17).translateObject(-0.49f, -.73f, 0f);
        kepala.get(0).getChildObject().get(18).translateObject(0.49f, -.73f, 0f);

        //paha
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.2f,
                0.25f, 360,
                180, 3));


        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.2f,
                0.25f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(19).translateObject(-0.2f, -0.9f, 0f);
        kepala.get(0).getChildObject().get(20).translateObject(0.2f, -0.9f, 0f);

        //telapak kaki
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.2f,
                0.1f, 360,
                180, 3));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.2f,
                0.1f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(21).translateObject(-0.21f, -1.2f, 0f);
        kepala.get(0).getChildObject().get(22).translateObject(0.21f, -1.2f, 0f);


        //kumis
        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                , Arrays.asList(0f, 0f, 0f)));
        kepala.get(0).getChildObject().get(23).addVertices(new Vector3f(-0.4f, -0.075f, 0.55f));
        kepala.get(0).getChildObject().get(23).addVertices(new Vector3f(-0.3f, 0.1f, 0.55f));
        kepala.get(0).getChildObject().get(23).addVertices(new Vector3f(-0.07f, -0.0225f, 0.55f));
        kepala.get(0).getChildObject().get(23).translateObject(0f, 0f, 0.5f);

        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                , Arrays.asList(0f, 0f, 0f)));
        kepala.get(0).getChildObject().get(24).addVertices(new Vector3f(-0.4f, -0.275f, 0f));
        kepala.get(0).getChildObject().get(24).addVertices(new Vector3f(-0.3f, 0.05f, 0f));
        kepala.get(0).getChildObject().get(24).addVertices(new Vector3f(-0.07f, -0.0425f, 0f));
        kepala.get(0).getChildObject().get(24).translateObject(0f, 0f, 0.5f);

        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                , Arrays.asList(0f, 0f, 0f)));
        kepala.get(0).getChildObject().get(25).addVertices(new Vector3f(0.4f, -0.075f, 0f));
        kepala.get(0).getChildObject().get(25).addVertices(new Vector3f(0.3f, 0.1f, 0f));
        kepala.get(0).getChildObject().get(25).addVertices(new Vector3f(0.07f, -0.0225f, 0f));
        kepala.get(0).getChildObject().get(25).translateObject(0f, 0f, 0.5f);

        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                , Arrays.asList(0f, 0f, 0f)));
        kepala.get(0).getChildObject().get(26).addVertices(new Vector3f(0.4f, -0.275f, 0f));
        kepala.get(0).getChildObject().get(26).addVertices(new Vector3f(0.3f, 0.05f, 0f));
        kepala.get(0).getChildObject().get(26).addVertices(new Vector3f(0.07f, -0.0425f, 0f));
        kepala.get(0).getChildObject().get(26).translateObject(0f, 0f, 0.5f);

        //topi
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
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
                0.15f, 360,
                180, 6));
        kepala.get(0).getChildObject().get(27).rotateObject((float) Math.toRadians(60.0), 0f, 0f, -0.5f);
        kepala.get(0).getChildObject().get(27).translateObject(-0.4f, 0.35f, 0f);
    }


    public void input() {
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            for (Sphere kepala : kepala) {
                List<Float> temp = new ArrayList<>(kepala.getCenterPoint());
                kepala.getChildObject().get(15).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(17).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(16).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(18).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(19).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(21).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(20).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(22).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                if (check) {
                    if (kepala.getChildObject().get(15).getCenterPoint().get(1) >= -0.47f && kepala.getChildObject().get(15).getCenterPoint().get(2) >= -0.08f) {
                        check = false;
                    } else {
                        //lengan kiri
                        kepala.getChildObject().get(15).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        kepala.getChildObject().get(17).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        //lengan kanan
                        kepala.getChildObject().get(16).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        kepala.getChildObject().get(18).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        //kaki kiri
                        kepala.getChildObject().get(19).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        kepala.getChildObject().get(21).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        //kaki kanan
                        kepala.getChildObject().get(20).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        kepala.getChildObject().get(22).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        System.out.println(kepala.getChildObject().get(15).getCenterPoint());
                    }
                } else {
                    if (kepala.getChildObject().get(15).getCenterPoint().get(1) <= -0.49f && kepala.getChildObject().get(15).getCenterPoint().get(2) <= -0.08f) {
                        check = true;
                    } else {
                        //lengan kiri
                        kepala.getChildObject().get(15).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        kepala.getChildObject().get(17).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        //lengan kanan
                        kepala.getChildObject().get(16).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        kepala.getChildObject().get(18).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        //kaki kiri
                        kepala.getChildObject().get(19).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        kepala.getChildObject().get(21).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        //kaki kanan
                        kepala.getChildObject().get(20).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        kepala.getChildObject().get(22).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);

                        System.out.println(kepala.getChildObject().get(15).getCenterPoint());
                    }
                }
                kepala.getChildObject().get(15).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(17).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(16).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(18).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(19).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(21).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(20).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(22).translateObject(temp.get(0), temp.get(1), temp.get(2));
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {

            for (Object kepala : kepala
            ) {
                List<Float> temp = new ArrayList<>(kepala.getCenterPoint());
                kepala.translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.rotateObject((float) Math.toRadians(0.5f), 0f, 1f, 0f);
                kepala.translateObject(temp.get(0), temp.get(1), temp.get(2));
            }
        }
        if (window.isKeyPressed(GLFW_KEY_E)) {
            camera.moveBackwards(0.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveForward(0.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (Sphere kepala : kepala
            ) {
                kepala.translateObject(-0.1f, 0f, 0f);
            }

        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (Sphere kepala : kepala
            ) {
                kepala.translateObject(0.1f, 0f, 0f);
            }
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 1.0f, 0.0f, 0.0f);
            GL.createCapabilities();

            input();

//            code
//            for (Sphere kaki : kaki
//            ) {
//                kaki.draw(camera, projection);
//            }
//            for (Sphere badan : badan
//            ) {
//                badan.draw(camera, projection);
//            }
//            for (Sphere tangan : tangan
//            ) {
//                tangan.draw(camera, projection);
//            }

            for (Object kepala : kepala
            ) {
                kepala.draw(camera, projection);
            }
//            for (Object kumis : kumis) {
//                kumis.drawLine(camera, projection);
//            }
//            for (Sphere topi : topi
//            ) {
//                topi.draw(camera, projection);
//            }
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
