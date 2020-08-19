package com.app.abugaev.recyclerviewexample.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.app.abugaev.recyclerviewexample.R;
import com.app.abugaev.recyclerviewexample.model.JsonObject;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<JsonObject> objects;

    public RecyclerViewAdapter(List<JsonObject> objects) {
        this.objects = objects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_object, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.field.setText(objects.get(position).getField());
        holder.description.setText(objects.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView field;
        public TextView description;

        public ViewHolder(View v) {
            super(v);
            field = v.findViewById(R.id.field);
            description = v.findViewById(R.id.description);
        }
    }
}
