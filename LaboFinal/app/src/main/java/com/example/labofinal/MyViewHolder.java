package com.example.labofinal;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView titleView;
    private TextView descriptionView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        titleView = itemView.findViewById(R.id.title);
        descriptionView = itemView.findViewById(R.id.description);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // créer l'intent pour l'activité 2
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                // la position de l'item cliqué
                intent.putExtra("num", getAdapterPosition());
                view.getContext().startActivity(intent);

            }
        });
    }

    public void bind(MyItem item) {
        imageView.setImageResource(item.getImageId());
        titleView.setText(item.getTitle());
        descriptionView.setText(item.getDescription());
    }

}
