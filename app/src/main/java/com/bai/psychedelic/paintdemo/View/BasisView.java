package com.bai.psychedelic.paintdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class BasisView extends View {
    private Paint paint;
    public BasisView(Context context) {
        super(context);
        //在代码中直接new 一个Custom View实例的时候，会调用第一个构造函数
        init();

    }

    private void init(){
        if (paint==null){
            synchronized (BasisView.class){
                if (paint==null){
                    paint = new Paint();
                }
            }
        }
    }


    public BasisView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        //在xml中调用Custom View的时候回调用第二个构造函数
        //在xml布局文件中调用Custom View,并且Custom View标签中还有自定义属性时,这里调用的还是第二个构造函数.

    }

    public BasisView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //不会自动调用，如果有默认style时，在第二个构造函数中调用
    }

    public BasisView(Context context,  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        // 只有在API版本>21时才会用到
        // 不会自动调用，如果有默认style时，在第二个构造函数中调用
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //设置画笔的基本属性
        canvas.drawColor(0xffff00ff);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(300,100);
        path.lineTo(500,200);
        path.lineTo(600,400);
        RectF rectF = new RectF(100,10,200,100);
        path.arcTo(rectF,0,90);
        path.close();
        canvas.drawPath(path,paint);

//        paint.setStrokeWidth(5);
//        paint.setStrokeWidth(50);
//        paint.setStyle(Paint.Style.FILL);
//
//        canvas.drawLine(190,200,800,800,paint);
//        canvas.drawCircle(190,200,150,paint);
//        paint.setColor(Color.RED);
//        canvas.drawCircle(190,200,100,paint);
//        paint.setColor(Color.YELLOW);
//        canvas.drawCircle(190,200,50,paint);
        super.onDraw(canvas);
    }
}
