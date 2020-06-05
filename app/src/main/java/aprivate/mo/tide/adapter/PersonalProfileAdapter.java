package aprivate.mo.tide.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aprivate.mo.tide.R;
import aprivate.mo.tide.entity.ProfileItem;

/**
 * Created by Mo on 2020/6/5
 * <p>
 * 个人中心页个人资料
 */

public class PersonalProfileAdapter extends
        RecyclerView.Adapter<PersonalProfileAdapter.PersonalProfileViewHolder> {

    private List<ProfileItem> profileItems;

    /**
     * 构造rv
     *
     * @param profileItems
     */
    public PersonalProfileAdapter(List<ProfileItem> profileItems) {
        this.profileItems = profileItems;
    }

    @NonNull
    @Override
    public PersonalProfileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_personal_profile, viewGroup, false);
        return new PersonalProfileViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalProfileViewHolder viewHolder, int i) {
        viewHolder.tvTitle.setText(profileItems.get(i).getTitle());
        viewHolder.tvContent.setText(profileItems.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return profileItems == null ? 0 : profileItems.size();
    }

    /**
     * 自定义ViewHolder
     */
    static class PersonalProfileViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvContent;

        public PersonalProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_personal_profile_item_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_personal_profile_item_content);
        }
    }
}
