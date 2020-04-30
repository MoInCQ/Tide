package aprivate.mo.tide.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.Store;
import aprivate.mo.tide.adapter.HomeCityMapAdapter;
import aprivate.mo.tide.adapter.HomeRecommendAdapter;
import aprivate.mo.tide.adapter.HomeSelectedStoreAdpter;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/1/27
 *
 * 首页
 */

public class HomeFragment extends BaseFragment<IHomeFragmentView, HomeFragmentPresenter>
        implements IHomeFragmentView {

    /**
     * 推荐相关
     */
    private RecyclerView rvHomeRecommend;
    private HomeRecommendAdapter homeRecommendAdapter;
    private LinearLayoutManager homeRecommendLayoutManager;


    /**
     * 精选店铺相关
     */
    private RecyclerView rvHomeSelectedStore;
    private HomeSelectedStoreAdpter homeSelectedStoreAdpter;
    private LinearLayoutManager homeSelectedStoreLayoutManager;


    /**
     * 城市地图相关
     */
    private RecyclerView rvHomeCityMap;
    private HomeCityMapAdapter homeCityMapAdapter;
    private LinearLayoutManager homeCityMapLayoutManager;


    @Override
    protected void initData() {
        getPresenter().getHomeRecommendList();
        getPresenter().getHomeSelectedStoreList();
        getPresenter().getHomeCityMapList();
    }

    @Override
    protected void initView(View view) {

        //推荐相关
        rvHomeRecommend = (RecyclerView) view.findViewById(R.id.rv_home_recommend);

        //精选店铺相关
        rvHomeSelectedStore = (RecyclerView) view.findViewById(R.id.rv_home_selected_store);

        //城市地图相关
        rvHomeCityMap = (RecyclerView) view.findViewById(R.id.rv_home_city_map);
    }


    /**
     * 推荐相关
     *
     * @param homeRecommendList
     */
    @Override
    public void initHomeRecommendInfo(List<Event> homeRecommendList) {
        homeRecommendLayoutManager = new LinearLayoutManager(getContext());
        homeRecommendLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        homeRecommendAdapter = new HomeRecommendAdapter(getContext(), homeRecommendList);
        rvHomeRecommend.setLayoutManager(homeRecommendLayoutManager);
        rvHomeRecommend.setAdapter(homeRecommendAdapter);
    }


    /**
     * 精选店铺相关
     *
     * @param homeSelectedStoreList
     */
    @Override
    public void initHomeSelectedStoreInfo(List<Store> homeSelectedStoreList) {
        homeSelectedStoreLayoutManager = new LinearLayoutManager(getContext());
        homeSelectedStoreLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        homeSelectedStoreAdpter = new HomeSelectedStoreAdpter(getContext(), homeSelectedStoreList);
        rvHomeSelectedStore.setLayoutManager(homeSelectedStoreLayoutManager);
        rvHomeSelectedStore.setAdapter(homeSelectedStoreAdpter);
    }

    /**
     * 城市地图相关
     *
     * @param homeCityMapList
     */
    @Override
    public void initHomeCityMapInfo(List<Event> homeCityMapList) {
        homeCityMapLayoutManager = new LinearLayoutManager(getContext());
        homeCityMapLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homeCityMapAdapter = new HomeCityMapAdapter(getContext(), homeCityMapList);
        rvHomeCityMap.setLayoutManager(homeCityMapLayoutManager);
        rvHomeCityMap.setAdapter(homeCityMapAdapter);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomeFragmentPresenter createPresenter() {
        return new HomeFragmentPresenter();
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

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
