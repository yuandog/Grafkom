package Engine;

import org.joml.Vector3f;

import java.util.List;

import static org.lwjgl.opengl.GL30.*;

public class Object2d extends ShaderProgram {

    List<Vector3f> vertices;
    int vao;
    int vbo;

    public Object2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
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

    public void drawSetup(){
        bind();

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
    }
   public void draw(){
        drawSetup();

        //Draw the vertices
       //optional
       glLineWidth(1); //ketebalan garis
       glPointSize(0); //besar kecil vertex

       //wajib
       //GL_LINES, GL_LINE_STRIP, GL_LINE_LOOP, GL_TRIANGLES, GL_TRIANGLES_FAN, GL_POINT -> YG SERING DIPAKAI
       glDrawArrays(GL_LINES,0,vertices.size());
   }
}
