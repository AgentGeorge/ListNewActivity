package com.example.study4_listdetails.UI.Main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.study4_listdetails.Core.Car;
import com.example.study4_listdetails.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Car> cars;
    private ItemClickListener mClickListener;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public interface ItemClickListener {
        void onItemClick(int ID);
    }

    public void setCars(List<Car> cars){
        this.cars = cars;
        this.notifyDataSetChanged();
    }

    //Создание новых View и ViewHolder элемента списка, которые впоследствии могут переиспользоваться.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    //Заполнение виджетов View данными из элемента списка с номером i
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Car car = cars.get(i);
        viewHolder.icon.setImageResource(car.iconID);
        viewHolder.title.setText(car.model);
        viewHolder.desc.setText(car.cost);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    //Реализация класса ViewHolder, хранящего ссылки на виджеты.
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView icon;
        private TextView title;
        private TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            icon = (ImageView) itemView.findViewById(R.id.imageView1);
            title = (TextView) itemView.findViewById(R.id.textView1);
            desc = (TextView) itemView.findViewById(R.id.textView2);
        }

        //Обработчик нажатия на вьюхи в строке
        @Override
        public void onClick(View itemView) {
            if (mClickListener != null) {
                mClickListener.onItemClick(cars.get(getAdapterPosition()).ID);
            }
        }

    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

}
