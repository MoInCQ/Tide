package aprivate.mo.tide.ui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.City;
import aprivate.mo.tide.ui.add.root.AddRootFragment;
import aprivate.mo.tide.ui.explore.root.ExploreRootFragment;
import aprivate.mo.tide.adapter.DrawerSelectCityAdapter;
import aprivate.mo.tide.ui.home.root.HomeRootFragment;
import aprivate.mo.tide.ui.message.root.MessageRootFragment;
import aprivate.mo.tide.ui.personalcenter.root.PersonalCenterRootFragment;
import aprivate.mo.tide.utils.TideMessage;
import privat.mo.tidelib.base.BaseActivity;
import privat.mo.tidelib.base.BaseFragment;


public class MainActivity extends BaseActivity<IMainActivityView, MainActivityPresenter>
    implements IMainActivityView,
    TabLayout.OnTabSelectedListener,
    View.OnClickListener {


  /**
   * 底部栏切换相关
   */
  private TabLayout tlMain;

  private List<BaseFragment> fragmentList = new ArrayList<>();
  private BaseFragment currentFragment;

  private static final int HOME_FRAGMENT_FLAG = 0;
  private static final int EXPLORE_FRAGMENT_FLAG = 1;
  private static final int ADD_FRAGMENT_FLAG = 2;
  private static final int MESSAGE_FRAGMENT_FLAG = 3;
  private static final int USER_FRAGMENT_FLAG = 4;

  private boolean isExploreFragmentLoaded = false;
  private boolean isAddFragmentLoaded = false;
  private boolean isMessageFragmentLoaded = false;
  private boolean isPersonalCenterFragmentLoaded = false;


  /**
   * 侧边栏相关
   */
  private RecyclerView rvCitySelectList;
  private DrawerSelectCityAdapter citySelectedAdapter;
  private RecyclerView.LayoutManager citySelectedLayoutManager;
  private TextView tvDrawerCitySelected;
  private DrawerLayout dlMain;
  private ImageView ivDrawerBack;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //底部栏
    tlMain = (TabLayout) findViewById(R.id.tl_main);
    tlMain.addOnTabSelectedListener(this);

    //侧边栏
    rvCitySelectList = (RecyclerView) findViewById(R.id.rv_drawer_main_select_city);
    tvDrawerCitySelected = (TextView) findViewById(R.id.tv_drawer_main_select_city);
    dlMain = (DrawerLayout) findViewById(R.id.dl_main);
    ivDrawerBack = (ImageView) findViewById(R.id.iv_drawer_main_back);
    ivDrawerBack.setOnClickListener(this);


    fragmentList.add(HomeRootFragment.newInstance());
    fragmentList.add(ExploreRootFragment.newInstance());
    fragmentList.add(AddRootFragment.newInstance());
    fragmentList.add(MessageRootFragment.newInstance());
    fragmentList.add(PersonalCenterRootFragment.newInstance());

    //加载根布局
    currentFragment = fragmentList.get(HOME_FRAGMENT_FLAG);
    loadMultipleRootFragment(R.id.fl_main, HOME_FRAGMENT_FLAG,
        fragmentList.get(HOME_FRAGMENT_FLAG));

    //侧边栏
    getPresenter().getCitySelectedList();
    getPresenter().getCitySelected();
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.iv_drawer_main_back:
        dlMain.closeDrawer(Gravity.LEFT);
        break;
    }
  }

  /**
   * 侧边栏相关
   *
   * @param cityList
   */
  @Override
  public void initCitySelectInfo(final List<City> cityList) {
    citySelectedLayoutManager = new GridLayoutManager(MainActivity.this, 3,
        OrientationHelper.VERTICAL, false);
    citySelectedAdapter = new DrawerSelectCityAdapter(this, cityList);
    citySelectedAdapter
        .setOnItemClickListener(new DrawerSelectCityAdapter.OnCitySelectedClickListener() {
          @Override
          public void onItemClick(View view, int position) {
            getPresenter().updateCitySelected(position);
          }

          @Override
          public void onItemLongClick(View view, int position) {
            Toast.makeText(MainActivity.this, "长按  " + cityList.get(position).getName(),
                Toast.LENGTH_SHORT).show();
          }
        });

    rvCitySelectList.setLayoutManager(citySelectedLayoutManager);
    rvCitySelectList.setAdapter(citySelectedAdapter);
  }

  @Override
  public void updateCitySelected(City city) {
    tvDrawerCitySelected.setText(city.getName() + " / " + city.getEnglishName());
  }

  /**
   * 初始化选中城市信息
   *
   * @param city
   */
  @Override
  public void initCitySelected(City city) {
    tvDrawerCitySelected.setText(city.getName() + " / " + city.getEnglishName());
  }


  /**
   * 底部栏切换相关
   *
   * @param tab
   */
  @Override
  public void onTabSelected(TabLayout.Tab tab) {

    //HomeFragment之外的界面实现懒加载
    switch (tab.getPosition()) {
      case EXPLORE_FRAGMENT_FLAG:
        if (!isExploreFragmentLoaded) {
          loadMultipleRootFragment(R.id.fl_main, EXPLORE_FRAGMENT_FLAG,
              fragmentList.get(EXPLORE_FRAGMENT_FLAG));
          isExploreFragmentLoaded = true;
        }
        break;
      case ADD_FRAGMENT_FLAG:
        if (!isAddFragmentLoaded) {
          loadMultipleRootFragment(R.id.fl_main, ADD_FRAGMENT_FLAG,
              fragmentList.get(ADD_FRAGMENT_FLAG));
          isAddFragmentLoaded = true;
        }
        break;
      case MESSAGE_FRAGMENT_FLAG:
        if (!isMessageFragmentLoaded) {
          loadMultipleRootFragment(R.id.fl_main, MESSAGE_FRAGMENT_FLAG,
              fragmentList.get(MESSAGE_FRAGMENT_FLAG));
          isMessageFragmentLoaded = true;
        }
        break;
      case USER_FRAGMENT_FLAG:
        if (!isPersonalCenterFragmentLoaded) {
          loadMultipleRootFragment(R.id.fl_main, USER_FRAGMENT_FLAG,
              fragmentList.get(USER_FRAGMENT_FLAG));
          isPersonalCenterFragmentLoaded = true;
        }
        break;
      default:
        break;
    }

    //切换
    showHideFragment(fragmentList.get(tab.getPosition()), currentFragment);
    currentFragment = fragmentList.get(tab.getPosition());


  }

  @Override
  public void onTabUnselected(TabLayout.Tab tab) {

  }

  @Override
  public void onTabReselected(TabLayout.Tab tab) {

  }

  @Override
  protected int getLayoutResId() {
    return R.layout.activity_main;
  }

  @Override
  protected MainActivityPresenter createPresenter() {
    return new MainActivityPresenter();
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
}
