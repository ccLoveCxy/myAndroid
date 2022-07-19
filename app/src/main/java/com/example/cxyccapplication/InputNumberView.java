package com.example.cxyccapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InputNumberView extends RelativeLayout {
    private int mCurrentNumber = 0;
    private EditText valueEdt;
    private TextView minusBtn;
    private TextView plusBtn;
    private OnNumbetChangeListener onNumbetChangeListener = null;
    private int max;
    private int min;
    private int step;
    private boolean disable;

    public InputNumberView(Context context) {
        this(context,null);
    }

    public InputNumberView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public InputNumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取相关属性
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.InputNumberView);
        max = a.getInt(R.styleable.InputNumberView_max, 0);
        min = a.getInt(R.styleable.InputNumberView_min, 0);
        step = a.getInt(R.styleable.InputNumberView_step, 1);
        disable = a.getBoolean(R.styleable.InputNumberView_disable, false);
        initView(context);
        //以下是功能等价的   作用都是吧View添加到容器里
//    View view = LayoutInflater.from(context).inflate(R.layout.input_number_view, this);
//        addView(view);
        //处理事件
        setUpEvent();

    }


    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.input_number_view,this,true);
        minusBtn = findViewById(R.id.minus_btn);
        valueEdt = findViewById(R.id.value_edt);
        plusBtn = findViewById(R.id.plus_btn);
    }

    public int getNumber() {
        return mCurrentNumber;
    }

    public void setNumber(int value) {
        this.mCurrentNumber = value;
       this.updateText();
    }
    private void setUpEvent() {
        minusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //减法
                mCurrentNumber -= step;
                if (min != 0 &&mCurrentNumber <= min){
                    mCurrentNumber = min;
                }
                updateText();

            }
        });
        plusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //加法
                mCurrentNumber += step;
                if (max != 0 && mCurrentNumber >= max){
                    mCurrentNumber = max;
                }
                updateText();

            }
        });

    }
    //更新数据
    private void updateText(){
        Log.d("zzz","此时计数器的值是："+mCurrentNumber);
        valueEdt.setText(String.valueOf(mCurrentNumber));
        if (onNumbetChangeListener != null ){
            onNumbetChangeListener.OnNumberChange(this.mCurrentNumber);
        }

    }

    public void setOnNumbetChangeListener(OnNumbetChangeListener onNumbetChangeListener) {
        this.onNumbetChangeListener = onNumbetChangeListener;
    }

    public interface OnNumbetChangeListener{
        void OnNumberChange(int value);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
