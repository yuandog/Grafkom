import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.PointerBuffer;
import org.lwjgl.assimp.*;
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
    private ArrayList<Float> positions = new ArrayList<>();
    private ArrayList<Float> normals = new ArrayList<>();
    private ArrayList<Float> texCoords = new ArrayList<>();
    boolean muter = true;
    Sphere kotak;
    int countDegree = 0;
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void init() {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0f, 0f, 3f);

        //code
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
//        //rumput
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-1.0f, -1.0f, 0.0f),
//                                new Vector3f(1.0f, -1.0f, 0.0f),
//                                new Vector3f(-1.0f, -0.45f, 0.0f),
//                                new Vector3f(1.0f, -0.45f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        //atap belakang
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.55f, 0.2f, 0.0f),
//                                new Vector3f(0.55f, 0.2f, 0.0f),
//                                new Vector3f(-0.8f, -0.2f, 0.0f),
//                                new Vector3f(0.8f, -0.2f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.6f, 0.0f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        //badan rumah
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.65f, -0.1f, 0.0f),
//                                new Vector3f(0.65f, -0.1f, 0.0f),
//                                new Vector3f(-0.65f, -0.6f, 0.0f),
//                                new Vector3f(0.65f, -0.6f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        //badan rumah atap
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.53f, 0.15f, 0.0f),
//                                new Vector3f(0.53f, 0.15f, 0.0f),
//                                new Vector3f(-0.65f, -0.1f, 0.0f),
//                                new Vector3f(0.65f, -0.1f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        //atap depan
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.55f, 0.2f, 0.0f),
//                                new Vector3f(0.55f, 0.2f, 0.0f),
//                                new Vector3f(-0.45f, -0.2f, 0.0f),
//                                new Vector3f(0.8f, -0.2f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.6f, 0.0f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        //cerobong asap badan
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.35f, 0.1f, 0.0f),
//                                new Vector3f(0.40f, 0.1f, 0.0f),
//                                new Vector3f(0.35f, 0.3f, 0.0f),
//                                new Vector3f(0.40f, 0.3f, 0.0f)
//                        )
//                ),
//                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        //cerobong asap kepala
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.3f, 0.3f, 0.0f),
//                                new Vector3f(0.45f, 0.3f, 0.0f),
//                                new Vector3f(0.3f, 0.35f, 0.0f),
//                                new Vector3f(0.45f, 0.35f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.7f, 0f, 0.0f, 0.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));
//        //asap
//        circle = createCircle(0.4f, 0.45f, .0875f, .05f, 1);
//        objects.add(new Object2d(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                circle,
//                new Vector4f(0.67f, 0.67f, 0.67f, 1)
//        ));
//        circle = createCircle(0.45f, 0.5f, .0875f, .05f, 1);
//        objects.add(new Object2d(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                circle,
//                new Vector4f(0.67f, 0.67f, 0.67f, 1)
//        ));
//        circle = createCircle(0.5f, 0.55f, .0875f, .05f, 1);
//        objects.add(new Object2d(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                circle,
//                new Vector4f(0.67f, 0.67f, 0.67f, 1)
//        ));
//        //bintang
//        circle = createCircle(.5f, .8f, .05f, .05f, 72);
//        stars.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                circle,
//                new Vector4f(1, 1, 1, 1),
//                Arrays.asList(0, 2, 4, 1, 3)
//        ));
//        circle = createCircle(-.4f, .5f, .05f, .05f, 72);
//        stars.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                circle,
//                new Vector4f(1, 1, 1, 1),
//                Arrays.asList(0, 2, 4, 1, 3)
//        ));
//        circle = createCircle(-.1f, .8f, .02f, .02f, 72);
//        stars.add(new Rectangle(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                circle,
//                new Vector4f(1, 1, 1, 1),
//                Arrays.asList(0, 2, 4, 1, 3)
//        ));
//        //bulan
//        circle = createCircle(-.75f, .75f, .1f, .1f, 1);
//        objectsRectangle.add(new Object2d(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                circle,
//                new Vector4f(1, 1, 0, 1)
//        ));
//
//        circle = createCircle(-.71f, .77f, .1f, .1f, 1);
//        objectsRectangle.add(new Object2d(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                circle,
//                new Vector4f(0, 0, 1, 0)
//        ));
//        objectsPointsControl.add(new Object2d(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f)
//        ));
//        /*objects.add(new Object2d(
//                Arrays.asList(
//                        // shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f, 0.5f, 0.0f),
//                                new Vector3f(-0.5f, -0.5f, 0.0f),
//                                new Vector3f(0.5f, -0.5f, 0.0f)
//                        )
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(1.0f, 0.0f, 0.0f),
//                                new Vector3f(0.0f, 1.0f, 0.0f),
//                                new Vector3f(0.0f, 0.0f, 1.0f)
//                        )
//                )
//        ));*/
        kotak = new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        );
        kotak.scaleObject(1f, 1f, 1f);

        kotak.getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
//        kotak.getChildObject().get(0).translateObject(0.25f,0.0f,0.0f);
        kotak.getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.5f);
        kotak.getChildObject().get(0).translateObject(1f, -0.1f, 0.0f);
        kotak.getChildObject().get(0).setCenterPoint(Arrays.asList(0.5f, -0.1f, 0.0f));

        kotak.getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
//        kotak.getChildObject().get(1).translateObject(0.5f,0.0f,0.0f);
        kotak.getChildObject().get(1).scaleObject(0.5f, 0.5f, 0.5f);
        kotak.getChildObject().get(1).translateObject(-1f, -0.1f, 0.0f);
        kotak.getChildObject().get(1).setCenterPoint(Arrays.asList(-0.5f, -0.1f, 0.0f));

        loadFBXFile("C://Users/Lenovo/OneDrive/Documents/Blender project/donat.fbx");
        System.out.println(positions);
        //matahari
//        planets.add(new Sphere(Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//        ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
//                Arrays.asList(0f, 0f, 0f),
//                0.3f,
//                0.3f,
//                0.3f, 36,
//                18
//        ));
//        planets.get(0).createSphere();
//
//        //merkurius
//        planets.add(new Sphere(Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//        ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
//                Arrays.asList(0.0f, 0.0f, 0f),
//                0.1f,
//                0.1f,
//                0.1f, 36,
//                18
//        ));
//        planets.get(1).createSphere();
//        planets.get(1).translateObject(-0.5f,0.0f,0.0f);
//
//        //venus
//        planets.add(new Sphere(Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//        ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
//                Arrays.asList(0.0f, 0.0f, 0f),
//                0.1f,
//                0.1f,
//                0.1f, 36,
//                18
//        ));
//        planets.get(2).createSphere();
//        planets.get(2).translateObject(-0.7f,-0.1f,0.0f);
//
//        //bumi
//        planets.add(new Sphere(Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//        ),
//                new ArrayList<>(
//                        List.of(
//                        )
//                ),
//                new Vector4f(0.0f, 1.0f, 0.0f, 0.0f),
//                Arrays.asList(0.0f, 0.0f, 0f),
//                0.1f,
//                0.1f,
//                0.1f, 36,
//                18
//        ));
//        planets.get(3).createSphere();
//        planets.get(3).translateObject(-0.9f,0.0f,0.0f);
//
    }

//    public static List<Vector3f> createCircle(float x, float y, float rx, float ry, double inc) {
//        List<Vector3f> circle = new ArrayList<>();
//
//        for (double i = 0; i <= 360; i += inc) {
//            float x1 = (float) (x + rx * Math.sin(Math.toRadians(i)));
//            float y1 = (float) (y + ry * Math.cos(Math.toRadians(i)));
//            float z = 0;
//            circle.add(new Vector3f(x1, y1, z));
//        }
//        return circle;
//    }

    public void rotate() {
        System.out.println(camera.getRotation());
        if (muter) {
                camera.addRotation(0f, (float) Math.toRadians(6.0f));
        }
    }

    public void loadFBXFile(String filepath) {
        AIScene scene = Assimp.aiImportFile(filepath, Assimp.aiProcess_Triangulate);
//        AIScene scene = Assimp.aiImportFile(filepath, Assimp.aiProcess_Triangulate);
        System.out.println(scene);
        PointerBuffer buffer = scene.mMeshes();

        for (int i = 0; i < buffer.limit(); i++) {
            AIMesh mesh = AIMesh.create(buffer.get(i));
            processMesh(mesh);
        }
    }

    public void processMesh(AIMesh mesh) {
        AIVector3D.Buffer vectors = mesh.mVertices();
        for (int i = 0; i < vectors.limit(); i++) {
            AIVector3D vector = vectors.get(i);
            positions.add(vector.x());
            positions.add(vector.y());
            positions.add(vector.z());
        }

        AIVector3D.Buffer coords = mesh.mTextureCoords(0);
        for (int i = 0; i < coords.limit(); i++) {
            AIVector3D coord = coords.get(i);
            texCoords.add(coord.x());
            texCoords.add(coord.y());
        }

        AIVector3D.Buffer norms = mesh.mNormals();
        for (int i = 0; i < norms.limit(); i++) {
            AIVector3D norm = norms.get(i);
            normals.add(norm.x());
            normals.add(norm.y());
            normals.add(norm.z());
        }


        AIColor4D.Buffer vertexColors = mesh.mColors(0);
        try {
            for (int i = 0; i < vertexColors.limit(); i++) {
                AIColor4D vertexColor = vertexColors.get(i);
                normals.add(vertexColor.r());
                normals.add(vertexColor.g());
                normals.add(vertexColor.b());
                normals.add(vertexColor.a());
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            System.out.println("W");
            countDegree++;
//            for (Sphere planet:planets) {
//                planet.rotateObject((float) Math.toRadians(0.5f), 0f,0f, 1f);
//            }
//            kotak.rotateObject((float) Math.toRadians(0.5f), 0.5f, 0.3f, 0f);
//            for (Object child : kotak.getChildObject()) {
//                child.rotateObject((float) Math.toRadians(countDegree * -1 * 0.5f), 0.0f, 0.0f, 1.0f);
//                child.translateObject(child.getCenterPoint().get(0) * -1, child.getCenterPoint().get(1) * -1, child.getCenterPoint().get(2) * -1);
//                child.rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1.0f);
//                child.translateObject(child.getCenterPoint().get(0) * 1, child.getCenterPoint().get(1) * 1, child.getCenterPoint().get(2) * 1);
//            }
            camera.moveForward(0.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(0.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(0.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(0.1f);
        }
        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f displayVec = window.getMouseInput().getDisplVec();
            camera.addRotation((float) Math.toRadians(displayVec.x * 0.1f), (float) Math.toRadians(displayVec.y * 0.1f));
        }
        if (window.getMouseInput().getScroll().y != 0) {
            projection.setFOV(projection.getFOV() - window.getMouseInput().getScroll().y * 0.1f);
            window.getMouseInput().setScroll(new Vector2f());
        }
        if (window.isKeyPressed(GLFW_KEY_E)) {
            rotate();
        }
//        if (window.getMouseInput().isLeftButtonPressed()) {
//            Vector2f pos = window.getMouseInput().getCurrentPos();
//
//            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
//            pos.y = (pos.y - (window.getHeight()) / 2.0f) / (-window.getHeight() / 2.0f);
//
//            if ((!(pos.x > 1 || pos.x < -0.95) && !(pos.y > 0.95 || pos.y < -1))) {
//                System.out.println("x : " + pos.x + " y : " + pos.y);
//                /*if (window.getMouseInput().getCurrentPos() == objectsPointsControl.get()){
//                    return 0;
//                }*/
//                //gambar
//                if (objectsPointsControl.isEmpty() || checkOverlaps(pos) == -1) {
//
//                    //object kotak
//                    objectsPointsControl.add(new Rectangle(
//                            Arrays.asList(
//                                    // shaderFile lokasi menyesuaikan objectnya
//                                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                            ),
//                            new ArrayList<>(
//                                    List.of(
//                                            new Vector3f(pos.x + 0.1f, pos.y - 0.1f, 0),
//                                            new Vector3f(pos.x + 0.1f, pos.y + 0.1f, 0),
//                                            new Vector3f(pos.x - 0.1f, pos.y + 0.1f, 0),
//                                            new Vector3f(pos.x - 0.1f, pos.y - 0.1f, 0)
//                                    )
//                            ),
//                            new Vector4f(1, 1, 0, 0),
//                            Arrays.asList(0, 1, 2, 0, 2, 3)
//                    ));
//                    center.add(new Vector3f(pos.x, pos.y, 0));
//
//                    // garis
//                    controlLine = new Object(
//                            Arrays.asList(
//                                    // shaderFile lokasi menyesuaikan objectnya
//                                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                                    new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                            ),
//                            center,
//                            new Vector4f(1, 0, 1, 1)
//                    );
//
//                    objectsPointsControl.get(objectsPointsControl.size() - 1).setupVAOVBO();
//                    controlLine.setupVAOVBO();
//                }
//                // drag n drop
//                if (!objectsPointsControl.isEmpty() && checkOverlaps(pos) != -1) {
//                    int clickedBox = checkOverlaps(pos);
//                    objectsPointsControl.get(clickedBox).vertices.set(0, new Vector3f(pos.x + 0.1f, pos.y - 0.1f, 0));
//                    objectsPointsControl.get(clickedBox).vertices.set(1, new Vector3f(pos.x + 0.1f, pos.y + 0.1f, 0));
//                    objectsPointsControl.get(clickedBox).vertices.set(2, new Vector3f(pos.x - 0.1f, pos.y + 0.1f, 0));
//                    objectsPointsControl.get(clickedBox).vertices.set(3, new Vector3f(pos.x - 0.1f, pos.y - 0.1f, 0));
//                    objectsPointsControl.get(clickedBox).setupVAOVBO();
//                    center.set(clickedBox, new Vector3f(pos.x, pos.y, 0));
//                    controlLine.setupVAOVBO();
//                }
//            }
//        }
//    }
//
//    public int checkOverlaps(Vector2f pos) {
//        int index = 0;
//        int collapse = -1;
//
//        for (Object object : objectsPointsControl) {
//            boolean collisionX = (pos.x + 0.1f <= object.vertices.get(2).x + 0.15f && object.vertices.get(2).x <= pos.x + 0.1f) ||
//                    (pos.x - 0.1f <= object.vertices.get(2).x + 0.15f && object.vertices.get(2).x <= pos.x + 0.1f);
//            boolean collisionY = (pos.y + 0.1f <= object.vertices.get(3).y + 0.15f && object.vertices.get(3).y <= pos.y + 0.1f) ||
//                    (pos.y - 0.1f <= object.vertices.get(3).y + 0.15f && object.vertices.get(3).y <= pos.y + 0.1f);
//
//            if (collisionX && collisionY) {
//                collapse = index;
//                break;
//            }
//            index++;
//        }
//
//        return collapse;
//    }
//
//    public int factorial(int num) {
//        if (num >= 1)
//            return num * factorial(num - 1);
//        else
//            return 1;
//    }
//
//    public int combination(int a, int b) {
//        return factorial(a) / (factorial(a - b) * factorial(b));
//    }
//
//    public ArrayList<Integer> pascal(int x) {
//        ArrayList<Integer> res = new ArrayList<>();
//
//        for (int i = 0; i < x; i++)
//            res.add(combination(x - 1, i));
//
//        return res;
//    }
//
//    public void curve() {
//        curves.clear();
//        ArrayList<Integer> pascal = pascal(center.size());
//        ArrayList<Vector3f> points = new ArrayList<>();
//
//        if (center.size() > 2) {
//            for (double t = 0; t <= 1; t += 0.01) {
//                float x = 0;
//                float y = 0;
//
//                for (int i = 0; i <= center.size() - 1; i++) {
//                    x += (pascal.get(i) * center.get(i).x * Math.pow(1 - t, (center.size() - 1) - i) * Math.pow(t, i));
//                    y += (pascal.get(i) * center.get(i).y * Math.pow(1 - t, (center.size() - 1) - i) * Math.pow(t, i));
//                }
//                points.add(new Vector3f(x, y, 0));
//            }
//
//            curves.add(new Object(
//                    Arrays.asList(
//                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                    ),
//                    points,
//                    new Vector4f(0, 1, 0, 1)
//            ));
//        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();
//            planet.draw();
            kotak.draw(camera, projection);
            kotak.draw(camera, projection);
            input();

//            curve();
//            code
//
//            for (Object2d object : objects) {
//                object.draw();
//            }
//            for (Object2d object : objectsRectangle) {
//                object.draw();
//            }
//            for (Rectangle object : stars) {
//                object.drawStars();
//            }
//            if (controlLine != null) {
//                controlLine.drawLine(camera,projection);
//            }
//            for (Object object : curves) {
//                object.drawLine(camera,projection);
//            }
//            for (Object object : objectsPointsControl) {
//                object.draw();
//            }
//            for (Sphere planets : planets){
//                planets.draw();
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
