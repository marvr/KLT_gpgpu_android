package hemanth.kltgpgpuandroid;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Message;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hemanth on 8/29/16.
 */
public class MyGLRenderer implements GLSurfaceView.Renderer {
    private native void drawFrameNative();
    private native void loadResourcesNative(int viewPortXOffset, int viewPortYOffset, int viewPortWidth, int viewPortHeight, boolean runAlgoOnCpu);
    private native boolean setupGLES3Native();

    private Context mctx;
    //private int screenWidth, screenHeight;

    public MyGLRenderer(Context ctx){
        mctx = ctx;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        //not using opengl3+ even if its available
        boolean isGL3InitSuccess = setupGLES3Native();
        if(isGL3InitSuccess){
            AppHelperFuncs.myLOGD("OpenGL3.0 context has got created!...");
        }
        else{
            AppHelperFuncs.myLOGD("OpenGL3.0 context creation failed!...");
        }

//        loadResourcesNative(glViewPortOffsetX, glViewPortOffsetY, glViewPortWidth, glViewPortHeight,runAlgoOnCpu);
    }

    public void onDrawFrame(GL10 unused) {
//        drawFrameNative();
    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {

    }
}