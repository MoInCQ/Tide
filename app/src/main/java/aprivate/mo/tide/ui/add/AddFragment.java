package aprivate.mo.tide.ui.add;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import aprivate.mo.tide.R;
import aprivate.mo.tide.bean.Person;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/1/27
 */

public class AddFragment extends BaseFragment<IAddFragmentView, AddFragmentPresenter>
        implements IAddFragmentView {


    private AppBarLayout abl;
    private TextView tvTitle;
    private Button btnAdd;
    private static final int TOOLBAR_HEIGHT_OFFSET = -450;



    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        abl = (AppBarLayout) view.findViewById(R.id.abl_add);
        tvTitle = (TextView) view.findViewById(R.id.tv_add_title);
        btnAdd = (Button) view.findViewById(R.id.btn_add_form_submit);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2020/5/22 测试代码 
                Person p2 = new Person();
                p2.setName("lucky");
                p2.setAddress("北京海淀");
                p2.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                            Toast.makeText(getContext(), "添加数据成功，返回objectId为：" + objectId, Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(), "创建数据失败：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
