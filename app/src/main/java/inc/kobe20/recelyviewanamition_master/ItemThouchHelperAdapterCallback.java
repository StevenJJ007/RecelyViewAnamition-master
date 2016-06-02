package inc.kobe20.recelyviewanamition_master;

/**
 * Created by shijj on 2016/5/13.
 */
public interface ItemThouchHelperAdapterCallback {

    /**
     * 拖拽会掉
     *
     * @param fromPosition
     * @param toPosition
     * @return
     */
    boolean onItemMove(int fromPosition, int toPosition);

    /**
     * 侧滑删除
     *
     * @param adapterPosition
     */
    void onItemSwiped(int adapterPosition);
}
