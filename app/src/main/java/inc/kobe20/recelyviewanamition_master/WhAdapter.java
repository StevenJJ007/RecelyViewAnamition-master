package inc.kobe20.recelyviewanamition_master;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by shijj on 2016/5/13.
 */
public class WhAdapter extends RecyclerView.Adapter<WhAdapter.MyHolder> implements ItemThouchHelperAdapterCallback {

    private final onDragStartListener startdraglistener;
    private List<String> mDatas;
    private LayoutInflater mInflater;

    public WhAdapter(Activity context, List<String> datas) {
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
        this.startdraglistener = (onDragStartListener) context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder = new MyHolder(mInflater.inflate(R.layout.item_home, parent, false));
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
        holder.iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    startdraglistener.onStartDrag(holder);
                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 两个接口的回调方法来执行移动和删除之后的操作
     *
     * @param fromPosition
     * @param toPosition
     * @return
     */
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //数据发生改变  两个数据交换位置
        Collections.swap(mDatas, fromPosition, toPosition);
        //刷新数据
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemSwiped(int adapterPosition) {
        //删除集合positon中的数据
        mDatas.remove(adapterPosition);
        //刷新adapter
        notifyItemRemoved(adapterPosition);
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView iv;

        public MyHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
            iv = (ImageView) view.findViewById(R.id.iv);

        }
    }

}
