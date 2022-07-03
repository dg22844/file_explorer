package com.example.file_explorer;

import android.content.Context;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.text.Format;
import java.util.List;
import java.util.Locale;

public class FileAdapter extends RecyclerView.Adapter<FileViewHolder> {

    private Context context;
    private List<File> file;

    public FileAdapter(Context context, List<File> file) {
        this.context = context;
        this.file = file;
    }

    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FileViewHolder(LayoutInflater.from(context).inflate(R.layout.file_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {

        holder.tvName.setText(file.get(position).getName());
        holder.tvName.setSelected(true);
        int items = 0;
        if(file.get(position).isDirectory()) {
            File[] files = file.get(position).listFiles();
            for (File singleFile : files){
                if(!singleFile.isHidden()){
                    items += 1;
                }
            }
            holder.tvSize.setText(String.valueOf(items) + " Files");
        }
        else {
            holder.tvSize.setText(Formatter.formatShortFileSize(context, file.get(position).length()));
        }

        if(file.get(position).getName().toLowerCase().endsWith(".jpeg")){
            holder.imgFile.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".jeg")) {
            holder.imgFile.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".jpeg")) {
            holder.imgFile.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".png")) {
            holder.imgFile.setImageResource(R.drawable.ic_image);
        } else if (file.get(position).getName().toLowerCase().endsWith(".pdf")) {
            holder.imgFile.setImageResource(R.drawable.ic_pdf);
        }  else if (file.get(position).getName().toLowerCase().endsWith(".doc")) {
            holder.imgFile.setImageResource(R.drawable.ic_docs);
        }  else if (file.get(position).getName().toLowerCase().endsWith(".mp3")) {
            holder.imgFile.setImageResource(R.drawable.ic_music);
        }  else if (file.get(position).getName().toLowerCase().endsWith(".mp4")) {
            holder.imgFile.setImageResource(R.drawable.ic_music);
        }  else if (file.get(position).getName().toLowerCase().endsWith(".wav")) {
            holder.imgFile.setImageResource(R.drawable.ic_music);
        }  else if (file.get(position).getName().toLowerCase().endsWith(".apk")) {
            holder.imgFile.setImageResource(R.drawable.ic_android);
        } else {
            holder.imgFile.setImageResource(R.drawable.folder);
        }
    }

    @Override
    public int getItemCount() {
        return file.size();
    }
}