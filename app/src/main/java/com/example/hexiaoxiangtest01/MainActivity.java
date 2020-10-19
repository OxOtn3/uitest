package com.example.hexiaoxiangtest01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup mRg_main;
    private List<BaseFragment> mBaseFragment;
    private int position;
    private Fragment mContent;

    private List<Lesson> lessonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();

        setContentView(R.layout.activity_main);
        initLessons();
        LessonAdapter adapter = new LessonAdapter(MainActivity.this, R.layout.lesson_item, lessonList);
        ListView listView = findViewById(R.id.lessons);
        listView.setAdapter(adapter);
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中框架页面
        mRg_main.check(R.id.mine);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.mine://框架
                    position = 0;
                    break;
//                case R.id.rb_thirdparty://第三方
//                    position = 1;
//                    break;
//                case R.id.rb_custom://自定义
//                    position = 2;
//                    break;
//                case R.id.rb_other://其他
//                    position = 3;
//                    break;
//                default: //默认第一个(框架)
//                    position = 0;
//                    break;
            }

            //根据位置得到对应的Fragment
            BaseFragment to = getFragment();
            //替换到Fragment
            switchFragment(mContent,to);
        }
    }

    /**
     *
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to 马上要切换到的Fragment，一会要显示
     */
    private void switchFragment(Fragment from,Fragment to) {
        if(from != to){
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //开启事务
            //判断to有没有被添加
            if(!to.isAdded()){//to没有被添加
                //1.from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //2.添加to
                if(to != null){
//                    ft.add(R.id.fl_content,to).commit();
                }
            }else{ //to已经被添加
                //1.from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //2.显示to
                if(to != null){
                    ft.show(to).commit();
                }
            }
        }
    }

    /**
     * 根据位置得到对应的Fragment
     * @return
     */
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new CommonFrameFragment());//框架Fragment
//        mBaseFragment.add(new ThirdPartyFragment());//第三方Fragment
//        mBaseFragment.add(new CustomFragment());//自定义控件Fragment
//        mBaseFragment.add(new OtherFragment());//其他Fragment
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRg_main = findViewById(R.id.radioGroup);
    }



    private void initLessons(){
        for(int i = 0; i < 2; i++){
            Lesson chinese = new Lesson("Chinese", R.drawable.chinese, "语文教学，我们是专业的！");
            lessonList.add(chinese);
            Lesson math = new Lesson("Math", R.drawable.math, "数学教学，我们是专业的！");
            lessonList.add(math);
            Lesson english = new Lesson("English", R.drawable.english, "英语教学，我们是专业的！");
            lessonList.add(english);
            Lesson physics = new Lesson("Physics", R.drawable.physics, "物理教学，我们是专业的！");
            lessonList.add(physics);
            Lesson chemistry = new Lesson("Chemistry", R.drawable.chemistry, "化学教学，我们是专业的！");
            lessonList.add(chemistry);
            Lesson biology = new Lesson("Biology", R.drawable.biology, "生物教学，我们是专业的！");
            lessonList.add(biology);
            Lesson geography = new Lesson("Geography", R.drawable.geography, "地理教学，我们是专业的！");
            lessonList.add(geography);
            Lesson history = new Lesson("History", R.drawable.history, "历史教学，我们是专业的！");
            lessonList.add(history);
            Lesson pe = new Lesson("PE", R.drawable.pe, "体育教学，我们是专业的！");
            lessonList.add(pe);

        }


    }
}