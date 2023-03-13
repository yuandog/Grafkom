package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL30.*;

public class Object extends ShaderProgram {

    public List<Vector3f> vertices, verticesColor;
    int vao;
    int vbo;
    UniformsMap uniformsMap;
    Vector4f color;
    Matrix4f model;

    int vboColor;

    //    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
//        super(shaderModuleDataList);
//        this.vertices = vertices;
//        setupVAOVBO();
//        uniformsMap = new UniformsMap(getProgramId());
//        uniformsMap.createUniform("uni_color");
//        this.color = color;
//    }
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        this.color = color;
        model = new Matrix4f().identity();
    }

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
    }

    public void setupVAOVBO() {
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void setupVAOVBOWithVerticesColor() {
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        //set vbo color
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

//    public void drawSetup(){
//        bind();
//        uniformsMap.setUniform("uni_color",color);
//
//        // Bind VBO
//        glEnableVertexAttribArray(0);
//        glBindBuffer(GL_ARRAY_BUFFER,vbo);
//        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
//    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
    }

    public void drawSetupWithVerticesColor() {
        bind();

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        //Bind vbo Color
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);

    }

    public void draw() {
        drawSetup();

        //Draw the vertices
        //optional
        glLineWidth(1); //ketebalan garis
        glPointSize(0); //besar kecil vertex

        //wajib
        //GL_LINES, GL_LINE_STRIP, GL_LINE_LOOP, GL_TRIANGLES, GL_TRIANGLES_FAN, GL_POINT -> YG SERING DIPAKAI
        //GL_POLYGON -> alternatif buat kotak
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
    }

    public void drawLine() {
        drawSetup();

        //Draw the vertices
        //optional
        glLineWidth(5); //ketebalan garis
        glPointSize(0); //besar kecil vertex

        //wajib
        //GL_LINES, GL_LINE_STRIP, GL_LINE_LOOP, GL_TRIANGLES, GL_TRIANGLES_FAN, GL_POINT -> YG SERING DIPAKAI
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }

    public void addVertices(Vector3f newVertices) {
        vertices.add(newVertices);
        setupVAOVBO();
    }

    public void translateObject(Float offsetX, Float offsetY, Float offsetZ) {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
    }
    public void rotateObject(Float degree,Float x, Float y, Float z) {
        model = new Matrix4f().rotate(degree,x,y,z).mul(new Matrix4f(model));
    }
    public void scaleObject(Float scaleX,Float scaleY, Float scaleZ) {
        model = new Matrix4f().scale(scaleX,scaleY,scaleZ).mul(new Matrix4f(model));
    }

    public void drawWithVerticesColor() {
        drawSetupWithVerticesColor();
        //Draw the vertices
        //optional
        glLineWidth(1); //ketebalan garis
        glPointSize(0); //besar kecil vertex

        //wajib
        //GL_LINES, GL_LINE_STRIP, GL_LINE_LOOP, GL_TRIANGLES, GL_TRIANGLES_FAN, GL_POINT -> YG SERING DIPAKAI
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }

}
