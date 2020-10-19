package com.example.hexiaoxiangtest01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LessonAdapter extends ArrayAdapter<Lesson> {

    private int resourceId;

    //重写父类构造器
    public LessonAdapter(@NonNull Context context, int resource, @NonNull List<Lesson> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Lesson lesson = getItem(position);  //获取当前项lesson实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        ImageView lessonImage = (ImageView) view.findViewById(R.id.lessonImage);
        TextView lessonName = (TextView) view.findViewById(R.id.lessonName);
//        TextView lessonIntroduction = (TextView) view.findViewById(R.id.lessonIntroduction) ;
        lessonImage.setImageResource(lesson.getImageId());
        lessonName.setText(lesson.getName());
        lessonName.append("\n" + lesson.getIntroduction());
//        lessonIntroduction.setText(lesson.getIntroduction());
//        lessonIntroduction.append("seeme");
        return view;
    }
}
