package aprivate.mo.tide.ui.add;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import org.greenrobot.eventbus.Subscribe;

import java.util.concurrent.TimeUnit;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.Event;
import aprivate.mo.tide.entity.TideUser;
import aprivate.mo.tide.utils.TideMessage;
import io.reactivex.functions.Consumer;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/1/27
 */
public class AddFragment extends BaseFragment<IAddFragmentView, AddFragmentPresenter>
        implements IAddFragmentView {


    private EditText etTitle;
    private EditText etTime;
    private EditText etAddress;
    private EditText etSupposedPopulation;
    private EditText etTag;
    private EditText etFares;
    private EditText etIntro;

    private AppBarLayout abl;
    private TextView tvTitle;
    private Button btnAdd;
    private static final int TOOLBAR_HEIGHT_OFFSET = -450;

    private Event event;

    private TideUser mUser;



    @Override
    protected void initData() {
        event = new Event();
    }

    @Override
    protected void initView(View view) {
        abl = (AppBarLayout) view.findViewById(R.id.abl_add);
        tvTitle = (TextView) view.findViewById(R.id.tv_add_title);
        btnAdd = (Button) view.findViewById(R.id.btn_add_form_submit);
        etTitle = (EditText) view.findViewById(R.id.et_add_form_title);
        etTime = (EditText) view.findViewById(R.id.et_add_form_time);
        etAddress = (EditText) view.findViewById(R.id.et_add_form_address);
        etSupposedPopulation = (EditText) view.findViewById(R.id.et_add_form_population);
        etTag = (EditText) view.findViewById(R.id.et_add_form_tag);
        etFares = (EditText) view.findViewById(R.id.et_add_form_fee);
        etIntro = (EditText) view.findViewById(R.id.et_add_form_intro);

        RxView.clicks(btnAdd)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if (event == null) {
                            return;
                        }
                        event.setTitle(etTitle.getText().toString());
                        event.setTime(etTime.getText().toString());
                        event.setAddress(etAddress.getText().toString());
                        event.setSupposedPopulation(TextUtils.isEmpty(etSupposedPopulation.getText().toString())
                                ? 0 : Integer.parseInt(etSupposedPopulation.getText().toString()));
                        event.setTag(etTag.getText().toString());
                        event.setFares(TextUtils.isEmpty(etFares.getText().toString())
                                ? 0 : Integer.parseInt(etFares.getText().toString()));
                        event.setIntro(etIntro.getText().toString());


                        getPresenter().submitEvent(mUser, event);
                    }
                });

        abl.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i < TOOLBAR_HEIGHT_OFFSET) {
                    tvTitle.setTextColor(Color.BLACK);
                } else {
                    tvTitle.setTextColor(Color.WHITE);
                }
            }
        });


    }

    /**
     * 限制普通用户没有发布权限
     */
    @Override
    public void submitEventLimitAuthority() {
        TideMessage.showMessage("您没有发布活动权限，请向系统管理员申请商家身份");
    }

    @Subscribe(sticky = true)
    public void onCheckAddAuthority(TideUser user) {
        this.mUser = user;
    }

    /**
     * 提交活动成功或失败
     */
    @Override
    public void submitEventSuccess() {
        etTitle.setText("");
        etTime.setText("");
        etAddress.setText("");
        etSupposedPopulation.setText("");
        etTag.setText("");
        etFares.setText("");
        etIntro.setText("");
        TideMessage.showMessage("提交活动成功");
    }

    @Override
    public void submitEventFail() {
        TideMessage.showMessage("提交活动失败，请核对活动信息");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_add;
    }

    @Override
    protected AddFragmentPresenter createPresenter() {
        return new AddFragmentPresenter();
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

    public static AddFragment newInstance() {
        return new AddFragment();
    }
}
