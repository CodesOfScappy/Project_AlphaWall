package com.scappycoding.demomessanger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.scappycoding.demomessanger.databinding.ActivityMainBinding;
import com.scappycoding.demomessanger.menu.CallsFragment;
import com.scappycoding.demomessanger.menu.ChatsFragment;
import com.scappycoding.demomessanger.menu.StatusFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Methode call
        setUpWithViewPager(binding.viewPager);
        // Implement tabLayout and ViewPager
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        // set Toolbar Custom Style
        setSupportActionBar(binding.toolbar);

        // Viewpager Adapter for FabIconButtons
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeFabIcon(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // This Manage the FragmentsView´s and the Title of them in TabsLayout
    private void setUpWithViewPager(ViewPager viewPager){
        MainActivity.SelectionPagerAdapter adapter = new SelectionPagerAdapter(getSupportFragmentManager());

        // adding the Fragments and the Title of it
        adapter.addFragment(new ChatsFragment(),"Chats");
        adapter.addFragment(new StatusFragment(),"Status");
        adapter.addFragment(new CallsFragment(),"Calls");

        // setting the adapter to handle fragments and binding them on tabLayout
        viewPager.setAdapter(adapter);


    }

    // Methode to handle Selected Fragments
    private static class SelectionPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SelectionPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        private void addFragment(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




    // This Implement a Option Menu
    //TODO: (OptionsMenu) coming soon implementation the another Option like: Settings,logout.usw
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        
        int id = item.getItemId();

        switch (id)
        {
            case R.id.menu_search :
                Toast.makeText(this, "Action Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_more:
                Toast.makeText(this, "Action More", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    // This Change the FabButton when switch the fragments
    private void changeFabIcon(final int index){
        binding.fabAction.hide();

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {

               switch (index){
                   case 0 : binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_chat));
                   break;

                   case 1 : binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_camera));
                   break;

                   case 2 : binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_call));
                   break;
               }
               binding.fabAction.show();

           }
       },400);


    }



}