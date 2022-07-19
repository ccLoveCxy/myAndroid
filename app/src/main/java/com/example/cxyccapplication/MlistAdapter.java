package com.example.cxyccapplication;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MlistAdapter extends RecyclerView.Adapter<MlistAdapter.MyViewHolder> {
    private Context context;
    private View inflate;
    private OnMyItemClickListener listener;

    public MlistAdapter(Context context) {
        this.context = context;
    }

    public void setListener(OnMyItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(context).inflate(R.layout.adapter_list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         if (listener != null){

//             holder.editText.setOnClickListener(new View.OnClickListener() {
//                 @Override
//                 public void onClick(View v) {
//                     String text = holder.editText.getText().toString();
//                     listener.myClick(text,v,position);
//                 }
//             });

             holder.editText.addTextChangedListener(new TextWatcher() {
                 @Override
                 public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                 }

                 @Override
                 public void onTextChanged(CharSequence s, int start, int before, int count) {

                 }

                 @Override
                 public void afterTextChanged(Editable s) {
                     String text = holder.editText.getText().toString();
                     listener.myClick(text,position);

                 }
             });
         }

    }

    @Override
    public int getItemCount() {
        return 17;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        EditText editText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.et_note);
        }
    }
    public interface OnMyItemClickListener{
        void myClick(String text,int position);
    }

}
