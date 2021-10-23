package org.techtown.capstone_final.fragment.Home.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.techtown.capstone_final.fragment.Home.viewpager.CompetitionFragment;
import org.techtown.capstone_final.fragment.Home.viewpager.FreeMeetingFragment;
import org.techtown.capstone_final.fragment.Home.viewpager.MentorFragment;
import org.techtown.capstone_final.fragment.Home.viewpager.StudyFragment;

public class FragementAdapter extends FragmentPagerAdapter {
    public FragementAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public FragementAdapter(@NonNull  FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0 : return  new MentorFragment();
            case 1 : return  new StudyFragment();
            case 2 : return  new CompetitionFragment();
            case 3 : return  new FreeMeetingFragment();
            default: return  new MentorFragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0){
            title = "멘토링";
        }
        if (position==1){
            title = "스터디";
        }
        if (position==2){
            title = "소모임";
        }
        if (position==3){
            title = "공모전";
        }
        return title;
    }
}