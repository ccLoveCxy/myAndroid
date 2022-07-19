package com.example.cxyccapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    public static final int DEFAULT_LINE = 3;

    private int mMaxLines;

    private List<String> mData = new ArrayList<>();

    public FlowLayout(Context context) {
        this(context,null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
        mMaxLines = a.getInt(R.styleable.FlowLayout_maxline,DEFAULT_LINE);
        a.recycle();

    }
    public void setTextList(List<String> data){
        this.mData.clear();
        this.mData.addAll(data);
        //根据数据创建子View,并且添加进来
        setUpChildren();

    }
    public void setUpChildren(){
        //先清空原有的内容
        removeAllViews();
        //添加子View进来
        for (String datum : mData){
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_text01,this,false);
            textView.setText(datum);
            //TODO:设置TextView的相关属性：边距，颜色，之类。
            addView(textView);
        }


    }
    private List<List<View>> mLines = new ArrayList<>();

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int parentWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        int parenthHeightSize = MeasureSpec.getSize(heightMeasureSpec);
        int childCount = getChildCount();
        if (childCount == 0){
            return;
        }
        //先清空
        mLines.clear();
        //添加默认行
        List<View> line = new ArrayList<>();
        mLines.add(line);
        int childWidthSpec = MeasureSpec.makeMeasureSpec(parentWidthSize, MeasureSpec.AT_MOST);
        int childHeightSpec = MeasureSpec.makeMeasureSpec(parenthHeightSize, MeasureSpec.AT_MOST);
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != VISIBLE){
                continue;
            }
            //测量孩子
            measureChild(child,childWidthSpec,childHeightSpec);
            if (line.size() == 0){
                //可以添加
                line.add(child);
            } else {
                //判断是否可以添加到当前行
                boolean canBeAdd = checkChildCanBeAdd(line, child,parentWidthSize);
                if (canBeAdd){
                    line.add(child);
                } else {
                    line = new ArrayList<>();
                    mLines.add(line);
                    line.add(child);

                }

            }
        }
        //根据尺寸计算行
        int height = getChildAt(0).getMeasuredHeight();
        int parentHeightSize = height * mLines.size();
        setMeasuredDimension(parentWidthSize,parentHeightSize);

    }

    private boolean checkChildCanBeAdd(List<View> line, View child,int parentWidthSize) {
        int measuredWidth = child.getMeasuredWidth();
        int totalWidth = 0;
        for (View view : line) {
            totalWidth += view.getMeasuredWidth();
        }
        totalWidth += measuredWidth;
        //如果超出限制宽度，则不可以添加
        //否则可以添加

        return (totalWidth <= parentWidthSize);

    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int currentLeft = 0;
        int currentTop = 0;
        int currentHeight = getChildAt(0).getMeasuredHeight();
        int currentRight = 0;
        int currentBottom = 0;
        for (List<View> line : mLines) {
            //布局每一行
            for (View view : line) {
                int width = view.getMeasuredWidth();
                int height = view.getMeasuredHeight();
                currentRight += width;
                currentBottom = height;
                view.layout(currentLeft,currentTop,currentRight,currentBottom);
                currentLeft = currentRight;
            }
            currentLeft = 0;
            currentTop += currentHeight;
            currentRight = 0;
            currentBottom += currentHeight;
        }

    }

}
