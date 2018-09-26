package warrior.himanshu.chainreaction;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GamePage extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mCoordinates;
    private Canvas mCanvas;
    private Bitmap mBitmap;
    private Paint linePaint = new Paint(), bgPaint = new Paint();
    private int getX, getY, vWidth, vHeight, lastX, lastY, offset, idxX, idxY;
    private int nColumns, nRows;
    private float leftShift, downShift;
    private boolean k;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        mImageView = findViewById(R.id.myImageView);
        getX = (int)mImageView.getX();
        getY = (int)mImageView.getY();
        k = true;
        nColumns = 6;
        nRows = 8;
        offset = 60;
        linePaint.setColor(ResourcesCompat.getColor(getResources(),R.color.line,null));
        bgPaint.setColor(ResourcesCompat.getColor(getResources(),R.color.bgcolor,null));
        mCoordinates = findViewById(R.id.coordinates);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                init(mImageView);
            }
        },1);

        mImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                lastX = (int)event.getX()-getX;
                lastY = (int)event.getY()-getY;
                idxX = (int)Math.floor((lastX-offset)/leftShift);
                idxY = (int)Math.floor((lastY-offset)/downShift);
                if(idxX >= 0 && idxX < nColumns && idxY >= 0 && idxY < nRows) {
                    mCoordinates.setText(idxX+ "," +idxY);
                }
                return false;
            }
        });
    }

    private void init(View v){
        vWidth = v.getWidth();
        vHeight = v.getHeight();
        leftShift = vWidth-2*offset;
        downShift = vHeight-2*offset;
        leftShift = leftShift/nColumns;
        downShift = downShift/nRows;
        mBitmap = Bitmap.createBitmap(vWidth,vHeight,Bitmap.Config.ARGB_4444);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(bgPaint.getColor());
        for(int i=0; i<=nColumns; i++){
            mCanvas.drawLine(offset+i*leftShift,offset,offset+i*leftShift,vHeight-offset,linePaint);
        }
        for(int i=0; i<=nRows; i++){
            mCanvas.drawLine(offset,offset+i*downShift,vWidth-offset,offset+i*downShift,linePaint);
        }
    }

}
