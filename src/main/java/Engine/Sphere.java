package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

public class Sphere extends Circle {
    float radiusZ;
    int sectorCount;
    int stackCount;
    int nbo;
    int nboColor;
    List<Vector3f> normal;

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices,
                  Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int sectorCount, int stackCount, int choose) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.sectorCount = sectorCount;
        this.stackCount = stackCount;

        if (choose == 1)
            createBoxVertices();
        if (choose == 2)
            createSphere();
        if (choose == 3)
            createEllipsoid();
        if (choose == 4)
            createHyperBoloid1Side();
        if (choose == 5)
            createHyperBoloid2Side();
        if (choose == 6)
            createEllipticCone();
        if (choose == 7)
            createEllipticParaboloid();
        if (choose == 8)
            createHyperboloidParaboloid();
        if (choose == 9)
            createSphereTemp();
        setupVAOVBO();
    }

    public void createBoxVertices() {
//        System.out.println("code");
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //Titik 1 kiri atas belakang
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 2 kiri bawah belakang
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 3 kanan bawah belakang
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 4 kanan atas belakang
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 5 kiri atas depan
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 6 kiri bawah depan
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 7 kanan bawah depan
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 8 kanan atas depan
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
        //kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
        //kotak samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(4));

        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));
        //kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(1));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(3));

        normal = new ArrayList<>(Arrays.asList(
                new Vector3f(0.0f, 0.0f, -1.0f),
                new Vector3f(0.0f, 0.0f, -1.0f),
                new Vector3f(0.0f, 0.0f, -1.0f),
                new Vector3f(0.0f, 0.0f, -1.0f),
                new Vector3f(0.0f, 0.0f, -1.0f),
                new Vector3f(0.0f, 0.0f, -1.0f),

                new Vector3f(0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 1.0f),
                new Vector3f(0.0f, 0.0f, 1.0f),

                new Vector3f(-1.0f, 0.0f, 0.0f),
                new Vector3f(-1.0f, 0.0f, 0.0f),
                new Vector3f(-1.0f, 0.0f, 0.0f),
                new Vector3f(-1.0f, 0.0f, 0.0f),
                new Vector3f(-1.0f, 0.0f, 0.0f),
                new Vector3f(-1.0f, 0.0f, 0.0f),

                new Vector3f(1.0f, 0.0f, 0.0f),
                new Vector3f(1.0f, 0.0f, 0.0f),
                new Vector3f(1.0f, 0.0f, 0.0f),
                new Vector3f(1.0f, 0.0f, 0.0f),
                new Vector3f(1.0f, 0.0f, 0.0f),
                new Vector3f(1.0f, 0.0f, 0.0f),

                new Vector3f(0.0f, -1.0f, 0.0f),
                new Vector3f(0.0f, -1.0f, 0.0f),
                new Vector3f(0.0f, -1.0f, 0.0f),
                new Vector3f(0.0f, -1.0f, 0.0f),
                new Vector3f(0.0f, -1.0f, 0.0f),
                new Vector3f(0.0f, -1.0f, 0.0f),

                new Vector3f(0.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, 1.0f, 0.0f),
                new Vector3f(0.0f, 1.0f, 0.0f)
        ));
    }

    public void createBox() {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //object 3d kotak
        //TITIK 1
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 7
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 8
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak di sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));

        //kotak di sisi depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));

        //kotak di sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

        //kotak di sisi kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        //kotak di sisi atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));

        //kotak di sisi bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

//    public void setupVAOVBO() {
//        super.setupVAOVBO();
//
//        //set nbo
//        nbo = glGenBuffers();
//        glBindBuffer(GL_ARRAY_BUFFER, nbo);
//        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(normal), GL_STATIC_DRAW);
//
////        uniformsMap.createUniform("lightColor");
////        uniformsMap.createUniform("lightPos");
//    }

    public void drawSetup(Camera camera, Projection projection) {
        super.drawSetup(camera, projection);

        // Bind VBO
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, nbo);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);

        //directional Light
        uniformsMap.setUniform("dirLight.direction", new Vector3f(0f, 1f, 0f));
        uniformsMap.setUniform("dirLight.ambient", new Vector3f(0.05f,0.05f,0.05f));
        uniformsMap.setUniform("dirLight.diffuse", new Vector3f(0.4f, 0.4f, 0.4f));
        uniformsMap.setUniform("dirLight.specular", new Vector3f(0.5f, 0.5f, 0.5f));

        //posisi pointLight
        Vector3f[] _pointLightPositions = {
                new Vector3f(6.214055f, 1.1962f, 7.146f),
                new Vector3f(-4.995f, 1.1962f, 14.06f),
                new Vector3f(-17.07f, 1.1962f, -2.094f),
                new Vector3f(-17.02f, 1.1962f, 15.185f),
                new Vector3f(19.63f, 0.9f, 20.78f),
        };
        for (int i = 0; i < _pointLightPositions.length; i++) {

            uniformsMap.setUniform("pointLights[" + i + "].position", _pointLightPositions[i]);
            uniformsMap.setUniform("pointLights[" + i + "].ambient", new Vector3f(0.05f, 0.05f, 0.05f));
            uniformsMap.setUniform("pointLights[" + i + "].diffuse", new Vector3f(0.8f, 0.8f, 0.8f));
            uniformsMap.setUniform("pointLights[" + i + "].specular", new Vector3f(0.5f, 0.5f, 0.5f));
            uniformsMap.setUniform("pointLights[" + i + "].constant", 1.0f);
            uniformsMap.setUniform("pointLights[" + i + "].linear", 0.002f);
            uniformsMap.setUniform("pointLights[" + i + "].quadratic", 0.1f);
        }



//        uniformsMap.setUniform("lightColor", new Vector3f(1.0f, 1.0f, 0f));
//        uniformsMap.setUniform("lightPos",new Vector3f(1.0f,5.0f,0.0f));

        //spotLight
        uniformsMap.setUniform("spotLight.position", camera.getPosition());
        uniformsMap.setUniform("spotLight.direction", camera.getDirection());
        uniformsMap.setUniform("spotLight.ambient", new Vector3f(0.1f, 0.1f, 0.1f));
        uniformsMap.setUniform("spotLight.diffuse", new Vector3f(1.0f, 1.0f, 1.0f));
        uniformsMap.setUniform("spotLight.specular", new Vector3f(1.0f, 1.0f, 1.0f));
        uniformsMap.setUniform("spotLight.constant", 1.0f);
        uniformsMap.setUniform("spotLight.linear", 0.09f);
        uniformsMap.setUniform("spotLight.quadratic", 0.09f);
        uniformsMap.setUniform("spotLight.cutOff", (float) Math.cos(Math.toRadians(12.5f)));
        uniformsMap.setUniform("spotLight.outerCutOff", (float) Math.cos(Math.toRadians(15f)));


        uniformsMap.setUniform("viewPos", camera.getPosition());
    }
//    public void draw() {
//        drawSetup();
//
//        //Draw the vertices
//        //optional
//        glLineWidth(1); //ketebalan garis
//        glPointSize(0); //besar kecil vertex
//
//        //wajib
//        //GL_LINES, GL_LINE_STRIP, GL_LINE_LOOP, GL_TRIANGLES, GL_TRIANGLES_FAN, GL_POINT -> YG SERING DIPAKAI
//        //GL_POLYGON -> alternatif buat kotak
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }

    public void createSphere() {
        float pi = (float) Math.PI;
        float sectorStep = 2 * (float) Math.PI / sectorCount;
        float stackStep = (float) Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;
        for (int i = 0; i <= stackCount; ++i) {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float) Math.cos(StackAngle);
            y = radiusY * (float) Math.cos(StackAngle);
            z = radiusZ * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float) Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float) Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }
    }

    public void createSphereTemp() {
        float pi = (float) Math.PI;
        float sectorStep = (float) Math.PI / sectorCount;
        float stackStep = (float) Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;
        for (int i = 0; i <= stackCount; ++i) {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float) Math.cos(StackAngle);
            y = radiusY * (float) Math.cos(StackAngle);
            z = radiusZ * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float) Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float) Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }
    }

    public void createEllipsoid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) (Math.cos(v) * Math.cos(u));
                float y = radiusY * (float) (Math.cos(v) * Math.sin(u));
                float z = radiusZ * (float) (Math.sin(v));
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperBoloid1Side() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) ((1 / Math.cos(v)) * Math.cos(u));
                float y = radiusY * (float) ((1 / Math.cos(v)) * Math.sin(u));
                float z = radiusZ * (float) (Math.tan(v));
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperBoloid2Side() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI / 2; u <= Math.PI / 2; u += Math.PI / 60) {
                float x = radiusX * (float) (Math.tan(v) * Math.cos(u));
                float y = radiusY * (float) (Math.tan(v) * Math.sin(u));
                float z = radiusZ * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));
            }
            for (double u = Math.PI / 2; u <= 3 * Math.PI / 2; u += Math.PI / 60) {
                float x = radiusX * (float) (Math.tan(v) * Math.cos(u));
                float y = radiusY * (float) (Math.tan(v) * Math.sin(u));
                float z = radiusZ * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createEllipticCone() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 100) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) (v * Math.cos(u));
                float y = radiusY * (float) (v * Math.sin(u));
                float z = radiusZ * (float) v;
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createEllipticParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = Math.PI; v >= 0; v -= Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) (v * Math.cos(u));
                float y = radiusY * (float) (v * Math.sin(u));
                float z = (float) (v * v);
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperboloidParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = Math.PI; v >= 0; v -= Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = radiusX * (float) (v * Math.tan(u));
                float y = radiusY * (float) (v * (1 / Math.cos(u)));
                float z = (float) (v * v);
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }
}
