package inc.kobe20.recelyviewanamition_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements onDragStartListener {
    private RecyclerView recycleView;
    private List<String> mDatas;
    private WhAdapter adapter;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));//定义样式

        adapter = new WhAdapter(this, mDatas);
        recycleView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new WhItemTouchCallback(adapter);//初始化ItemTouchHelper
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recycleView);//这个必须加上.让辅助类和recycleview关联上


    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    /**
     * 执行点击图标进行拖动的效果
     *
     * @param viewHolder
     */
    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }
}
