package warrior.himanshu.chainreaction;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    private int getX, getY, vWidth, vHeight, lastX, lastY;
    private boolean k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        mImageView = findViewById(R.id.myImageView);
        getX = (int)mImageView.getX();
        getY = (int)mImageView.getY();
        k = true;
        linePaint.setColor(ResourcesCompat.getColor(getResources(),R.color.line,null));
        bgPaint.setColor(ResourcesCompat.getColor(getResources(),R.color.bgcolor,null));
        mCoordinates = findViewById(R.id.coordinates);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k){
                    init(v);
                    k = false;
                    Toast.makeText(getApplicationContext(),"Hey",Toast.LENGTH_SHORT).show();
                }
            }
        });
        mImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                lastX = (int)event.getX()-getX;
                lastY = (int)event.getY()-getY;
                mCoordinates.setText(lastX+","+lastY);
                return false;
            }
        });
    }

    private void init(View v){
        int vWidth = v.getWidth();
        int vHeight = v.getHeight();
        mBitmap = Bitmap.createBitmap(vWidth,vHeight,Bitmap.Config.ARGB_4444);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(bgPaint.getColor());

    }
}
