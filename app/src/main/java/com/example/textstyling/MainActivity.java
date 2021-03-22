package com.example.textstyling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.Display;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   List<Model> list;
   StylingAdapter adapter;
   RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        recyclerView=findViewById(R.id.rv);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter=new StylingAdapter(getApplicationContext(),list);
        recyclerView.setAdapter(adapter);
        updateList();

    }
    void updateList()
    {
        Model model=new Model(getSpannableString(getResources().getString(R.string.demo_txt),new ForegroundColorSpan(Color.RED),13,22,SpannableString.SPAN_EXCLUSIVE_INCLUSIVE));
       list.add(model);
       model=new Model(getSpannableString(getResources().getString(R.string.demo_txt),new StyleSpan(Typeface.BOLD_ITALIC),13,22,SpannableString.SPAN_EXCLUSIVE_INCLUSIVE));
        list.add(model);
        model=new Model(getSpannableString(getResources().getString(R.string.demo_txt),new BackgroundColorSpan(Color.RED),13,22,SpannableString.SPAN_EXCLUSIVE_INCLUSIVE));
        list.add(model);
        model=new Model(getSpannableString(getResources().getString(R.string.demo_txt),new RelativeSizeSpan(2f),13,22,SpannableString.SPAN_EXCLUSIVE_INCLUSIVE));
        list.add(model);
        model=new Model(getSpannableString(getResources().getString(R.string.demo_txt),new UnderlineSpan(),13,22,SpannableString.SPAN_EXCLUSIVE_INCLUSIVE));
        list.add(model);
        model=new Model(getSpannableString(getResources().getString(R.string.demo_txt),new StrikethroughSpan(),13,22,SpannableString.SPAN_EXCLUSIVE_INCLUSIVE));
        list.add(model);
        adapter.notifyDataSetChanged();

    }
    SpannableString getSpannableString(String txt,Object span,int start,int end,int flag)
    {
        SpannableString string=new SpannableString(txt);
        string.setSpan(span,start,end,flag);
         return string;
    }

}