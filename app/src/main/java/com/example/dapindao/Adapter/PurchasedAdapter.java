package com.example.dapindao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dapindao.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.List;

public class PurchasedAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    public static final int VIEW_TYPE_ITEM = 1;
    public static final int VIEW_TYPE_EMPTY = 0;
    private Context context;
    //private List<CouponModel.DataBean> couponVoListBeans;
    public PurchasedAdapter(Context context){
        this.context = context;
        //this.couponVoListBeans = couponVoListBeans;
    }

    private OnitemClickListener onitemClickListener=null;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //在onCreateViewHolder方法中，我们要根据不同的ViewType来返回不同的ViewHolder
        if (viewType == VIEW_TYPE_EMPTY) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.empty_view_tab, viewGroup, false);
            return new RecyclerView.ViewHolder(view) {
            };
        }

        View baseView;
        baseView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.purchased_data, viewGroup, false);
        BodyViewHolder bodyViewHolder = new BodyViewHolder(baseView);
        baseView.setOnClickListener(this);
        return bodyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof BodyViewHolder){

           /* if(couponVoListBeans.get(i).getCoupon_type() == 0){
                ((BodyViewHolder) viewHolder).type.setText("满减券");
                ((BodyViewHolder) viewHolder).Couponamount_tv.setText("¥"+couponVoListBeans.get(i).getType_money());
            }
            if(couponVoListBeans.get(i).getCoupon_type() == 1){
                ((BodyViewHolder) viewHolder).type.setText("折扣券");
                ((BodyViewHolder) viewHolder).Couponamount_tv.setText("¥"+couponVoListBeans.get(i).getDiscount());
            }
            ((BodyViewHolder) viewHolder).PreferentialPremises_tv.setText(couponVoListBeans.get(i).getName());
            ((BodyViewHolder) viewHolder).Use_btn.setVisibility(View.GONE);
            ((BodyViewHolder) viewHolder).Termvalidity_tv.setText(Utils.stampToDate1(couponVoListBeans.get(i).getUse_start_date())+"-"+Utils.stampToDate1(couponVoListBeans.get(i).getUse_end_date()));*/


        }
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
     /*   if (couponVoListBeans.size() == 0) {
            return 1;
        }
        return couponVoListBeans.size();*/
        return 20;
    }

    /**
     *
     * 复用getItemViewType方法，根据位置返回相应的ViewType
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        //如果是0，就是头，否则则是其他的item

     /*   if (couponVoListBeans.size() == 0) {
            return VIEW_TYPE_EMPTY;
        }
        //如果有数据，则使用ITEM的布局
        return VIEW_TYPE_ITEM;*/

        return VIEW_TYPE_ITEM;
    }

    @Override
    public void onClick(View view) {
        if(onitemClickListener!=null){
            onitemClickListener.onItemClick(view,(int)view.getTag());
        }


    }

    public void setOnitemClickListener(OnitemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    public static interface OnitemClickListener{
        void onItemClick(View view, int position);
    }

    /**
     * 给GridView中的条目用的ViewHolder，里面只有一个TextView
     */
    public class BodyViewHolder extends RecyclerView.ViewHolder {

        private SwipeMenuLayout swipeMenuLayout;


        public BodyViewHolder(View itemView) {
            super(itemView);
            swipeMenuLayout = (SwipeMenuLayout)itemView.findViewById(R.id.swipeMenuLayout);
        }

    }
}
