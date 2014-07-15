
package com.example.graypic;





import org.join.image.util.JoinImage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private Button bt;
    JoinImage ji;
    ImageView iv;
    ImageView iv1;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=new Button(getBaseContext());
        bt=(Button)findViewById(R.id.button1);
        ji=new JoinImage();
        iv=new ImageView(getBaseContext());
        iv=(ImageView)findViewById(R.id.imageView1);

       iv.setBackgroundResource(R.drawable.test);

        iv1=new ImageView(getBaseContext());
        iv1=(ImageView)findViewById(R.id.imageView2);
        Resources res=getResources();
        Drawable drawable = res.getDrawable(R.drawable.test);
        //实际上这是一个BitmapDrawable对象
        BitmapDrawable bitmapDrawable=(BitmapDrawable)drawable;
        //可以在调用getBitmap方法，得到这个位图
        bitmap=bitmapDrawable.getBitmap();
        bt.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                iv.setImageBitmap(ji.imgToGray(convertViewToBitmap(iv)));

            }
        });
    }


    public static Bitmap convertViewToBitmap(View view){
          view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
          view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
          view.buildDrawingCache();
          Bitmap bitmap = view.getDrawingCache();

         return bitmap;
  }


}
