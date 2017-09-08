package com.hyperdev.androidme.activities;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;

import java.util.ArrayList;
import java.util.List;



public class BodyPartsFragment extends Fragment {

    private List<Integer> mPartsNumber;
    private int mListPosition;
    private static final String PARTS_LIST = "parts_list";
    private static final String PARTS_NUMBER = "parts_number";
    public BodyPartsFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null){
            mPartsNumber = savedInstanceState.getIntegerArrayList(PARTS_LIST);
            mListPosition = savedInstanceState.getInt(PARTS_NUMBER);
        }
        View rootView = inflater.inflate(R.layout.fragment_body_parts, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageFrag);
        if(mPartsNumber !=null){
            imageView.setImageResource(mPartsNumber.get(mListPosition));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListPosition < mPartsNumber.size()-1){
                        mListPosition++;
                    }else {
                        mListPosition = 0;
                    }
                    imageView.setImageResource(mPartsNumber.get(mListPosition));
                }
            });
        }
        return rootView;
    }

    public void setPartList(List<Integer> partList) {

        this.mPartsNumber = partList;
    }

    public void setListPosition(int mListPosition) {

        this.mListPosition = mListPosition;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(PARTS_LIST, (ArrayList<Integer>)mPartsNumber);
        outState.putInt(PARTS_NUMBER,mListPosition);
    }
}