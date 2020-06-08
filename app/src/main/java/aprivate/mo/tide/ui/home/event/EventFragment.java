package aprivate.mo.tide.ui.home.event;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.utils.TideMessage;
import aprivate.mo.tide.widget.TideTitleBar;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/6/7
 *
 * 活动详情页
 */

public class EventFragment extends BaseFragment<IEventFragmentView, EventFragmentPresenter>
        implements IEventFragmentView {

    /**
     * 获取索引数据初始化
     */
    private static final String ARG_ITEM = "arg_item";
    private Event mEvent;

    private TideTitleBar titleBar;
    private ImageView ivCover;
    private TextView tvTitle;
    private TextView tvSponsor;
    private TextView tvTime;
    private TextView tvAddress;
    private TextView tvPopulation;
    private TextView tvFares;
    private TextView tvIntro;
    private FloatingActionButton fabRegister;


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_event;
    }

    @Override
    protected EventFragmentPresenter createPresenter() {
        return new EventFragmentPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        // 获取索引数据初始化
        if (getArguments().getParcelable(ARG_ITEM) == null) {
            pop();
        }
        mEvent = getArguments().getParcelable(ARG_ITEM);

        titleBar = (TideTitleBar) view.findViewById(R.id.ttb_event);
        titleBar.setTitle("活动详情");
        titleBar.setBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });

        ivCover = (ImageView) view.findViewById(R.id.iv_event_cover);
        Glide.with(getContext())
                .load(mEvent.getCover())
                .into(ivCover);
        tvTitle = (TextView) view.findViewById(R.id.tv_event_title);
        tvTitle.setText(mEvent.getTitle() + "  |  " + mEvent.getSubTitle());
        tvSponsor = (TextView) view.findViewById(R.id.tv_event_sponsor);
        tvSponsor.setText(mEvent.getSponsor());
        tvTime = (TextView) view.findViewById(R.id.tv_event_time);
        tvTime.setText(mEvent.getDate() + " —— " + mEvent.getTime());
        tvAddress = (TextView) view.findViewById(R.id.tv_event_address);
        tvAddress.setText(mEvent.getAddress());
        tvPopulation = (TextView) view.findViewById(R.id.tv_event_population);
        tvPopulation.setText(mEvent.getRegisterPopulation() + " / " + mEvent.getSupposedPopulation());
        tvFares = (TextView) view.findViewById(R.id.tv_event_fares);
        tvFares.setText(mEvent.getFares() + " 元 / 人");
        tvIntro = (TextView) view.findViewById(R.id.tv_event_intro);
        tvIntro.setText(mEvent.getIntro());
        fabRegister = (FloatingActionButton) view.findViewById(R.id.fab_event_register);
        fabRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TideMessage.showMessage("报名成功");
            }
        });


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

    public static EventFragment newInstance(Event event) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_ITEM, event);
        EventFragment eventFragment = new EventFragment();
        eventFragment.setArguments(args);
        return eventFragment;
    }
}
