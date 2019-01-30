package com.example.study4_listdetails;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<DbHelper.Record> results;
    private Activity activity;

    public RecyclerAdapter(Activity activity) {
        DbHelper dbHelper = new DbHelper();
        this.results = dbHelper.SimpleModels();
        this.activity = activity;
    }

    //Создание новых View и ViewHolder элемента списка, которые впоследствии могут переиспользоваться.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    //Заполнение виджетов View данными из элемента списка с номером i
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        DbHelper.Record record = results.get(i);
        viewHolder.icon.setImageResource(record.iconID);
        viewHolder.title.setText(record.model);
        viewHolder.desc.setText(record.cost);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    //Реализация класса ViewHolder, хранящего ссылки на виджеты.
    class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        private ImageView icon;
        private TextView title;
        private TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.imageView1);
            icon.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.textView1);
            title.setOnClickListener(this);
            desc = (TextView) itemView.findViewById(R.id.textView2);
            desc.setOnClickListener(this);
        }

        //Обработчик нажатия на вьюхи в строке
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, DetailsActivity.class);
            DbHelper.Record record = results.get(this.getAdapterPosition());
            intent.putExtra("imageID", record.imageID);
            intent.putExtra("model", record.model);
            intent.putExtra("engineVolume", record.engineVolume);
            intent.putExtra("enginePower", record.enginePower);
            intent.putExtra("cost", record.cost);
            intent.putExtra("descID", record.descID);
            activity.startActivity(intent);
        }

    }


}
