package com.jsn.mylibrary;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;


public class ResFragment extends Fragment {

    private Intent intent;

    int requestCode;

    public void init(Intent intent,int code,ResultCallback callback){
        this.intent=intent;
        this.requestCode=code;
        this.resultCallback=callback;
    }

    ResultCallback resultCallback;

    public interface ResultCallback{

        void onActivityResult(int resultCode,@Nullable Intent data);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        startActivityForResult(intent,requestCode);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        resultCallback.onActivityResult(resultCode, data);
        try {
            getActivity().getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        intent=null;
        resultCallback=null;
    }

    //it may throw
    public static void  startActivityForRes(Activity activity,
                                            Intent intent,
                                            int requestCode,
                                            ResultCallback callback){
        ResFragment fragment=new ResFragment();
        fragment.init(intent,requestCode,callback);
        activity.getFragmentManager().beginTransaction().add(fragment,ResFragment.class.getSimpleName()).commit();

    }



}
