package com.hua.feature.player.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.hua.R;
import com.hua.feature.player.model.AudioDecorator;
import com.hua.feature.player.model.PlayList;


/**
 * Created by Administrator on 2017/1/22.
 */
public class MusicAdapter extends RecyclerView.Adapter {

    private final View.OnClickListener onClickListener;
    private PlayList playList;
    private List<AudioDecorator> songs;

    public MusicAdapter(View.OnClickListener onClickListener, PlayList playList) {
        this.onClickListener = onClickListener;
        this.playList = playList;
        this.songs = playList.getSongs();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_music, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        AudioDecorator song = songs.get(position);
        viewHolder.tvName.setText(position + "." + song.getAudio().getAudioName());
        viewHolder.itemView.setTag(position);
        viewHolder.itemView.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{

        View itemView;
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }


}
