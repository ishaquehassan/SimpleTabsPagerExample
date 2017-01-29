package sample.tabs.tabssampleproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents(){
        tabs = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        ArrayList<BaseFragment> pages = new ArrayList<>();

        TabPage page1 = new TabPage();
        page1.setTitle("TAB 1");
        pages.add(page1);

        TabPage page2 = new TabPage();
        page2.setTitle("TAB 2");
        pages.add(page2);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),pages);

        pager.setAdapter(pagerAdapter);
        pager.setOffscreenPageLimit(pages.size());
        tabs.setupWithViewPager(pager);
    }

    public static class TabPage extends BaseFragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            setFragmentView(inflater.inflate(R.layout.simple_page,container,false));
            TextView tv1 = (TextView) findViewById(R.id.pageText);
            tv1.setText(getTitle());
            return getFragmentView();
        }
    }
}
