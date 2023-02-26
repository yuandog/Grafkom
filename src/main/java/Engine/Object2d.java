package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL30.*;

public class Object2d extends ShaderProgram {

    List<Vector3f> vertices, verticesColor;
    int vao;
    int vbo;
    UniformsMap uniformsMap;
    Vector4f color;

    int vboColor;

    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        this.color = color;
    }
    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
    }

    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);
    }

    public void setupVAOVBOWithVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);

        //set vbo color
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vboColor);
        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(verticesColor),GL_STATIC_DRAW);
    }

    public void drawSetup(){
        bind();
        uniformsMap.setUniform("uni_color",color);

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
    }

    public void drawSetupWithVerticesColor(){
        bind();

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);

        //Bind vbo Color
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER,vboColor);
        glVertexAttribPointer(1,3,GL_FLOAT,false,0,0);

    }
   public void draw(){
        drawSetup();

        //Draw the vertices
       //optional
       glLineWidth(1); //ketebalan garis
       glPointSize(0); //besar kecil vertex

       //wajib
       //GL_LINES, GL_LINE_STRIP, GL_LINE_LOOP, GL_TRIANGLES, GL_TRIANGLES_FAN, GL_POINT -> YG SERING DIPAKAI
       glDrawArrays(GL_TRIANGLE_FAN,0,vertices.size());
   }
    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        //Draw the vertices
        //optional
        glLineWidth(1); //ketebalan garis
        glPointSize(0); //besar kecil vertex

        //wajib
        //GL_LINES, GL_LINE_STRIP, GL_LINE_LOOP, GL_TRIANGLES, GL_TRIANGLES_FAN, GL_POINT -> YG SERING DIPAKAI
        glDrawArrays(GL_TRIANGLES,0,vertices.size());
    }
}
