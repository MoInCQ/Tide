package aprivate.mo.tide.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import aprivate.mo.tide.R;

/**
 * Created by Mo on 2020/6/6
 * <p>
 * 次级页面带有1dp高度的标题栏
 */

public class TideTitleBar extends RelativeLayout {

    private ImageView ivBack;
    private TextView tvTittle;
    private TextView tvSubTitle;

    public TideTitleBar(Context context) {
        this(context, null);
    }

    public TideTitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TideTitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.widget_tide_tittle_bar, this, true);
        ivBack = (ImageView) view.findViewById(R.id.iv_back);
        tvTittle = (TextView) view.findViewById(R.id.tv_title);
        tvSubTitle = (TextView) view.findViewById(R.id.tv_subtitle);
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tvTittle.setText(title);
        }
    }

    /**
     * 设置返回按钮事件
     * @param onClickListener
     */
    public void setBackClickListener(View.OnClickListener onClickListener) {
        ivBack.setOnClickListener(onClickListener);
    }

    /**
     * 设置副标题
     * @param subTitle
     */
    public void setSubTitle(String subTitle) {
        if (!TextUtils.isEmpty(subTitle)) {
            tvSubTitle.setText(subTitle);
        }
    }

    /**
     * 设置副标题点击事件
     * @param onClickListener
     */
    public void setSubTitleClickListener(OnClickListener onClickListener) {
        tvSubTitle.setOnClickListener(onClickListener);
    }

    /**
     * 设置副标题可见性（默认不可见）
     * @param visible
     */
    public void setSubTitleVisible(boolean visible) {
        if (visible) {
            tvSubTitle.setVisibility(VISIBLE);
        } else {
            tvSubTitle.setVisibility(GONE);
        }
    }
}
