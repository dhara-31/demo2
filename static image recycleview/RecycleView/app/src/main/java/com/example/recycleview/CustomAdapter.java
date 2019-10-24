package com.example.recycleview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    int i;

    ArrayList letter;
    ArrayList myimage;
    Context context;

    public CustomAdapter(Context context, ArrayList letter/*,ArrayList myimage*/) {
        this.context = context;
        this.letter = letter;
        //this.myimage = myimage;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        MyViewHolder mh = new MyViewHolder(v);

        return mh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {

        holder.name.setText(letter.get(position).toString());

       holder.myphoto.setImageDrawable(context.getResources().getDrawable(R.drawable.d));

//        holder.myphoto.setImageResource(myimage.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,letter.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return letter.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView myphoto;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            myphoto = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

}
