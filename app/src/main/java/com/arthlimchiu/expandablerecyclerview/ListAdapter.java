package com.arthlimchiu.expandablerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shang on 9/8/2015.
 */
public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int HEADER = 0;
    public static final int CHILD = 1;

    private List<Item> data;

    public ListAdapter(List<Item> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        switch (type) {
            case HEADER:
                View header = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
                return new HeaderViewHolder(header);
            case CHILD:
                View child = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_child, viewGroup, false);
                return new ChildViewHolder(child);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (data.get(position).getType()) {
            case HEADER:
                final Header header = (Header) data.get(position);

                final HeaderViewHolder holder = ((HeaderViewHolder) viewHolder);
                holder.mText.setText(header.getText());
                holder.mToggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = data.indexOf(header);

                        //Log.d("ListAdapter", "index: " + pos);

                        if (header.isExpanded()) {

                            //Log.d("ListAdapter", "Removed positionStart: " + pos + 1 + " itemCount: " + header.getChildren().size());

                            data.removeAll(header.getChildren());
                            notifyItemRangeRemoved(pos + 1, header.getChildren().size());

                            header.setIsExpanded(false);
                            holder.mToggle.setImageResource(R.drawable.ic_expand_more_black_24dp);
                        } else {

                            int index = pos + 1;

                            for (Child i : header.getChildren()) {
                                data.add(index, i);
                                index++;
                            }

                            //Log.d("ListAdapter", "Inserted positionStart: " + pos + 1 + " itemCount: " + header.getChildren().size());

                            notifyItemRangeInserted(pos + 1, header.getChildren().size());
                            header.setIsExpanded(true);
                            holder.mToggle.setImageResource(R.drawable.ic_expand_less_black_24dp);
                        }
                    }
                });
                break;
            case CHILD:
                ((ChildViewHolder) viewHolder).mText.setText(data.get(position).getText());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public TextView mText;
        public ImageView mToggle;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.list_header);
            mToggle = (ImageView) itemView.findViewById(R.id.expand_toggle);
        }
    }

    private static class ChildViewHolder extends RecyclerView.ViewHolder {

        public TextView mText;

        public ChildViewHolder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.child_text);
        }
    }
}
