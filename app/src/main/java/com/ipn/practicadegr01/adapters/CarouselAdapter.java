package com.ipn.practicadegr01.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ipn.practicadegr01.R;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.SlideViewHolder> {

    private final List<String> captions;
    private final int[] colores = {
            0xFFBFC7D1, 0xFFBFD8D1, 0xFFD9C7B8, 0xFFC9BFD8, 0xFFD8BFC9
    };

    public CarouselAdapter(List<String> captions) {
        this.captions = captions;
    }

    @NonNull
    @Override
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carousel_slide, parent, false);
        return new SlideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlideViewHolder holder, int position) {
        holder.caption.setText(captions.get(position));
        holder.background.setBackgroundColor(colores[position % colores.length]);
    }

    @Override
    public int getItemCount() {
        return captions.size();
    }

    static class SlideViewHolder extends RecyclerView.ViewHolder {
        View background;
        TextView caption;

        SlideViewHolder(@NonNull View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.slideBg);
            caption = itemView.findViewById(R.id.slideCaption);
        }
    }
}
