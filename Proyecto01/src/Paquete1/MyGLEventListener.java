package Paquete1;


import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class MyGLEventListener implements GLEventListener {

	@Override
	public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    }

	@Override
	public void dispose(GLAutoDrawable arg0) {
	
	}

	@Override
	public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0.4f, 0.7f, 0.98f, 1.0f);
    }

	@Override
	  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		   GL2 gl = drawable.getGL().getGL2();
	        gl.glMatrixMode(GL2.GL_PROJECTION);
	        gl.glLoadIdentity();
	        double aspectRatio = (double) height / width;
	        gl.glOrtho(-1, 1, -aspectRatio, aspectRatio, -1, 1);
	        gl.glMatrixMode(GL2.GL_MODELVIEW);
	        gl.glLoadIdentity();
    }

}
