package aprivate.mo.tide.ui.explore;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Classify;
import aprivate.mo.tide.ui.explore.classify.ClassifyFragment;
import aprivate.mo.tide.adapter.ExploreClassifyAdapter;
import privat.mo.tidelib.base.BaseFragment;
import privat.mo.tidelib.listener.OnItemClickListener;

/**
 * Created by Mo on 2020/1/27
 */

public class ExploreFragment extends BaseFragment<IExploreFragmentView, ExploreFragmentPresenter>
        implements IExploreFragmentView {

    private RecyclerView rvClassify;
    private ExploreClassifyAdapter exploreClassifyAdapter;
    private RecyclerView.LayoutManager exploreClassifyLayoutManager;




    @Override
    protected void initData() {
        getPresenter().getClassifyList();
    }

    @Override
    protected void initView(View view) {
        rvClassify = (RecyclerView) view.findViewById(R.id.rv_explore_classify);
    }

    /**
     * "分类" 列表
     *
     * @param classifies
     */
    @Override
    public void initClassifyList(final List<Classify> classifies) {
        exploreClassifyAdapter = new ExploreClassifyAdapter(getContext(), classifies);
        exploreClassifyAdapter.setOnSelectClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder viewHolder) {
                //获取点击的Item的Classify实体
                ClassifyFragment classifyFragment = ClassifyFragment.newInstance(classifies.get(position));
                start(classifyFragment);
            }

            @Override
            public void onItemLongClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {

            }
        });


        exploreClassifyLayoutManager = new GridLayoutManager(getContext()
                , 2, LinearLayoutManager.VERTICAL, false);


        rvClassify.setAdapter(exploreClassifyAdapter);
        rvClassify.setLayoutManager(exploreClassifyLayoutManager);
    }




    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_explore;
    }

    @Override
    protected ExploreFragmentPresenter createPresenter() {
        return new ExploreFragmentPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String tip) {

    }

    public static ExploreFragment newInstance() {
        return new ExploreFragment();
    }
}
