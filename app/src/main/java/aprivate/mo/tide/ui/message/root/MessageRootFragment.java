package aprivate.mo.tide.ui.message.root;

import android.view.View;

import aprivate.mo.tide.R;
import aprivate.mo.tide.ui.message.MessageFragment;
import privat.mo.tidelib.base.BaseFragment;

/**
 * Created by Mo on 2020/3/17
 */

public class MessageRootFragment extends BaseFragment<IMessageRootFragmentView, MessageRootFragmentPresenter> implements IMessageRootFragmentView {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_message_root;
    }

    public static MessageRootFragment newInstance() {
        return new MessageRootFragment();
    }

    @Override
    protected MessageRootFragmentPresenter createPresenter() {
        return new MessageRootFragmentPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        loadRootFragment(R.id.fl_message_root_container, MessageFragment.newInstance());
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
